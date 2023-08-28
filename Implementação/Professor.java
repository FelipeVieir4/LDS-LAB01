import java.util.List;

public class Professor {
    private String login;
    private String senha;

    public Professor() {

    }

    public void salvar(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public List<Aluno> consultarAlunosPorDisciplina(DisciplinaOfertada disciplina) {
        return disciplina.getAlunos();
    }

}
