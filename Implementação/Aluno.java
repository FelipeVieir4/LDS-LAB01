import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno implements IAutenticavel {
    private String login;
    private String senha;
    private List<DisciplinaOfertada> disciplinasObrigatorias;
    private List<DisciplinaOfertada> disciplinasOptativas;
    private LocalDate prazoMatricula;
    private Aluno alunoAtual;

    public Aluno(String login, String senha, List<DisciplinaOfertada> disciplinasObrigatorias,
            List<DisciplinaOfertada> disciplinasOptativas, LocalDate prazoMatricula) {
        this.login = login;
        this.senha = senha;
        this.disciplinasObrigatorias = disciplinasObrigatorias;
        this.disciplinasOptativas = disciplinasOptativas;
        this.prazoMatricula = prazoMatricula;
    }

    public void salvar(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean incluirDisciplina(DisciplinaOfertada disciplina) {
        return false;
    }

    private void incluirDisciplinaObrigatoria(DisciplinaOfertada disciplina) {
        if (LocalDate.now().isAfter(prazoMatricula)) {
            System.out.println("Não é possível se matricular fora do prazo.");
            return;
        }
        if (disciplinasObrigatorias.size() >= 4) {
            System.out.println("Não é possível se matricular em mais de 4 disciplinas obrigatórias por semestre.");
            return;
        }
        this.disciplinasObrigatorias.add(disciplina);
    }

    private void incluirDisciplinaOptativa(DisciplinaOfertada disciplina) {
        if (LocalDate.now().isAfter(prazoMatricula)) {
            System.out.println("Não é possível se matricular fora do prazo.");
            return;
        }
        if (disciplinasOptativas.size() >= 2) {
            System.out.println("Não é possível se matricular em mais de 2 disciplinas optativas por semestre.");
            return;
        }
        this.disciplinasOptativas.add(disciplina);
    }

    public void removerDisciplina(DisciplinaOfertada disciplina) {
        if (LocalDate.now().isAfter(prazoMatricula)) {
            System.out.println("Não é possível alterar as disciplinas fora do prazo.");
            return;
        }
        this.disciplinasObrigatorias.remove(disciplina);
        this.disciplinasOptativas.remove(disciplina);
    }

    public List<DisciplinaOfertada> listarDisciplinas() {
        List<DisciplinaOfertada> todasDisciplinas = new ArrayList<>();
        for (DisciplinaOfertada disciplinaOfertada : disciplinasObrigatorias) {
            todasDisciplinas.add(disciplinaOfertada);
        }
        for (DisciplinaOfertada disciplinaOfertada : disciplinasOptativas) {
            todasDisciplinas.add(disciplinaOfertada);
        }
        return todasDisciplinas;
    }

    public boolean matricularSemestre() {
        return false;
    }

    /**
     * Retorna o login do cliente.
     *
     * @return String com o login do cliente.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Verifica se a senha fornecida é igual à senha armazenada neste objeto de
     * cliente.
     *
     * @param senha A senha a ser verificada.
     * @return true se a senha fornecida é igual à senha armazenada neste objeto de
     *         cliente, false caso contrário.
     */
    public boolean senhaCorreta(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public boolean autenticar(String login, String senha) throws Exception {
        boolean resp = false;
        if (login == null) {
            System.out.println("Login nao pode ser null");
            return resp;
        } else {
            if (login == "login") {
                if (senha == "senha") {
                    resp = true;
                    return resp;
                } else {
                    System.out.println("Senha incorreta");
                    return resp;
                }
            } else {
                System.out.println("Login nao encontrado");
                return resp;
            }
        }
    }
}