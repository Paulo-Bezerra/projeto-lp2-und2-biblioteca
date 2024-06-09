package dto;

import modelo.Professor;
import modelo.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

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
    return (validarStrings(this.getNome(), this.getMatricula(), this.getDepartamento()) && validarCPF(this.getCpf()) && validarData(this.getDataNascimento()));
  }

  // Método para validar o formato do cpf (apenas dígitos) usando regex
  private static boolean validarCPF(String cpf) {
    return (cpf.length() == 11 && cpf.matches("^\\d{11}$"));
  }

  // Método para validar a data usando LocalDate
  private static boolean validarData(String data) {
    if (!validarFormatoData(data)) {
      return false;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    try {
      LocalDate.parse(data, formatter);
    } catch (DateTimeParseException e) {
      return false;
    }
    return true;
  }

  // Método para validar o formato da data usando regex
  private static boolean validarFormatoData(String data) {
    Pattern pattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
    return pattern.matcher(data).matches();
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
