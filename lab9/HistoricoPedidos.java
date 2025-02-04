import java.util.ArrayList;
import java.util.List;

public class HistoricoPedidos<T extends Pedido> {
    private List<T> pedidos;

    public HistoricoPedidos() {
        this.pedidos = new ArrayList<T>();
    }

    public void adicionarPedido(T pedido){
        this.pedidos.add(pedido);
    }

    public void exibirHistorico(){
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido concluido");
            return;
        }
        System.out.println("Pedidos concluidos:");
        for(T pedido : pedidos){
            System.out.println(pedido);
        }
    }
    
}
