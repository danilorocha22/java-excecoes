package _1_excecao_nao_checada;

import _1_excecao_nao_checada.model.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Smart Watch");
        produto.ativar();
        produto.adicionarEstoque(20);

        comprar(produto);

        /*try {
            Produto relogioApple = new Produto("Relógio");
            relogioApple.setAtivo(true);

            relogioApple.adicionarEstoque(1);
            relogioApple.retirarEstoque(1);

            System.out.printf("Estoque atual: %d%n", relogioApple.getQuantidadeEstoque());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

    }

    private static void comprar(Produto produto) {
        produto.desativar();
        Scanner sc = new Scanner(System.in);

        do {

            try {
                System.out.print("Quantidade: ");
                int quantidade = sc.nextInt();

                efetuarBaixaEstoque(produto, quantidade);
                System.out.println("Compra realizada");

                break;
            } catch (IllegalArgumentException iae) {
                System.out.println("Erro na compra: " + iae.getMessage());

            } catch (IllegalStateException ise) {
                System.out.println("Erro na compra: " + ise.getMessage());
                System.out.print("Deseja ativar o produto? ");

                if (sc.nextBoolean()) {
                    produto.ativar();
                    System.out.println("OK, produto foi ativado.");
                } else {
                    System.out.println("Ok. Compra não pode ser realizada.");
                    break;
                }
            }

        } while (true);

    }

    private static void efetuarBaixaEstoque(Produto produto, int quantidade) {
        produto.retirarEstoque(quantidade);
        System.out.printf("%d unidades retiradas do estoque. Estoque atual: %d%n", quantidade,
                produto.getQuantidadeEstoque());
    }

}