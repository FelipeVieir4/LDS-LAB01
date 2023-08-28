import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String login;
    private String senha;
    private List<DisciplinaOfertada> disciplinasObrigatorias;
    private List<DisciplinaOfertada> disciplinasOptativas;
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
}