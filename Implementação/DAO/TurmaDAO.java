package DAO;

import ModelController.Turma;
import java.io.IOException;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Turma.
 */
public class TurmaDAO {

    private static final String CAMINHO_ARQUIVO_TURMA = "./DB/turmas.csv";

    /**
     * Salva uma turma em um arquivo CSV.
     *
     * @param turmas A turma a ser salva.
     * @throws IOException Se ocorrer um erro ao salvar o arquivo.
     */
    public void salvarTurma(Turma turma) throws IOException {
        String turmaCSV = turma.toCSV();
        Util.salvarNoArquivo(CAMINHO_ARQUIVO_TURMA, turmaCSV);
    }
}
