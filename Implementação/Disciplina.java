import java.math.BigDecimal;

public class Disciplina {
    private BigDecimal id;
    private String nome;
    private Integer credito;
    private BigDecimal valorCustoHora;
    private EnumTipoDisciplina tipo;

    public Disciplina(String nome, Integer credito,
            BigDecimal valorCustoHora, EnumTipoDisciplina tipo) {
        this.id = getNextId();
        this.nome = nome;
        this.credito = credito;
        this.valorCustoHora = valorCustoHora;
        this.tipo = tipo;
    }

    public Disciplina() {

    }

    // Método para obter o próximo ID autoincrementado
    private static synchronized BigDecimal getNextId() {
        ultimoId = ultimoId.add(BigDecimal.ONE);
        return ultimoId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCredito() {
        return credito;
    }

    public void setCredito(Integer credito) {
        this.credito = credito;
    }

    public BigDecimal getValorCustoHora() {
        return valorCustoHora;
    }

    public void setValorCustoHora(BigDecimal valorCustoHora) {
        this.valorCustoHora = valorCustoHora;
    }

    public EnumTipoDisciplina getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoDisciplina tipo) {
        this.tipo = tipo;
    }

}
