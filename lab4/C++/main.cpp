    #include <iostream>
    #include <vector>
    #include "Desenvolvedor.hpp"
    #include "Gerente.hpp"
    #include "TechLead.hpp"
    using namespace std;

    int main()
    {
        vector<Desenvolvedor> desenvolvedores;
        vector<Gerente> gerentes;
        vector<TechLead> techLeads;
        int op = 0;
        do
        {
            cout << "\nMenu: " << endl;
            cout << "1--->Adicionar Desenvolvedor. " << endl;
            cout << "2--->Adicionar Gerente. " << endl;
            cout << "3--->Adicionar TechLead. " << endl;
            cout << "4--->Imprimir funcionários cadastrados. " << endl;
            cout << "0--->Sair" << endl;
            cout << "Digite qual opção desejada: ";
            cin >> op;
            cin.ignore();
            cout << endl;

            string nomeGerente, nomeDesenvolvedor, linguagemPrincipal, nomeTechLead;
            int qtdEquipes = 0, qtdProjetos = 0;
            float salarioG = 0.0, salarioD = 0.0, salarioTL = 0.0;

            if(op == 1){
                cout << "Digite o nome do desenvolvedor: ";
                getline(cin, nomeDesenvolvedor);
                cout << "Digite seu salário: ";
                cin >> salarioD;
                cin.ignore();
                cout << "Digite a linguagem principal: ";
                getline(cin, linguagemPrincipal);
                Desenvolvedor desenvolvedor(nomeDesenvolvedor, salarioD, linguagemPrincipal);
                desenvolvedores.push_back(desenvolvedor);
            }
            else if (op == 2){ // add gerente
                cout << "Digite o nome do gerente: ";
                getline(cin, nomeGerente);
                cout << "Digite seu salário: ";
                cin >> salarioG;
                cin.ignore();
                cout << "Digite a quantidade de equipes sob sua supervisão: ";
                cin >> qtdEquipes;
                cin.ignore();
                Gerente gerente(nomeGerente, salarioG, qtdEquipes);
                gerentes.push_back(gerente);
            }
            else if (op == 3){ // add techLead
                cout << "Digite o nome do TechLead: ";
                getline(cin, nomeTechLead);
                cout << "Digite seu salário: ";
                cin >> salarioTL;
                cin.ignore();
                cout << "Digite a quantidade de projetos em sua direção: ";
                cin >> qtdEquipes;
                cin.ignore();
                cout << "Digite a linguagem principal: ";
                getline(cin, linguagemPrincipal);
                cout << "Digite a quantidade projetos realizados: ";
                cin >> qtdProjetos;
                
                TechLead techLead(nomeTechLead, salarioTL, qtdEquipes, linguagemPrincipal, qtdProjetos);
                techLeads.push_back(techLead);
            }
            else if (op == 4){ // imprimir
                for(auto& dev : desenvolvedores) 
                    cout << dev.descricao() << endl;
                for(auto& gerente : gerentes) 
                    cout << gerente.descricao() << endl;
                for(auto& techLead : techLeads) 
                    cout << techLead.descricao() << endl;
            }
            else if (op == 0){
                cout << "Saindo..." << endl;
                break;
            }
            else{
                cout << "Opção " << op << " inválida. " << endl;
            }
        } while (op != 0);
        return 0;
    }