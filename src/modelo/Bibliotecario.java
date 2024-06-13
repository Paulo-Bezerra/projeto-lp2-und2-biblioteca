package modelo;

import dto.BibliotecarioDTO;

import java.time.LocalDate;

public class Bibliotecario extends Usuario {
  private Credencias credencias;

  public Bibliotecario(String nome, String cpf, String matricula, LocalDate dataNascimento, Credencias credencias) {
    super(nome, cpf, matricula, dataNascimento);
    this.credencias = credencias;
  }

  public Bibliotecario(Bibliotecario bibliotecario) {
    super(bibliotecario);
    this.credencias = bibliotecario.getCredencias();
  }

  public Bibliotecario(BibliotecarioDTO bibliotecarioDTO) {
    super(bibliotecarioDTO);
    this.credencias = new Credencias(bibliotecarioDTO.getLogin(), bibliotecarioDTO.getSenha());
  }


  public Credencias getCredencias() {
    return credencias;
  }

  public void setCredencias(Credencias credencias) {
    this.credencias = credencias;
  }
}
