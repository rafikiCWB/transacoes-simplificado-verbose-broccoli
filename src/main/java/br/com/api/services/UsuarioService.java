package br.com.api.services;

import br.com.api.exceptions.UserNotFound;
import br.com.api.infra.entity.Usuario;
import br.com.api.infra.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

  private final UsuarioRepository repository;

  public Usuario buscarUsuario(Long id){
    return repository.findById(id)
        .orElseThrow(() ->
            new UserNotFound("Usuário não encontrado"));
  }
}
