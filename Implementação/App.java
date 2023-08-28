import java.util.Scanner;

import javax.naming.NameNotFoundException;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Aluno aluno;

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
     * Metodo com sub menu principal
     */
    public static int subMenuPrincipal() {
        int opcao = -1;
        do {
            System.out.println("==========================");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1 - Login");
            System.out.println("2 - Matricular");
            System.out.println("3 - Lista Disciplinas matriculadas");
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

    /**
     * Metodo para efetuar login no sistema
     *
     * @return true se o login for efetuado, false se o usuário escolher sair do
     *         login
     */
    private static boolean efetuarLogin() throws Exception, NameNotFoundException {
        while (true) {
            String login;
            String senha;

            System.out.println("==========================");
            System.out.println("Efetuar Login");
            System.out.print("Digite o nome de usuário (ou 'sair' para sair): ");
            login = scanner.nextLine();

            if (login.equalsIgnoreCase("sair")) {
                System.out.println("Saindo do login...");
                return false; // Retorna false para indicar que o usuário escolheu sair do login
            }

            System.out.print("Digite a senha: ");
            senha = scanner.nextLine();

            try {
                boolean resposta = aluno.autenticar(login, senha);
                return resposta; // Retorna true para indicar que o login foi efetuado com sucesso
            } catch (NameNotFoundException e) {
                System.out.println("Erro ao fazer login: Usuário não cadastrado!");
            } catch (Exception e) {
                System.out.println("Erro ao fazer login: Senha incorreta!");
            }
        }
    }

    private static void init() throws NameNotFoundException, Exception {
        int opcao;
        do {
            opcao = subMenuEscolherPerfil();
            limparConsole();
            boolean resp = false;
            switch (opcao) {
                case 1:
                    resp = efetuarLogin();
                    System.out.println(resp);
                    break;
                case 2:
                    resp = efetuarLogin();
                    System.out.println(resp);
                    break;
                case 3:
                    resp = efetuarLogin();
                    System.out.println(resp);
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
        int opcao;
        init();
        do {
            opcao = subMenuPrincipal();
            limparConsole();
            switch (opcao) {
                case 1:
                    System.out.println("Em breve...");
                    break;
                case 2:
                    System.out.println("Em breve...");
                    break;
                case 3:
                    System.out.println("Em breve...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            pausar();
            limparConsole();
        } while (opcao != 0);
    }

}
