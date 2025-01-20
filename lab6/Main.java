import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        List<Motorista> motoristas = new ArrayList<Motorista>();
        List<Viagem> viagens = new ArrayList<Viagem>();

        int op = 0;

        do{
            menu();
            op = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (op) {
                case 1:
                    //cadastrar motorista
                    System.out.println("Digite o nome do motorista:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do motorista:");
                    String CPF = scanner.nextLine();
                    System.out.println("Digite a habilitação do motorista:");
                    String habilitacao = scanner.nextLine();
                    habilitacao = habilitacao.toUpperCase();
                    Motorista motorista = new Motorista(nome, CPF, habilitacao);
                    motoristas.add(motorista);                   
                    break;
            

                case 2:
                    //adicionar veiculo
                    cadastrarVeiculo(scanner, veiculos);
                    break;
                    
                case 3:
                    //adicionar viagem
                    adicionarViagem(scanner, motoristas, veiculos, viagens);
                    
                    break;
                case 4:
                    //listar motoristas
                    if (motoristas.isEmpty()){
                        System.out.println("Nenhum motorista cadastrado.");
                        break;
                    }
                    for(Motorista m : motoristas){
                        System.out.println(m.getDetalhes());
                    }
                    break;
                case 5:
                    //listar veiculos
                    if (veiculos.isEmpty()){
                        System.out.println("Nenhum veículo cadastrado.");
                        break;
                    }
                    for(Veiculo v : veiculos){
                        System.out.println(v.getDetalhes());
                    }
                    break;
                case 6:
                    //excluir motorista
                    excluirMotorista(scanner, motoristas);
                    break;
                case 7:
                    //excluir veiculo
                    excluirVeiculo(scanner, veiculos);
                    break;
                case 8:
                    if (viagens.isEmpty()){
                        System.out.println("Nenhuma viagem cadastrada.");
                        break;
                    }
                    int ctt = 1;
                    for(Viagem v : viagens){

                        System.out.println("Viagem: " + ctt + " " + v.getDetalhes());
                        ctt = ctt + 1;
                    }                  
                    
                    break;

                case 0: 
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção " + op + " inválida, tente novamente.");
                    break;
            }



        }while(op != 0);
       
        
    }

    private static void cadastrarVeiculo(Scanner scanner, List<Veiculo> veiculos) {
    
    int tipo = 0;


        System.out.println("Escolha o tipo de veículo:");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.println("3 - Caminhão");

        tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a placa do veículo:");
        String placa = scanner.nextLine();
        System.out.println("Digite o modelo do veículo:");
        String modelo = scanner.nextLine();

        try{
            Veiculo veiculo = null;
            switch(tipo){
                case 1:
                    //cadastrar carro
                    System.out.println("Qual o numero de assentos?");
                    int numPassageiros = scanner.nextInt();
                    scanner.nextLine();
                    veiculo = new Carro(placa, modelo, numPassageiros); 
                break;
                case 2:
                    //cadastrar moto
                    System.out.println("Qual a cilindrada?");
                    int cilindrada = scanner.nextInt();
                    scanner.nextLine();
                    veiculo = new Moto(placa, modelo, cilindrada);
                    break;
                case 3:
                    //cadastrar caminhão
                    System.out.println("Qual a capacidade(ton)?");
                    double capacidade = scanner.nextDouble();
                    scanner.nextLine();
                    veiculo = new Caminhao(placa, modelo, capacidade);

                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            if (veiculo != null){
                System.out.println("Veículo cadastrado com sucesso.");
                veiculos.add(veiculo);
            }
            else{
                System.out.println("Erro ao cadastrar veículo.");
            }
        }
        catch(Exception e){
            System.out.println("Erro ao cadastrar veículo: " + e.getMessage());
        }
    }
    private static void excluirMotorista(Scanner scanner, List<Motorista> motoristas) {
        if (motoristas.isEmpty()){
            System.out.println("Nenhum motorista cadastrado.");
            return;
        }
        System.out.println("Digite o CPF do motorista que deseja excluir:");
        String CPF = scanner.nextLine(); // cpf do motorista é string, não necessário do scanner.nextInt()

        for (int i = 0; i < motoristas.size(); i++){
            if (motoristas.get(i).getCPF().equals(CPF)){ // aqui temos um for que percorre todos os motoristas, optei em não usar o for each para poder pegar o indice do motorista que queremos excluir
                System.out.println("Motorista: " + motoristas.get(i).getNome() +" excluído com sucesso.");
                motoristas.remove(i);
                return;
            }
            
        }
        System.out.println("CPF " + CPF + " não encontrado.");
        return;
    }
    private static void excluirVeiculo(Scanner scanner, List<Veiculo> veiculos) {
        if (veiculos.isEmpty()){
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        System.out.println("Digite a placa do veículo que deseja excluir:");
        String placa = scanner.nextLine();

        for (int i = 0; i < veiculos.size(); i++){
            if (veiculos.get(i).getPlaca().equals(placa)){ // aqui temos um for que percorre todos os veiculos, optei em não usar o for each para poder pegar o indice do veiculo que queremos excluir
                System.out.println("Veículo: " + veiculos.get(i).getModelo() + " excluído com sucesso.");
                veiculos.remove(i);
                return;
            }
        }
        System.out.println("Placa " + placa + " não encontrada.");
        return;
    }
    private static void adicionarViagem(Scanner scanner, List<Motorista> motoristas, List<Veiculo> veiculos, List<Viagem> viagens) {
        boolean auxMotorista = false;
        boolean auxVeiculo = false;
        Veiculo v = null;
        Motorista m = null;
        if (motoristas.isEmpty()){
            System.out.println("Nenhum motorista cadastrado para a viagem.");
            auxMotorista = true;
            return;
        }
        if (veiculos.isEmpty()){
            System.out.println("Nenhum veículo cadastrado para a viagem.");
            auxVeiculo = true;   
            return;       
        }
        if (auxMotorista == true && auxVeiculo == true) {
            System.out.println("Tente novamente.");
            return;
        }
        auxMotorista = false; // aqui eu reseto as variaveis auxiliares para poderem ser usadas novamente
        auxVeiculo = false;

        System.out.println("Digite o CPF do motorista da viagem: ");
        String CPF = scanner.nextLine();
        
        for (int i = 0; i < motoristas.size(); i++){
            if (motoristas.get(i).getCPF().equals(CPF)){ // aqui temos um for que percorre todos os motoristas, optei em não usar o for each para poder pegar o indice do motorista que queremos excluir
                System.out.println("Motorista: " + motoristas.get(i).getNome() +" encontrado com sucesso.");
                m = motoristas.get(i);
                auxMotorista = true;
                break;              
            }
        }
        if (auxMotorista == false){
            System.out.println("Motorista não encontrado.");
            return;
        }
        System.out.println("Deseja imprimir todos os veículos cadastrados? (S/N)");
        String opVei = scanner.nextLine();
        opVei = opVei.toUpperCase();
        if (opVei.equals("S")){ // aqui eu imprimo todos os veiculos cadastrados caso o usuario deseje
            for(int i = 0; i < veiculos.size(); i++){
                System.out.println(veiculos.get(i).getDetalhes());
            }            
        }

        System.out.println("Digite a placa do veículo da viagem: ");
        String placa = scanner.nextLine();

        for(int i = 0; i < veiculos.size(); i++){
            if (veiculos.get(i).getPlaca().equals(placa)){
                System.out.println("Veículo: " + veiculos.get(i).getModelo() + " encontrado com sucesso.");
                v = veiculos.get(i);
                auxVeiculo = true;
                break;
            }
        }
        if (auxVeiculo == false){
            System.out.println("Veículo placa: " + placa + "não encontrado.");
            return;            
        }
        if (!m.getHabilitação().equals(v.getHab())){
            System.out.println("Motorista não habilitado para dirigir este veículo.");
            System.out.println("Habilitação do motorista: " + m.getHabilitação() + ", habilitação requerida do veículo: " + v.getHab());  
            return;
        }
    
        System.out.println("Digite a distância da viagem em km: ");
        double distancia = scanner.nextDouble();
        scanner.nextLine();

        Viagem viagem = new Viagem(v, m, distancia);
        viagens.add(viagem);
        System.out.println("Viagem cadastrada com sucesso,");
        System.out.println(viagem.getDetalhes());
        return;
    }

    public static void menu(){
        System.out.println("\nEscollha uma opção listada a baixo:");
            System.out.println("1 - Adicionar motorista.");
            System.out.println("2 - Adicionar veiculo.");
            System.out.println("3 - Adicionar viagem.");
            System.out.println("4 - Exibir motoristas.");
            System.out.println("5 - Exibir carros cadastrados.");
            System.out.println("6 - Excluir motorista.");
            System.out.println("7 - Excluir veiculo.");
            System.out.println("8 - Exibir viagens.");
            System.out.println("0 - Sair.");
    }
}

