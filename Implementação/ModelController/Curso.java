package ModelController;

import java.util.List;

public class Curso {
    private static int proximoId = 1; // Variável estática para controlar o próximo ID
    private int id;
    private String nome;
    private List<Disciplina> disciplinas;

    public Curso(String nome, List<Disciplina> disciplinas) {
        this.id = proximoId++; // Gere automaticamente o próximo ID
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

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
