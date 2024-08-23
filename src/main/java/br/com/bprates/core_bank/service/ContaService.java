package br.com.bprates.core_bank.service;

import br.com.bprates.core_bank.model.domain.Conta;
import br.com.bprates.core_bank.model.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta incluir(Conta conta) {
        return contaRepository.save(conta);
    }

    public List<Conta> obterLista() {
        return contaRepository.findAll();
    }

    public Conta obterPorId(Integer id) {
        return contaRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        contaRepository.deleteById(id);
    }
}

