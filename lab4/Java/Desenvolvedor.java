public class Desenvolvedor extends Funcionario implements InterfaceDesenvolvedor {
    private String linguagemPrincipal;
    private int qtdProjetos;

    public Desenvolvedor(String nomeFuncionario, float salarioFuncionario, String linguagemPrincipal, int qtdProjetos) {
        super(nomeFuncionario, salarioFuncionario);
        this.linguagemPrincipal = linguagemPrincipal;
        this.qtdProjetos = qtdProjetos;
    }
    public String getLinguagemPrincipal(){
        return linguagemPrincipal;
    }
    public String projetosRealizados(){
        return "Desenvolvedor realizou " + qtdProjetos + " projetos na linguagem: " + linguagemPrincipal;
    }
    @Override
    public String descricao() {
        return super.descricao() + ", Linguagem Principal: " + linguagemPrincipal;
    }
}
