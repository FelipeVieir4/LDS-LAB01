package DAO;
import ModelController.Professor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Professor.
 */
public class ProfessorDAO {

    private static final String FILENAME = "professores.csv";

    /**
     * Salva uma lista de professores em um arquivo CSV.
     *
     * @param professores A lista de professores a ser salva.
     * @throws IOException Se ocorrer um erro ao salvar o arquivo.
     */
    public void salvar(List<Professor> professores) throws IOException {
        FileWriter writer = new FileWriter(FILENAME);

        // Escreve o cabeçalho do arquivo CSV
        writer.append("ID,Login,Senha,Nome\n");

        // Escreve os dados dos professores no arquivo CSV
        for (Professor professor : professores) {
            writer.append(String.valueOf(professor.getId()));
            writer.append(',');
            writer.append(professor.getLogin());
            writer.append(',');
            writer.append(professor.getSenha());
            writer.append(',');
            writer.append(professor.getNome());
            writer.append('\n');
        }

        writer.flush();
        writer.close();
    }
}