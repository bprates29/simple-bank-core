package br.com.bprates.core_bank.model.domain;

public class ValidacaoDebitoStrategy implements ValidacaoTransacaoStrategy {
    @Override
    public boolean validar(Transacao transacao) {
        return transacao.getConta().getSaldo() >= transacao.getValor();
    }
} 