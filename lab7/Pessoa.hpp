#pragma once
#include <iostream>
#include <string>
using namespace std;

class Pessoa {
private:
    string nome, CPF;
public:
    Pessoa();
    Pessoa(const string& nome, const string& CPF);
    string getNome() const;
    string getCPF() const;
    string getDetalhes() const;
};