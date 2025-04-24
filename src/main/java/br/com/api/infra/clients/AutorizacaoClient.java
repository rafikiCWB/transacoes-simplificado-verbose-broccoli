package br.com.api.infra.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "autorizacao", url = "https://util.devi.tools/api/v2/authorize")
public interface AutorizacaoClient {

  @GetMapping
  AutorizacaoDTO validarAutorizacao();

}
