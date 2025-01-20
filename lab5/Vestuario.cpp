// Vestuario.cpp
#include "Vestuario.hpp"

Vestuario::Vestuario(string nome, double preco, string tamanho)
: Produto(nome, preco), tamanho(tamanho) {}

string Vestuario::getDetalhes() {
    return getTipo() + ": " + Produto::getDetalhes() + ", Tamanho: " + tamanho;
}

string Vestuario::getTipo() const {
    return "Vestuario";
}