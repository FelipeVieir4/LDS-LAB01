package DAO;

import java.io.IOException;

import ModelController.Curso;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Curso.
 */
public class CursoDAO {

    private static final String PATH = "./DB/curso.csv";

    /**
     * Salva uma lista de cursos em um arquivo CSV.
     *
     * @param cursos A lista de cursos a ser salva.
     * @throws IOException Se ocorrer um erro ao salvar o arquivo.
     */
    public void salvar(Curso curso) throws IOException {
        String textoMontado = curso.toCSV();
        Util.salvarNoArquivo(PATH, textoMontado);
    }
}