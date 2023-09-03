package DAO;


import ModelController.SecretariaAcademica;

public class SecretariaAcademicaDAO {

    final String CAMINHO = "./DB/secretariaAcademica.csv";

    public SecretariaAcademica login(String login, String senha) {

        String dadosDoPerfil[];
        SecretariaAcademica secretario = null;
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
            String loginSecretario = dadosDoPerfil[1];
            String senhaSecretario = dadosDoPerfil[2];
            String nomeSecretario = dadosDoPerfil[3];

            secretario = new SecretariaAcademica(id, loginSecretario,
                    senhaSecretario, nomeSecretario);

        }
        return secretario;
    }
}
