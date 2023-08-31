package ModelController;

import java.util.ArrayList;

/**
 * Representa uma turma de um curso.
 */
public class Turma implements ICSV {
    private static final int MAX_MATRICULAS = 60; // Máximo de matrículas permitidas
    private static int proximoId = 5000;
    private int id;
    private String professor;
    private String disciplina;
    private boolean estaAtivo;
    private int anoOfertado;
    private int semestreOfertado;
    private ArrayList<Integer> matriculas = new ArrayList<Integer>();
    private int valorCustoSemestre;

    /**
     * Cria uma nova instância de Turma com um ID gerado automaticamente.
     *
     * @param professor          O nome do professor da turma.
     * @param disciplina         O nome da disciplina da turma.
     * @param estaAtivo          Indica se a turma está ativa.
     * @param anoOfertado        O ano em que a turma foi oferecida.
     * @param semestreOfertado   O semestre em que a turma foi oferecida.
     * @param valorCustoSemestre O valor de custo do semestre.
     * @throws IllegalArgumentException Se o professor, disciplina forem nulos,
     *                                  anoOfertado ou semestreOfertado forem
     *                                  inválidos.
     */
    public Turma(String professor, String disciplina, int anoOfertado, int semestreOfertado, int valorCustoSemestre) {
        validarParametros(professor, disciplina, anoOfertado, semestreOfertado);
        this.professor = professor;
        this.disciplina = disciplina;
        this.estaAtivo = true;
        this.anoOfertado = anoOfertado;
        this.semestreOfertado = semestreOfertado;
        this.valorCustoSemestre = valorCustoSemestre;
        this.id = proximoId;
        proximoId++;
    }

    /**
     * Cria uma nova instância de Turma com um ID especificado.
     *
     * @param id                 O ID da turma.
     * @param professor          O nome do professor da turma.
     * @param disciplina         O nome da disciplina da turma.
     * @param anoOfertado        O ano em que a turma foi oferecida.
     * @param semestreOfertado   O semestre em que a turma foi oferecida.
     * @param valorCustoSemestre O valor de custo do semestre.
     * @throws IllegalArgumentException Se o ID for inválido, o professor ou
     *                                  disciplina forem nulos,
     *                                  anoOfertado ou semestreOfertado forem
     *                                  inválidos.
     */
    public Turma(int id, String professor, String disciplina, int anoOfertado, int semestreOfertado,
            int valorCustoSemestre) {
        validarParametros(professor, disciplina, anoOfertado, semestreOfertado);
        if (id < 0) {
            throw new IllegalArgumentException("O ID da turma não pode ser menor que 0.");
        }
        this.id = id;
        this.professor = professor;
        this.disciplina = disciplina;
        this.estaAtivo = true;
        this.anoOfertado = anoOfertado;
        this.semestreOfertado = semestreOfertado;
        this.valorCustoSemestre = valorCustoSemestre;
    }

    /**
     * Valida os parâmetros do construtor.
     *
     * @param professor        O nome do professor da turma.
     * @param disciplina       O nome da disciplina da turma.
     * @param anoOfertado      O ano em que a turma foi oferecida.
     * @param semestreOfertado O semestre em que a turma foi oferecida.
     * @throws IllegalArgumentException Se o professor, disciplina forem nulos,
     *                                  anoOfertado ou semestreOfertado forem
     *                                  inválidos.
     */
    private void validarParametros(String professor, String disciplina, int anoOfertado, int semestreOfertado) {
        if (professor == null) {
            throw new IllegalArgumentException("O nome do professor não pode ser nulo.");
        }
        if (disciplina == null) {
            throw new IllegalArgumentException("O nome da disciplina não pode ser nulo.");
        }
        if (anoOfertado < 1900 || anoOfertado > 2100) {
            throw new IllegalArgumentException("O ano de oferta é inválido.");
        }
        if (semestreOfertado < 1 || semestreOfertado > 2) {
            throw new IllegalArgumentException("O semestre de oferta é inválido.");
        }
    }

    public void adicionarMatricula(int id) throws RuntimeException {
        if (!matriculas.contains(id) & this.matriculas.size() <= MAX_MATRICULAS) {
            matriculas.add(id);
        } else {
            throw new RuntimeException("Turma lotada");
        }
    }

    public void removerMatricula(int id) {
        if (matriculas.contains(id)) {
            matriculas.remove(id);
        }
    }

    public void validarTurma() {
        int totalAlunos = this.matriculas.size();
        if (totalAlunos < 3) {
            this.estaAtivo = false;
        }
    }

    public int getId() {
        return id;
    }

    public String getProfessor() {
        return professor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public boolean isEstaAtivo() {
        return estaAtivo;
    }

    public int getAnoOfertado() {
        return anoOfertado;
    }

    public int getSemestreOfertado() {
        return semestreOfertado;
    }

    public ArrayList<Integer> getMatriculas() {
        return matriculas;
    }

    public int getValorCustoSemestre() {
        return valorCustoSemestre;
    }

    @Override
    public String toCSV() {
        // TODO aplicar a lógica para gerar o csv
        throw new UnsupportedOperationException("Unimplemented method 'toCSV'");
    }

}
