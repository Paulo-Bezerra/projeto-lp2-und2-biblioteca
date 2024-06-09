package modelo;

import dto.LivroDTO;

import java.util.Objects;

public class Livro {
  private String titulo;
  private String autor;
  private String isbn;
  private String assunto;
  private int ano;
  private int estoque;

  public Livro(String titulo, String autor, String isbn, String assunto, int ano, int estoque) {
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
    this.assunto = assunto;
    this.ano = ano;
    this.estoque = estoque;
  }

  public Livro(Livro livro) {
    this.titulo = livro.getTitulo();
    this.autor = livro.getAutor();
    this.isbn = livro.getIsbn();
    this.assunto = livro.getAssunto();
    this.ano = livro.getAno();
    this.estoque = livro.getEstoque();
  }

  public Livro(LivroDTO livroDTO) {
    this.titulo = livroDTO.getTitulo();
    this.autor = livroDTO.getAutor();
    this.isbn = livroDTO.getIsbn();
    this.assunto = livroDTO.getAssunto();
    this.ano = livroDTO.getAno();
    this.estoque = livroDTO.getEstoque();
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Livro livro = (Livro) o;
    return Objects.equals(isbn, livro.isbn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn);
  }
}
