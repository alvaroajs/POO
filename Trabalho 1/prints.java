import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class prints {


    
    
    public static void menu() {
        System.out.println();
        System.out.println("                  ===== Menu: =====                ");
        System.out.println("1 - Cadastrar sobrevivente");
        System.out.println("2 - Adicionar habilidade a um sobrevivente");
        System.out.println("3 - Remover habilidade de um sobrevivente");
        System.out.println("4 - Adicionar recurso ao Vault");
        System.out.println("5 - Consumir recurso");
        System.out.println("6 - Registrar missão");
        System.out.println("7 - Adicionar sobrevivente a uma missão");
        System.out.println("8 - Exibir sobreviventes do Vault");
        System.out.println("9 - Exibir recursos do Vault");
        System.out.println("10 - Exibir missões realizadas");
        System.out.println("11 - Exibir sobreviventes cadastrados em uma missão");
        System.out.println("0 - Sair");
    }

    public static void habilidadesDisponiveis(){
        System.out.println("\nHabilidades disponiveis: ");
        int i = 1;
        for (HabilidadesDisponivel h : HabilidadesDisponivel.values()) {
            System.out.println(i + " - " +  h);
            i++;
        }

    }

    public static void imprimirSobreviventes(List<Sobrevivente> sobreviventes){
        if(sobreviventes.isEmpty()){
            System.out.println("Nenhum sobrevivente cadastrado");
            return;
        }
        System.out.println(sobreviventes);
    }

    public static void imprimirStatus(){
        System.out.println("Status disponíveis: ");
        int i = 1;
        for (StatusDisponivel s : StatusDisponivel.values()) {
            System.out.println(i +" - " + s);
            i++;
        }
    }
    public static void imprimirHabilidade(List<String> habilidades){
        System.out.println("Habilidades do sobrevivente: ");
        int i = 1;
        for (String h : habilidades) {
            System.out.println(i + "- " + h);
            i++;
        }
    }

    
    public static void imprimirRecursos(List <Recursos> aux){
        if(aux.isEmpty()){
            System.out.println("Nenhum recurso cadastrado");
            return;
        }
        System.out.println(aux);
    }
    
    public static void imprimirStatusMissao(){
        System.out.println("Status disponíveis: ");
        int i = 0;
        for (StatusDisponivelMissao s : StatusDisponivelMissao.values()) {
            i++;
            System.out.println(i + " - " + s);
        }
    }
    public static void imprimirMissoes(List<Missao> missoes){
        if (missoes.isEmpty()) {
            System.out.println("Nenhuma missão cadastrada");
            return;
        }
        System.out.println(missoes);
    }
    public static void imprimirSobreviventesMissao(Scanner scanner, Vault vault){
        List<Missao> missao = vault.getMissoes();
        List<String> IDs = new ArrayList<>();
        
        if(missao.isEmpty()){
            System.out.println("Nenhum missão cadastrada");
            return;
        }
        System.out.println("Deseja imprimir todas missões ? (s/n)");
        String opcao = scanner.nextLine();

        if(opcao.equals("s")){
            System.out.println(missao);
            
        }
        System.out.println("Digite o nome da missão: ");
        String nomeMissao = scanner.nextLine();

        for(Missao m : missao){
            if(m.getNomeMissao() == nomeMissao){
                IDs = m.detalhesID();
            }
        }
        if(IDs.isEmpty()){
            System.out.println("Nenhum sobrevivente cadastrado na missão " + nomeMissao);
            return;
        }
        
        List<Sobrevivente> sobreviventes = vault.getSobreviventes();

        System.out.println("Sobreviventes cadastrados na missão: " + nomeMissao);
        for(Sobrevivente s : sobreviventes){
            for(String id : IDs){
                if(s.getID() == id){
                    System.out.println(s);
                }
            }
        }

    }
}
