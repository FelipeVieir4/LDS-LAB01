package DAO;

import java.io.IOException;

import ModelController.Aluno;

/**
 * Classe que representa um DAO (Data Access Object) para a classe Aluno.
 */
public class AlunoDAO {

    private static final String CAMINHO = "./DB/alunos.csv";

    public void salvarTurma(Aluno aluno) throws IOException {
        Util.salvarNoArquivo(CAMINHO, aluno.toCSV());
    }

    public Aluno login(String login, String senha) {
        String dadosDoPerfil[];
        Aluno aluno = null;
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
            String loginAluno = dadosDoPerfil[1];
            String senhaAluno = dadosDoPerfil[2];
            String nomeAluno = dadosDoPerfil[3];
            String cursoAluno = dadosDoPerfil[4];
            aluno = new Aluno(id, loginAluno, senhaAluno, nomeAluno, cursoAluno);

        }
        return aluno;
    }
}
