#pragma once

#include "Gerente.hpp"
#include "Desenvolvedor.hpp"

using namespace std;
class TechLead : public Gerente, public Desenvolvedor{
    private:
        int projetos_em_andamento;
    public:
        TechLead(string nomeFuncionario, float salarioBase, int numero_de_equipes, string linguagemPrincipal, int projetos_em_andamento);
        string descricao() override;
};