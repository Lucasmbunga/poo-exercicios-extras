package ao.universidade.poo.banco;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String senha;
    private List<Conta> contas= new ArrayList<Conta>();

    public Cliente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public void transferir(Conta conta,double valor){
        if(valor<=0) throw new IllegalArgumentException("O valor de transferência deve ser maior que zero");
        conta.setSaldo(conta.getSaldo()+valor);
        System.out.println("Transferencia realizada com sucesso!");
    }
    public void adicionarConta(Conta conta){
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso!");
    }

    public List<Conta> getContas() {
        return contas;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
