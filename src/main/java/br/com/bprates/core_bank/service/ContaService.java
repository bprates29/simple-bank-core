package br.com.bprates.core_bank.service;

import br.com.bprates.core_bank.model.domain.Conta;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ContaService {
    private final Map<Integer, Conta> contaMap = new HashMap<>();

    public void incluir(Conta conta) {
        contaMap.put(conta.getId(), conta);
    }

    public Collection<Conta> obterLista() {
        return contaMap.values();
    }

    public Conta obterPorId(Integer id) {
        return contaMap.get(id);
    }

    public void excluir(Integer id) {
        contaMap.remove(id);
    }
}
