package DAO;

import java.io.IOException;

import ModelController.Aluno;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Aluno.
 */
public class AlunoDAO {

    private static final String CAMINHO_ARQUIVO_ALUNO = "./DB/alunos.csv";

    /**
     * Salva uma turma em um arquivo CSV.
     *
     * @param turmas A turma a ser salva.
     * @throws IOException Se ocorrer um erro ao salvar o arquivo.
     */
    public void salvarTurma(Aluno aluno) throws IOException {
        String alunoCSV = aluno.toCSV();
        Util.salvarNoArquivo(CAMINHO_ARQUIVO_ALUNO, alunoCSV);
    }
}
