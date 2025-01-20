#include "Gerente.hpp"

Gerente::Gerente(string nomeFuncionario, float salarioBase, int numero_de_equipes)
    : Funcionario(nomeFuncionario, salarioBase), numero_de_equipes(numero_de_equipes){}

float Gerente::bonusGerente()
{
    return numero_de_equipes * 500;
}
string Gerente::descricao()
{
    return "\nGerente: " + Funcionario::descricao() + ", Número de equipes: " + to_string(numero_de_equipes) + ", Bônus: " + to_string(bonusGerente());
}