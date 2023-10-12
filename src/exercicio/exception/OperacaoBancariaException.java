package exercicio.exception;

public class OperacaoBancariaException extends Exception {

    public OperacaoBancariaException(String message) {
        super(message);
    }

    public OperacaoBancariaException(String message, Throwable cause) {
        super(message, cause);
    }

}
