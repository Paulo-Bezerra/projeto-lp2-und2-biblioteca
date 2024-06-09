package dto;

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
    return (validarStrings(nomeUsuario, matriculaUsuario, nomeLivro, isbn) && validarDatas(dataEmprestimo, dataEmprestimo));
  }

  private boolean validarStrings(String... entradas) {
    for (String entrada : entradas) {
      if (entrada.isEmpty() || entrada.equals(" ")) {
        return false;
      }
    }
    return true;
  }

  private static boolean validarDatas(String... datas) {
    for (String data : datas) {
      if (!validarData(data)) {
        return false;
      }
    }
    return true;
  }
  // Método para validar a data usando LocalDate
  private static boolean validarData(String data) {
    if (!validarFormatoData(data)) {
      return false;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    try {
      LocalDate.parse(data, formatter);
    } catch (DateTimeParseException e) {
      return false;
    }
    return true;
  }

  // Método para validar o formato da data usando regex
  private static boolean validarFormatoData(String data) {
    Pattern pattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
    return pattern.matcher(data).matches();
  }
}
