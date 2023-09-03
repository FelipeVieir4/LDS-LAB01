package ModelController;

public class Disciplina {
    private static int proximoId = 1; // Variável estática para controlar o próximo ID
    private int id;
    private String nome;
    private int credito;
    private TipoDisciplina tipo;

    public Disciplina(String nome, int credito, TipoDisciplina tipo) {
        this.id = proximoId++;
        this.nome = nome;
        this.credito = credito;
        this.tipo = tipo;
    }

    // Métodos de acesso Get
    public int getProximoID() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCredito() {
        return credito;
    }

    public TipoDisciplina getTipo() {
        return tipo;
    }

}
