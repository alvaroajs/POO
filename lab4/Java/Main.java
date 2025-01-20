import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Listas para armazenar os funcionários
        List<Desenvolvedor> desenvolvedores = new ArrayList<>();
        List<Gerente> gerentes = new ArrayList<>();
        List<TechLead> techLeads = new ArrayList<>();

        // Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);
        int op = -1;

        do {
            // Menu de opções
            System.out.println("\nMenu: ");
            System.out.println("1 ---> Adicionar Desenvolvedor.");
            System.out.println("2 ---> Adicionar Gerente.");
            System.out.println("3 ---> Adicionar TechLead.");
            System.out.println("4 ---> Imprimir funcionários cadastrados.");
            System.out.println("0 ---> Sair");
            System.out.print("Digite qual opção desejada: ");

            op = scanner.nextInt();
            scanner.nextLine();
            
            String nomeDesenvolvedor, linguagemPrincipal, nomeGerente, nomeTechLead;
            int qtdEquipes = 0, qtdProjetos = 0;
            float salarioD = 0, salarioG = 0, salarioTL = 0;

            switch (op) {
                case 1: // add dev
                    System.out.print("Digite o nome do desenvolvedor: ");
                    nomeDesenvolvedor = scanner.nextLine();
                    
                    System.out.print("Digite seu salário: ");
                    salarioD = scanner.nextFloat();
                    scanner.nextLine();
                    
                    System.out.print("Digite a linguagem principal: ");
                    linguagemPrincipal = scanner.nextLine();
                    System.out.println("Digite a quantidade de  projetos reslizados?");
                    int qtdProjetosRealizados = scanner.nextInt();
                    scanner.nextLine();
                    
                    Desenvolvedor desenvolvedor = new Desenvolvedor(nomeDesenvolvedor, salarioD, linguagemPrincipal, qtdProjetosRealizados);
                    desenvolvedores.add(desenvolvedor);
                    System.out.println("Desenvolvedor adicionado com sucesso!");
                    break;

                case 2: //add gerente
                    System.out.print("Digite o nome do gerente: ");
                    nomeGerente = scanner.nextLine();
                    
                    System.out.print("Digite seu salário: ");
                    salarioG = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.print("Digite a quantidade de equipes sob sua supervisão: ");
                    qtdEquipes = Integer.parseInt(scanner.nextLine());
                    
                    Gerente gerente = new Gerente(nomeGerente, salarioG, qtdEquipes);
                    gerentes.add(gerente);
                    System.out.println("Gerente adicionado com sucesso!");
                    break;

                case 3: // add techlead
                    System.out.print("Digite o nome do TechLead: ");
                    nomeTechLead = scanner.nextLine();
                    
                    System.out.print("Digite seu salário: ");
                    salarioTL = scanner.nextFloat();
                    scanner.nextLine();
                    
                    System.out.print("Digite a quantidade de equipes sob sua supervisão: ");
                    qtdEquipes = Integer.parseInt(scanner.nextLine());
                    
                    System.out.print("Digite a linguagem principal: ");
                    linguagemPrincipal = scanner.nextLine();
                    
                    System.out.print("Digite a quantidade de projetos em andamento: ");
                    qtdProjetos = scanner.nextInt();
                    scanner.nextLine();
                    
                    TechLead techLead = new TechLead(nomeTechLead, salarioTL, qtdEquipes, linguagemPrincipal, qtdProjetos);
                    techLeads.add(techLead);
                    System.out.println("TechLead adicionado com sucesso!");
                    break;

                case 4: // Imprimir funcionários
                    System.out.println("\n--- Desenvolvedores ---");
                    for (Desenvolvedor dev : desenvolvedores) {
                        System.out.println(dev.descricao());
                        System.out.println(dev.projetosRealizados());
                    }

                    System.out.println("\n--- Gerentes ---");
                    for (Gerente ger : gerentes) {
                        System.out.println(ger.descricao());
                        System.out.printf("Bônus: %.2f\n", ger.bonus());
                    }

                    System.out.println("\n--- TechLeads ---");
                    for (TechLead tl : techLeads) {
                        System.out.println(tl.descricao());
                        System.out.printf("Bônus: %.2f\n", tl.bonus());
                        System.out.println(tl.projetosRealizados());
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção " + op + " inválida.");
            }
        } while (op != 0);

        scanner.close();
    }
}