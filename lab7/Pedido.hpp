#pragma once
#include <iostream>
#include <string>
using namespace std;

class Pedido {
private:
    string descricaoPedido;
    int codigoPedido;
    string cpf;
    int tempoEstimado;
    static int proximoCodigo;

public:
    Pedido();
    Pedido(const string& descricaoPedido, const string& cpf, int tempoEstimado);
    
    void setDescricaoPedido(const string& descricaoPedido);
    string getDescricaoPedido() const;
    
    int getCodigoPedido() const;
    
    void setCPF(const string& cpf);
    string getCPF() const;
    
    void setTempoEstimado(int tempoEstimado);
    int getTempoEstimado() const;
    
    string getDetalhes() const;
};