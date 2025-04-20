package br.com.api.infra.repository;

import br.com.api.infra.entity.Carteira;
import org.springframework.data.repository.CrudRepository;

public interface CarteiraRepository extends CrudRepository<Carteira, Long> {

}