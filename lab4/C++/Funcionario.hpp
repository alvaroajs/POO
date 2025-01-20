#pragma once
#include <string>

using namespace std;
class Funcionario {
    protected: 
        string nomeFuncionario;
        float salarioBase;
    public:
        Funcionario(string nomeFuncionario, float salario_base);
        virtual string descricao();

};