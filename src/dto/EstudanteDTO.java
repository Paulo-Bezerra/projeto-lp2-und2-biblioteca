package dto;


import modelo.Estudante;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class EstudanteDTO extends UsuarioDTO {
  private String curso;

  public EstudanteDTO(String nome, String cpf, String matricula, String dataNascimento, String curso) {
    super(nome, cpf, matricula, dataNascimento);
    this.curso = curso;
  }

  public EstudanteDTO(EstudanteDTO estudanteDTO) {
    super(estudanteDTO);
    this.curso = estudanteDTO.getCurso();

  }

  public EstudanteDTO(Estudante estudante) {
    super(estudante);
    this.curso = estudante.getCurso();
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  @Override
  public boolean validar() {
    return (validarStrings(this.getNome(), this.getMatricula(), this.getCurso()) && validarCPF(this.getCpf()) && validarData(this.getDataNascimento()));
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
    return "Estudante: {" +
           "Nome: '" + this.getNome() + "'" +
           ", CPF: '" + this.getCpf() + "'" +
           ", Matrícula: '" + this.getMatricula() + "'" +
           ", Data de nascimento: '" + this.getDataNascimento() + "'" +
           ", Curso: " + this.getCurso() +
           "}";
  }
}
