package ModelController;

import java.util.ArrayList;

/**
 * Classe que representa um aluno, derivada da classe Pessoa.
 */
public class Aluno extends Pessoa {

    private ArrayList<Integer> matriculas = new ArrayList<Integer>();

    /**
     * Construtor para criar um objeto Aluno.
     *
     * @param login O login do aluno.
     * @param senha A senha do aluno.
     * @param nome  O nome do aluno.
     * @throws IllegalArgumentException Se os parâmetros fornecidos forem inválidos
     *                                  (nulos ou vazios).
     */
    public Aluno(String login, String senha, String nome) throws IllegalArgumentException {
        super(login, senha, nome);
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
    public Aluno(int id, String login, String senha, String nome) throws IllegalArgumentException {
        super(id, login, senha, nome);
    }

    /**
     * Adiciona uma matrícula à lista de matrículas do aluno.
     *
     * @param mat A matrícula a ser adicionada.
     */
    public void adicionarMatricula(int mat) {
        matriculas.add(mat);
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
