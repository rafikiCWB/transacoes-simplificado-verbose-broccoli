package br.com.api.infra.repository;

import br.com.api.infra.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends JpaRepository<Transacoes, Long> {
}

