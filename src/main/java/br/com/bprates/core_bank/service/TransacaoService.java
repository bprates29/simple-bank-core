package br.com.bprates.core_bank.service;

import br.com.bprates.core_bank.model.domain.Transacao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TransacaoService {
    private final Map<Integer, Transacao> transacaoMap = new HashMap<>();

    public void incluir(Transacao transacao) {
        transacaoMap.put(transacao.getId(), transacao);
    }

    public Collection<Transacao> obterLista() {
        return transacaoMap.values();
    }

    public Transacao obterPorId(Integer id) {
        return transacaoMap.get(id);
    }

    public void excluir(Integer id) {
        transacaoMap.remove(id);
    }
}
