package DAO;

import ModelController.Curso;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Curso.
 */
public class CursoDAO {

    private static final String FILENAME = "cursos.csv";

    /**
     * Salva uma lista de cursos em um arquivo CSV.
     *
     * @param cursos A lista de cursos a ser salva.
     * @throws IOException Se ocorrer um erro ao salvar o arquivo.
     */
    public void salvar(List<Curso> cursos) throws IOException {
        FileWriter writer = new FileWriter(FILENAME);

        // Escreve o cabeçalho do arquivo CSV
        writer.append("ID,Nome\n");

        // Escreve os dados dos cursos no arquivo CSV
        for (Curso curso : cursos) {
            writer.append(String.valueOf(curso.getId()));
            writer.append(',');
            writer.append(curso.getNome());
            writer.append('\n');
        }

        writer.flush();
        writer.close();
    }
}