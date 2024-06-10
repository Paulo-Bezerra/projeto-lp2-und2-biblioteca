package dto;

import util.Tratamento;

public class CredenciasDTO implements IValidacaoDeDTO {
  private String login;
  private String senha;

  public CredenciasDTO(String login, String senha) {
    this.login = login;
    this.senha = senha;
  }

  public CredenciasDTO(CredenciasDTO credenciasDTO) {
    this.login = credenciasDTO.getLogin();
    this.senha = credenciasDTO.getSenha();
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
    return Tratamento.validarStrings(login, senha);
  }
}
