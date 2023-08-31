package ModelController;

import java.util.ArrayList;

/**
 * Representa um professor com informações básicas como nome, login e senha.
 */
public class Professor extends Pessoa {

    /**
     * Construtor para criar um objeto Professor.
     *
     * @param login O login do professor.
     * @param senha A senha do professor.
     * @param nome  O nome do professor.
     * @throws IllegalArgumentException Se os parâmetros fornecidos forem inválidos
     *                                  (nulos ou vazios).
     */
    public Professor(String login, String senha, String nome) throws IllegalArgumentException {
        super(login, senha, nome);
    }

    /**
     * Construtor para criar um objeto Professor com um ID especificado.
     *
     * @param id    O ID do professor.
     * @param login O login do professor.
     * @param senha A senha do professor.
     * @param nome  O nome do professor.
     * @throws IllegalArgumentException Se o ID for menor que 0 ou se os outros
     *                                  parâmetros fornecidos forem inválidos
     *                                  (nulos ou vazios).
     */
    public Professor(int id, String login, String senha, String nome) throws IllegalArgumentException {
        super(id, login, senha, nome);
    }

    /**
     * Lista as disciplinas em que o professor está matriculado em um determinado ano e semestre.
     *
     * @param ano      O ano a ser considerado.
     * @param semestre O semestre a ser considerado.
     * @return Uma lista de disciplinas em que o professor está matriculado.
     */
    public ArrayList<Disciplina> listarTurmasMatriculadas(int ano, int semestre) {
        ArrayList<Disciplina> lista = new ArrayList<Disciplina>();

        // TODO aplicar lógica para buscar disciplinas em que o professor está matriculado.

        return lista;
    }

    /**
     * Lista os alunos matriculados em uma determinada disciplina.
     *
     * @param disc A disciplina em que se deseja listar os alunos.
     * @return Uma lista de alunos matriculados na disciplina.
     */
    public ArrayList<Aluno> listarAlunosMatriculadosNaTurma(Disciplina disc) {
        ArrayList<Aluno> lista = new ArrayList<Aluno>();

        // TODO aplicar lógica para buscar alunos na turma selecionada
        
        return lista;
    }

    @Override
    public String toCSV() {
        // Implementar o toCSV para a classe DAO salvar o objeto.
        throw new UnsupportedOperationException("Unimplemented method 'toCSV'");
    }
}
