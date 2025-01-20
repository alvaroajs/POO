import java.util.ArrayList;
import java.util.List;

public class Vault {
    
    private List<Sobrevivente> sobreviventes = new ArrayList<>();
    private List<Missao> missoes = new ArrayList<>();
    private List <Recursos> recursos = new ArrayList<>();


    
    public Vault(){
        
    }

    public void addSobrevivente(Sobrevivente sobrevivente) {
        this.sobreviventes.add(sobrevivente);
    }
    
    public List<Sobrevivente> getSobreviventes() {
        return sobreviventes;
    }
    
    public void setRecurso(Recursos recursos){
        this.recursos.add(recursos);
    }
    public List <Recursos> getRecursos(){
        return recursos;
    }

    public void addMissao(Missao missao){
        this.missoes.add(missao);
    }
    public List<Missao> getMissoes(){
        return missoes;
    }

}
