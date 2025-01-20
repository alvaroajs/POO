#pragma once

#include "Funcionario.hpp"
#include <string>

using namespace std;

class Gerente : virtual public Funcionario{
    protected:
        int numero_de_equipes;
    public:
        Gerente(string nomeFuncionario, float salarioBase, int numero_de_equipes);
        float bonusGerente();
        string descricao() override;
};