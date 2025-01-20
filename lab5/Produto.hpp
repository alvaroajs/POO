// Produto.hpp
#pragma once
#include <string>

using namespace std;

class Produto {
private:
    string nome;
    double preco;
public:
    Produto(string nome, double preco);
    virtual string getDetalhes();
    virtual string getTipo() const;
    double getPreco() ;
    virtual ~Produto() = default;  // Destrutor virtual importante para polimorfismo
};