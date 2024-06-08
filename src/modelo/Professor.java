package modelo;

import java.time.LocalDate;

public class Professor extends Usuario {
  private String departamento;

  public Professor(String nome, String cpf, String matricula, LocalDate dataNascimento, String departamento) {
    super(nome, cpf, matricula, dataNascimento);
  }

  public Professor(Professor professor) {
    super(professor.getNome(), professor.getCpf(), professor.getMatricula(), professor.getDataNascimento());
    this.departamento = professor.getDepartamento();
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
}
