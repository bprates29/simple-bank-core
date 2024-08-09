package br.com.bprates.core_bank;

import br.com.bprates.core_bank.model.domain.Conta;
import br.com.bprates.core_bank.model.domain.TipoTransacao;
import br.com.bprates.core_bank.model.domain.Transacao;
import br.com.bprates.core_bank.service.ContaService;
import br.com.bprates.core_bank.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class TransacaoLoader implements ApplicationRunner {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private ContaService contaService;

    @Override
    public void run(ApplicationArguments args) {
        String filePath = "files/transacoes.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                Transacao transacao = new Transacao();
                transacao.setId(Integer.valueOf(values[0]));
                transacao.setValor(Double.parseDouble(values[1]));
                transacao.setDescricao(values[2]);
                transacao.setTipo(TipoTransacao.valueOf(values[3].toUpperCase()));

                Conta conta = contaService.obterPorId(Integer.valueOf(values[4]));
                if (conta != null) {
                    transacao.setConta(conta);
                }

                transacaoService.incluir(transacao);
                System.out.println(transacao);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
