#include "EstacaoEspacial.hpp"


EstacaoEspacial::EstacaoEspacial(int linhas, int colunas){
    this->linhas = linhas;
    this->colunas = colunas;
    matriz = vector<vector<Modulo*>> (linhas, vector<Modulo*>(colunas));

}

EstacaoEspacial::~EstacaoEspacial(){
    
}

void EstacaoEspacial::adicionarModulo(int x, int y, char tipo){

    if (tipo == 'S') {
        matriz[x][y] = new ModuloSeguranca();
        posicaoInicialX = x;
        posicaoInicialY = y;

    } else if (tipo == 'A') {
        matriz[x][y] = new ModuloComAstronauta();
    } else if (tipo == '#') {
        matriz[x][y] = new ModuloObstaculo();
    } else if (tipo == '~') {
        matriz[x][y] = new ModuloVazio();
    } else if (tipo == 'F') {
        matriz[x][y] = new ModuloComFogo();
    } else if (tipo == '.' || tipo == 'R') {    
        matriz[x][y] = new ModuloNormal();
    }

}
void EstacaoEspacial::deletarModulo(){
    for(int i = 0; i < linhas; i++){
        for(int j = 0; j < colunas; j++){
            delete matriz[i][j];
        }
    }
}

void EstacaoEspacial::adicionarAstronauta(string nome, int vida, int atendimentoUrgente, int x, int y){
    astronautas.push_back(Astronauta(nome, vida, atendimentoUrgente, x, y));
}

void EstacaoEspacial::adicionarPosicaoAstronauta(int x, int y, int aux){
    astronautas[aux].setX(x);
    astronautas[aux].setY(y);

}


void EstacaoEspacial::imprimirEstacao(){

    for(int i = 0; i < linhas; i++){
        for(int j = 0; j < colunas; j++){
            cout << matriz[i][j]->getTipo() << " ";
        }
        cout << endl;
    }
}

void EstacaoEspacial::ImprimirAstro(){
    for (Astronauta a : astronautas) {
        cout << a.toString();
    }
}

int EstacaoEspacial::getPosicaoInicialX(){
    return posicaoInicialX;
}
int EstacaoEspacial::getPosicaoInicialY(){
    return posicaoInicialY;
}

int EstacaoEspacial::getLinhas(){
    return linhas;
}
int EstacaoEspacial::getColunas(){
    return colunas;
}

vector<vector<Modulo*>> EstacaoEspacial::getMatriz(){
    return matriz;
}


vector<Astronauta> EstacaoEspacial::getAstronautas(){
    return astronautas;
}


