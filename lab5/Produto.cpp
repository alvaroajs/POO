// Produto.cpp
#include "Produto.hpp"

Produto::Produto(string nome, double preco)
: nome(nome), preco(preco) {}

double Produto::getPreco() {
    return preco;
}
string Produto::getDetalhes() {
    return "Nome: " + nome + ", Preço: R$: " + to_string(getPreco());
}

string Produto::getTipo() const{
    return "Produto";
}
