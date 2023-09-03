package DAO;

import ModelController.Aluno;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Aluno.
 */
public class AlunoDAO {

    private static final String FILENAME = "alunos.csv";

    /**
     * Salva uma lista de alunos em um arquivo CSV.
     *
     * @param alunos A lista de alunos a ser salva.
     * @throws IOException Se ocorrer um erro ao salvar o arquivo.
     */
    public void salvar(List<Aluno> alunos) throws IOException {
        FileWriter writer = new FileWriter(FILENAME);

        // Escreve o cabeçalho do arquivo CSV
        writer.append("ID,Login,Senha,Nome\n");

        // Escreve os dados dos alunos no arquivo CSV
        for (Aluno aluno : alunos) {
            writer.append(String.valueOf(aluno.getId()));
            writer.append(',');
            writer.append(aluno.getLogin());
            writer.append(',');
            writer.append(aluno.getSenha());
            writer.append(',');
            writer.append(aluno.getNome());
            writer.append('\n');
        }

        writer.flush();
        writer.close();
    }
}