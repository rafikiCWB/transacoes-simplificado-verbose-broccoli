package br.com.api.services;

import br.com.api.infra.clients.AutorizacaoClient;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@NoArgsConstructor
public class AutorizacaoService {

  private AutorizacaoClient client;

  public boolean validarTransferencia(){
    if(Objects.equals(client.validarAutorizacao().data().authorization(), "true")){
      return true;
    }
    return false;
  }

}
