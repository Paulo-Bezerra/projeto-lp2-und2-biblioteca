package dto;

import modelo.Livro;
import util.Tratamento;

public class LivroDTO implements IValidacaoDeDTO {
  private String titulo;
  private String autor;
  private String assunto;
  private String isbn;
  private int ano;
  private int estoque;
  private int qtdDisponivel;


  public LivroDTO(String titulo, String autor, String assunto, String isbn, int ano, int estoque, int qtdDisponivel) {
    this.titulo = titulo;
    this.autor = autor;
    this.assunto = assunto;
    this.isbn = isbn;
    this.ano = ano;
    this.estoque = estoque;
    this.qtdDisponivel = qtdDisponivel;
  }

  public LivroDTO(Livro livro, int qtdDisponivel) {
    this.titulo = livro.getTitulo();
    this.autor = livro.getAutor();
    this.assunto = livro.getAssunto();
    this.isbn = livro.getIsbn();
    this.ano = livro.getAno();
    this.estoque = livro.getEstoque();
    this.qtdDisponivel = qtdDisponivel;
  }

  public LivroDTO(LivroDTO livroDTO) {
    this.titulo = livroDTO.getTitulo();
    this.autor = livroDTO.getAutor();
    this.assunto = livroDTO.getAssunto();
    this.isbn = livroDTO.getIsbn();
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

  public String getAssunto() {
    return assunto;
  }

  public void setAssunto(String assunto) {
    this.assunto = assunto;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
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
    return (Tratamento.validarStrings(titulo, autor, assunto)
            && Tratamento.validarStringsNumericas(isbn)
            && Tratamento.validarInteirosPositivos(ano, estoque, qtdDisponivel));
  }

  @Override
  public String toString() {
    return "Livro: {" +
        "Título: " + titulo +
        ", Autor: " + autor +
        ", Assunto: " + assunto +
        ", ISBN: " + isbn +
        ", Ano: " + ano +
        ", Cadastrados: " + estoque +
        ", Disponíveis: " + qtdDisponivel +
        "}";
  }
}
