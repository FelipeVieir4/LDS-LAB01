package DAO;

import ModelController.Turma;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Turma.
 */
public class TurmaDAO {

    private static final String FILENAME = "turmas.csv";

    /**
     * Salva uma lista de turmas em um arquivo CSV.
     *
     * @param turmas A lista de turmas a ser salva.
     * @throws IOException Se ocorrer um erro ao salvar o arquivo.
     */
    public void salvar(List<Turma> turmas) throws IOException {
        FileWriter writer = new FileWriter(FILENAME);

        // Escreve o cabeçalho do arquivo CSV
        writer.append("ID,Professor,Disciplina,EstaAtivo,AnoOfertado,SemestreOfertado,ValorCustoSemestre\n");

        // Escreve os dados das turmas no arquivo CSV
        for (Turma turma : turmas) {
            writer.append(String.valueOf(turma.getId()));
            writer.append(',');
            writer.append(turma.getProfessor());
            writer.append(',');
            writer.append(turma.getDisciplina());
            writer.append(',');
            writer.append(String.valueOf(turma.getEstaAtivo()));
            writer.append(',');
            writer.append(String.valueOf(turma.getAnoOfertado()));
            writer.append(',');
            writer.append(String.valueOf(turma.getSemestreOfertado()));
            writer.append(',');
            writer.append(String.valueOf(turma.getValorCustoSemestre()));
            writer.append('\n');
        }

        writer.flush();
        writer.close();
    }
}
