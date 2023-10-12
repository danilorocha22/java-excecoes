package _2_excecao_checada.exemplo2.model;

import _2_excecao_checada.exemplo2.exception.ProdutoInativoException;
import _2_excecao_checada.exemplo2.exception.ProdutoSemEstoqueException;

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
    public void adicionarEstoque(int quantidade) throws ProdutoInativoException {
        validarQuantidade(quantidade);
        validarSituacaoProduto();
        this.quantidadeEstoque += quantidade;
    }

    public void retirarEstoque(int quantidade) throws ProdutoSemEstoqueException, ProdutoInativoException {
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

    private void validarSaldoEstoque(int quantidade) throws ProdutoSemEstoqueException  {
        if (this.getQuantidadeEstoque() - quantidade < 0) {
            throw new ProdutoSemEstoqueException("quantidade atual em estoque insuficiente", this.getQuantidadeEstoque(),
                    quantidade);
        }
    }

    private void validarSituacaoProduto() throws ProdutoInativoException {
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
