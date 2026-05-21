package ao.universidade.poo.banco;

public class ContaPoupanca extends Conta{
    private double taxaRendimento; // ex.: 0.01 = 1%

    public ContaPoupanca(String numero, double saldoInicial, double taxaRendimento) {
        super(numero, saldoInicial);
        if (taxaRendimento < 0) throw new IllegalArgumentException("Taxa negativa");
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() { return taxaRendimento; }
    public void setTaxaRendimento(double taxaRendimento) {
        if (taxaRendimento < 0) throw new IllegalArgumentException("Taxa negativa");
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        this.ajustarSaldo(this.getSaldo()*taxaRendimento);
    }

    // usa o comportamento padrÃ£o de sacar (sem limite)
    @Override
    public String toString() {
        return String.format("ContaPoupanca %s - Saldo: %.2f - Taxa: %.4f", numero, this.getSaldo(), taxaRendimento);
    }

}
