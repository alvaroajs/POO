import java.util.LinkedList;
import java.util.Queue;

public class FilaEntradaPacotes {
    private Queue<Pacote> fila = new LinkedList<>();

    public void adicionarPacote(Pacote pacote) {
        fila.add(pacote);
    }

    public boolean filaVazia(){
        if(fila.isEmpty()){
            return true;
        }
        return false;

    }
    public Pacote removerPacote() {
        return fila.poll();
    }
    public void exibirFila(){
        System.out.println(fila);
    }
}
