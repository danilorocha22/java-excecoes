package _2_excecao_checada.exemplo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path arquivo = Path.of("/home/dan/Downloads/teste.txt");

        try (BufferedReader  reader = Files.newBufferedReader(arquivo)) {
            System.out.println(reader.readLine());

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: "+ e.getMessage());
        }

    }
}
