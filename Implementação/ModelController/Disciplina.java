package ModelController;

/**
 * A classe Disciplina representa uma disciplina acadêmica.
 */
public class Disciplina implements ICSV {
    private static int proximoId = 1; // Variável estática para controlar o próximo ID
    private int id;
    private String nome;
    private int credito;
    private TipoDisciplina tipo;

    /**
     * Construtor para criar uma nova disciplina.
     *
     * @param nome    O nome da disciplina.
     * @param credito O número de créditos da disciplina.
     * @param tipo    O tipo da disciplina.
     * @throws IllegalArgumentException Se os parâmetros forem inválidos.
     */
    public Disciplina(String nome, int credito, TipoDisciplina tipo) {
        validarParametros(nome, credito);

        this.id = proximoId;
        this.nome = nome;
        this.credito = credito;
        this.tipo = tipo;
        proximoId++;
    }

    /**
     * Construtor para criar uma disciplina com um ID específico.
     *
     * @param id      O ID da disciplina.
     * @param nome    O nome da disciplina.
     * @param credito O número de créditos da disciplina.
     * @param tipo    O tipo da disciplina.
     * @throws IllegalArgumentException Se os parâmetros forem inválidos.
     */
    public Disciplina(int id, String nome, int credito, TipoDisciplina tipo) {
        validarParametros(id, nome, credito);

        this.id = id;
        this.nome = nome;
        this.credito = credito;
        this.tipo = tipo;
        proximoId = Math.max(proximoId, id + 1); // Atualiza o próximo ID com base no ID fornecido
    }

    private void validarParametros(String nome, int credito) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da disciplina não pode ser nulo ou vazio.");
        }
        if (credito < 0) {
            throw new IllegalArgumentException("O número de créditos não pode ser menor que 0.");
        }
    }

    private void validarParametros(int id, String nome, int credito) {
        if (id < 1) {
            throw new IllegalArgumentException("O ID da disciplina deve ser maior ou igual a 1.");
        }
        validarParametros(nome, credito);
    }

    /**
     * Obtém o ID da disciplina.
     *
     * @return O ID da disciplina.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o nome da disciplina.
     *
     * @return O nome da disciplina.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o número de créditos da disciplina.
     *
     * @return O número de créditos da disciplina.
     */
    public int getCredito() {
        return credito;
    }

    /**
     * Obtém o tipo da disciplina.
     *
     * @return O tipo da disciplina.
     */
    public TipoDisciplina getTipo() {
        return tipo;
    }

    @Override
    public String toCSV() {
        StringBuilder aux = new StringBuilder();

        return aux.toString();
    }
}
