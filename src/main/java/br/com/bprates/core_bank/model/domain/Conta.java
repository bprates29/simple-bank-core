package br.com.bprates.core_bank.model.domain;

import java.util.List;

public class Conta {
    private Integer id;
    private Double saldo;
    private String numeroConta;

    private Cliente cliente;

    private List<Transacao> transacoes;

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
