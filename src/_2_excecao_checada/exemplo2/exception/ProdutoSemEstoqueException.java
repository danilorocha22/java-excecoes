package _2_excecao_checada.exemplo2.exception;

public class ProdutoSemEstoqueException extends ProdutoException {

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
