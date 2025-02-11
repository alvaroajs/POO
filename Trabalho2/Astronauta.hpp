#pragma once
#include "Modulo.hpp"
#include <vector>
#include <iostream>

using namespace std;

class Astronauta {
    private:
        string nome;
        int x, y, nivelSaude;
        bool antendimentoUrgente;
    
    public:
        Astronauta(string nome, int nivelSaude, bool atendimentoUrgente, int x, int y);

        int getX();
        int getY();
        void setX(int x);
        void setY(int y);
        string getNome();
        int getNivelSaude();
        bool isAtendimentoUrgente();
        string toString();
        string getDetalhes();


};