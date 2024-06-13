package dto;

import controlador.ControladorEmprestimo;
import controlador.ControladorLivro;
import controlador.ControladorUsuario;
import modelo.Emprestimo;
import util.TipoUsuario;
import util.Tratamento;

public class EmprestimoDTO implements IValidacaoDeDTO {
  private String matricula;
  private String isbn;
  private String dataEmprestimo;
  private String dataDevolucao;
  private TipoUsuario tipoUsuario;

  public EmprestimoDTO(String matricula, String isbn, String dataEmprestimo, String dataDevolucao, TipoUsuario tipoUsuario) {
    this.matricula = matricula;
    this.isbn = isbn;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
    this.tipoUsuario = tipoUsuario;
  }

  public EmprestimoDTO(String matricula, String isbn, String dataEmprestimo) {
    this.matricula = matricula;
    this.isbn = isbn;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = null;
    this.tipoUsuario = null;
  }

  public EmprestimoDTO(String matricula, String isbn) {
    this.matricula = matricula;
    this.isbn = isbn;
    this.dataEmprestimo = null;
    this.dataDevolucao = null;
    this.tipoUsuario = null;
  }

  public EmprestimoDTO(EmprestimoDTO emprestimoDTO) {
    this.matricula = emprestimoDTO.getMatricula();
    this.isbn = emprestimoDTO.getIsbn();
    this.dataEmprestimo = emprestimoDTO.getDataEmprestimo();
    this.dataDevolucao = emprestimoDTO.getDataDevolucao();
  }

  public EmprestimoDTO(Emprestimo emprestimo) {
    this.matricula = emprestimo.getMatricula();
    this.isbn = emprestimo.getIsbn();
    this.dataEmprestimo = Tratamento.dataParaString(emprestimo.getDataEmprestimo());
    this.dataDevolucao = Tratamento.dataParaString(emprestimo.getDataDevolucao());
  }


  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
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

  public TipoUsuario getTipoUsuario() {
    return tipoUsuario;
  }

  public void setTipoUsuario(TipoUsuario tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }

  @Override
  public boolean validar() {
    return (Tratamento.validarStringsNumericas(matricula, isbn)
        && Tratamento.validarDatas(dataEmprestimo, dataDevolucao)
        && tipoUsuario != null);
  }
}
