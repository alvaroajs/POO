#include "Pessoa.hpp"

Pessoa::Pessoa() {}

Pessoa::Pessoa(const string& nome, const string& CPF) {
    this->nome = nome;
    this->CPF = CPF;
}

string Pessoa::getNome() const {
    return nome;
}

string Pessoa::getCPF() const {
    return CPF;
}

string Pessoa::getDetalhes() const {
    return "Nome: " + nome + "\nCPF: " + CPF;
}