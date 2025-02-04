#include <fstream>
#include <iostream>
#include "RoboDeResgate.hpp"
#include "EstacaoEspacial.hpp"
#include "Astronauta.hpp"
using namespace std;



int main(){


    
    for(int i = 1; i <= 1; i++){
        string entrada = "entrada" + to_string(i) + ".txt";
        string saida = "saida" + to_string(i) + ".txt";
            
        ifstream arquivoEntrada;
        arquivoEntrada.open(entrada);
        if (!arquivoEntrada.is_open()) {
            cerr << "Erro ao abrir o arquivo de entrada: " << entrada << endl;
            continue; // Passa para o próximo arquivo
        }

        // Abrir o arquivo de saída
        ofstream arquivoSaida(saida);
        if (!arquivoSaida.is_open()) {
            cerr << "Erro ao criar o arquivo de saída: " << saida << endl;
            arquivoEntrada.close();
            continue; // Passa para o próximo arquivo
        }
        
        int dX, dY, x = 0, y = 0; // tamanho da matriz
        arquivoEntrada >> dX >> dY;

        if (arquivoEntrada.fail()) {
            cerr << "Erro ao ler as dimensões da matriz do arquivo: " << entrada << endl;
            arquivoEntrada.close();
            arquivoSaida.close();
            continue; // Passa para o próximo arquivo
        }

        EstacaoEspacial estacao(dX, dY);
        string linha;
        // Criar uma nova estação espacial
        EstacaoEspacial novaEstacao(dX, dY);
        char s[dX][dY];
        // Apagar a estação espacial existente e criar uma nova
        estacao = EstacaoEspacial(dX, dY);
        cout<<endl;

        // Ler a matriz da estação espacial
        for(int i = 0; i < dX; i++){
            for(int j = 0; j < dY; j++){
                arquivoEntrada >> s[i][j];
                cout << s[i][j] << " ";
                estacao.adicionarModulo(i, j, s[i][j]);
                
            }
            cout << endl;
        }
        cout << endl;
        // Ignorar a próxima linha
        arquivoEntrada.ignore();
        getline(arquivoEntrada, linha);


        vector<Astronauta> astronautas;
        //ler os astronautas
        string astronauta;

        while (getline(arquivoEntrada, linha) && linha != "Posições dos astronautas na matriz:") {
            string nome;
            int vida, atendimentoUrgente;
            size_t pos = 0;

            // Ler o nome do astronauta
            pos = linha.find(',');
            if (pos != string::npos) {
            nome = linha.substr(0, pos);
            linha.erase(0, pos + 1);
            }

            // Ler a vida do astronauta
            pos = linha.find(',');
            if (pos != string::npos) {
            vida = stoi(linha.substr(0, pos));
            linha.erase(0, pos + 1);
            }

            // Ler o atendimento urgente do astronauta
            atendimentoUrgente = stoi(linha);

            // Adicionar o astronauta ao vetor
            astronautas.push_back(Astronauta(nome, vida, atendimentoUrgente, 0, 2));
        }

        cout<<"imprimindo astronautas: "<<endl;
        for (Astronauta a : astronautas) {
            cout << a.toString() << endl;
        }   
        


        while (getline(arquivoEntrada, linha) && linha != "Posições dos astronautas na matriz:"){
            cout << linha << endl;
        }
        












        cout << "Imprimindo dentro da estação  "<< endl;
        estacao.imprimirEstacao();
        


        arquivoEntrada.close();
        arquivoSaida.close();
        }


    
    



    return 0;
}