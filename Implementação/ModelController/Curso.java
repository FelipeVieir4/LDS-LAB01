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

    /**
     * Retorna uma representação CSV do aluno.
     *
     * @return Uma string no formato CSV que representa o aluno.
     */
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(";").append(nome).append(";");
        for (Disciplina disciplina : disciplinas) {
            sb.append(disciplina).append(";");
        }
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
