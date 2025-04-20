package br.com.api.infra.entity;

import jakarta.persistence.*;

@Entity(name = "usuario")
@Table(name = "tbl_usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idUsuario;

  private String nomeCompleto;
  @Column(unique = true, nullable = false)
  private String email;
  @Column(unique = true, nullable = false)
  private String cpfCnpj;

  public Long getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Long id) {
    this.idUsuario = id;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpfCnpj() {
    return cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }
}
