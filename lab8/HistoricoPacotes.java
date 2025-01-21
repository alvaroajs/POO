import java.util.LinkedList;
import java.util.List;;
public class HistoricoPacotes {
    private List<Pacote> historicoPacotes = new LinkedList<>();
    
    public void adicionarAoHistorico(Pacote pacote) {
        historicoPacotes.add(pacote);
    }
    public void exibirHistorico(){
        System.out.println(historicoPacotes);
    }
    
}
