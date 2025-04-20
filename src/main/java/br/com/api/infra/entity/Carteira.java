package br.com.api.infra.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "carteira")
@Table(name = "tbl_carteira")
public class Carteira {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal saldo;

  @OneToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  public Carteira() {
  }

  public Carteira(Long id, BigDecimal salario, Usuario usuario) {
    this.id = id;
    this.saldo = salario;
    this.usuario = usuario;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getSaldo() {
    return saldo;
  }

  public void setSaldo(BigDecimal salario) {
    this.saldo = salario;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

}