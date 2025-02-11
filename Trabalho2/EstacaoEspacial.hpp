#pragma once

#include <iostream>
#include <string>
#include <vector>
#include "Modulo.hpp"
#include "ModuloSeguranca.hpp"
#include "ModuloComAstronauta.hpp"
#include "ModuloObstaculo.hpp"
#include "ModuloVazio.hpp"
#include "ModuloComFogo.hpp"
#include "ModuloNormal.hpp"
#include "Astronauta.hpp"

using namespace std;

class EstacaoEspacial{
    private:
        vector<vector<Modulo*>> matriz;
        int linhas, colunas, posicaoInicialX, posicaoInicialY;
        vector<Astronauta> astronautas;

    public:
        EstacaoEspacial(int linhas, int colunas);
        ~EstacaoEspacial();
        void adicionarModulo(int i, int j, char tipo);
        void adicionarAstronauta(string nome, int vida, int atendimentoUrgente, int x, int y);
        void imprimirEstacao();
        void ImprimirAstro();

        int getPosicaoInicialX();
        int getPosicaoInicialY();

        int getLinhas();
        int getColunas();

        vector<vector<Modulo*>> getMatriz();

       

};