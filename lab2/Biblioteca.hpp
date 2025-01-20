#ifndef BIBLIOTECA_HPP
#define BIBLIOTECA_HPP

#include "Livro.hpp"
#include "Autor.hpp"
#include <vector>

class Biblioteca{

    private:
        vector<Livro> livros;
        
    public:
    Biblioteca ();
    void adicionarLivro(Livro livro);
    void mostrarLivros();
    
    vector<Livro> busca(string nomeBusca, string tituloBusca);



};

#endif