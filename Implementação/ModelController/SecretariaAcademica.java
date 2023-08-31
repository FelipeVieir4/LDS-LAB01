package ModelController;

/**
 * Representa a secretaria acadêmica com informações básicas como nome, login e senha.
 */
public class SecretariaAcademica extends Pessoa {

    /**
     * Construtor para criar um objeto SecretariaAcademica com um ID gerado automaticamente.
     *
     * @param login O login da secretaria acadêmica.
     * @param senha A senha da secretaria acadêmica.
     * @param nome  O nome da secretaria acadêmica.
     * @throws IllegalArgumentException Se os parâmetros fornecidos forem inválidos
     *                                  (nulos ou vazios).
     */
    public SecretariaAcademica(String login, String senha, String nome) throws IllegalArgumentException {
        super(login, senha, nome);
    }

    /**
     * Construtor para criar um objeto SecretariaAcademica com um ID especificado.
     *
     * @param id    O ID da secretaria acadêmica.
     * @param login O login da secretaria acadêmica.
     * @param senha A senha da secretaria acadêmica.
     * @param nome  O nome da secretaria acadêmica.
     * @throws IllegalArgumentException Se o ID for menor que 0 ou se os outros
     *                                  parâmetros fornecidos forem inválidos
     *                                  (nulos ou vazios).
     */
    public SecretariaAcademica(int id, String login, String senha, String nome) throws IllegalArgumentException {
        super(id, login, senha, nome);
    }

    /**
     * Cadastra um novo curso no sistema.
     *
     * @param curso O curso a ser cadastrado.
     */
    public void cadastrarCurso(Curso curso) {
        // TODO aplicar lógica para DAO salvar o curso
    }

    /**
     * Cria uma nova turma no sistema.
     *
     * @param turma A turma a ser criada.
     */
    public void criarTurma(Turma turma) {
        // TODO aplicar lógica para DAO salvar uma turma
    }

    /**
     * Cadastra um novo aluno no sistema.
     *
     * @param aluno O aluno a ser cadastrado.
     */
    public void cadastrarAluno(Aluno aluno) {
        // TODO aplicar lógica para DAO salvar um aluno
    }

    /**
     * Matricula um aluno em uma turma.
     *
     * @param turma     A turma em que o aluno será matriculado.
     * @param matricula A matrícula do aluno.
     */
    public void matricularAluno(Turma turma, Matricula matricula) {
        // TODO aplicar lógica para DAO salvar uma matrícula num aluno
    }

    /**
     * Cobra a mensalidade de todos os alunos matriculados.
     */
    public void cobrarMensalidade() {
        // TODO aplicar lógica para cobrar mensalidade de todas as matrículas
    }

    /**
     * Valida a quantidade de alunos nas turmas de um determinado ano e semestre.
     *
     * @param ano      O ano a ser considerado.
     * @param semestre O semestre a ser considerado.
     */
    public void validarTurmas(int ano, int semestre) {
        // TODO aplicar lógica para percorrer todas as turmas do semestre e validar a quantidade de alunos.
    }

    @Override
    public String toCSV() {
        // Implementar o toCSV para a classe DAO salvar o objeto.
        throw new UnsupportedOperationException("Unimplemented method 'toCSV'");
    }
}
