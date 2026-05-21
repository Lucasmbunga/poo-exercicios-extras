package ao.universidade.poo.banco;

public class Conta {
    protected String numero;
    private double saldo;

    public Conta(String numero, double saldoInicial) {
        if (numero == null || numero.isBlank()) throw new IllegalArgumentException("Número inválido");
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() { return numero; }

    public double getSaldo() { return saldo; }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        this.ajustarSaldo(valor);
    }

    // método que pode lançar exceção em caso de saldo insuficiente
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) throw new IllegalArgumentException("Valor de saque deve ser positivo");
        if (saldo < valor) throw new SaldoInsuficienteException("Saldo insuficiente: saldo=" + saldo + ", valor=" + valor);
        this.ajustarSaldo(-valor);
    }

    // transferir usa sacar e depositar (reuso de código)
    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException {
        if (destino == null) throw new IllegalArgumentException("Conta destino nula");
        sacar(valor); // pode lançar SaldoInsuficienteException
        destino.depositar(valor);
    }

    protected void ajustarSaldo(double valor) throws SaldoInsuficienteException {
        setSaldo(this.getSaldo() + valor);
    }
    protected void debitar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) throw new IllegalArgumentException("Valor de debito deve ser positivo");
        this.ajustarSaldo(-valor);
    }
    protected void creditar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) throw new IllegalArgumentException("Valor de Credito deve ser positivo");
        this.ajustarSaldo(valor);
    }


    @Override
    public String toString() {
        return String.format("Conta %s - Saldo: %.2f", numero, saldo);
    }

}
