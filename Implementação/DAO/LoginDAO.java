package DAO;

import java.io.IOException;
import ModelController.Aluno;
import ModelController.EnumPerfil;
import ModelController.Pessoa;
import ModelController.Professor;
import ModelController.SecretariaAcademica;

public class LoginDAO {

    public Pessoa login(String login, String senha, EnumPerfil perfil) throws IOException, IllegalArgumentException {
        String dadosDoPerfil[];
        try {
            dadosDoPerfil = Util.buscarNoArquivo(login, perfil);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "não foi possível autenticar com as credenciais informadas, tente novamente.");
        }

        if (dadosDoPerfil == null) {
            throw new IllegalArgumentException(
                    "não foi possível autenticar com as credenciais informadas, tente novamente.");
        }

        switch (perfil) {
            case ALUNO:
                Aluno aluno = null;

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

            case PROFESSOR:
                Professor professor = null;

                if (dadosDoPerfil.length > 0) {
                    // id;login;senha;nome;curso
                    int id = Integer.parseInt(dadosDoPerfil[0]);
                    String loginProfssor = dadosDoPerfil[1];
                    String senhaProfessor = dadosDoPerfil[2];
                    String nomeAluno = dadosDoPerfil[3];

                    professor = new Professor(id, loginProfssor, senhaProfessor, nomeAluno);

                }
                return professor;
            case SECRETARIA_ACADEMICA:
                SecretariaAcademica secretariaAcademica = null;

                if (dadosDoPerfil.length > 0) {
                    // id;login;senha;nome;curso
                    int id = Integer.parseInt(dadosDoPerfil[0]);
                    String loginSecretario = dadosDoPerfil[1];
                    String senhaSecretario = dadosDoPerfil[2];
                    String nomeSecretario = dadosDoPerfil[3];

                    secretariaAcademica = new SecretariaAcademica(id, loginSecretario, senhaSecretario, nomeSecretario);

                }
                return secretariaAcademica;

            default:
                throw new IllegalArgumentException(
                        "não foi possível autenticar com as credenciais informadas, tente novamente.");
        }

    }

}
