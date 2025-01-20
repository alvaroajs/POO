#include "TechLead.hpp"

TechLead::TechLead(string nomeFuncionario, float salarioBase, int numero_de_equipes, string linguagemPrincipal, int projetos_em_andamento)
    : Funcionario(nomeFuncionario, salarioBase),
    Gerente(nomeFuncionario, salarioBase, numero_de_equipes),
    Desenvolvedor(nomeFuncionario, salarioBase, linguagemPrincipal),
    projetos_em_andamento(projetos_em_andamento)
{}
string TechLead::descricao(){
    return "TechLead: Nome: " + nomeFuncionario + 
           ", Salário base: " + to_string(salarioBase) + 
           ", Número de equipes: " + to_string(numero_de_equipes) + 
           ", Linguagem principal: " + linguagemPrincipal +
           ", Projetos em andamento: " + to_string(projetos_em_andamento) + ".";
}