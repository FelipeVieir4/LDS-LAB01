package DAO;

import java.io.IOException;

import ModelController.Aluno;
import ModelController.EnumPerfil;
import ModelController.Pessoa;

public class LoginDAO {

    public Pessoa login(String login, String senha, EnumPerfil perfil) throws IOException, IllegalArgumentException {

        String dadosDoPerfil[] = Util.buscarNoArquivo(login, perfil);

        switch (perfil) {
            case ALUNO:
                Aluno aluno = null;
                System.out.println("Aluno : " + dadosDoPerfil);
                if (dadosDoPerfil.length > 0 || dadosDoPerfil != null) {
                    // id;login;senha;nome;matriculas
                    int id = Integer.parseInt(dadosDoPerfil[0]);
                    String loginAluno = dadosDoPerfil[1];
                    String senhaAluno = dadosDoPerfil[2];
                    String nomeAluno = dadosDoPerfil[3];
                    aluno = new Aluno(id, loginAluno, senhaAluno, nomeAluno);

                    for (int i = 4; i < dadosDoPerfil.length; i++) {
                        aluno.adicionarMatricula(Integer.parseInt(dadosDoPerfil[i]));
                    }
                }

                break;
            case PROFESSOR:
                System.out.println("Professor : " + dadosDoPerfil);
                break;
            case SECRETARIA_ACADEMICA:
                System.out.println("Secretaria : " + dadosDoPerfil);
                break;

            default:
                System.out.println("Erro : Perfil não encontrado");
                break;
        }
        return null;

    }

}
