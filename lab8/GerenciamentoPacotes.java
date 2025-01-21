import java.util.Scanner;

public class GerenciamentoPacotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaCliente listaCliente = new ListaCliente();
        FilaEntradaPacotes filaEntrada = new FilaEntradaPacotes();
        FilaPrioridadePacote filaPrioridade = new FilaPrioridadePacote();
        HistoricoPacotes historico = new HistoricoPacotes();
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar um novo cliente à lista de clientes");
            System.out.println("2. Registrar um novo pacote");
            System.out.println("3. Processar o próximo pacote");
            System.out.println("4. Exibir os pacotes na fila de entrada");
            System.out.println("5. Exibir os pacotes na fila de prioridade");
            System.out.println("6. Exibir o histórico de pacotes entregues");
            System.out.println("7. Exibir a lista de clientes cadastrados");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    // Adicionar um novo cliente à lista de clientes
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    if(listaCliente.buscarCPF(cpf)){
                        System.out.println("CPF já cadastrado.");
                        break;
                    }
                    
                    listaCliente.adicionarCliente(nome, cpf);
                    break;
                case 2:
                    // Registrar um novo pacote
                    System.out.println("Digite o CPF do destinatário: ");
                    String cpfDestinatario = scanner.nextLine();

                    if (!listaCliente.buscarCPF(cpfDestinatario)) {
                        System.out.println("CPF: " + cpfDestinatario + "não cadastrado.");
                        break;
                    }
                    System.out.println("Digite o codigo postal do pacote: ");
                    String codigo = scanner.nextLine();

                    System.out.println("Digite a descrição do pacote: ");
                    String descricao = scanner.nextLine();

                    System.out.println("Digite a prioridade(1 urgente, 2 normal) do pacote: ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();

                    if (prioridade == 1) {
                        filaPrioridade.adicionarPacote(new Pacote(codigo, descricao, prioridade, cpfDestinatario));
                        System.out.println("Pacote adicionado à fila de prioridade.");
                        break;
                    }
                    else if (prioridade == 2) {
                        filaEntrada.adicionarPacote(new Pacote(codigo, descricao, prioridade, cpfDestinatario));
                        System.out.println("Pacote adicionado à fila de entrada.");
                        break;
                    }

                    else {
                        System.out.println("Prioridade inválida! Tente novamente.");
                    }

                    break;
                case 3: // Processar o próximo pacote
                    if(filaPrioridade.filaVazia()){
                        System.out.println("Fila de prioridade vazia.");
                        
                    }
                    else{
                        System.out.println("Pacote urgente processado: ");
                        historico.adicionarAoHistorico(filaPrioridade.removerPacote());
                        break;
                    }

                    if(filaEntrada.filaVazia()){
                        System.out.println("Fila de entrada vazia.");
                    }
                    else{
                        System.out.println("Pacote não urgente processado: ");
                        historico.adicionarAoHistorico(filaEntrada.removerPacote());
                        break;
                    }

                    System.out.println("Nenhum pacote cadastrado");
                    break;
                    
                    
                case 4: // Exibir os pacotes na fila de entrada
                    if(filaEntrada.filaVazia()){
                        System.out.println("Fila de entrada vazia.");
                        break;
                    }
                    
                    filaPrioridade.exibirFila();
                    break;
                case 5: // Exibir os pacotes na fila de prioridade
                    if(filaPrioridade.filaVazia()){
                        System.out.println("Fila de prioridade vazia.");
                        break;
                    }
                    filaEntrada.exibirFila();

                    break;
                case 6: // Exibir o histórico de pacotes entregues
                    historico.exibirHistorico();
                    break;
                case 7: // Exibir a lista de clientes cadastrados
                    listaCliente.exibirClientes();

                    break;
                case 8: // Sair
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 8);
        scanner.close();
    }
}
