package br.com.bprates.core_bank.clients.CpfCnpjClient;

import br.com.bprates.core_bank.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepClient", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    Endereco getAddressByCep(@PathVariable("cep") String cep);
}
