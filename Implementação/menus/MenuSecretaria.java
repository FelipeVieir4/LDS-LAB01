package menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ModelController.Curso;
import ModelController.Disciplina;
import ModelController.Pessoa;
import ModelController.SecretariaAcademica;
import ModelController.TipoDisciplina;

public class MenuSecretaria {
    static Scanner scanner = new Scanner(System.in);

    public static void init(SecretariaAcademica secretarioLogado) throws IOException {
        int opcao = -1;

        while (opcao != 0) {
            UtilMenu.limparConsole();
            opcao = menuPrincipal();
        }

    }

    public static int menuPrincipal() throws IOException {

        /**
         * 1. Cadastrar novo curso
         * 2. Cadastrar Disciplina
         * 3. Cadastrar novo aluno
         * 4. Cadastrar novo professor
         * 5. Matricular aluno na turma
         * 6. Validar Turmas
         * 7. Cobrar Mesalidades
         */

        int opcao = -1;
        do {
            System.out.println("==========================");
            System.out.println("Escolha a tarefa:");
            System.out.println("1 - Cadastrar novo Curso");
            System.out.println("0 - Sair");
            System.out.println("Sua opção:");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por gentileza, digite um valor válido (número inteiro entre os apresentados)");
                opcao = -1;
            }
        } while (opcao < 1 || opcao > 3);

        switch (opcao) {
            case 0:
                return 0;
            case 1:
                cadastrarNovoCurso();
                break;

            default:
                break;
        }
        return opcao;

    }

    private static void cadastrarNovoCurso() throws IOException {
    UtilMenu.limparConsole();
    System.out.println("Informe o nome do curso:");
    String nome = scanner.nextLine();

    List<Disciplina> disciplinas = new ArrayList<>(); // Crie uma lista vazia para as disciplinas
    disciplinas = criarNovaDisciplina(disciplinas);
    Curso curso = new Curso(nome, disciplinas);
    sa.cadastrarCurso(curso);
    }

    private static List<Disciplina> criarNovaDisciplina(List<Disciplina> disciplinas) {
        do {
            UtilMenu.limparConsole();
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

    // /*
    // * Metodo com sub menu para Selecionar uma disciplina ou criar uma nova
    // */
    // public static int subMenuAdicionarDisciplinaNoCurso() {
    // int opcao = -1;
    // System.out.println("==========================");
    // System.out.println("Escolha uma opção:");
    // System.out.println("1 - Selecionar uma disciplina existente");
    // System.out.println("2 - Criar uma nova disciplina");
    // System.out.println("0 - Sair");
    // System.out.println("Sua opção:");
    // try {
    // return opcao = Integer.parseInt(scanner.nextLine());
    // } catch (NumberFormatException e) {
    // System.out.println("Por gentileza, digite um valor válido (número inteiro
    // entre os apresentados)");
    // return opcao = -1;
    // }
    // }

    // private static void listarDisciplinasExistentes() {
    // // metodo nao implementado
    // System.out.println("metodo nao implementado");
    // }

}
