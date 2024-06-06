package dto;

import modelo.Livro;

public class LivroDTO {
  private String titulo;
  private String autor;
  private String assunto;
  private int ano;
  private int estoque;
  private int qtdDisponivel;

  public LivroDTO(String titulo, String autor, String assunto, int ano, int estoque, int qtdDisponivel) {
    this.titulo = titulo;
    this.autor = autor;
    this.assunto = assunto;
    this.ano = ano;
    this.estoque = estoque;
    this.qtdDisponivel = qtdDisponivel;
  }

  public LivroDTO(Livro livro, int qtdDisponivel) {
    this.titulo = livro.getTitulo();
    this.autor = livro.getAutor();
    this.assunto = livro.getAssunto();
    this.ano = livro.getAno();
    this.estoque = livro.getEstoque();
    this.qtdDisponivel = qtdDisponivel;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getAssunto() {
    return assunto;
  }

  public void setAssunto(String assunto) {
    this.assunto = assunto;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public int getEstoque() {
    return estoque;
  }

  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

  public int getQtdDisponivel() {
    return qtdDisponivel;
  }

  public void setQtdDisponivel(int qtdDisponivel) {
    this.qtdDisponivel = qtdDisponivel;
  }

  public boolean validarLivro() {
    return (validarStrings(titulo, autor, assunto)
        && validarInteiros(ano, estoque, qtdDisponivel));
  }

  private boolean validarStrings(String... entradas) {
    for (String entrada : entradas) {
      if (entrada.isEmpty() || entrada.equals(" ")) {
        return false;
      }
    }
    return true;
  }

  private boolean validarInteiros(Integer... entradas) {
    for (Integer entrada : entradas) {
      if (entrada < 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String toString() {
    return "{" +
        "Título='" + titulo + "'" +
        ", Autor='" + autor + "'" +
        ", Assunto='" + assunto + "'" +
        ", Ano=" + ano +
        ", Cadastrados=" + estoque +
        ", Disponíveis=" + qtdDisponivel +
        "}";
  }
}
