package exercicio;

import exercicio.banco.ContaCorrente;
import exercicio.exception.OperacaoBancariaException;

public class Principal1 {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente("123");
        //conta1.ativar();

        try {
            conta1.depositar(10);
            System.out.printf("Saldo da conta 1: R$ %.2f%n", conta1.getSaldo());
        } catch (IllegalArgumentException | OperacaoBancariaException e) {
            System.out.println("Erro - "+ e.getMessage());
        }

    }
}
