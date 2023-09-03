package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import ModelController.EnumPerfil;

public class Util {

    public static final String CAMINHO_ARQUIVO_ALUNO = "./DB/alunos.csv";
    public static final String CAMINHO_ARQUIVO_PROFESSORES = "./DB/professores.csv";
    public static final String CAMINHO_ARQUIVO_SECRETARIA_ACADEMICA = "assets/secretariaAcademica.csv";

    public static final String SEPARADOR_CSV = ";";
    public static final String SEPARADOR_LINHA = System.lineSeparator();

    /**
     * Lê o conteúdo de um arquivo.
     *
     * @param filePath O caminho do arquivo a ser lido.
     * @return O conteúdo do arquivo como uma string.
     * @throws IOException Se ocorrer um erro de leitura ou fechamento do arquivo.
     */
    public static String lerArquivoTodo(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        try {
            File file = new File(filePath);
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());// separador de linha do sistema operacional que está executando.
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Tratar qualquer exceção ao fechar o leitor
                }
            }
        }
        return content.toString();
    }

    /**
     * Salva uma string no arquivo CSV especificado.
     * 
     * @param caminhoDoArquivo O caminho do arquivo CSV.
     * @param dadoCSV          A string a ser salva no arquivo.
     * @throws IOException Se ocorrer um erro de E/S durante a operação.
     */
    public static void salvarNoArquivo(String caminhoDoArquivo, String dadosParaAcrescentar) throws IOException {
        try {
            if (Files.notExists(Path.of(caminhoDoArquivo))) {
                Files.createFile(Path.of(caminhoDoArquivo));
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoDoArquivo, true));
            writer.write(dadosParaAcrescentar);
            writer.newLine();
            writer.close();
            // System.out.println("Dados salvos com sucesso no final do arquivo.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }

    /**
     * Retorna uma linha do csv baseada no identificador.
     * 
     * @param Id     Identificador do dado.
     * @param perfil em qual banco de dado o dado deve ser buscado.
     * @return O conteúdo do arquivo como uma string ou NULO se não houver
     *         correspondência.
     * @throws IOException              Se ocorrer um erro de leitura ou fechamento
     *                                  do arquivo.
     * @throws IllegalArgumentException Se o perfil informado não for suportado
     */
    public static String[] buscarNoArquivo(String id, EnumPerfil perfil) throws IOException {
        String filePath;
        switch (perfil) {
            case ALUNO:
                filePath = CAMINHO_ARQUIVO_ALUNO;
                break;
            case PROFESSOR:
                filePath = CAMINHO_ARQUIVO_PROFESSORES;
                break;
            case SECRETARIA_ACADEMICA:
                filePath = CAMINHO_ARQUIVO_SECRETARIA_ACADEMICA;
                break;
            default:
                throw new IllegalArgumentException("Perfil não suportado: " + perfil);
        }

        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String lineArray[] = line.split(SEPARADOR_CSV);
                if (lineArray.length > 0 && lineArray[0].equals(id)) {
                    return lineArray; // Retorna a primeira linha correspondente encontrada
                }
            }
        }
        return null; // Retorna null se não encontrar correspondência
    }
}
