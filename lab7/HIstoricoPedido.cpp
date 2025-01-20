
#include "HistoricoPedidos.hpp"
#include <iostream>

HistoricoPedidos::HistoricoPedidos() : primeiro(nullptr), tamanho(0) {}

HistoricoPedidos::~HistoricoPedidos() {
    NoHistorico* atual = primeiro;
    while (atual != nullptr) {
        NoHistorico* proximo = atual->proximo;
        delete atual;
        atual = proximo;
    }
}

void HistoricoPedidos::adicionar(const Pedido& pedido) {
    NoHistorico* novo = new NoHistorico;
    novo->pedido = pedido;
    novo->proximo = primeiro;
    primeiro = novo;
    tamanho++;
}

void HistoricoPedidos::exibirTodos(ListaClientes& listaClientes) {
    NoHistorico* atual = primeiro;
    while (atual != nullptr) {
        Pessoa* cliente = listaClientes.buscarPorCPF(atual->pedido.getCPF());
        std::cout << "Pedido #" << atual->pedido.getCodigoPedido()
                  << " - Cliente: " << cliente->getNome()
                  << " - Descrição: " << atual->pedido.getDescricaoPedido()
                  << " - Tempo: " << atual->pedido.getTempoEstimado()
                  << " minutos" << std::endl;
        atual = atual->proximo;
    }
}
int HistoricoPedidos::getTamanho() {
    return tamanho;
}