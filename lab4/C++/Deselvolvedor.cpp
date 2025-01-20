#include "Desenvolvedor.hpp"

Desenvolvedor::Desenvolvedor(string nomeFuncionario, float salarioBase, string linguagemPrincipal)
    : Funcionario(nomeFuncionario, salarioBase), linguagemPrincipal(linguagemPrincipal)
{} // fim do construtor, lembrando que temos que fazer o contrutor da linguagem principal

string Desenvolvedor::descricao(){
    return "\nDesenvolvedor: " + Funcionario::descricao() + ", Linguagem Principal: " + linguagemPrincipal;
} 