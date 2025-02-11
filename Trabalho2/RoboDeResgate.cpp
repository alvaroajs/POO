#include "RoboDeResgate.hpp"
#include <queue>

#include "RoboDeResgate.hpp"

RoboDeResgate::RoboDeResgate(int x, int y, EstacaoEspacial& estacao) 
    : posicaoInicialX(x), posicaoInicialY(y), estacao(estacao) {
    
}
RoboDeResgate::~RoboDeResgate() {}

void RoboDeResgate::imprimir() {
    // Implementação do método imprimir
    cout << "Robo de resgate na posicao (" << posicaoInicialX << ", " << posicaoInicialY << ")" << endl;
    estacao.imprimirEstacao();
    cout <<endl;
    estacao.ImprimirAstro();


    cout<<"Dentro da estação pegando Matriz "<<endl;
    for(int i = 0; i < estacao.getLinhas(); i++){
        for(int j = 0; j < estacao.getColunas(); j++){
            cout << posicaoValida(i, j) << " ";
        }
            cout << endl;
    }
}

string RoboDeResgate::Resultados(){

    return "";
}

bool RoboDeResgate::proximoAoFogo(int x, int y){

    int linhas = estacao.getLinhas();
    int colunas = estacao.getColunas();
    auto matriz = estacao.getMatriz();

    if (x > 0 && matriz[x - 1][y]->getTipo() == 'F') return true; // cima
    else if (x < linhas - 1 && matriz[x + 1][y]->getTipo() == 'F') return true; // baixo
    else if (y > 0 && matriz[x][y - 1]->getTipo() == 'F') return true; // esquerda
    else if (y < colunas - 1 && matriz[x][y + 1]->getTipo() == 'F') return true; // direita

    return false;
    
}

void RoboDeResgate::buscarAstronautas() {
    cout << "Buscando astronautas no robo..." << endl;
    int passos = 0;
    int linhas = estacao.getLinhas();
    int colunas = estacao.getColunas();
    auto matriz = estacao.getMatriz();
    queue<pair<int, int>> fila;
    vector<vector<bool>> visitado(linhas, vector<bool>(colunas, false));

    fila.push({posicaoInicialX, posicaoInicialY});
    visitado[posicaoInicialX][posicaoInicialY] = true;

    while (!fila.empty()) {
        auto [x, y] = fila.front();
        fila.pop();

        if (matriz[x][y]->getTipo() == 'A') {
            cout << "Astronauta encontrado na posicao (" << x << ", " << y << ")" << endl;
        }

        vector<pair<int, int>> direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (auto [dx, dy] : direcoes) {
            int novoX = x + dx;
            int novoY = y + dy;

            if (novoX >= 0 && novoX < linhas && novoY >= 0 && novoY < colunas && !visitado[novoX][novoY] && posicaoValida(novoX, novoY)) {
                fila.push({novoX, novoY});
                visitado[novoX][novoY] = true;
                passos++;
            }
        }
    }
    cout << "Total de passos dados: " << passos << endl;


    
}

bool RoboDeResgate::posicaoValida(int x, int y) {
    
    if( x < 0 && x >= estacao.getLinhas() && y < 0 && y >= estacao.getColunas())
        return false;
    
    else if(estacao.getMatriz()[x][y]->podeAcessar() && ! proximoAoFogo(x, y))
        return true;

    return false;

}