#include <iostream>
#include "Biblioteca.hpp"

using namespace std;

Biblioteca::Biblioteca() 
{}

void Biblioteca::adicionarLivro(Livro livro){
    
    livros.push_back(livro);


}
void Biblioteca::mostrarLivros(){
    for (Livro aux : livros){
        cout << "\nTitulo: " << aux.getTituloDoLivro() << endl;
        cout << "ISBN: " << aux.getISBN() << endl;

        cout << "Nome do autor: " << aux.getAutor().getNomeAutor() << endl;
        cout << "Data de nascimento: " << aux.getAutor().getDataDeNascimento() << endl;
    }
}   
    vector<Livro> Biblioteca::busca(string nomeBusca, string tituloBusca){
        vector<Livro> auxb;
        for(Livro i : livros){
            if ( i.getAutor().getNomeAutor() == nomeBusca && i.getTituloDoLivro() == tituloBusca){
                auxb.push_back(i);
            }
        }
        return auxb;
        
        }
