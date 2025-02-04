#include "EstacaoEspacial.hpp"


EstacaoEspacial::EstacaoEspacial(int linhas, int colunas){
    this->linhas = linhas;
    this->colunas = colunas;
    matriz = vector<vector<Modulo*>>(linhas, vector<Modulo*>(colunas));

}

void EstacaoEspacial::adicionarModulo(int x, int y, char tipo){

    if (tipo == 'S') {
        matriz[x][y] = new ModuloSeguranca();
    } else if (tipo == 'A') {
        matriz[x][y] = new ModuloComAstronauta();
    } else if (tipo == '#') {
        matriz[x][y] = new ModuloObstaculo();
    } else if (tipo == '~') {
        matriz[x][y] = new ModuloVazio();
    } else if (tipo == 'F') {
        matriz[x][y] = new ModuloComFogo();
    } else if (tipo == '.') {
        matriz[x][y] = new ModuloNormal();
    }
}

void EstacaoEspacial::imprimirEstacao(){
    for(int i = 0; i < linhas; i++){
        for(int j = 0; j < colunas; j++){
            cout << matriz[i][j]->getTipo() << " ";
        }
        cout << endl;
    }
}