package modelo;

import java.time.LocalDate;

public abstract class Usuario {
  private String nome;
  private String cpf;
  private String matricula;
  private LocalDate dataNascimento;

  public Usuario(String nome, String cpf, String matricula, LocalDate dataNascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.matricula = matricula;
    this.dataNascimento = dataNascimento;
  }

  public Usuario(Usuario usuario) {
    this.nome = usuario.getNome();
    this.cpf = usuario.getCpf();
    this.matricula = usuario.getMatricula();
    this.dataNascimento = usuario.getDataNascimento();
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
}

