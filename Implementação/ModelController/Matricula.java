package ModelController;

/**
 * Representa uma matrícula em um curso.
 */
public class Matricula {
    private static int proximoId = 9000;
    private int id;
    private String curso;

    /**
     * Cria uma nova instância de Matricula com um ID gerado automaticamente.
     *
     * @param curso O nome do curso.
     * @throws IllegalArgumentException Se o curso for nulo ou vazio.
     */
    public Matricula(String curso) {
        validarParametros(curso);
        this.id = proximoId;
        proximoId++;
        this.curso = curso;
    }

    /**
     * Cria uma nova instância de Matricula com um ID especificado.
     *
     * @param id    O ID da matrícula.
     * @param curso O nome do curso.
     * @throws IllegalArgumentException Se o ID for menor que 0 ou se o curso for nulo ou vazio.
     */
    public Matricula(int id, String curso) {
        validarParametros(curso);
        if (id < 0) {
            throw new IllegalArgumentException("O ID da matrícula não pode ser menor que 0.");
        }
        this.id = id;
        this.curso = curso;
    }

    /**
     * Valida os parâmetros do construtor.
     *
     * @param curso O nome do curso.
     * @throws IllegalArgumentException Se o curso for nulo ou vazio.
     */
    private void validarParametros(String curso) {
        if (curso == null || curso.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do curso não pode ser nulo ou vazio.");
        }
    }

    /**
     * Obtém o ID da matrícula.
     *
     * @return O ID da matrícula.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o nome do curso.
     *
     * @return O nome do curso.
     */
    public String getCurso() {
        return curso;
    }


}
