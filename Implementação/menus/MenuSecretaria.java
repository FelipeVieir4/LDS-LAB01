package menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.DisciplinaDAO;
import ModelController.Curso;
import ModelController.Disciplina;
import ModelController.SecretariaAcademica;


public class MenuSecretaria {
    static Scanner scanner = new Scanner(System.in);
    static SecretariaAcademica secretarioLogado;

    public static void init(SecretariaAcademica user) throws IOException {
        secretarioLogado = user;
        int opcao = -1;

        while (opcao != 0) {
            UtilMenu.limparConsole();
            opcao = menuPrincipal();
        }

    }

    public static int menuPrincipal() throws IOException, NullPointerException {

        /**
         * 1. Cadastrar novo curso 
         * 2. Cadastrar Disciplina ok
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
            System.out.println("3 - Listar todas as disciplinas cadastradas");
            System.out.println("4 - Cadastrar uma nova disciplina");
            System.out.println("0 - Sair");
            System.out.println("Sua opção:");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por gentileza, digite um valor válido (número inteiro entre os apresentados)");
                opcao = -1;
            }
        } while (opcao < 1 || opcao > 10);

        switch (opcao) {
            case 0:
                return 0;
            case 1:
                cadastrarNovoCurso();
                break;
            case 3:
                listarTodasDisciplinasCadastradas();
                break;
            case 4:
                criarNovaDisciplina();
                break;

            default:
                break;
        }
        return opcao;

    }

    private static void listarTodasDisciplinasCadastradas() throws IOException {
        UtilMenu.limparConsole();
        DisciplinaDAO discDAO = new DisciplinaDAO();
        List<Disciplina> lista = discDAO.todasDisciplinas();
        for (Disciplina disciplina : lista) {
            System.out.println(disciplina.toString());
        }
        UtilMenu.pausar();
    }

    private static void cadastrarNovoCurso() throws IOException {

        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        UtilMenu.limparConsole();
        System.out.println("Informe o nome do curso:");
        String nome = scanner.nextLine();

        List<Disciplina> disciplinas = new ArrayList<>(); // Crie uma lista vazia para as disciplinas

        boolean cadastrar = true;

        do {
            listarTodasDisciplinasCadastradas();
            System.out.println("Informe o ID da discplina cadastrada:");
            int idUser = 0;
            try {
                idUser = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Informe um valor válido da lista");
            }

            Disciplina disciplinaBuscada = disciplinaDAO.buscarDisciplinaPorID(idUser);
            disciplinas.add(disciplinaBuscada);

            System.out.println("Deseja inserir outra disciplina? (S/N)");
            String vaiParar = scanner.nextLine();

            if (vaiParar.equalsIgnoreCase("n")) {
                cadastrar = false;
            }

        } while (cadastrar);

        Curso curso = new Curso(nome, disciplinas);
        secretarioLogado.cadastrarCurso(curso);
    }

    private static void criarNovaDisciplina() throws IOException {

        // id;nome;credito;tipo

        UtilMenu.limparConsole();
        System.out.println("Informe o nome da disciplina:");
        String nome = scanner.nextLine();

        System.out.println("Informe o crédito da disciplina:");
        int credito = Integer.parseInt(scanner.nextLine());

        System.out.println("Escolha o tipo da disciplina:");
        System.out.println("1 = Obrigatória");
        System.out.println("2 = Optativa");
        int tipoSelecionado = Integer.parseInt(scanner.nextLine());

        ModelController.TipoDisciplina tipoDisciplina = ModelController.TipoDisciplina.OPTATIVA;
        if (tipoSelecionado == 1) {
            tipoDisciplina = ModelController.TipoDisciplina.OBRIGATORIA;
        }

        Disciplina nova = new Disciplina(nome, credito, tipoDisciplina);
        DisciplinaDAO novaDAO = new DisciplinaDAO();
        novaDAO.salvarDisciplina(nova);

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
