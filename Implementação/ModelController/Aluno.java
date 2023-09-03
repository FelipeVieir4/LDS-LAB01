package ModelController;

import java.util.ArrayList;

/**
 * Classe que representa um aluno, derivada da classe Pessoa.
 */
public class Aluno extends Pessoa {

    private String curso;

    /**
     * Construtor para criar um objeto Aluno.
     *
     * @param login O login do aluno.
     * @param senha A senha do aluno.
     * @param nome  O nome do aluno.
     * @throws IllegalArgumentException Se os parâmetros fornecidos forem inválidos
     *                                  (nulos ou vazios).
     */
    public Aluno(String login, String senha, String nome, String curso) throws IllegalArgumentException {
        super(login, senha, nome);
        if (curso.trim().isEmpty()) {
            throw new IllegalArgumentException("O curso não pode ser nulo");
        }
        this.curso = curso;
    }

    /**
     * Construtor para criar um objeto Aluno com um ID.
     *
     * @param id    O ID do aluno.
     * @param login O login do aluno.
     * @param senha A senha do aluno.
     * @param nome  O nome do aluno.
     * @throws IllegalArgumentException Se os parâmetros fornecidos forem inválidos
     *                                  (nulos ou vazios).
     */
    public Aluno(int id, String login, String senha, String nome, String curso) throws IllegalArgumentException {
        super(id, login, senha, nome);
        if (curso.trim().isEmpty()) {
            throw new IllegalArgumentException("O curso não pode ser nulo");
        }
        this.curso = curso;
    }

    /**
     * Retorna uma representação CSV do aluno.
     *
     * @return Uma string no formato CSV que representa o aluno.
     */
    @Override
    public String toCSV() {
        // Implementar o toCSV para a classe DAO salvar o objeto.
        throw new UnsupportedOperationException("Unimplemented method 'toCSV'");
    }
}
