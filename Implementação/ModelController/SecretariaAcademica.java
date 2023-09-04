package ModelController;

import java.io.IOException;

import DAO.CursoDAO;

/**
 * Representa a secretaria acadêmica com informações básicas como nome, login e
 * senha.
 */
public class SecretariaAcademica extends Pessoa {

    /**
     * Construtor para criar um objeto SecretariaAcademica com um ID gerado
     * automaticamente.
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
     * @throws IOException
     */
    public void cadastrarCurso(Curso curso) throws IOException {
       
        CursoDAO dao = new CursoDAO();
        dao.salvar(curso);
    }

    /**
     * Cria uma nova turma no sistema.
     *
     * @param turma A turma a ser criada.
     */
    public void criarTurma(Turma turma) {
        // TODO aplicar lógica para DAO salvar uma turma

        /*
         * 1. Deve dar um new constructor com o objeto passado por parametro
         */
    }

    /**
     * Cadastra um novo aluno no sistema.
     *
     * @param aluno O aluno a ser cadastrado.
     */
    public void cadastrarAluno(Aluno aluno) {
        // TODO aplicar lógica para DAO salvar um aluno

        /*
         * 1. Deve dar um new constructor com o objeto passado por parametro
         */
    }

    /**
     * Matricula um aluno em uma turma.
     *
     * @param turma A turma em que o aluno será matriculado.
     * @param id    Id do aluno.
     */
    public void matricularAluno(Turma turma, int id) {
        // TODO aplicar lógica para DAO salvar uma matrícula num aluno

        /*
         * 1. Deve atribuir os parametros em variaveis
         * 2. Deve checar se a turma contem mais de 60 alunos
         * 3. inserir a matricula na turma
         * 4. realizar um +1 na quantidade da turma
         */
    }

    /**
     * Cobra a mensalidade de todos os alunos matriculados.
     */
    public void cobrarMensalidade() {
        // TODO aplicar lógica para cobrar mensalidade de todas as matrículas

        /*
         * 1. Buscar do csv todos os alunos
         * 2. Atribuir a uma lista
         * 3. Notificar o aluno da mensalidade
         */
    }

    /**
     * Valida a quantidade de alunos nas turmas de um determinado ano e semestre.
     *
     * @param ano      O ano a ser considerado.
     * @param semestre O semestre a ser considerado.
     */
    public void validarTurmas(int ano, int semestre) {
        // TODO aplicar lógica para percorrer todas as turmas do semestre e validar a
        // quantidade de alunos.

        /*
         * 1. Buscar todas as turmas do csv
         * 2. Pesquisar nesse list as turmas que contem os parametros passados
         * 3. Verificar se cada turma tem - de 3 alunos ou + 60
         * 4. caso aconteça deve DESATIVAR a turma
         */
    }

    @Override
    public String toCSV() {
        // Implementar o toCSV para a classe DAO salvar o objeto.
        throw new UnsupportedOperationException("Unimplemented method 'toCSV'");
    }
}
