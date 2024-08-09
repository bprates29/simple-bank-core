package br.com.bprates.core_bank;

import br.com.bprates.core_bank.model.domain.Cliente;
import br.com.bprates.core_bank.model.domain.Conta;
import br.com.bprates.core_bank.service.ClienteService;
import br.com.bprates.core_bank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ContaLoader implements ApplicationRunner {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public void run(ApplicationArguments args) {
        String filePath = "files/conta.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                Conta conta = new Conta();
                conta.setId(Integer.valueOf(values[0]));
                conta.setSaldo(Double.parseDouble(values[1]));
                conta.setNumeroConta(values[2]);

                Cliente cliente = clienteService.obterPorId(Integer.valueOf(values[3]));
                if (cliente != null) {
                    conta.setCliente(cliente);
                }

                contaService.incluir(conta);
                System.out.println(conta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
