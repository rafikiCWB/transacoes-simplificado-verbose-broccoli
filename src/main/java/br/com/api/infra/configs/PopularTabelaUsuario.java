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

//  private static final Logger log = LoggerFactory.getLogger(PopularTabelaUsuario.class);

  /**
   * Initial seed database
   */

  @Bean
  CommandLineRunner popularBanco(UsuarioRepository usuarioRepository, CarteiraRepository carteiraRepository) {
    return args -> {
      if (usuarioRepository.count() == 0) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Usuario usuario1 = new Usuario(null, "Carlos Silva", "carlos@email.com", "101111111111",
            encoder.encode("123456"), null, TipoUsuario.COMUM);

        Usuario usuario2 = new Usuario(null, "Ana Souza", "ana@email.com", "22222222222",
            encoder.encode("123456"), null, TipoUsuario.COMUM);

        Usuario lojista = new Usuario(null, "Loja Exemplo", "loja@email.com", "33333333333",
            encoder.encode("123456"), null, TipoUsuario.LOJISTA);

        usuarioRepository.saveAll(List.of(usuario1, usuario2, lojista));


        Carteira carteira1 = new Carteira(null, new BigDecimal("1000.00"), usuario1);
        Carteira carteira2 = new Carteira(null, new BigDecimal("2000.00"), usuario2);
        Carteira carteira3 = new Carteira(null, new BigDecimal("5000.00"), lojista);

        carteiraRepository.saveAll(List.of(carteira1, carteira2, carteira3));

        System.out.println("Usuários e carteiras populados com sucesso!");
      }
    };
  }
  }
