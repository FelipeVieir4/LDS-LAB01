package menus;

import java.util.Scanner;

public class UtilMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void pausar() {

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
}
