package model;

public class Produto {
    private final String nome;
    private int quantidadeEstoque;
    private boolean ativo;

    public Produto(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("'NOME DO PRODUTO' é obrigatório");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    // Métodos
    public void adicionarEstoque(int quantidade) {
        validarSituacaoProduto();
        validarQuantidade(quantidade);
        this.quantidadeEstoque += quantidade;
    }

    public void retirarEstoque(int quantidade) {
        validarSituacaoProduto();
        validarQuantidade(quantidade);
        validarSaldoEstoque(quantidade);
        this.quantidadeEstoque -= quantidade;
    }

    private void validarSaldoEstoque(int quantidade) {
        if (this.getQuantidadeEstoque() - quantidade < 0) {
            throw new IllegalArgumentException(String.format("Quantidade em estoque insuficiente: %d%n",
                    this.getQuantidadeEstoque()));
        }
    }

    private void validarSituacaoProduto() {
        if (produtoInativo())
            throw new IllegalStateException(String.format("Produto inativo: %s%n", this.getNome()));
    }

    private void validarQuantidade(int quantidade) {
        if (quantidade <= 0)
            throw new IllegalArgumentException("Informe uma quantidade maior que zero");
    }

    private boolean produtoInativo() {
        return !isAtivo();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", ativo=" + ativo +
                '}';
    }
}
