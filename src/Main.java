import model.Produto;

public class Main {
    public static void main(String[] args) {

        try {
            Produto relogioApple = new Produto("Relógio");
            relogioApple.setAtivo(true);

            relogioApple.adicionarEstoque(1);
            relogioApple.retirarEstoque(1);

            System.out.printf("Estoque atual: %d%n", relogioApple.getQuantidadeEstoque());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}