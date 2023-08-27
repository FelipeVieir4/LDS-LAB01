import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Aluno {
    private String login;
    private String senha;
    private List<String> disciplinasObrigatorias;
    private List<String> disciplinasOptativas;
    private LocalDate prazoMatricula;

    public Aluno(LocalDate prazoMatricula) {
        this.disciplinasObrigatorias = new ArrayList<>();
        this.disciplinasOptativas = new ArrayList<>();
        this.prazoMatricula = prazoMatricula;
    }

    public void salvar(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean incluirDisciplina(Disciplina disciplina) {
        return false;
    }

    private void incluirDisciplinaObrigatoria(Disciplina disciplina) {
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

    private void incluirDisciplinaOptativa(Disciplina disciplina) {
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

    public void removerDisciplina(Disciplina disciplina) {
        if (LocalDate.now().isAfter(prazoMatricula)) {
            System.out.println("Não é possível alterar as disciplinas fora do prazo.");
            return;
        }
        this.disciplinasObrigatorias.remove(disciplina);
        this.disciplinasOptativas.remove(disciplina);
    }

    public List<Disciplina> listarDisciplinas() {
        List<Disciplina> todasDisciplinas = new ArrayList<>();
        todasDisciplinas.add(disciplinasObrigatorias);
        todasDisciplinas.add(disciplinasOptativas);
        return todasDisciplinas;
    }

    public boolean matricularSemestre() {
        return false;
    }
}