public class Aluno extends Pessoa{
    private int matricula;

    public Aluno(String nome, String endereco, int matricula){
        super(nome, endereco); //super tem que sempre ser chamado antes da atribuição dentro da classe.
        this.matricula = matricula;
    }
    public int getMatricula(){
        return matricula;
    }


}