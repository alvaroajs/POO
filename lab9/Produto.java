public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private int estoque;

    public Produto(int codigo, String descricao, double preco, int estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }
    public Produto(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = 10;
        this.estoque = 5;
    }

    public void reduzirEstoque(int quantidade){
       
        this.estoque -= quantidade;
        
       
    }

    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public double getPreco() {
        return preco;
    }
    public int getEstoque() {
        return estoque;
    }
    public String toString(){
        return "Código: " + codigo + " Descrição: " + descricao + " Preço: " + preco + " Estoque: " + estoque;
    }
    
}
