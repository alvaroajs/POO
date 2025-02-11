#pragma once
#include <vector>
#include <string>
#include "EstacaoEspacial.hpp"
#include <iostream>

using namespace std;

class RoboDeResgate {
private:
    int posicaoInicialX, posicaoInicialY, passos;
    EstacaoEspacial estacao;
    vector<Astronauta> resgatados;
    vector<Astronauta> naoResgatados;

public:
    RoboDeResgate(int x, int y, EstacaoEspacial& estacao); // Apenas a declaração
    ~RoboDeResgate();
    void imprimir();
    string Resultados();
    void buscarAstronautas();
    bool proximoAoFogo(int x, int y);
    bool posicaoValida(int x, int y);

    
};