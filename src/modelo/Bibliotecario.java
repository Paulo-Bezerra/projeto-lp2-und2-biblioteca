package modelo;

import java.time.LocalDate;

public class Bibliotecario extends Usuario {

  public Bibliotecario(String nome, String cpf, String matricula, LocalDate dataNascimento) {
    super(nome, cpf, matricula, dataNascimento);
  }

  public Bibliotecario(Bibliotecario bibliotecario) {
    super(bibliotecario);
  }
}
