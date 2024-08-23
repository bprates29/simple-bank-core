package br.com.bprates.core_bank.service;

import br.com.bprates.core_bank.model.domain.Cliente;
import br.com.bprates.core_bank.model.domain.Endereco;
import br.com.bprates.core_bank.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    public List<Cliente> obterLista() {
        return clienteRepository.findAll();
    }

    public Cliente obterPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Cliente> obterClientesAtivos() {
        return clienteRepository.findByIsAtivoTrue();
    }

    public Cliente incluir(Cliente cliente) {
                return clienteRepository.save(cliente);
    }

    public void excluir(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Endereco getEnderecoById(Integer id) {
        var cliente = obterPorId(id);
        return enderecoService.getAddressByCep(cliente.getCep());
    }
}