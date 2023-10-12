package _3_excecao_customizada.exception;

public class ProdutoSemEstoqueException extends RuntimeException {

    private final int estoqueDisponivel;
    private final int quantidadeComprada;

    public ProdutoSemEstoqueException(String message, int estoqueDisponivel, int quantidadeComprada) {
        super(message);
        this.estoqueDisponivel = estoqueDisponivel;
        this.quantidadeComprada = quantidadeComprada;
    }

    public int getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }
}
