#pragma once
#include "Pessoa.hpp"

#include <iostream>


struct NoCliente {
    Pessoa cliente;
    NoCliente* proximo;
};

class ListaClientes {
private:
    NoCliente* primeiro;
    int tamanho;

public:
    ListaClientes();
    ~ListaClientes();
    void adicionar(const Pessoa& pessoa);
    Pessoa* buscarPorCPF(const std::string& cpf);
    void exibirTodos();
    bool clienteExiste(const std::string& cpf);
    int getTamanho();
};