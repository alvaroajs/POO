import java.util.List;
import java.util.ArrayList;
public class ListaCliente {
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public void adicionarCliente(String nome, String cpf) {

        clientes.add(new Cliente(nome, cpf));
    }

    public boolean buscarCPF(String cpf){
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public void exibirClientes() {
        System.out.println(clientes);
    }

}
