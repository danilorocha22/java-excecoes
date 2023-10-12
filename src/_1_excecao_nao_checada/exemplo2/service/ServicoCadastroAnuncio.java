package _1_excecao_nao_checada.exemplo2.service;

import _1_excecao_nao_checada.exemplo2.exception.CadastroAnuncioException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServicoCadastroAnuncio {

    public void cadastrar(String codigo, String descricao) {
        Path arquivo = Path.of("/home/dan/Downloads/", codigo +".txt");

        try {
            Files.writeString(arquivo, descricao);
        } catch (IOException e) {
            throw new CadastroAnuncioException("Erro ao tentar escrever o anúncio", e);
            //System.out.println("Erro - não foi possível cadastrar o anúncio: "+ e.getMessage());
        }
    }

}
