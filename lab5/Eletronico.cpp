// Eletronico.cpp
#include "Eletronico.hpp"

Eletronico::Eletronico(string nome, double preco, int garantia)
: Produto(nome, preco), garantia(garantia) {}

string Eletronico::getDetalhes() {
    return getTipo() + ": " + Produto::getDetalhes() + ", Garantia: " + to_string(garantia) + " meses";
}

string Eletronico::getTipo() const {
    return "Eletronico";
}