#include <fstream>
#include <iostream>
#include "RoboDeResgate.hpp"
#include "EstacaoEspacial.hpp"
#include "Astronauta.hpp"
#include <sstream>
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
                //cout << s[i][j] << " ";
                estacao.adicionarModulo(i, j, s[i][j]);
                
            }
            //cout << endl;
        }





        int posicaoInicialX = estacao.getPosicaoInicialX(), posicaoInicialY = estacao.getPosicaoInicialY();

        cout << "Posição inicial: (" << posicaoInicialX << ", " << posicaoInicialY << ")" << endl;

        cout << endl;
        // Ignorar a próxima linha
        arquivoEntrada.ignore();
        getline(arquivoEntrada, linha);


        vector<Astronauta> astronautas;
        //ler os astronautas
        string astronauta;
        string teste;
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
                cout << " aux " << xAstronauta << " " << yAstronauta << endl;
                estacao.adicionarPosicaoAstronauta(xAstronauta, yAstronauta, aux);
                aux++;
            }
        }



        RoboDeResgate robo(posicaoInicialX, posicaoInicialY, estacao);

        robo.Resultados();









        
        cout << "Estação espacial inicial:" << endl;        
        robo.imprimir();

        cout << "Astronautas resgatados:" << endl;
        robo.buscarAstronautas();
        arquivoEntrada.close();
        arquivoSaida.close();
        

        }


    
    



    return 0;
}