package dto;

import util.Tratamento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class EmprestimoDTO implements IValidacaoDeDTO {
  String nomeUsuario;
  String matriculaUsuario;
  String nomeLivro;
  String isbn;
  String dataEmprestimo;
  String dataDevolucao;

  public EmprestimoDTO(String nomeUsuario, String matriculaUsuario, String nomeLivro, String isbn, String dataEmprestimo, String dataDevolucao) {
    this.nomeUsuario = nomeUsuario;
    this.matriculaUsuario = matriculaUsuario;
    this.nomeLivro = nomeLivro;
    this.isbn = isbn;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
  }

  public EmprestimoDTO(EmprestimoDTO emprestimoDTO) {
    this.nomeUsuario = emprestimoDTO.getNomeUsuario();
    this.matriculaUsuario = emprestimoDTO.getMatriculaUsuario();
    this.nomeLivro = emprestimoDTO.getNomeLivro();
    this.isbn = emprestimoDTO.getIsbn();
    this.dataEmprestimo = emprestimoDTO.getDataEmprestimo();
    this.dataDevolucao = emprestimoDTO.getDataDevolucao();
  }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public String getMatriculaUsuario() {
    return matriculaUsuario;
  }

  public void setMatriculaUsuario(String matriculaUsuario) {
    this.matriculaUsuario = matriculaUsuario;
  }

  public String getNomeLivro() {
    return nomeLivro;
  }

  public void setNomeLivro(String nomeLivro) {
    this.nomeLivro = nomeLivro;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getDataEmprestimo() {
    return dataEmprestimo;
  }

  public void setDataEmprestimo(String dataEmprestimo) {
    this.dataEmprestimo = dataEmprestimo;
  }

  public String getDataDevolucao() {
    return dataDevolucao;
  }

  public void setDataDevolucao(String dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }

  @Override
  public boolean validar() {
    return (Tratamento.validarStrings(nomeUsuario, matriculaUsuario, nomeLivro, isbn)
            && Tratamento.validarDatas(dataEmprestimo, dataEmprestimo));
  }
}
