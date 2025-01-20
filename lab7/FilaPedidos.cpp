#include "FilaPedidos.hpp"

FilaPedidos::FilaPedidos() : primeiro(nullptr), ultimo(nullptr), tamanho(0) {}

FilaPedidos::~FilaPedidos() {
    while (!estaVazia()) {
        desenfileirar();
    }
}

void FilaPedidos::enfileirar(const Pedido& pedido) {
    NoPedido* novo = new NoPedido(pedido);
    
    if (estaVazia()) {
        primeiro = ultimo = novo;
    } else {
        ultimo->proximo = novo;
        ultimo = novo;
    }
    tamanho++;
}

Pedido FilaPedidos::desenfileirar() {
    if (estaVazia()) {
        throw runtime_error("Fila vazia");
    }

    NoPedido* temp = primeiro;
    Pedido pedido = temp->pedido;
    primeiro = primeiro->proximo;
    
    if (primeiro == nullptr) {
        ultimo = nullptr;
    }
    
    delete temp;
    tamanho--;
    return pedido;
}

void FilaPedidos::exibirTodos(ListaClientes& listaClientes) {
    NoPedido* atual = primeiro;
    while (atual != nullptr) {
        Pessoa* cliente = listaClientes.buscarPorCPF(atual->pedido.getCPF());
        if (cliente) {
            cout << "Pedido #" << atual->pedido.getCodigoPedido() + 1
                 << " - Cliente: " << cliente->getNome()
                 << " - Descrição: " << atual->pedido.getDescricaoPedido()
                 << " - Tempo Estimado: " << atual->pedido.getTempoEstimado() 
                 << " minutos" << endl;
        }
        atual = atual->proximo;
    }
}

bool FilaPedidos::estaVazia() const {
    return primeiro == nullptr;
}