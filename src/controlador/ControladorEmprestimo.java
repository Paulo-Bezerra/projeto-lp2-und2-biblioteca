package controlador;

import dto.BibliotecarioDTO;
import dto.EmprestimoDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;
import modelo.Emprestimo;
import servico.OperacoesEmprestimo;
import util.Tratamento;

import java.util.ArrayList;
import java.util.List;

public class ControladorEmprestimo {
  private final OperacoesEmprestimo opEmprestimo = new OperacoesEmprestimo();
  private final ControladorUsuario cUsuario = new ControladorUsuario();
  private final ControladorLivro cLivro = new ControladorLivro();

  public EmprestimoDTO getEmprestimo(String matricula, String isbn) {
    if (matricula == null || matricula.trim().isEmpty() || isbn == null || isbn.trim().isEmpty()) {
      return null;
    }
    if (!Tratamento.validarStringsNumericas(matricula, isbn)) {
      return null;
    }
    return opEmprestimo.getEmprestimo(matricula, isbn);
  }

  public boolean existeEmprestimo(String matricula, String isbn) {
    if (matricula == null || matricula.trim().isEmpty() || isbn == null || isbn.trim().isEmpty()) {
      return false;
    }
    if (!Tratamento.validarStringsNumericas(matricula, isbn)) {
      return false;
    }
    return opEmprestimo.existeEmprestimo(matricula, isbn);
  }

  public boolean registrarEmprestimo(EmprestimoDTO emprestimoDTO) {
    if (emprestimoDTO == null) {
      return false;
    }
    if (!Tratamento.validarDatas(emprestimoDTO.getDataEmprestimo())) {
        return false;
    }
    if (!emprestimoDTO.validar()) {
      return false;
    }
    if (!validarEmprestimo(emprestimoDTO)) {
      return false;
    }
    return opEmprestimo.registrarEmprestimo(emprestimoDTO);
  }

  private boolean validarEmprestimo(EmprestimoDTO emprestimoDTO) {
    switch (emprestimoDTO.getTipoUsuario()) {
      case TIPO_ESTUDANTE -> {
        if (!(cUsuario.buscarUsuarioPorMatricula(emprestimoDTO.getMatricula()) instanceof EstudanteDTO)) {
          return false;
        }
        if (!emprestimoDTO.getDataDevolucao().equalsIgnoreCase(Tratamento.somarDias(emprestimoDTO.getDataEmprestimo(), 15))){
          return false;
        }
      }
      case TIPO_PROFESSOR -> {
        if (!(cUsuario.buscarUsuarioPorMatricula(emprestimoDTO.getMatricula()) instanceof ProfessorDTO)) {
          return false;
        }
        if (!emprestimoDTO.getDataDevolucao().equalsIgnoreCase(Tratamento.somarDias(emprestimoDTO.getDataEmprestimo(), 30))){
          return false;
        }
      }
      case TIPO_BIBLIOTECARIO -> {
        if (!(cUsuario.buscarUsuarioPorMatricula(emprestimoDTO.getMatricula()) instanceof BibliotecarioDTO)) {
          return false;
        }
        if (!emprestimoDTO.getDataDevolucao().equalsIgnoreCase(Tratamento.somarDias(emprestimoDTO.getDataEmprestimo(), 30))){
          return false;
        }
      }
    }
    return true;
  }

  public boolean registrarDevolucao(String matricula, String isbn) {
    if (matricula == null || isbn == null) {
      return false;
    }
    if (!Tratamento.validarStringsNumericas(matricula, isbn)) {
      return false;
    }
    return opEmprestimo.registrarDevolucao(matricula, isbn);
  }

  public ArrayList<String> getEmprestimos() {
    ArrayList<String> emprestimos = new ArrayList<>();
    String str;
    for (EmprestimoDTO emprestimoDTO : opEmprestimo.getEmprestimos()) {
      str = "Emprestimo: {\n" +
          "  " + cUsuario.buscarUsuarioPorMatricula(emprestimoDTO.getMatricula()) + ",\n" +
          "  " + cLivro.buscarLivroPorIsbn(emprestimoDTO.getIsbn()) + "\n" +
          "  Data do empréstimo: " + emprestimoDTO.getDataEmprestimo() + "\n" +
          "  Data prevista para devolução: " + emprestimoDTO.getDataDevolucao() + "\n" +
          "}";
      emprestimos.add(str);
    }
    return emprestimos;
  }

  public ArrayList<String> getEmprestimosAtrasados() {
    ArrayList<String> emprestimos = new ArrayList<>();
    String str;
    for (EmprestimoDTO emprestimoDTO : opEmprestimo.getEmprestimosAtrasados()) {
      str = "Emprestimo: {\n" +
          "  " + cUsuario.buscarUsuarioPorMatricula(emprestimoDTO.getMatricula()) + ",\n" +
          "  " + cLivro.buscarLivroPorIsbn(emprestimoDTO.getIsbn()) + "\n" +
          "  Data do empréstimo: " + emprestimoDTO.getDataEmprestimo() + "\n" +
          "  Data prevista para devolução: " + emprestimoDTO.getDataDevolucao() + "\n" +
          "}";
      emprestimos.add(str);
    }
    return emprestimos;
  }

  public ArrayList<String> getEmprestimosAtrasados(String matricula) {
    ArrayList<String> emprestimos = new ArrayList<>();
    String str;
    for (EmprestimoDTO emprestimoDTO : opEmprestimo.getEmprestimosAtrasados(matricula)) {
      str = "Emprestimo: {\n" +
          "  " + cLivro.buscarLivroPorIsbn(emprestimoDTO.getIsbn()) + "\n" +
          "  Data do empréstimo: " + emprestimoDTO.getDataEmprestimo() + "\n" +
          "  Data prevista para devolução: " + emprestimoDTO.getDataDevolucao() + "\n" +
          "}";
      emprestimos.add(str);
    }
    return emprestimos;
  }

  public ArrayList<String> getEmprestimosPorMatricula(String matricula) {
    ArrayList<String> emprestimos = new ArrayList<>();
    String str;
    for (EmprestimoDTO emprestimoDTO : opEmprestimo.getEmprestimosPorMatricula(matricula)) {
      str = "Emprestimo: {\n" +
          "  " + cLivro.buscarLivroPorIsbn(emprestimoDTO.getIsbn()) + "\n" +
          "  Data do empréstimo: " + emprestimoDTO.getDataEmprestimo() + "\n" +
          "  Data prevista para devolução: " + emprestimoDTO.getDataDevolucao() + "\n" +
          "}";
      emprestimos.add(str);
    }
    return emprestimos;
  }
}
