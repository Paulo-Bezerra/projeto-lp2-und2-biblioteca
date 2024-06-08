package dto;

public class CredenciasDTO {
  private String nome;
  private String senha;

  public CredenciasDTO(String nome, String senha) {
    this.nome = nome;
    this.senha = senha;
  }

  public CredenciasDTO(CredenciasDTO credenciasDTO) {
    this.nome = credenciasDTO.getNome();
    this.senha = credenciasDTO.getSenha();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
