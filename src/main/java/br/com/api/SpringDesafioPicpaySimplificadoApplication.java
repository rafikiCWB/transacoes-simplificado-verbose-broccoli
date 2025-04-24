package br.com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringDesafioPicpaySimplificadoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringDesafioPicpaySimplificadoApplication.class, args);
  }

}
