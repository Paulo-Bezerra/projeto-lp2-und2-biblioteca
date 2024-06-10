package dto;

import modelo.Professor;
import util.Tratamento;

public class ProfessorDTO extends UsuarioDTO {
  private String departamento;

  public ProfessorDTO(String nome, String cpf, String matricula, String dataNascimento, String departamento) {
    super(nome, cpf, matricula, dataNascimento);
    this.departamento = departamento;
  }

  public ProfessorDTO(ProfessorDTO professorDTO) {
    super(professorDTO);
    this.departamento = professorDTO.getDepartamento();
  }

  public ProfessorDTO(Professor professor) {
    super(professor);
    this.departamento = professor.getDepartamento();
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  @Override
  public boolean validar() {
    return (Tratamento.validarStrings(this.getNome(), this.getDepartamento())
            && Tratamento.validarStringNumerica(this.getMatricula())
            && Tratamento.validarCPF(this.getCpf())
            && Tratamento.validarDatas(this.getDataNascimento()));
  }

  @Override
  public String toString() {
    return "Professor: {" +
           "Nome: '" + this.getNome() + "'" +
           ", CPF: '" + this.getCpf() + "'" +
           ", Matrícula: '" + this.getMatricula() + "'" +
           ", Data de nascimento: '" + this.getDataNascimento() + "'" +
           ", Departamento: " + this.getDepartamento() +
           "}";
  }
}
