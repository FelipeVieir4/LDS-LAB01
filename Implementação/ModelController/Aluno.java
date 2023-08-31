package ModelController;

import java.util.ArrayList;

/**
 * Classe que representa um aluno, derivada da classe Pessoa.
 */
public class Aluno extends Pessoa {

    private ArrayList<Matricula> matriculas = new ArrayList<Matricula>();

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
     * Adiciona uma matrícula à lista de matrículas do aluno.
     *
     * @param mat A matrícula a ser adicionada.
     */
    public void adicionarMatricula(Matricula mat) {
        matriculas.add(mat);
    }

    @Override
    public String toCSV() {
        // Implementar o toCSV para a classe DAO salvar o objeto.
        throw new UnsupportedOperationException("Unimplemented method 'toCSV'");
    }
}
