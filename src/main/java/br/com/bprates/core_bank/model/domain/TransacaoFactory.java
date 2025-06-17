package br.com.bprates.core_bank.model.domain;

public class TransacaoFactory {
    public static Transacao criarTransacao(Double valor, String descricao, TipoTransacao tipo, Conta conta) {
        return new Transacao(valor, descricao, tipo, conta);
    }
} 