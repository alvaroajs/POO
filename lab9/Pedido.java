import java.util.ArrayList;
import java.util.List;
public class Pedido {

    private int codigoPedido;
    private String clienteNome;
    private List<Produto> itens = new ArrayList<Produto>();
    private double total;
    private List<Integer> quant = new ArrayList<Integer>();

    public Pedido(int codigoPedido, String clienteNome) {
        this.codigoPedido = codigoPedido;
        this.clienteNome = clienteNome;

    }

    public void adicionarProduto(Produto produto, int quantidade) {
        System.out.println("Entrou no adicionar produto");
        this.itens.add(produto);
        this.quant.add(quantidade);
        this.total += produto.getPreco() * quantidade;
    }
    public String getDescricaoPedido(){
        String s = "";
        for(int i = 0; i < itens.size(); i++){
            s +=  "Descrição: " + itens.get(i).getDescricao() + ", " + quant.get(i) + " unidades,  Preço: "  +  itens.get(i).getPreco() + "\n";
        }
        return s;
    }
    public String toString(){
        return "\nCódigo do pedido: " + codigoPedido  + ", Cliente: " + clienteNome + "\n" + "Itens: \n" + getDescricaoPedido() + "Total: " + total;

    }


}