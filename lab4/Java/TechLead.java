public class TechLead extends Funcionario implements InterfaceDesenvolvedor, InterfaceGerente {
    private String linguagemPrincipal;
    private int qtdEquipes;
    private int qtdProjetos;

    public TechLead(String nomeFuncionario, float salarioFuncionario, int qtdEquipes,  String linguagemPrincipal, int qtdProjetos) {
        super(nomeFuncionario, salarioFuncionario);
        this.linguagemPrincipal = linguagemPrincipal;
        this.qtdEquipes = qtdEquipes;
        this.qtdProjetos = qtdProjetos;
    }

    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }

    public String projetosRealizados() {
        return "TechLead realizou " +qtdProjetos + " projetos na linguagem: " + linguagemPrincipal;
    }
    
    public int getQtdEquipe() {
        return qtdEquipes;
    }

    public float bonus() {
        return qtdEquipes * 500;
    }

    @Override
    public String descricao() {
        return super.descricao() + ", Linguagem Principal: " + linguagemPrincipal + ", Equipes: " + qtdEquipes + ", Bônus: " + bonus();
    }   
    
}
