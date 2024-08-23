package br.com.bprates.core_bank.service;

import br.com.bprates.core_bank.model.domain.TipoTransacao;
import br.com.bprates.core_bank.model.domain.Transacao;
import br.com.bprates.core_bank.model.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao incluir(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> obterLista() {
        return transacaoRepository.findAll();
    }

    public Transacao obterPorId(Integer id) {
        return transacaoRepository.findById(id).orElse(null);
    }

    public List<Transacao> obterListaOrdenadaPorValor() {
        return transacaoRepository.findAll(Sort.by(Sort.Direction.ASC, "valor"));
    }

    public List<Transacao> obterListaOrdenadaPorData() {
        return transacaoRepository.findAll(Sort.by(Sort.Direction.DESC, "data"));
    }

    public List<Transacao> buscarPorTipo(TipoTransacao tipo) {
        return transacaoRepository.findByTipo(tipo);
    }

    public List<Transacao> buscarPorContaId(Integer contaId) {
        return transacaoRepository.findByContaId(contaId);
    }

    public List<Transacao> buscarPorValorMaiorQue(Double valor) {
        return transacaoRepository.findByValorGreaterThan(valor);
    }

    public List<Transacao> obterListaOrdenada(Sort sort) {
        return transacaoRepository.findAll(sort);
    }

    public void excluir(Integer id) {
        transacaoRepository.deleteById(id);
    }
}
