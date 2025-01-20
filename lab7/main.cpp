// main.cpp
#include <iostream>
#include <string>
#include "ListaClientes.hpp"
#include "FilaPedidos.hpp"
#include "HistoricoPedidos.hpp"

using namespace std;
void exibirMenu() {
    cout << "\nSistema de Gerenciamento de Pedidos" << endl;
    cout << "1. Adicionar novo cliente" << endl;
    cout << "2. Adicionar novo pedido" << endl;
    cout << "3. Preparar próximo pedido" << endl;
    cout << "4. Exibir pedidos em espera" << endl;
    cout << "5. Exibir histórico de pedidos" << endl;
    cout << "6. Exibir clientes cadastrados" << endl;
    cout << "7. Sair" << endl;
    cout << "Escolha uma opção:" << endl;
}

int main() {
    ListaClientes listaClientes;
    FilaPedidos filaPedidos;
    HistoricoPedidos historicoPedidos;
    int opcao;
    string nome, cpf, descricao;
    int tempo;

    do {
        exibirMenu();
        cin >> opcao;
        cin.ignore();

        switch (opcao) {
            case 1: {
                cout << "Nome do cliente: ";
                getline(cin, nome);
                cout << "CPF: ";
                getline(cin, cpf);
                
                Pessoa novaPessoa(nome, cpf);
                listaClientes.adicionar(novaPessoa);
                cout << "Cliente cadastrado com sucesso!\n";
                break;
            }
            case 2: {
                if (cpf.empty()) {
                    cout << "Nenhum Cliente cadastrado!\n";
                    break;
                }
                cout << "CPF do cliente: ";
                getline(cin, cpf);
                if (!listaClientes.clienteExiste(cpf)) {
                    cout << "Cliente não encontrado!\n";
                    break;
                }
                
                cout << "Descrição do pedido: ";
                getline(cin, descricao);
                cout << "Tempo estimado (minutos): ";
                cin >> tempo;
                cin.ignore(); // Limpa o buffer após ler o número
                
                // Cria o pedido com os dados coletados
                Pedido novoPedido;
                novoPedido.setDescricaoPedido(descricao);
                novoPedido.setTempoEstimado(tempo);
                novoPedido.setCPF(cpf);
                
                filaPedidos.enfileirar(novoPedido);
                cout << "Pedido adicionado com sucesso!\n";
                break;
            }
            case 3: {
                if (filaPedidos.estaVazia()) {
                    cout << "Não há pedidos na fila!\n";
                    break;
                }
                
                Pedido pedidoConcluido = filaPedidos.desenfileirar();
                historicoPedidos.adicionar(pedidoConcluido);
                cout << "Pedido #" << pedidoConcluido.getCodigoPedido() 
                          << " preparado e movido para o histórico!\n";
                break;
            }
            case 4:
                if(filaPedidos.estaVazia()) {
                    cout << "Nenhum pedido em espera!\n";
                    break;
                }
                cout << "\nPedidos em espera:\n";
                filaPedidos.exibirTodos(listaClientes);
                break;
            case 5:
                if(historicoPedidos.getTamanho() == 0) {
                    cout << "Nenhum pedido foi concluído!\n";
                    break;
                }
                cout << "\nHistórico de pedidos:\n";
                historicoPedidos.exibirTodos(listaClientes);
                break;
            case 6:
                if(listaClientes.getTamanho() == 0) {
                    cout << "Nenhum cliente cadastrado!\n";
                    break;
                }
                cout << "\nClientes cadastrados:\n";
                listaClientes.exibirTodos();
                break;
            case 7:
                cout << "Encerrando o programa...\n";
                break;
            default:
                cout << "Opção inválida!\n";
        }
    } while (opcao != 7);

    return 0;
}