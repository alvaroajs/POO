// Vestuario.hpp
#pragma once
#include "Produto.hpp"

class Vestuario : public Produto {
private:
    string tamanho;
public:
    Vestuario(string nome, double preco, string tamanho);
    string getDetalhes() override;
    string getTipo() const override;
};