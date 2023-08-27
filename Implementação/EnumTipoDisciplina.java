public enum EnumTipoDisciplina {
    OBRIGATORIA("Obrigatória"),
    OPTATIVA("Optativa");

    private final String descricao;

    EnumTipoDisciplina(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
