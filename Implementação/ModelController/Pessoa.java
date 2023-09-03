package ModelController;

/**
 * Classe que representa uma pessoa com informações básicas como nome, login e
 * senha.
 */
public abstract class Pessoa implements ICSV {
    private static int proximoId;

    protected int id;
    protected String nome;
    protected String login;
    protected String senha;

    static {
        proximoId = 1000;
    }

    /**
     * Construtor para criar um objeto Pessoa com um ID gerado automaticamente.
     *
     * @param login O login da pessoa.
     * @param senha A senha da pessoa.
     * @param nome  O nome da pessoa.
     * @throws IllegalArgumentException Se os parâmetros fornecidos forem inválidos
     *                                  (nulos ou vazios).
     */
    public Pessoa(String login, String senha, String nome) throws IllegalArgumentException {
        validarParametrosConstrutor(login, senha, nome);
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        id = proximoId;
        proximoId++;
    }

    /**
     * Construtor para criar um objeto Pessoa com um ID especificado.
     *
     * @param id    O ID da pessoa.
     * @param login O login da pessoa.
     * @param senha A senha da pessoa.
     * @param nome  O nome da pessoa.
     * @throws IllegalArgumentException Se o ID for menor que 0 ou se os outros
     *                                  parâmetros fornecidos forem inválidos
     *                                  (nulos ou vazios).
     */
    public Pessoa(int id, String login, String senha, String nome) throws IllegalArgumentException {
        validarParametrosConstrutor(login, senha, nome);
        if (id < 0) {
            throw new IllegalArgumentException("O ID da pessoa não pode ser menor que 0.");
        }
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    /**
     * Valida os parâmetros do construtor.
     *
     * @param login O login a ser validado.
     * @param senha A senha a ser validada.
     * @param nome  O nome a ser validado.
     * @throws IllegalArgumentException Se algum dos parâmetros for nulo ou vazio.
     */
    private void validarParametrosConstrutor(String login, String senha, String nome) throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O NOME não pode ser vazio ou nulo.");
        }
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("O LOGIN não pode ser vazio ou nulo.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("A SENHA não pode ser vazia ou nula.");
        }
    }

    public static int getProximoId() {
        return proximoId;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    // Metodos de acesso Get

}
