import java.io.IOException;
import java.util.Scanner;

import javax.naming.NameNotFoundException;

import DAO.AlunoDAO;
import DAO.ProfessorDAO;
import DAO.SecretariaAcademicaDAO;
import ModelController.Aluno;

import ModelController.Professor;
import ModelController.SecretariaAcademica;
import menus.MenuSecretaria;
import menus.UtilMenu;

public class App {
    static Scanner scanner = new Scanner(System.in);

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

    public static Aluno efetuarLoginAluno() {
        UtilMenu.limparConsole();
        AlunoDAO alunoDAO = new AlunoDAO();
        System.out.println("Informe seu login:");
        String login = scanner.nextLine();
        System.out.println("Informe sua senha:");
        String senha = scanner.nextLine();

        try {
            Aluno aluno = alunoDAO.login(login, senha);
            return aluno;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static SecretariaAcademica efetuarLoginSecretario() {
        UtilMenu.limparConsole();
        SecretariaAcademicaDAO secDAO = new SecretariaAcademicaDAO();
        System.out.println("Informe seu login:");
        String login = scanner.nextLine();
        System.out.println("Informe sua senha:");
        String senha = scanner.nextLine();

        try {
            SecretariaAcademica sec = secDAO.login(login, senha);
            return sec;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Professor efetuarLoginProfessor() {
        UtilMenu.limparConsole();
        ProfessorDAO professorDAO = new ProfessorDAO();
        System.out.println("Informe seu login:");
        String login = scanner.nextLine();
        System.out.println("Informe sua senha:");
        String senha = scanner.nextLine();

        try {
            Professor professor = professorDAO.login(login, senha);
            return professor;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void menuSecretaria(SecretariaAcademica sec) {
        try {

            MenuSecretaria.init(sec);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void init() {
        int opcao;
        do {
            opcao = subMenuEscolherPerfil();
            switch (opcao) {
                case 1:
                    Aluno aluno = efetuarLoginAluno();
                    System.out.println(aluno.toString());
                    break;
                case 2:
                    Professor professor = efetuarLoginProfessor();
                    System.out.println(professor.toString());
                    break;
                case 3:
                    SecretariaAcademica secretario = efetuarLoginSecretario();
                    System.out.println(secretario.toString());
                    menuSecretaria(secretario);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            UtilMenu.pausar();
            UtilMenu.limparConsole();
        } while (opcao != 0);
    }

    public static void main(String[] args) throws NameNotFoundException, Exception {
        init();
    }

}