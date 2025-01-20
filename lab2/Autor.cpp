#include <iostream>

#include "Autor.hpp"

Autor::Autor(string nomeAutor, string dataDeNascimento) : nomeAutor(nomeAutor), dataDeNascimento(dataDeNascimento)
{} 

string Autor::getNomeAutor(){
    return nomeAutor;
}
string Autor::getDataDeNascimento(){
    return dataDeNascimento;
}
