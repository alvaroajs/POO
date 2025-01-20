#include "Funcionario.hpp"

Funcionario::Funcionario(string nomeFuncionario, float salarioBase)
: nomeFuncionario(nomeFuncionario), salarioBase(salarioBase) {}

string Funcionario::descricao()
{
    return "Nome: " + nomeFuncionario + ", Salário: " + to_string(salarioBase);
}