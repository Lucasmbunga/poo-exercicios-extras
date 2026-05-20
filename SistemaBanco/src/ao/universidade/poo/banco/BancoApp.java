package ao.universidade.poo.banco;

import java.util.ArrayList;
import java.util.List;

public class BancoApp {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>();

        ContaCorrente cc1 = new ContaCorrente("001", 500.0, 300.0);
        ContaPoupanca cp1 = new ContaPoupanca("002", 1000.0, 0.01);

        contas.add(cc1);
        contas.add(cp1);

        System.out.println("Estado inicial das contas:");
        imprimirContas(contas);
        System.out.println();

        // Demonstra polimorfismo: chamamos depositar em referência Conta
        System.out.println("Depositando 200 em todas as contas:");
        for (Conta c : contas) {
            c.depositar(200);
        }
        imprimirContas(contas);
        System.out.println();

        // Testando saques com tratamento de exceção
        try {
            System.out.println("Tentando sacar 1000 da conta corrente (deve usar limite):");
            cc1.sacar(1000); // saldo 700 + limite 300 = 1000 => permitido
            System.out.println("Saque efetuado.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        imprimirContas(contas);
        System.out.println();

        try {
            System.out.println("Tentando sacar 5000 da poupança (deve falhar):");
            cp1.sacar(5000);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        imprimirContas(contas);
        System.out.println();

        // Transferência usando método da superclasse (reuso)
        try {
            System.out.println("Transferindo 300 da poupança para a conta corrente:");
            cp1.transferir(cc1, 300);
            System.out.println("Transferência efetuada.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        imprimirContas(contas);
        System.out.println();

        // Aplicar rendimento apenas para poupança — demonstra uso de instanceof (quando necessário)
        for (Conta c : contas) {
            if (c instanceof ContaPoupanca) {
                ContaPoupanca cp = (ContaPoupanca) c;
                cp.aplicarRendimento();
                System.out.println("Rendimento aplicado em " + cp.getNumero());
            }
        }
        imprimirContas(contas);
    }

    private static void imprimirContas(List<Conta> contas) {
        for (Conta c : contas) {
            System.out.println(c); // chama toString apropriado (polimorfismo)
        }
    }

}
