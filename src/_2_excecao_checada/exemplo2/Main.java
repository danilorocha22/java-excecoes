package _2_excecao_checada.exemplo2;

import _2_excecao_checada.exemplo2.exception.BaixaEstoqueException;
import _2_excecao_checada.exemplo2.exception.ProdutoException;
import _2_excecao_checada.exemplo2.exception.ProdutoInativoException;
import _2_excecao_checada.exemplo2.exception.ProdutoSemEstoqueException;
import _2_excecao_checada.exemplo2.model.Produto;

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

            } catch (BaixaEstoqueException | ProdutoInativoException e) {
                System.out.println("Erro na compra: "+ e.getCause().getMessage());
            }

        } while (true);

    }

    private static void comprar(Produto produto) throws BaixaEstoqueException {
        System.out.print("Quantidade: ");
        int quantidade = new Scanner(System.in).nextInt();

        efetuarBaixaEstoque(produto, quantidade);
        System.out.println("Compra realizada");
    }

    private static void efetuarBaixaEstoque(Produto produto, int quantidade) throws BaixaEstoqueException {

        try {
            produto.retirarEstoque(quantidade);
            System.out.printf("%d unidades retiradas do estoque. Estoque atual: %d%n", quantidade,
                    produto.getQuantidadeEstoque());
        } catch (ProdutoException | IllegalArgumentException e) {
            throw new BaixaEstoqueException("Erro ao tentar dar baixa no estoque", e);
        }
    }


}