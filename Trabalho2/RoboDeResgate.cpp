#include "RoboDeResgate.hpp"

RoboDeResgate::RoboDeResgate(int linha, int coluna){
    this->linha = linha;
    this->coluna = coluna;
}
void RoboDeResgate::teste(){
    cout << "Linha " << linha;
    cout << " Coluna " << coluna;
}   