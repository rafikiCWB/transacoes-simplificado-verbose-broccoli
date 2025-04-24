package br.com.api.services;

import br.com.api.infra.entity.Carteira;
import br.com.api.infra.repository.CarteiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarteiraService {

  private final CarteiraRepository repository;

  public void salvar(Carteira carteira){
    repository.save(carteira);
  }
}
