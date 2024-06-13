package visao;

import controlador.ControladorEmprestimo;
import controlador.ControladorLivro;
import controlador.ControladorUsuario;
import dto.*;
import util.Impressao;
import util.Leitura;
import util.TipoUsuario;
import util.Tratamento;

import java.util.ArrayList;

public class GerenciarEmprestimoUI {
  private final ControladorEmprestimo cEmprestimo = new ControladorEmprestimo();
  private final ControladorUsuario cUsuario = new ControladorUsuario();
  private final ControladorLivro cLivro = new ControladorLivro();
  private final GerenciarUsuarioUI gUsuarioUI = new GerenciarUsuarioUI();
  private final GerenciarLivroUI gLivroUI = new GerenciarLivroUI();


  public void gerenciarEmprestimo() {
    int opcao = 0;
    do {
      opcao = MenuUI.gerenciarEmprestimo();
      switch (opcao) {
        case 1:
          registrarEmprestimo();
          break;
        case 2:
          registrarDevolucao();
          break;
        case 3:
          consultarEmprestimos();
          break;
      }

    } while (opcao != 4);
  }

  private void registrarEmprestimo() {
    int opcao = 0;
    do {
      opcao = MenuUI.registrarEmprestimo();
      switch (opcao) {
        case 1:
          adicionarEmprestimo();
          break;
        case 2:
          gUsuarioUI.consultarMatriculaDoUsuario();
          break;
        case 3:
          gLivroUI.consultarIsbnDoLivro();
          break;
      }

    } while (opcao != 4);
  }

  private void adicionarEmprestimo() {
    EmprestimoDTO emprestimoDTO = FormUI.formRegistrarEmprestimo();
    if (cLivro.buscarLivroPorIsbn(emprestimoDTO.getIsbn()) == null) {
      System.out.println("ISBN não encontrado.");
      return;
    }

    switch (cUsuario.buscarUsuarioPorMatricula(emprestimoDTO.getMatricula())) {
      case EstudanteDTO estudanteDTO -> {
        emprestimoDTO.setDataDevolucao(Tratamento.somarDias(emprestimoDTO.getDataEmprestimo(), 15));
        emprestimoDTO.setTipoUsuario(TipoUsuario.TIPO_ESTUDANTE);
        if (!confirmarEmprestimo(emprestimoDTO, estudanteDTO)) {
          System.out.println("Operação cancelada.");
          return;
        }
      }
      case ProfessorDTO professorDTO -> {
        emprestimoDTO.setDataDevolucao(Tratamento.somarDias(emprestimoDTO.getDataEmprestimo(), 30));
        emprestimoDTO.setTipoUsuario(TipoUsuario.TIPO_PROFESSOR);
        if (!confirmarEmprestimo(emprestimoDTO, professorDTO)) {
          System.out.println("Operação cancelada.");
          return;
        }
      }
      case BibliotecarioDTO bibliotecarioDTO -> {
        emprestimoDTO.setDataDevolucao(Tratamento.somarDias(emprestimoDTO.getDataEmprestimo(), 30));
        emprestimoDTO.setTipoUsuario(TipoUsuario.TIPO_BIBLIOTECARIO);
        if (!confirmarEmprestimo(emprestimoDTO, bibliotecarioDTO)) {
          System.out.println("Operação cancelada.");
          return;
        }
      }
      default -> {
        System.out.println("Matrícula não encotrada.");
        return;
      }
    }

    if (cEmprestimo.registrarEmprestimo(emprestimoDTO)) {
      System.out.println("Empréstimo registrado com sucesso.");
    } else {
      System.out.println("Empréstimo não registrado.");
    }

  }

  private <T extends UsuarioDTO> boolean confirmarEmprestimo(EmprestimoDTO emprestimoDTO, T usuarioDTO) {
    String msg = "Dados do emprestimo: {\n" +
        "Requerente: " + usuarioDTO + ",\n" +
        "Material: " + cLivro.buscarLivroPorIsbn(emprestimoDTO.getIsbn()) + "\n" +
        "Data do empréstimo: " + emprestimoDTO.getDataEmprestimo() + "\n" +
        "Data prevista para devolução: " + emprestimoDTO.getDataDevolucao() + "\n" +
        "}" +
        "\nCadastrar emprestimo? [1. Sim/2. Não]: ";
    return DialogoUI.dialogoConfirmar(msg) != 2;
  }

  private void registrarDevolucao() {
    int opcao = 0;
    do {
      opcao = MenuUI.registrarDevolucao();
      switch (opcao) {
        case 1:
          removerEmprestimo();
          break;
        case 2:
          gUsuarioUI.consultarMatriculaDoUsuario();
          break;
        case 3:
          gLivroUI.consultarIsbnDoLivro();
          break;
      }

    } while (opcao != 4);
  }

  private void removerEmprestimo() {
    String matricula, isbn;
    matricula = Leitura.leStr("Informe a matricula: ");
    isbn = Leitura.leStr("Informe a ISBN: ");
    if (cEmprestimo.existeEmprestimo(matricula, isbn)) {
      System.out.println("Empréstimo não encontrado.");
      return;
    }

    EmprestimoDTO emprestimoEncontado = cEmprestimo.getEmprestimo(matricula, isbn);

    if (!confirmarDevolucao(emprestimoEncontado)) {
      System.out.println("Operação cancelada.");
      return;
    }

    if (cEmprestimo.registrarDevolucao(matricula, isbn)) {
      System.out.println("Devolução registrado com sucesso.");
    } else {
      System.out.println("Devolução não registrada.");
    }
  }

  private <T extends UsuarioDTO> boolean confirmarDevolucao(EmprestimoDTO emprestimoDTO) {
    String msg = "Dados para devolução: {\n" +
        "Restituidor: " + cUsuario.buscarUsuarioPorMatricula(emprestimoDTO.getMatricula()) + ",\n" +
        "Material: " + cLivro.buscarLivroPorIsbn(emprestimoDTO.getIsbn()) + "\n" +
        "Data do empréstimo: " + emprestimoDTO.getDataEmprestimo() + "\n" +
        "Data prevista para devolução: " + emprestimoDTO.getDataDevolucao() + "\n" +
        "}" +
        "\nCadastrar emprestimo? [1. Sim/2. Não]: ";
    return DialogoUI.dialogoConfirmar(msg) != 2;
  }

  private void consultarEmprestimos() {
    int opcao = 0;
    do {
      opcao = MenuUI.consultarEmprestimo();
      switch (opcao) {
        case 1:
          listarEmprestimos();
          break;
        case 2:
          listarAtrasos();
          break;
      }

    } while (opcao != 3);
  }

  private void listarEmprestimos() {
    ArrayList<String> emprestimos = cEmprestimo.getEmprestimos();
    if (emprestimos.isEmpty()) {
      System.out.println("Nenhum emprestimo registrado.");
      return;
    }
    System.out.println("Listando emprestimos:");
    Impressao.imprimirLista(emprestimos);
  }

  private void listarAtrasos() {
    ArrayList<String> emprestimos = cEmprestimo.getEmprestimosAtrasados();
    if (emprestimos.isEmpty()) {
      System.out.println("Nenhum devolução em atraso.");
      return;
    }
    System.out.println("Listando empréstimos atrasados:");
    Impressao.imprimirLista(emprestimos);
  }
}
