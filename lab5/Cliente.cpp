// Cliente.cpp
#include "Cliente.hpp"

Cliente::Cliente(string nomeCliente, string CPF)
: nomeCliente(nomeCliente), CPF(CPF), numProdutos(0), total(0) {
    for(int i = 0; i < 100; i++) {
        produtos[i] = nullptr;
    }
}

Cliente::~Cliente() {
    for(int i = 0; i < numProdutos; i++) {
        delete produtos[i];
    }
}

string Cliente::getNomeCliente() {
    return nomeCliente;
}

string Cliente::getCPFCliente() {
    return CPF;
}

void Cliente::adicionarProduto(Produto* p) {
    if(numProdutos < 100) {
        produtos[numProdutos++] = p;
        cout << "Produto adicionado: " << p->getDetalhes() << endl;
        total += p->getPreco();
    } else {
        cout << "Limite de produtos atingido!" << endl;
        delete p; // deleta o produto que não foi adicionado
    }
}

string Cliente::getDetalhes() {
    string detalhes = "Nome do cliente: " + getNomeCliente() + 
                     " CPF: " + getCPFCliente() + "\n";
    
    if (numProdutos == 0) {
        detalhes += "Nenhum produto cadastrado.\n";
        return detalhes;
    }
    
    detalhes += "Produtos:\n";
    for(int i = 0; i < numProdutos; i++) {
        if(produtos[i] != nullptr) {
            detalhes += produtos[i]->getDetalhes() + "\n";
        }
    }
    detalhes += "Total: R$ " + to_string(total) + "\n";
    return detalhes;
}