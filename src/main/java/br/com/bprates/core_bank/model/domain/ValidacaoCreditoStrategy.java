package br.com.bprates.core_bank.model.domain;

public class ValidacaoCreditoStrategy implements ValidacaoTransacaoStrategy {
    @Override
    public boolean validar(Transacao transacao) {
        return true;
    }
} 