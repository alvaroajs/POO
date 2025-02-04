import java.util.LinkedList;
import java.util.Queue;

public class FilaPedidos <T>{
    private Queue<T> pedidos;
    
    public FilaPedidos(){
        this.pedidos = new LinkedList<T>();
    }

    public void adicionarPedido(T pedido){
        
        this.pedidos.add(pedido);
        
    }

    public T removerPedido(){
        return this.pedidos.poll();
    }

    public boolean exibirFila(){
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido pendente");
            return false;
        }
        System.out.println("Pedidos pendentes:");
        for(T pedido : pedidos){
            System.out.println(pedido);
        }
        return true;
    }




}