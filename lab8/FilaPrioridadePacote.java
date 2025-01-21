import java.util.LinkedList;
import java.util.Queue;
public class FilaPrioridadePacote{
    private Queue<Pacote> filaPrioridade = new LinkedList<>();
    
    public void adicionarPacote(Pacote pacote) {
        filaPrioridade.add(pacote);
    }

    public boolean filaVazia(){
        if(filaPrioridade.isEmpty()){
            return true;
        }
        return false;

    }
    public Pacote removerPacote() {
        
        return filaPrioridade.poll();
    }
    public void exibirFila(){
        System.out.println(filaPrioridade);
    }
    
}
