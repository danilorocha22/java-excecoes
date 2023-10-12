package exercicio;

import exercicio.banco.ContaCorrente;
import exercicio.exception.ContaInativaException;
import exercicio.exception.SaldoInsuficienteException;

public class Principal2 {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente("123");
        ContaCorrente conta2 = new ContaCorrente("987");

        conta1.ativar();
        conta2.ativar();

        try {
            conta1.depositar(1_000);
            conta1.transferir(conta2, 5_000);

            System.out.printf("Saldo da conta 2: %.2f%n", conta2.getSaldo());
            System.out.printf("Saldo da conta 1: %.2f%n", conta1.getSaldo());

        } catch (ContaInativaException | SaldoInsuficienteException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
