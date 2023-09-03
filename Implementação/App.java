import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.NameNotFoundException;

import DAO.LoginDAO;
import ModelController.Curso;
import ModelController.Disciplina;
import ModelController.EnumPerfil;
import ModelController.Pessoa;
import ModelController.SecretariaAcademica;
import ModelController.TipoDisciplina;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Pessoa perfilLogado;
    static SecretariaAcademica sa = new SecretariaAcademica(1, "admin", "1234", "secretaria academica");

    // #region Utilitários
    static void pausar() {
        System.out.print(System.lineSeparator() + "Digite qualquer tecla para continuar...");
        scanner.nextLine();
    }

    /**
     * Limpa o console exibindo o programa em execução.
     * Essa função limpa a tela do console, removendo todas as saídas anteriores.
     * O método usado para limpar o console varia dependendo do sistema operacional.
     * Atualmente, o suporte é fornecido para sistemas Windows e outros sistemas
     * operacionais.
     * Se ocorrer um erro durante a execução da limpeza do console, a mensagem de
     * erro será exibida.
     */
    public static void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Limpa o console no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Limpa o console em outros sistemas operacionais
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Exibe a mensagem de erro, caso ocorra algum problema
            System.out.println(e.getMessage());
        }
    }
    // #endregion

    /*
     * Metodo com sub menu para escolher papel login
     */
    public static int subMenuEscolherPerfil() {
        int opcao = -1;
        do {
            System.out.println("==========================");
            System.out.println("Escolha o perfil:");
            System.out.println("1 - Aluno");
            System.out.println("2 - Professor");
            System.out.println("3 - Secretaria Academica");
            System.out.println("Sua opção:");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por gentileza, digite um valor válido (número inteiro entre os apresentados)");
                opcao = -1;
            }
        } while (opcao < 1 || opcao > 3);
        return opcao;
    }

    /*
     * Metodo com sub menu para SECRETARIA ACADEMICA
     */
    public static int subMenuSecretariaAcademica() {
        int opcao = -1;
        do {
            System.out.println("==========================");
            System.out.println("Escolha a tarefa:");
            System.out.println("1 - Cadastrar novo Curso");
            System.out.println("Sua opção:");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por gentileza, digite um valor válido (número inteiro entre os apresentados)");
                opcao = -1;
            }
        } while (opcao < 1 || opcao > 3);
        return opcao;
    }

    /*
     * Metodo com sub menu para Selecionar uma disciplina ou criar uma nova
     */
    public static int subMenuAdicionarDisciplinaNoCurso() {
        int opcao = -1;
        System.out.println("==========================");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Selecionar uma disciplina existente");
        System.out.println("2 - Criar uma nova disciplina");
        System.out.println("0 - Sair");
        System.out.println("Sua opção:");
        try {
            return opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por gentileza, digite um valor válido (número inteiro entre os apresentados)");
            return opcao = -1;
        }
    }

    public static void efetuarLogin(EnumPerfil perfil) {
        limparConsole();
        LoginDAO loginDAO = new LoginDAO();
        System.out.println("Informe seu login:");
        String login = scanner.nextLine();
        System.out.println("Informe sua senha:");
        String senha = scanner.nextLine();

        try {

            Pessoa pessoa = loginDAO.login(login, senha, perfil);
            perfilLogado = pessoa;
            System.err.println(perfilLogado.toString());
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void init() {
        int opcao;
        EnumPerfil perfil;
        do {
            opcao = subMenuEscolherPerfil();
            switch (opcao) {
                case 1:
                    perfil = EnumPerfil.ALUNO;
                    efetuarLogin(perfil);
                    break;
                case 2:
                    perfil = EnumPerfil.PROFESSOR;
                    efetuarLogin(perfil);
                    break;
                case 3:
                    perfil = EnumPerfil.SECRETARIA_ACADEMICA;
                    efetuarLogin(perfil);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            pausar();
            limparConsole();
        } while (opcao != 0);
    }

    private static void cadastrarNovoCurso() throws IOException {
        limparConsole();
        System.out.println("Informe o nome do curso:");
        String nome = scanner.nextLine();

        List<Disciplina> disciplinas = new ArrayList<>(); // Crie uma lista vazia para as disciplinas
        disciplinas = criarNovaDisciplina(disciplinas);
        Curso curso = new Curso(nome, disciplinas);
        sa.cadastrarCurso(curso);
    }

    private static List<Disciplina> criarNovaDisciplina(List<Disciplina> disciplinas) {
        do {
            limparConsole();
            System.out.println("Informe o nome da disciplina:");
            String nome = scanner.nextLine();

            System.out.println("Informe o crédito da disciplina:");
            int credito = Integer.parseInt(scanner.nextLine());

            // Mostrar os tipos disponíveis do enumerador
            System.out.println("Tipos de disciplina disponíveis:");
            for (TipoDisciplina tipo : TipoDisciplina.values()) {
                System.out.println(tipo.ordinal() + ". " + tipo.name());
            }

            // Solicitar ao usuário escolher um tipo de disciplina
            int escolhaTipo;
            do {
                System.out.print("Escolha o número correspondente ao tipo de disciplina: ");
                escolhaTipo = Integer.parseInt(scanner.nextLine());
            } while (escolhaTipo < 0 || escolhaTipo >= TipoDisciplina.values().length);

            TipoDisciplina tipoDisciplina = TipoDisciplina.values()[escolhaTipo];

            Disciplina disciplina = new Disciplina(nome, credito, tipoDisciplina);
            disciplinas.add(disciplina);

            System.out.println("Deseja cadastrar outra disciplina? (S/N)");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (!resposta.equals("S")) {
                break; // Sai do loop se a resposta não for "S"
            }
        } while (true); // Loop infinito, só sairá com "break"

        return disciplinas;
    }

    private static void listarDisciplinasExistentes() {
        // metodo nao implementado
        System.out.println("metodo nao implementado");
    }

    public static void main(String[] args) throws NameNotFoundException, Exception {
        // init();
        int opcao;
        do {
            opcao = subMenuSecretariaAcademica();
            switch (opcao) {
                case 1:
                    cadastrarNovoCurso();
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

}