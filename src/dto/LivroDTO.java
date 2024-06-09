package dto;

import modelo.Livro;

public class LivroDTO implements IValidacaoDeDTO {
  private String titulo;
  private String autor;
  private String isbn;
  private String assunto;
  private int ano;
  private int estoque;
  private int qtdDisponivel;


  public LivroDTO(String titulo, String autor, String isbn, String assunto, int ano, int estoque, int qtdDisponivel) {
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
    this.assunto = assunto;
    this.ano = ano;
    this.estoque = estoque;
    this.qtdDisponivel = qtdDisponivel;
  }

  public LivroDTO(Livro livro, int qtdDisponivel) {
    this.titulo = livro.getTitulo();
    this.autor = livro.getAutor();
    this.isbn = livro.getIsbn();
    this.assunto = livro.getAssunto();
    this.ano = livro.getAno();
    this.estoque = livro.getEstoque();
    this.qtdDisponivel = qtdDisponivel;
  }

  public LivroDTO(LivroDTO livroDTO) {
    this.titulo = livroDTO.getTitulo();
    this.autor = livroDTO.getAutor();
    this.isbn = livroDTO.getIsbn();
    this.assunto = livroDTO.getAssunto();
    this.ano = livroDTO.getAno();
    this.estoque = livroDTO.getEstoque();
    this.qtdDisponivel = livroDTO.getQtdDisponivel();
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

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
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

  public boolean validar() {
    return (validarStrings(titulo, autor, isbn, assunto)
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
    return "Livro: {" +
        "Título: '" + titulo + "'" +
        ", Autor: '" + autor + "'" +
        ", ISBN: '" + isbn + "'" +
        ", Assunto: '" + assunto + "'" +
        ", Ano: " + ano +
        ", Cadastrados: " + estoque +
        ", Disponíveis: " + qtdDisponivel +
        "}";
  }
}
