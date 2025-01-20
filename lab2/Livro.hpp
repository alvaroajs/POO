#ifndef LIVRO_HPP
#define LIVRO_HPP

#include <string>
#include "Autor.hpp"
using namespace std;
class Livro{
    private:
        string ISBN;
        string tituloDoLivro;
        Autor autor;
    public:
        Livro(string ISBN, string tituloDoLivro, Autor autor); 
        string getISBN();
        string getTituloDoLivro();
        Autor getAutor();

};

#endif