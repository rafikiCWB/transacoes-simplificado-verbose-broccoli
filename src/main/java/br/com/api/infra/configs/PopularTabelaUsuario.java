package br.com.api.infra.configs;

import br.com.api.infra.entity.Carteira;
import br.com.api.infra.entity.TipoUsuario;
import br.com.api.infra.entity.Usuario;
import br.com.api.infra.repository.CarteiraRepository;
import br.com.api.infra.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class PopularTabelaUsuario  {

  private static final Logger log = LoggerFactory.getLogger(PopularTabelaUsuario.class);

  /**
   * Initial seed database
   */
  @Bean
  public CommandLineRunner popularBanco(UsuarioRepository usuarioRepository, CarteiraRepository carteiraRepository) throws Exception {
    return args -> {
      if (usuarioRepository.count() == 0) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Usuario lojista = new Usuario(null, "BrisaStore", "BrisaStore@email.com", "0001-123456789", encoder.encode("102030"), null, TipoUsuario.LOJISTA);

        Usuario usuario1 = new Usuario(null, "John Doe", "John@email.com", "10987654321", encoder.encode("123456"), null, TipoUsuario.COMUM);

        Usuario usuario2 = new Usuario(null, "Jane Doe", "Jane@email.com", "11223344556", encoder.encode("654321"), null, TipoUsuario.COMUM);

        usuarioRepository.saveAll(List.of(lojista, usuario1, usuario2));

        Carteira carteira2 = new Carteira(null, BigDecimal.valueOf(6750.00), lojista);
        Carteira carteira1 = new Carteira(null, BigDecimal.valueOf(7750.00), usuario1);
        Carteira carteira3 = new Carteira(null, BigDecimal.valueOf(5750.00), usuario2);

        carteiraRepository.saveAll(List.of(carteira1, carteira2, carteira3));

        log.info("Usuários e carteiras populados com sucesso!");
      }
    };
  }

}