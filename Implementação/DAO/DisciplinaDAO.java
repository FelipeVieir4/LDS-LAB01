package DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ModelController.Disciplina;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Disciplina.
 */
public class DisciplinaDAO {

    private static final String FILENAME = "disciplinas.csv";

    /**
     * Salva uma lista de disciplinas em um arquivo CSV.
     *
     * @param disciplinas A lista de disciplinas a ser salva.
     * @throws IOException Se ocorrer um erro ao salvar o arquivo.
     */
    public void salvar(List<Disciplina> disciplinas) throws IOException {
        FileWriter writer = new FileWriter(FILENAME);

        // Escreve o cabeçalho do arquivo CSV
        writer.append("ProximoID,Nome,Credito,Tipo\n");

        // Escreve os dados das disciplinas no arquivo CSV
        for (Disciplina disciplina : disciplinas) {
            writer.append(String.valueOf(disciplina.getProximoID()));
            writer.append(',');
            writer.append(disciplina.getNome());
            writer.append(',');
            writer.append(String.valueOf(disciplina.getCredito()));
            writer.append(',');
            writer.append(disciplina.getTipo().toString());
            writer.append('\n');
        }

        writer.flush();
        writer.close();
    }
}