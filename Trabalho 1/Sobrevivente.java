import java.util.List;


enum StatusDisponivel {
    Ativo,
    Doente,
    Ferido,
    Morto;
}

public class Sobrevivente extends Pessoa {
    private List<String> habilidades;
    private String status;
    
    public Sobrevivente(String nomePessoa, int idadePessoa, String ID, List<String> habilidades, String status) {
        super(nomePessoa, idadePessoa, ID);
        this.habilidades = habilidades;
        this.status = status;
    }
    public void sethabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }
    public void addHabilidade(String habilidade) {
        this.habilidades.add(habilidade);
    }

    public String getStatus() {
        return status;
    }
    

    @Override
    public String toString() {
        return super.getDetalhes() + ", Status: " + status + ", Habilidades: " + habilidades + ".\n";
    }
    
} 