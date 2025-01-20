public class Professor extends Pessoa {
    private String titulacao;

    public Professor(String nome, String endereco, String titulacao){
        super(nome, endereco);
        this.titulacao = titulacao;

    }

    public String getTitulação(){
        return titulacao;
    }
}