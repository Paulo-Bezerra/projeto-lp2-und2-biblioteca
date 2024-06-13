package modelo;

import dto.ProfessorDTO;
import util.TipoUsuario;

import java.time.LocalDate;

public class Professor extends Usuario {
  private String departamento;

  public Professor(String nome, String cpf, String matricula, LocalDate dataNascimento, String departamento) {
    super(nome, cpf, matricula, dataNascimento);
    this.departamento = departamento;
  }

  public Professor(Professor professor) {
    super(professor);
    this.departamento = professor.getDepartamento();
  }

  public Professor(ProfessorDTO professorDTO) {
    super(professorDTO);
    this.departamento = professorDTO.getDepartamento();
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
}
