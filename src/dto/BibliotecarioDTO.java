package dto;

import modelo.Bibliotecario;
import util.Tratamento;

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
    return (Tratamento.validarStrings(this.getNome(), this.getLogin(), this.getSenha())
            && Tratamento.validarStringsNumericas(this.getMatricula())
            && Tratamento.validarCPF(this.getCpf())
            && Tratamento.validarDatas(this.getDataNascimento()));
  }

  @Override
  public String toString() {
    return "Bibliotecário: {" +
           "Nome: '" + this.getNome() + "'" +
           ", CPF: '" + this.getCpf() + "'" +
           ", Matrícula: '" + this.getMatricula() + "'" +
           ", Data de nascimento: '" + this.getDataNascimento() + "'" +
           ", Login: " + this.getLogin() +
           "}";
  }
}
