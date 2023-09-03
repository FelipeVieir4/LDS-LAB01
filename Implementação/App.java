import java.io.IOException;
import java.util.Scanner;

import javax.naming.NameNotFoundException;

import DAO.LoginDAO;
import ModelController.EnumPerfil;
import ModelController.Pessoa;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Pessoa perfilLogado;

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

    public static void efetuarLogin(EnumPerfil perfil) {
        LoginDAO loginDAO = new LoginDAO();
        System.out.println("Informe seu login:");
        String login = scanner.nextLine();
        System.out.println("Informe sua senha:");
        String senha = scanner.nextLine();

        try {
            System.out.println(perfilLogado);
            Pessoa pessoa = loginDAO.login(login, senha, perfil);
            System.out.println(perfilLogado);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("houve um erro com as credenciais de acesso.");
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

    public static void main(String[] args) throws NameNotFoundException, Exception {
        init();
    }

}