import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaOfertada extends Disciplina {
    private static BigDecimal ultimoId = BigDecimal.ZERO; // Variável para controlar o último ID utilizado
    private BigDecimal id; // ID da disciplina ofertada

    private Professor professor;
    private boolean estaAtivo;
    private int anoOfertado;
    private int semestreOfertado;
    private List<Aluno> alunos;

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

    public DisciplinaOfertada(String nome, int codigo, Integer credito,
            BigDecimal valorCustoHora, EnumTipoDisciplina tipo,
            Professor professor, boolean estaAtivo,
            int anoOfertado, int semestreOfertado) {
        super(valorCustoHora, nome, credito, valorCustoHora, tipo);
        this.id = getNextId(); // Obtém o próximo ID autoincrementado
        this.professor = professor;
        this.estaAtivo = estaAtivo;
        this.anoOfertado = anoOfertado;
        this.semestreOfertado = semestreOfertado;
        this.alunos = new ArrayList<>();
    }

    public DisciplinaOfertada() {
        super();
    }

    // Método para obter o próximo ID autoincrementado
    private static synchronized BigDecimal getNextId() {
        ultimoId = ultimoId.add(BigDecimal.ONE);
        return ultimoId;
    }

    public int verificarTotalAlunos() {
        return alunos.size();
    }
}
