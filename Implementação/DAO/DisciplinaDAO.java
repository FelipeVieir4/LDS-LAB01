package DAO;

import java.io.IOException;
import ModelController.Disciplina;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Disciplina.
 */
public class DisciplinaDAO {

    private static final String CAMINHO = "./DB/disciplinas.csv";

    public void salvarDisciplina(Disciplina disc) throws IOException {
        Util.salvarNoArquivo(CAMINHO, disc.toCSV());
    }

}