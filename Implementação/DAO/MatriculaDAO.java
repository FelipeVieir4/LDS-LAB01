package DAO;

import ModelController.Matricula;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Matricula.
 */
public class MatriculaDAO {

    private static final String FILENAME = "matriculas.csv";

    /**
     * Salva uma lista de matrículas em um arquivo CSV.
     *
     * @param matriculas A lista de matrículas a ser salva.
     * @throws IOException Se ocorrer um erro ao salvar o arquivo.
     */
    public void salvar(List<Matricula> matriculas) throws IOException {
        FileWriter writer = new FileWriter(FILENAME);

        // Escreve o cabeçalho do arquivo CSV
        writer.append("ID,Curso\n");

        // Escreve os dados das matrículas no arquivo CSV
        for (Matricula matricula : matriculas) {
            writer.append(String.valueOf(matricula.getId()));
            writer.append(',');
            writer.append(matricula.getCurso());
            writer.append('\n');
        }

        writer.flush();
        writer.close();
    }
}