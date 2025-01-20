import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m"; //mudar a cor do terminar para amarelo
    public static void main(String[] args) {
        // List<Sobrevivente> sobreviventes = new ArrayList<>();
        Vault vault = new Vault();
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        System.out.println(YELLOW + "Bem vindo ao Gerenciador do Vault !");
        do {
            prints.menu();

            System.out.println("Digite a opção desejada: ");
            op = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (op) {
                case 1:
                    // Cadastrar sobrevivente
                    vault.addSobrevivente(cadastrarSobrevivente(scanner, vault.getSobreviventes()));
                    break;
                case 2:
                    // Adicionar habilidade a um sobrevivente
                    adicionarHabilidade(scanner, vault.getSobreviventes());
                    break;
                case 3:
                    // Remover habilidade de um sobrevivente
                    // Falta implementar a lógica para remover habilidade
                    removerHabilidade(scanner, vault.getSobreviventes());
                    break;
                case 4:
                    // Adicionar recurso ao Vault
                    String auxNome = "";
                    int auxQuantidade = 0;
                    vault.setRecurso(adicionarRecurso(scanner, vault, auxNome, auxQuantidade));
                    break;
                case 5:
                    // Consumir recurso
                    consumirRecurso(scanner, vault);
                    break;
                case 6:
                    // Registrar missão
                    registrarMissao(scanner, vault);
                    break;
                case 7:
                    // Adicionar sobrevivente a uma missão
                    adicionarSobreviventeMissao(scanner, vault);
                    break;
                case 8:
                    // Exibir sobreviventes do Vault
                    prints.imprimirSobreviventes(vault.getSobreviventes());
                    break;
                case 9:
                    // Exibir recursos do Vault
                    
                    prints.imprimirRecursos(vault.getRecursos());

                    break;
                case 10:
                    // Exibir missões realizadas
                    prints.imprimirMissoes(vault.getMissoes());

                    break;
                case 11:
                    // Exibir sobreviventes cadastrados em uma missão
                    prints.imprimirSobreviventesMissao(scanner, vault);
                    break;
                case 0:
                    // Sair
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (op != 0);

    }

    public static Sobrevivente cadastrarSobrevivente(Scanner scanner, List<Sobrevivente> sobreviventes) {
        

        String ID = "";
        Boolean IDJaAdicionado = false;
        while (true) {
            System.out.println("Digite o ID do sobrevivente: ");
            ID = scanner.nextLine();
            for (Sobrevivente s : sobreviventes) {
                if (s.getID().equals(ID)) {
                    IDJaAdicionado = true;
                    break;
                }
            }
            if (IDJaAdicionado) {
                System.out.println("\nID já adicionado, tente novamente.");
            } else {
                break;
            }

        }

        System.out.println("Digite o nome do sobrevivente: ");
        String nome = scanner.nextLine();

        int idade = -1; // idade -1 para entrar no loop
        while (idade < 0) {
            System.out.println("Digite a idade do sobrevivente: ");
            try {
                idade = Integer.parseInt(scanner.nextLine()); // aqui se verifiva se o valor é inteiro
                if (idade <= 0) { // aqui se verifica se o valor é maior que 0
                    System.out.println("A idade deve ser maior que 0. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro maior que 0.");
            }
        }
        

        
        String status; // foi criada a variavel para a chamada do metodo sobrvivente enxergue o status
        System.out.println("Adicione no máximo 3 habilidades");

        while (true) { // while que virifica se o status é valido pelo try catch
            prints.imprimirStatus();
            System.out.println("Digite o numero correspondente ao status do sobrevivente: ");
            int statusInt = scanner.nextInt();
            if(statusInt < 1 || statusInt > StatusDisponivel.values().length){
                System.out.println("Status inválido, tente novamente.");
            }
            else{
                status = StatusDisponivel.values()[statusInt - 1].toString();
                break;
            }

        }
        List<String> h = new ArrayList<>(); //criando uma lista de habilidades, se for passar com newArrayList tem que passar o tipo de dado
        System.out.println("Sobrevivente: " + nome + " cadastrado com sucesso.");
        return new Sobrevivente(nome, idade, ID, h, status);

    }

   
    public static void adicionarHabilidade(Scanner scanner, List<Sobrevivente> sobreviventes) {
        // Falta implementar a lógica para adicionar habilidade
        if (sobreviventes.isEmpty()) {
            System.out.println("Nenhum sobrevivente cadastrado");
            return;
        }
        System.out.println("Deseja imprimir os sobreviventes cadastrados? (s/n)");
        String imprimir = scanner.nextLine().toLowerCase();
        if (imprimir.equals("s")) { //aqui temos um if para verificar se o usuario deseja imprimir os sobreviventes
            prints.imprimirSobreviventes(sobreviventes);
        }

        System.out.println("Digite o ID do sobrevivente que deseja adicionar uma habilidade: ");
            String ID = scanner.nextLine();
        Sobrevivente sobrevivente = null;
        for (Sobrevivente s: sobreviventes){
            if(s.getID().equals(ID)){
                System.out.println("Sobrevivente: "+ s.getNomePessoa() + " encontrado: ");
                sobrevivente = s;
                break;
            }   
        }
        if (sobrevivente == null){
            System.out.println("Sobrevivente não encontrado");
            return;
        }

        int auxMissai = 0;
        for (String habilidade : sobrevivente.getHabilidades()){
            System.out.println(auxMissai + " - " + habilidade);
            auxMissai++;
        }
        if (auxMissai == 3){
            System.out.println("Sobrevivente já possui 3 habilidades.");
            return;
        }
        String h = "";
        
        while (true) {
            prints.habilidadesDisponiveis();
            System.out.println("Digite numero correspondente a habilidade que deseja adicionaraaa: ");
            int habilidade = scanner.nextInt();
            if (habilidade < 1 || habilidade > HabilidadesDisponivel.values().length) {
                System.out.println("Habilidade inválida, tente novamente.");
            } else {
                h = HabilidadesDisponivel.values()[habilidade - 1].toString();
                if (sobrevivente.getHabilidades().contains(h)){
                    System.out.println("Habilidade " + h + " já adicionada, tente novamente.");                    
                }
                else{
                    break;
                }
            }
        }
        System.out.println("Habilidade: "+ h + " adicionada com sucesso");
        sobrevivente.addHabilidade(h);

    }
    public static void removerHabilidade(Scanner scanner, List<Sobrevivente> sobreviventes){
        if (sobreviventes.isEmpty()) {
            System.out.println("Nenhum sobrevivente cadastrado");
            return;
        }
        System.out.println("Deseja imprimir os sobreviventes cadastrados? (s/n)");
        String imprimir = scanner.nextLine().toLowerCase();
        if (imprimir.equals("s")) { //aqui temos um if para verificar se o usuario deseja imprimir os sobreviventes
            prints.imprimirSobreviventes(sobreviventes);
        }

        System.out.println("Digite o ID do sobrevivente que deseja remover uma habilidade: ");
        String ID = scanner.nextLine();
        Sobrevivente sobrevivente = null;

        for (Sobrevivente s: sobreviventes){
            if(s.getID().equals(ID)){
                sobrevivente = s;
                System.out.println("Sobrevivente "+ s.getNomePessoa() + " encontrado: ");
                break;
            }   
        }
        if (sobrevivente == null){
            System.out.println("Sobrevivente não encontrado");
            return;
        }

        
        if (sobrevivente.getHabilidades().isEmpty()) {
            System.out.println("Sobrevivente não possui habilidades.");
            return;
        }
        
        
        String h = "";
        while (true) {
            
            int auxMissai = 0;
            for (String habilidade : sobrevivente.getHabilidades()){
                System.out.println(auxMissai + 1 + " - " + habilidade);
                auxMissai++;
            }
            System.out.println("Digite o numero correspondente a habilidade que deseja remover: ");
            int indiceHabilidade = scanner.nextInt();
            indiceHabilidade--;
            if (indiceHabilidade < 0 || indiceHabilidade >= sobrevivente.getHabilidades().size()) {
                System.out.println("Habilidade inválida, tente novamente.");
            } else {
                
                h = sobrevivente.getHabilidades().get(indiceHabilidade);
                break;
            }
        }

        System.out.println("Habilidade: "+ h + " removida com sucesso");
        sobrevivente.getHabilidades().remove(h);
    }

    public static Recursos adicionarRecurso(Scanner scanner, Vault vault, String auxNome, int auxQuantidade){
        int quantidade = auxQuantidade;
        List<Recursos> r = vault.getRecursos();
        String nomeRecuso =auxNome;
        if (auxNome == "") {    
            System.out.println("Digite o tipo de recurso que deseja adicionar: ");
            nomeRecuso = scanner.nextLine();
            for (Recursos recurso : r) {
                if (recurso.getTipo().equals(nomeRecuso)) {
                    System.out.println("Recurso "+ nomeRecuso +" ja encontrada, digite a quantidade encontrada.");
                    quantidade = scanner.nextInt();
                    recurso.addQuantidade(quantidade);
                    System.out.println("Quantidade");
                    return new Recursos(nomeRecuso, quantidade);
                }
            }
        }

        if(quantidade == 0){
            System.out.println("Digite a quantidade do recurso "+ nomeRecuso +" encontrado: ");
            while (true) {
                if (scanner.hasNextInt()) {
                String input = scanner.nextLine(); // Use nextLine() e faça parse manualmente
                quantidade = Integer.parseInt(input);
                    if (quantidade <= 0) {
                        System.out.println("Quantidade inválida. Por favor, digite um número inteiro maior que 0.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                    scanner.next(); // Consumir a entrada inválida
                }
                scanner.nextLine();
            }
        }
        System.out.println("Recurso "+ nomeRecuso + " adicionado com sucesso");
        return new Recursos(nomeRecuso, quantidade);
    }
    public static void consumirRecurso(Scanner scanner, Vault vault){
        List<Recursos> r = vault.getRecursos();
        int quantidade;
        if (r.isEmpty()) {
            System.out.println("Nenhum recurso cadastrado");
            return;
        }
        System.out.println("Digite o tipo de recurso que deseja consumir: ");
        String nomeRecurso = scanner.nextLine();
        Recursos recurso = null;
        for (Recursos rec : r) {
            if (rec.getTipo().equals(nomeRecurso)) {
                recurso = rec;
                break;
            }
        }
        if (recurso == null) {
            System.out.println("Recurso não encontrado");
            return;
        }
        System.out.println("Digite a quantidade que deseja consumir: ");
        while (true) {
            if (scanner.hasNextInt()) {
                quantidade = scanner.nextInt();
                if (quantidade <= 0) {
                    System.out.println("Quantidade inválida. Por favor, digite um número inteiro maior que 0.");
                } else {
                    break;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Consumir a entrada inválida
            }
        }

        if (recurso.getQuantidade() < quantidade) {
            System.out.println("Quantidade insuficiente. Total disponível: " + recurso.getQuantidade());
            return;
        }
        recurso.removeQuantidade(quantidade);
        System.out.println("Recurso "+ nomeRecurso + " consumido com sucesso");        
        
    }
    public static void registrarMissao(Scanner scanner, Vault vault){
        System.out.println("Digite o nome da missão: ");
        String nomeMissao = scanner.nextLine();
        System.out.println("Digite o objetivo da missão: ");
        String objetivo = scanner.nextLine();
        System.out.println("Digite o local da missão: ");
        String local = scanner.nextLine();
        System.out.println("Qual o Status da missão? ");
        String status = "";
        
        while (true) {
            prints.imprimirStatusMissao();
            int statusInt = scanner.nextInt();
            scanner.nextLine();
            if(statusInt < 1 || statusInt > StatusDisponivelMissao.values().length){
                System.out.println("Status inválido, tente novamente.");
            }
            else{
                status = StatusDisponivelMissao.values()[statusInt - 1].toString();
                break;
            }
        }
        
        Missao missao = new Missao();
        missao.setNomeMissao(nomeMissao);
        missao.setObjetivo(objetivo);
        missao.setLocal(local);
        missao.setStatusMissao(status);
        
        System.out.println("Foi coletado algum recurso na missão? (s/n)");
        String resposta = scanner.nextLine().toLowerCase();
        
        if(resposta.equals("s")){
            recursosColetadoMissao(scanner, vault, missao);
        }
    
        System.out.println("Missão: "+ nomeMissao + " registrada com sucesso");
        vault.addMissao(missao);
    }
    
    public static void adicionarSobreviventeMissao(Scanner scanner, Vault vault) {
        if (vault.getMissoes().isEmpty()) {
            System.out.println("Nenhuma missão cadastrada");
            return;
        }
    
        System.out.println("Digite o nome da missão que deseja adicionar o sobrevivente: ");
        String nomeMissao = scanner.nextLine();
        
        boolean missaoEncontrada = false;
        int indiceMissao = -1;
    
        for (int y = 0; y < vault.getMissoes().size(); y++) {
            if (vault.getMissoes().get(y).getNomeMissao().equals(nomeMissao)) {
                missaoEncontrada = true;
                indiceMissao = y;
                break;
            }
        }
    
        if (!missaoEncontrada) {
            System.out.println("Missão " + nomeMissao + " não encontrada");
            return;
        }
    
        Missao missaoSelecionada = vault.getMissoes().get(indiceMissao);
        
        if(missaoSelecionada.detalhesID().size() == 5) {
            System.out.println("Missão já possui 5 sobreviventes");
            return;
        }
    
        System.out.println("Digite o ID do sobrevivente: ");
        String ID = scanner.nextLine();
    
        // Verifica se o ID já está na missão
        if (missaoSelecionada.detalhesID().contains(ID)) {
            System.out.println("Sobrevivente já está na missão");
            return;
        }
    
        // Verifica se o sobrevivente existe
        String nomeSobrevivente = "";
        for (Sobrevivente s : vault.getSobreviventes()) {
            if (s.getID().equals(ID)) {
                nomeSobrevivente = s.getNomePessoa();
                break;
            }
        }
    
        if (nomeSobrevivente.isEmpty()) {
            System.out.println("Sobrevivente não encontrado");
            return;
        }
    
        missaoSelecionada.addID(ID);
        System.out.println("Sobrevivente " + nomeSobrevivente + " adicionado à missão " + nomeMissao + " com sucesso");
    }
    public static void recursosColetadoMissao(Scanner scanner, Vault vault, Missao missao){
        List<Recursos> recursosColetados = new ArrayList<>();
        String continuar;
        
        do {
            System.out.println("Digite o nome do recurso coletado: ");
            String nomeRecurso = scanner.nextLine();
            
            System.out.println("Digite a quantidade do recurso "+ nomeRecurso +" encontrado: ");
            int quantidade = 0;
            while (true) {
                try {
                    quantidade = Integer.parseInt(scanner.nextLine());
                    if (quantidade <= 0) {
                        System.out.println("Quantidade inválida. Por favor, digite um número inteiro maior que 0.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                }
            }
    
            // Adiciona o recurso à missão
            Recursos novoRecurso = new Recursos(nomeRecurso, quantidade);
            recursosColetados.add(novoRecurso);
            
            // Adiciona ou atualiza o recurso no vault
            boolean recursoExistente = false;
            for (Recursos recurso : vault.getRecursos()) {
                if (recurso.getTipo().equals(nomeRecurso)) {
                    recurso.addQuantidade(quantidade);
                    recursoExistente = true;
                    break;
                }
            }
            
            if (!recursoExistente) {
                vault.setRecurso(new Recursos(nomeRecurso, quantidade));
            }
    
            System.out.println("Deseja adicionar mais recursos? (s/n)");
            continuar = scanner.nextLine().toLowerCase();
        } while (continuar.equals("s"));
        
        missao.setRecursosColetados(recursosColetados);
    }
}