import java.util.List;
import java.util.ArrayList;


public class Missao {
    private String nomeMissao = "";
    private String objetivo = "";
    private String local = "";
    private String status = "";
    private List<String> ID = new ArrayList<>();
    private List<Recursos> recursosColetados = new ArrayList<>();

    public Missao(){
        
    }
    public void setNomeMissao(String nomeMissao){
        this.nomeMissao = nomeMissao;
    }
    public String getNomeMissao(){
        return nomeMissao;
    }

    public void setObjetivo(String objetivo){
        this.objetivo = objetivo;
    }
    public String getObjetivo(){
        return objetivo;
    }

    public void setLocal(String local){
        this.local = local;
    }
    public String getLocal(){
        return local;
    }

    public void setStatusMissao(String status){
        this.status = status;
    }
    public String getStatusMissao(){
        return status;
    }

    public void addID(String ID){
        this.ID.add(ID);
        System.out.println(ID + " adicionado com sucesso");
        
    }
    public List<String> detalhesID(){
        return ID;
    }
    
   

    public void setRecursosColetados(List<Recursos> recursoColetado){
        this.recursosColetados = recursoColetado;
    }
    public List<Recursos> getRecursosColetados(){
        return recursosColetados;
    }
    public String toString() {
        
        
        return "\nNome da Missão: " + nomeMissao + 
               ", Objetivo: " + objetivo + 
               ", Local: " + local + 
               ", Status: " + getStatusMissao() +
               ", \nIDs: " + detalhesID() + 
               "\nRecursos coletados:" + recursosColetados;
    }
}
