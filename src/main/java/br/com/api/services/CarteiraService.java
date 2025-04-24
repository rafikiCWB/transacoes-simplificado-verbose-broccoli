package br.com.api.services;

import br.com.api.infra.entity.Carteira;
import br.com.api.infra.repository.CarteiraRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CarteiraService {

  private CarteiraRepository repository;

  @Autowired
  public CarteiraService(CarteiraRepository repository) {
    this.repository = repository;
  }

  public void salvar(Carteira carteira) {
    repository.save(carteira);
  }
}
