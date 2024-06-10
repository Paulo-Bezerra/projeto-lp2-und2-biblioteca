package dto;

import modelo.Usuario;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public abstract class UsuarioDTO implements IValidacaoDeDTO {
  private String nome;
  private String cpf;
  private String matricula;
  private String dataNascimento;
  private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public UsuarioDTO(String nome, String cpf, String matricula, String dataNascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.matricula = matricula;
    this.dataNascimento = dataNascimento;
  }

  public UsuarioDTO(UsuarioDTO usuarioDTO) {
    this.nome = usuarioDTO.getNome();
    this.cpf = usuarioDTO.getCpf();
    this.matricula = usuarioDTO.getMatricula();
    this.dataNascimento = usuarioDTO.getDataNascimento();
  }

  public UsuarioDTO(Usuario usuario) {
    this.nome = usuario.getNome();
    this.cpf = usuario.getCpf();
    this.matricula = usuario.getMatricula();
    // Formata o LocalDate para o formato dd/MM/yyyy
    this.dataNascimento = usuario.getDataNascimento().format(this.getFormato());
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

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public DateTimeFormatter getFormato() {
    return formato;
  }
}
