package dto;

import modelo.Bibliotecario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class BibliotecarioDTO extends UsuarioDTO {
  private String login;
  private String senha;

  public BibliotecarioDTO(String nome, String cpf, String matricula, String dataNascimento, String login, String senha) {
    super(nome, cpf, matricula, dataNascimento);
    this.login = login;
    this.senha = senha;
  }

  public BibliotecarioDTO(BibliotecarioDTO bibliotecarioDTO) {
    super(bibliotecarioDTO);
    this.login = bibliotecarioDTO.getLogin();
    this.senha = bibliotecarioDTO.getSenha();
  }

  public BibliotecarioDTO(Bibliotecario bibliotecario) {
    super(bibliotecario);
    this.login = bibliotecario.getCredencias().getLogin();
    this.senha = bibliotecario.getCredencias().getSenha();
  }


  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  @Override
  public boolean validar() {
    return (validarStrings(this.getNome(), this.getMatricula(), this.getLogin(), this.getSenha()) && validarCPF(this.getCpf()) && validarData(this.getDataNascimento()));
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
}
