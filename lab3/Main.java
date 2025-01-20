import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){


        int op ;
        boolean profEncontrado = false; //boolean que vai ajudar na parte de encontrar o prof
        
        List<Professor> professores = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();


        
        
        Scanner scanner = new Scanner(System.in);
        
        do{
            
            System.out.println("\nQual opção desejava ?");
            System.out.println("1 --> Cadastrar professor.");
            System.out.println("2 --> Cadastrar aluno.");
            System.out.println("3 --> Cadastrar disciplina.");
            System.out.println("4 --> Imprimir professores..");
            System.out.println("5 --> Imprimir alunos.");
            System.out.println("6 --> Imprimir disciplinas.");
            System.out.println("0 --> Sair.");

            op = scanner.nextInt();
            scanner.nextLine();
            
            switch (op) {
                case 1:
                    //Cadastrar prof
                    System.out.print("Digite o nome do professor: "); 
                    String nomeProf = scanner.nextLine();

                    System.out.print("Digite sua titulação: ");
                    String titulaçãoProf = scanner.nextLine();

                    System.out.print("Digite seu endereço: ");
                    String endereçoProf = scanner.nextLine();

                    Professor professor = new Professor(nomeProf, endereçoProf, titulaçãoProf);
                    professores.add(professor);




                    break;
            
                case 2:
                    //cadastrar aluno

                    System.err.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();

                    System.err.print("Digite seu endereço: ");
                    String enderecoAluno = scanner.nextLine();
                    
                    System.err.print("Digite sua matricula: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();

                    Aluno aluno = new Aluno(nomeAluno, enderecoAluno, matricula);
                    alunos.add(aluno);

                    break;

                case 3:
                    //cadastrar disciplina
                    if (professores.isEmpty()){
                        System.out.println("Nenhum professor cadastro, tente cadastrar um professor antes de cadastrar uma disciplina. ");
                    }
                    
                    else{
                    System.out.print("Digite a disciplina: ");
                    String nomeDisciplina = scanner.nextLine();

                    System.out.print("Digite o professor: ");
                    String nomeProfDisicplina = scanner.nextLine();

                    System.out.print("Digite sua carga horária: ");
                    int CH = scanner.nextInt();
                    scanner.nextLine();// carregar o buffer

                    profEncontrado = false;
                        
                    for (Professor aux : professores) {
                        if (aux.getNome().equals(nomeProfDisicplina)) {
                            Disciplina disciplina = new Disciplina(nomeDisciplina, CH, aux);
                            disciplinas.add(disciplina);
                            profEncontrado = true;  // Marca que o professor foi encontrado.
                            break;  // Sai do laço quando o professor é encontrado.
                        }
                    }
            
                    // Verifica se o professor foi encontrado e exibe a mensagem correspondente.
                    if (profEncontrado) {
                        System.out.println("Disciplina " + nomeDisciplina + " cadastrada com sucesso com o professor " + nomeProfDisicplina + ".");
                    } else {
                        System.out.println("Professor " + nomeProfDisicplina + " não encontrado.");
                    }
                    }

                    break;
                case 4:
                    //Imprimir professores
                    if(professores.isEmpty()){
                        System.out.println("Nenhum professor cadastrado.");
                    }
                    else{
                        for(Professor aux : professores){
                            System.out.println();
                            System.out.println("Professor: " + aux.getNome());
                            System.out.println("Endereco: " + aux.getEndereco());
                            System.out.println("Titulação: " + aux.getTitulação());

                        }
                    }
                    break;
                case 5:
                    //imprimir alunos
                    if(alunos.isEmpty()){
                        System.out.println("Nenhum aluno cadastrado.");
                    }
                    else{
                        for(Aluno aux : alunos){
                            System.out.println();
                            System.out.println("Aluno: " + aux.getNome());
                            System.out.println("Endereço: " + aux.getEndereco());
                            System.out.println("Matricula: " + aux.getMatricula());
                        }
                    }

                    break;
                case 6:
                    //Impri disciplinas

                    if(disciplinas.isEmpty()){
                        System.out.println("Nenhuma disciplina cadastrada.");
                    }
                    else{
                        for(Disciplina aux : disciplinas){
                            System.out.println();
                            System.out.println("Disciplina: "+ aux.getNomeDisciplina());
                            System.out.println("Carga horária: " + aux.getCargaHoraria());
                            System.out.println("Professor: " + aux.getNomeProfessorDisciplina());


                        }
                    }
                    break;

                case 0:
                    System.err.println("Saindo...");
                    //sair

                    break;
                default:
                    System.err.println("Opção " + op + " invalida.");
                    break;
            }
            
            
            
        }while (op != 0);
        scanner.close();

    }
}