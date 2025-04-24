package br.com.api.services;

import br.com.api.exceptions.UserNotFound;
import br.com.api.infra.entity.Usuario;
import br.com.api.infra.repository.UsuarioRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UsuarioService {

  private UsuarioRepository repository;

  @Autowired
  public UsuarioService(UsuarioRepository repository) {
    this.repository = repository;
  }

  public Usuario buscarUsuario(Long id) {
  return repository.findById(id).orElseThrow(() -> new UserNotFound("Usuário não encontrado"));
  }

}