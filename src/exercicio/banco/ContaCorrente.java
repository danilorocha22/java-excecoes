package exercicio.banco;

import exercicio.exception.ContaInativaException;
import exercicio.exception.SaldoInsuficienteException;

public class ContaCorrente {
    private final String numero;
    private double saldo;
    private boolean ativa;

    public ContaCorrente(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public boolean isInativa() {
        return !isAtiva();
    }

    public void ativar() {
        this.ativa = true;
    }

    public void inativar() {
        this.ativa = false;
    }

    public void sacar(double valor) throws SaldoInsuficienteException, ContaInativaException {
        this.validarValorInformado(valor);
        this.validarSeContaAtiva();
        this.validarSaldoConta(valor);
        this.saldo -= valor;
    }

    public void depositar(double valor) throws ContaInativaException {
        this.validarValorInformado(valor);
        this.validarSeContaAtiva();
        this.saldo += valor;
    }

    public void transferir(ContaCorrente contaDestino, double valor) throws ContaInativaException, SaldoInsuficienteException {
        this.validarSeContaAtiva();
        contaDestino.validarSeContaAtiva();
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    private void validarValorInformado(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Informe um valor maior que 0.");
    }

    private void validarSeContaAtiva() throws ContaInativaException {
        if (isInativa()) throw new ContaInativaException("Conta não está ativada: conta nº " + this.getNumero());
    }

    private void validarSaldoConta(double valor) throws SaldoInsuficienteException {
        if (valor > this.saldo)
            throw new SaldoInsuficienteException("Não há saldo suficiente na conta nº " + this.getNumero());
    }

}
