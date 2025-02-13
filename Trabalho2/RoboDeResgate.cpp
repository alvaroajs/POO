#include "RoboDeResgate.hpp"
#include <queue>
#include <algorithm>

RoboDeResgate::RoboDeResgate(int x, int y, EstacaoEspacial& estacao) 
    : posicaoInicialX(x), posicaoInicialY(y), estacao(estacao), passos(0) {
    naoResgatados = estacao.getAstronautas();
}

RoboDeResgate::~RoboDeResgate() {}

void RoboDeResgate::imprimir() {
    cout << "Robo de resgate na posicao (" << posicaoInicialX << ", " << posicaoInicialY << ")" << endl;
    estacao.imprimirEstacao();
    cout << endl;
    cout << "Astronautas na estacao:" << endl;
    estacao.ImprimirAstro();
    buscarAstronautas();
}

bool RoboDeResgate::posicaoValida(int x, int y) {
    if (x < 0 || x >= estacao.getLinhas() || y < 0 || y >= estacao.getColunas())
        return false;
    return estacao.getMatriz()[x][y]->podeAcessar() && !proximoAoFogo(x, y);
}

bool RoboDeResgate::proximoAoFogo(int x, int y) {
    int linhas = estacao.getLinhas();
    int colunas = estacao.getColunas();
    auto matriz = estacao.getMatriz();

    if (x > 0 && matriz[x-1][y]->getTipo() == 'F') return true;
    if (x < linhas-1 && matriz[x+1][y]->getTipo() == 'F') return true;
    if (y > 0 && matriz[x][y-1]->getTipo() == 'F') return true;
    if (y < colunas-1 && matriz[x][y+1]->getTipo() == 'F') return true;

    return false;
}   

string RoboDeResgate::Resultados() {
    string aux = "Relatorio de Resgate:\n";
    aux += "-Numero de astronautas resgatados: " + to_string(resgatados.size()) + "\n";
    
    for (Astronauta a : resgatados) {
        aux += a.toString();
    }
    aux += "\nAstronautas não resgatados: " + to_string(naoResgatados.size()) + "\n";
    for (Astronauta a : naoResgatados) {
        aux += a.toString();
    }
    aux += "\nTempo total da operação de resgate: " + to_string(passos) + "\n\n";
    return aux;
}

void RoboDeResgate::buscarAstronautas() {
    int linhas = estacao.getLinhas();
    int colunas = estacao.getColunas();
    auto matriz = estacao.getMatriz();
    
    if (!posicaoValida(posicaoInicialX, posicaoInicialY)) {
        cout << "Posição inicial inválida!" << endl;
        return;
    }

    vector<vector<char>> mapaVisual(linhas, vector<char>(colunas));
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            mapaVisual[i][j] = matriz[i][j]->getTipo();
        }
    }

    pair<int, int> posicaoAtual = {posicaoInicialX, posicaoInicialY};
    passos = 0;

    // Movimentos possíveis: cima, baixo, esquerda, direita
    const int dx[] = {-1, 1, 0, 0};
    const int dy[] = {0, 0, -1, 1};

    bool voltandoParaBase = false;
    while (true) {
        vector<Astronauta> astronautasAtuais = naoResgatados;
        bool encontrouCaminho = false;

        if (voltandoParaBase) {
            if (posicaoAtual.first == posicaoInicialX && posicaoAtual.second == posicaoInicialY) {
                break;
            }
        } else if (naoResgatados.empty()) {
            voltandoParaBase = true;
            continue;
        }

        // BFS para encontrar próximo passo
        queue<pair<int, int>> fila;
        vector<vector<bool>> visitado(linhas, vector<bool>(colunas, false));
        vector<vector<pair<int, int>>> pai(linhas, vector<pair<int, int>>(colunas));
        
        fila.push(posicaoAtual);
        visitado[posicaoAtual.first][posicaoAtual.second] = true;
        
        pair<int, int> destino = voltandoParaBase ? make_pair(posicaoInicialX, posicaoInicialY) : posicaoAtual;
        while (!fila.empty() && !encontrouCaminho) {
            auto [x, y] = fila.front();
            fila.pop();

            // Se encontrou um alvo
            if (voltandoParaBase) {
                if (x == posicaoInicialX && y == posicaoInicialY) {
                    destino = {x, y};
                    encontrouCaminho = true;
                }
            } else {
                for (Astronauta a : astronautasAtuais) {
                    if (x == a.getX() && y == a.getY()) {
                        destino = {x, y};
                        encontrouCaminho = true;
                        break;
                    }
                }
            }

            if (encontrouCaminho) break;

            // Tenta todos os movimentos possíveis
            for (int i = 0; i < 4; i++) {
                int novoX = x + dx[i];
                int novoY = y + dy[i];
                
                if (posicaoValida(novoX, novoY) && !visitado[novoX][novoY]) {
                    visitado[novoX][novoY] = true;
                    pai[novoX][novoY] = {x, y};
                    fila.push({novoX, novoY});
                }
            }
        }

        if (!encontrouCaminho) {
            if (voltandoParaBase) {
                cout << "Não foi possível voltar para a base!" << endl;
            } else {
                cout << "Não foi possível alcançar mais astronautas!" << endl;
                // Se não conseguir alcançar astronautas, tenta voltar para base
                voltandoParaBase = true;
                continue;
            }
            break;
        }

        // Reconstrói o primeiro passo do caminho
        pair<int, int> proxPasso = destino;
        while (pai[proxPasso.first][proxPasso.second].first != posicaoAtual.first || 
               pai[proxPasso.first][proxPasso.second].second != posicaoAtual.second) {
            if (proxPasso == posicaoAtual) break;
            proxPasso = pai[proxPasso.first][proxPasso.second];
        }

        // Move o robô
        if (proxPasso != posicaoAtual) {
            mapaVisual[posicaoAtual.first][posicaoAtual.second] = '.';
            posicaoAtual = proxPasso;
            mapaVisual[posicaoAtual.first][posicaoAtual.second] = 'R';
            passos++;

            cout << "\nPasso " << passos << ":\n";
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    cout << mapaVisual[i][j] << " ";
                }
                cout << endl;
            }

            // Verifica se resgatou algum astronauta
            if (!voltandoParaBase) {
                for (auto it = naoResgatados.begin(); it != naoResgatados.end(); ) {
                    if (it->getX() == posicaoAtual.first && it->getY() == posicaoAtual.second) {
                        resgatados.push_back(*it);
                        it = naoResgatados.erase(it);
                        // Se era o último astronauta, inicia retorno à base
                        if (naoResgatados.empty()) {
                            voltandoParaBase = true;
                        }
                    } else {
                        ++it;
                    }
                }
            }
        } else {
            // Se não conseguiu mover, para o loop
            break;
        }
    }

    // Marca posição final
    mapaVisual[posicaoInicialX][posicaoInicialY] = 'S';

    cout << "\nEstado Final:\n";
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            cout << mapaVisual[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;

    //cout << Resultados();
}