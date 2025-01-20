#include "ListaClientes.hpp"
#include <iostream>

ListaClientes::ListaClientes() : primeiro(nullptr), tamanho(0) {}

ListaClientes::~ListaClientes() {
    NoCliente* atual = primeiro;
    while (atual != nullptr) {
        NoCliente* proximo = atual->proximo;
        delete atual;
        atual = proximo;
    }
}

void ListaClientes::adicionar(const Pessoa& pessoa) {
    NoCliente* novo = new NoCliente;
    novo->cliente = pessoa;
    novo->proximo = primeiro;
    primeiro = novo;
    tamanho++;
}

Pessoa* ListaClientes::buscarPorCPF(const std::string& cpf) {
    NoCliente* atual = primeiro;
    while (atual != nullptr) {
        if (atual->cliente.getCPF() == cpf) {
            return &(atual->cliente);
        }
        atual = atual->proximo;
    }
    return nullptr;
}

void ListaClientes::exibirTodos() {
    NoCliente* atual = primeiro;
    while (atual != nullptr) {
        std::cout << "Nome: " << atual->cliente.getNome() 
                  << " - CPF: " << atual->cliente.getCPF() << std::endl;
        atual = atual->proximo;
    }
}

bool ListaClientes::clienteExiste(const std::string& cpf) {
    return buscarPorCPF(cpf) != nullptr;
}
int ListaClientes::getTamanho() {
    return tamanho;
}