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

    // Métodos
    public void adicionarEstoque(int quantidade) {
        validarQuantidade(quantidade);
        validarSituacaoProduto();
        this.quantidadeEstoque += quantidade;
    }

    public void retirarEstoque(int quantidade) {
        validarQuantidade(quantidade);
        validarSituacaoProduto();
        validarSaldoEstoque(quantidade);
        this.quantidadeEstoque -= quantidade;
    }

    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }

    private void validarSaldoEstoque(int quantidade) {
        if (this.getQuantidadeEstoque() - quantidade < 0) {
            throw new IllegalArgumentException(String.format("Quantidade atual em estoque é insuficiente: %d%n",
                    this.getQuantidadeEstoque()));
        }
    }

    private void validarSituacaoProduto() {
        if (seInativo())
            throw new IllegalStateException(String.format("Produto inativo: %s%n", this.getNome()));
    }

    private boolean seInativo() {
        return !isAtivo();
    }

    private void validarQuantidade(int quantidade) {
        if (quantidade <= 0)
            throw new IllegalArgumentException(String.format("Informe uma quantidade maior que zero %n"));
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
