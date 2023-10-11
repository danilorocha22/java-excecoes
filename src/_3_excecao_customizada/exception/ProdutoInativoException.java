package _3_excecao_customizada.exception;

public class ProdutoInativoException extends RuntimeException {

    public ProdutoInativoException(String message) {
        super(message);
    }

}
