// Eletronico.hpp
#pragma once
#include "Produto.hpp"

class Eletronico : public Produto {
private:
    int garantia;
public:
    Eletronico(string nome, double preco, int garantia);
    string getDetalhes() override;
    string getTipo() const override;
};