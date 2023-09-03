package ModelController;

import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private List<Disciplina> disciplinas;

    // Métodos de acesso
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

}
