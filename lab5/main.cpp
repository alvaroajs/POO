#include <iostream>
#include <vector>
#include "Cliente.hpp"
#include "Vestuario.hpp"
#include "Eletronico.hpp"

using namespace std;

Cliente adicionarCliente();
Vestuario* adicionarVestuario();
Eletronico* adicionarEletronico();

int main() {
    vector<Cliente> clientes;
    string CPFBuscar;
    bool auxCPF = false, auxCliente = false;
    int op = 0, opProduto = 0;
    Cliente prov("", ""); // tive que criar um cliente provisório para poder posteriormente comparar o CPF

    do {
        cout << "\nDigite a opção desejada:" << endl;
        cout << "1 --> Cadastrar cliente." << endl;
        cout << "2 --> Adicionar compra." << endl;
        cout << "3 --> Detalhes do cliente." << endl;
        cout << "0 --> Sair." << endl;
        
        cin >> op;
        cin.ignore();

        switch (op) {
            case 1:
                prov = adicionarCliente();
                
                for (Cliente& aux : clientes) {
                    if (prov.getCPFCliente() == aux.getCPFCliente()) {
                        cout << "CPF: " << prov.getCPFCliente() << " já cadastrado para o cliente de nome: " + aux.getNomeCliente() << "." << endl;
                        break;
                    }
                }

                clientes.push_back(prov); // aqui caso o CPF não tiver cadastrado o cliente é adicionado
                break;

            case 2:
                if (clientes.empty()) {
                    cout << "Nenhum cliente cadastrado." << endl;
                    break;
                }
                cout << "Digite o CPF do cliente: ";
                getline(cin, CPFBuscar);
                auxCPF = false;

                for(Cliente& aux : clientes) {
                    if (CPFBuscar == aux.getCPFCliente()) {
                        cout << "CPF: "<< CPFBuscar <<  " encontrado, Cliente: " + aux.getNomeCliente() << endl;
                        do {
                            cout << "Digite 1 para Vestuario ou 2 para Eletronico: ";
                            cin >> opProduto;
                            cin.ignore();
                            
                            if (opProduto == 1) {
                                aux.adicionarProduto(adicionarVestuario());
                                break;
                            } else if (opProduto == 2) {
                                aux.adicionarProduto(adicionarEletronico());
                                break;
                            } else {
                                cout << "Opção inválida!" << endl;
                            }
                        } while (true);
                        auxCPF = true;
                        break;
                    }
                }
                if(!auxCPF) {
                    cout << "CPF não encontrado." << endl;
                }
                break;

            case 3:
                if (clientes.empty()) {
                    cout << "Nenhum cliente cadastrado." << endl;
                    break;
                }

                cout << "Digite o CPF do cliente:" << endl;
                getline(cin, CPFBuscar);
                auxCliente = false;

                for (Cliente& aux : clientes) {
                    if(aux.getCPFCliente() == CPFBuscar) {
                        cout << aux.getDetalhes() << endl;
                        
                        aux.getDetalhes(); // aqui imprimimos os detalhes do cliente em expecifico
                        
                        auxCliente = true;
                        
                        break;
                    }
                }
                if (!auxCliente) {
                    cout << "CPF não encontrado." << endl;
                }
                break;

            case 0:
                cout << "Saindo..." << endl;
                break;

            default:
                cout << "Opção inválida!" << endl;
                break;
        }
    } while (op != 0);

    return 0;
}

Cliente adicionarCliente() {
    string nomeCliente, CPF;
    cout << "Digite o nome do cliente: ";
    getline(cin, nomeCliente);
    cout << "Digite o CPF do cliente: ";
    getline(cin, CPF);
    return Cliente(nomeCliente, CPF);
}

Vestuario* adicionarVestuario() {
    string nomeVestuario, tamanho;
    double preco;

    cout << "Digite o nome do vestuario: ";
    getline(cin, nomeVestuario);
    cout << "Digite o valor: R$: ";
    cin >> preco;
    cin.ignore();
    cout << "Digite o tamanho: ";
    getline(cin, tamanho);

    return new Vestuario(nomeVestuario, preco, tamanho);
}

Eletronico* adicionarEletronico() {
    string nomeEletronico;
    double preco;
    int garantia;

    cout << "Digite o nome do eletronico: ";
    getline(cin, nomeEletronico);
    cout << "Digite o valor: R$: ";
    cin >> preco;
    cin.ignore();
    cout << "Digite o tempo de garantia (meses): ";
    cin >> garantia;
    cin.ignore();

    return new Eletronico(nomeEletronico, preco, garantia);
}