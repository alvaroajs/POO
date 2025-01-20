// Cliente.hpp
#pragma once
#include <iostream>
#include "Produto.hpp"

class Cliente {
private:
    string nomeCliente, CPF;
    Produto* produtos[100];
    int numProdutos;
    double total;
public:
    Cliente(string nomeCliente, string CPF);
    ~Cliente();
    string getNomeCliente();
    string getCPFCliente();
    void adicionarProduto(Produto* p);
    string getDetalhes();
};