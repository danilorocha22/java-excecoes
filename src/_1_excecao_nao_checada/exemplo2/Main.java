package _1_excecao_nao_checada.exemplo2;

import _1_excecao_nao_checada.exemplo2.exception.CadastroAnuncioException;
import _1_excecao_nao_checada.exemplo2.service.ServicoCadastroAnuncio;

public class Main {
    public static void main(String[] args) {
        ServicoCadastroAnuncio cadastroAnuncio = new ServicoCadastroAnuncio();

        try {
            cadastroAnuncio.cadastrar("123", "Java");
            System.out.println("Anúncio cadastrado com sucesso");
        } catch (CadastroAnuncioException e) {
            System.out.println(e.getMessage() + ", causa: "+ e.getCause().getMessage());
        }


    }

}
