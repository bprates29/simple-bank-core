package br.com.bprates.core_bank.model.repository;

import br.com.bprates.core_bank.model.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
