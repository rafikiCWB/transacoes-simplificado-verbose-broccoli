package br.com.api.services;

import br.com.api.controller.TransacaoDTO;
import br.com.api.exceptions.BadRequestException;
import br.com.api.infra.entity.Carteira;
import br.com.api.infra.entity.TipoUsuario;
import br.com.api.infra.entity.Transacoes;
import br.com.api.infra.entity.Usuario;
import br.com.api.infra.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransacaoService {

  private final UsuarioService usuarioService;
  private final AutorizacaoService autorizacaoService;
  private final CarteiraService carteiraService;
  private final TransacaoRepository repository;
  private final NotificacaoService notificacaoService;

  @Transactional
  public void transferirValores(TransacaoDTO transacaoDTO) {
    Usuario pagador = usuarioService.buscarUsuario(transacaoDTO.payer());
    Usuario recebedor = usuarioService.buscarUsuario(transacaoDTO.payee());

    validaPagadorLojista(pagador);
    validarSaldoUsuario(pagador, transacaoDTO.value());
    validarTranferencia();

    pagador.getCarteira().setSaldo(pagador.getCarteira().getSaldo().subtract(transacaoDTO.value()));
    atualizarSaldoCarteira(pagador.getCarteira());
    recebedor.getCarteira().setSaldo(pagador.getCarteira().getSaldo().add(transacaoDTO.value()));
    atualizarSaldoCarteira(recebedor.getCarteira());

    Transacoes transacoes = Transacoes.builder()
        .valor(transacaoDTO.value())
        .pagador(pagador)
        .recebedor(recebedor)
        .build();

    repository.save(transacoes);
    enviarNotificacao();

  }

  private void validaPagadorLojista(Usuario tipoPagador) {
    try {
      if (tipoPagador.getTipoUsuario().equals(TipoUsuario.LOJISTA)) {
        throw new IllegalArgumentException("Transação não permitida para lojista!");
      }
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  private void validarSaldoUsuario(Usuario usuario, BigDecimal valor) {
    try {
      if (usuario.getCarteira().getSaldo().compareTo(valor) < 0) {
        throw new IllegalArgumentException("Transação não autorizada, saldo insuficiente");
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  private void validarTranferencia() {
    try {
      if (!autorizacaoService.validarTransferencia()) {
        throw new IllegalArgumentException("Transação não autorizada pela api");
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  private void atualizarSaldoCarteira(Carteira carteira) {
    carteiraService.salvar(carteira);
  }

  private void enviarNotificacao() {
    try {
      notificacaoService.enviarNotificacao();
    } catch (HttpClientErrorException e) {
      new BadRequestException("Erro ao enviar notificacao");
    }
  }

}