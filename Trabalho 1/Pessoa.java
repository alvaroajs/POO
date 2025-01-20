public class Pessoa {

    private String nomePessoa;
    private int idadePessoa;
    private String ID;

    public Pessoa(String nomePessoa, int idadePessoa, String ID) {
        this.nomePessoa = nomePessoa;
        this.idadePessoa = idadePessoa;
        this.ID = ID;
    }
    public String getNomePessoa() {
        return nomePessoa;
    }
    public int getIdadePessoa() {
        return idadePessoa;        
    }
    public String getID() {
        return ID;
    }
    
    public String getDetalhes(){
        return "ID: " + getID() + ", Nome: " + getNomePessoa() + ", Idade: " + idadePessoa + ".";
    }
}