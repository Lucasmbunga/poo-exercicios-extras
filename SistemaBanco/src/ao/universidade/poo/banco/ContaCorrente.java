package ao.universidade.poo.banco;

public class ContaCorrente extends Conta implements Tributavel{
    @Override
    public void debitarTaxaMensal() {
        ajustarSaldo(12);
    }

    private double limite; // pode sacar até saldo + limite

    public ContaCorrente(String numero, double saldoInicial, double limite) {
        super(numero, saldoInicial);
        if (limite < 0) throw new IllegalArgumentException("Limite negativo");
        this.limite = limite;
    }

    public double getLimite() { return limite; }
    public void setLimite(double limite) {
        if (limite < 0) throw new IllegalArgumentException("Limite negativo");
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        this.depositar(valor);
    }

    @Override
    public String toString() {
        return String.format("ContaCorrente %s - Saldo: %.2f - Limite: %.2f", numero, this.getSaldo(), limite);
    }

}
