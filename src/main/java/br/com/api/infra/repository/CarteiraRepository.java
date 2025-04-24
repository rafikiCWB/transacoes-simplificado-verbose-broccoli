package br.com.api.infra.repository;

import br.com.api.infra.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
