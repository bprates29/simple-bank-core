package br.com.bprates.core_bank.model.repository;

import br.com.bprates.core_bank.model.domain.TipoTransacao;
import br.com.bprates.core_bank.model.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<Transacao> findAll(Sort sort);

    List<Transacao> findByTipo(TipoTransacao tipo);

    List<Transacao> findByContaId(Integer contaId);

    List<Transacao> findByValorGreaterThan(Double valor);
}

