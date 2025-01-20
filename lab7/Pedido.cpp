#include "Pedido.hpp"

int Pedido::proximoCodigo = 1;

Pedido::Pedido() : codigoPedido(0), tempoEstimado(0) {}

Pedido::Pedido(const string& descricaoPedido, const string& cpf, int tempoEstimado) {
    this->descricaoPedido = descricaoPedido;
    this->cpf = cpf;
    this->tempoEstimado = tempoEstimado;
    this->codigoPedido = proximoCodigo++;
}

void Pedido::setDescricaoPedido(const string& descricaoPedido) {
    this->descricaoPedido = descricaoPedido;
}

string Pedido::getDescricaoPedido() const {
    return descricaoPedido;
}

int Pedido::getCodigoPedido() const {
    return codigoPedido;
}

void Pedido::setCPF(const string& cpf) {
    this->cpf = cpf;
}

string Pedido::getCPF() const {
    return cpf;
}

void Pedido::setTempoEstimado(int tempoEstimado) {
    this->tempoEstimado = tempoEstimado;
}

int Pedido::getTempoEstimado() const {
    return tempoEstimado;
}

string Pedido::getDetalhes() const {
    return "Descrição do pedido: " + descricaoPedido + 
           "\nCódigo do pedido: " + to_string(codigoPedido) + 
           "\nCPF: " + cpf + 
           "\nTempo estimado: " + to_string(tempoEstimado) + " minutos";
}