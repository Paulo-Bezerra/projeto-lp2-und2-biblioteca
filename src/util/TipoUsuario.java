package util;

public enum TipoUsuario {
  TIPO_ESTUDANTE(1, "Estudante"),
  TIPO_PROFESSOR(2, "Professor"),
  TIPO_BIBLIOTECARIO(3, "Biblioteca"),;

  private final int codigo;
  private final String descricao;

  TipoUsuario(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public int getCodigo() {
    return codigo;
  }
  public String getDescricao() {
    return descricao;
  }
}
