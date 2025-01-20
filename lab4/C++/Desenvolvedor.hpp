#pragma once
#include "Funcionario.hpp"

using namespace std;

class Desenvolvedor : virtual public Funcionario{
    protected:
        string linguagemPrincipal;
    public:
        Desenvolvedor(string nomeFuncionario, float salarioBase, string linguagemPrincipal);
        string descricao() override;
};