package br.com.api.exceptions;

public class UserNotFound extends RuntimeException {

  public UserNotFound(String mensagem){
    super(mensagem);
  }
}


