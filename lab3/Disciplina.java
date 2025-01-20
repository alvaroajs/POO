public class Disciplina{

    private String nomeDisciplina;
    private int CH;
    Professor professor;

    public Disciplina(String nomeDisiciplina, int CH, Professor professor){
        this.nomeDisciplina = nomeDisiciplina;
        this.CH = CH;
        this.professor = professor;

    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getCargaHoraria() {
        return CH;
    }

    public String getNomeProfessorDisciplina() {
        return professor.getNome();
    }
}