package br.com.bprates.core_bank;

import br.com.bprates.core_bank.model.domain.Cliente;
import br.com.bprates.core_bank.model.domain.Conta;
import br.com.bprates.core_bank.model.domain.Transacao;
import br.com.bprates.core_bank.model.domain.TipoTransacao;
import br.com.bprates.core_bank.model.domain.TransacaoFactory;
import br.com.bprates.core_bank.service.ClienteService;
import br.com.bprates.core_bank.service.ContaService;
import br.com.bprates.core_bank.service.TransacaoService;
import br.com.bprates.core_bank.model.domain.ValidacaoTransacaoStrategy;
import br.com.bprates.core_bank.model.domain.ValidacaoCreditoStrategy;
import br.com.bprates.core_bank.model.domain.ValidacaoDebitoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaFacade {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TransacaoService transacaoService;

    public Conta abrirContaParaCliente(Integer clienteId, String numeroConta, Double saldoInicial) {
        Cliente cliente = clienteService.obterPorId(clienteId);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        Conta conta = new Conta(saldoInicial, numeroConta, cliente);
        return contaService.incluir(conta);
    }

    public Transacao realizarTransacao(Integer contaId, Double valor, String descricao, TipoTransacao tipo) {
        Conta conta = contaService.obterPorId(contaId);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada");
        }
        Transacao transacao = TransacaoFactory.criarTransacao(valor, descricao, tipo, conta);

        ValidacaoTransacaoStrategy strategy;
        if (tipo == TipoTransacao.CREDITO) {
            strategy = new ValidacaoCreditoStrategy();
        } else {
            strategy = new ValidacaoDebitoStrategy();
        }
        if (!strategy.validar(transacao)) {
            throw new IllegalArgumentException("Transação inválida para o tipo e saldo da conta");
        }
        return transacaoService.incluir(transacao);
    }

    public Double consultarSaldo(Integer contaId) {
        Conta conta = contaService.obterPorId(contaId);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada");
        }
        return conta.getSaldo();
    }
} 