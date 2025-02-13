#include <fstream>
#include <iostream>
#include "RoboDeResgate.hpp"
#include "EstacaoEspacial.hpp"
#include "Astronauta.hpp"
#include <sstream>
using namespace std;


void lerArquivo(int i);

int main(){
    for(int i = 1; i <= 1; i++){

        lerArquivo(i);
    }

    return 0;
}



void lerArquivo(int i){


    
    while (true) {
        string entrada = "entrada" + to_string(i) + ".txt";
        string saida = "saida" + to_string(i) + ".txt";
            
        ifstream arquivoEntrada;
        arquivoEntrada.open(entrada);
        if (!arquivoEntrada.is_open()) {
            cerr << "Erro ao abrir o arquivo de entrada: " << entrada << endl;
            break;; // Passa para o próximo arquivo
        }

        // Abrir o arquivo de saída
        ofstream arquivoSaida(saida);
        if (!arquivoSaida.is_open()) {
            cerr << "Erro ao criar o arquivo de saída: " << saida << endl;
            arquivoEntrada.close();
            break;; // Passa para o próximo arquivo
        }
        
        int dX, dY, x = 0, y = 0; // tamanho da matriz
        arquivoEntrada >> dX >> dY;

        if (arquivoEntrada.fail()) {
            cerr << "Erro ao ler as dimensões da matriz do arquivo: " << entrada << endl;
            arquivoEntrada.close();
            arquivoSaida.close();
            break;; // Passa para o próximo arquivo
        }

        EstacaoEspacial estacao(dX, dY);
        string linha;
        // Criar uma nova estação espacial
        // Apagar a estação espacial existente e criar uma nova
        //estacao = EstacaoEspacial(dX, dY);
        cout<<endl;
        
        arquivoEntrada.ignore();
        // Ler a matriz da estação espacial
        int k = 0;
        int j = 0;
        bool erro = false;

        for(k = 0; k < dX; k++){
            
            getline(arquivoEntrada, linha);
            for(j = 0; j < linha.length(); j++){
               
                if(linha.length() != dY){
                    erro = true;
                    break;
                }
                
                estacao.adicionarModulo(k, j, linha[j]);
            }
            if(erro){
                break;
            }
            

        }

        if (k != dX){ // verifica a coluna tem o mesmo tamanho que o informado
            erro = true;
        }
        if(erro){
            //estacao.deletarModulo();
            cout << "Matriz do arquivo entrada"<< i <<  ".txt mal formatada, passando para o proximo arquivo." << endl;
            arquivoSaida << "Matriz do arquivo entrada"<< i <<  ".txt mal formatada, passando para o proximo arquivo.";
            arquivoEntrada.close();
            arquivoSaida.close();

            break; 
            
        }

        
        int posicaoInicialX = estacao.getPosicaoInicialX(), posicaoInicialY = estacao.getPosicaoInicialY();


        // Ignorar a próxima linha
        // arquivoEntrada.ignore();
        
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
            estacao.adicionarAstronauta(nome, vida, atendimentoUrgente, 0, 0);
        }
        //ler a posição dos astronautas 

        
        int xAstronauta, yAstronauta;
        int aux = 0;

        
        while (getline(arquivoEntrada, linha)){
            if (aux < estacao.getAstronautas().size()) {
                string nomeAstronauta;
                size_t pos = linha.find(':');
                if (pos != string::npos) {
                    nomeAstronauta = linha.substr(0, pos);
                    linha.erase(0, pos + 2); // Remove ": " from the string
                }

                pos = linha.find(',');
                if (pos != string::npos) {
                    xAstronauta = stoi(linha.substr(1, pos - 1)); // Remove '(' and get x position
                    yAstronauta = stoi(linha.substr(pos + 1, linha.length() - pos - 2)); // Remove ')' and get y position
                }
                estacao.adicionarPosicaoAstronauta(xAstronauta, yAstronauta, aux);
                aux++;
            }
        }



        RoboDeResgate robo(posicaoInicialX, posicaoInicialY, estacao);



        cout << "Estação espacial "<< i <<" iniciada." << endl;        
        robo.imprimir();
        
        cout << robo.Resultados();
        arquivoSaida << robo.Resultados();
        arquivoEntrada.close();
        arquivoSaida.close();

        break;
        }

    
    




}