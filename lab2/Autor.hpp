#ifndef AUTOR_HPP
#define AUTOR_HPP
#include <string>
#include<iostream>

using namespace std;

class Autor{
    private:
        string nomeAutor;
        string dataDeNascimento;
    public:

    Autor(string nomeAutor, string dataDeNascimento);
    string getNomeAutor();
    string getDataDeNascimento();
};

#endif