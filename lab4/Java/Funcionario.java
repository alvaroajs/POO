public class Funcionario {
    protected String nomeFuncionario;
    protected float salarioFuncionario;

    public Funcionario(String nomeFuncionario, float salarioFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }

    public String descricao(){
        return "Nome: " + nomeFuncionario + " - Salário: " + salarioFuncionario;
    }
}
