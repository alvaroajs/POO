public class Motorista {
    private String nome;
    private String CPF;
    private String habilitação;

    public Motorista(String nome, String CPF, String habilitação) {
        this.nome = nome;
        this.CPF = CPF;
        this.habilitação = habilitação;
    }
    public String getNome() {
        return nome;
    }
    public String getCPF() {
        return CPF;
    }
    public String getHabilitação() {
        return habilitação;
    }
    public String getDetalhes() {
        return "Motorista: " + nome + " CPF: " + CPF + " Habilitação: " + getHabilitação() + ".";
    }
}
