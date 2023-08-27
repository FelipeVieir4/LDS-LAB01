import java.math.BigDecimal;
import java.util.List;

public class Curso {
    private static BigDecimal ultimoId = BigDecimal.ZERO;
    private BigDecimal id;
    private String nome;
    private List<Disciplina> disciplinas;

    public BigDecimal getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Curso(String nome, List<Disciplina> disciplinas) {
        this.id = getNextId(); // Obtém o próximo ID autoincrementado
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public Curso() {

    }

    // Método para obter o próximo ID autoincrementado
    private static synchronized BigDecimal getNextId() {
        ultimoId = ultimoId.add(BigDecimal.ONE);
        return ultimoId;
    }

    public Disciplina adicionarDisciplina(Disciplina disciplina) {
        return null;
    }

    public Disciplina removerDisciplina(Disciplina disciplina) {
        return null;
    }

    public List<Disciplina> listarDisciplinas(Disciplina disciplina) {
        return null;
    }
}
