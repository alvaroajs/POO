#include <iostream>
#include "Biblioteca.hpp"
#include "Livro.hpp"
#include "Autor.hpp"

using namespace std;
int main(){

    int op = 0;
    string nomeAutor, dataDeNascimento, ISBN, tituloDoLivro, nomeBuscar, tituloBuscar;
    Biblioteca biblioteca;
    do
    {
        cout << "1: Adicionar." <<endl;
        cout << "2: Buscar." <<endl;
        cout << "3: Mostar todos os livros." <<endl;

        cout << "Qual opção desejada ?" <<endl;
        cin >> op;
        cin.ignore();
        cout<<endl;
        if (op == 1){
            cout << "Digite o título do livro: ";
            getline(cin, tituloDoLivro);
            cout << "Digite o nome do autor: ";
            getline(cin, nomeAutor);
            cout << "Digite a data de nascimento do autor: ";
            getline(cin, dataDeNascimento);
            cout << "Digite o ISBN do livro: ";
            getline(cin, ISBN);

            Autor autor(nomeAutor, dataDeNascimento);
            Livro livro(ISBN, tituloDoLivro, autor);
            biblioteca.adicionarLivro(livro);

            
            
        }
        else if (op == 2){
            cout << "Qual o nome do autor a buscar" << endl;
            getline(cin, nomeBuscar);
            cout << "Qual o nome do livro a buscar" << endl;
            getline(cin, tituloBuscar);

            biblioteca.busca(nomeBuscar, tituloBuscar);
            for (Livro aux : biblioteca.busca(nomeBuscar, tituloBuscar)){

            cout << "\nTitulo: " << aux.getTituloDoLivro() << endl;
            cout << "ISBN: " << aux.getISBN() << endl;

            cout << "Nome do autor: " << aux.getAutor().getNomeAutor() << endl;
            cout << "Data de nascimento: " << aux.getAutor().getDataDeNascimento() << endl;
             }

            
        }
        else if (op == 3)
        {
            biblioteca.mostrarLivros();
        }
        else if (op != 0){
            cout << "Opção " << op << " invalida" <<endl;
        }
        
        
        

    } while (op != 0);
    



    return 0;
}