package br.com.bprates.core_bank.service;

import br.com.bprates.core_bank.clients.CpfCnpjClient.ViaCepClient;
import br.com.bprates.core_bank.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private ViaCepClient viaCepClient;

    public Endereco getAddressByCep(String cep) {
        return viaCepClient.getAddressByCep(cep);
    }
}
