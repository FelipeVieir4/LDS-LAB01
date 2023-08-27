import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaOfertada extends Disciplina {
    private Professor professor;
    private boolean estaAtivo;
    private int anoOfertado;
    private int semestreOfertado;
    private List<Aluno> alunos;

    public DisciplinaOfertada(String nome, int codigo, Integer credito,
            BigDecimal valorCustoHora, EnumTipoDisciplina tipo,
            Professor professor, boolean estaAtivo,
            int anoOfertado, int semestreOfertado) {
        super(valorCustoHora, nome, credito, valorCustoHora, tipo);
        this.professor = professor;
        this.estaAtivo = estaAtivo;
        this.anoOfertado = anoOfertado;
        this.semestreOfertado = semestreOfertado;
        this.alunos = new ArrayList<>();
    }

    public DisciplinaOfertada() {
        super();
    }

    public int verificarTotalAlunos() {
        return (Integer) null;
    }
}
