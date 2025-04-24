package br.com.api.services;

import br.com.api.infra.clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

  private NotificacaoClient client;

  public void enviarNotificacao() {
    client.enviarNotificacao();
  }
}
