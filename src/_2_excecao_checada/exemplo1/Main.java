package _2_excecao_checada.exemplo1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path local = Path.of("/home/danilorocha/Documentos/abc/teste.txt");


        try {
            Files.createFile(local); // Este método nos obriga tratar a exceção
        } catch (IOException e) {
            System.out.println("Erro ao tentar criar arquivo: "+ e.getMessage());
            //e.printStackTrace();
        }

    }
}
