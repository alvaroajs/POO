#include "RoboDeResgate.hpp"

#include "RoboDeResgate.hpp"

RoboDeResgate::RoboDeResgate(int x, int y, EstacaoEspacial& estacao) 
    : posicaoInicialX(x), posicaoInicialY(y), estacao(estacao) {
    // Qualquer inicialização adicional pode ser feita aqui
}

void RoboDeResgate::imprimir() {
    // Implementação do método imprimir
    cout << "Robo de resgate na posicao (" << posicaoInicialX << ", " << posicaoInicialY << ")" << endl;
    estacao.imprimirEstacao();
    cout <<endl;
    estacao.ImprimirAstro();
}