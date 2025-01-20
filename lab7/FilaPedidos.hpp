
#pragma once
#include "Pedido.hpp"
#include "ListaClientes.hpp"
#include <iostream>

struct NoPedido {
    Pedido pedido;
    NoPedido* proximo;
    
    NoPedido(const Pedido& p) : pedido(p), proximo(nullptr) {}
};

class FilaPedidos {
private:
    NoPedido* primeiro;
    NoPedido* ultimo;
    int tamanho;

public:
    FilaPedidos();
    ~FilaPedidos();
    void enfileirar(const Pedido& pedido);
    Pedido desenfileirar();
    void exibirTodos(ListaClientes& listaClientes);
    bool estaVazia() const;
};