package util;

public enum FiltroLivro {
  POR_TITULO(1, "Por título"),
  POR_AUTOR(2, "Por autor"),
  POR_ISBN(3, "Por ISBN"),
  POR_ASSUNTO(4, "Por assunto");

  private final int codigo;
  private final String descricao;

  FiltroLivro(int codigo, String descricao) {
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
