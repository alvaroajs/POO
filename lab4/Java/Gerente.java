public class Gerente extends Funcionario implements InterfaceGerente {
    protected int qtdEquipes;

    public Gerente(String nomeFuncionario, float salarioFuncionario, int qtdEquipes) {
        super(nomeFuncionario, salarioFuncionario);
        this.qtdEquipes = qtdEquipes;
    }
    public int getQtdEquipe(){
        return qtdEquipes;
    }

    @Override
    public float bonus(){
        return qtdEquipes * 500;
    }
    @Override
    public String descricao(){
        return super.descricao() + ", Equipes: " + qtdEquipes + ", Bônus: " + bonus();
    }
}