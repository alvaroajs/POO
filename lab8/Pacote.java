public class Pacote {
    private String codigoPostal;
    private String descricao;
    private int prioridade;
    private String cpf;

    public Pacote(String codigoPostal, String descricao, int prioridade, String cpf) {
        this.codigoPostal = codigoPostal;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.cpf = cpf;
    }
    public String toString() {
        return "Código Postal: " + codigoPostal + ", Descrição: " + descricao + ", Prioridade: " + prioridade + ", CPF: " + cpf + ".";
    }
}
