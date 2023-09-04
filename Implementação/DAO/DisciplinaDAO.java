package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ModelController.Disciplina;
import ModelController.TipoDisciplina;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Disciplina.
 */
public class DisciplinaDAO {

    private static final String CAMINHO = "./DB/disciplinas.csv";

    public void salvarDisciplina(Disciplina disc) throws IOException {
        Util.salvarNoArquivo(CAMINHO, disc.toCSV());
    }

    public List<Disciplina> todasDisciplinas() throws IOException {
        String BASE_DADOS_DISC[] = Util.lerArquivoTodo(CAMINHO).split(System.lineSeparator());
        List<Disciplina> lista = new ArrayList<Disciplina>();

        for (String discplina : BASE_DADOS_DISC) {
            String discplinaCSV[] = discplina.split(";");
            // id;nome;credito;tipo
            int id = Integer.parseInt(discplinaCSV[0]);
            String nome = discplinaCSV[1];
            int credito = Integer.parseInt(discplinaCSV[2]);
            TipoDisciplina tipo = TipoDisciplina.valueOf(discplinaCSV[3]);

            Disciplina nova = new Disciplina(id, nome, credito, tipo);
            lista.add(nova);
        }

        return lista;
    }

    public Disciplina buscarDisciplinaPorID(int idInt) throws IOException {
        String idString = Integer.toString(idInt);
        String discplinaCSV[] = Util.buscarIDNoArquivo(idString, CAMINHO);
        // id;nome;credito;tipo
        int id = Integer.parseInt(discplinaCSV[0]);
        String nome = discplinaCSV[1];
        int credito = Integer.parseInt(discplinaCSV[2]);
        TipoDisciplina tipo = TipoDisciplina.valueOf(discplinaCSV[3]);

        Disciplina nova = new Disciplina(id, nome, credito, tipo);

        return nova;
    }

}