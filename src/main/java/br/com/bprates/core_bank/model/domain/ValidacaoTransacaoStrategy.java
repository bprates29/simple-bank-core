package br.com.bprates.core_bank.model.domain;

public interface ValidacaoTransacaoStrategy {
    boolean validar(Transacao transacao);
} 