import java.math.BigDecimal;
import java.util.List;

public class DisciplinaOfertada extends Disciplina {
    private Professor professor;
    private boolean estaAtivo;
    private int anoOfertado;
    private int semestreOfertado;
    private List<Aluno> alunos;

    public DisciplinaOfertada(String nome, Integer credito, BigDecimal valorCustoHora, EnumTipoDisciplina tipo,
            Professor professor, boolean estaAtivo, int anoOfertado, int semestreOfertado, List<Aluno> alunos) {
        super(nome, credito, valorCustoHora, tipo);
        this.professor = professor;
        this.estaAtivo = estaAtivo;
        this.anoOfertado = anoOfertado;
        this.semestreOfertado = semestreOfertado;
        this.alunos = alunos;
    }

    public DisciplinaOfertada(Professor professor, boolean estaAtivo, int anoOfertado, int semestreOfertado,
            List<Aluno> alunos) {
        this.professor = professor;
        this.estaAtivo = estaAtivo;
        this.anoOfertado = anoOfertado;
        this.semestreOfertado = semestreOfertado;
        this.alunos = alunos;
    }

    public DisciplinaOfertada() {

    }

    public int verificarTotalAlunos() {
        return alunos.size();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public boolean isEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public int getAnoOfertado() {
        return anoOfertado;
    }

    public void setAnoOfertado(int anoOfertado) {
        this.anoOfertado = anoOfertado;
    }

    public int getSemestreOfertado() {
        return semestreOfertado;
    }

    public void setSemestreOfertado(int semestreOfertado) {
        this.semestreOfertado = semestreOfertado;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
