package br.com.bprates.core_bank.clients.CpfCnpjClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cpfCnpjClient", url = "https://www.4devs.com.br")
public interface CpfCnpjClient {

    // TODO: Tentei usar essa api mas não achei a documentação adeaquada melhorar em um futuro próximo
    @GetMapping("/validador_cpf")
    Boolean validarCpf(@RequestParam("cpf") String cpf);
}
