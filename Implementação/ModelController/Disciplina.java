package ModelController;

public class Disciplina {
    private int proximoID;
    private String nome;
    private int credito;
    private TipoDisciplina tipo;

    // Métodos de acesso Get
    public int getProximoID() {
        return proximoID;
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
