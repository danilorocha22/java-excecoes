package _3_excecao_customizada;

import _3_excecao_customizada.exception.ProdutoInativoException;
import _3_excecao_customizada.exception.ProdutoSemEstoqueException;
import _3_excecao_customizada.model.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Smart Watch");
        produto.ativar();

        do {
            try {
                if (produto.getQuantidadeEstoque() == 0) {
                    produto.adicionarEstoque(20);
                }

                comprar(produto);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println("Erro na compra: " + ex.getMessage());

            } catch (ProdutoSemEstoqueException ex) {
                System.out.printf("Erro na compra: %s; estoque atual: %d; quantidade comprada: %d%n%n",
                        ex.getMessage(), ex.getEstoqueDisponivel(), ex.getQuantidadeComprada());

            } catch (ProdutoInativoException ex) {
                System.out.println("Erro na compra: " + ex.getMessage());
                verificarAtivacaoProduto(produto);

                if (produto.seInativo())
                    break;
            }

        } while (true);

    }

    private static void comprar(Produto produto) {
        System.out.print("Quantidade: ");
        int quantidade = new Scanner(System.in).nextInt();

        efetuarBaixaEstoque(produto, quantidade);
        System.out.println("Compra realizada");
    }

    private static void efetuarBaixaEstoque(Produto produto, int quantidade) {
        produto.retirarEstoque(quantidade);
        System.out.printf("%d unidades retiradas do estoque. Estoque atual: %d%n", quantidade,
                produto.getQuantidadeEstoque());
    }

    private static void verificarAtivacaoProduto(Produto produto) {
        System.out.print("Deseja ativar o produto? ");
        Scanner sc = new Scanner(System.in);

        if (sc.nextBoolean()) {
            produto.ativar();
            System.out.println("OK, produto foi ativado.");
        } else {
            System.out.println("Ok. Compra não pode ser realizada.");
        }
    }

}