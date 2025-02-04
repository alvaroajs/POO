import java.util.List;
import java.util.ArrayList;
public class ListaProdutos<T extends Produto> {
    private List<T> produtos;

    public ListaProdutos() {
        this.produtos = new ArrayList<T>();
    }

    public void adicionarProduto(T produto){
        this.produtos.add(produto);
    }
    public T buscarProduto(int cod){
        for(T produto : produtos){
            if(produto.getCodigo() == cod){
                return produto;
            }
        }
        
        System.out.println("Produto não encontrado");
        return null;
    }
    public boolean exibirProtudo() {
        if (produtos.isEmpty()) {
            return false;
            
        }
        System.out.println("Produtos cadastrados:");
        for(T produto : produtos){
            System.out.println(produto);
        }
        return true;
    }
    
}
