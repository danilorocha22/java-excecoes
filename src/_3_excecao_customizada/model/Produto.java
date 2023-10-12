package _3_excecao_customizada.model;

import _3_excecao_customizada.exception.ProdutoInativoException;
import _3_excecao_customizada.exception.ProdutoSemEstoqueException;

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
            throw new ProdutoSemEstoqueException("quantidade atual em estoque insuficiente", this.getQuantidadeEstoque(),
                    quantidade);
        }
    }

    private void validarSituacaoProduto() {
        if (seInativo())
            throw new ProdutoInativoException(String.format("Produto inativo: %s%n", this.getNome()));
    }

    public boolean seInativo() {
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
