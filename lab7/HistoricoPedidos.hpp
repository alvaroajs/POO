#pragma once
#include "Pedido.hpp"
#include "ListaClientes.hpp"

struct NoHistorico {
    Pedido pedido;
    NoHistorico* proximo;
};

class HistoricoPedidos {
private:
    NoHistorico* primeiro;
    int tamanho;

public:
    HistoricoPedidos();
    ~HistoricoPedidos();
    void adicionar(const Pedido& pedido);
    void exibirTodos(ListaClientes& listaClientes);
    int getTamanho();
};
