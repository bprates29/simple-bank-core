package br.com.bprates.core_bank;

import br.com.bprates.core_bank.model.domain.Cliente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ClienteLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        String filePath = "cliente.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                Cliente cliente = new Cliente();
                cliente.setId(Integer.valueOf(values[0]));
                cliente.setNome(values[1]);
                cliente.setEmail(values[2]);
                cliente.setAtivo(Boolean.valueOf(values[3]));

                System.out.println(cliente);
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
