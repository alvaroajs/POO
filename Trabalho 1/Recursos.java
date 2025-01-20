

public class Recursos{
    private String tipo;
    private int quantidade;
    public Recursos(String tipo, int quantidade){
        this.tipo = tipo;
        this.quantidade = quantidade;
    }
    public String getTipo(){
        return tipo;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public void addQuantidade(int quantidade){
        this.quantidade += quantidade;
    }
    public void removeQuantidade(int quantidade){
        this.quantidade -= quantidade;
    }
    public String toString(){
        return "Tipo: " + tipo + ", Quantidade: " + quantidade + ".";
    }
    
}
