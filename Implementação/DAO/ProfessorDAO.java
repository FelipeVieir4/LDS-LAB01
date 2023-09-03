package DAO;

import ModelController.Professor;
import java.io.IOException;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Professor.
 */
public class ProfessorDAO {

    private static final String CAMINHO = "./DB/professores.csv";

    public void salvarProfessor(Professor prof) throws IOException {
        Util.salvarNoArquivo(CAMINHO, prof.toCSV());

    }

    public Professor login(String login, String senha) {
        String dadosDoPerfil[];
        Professor professor = null;
        try {
            dadosDoPerfil = Util.buscarLoginNoArquivo(login, CAMINHO);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "não foi possível autenticar com as credenciais informadas, tente novamente.");
        }

        if (dadosDoPerfil == null) {
            throw new IllegalArgumentException(
                    "não foi possível autenticar com as credenciais informadas, tente novamente.");
        }

        if (dadosDoPerfil.length > 0) {
            // id;login;senha;nome;curso
            int id = Integer.parseInt(dadosDoPerfil[0]);
            String loginProfssor = dadosDoPerfil[1];
            String senhaProfessor = dadosDoPerfil[2];
            String nomeAluno = dadosDoPerfil[3];

            professor = new Professor(id, loginProfssor, senhaProfessor, nomeAluno);

        }
        return professor;
    }
}