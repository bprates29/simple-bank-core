package br.com.bprates.core_bank.service;

import br.com.bprates.core_bank.model.domain.Cliente;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {
    private final Map<Integer, Cliente> clienteMap = new HashMap<>();

    public void incluir(Cliente cliente) {
        clienteMap.put(cliente.getId(), cliente);
    }

    public Collection<Cliente> obterLista() {
        return clienteMap.values();
    }

    public Cliente obterPorId(Integer id) {
        return clienteMap.get(id);
    }

    public void excluir(Integer id) {
        clienteMap.remove(id);
    }
}
