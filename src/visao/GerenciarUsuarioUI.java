package visao;

import controlador.ControladorEmprestimo;
import controlador.ControladorUsuario;
import dto.BibliotecarioDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;
import util.Impressao;
import util.Leitura;

import java.util.ArrayList;
import java.util.List;

public class GerenciarUsuarioUI {
  private final ControladorUsuario cUsuario = new ControladorUsuario();
  private final ControladorEmprestimo cEmprestimo = new ControladorEmprestimo();

  public void gerenciarUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.gerenciarUsuario();
      switch (opcao) {
        case 1:
          cadastrarUsuario(); // aqui
          break;
        case 2:
          removerUsuario(); // foi
          break;
        case 3:
          consultarUsuario(); // foi
          break;
      }

    } while (opcao != 4);
  }

  private void cadastrarUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.cadastrarUsuario();
      switch (opcao) {
        case 1:
          cadastrarEstudante();
          break;
        case 2:
          cadastrarProfessor();
          break;
        case 3:
          cadastrarBibliotecario();
          break;
      }

    } while (opcao != 4);
  }

  private void cadastrarEstudante() {
    EstudanteDTO estudanteDTO = FormUI.formCadastrarEstudante();

    String msg = "Dados informados:\n" +
        estudanteDTO.toString() +
        "\nCadastrar estudante? [1. Sim/2. Não]: ";

    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Cadastro cancelado.");
      return;
    }

    if (cUsuario.adicionarUsuario(estudanteDTO)) {
      System.out.println("Cadastrado com sucesso.");
    } else {
      System.out.println("Falha ao cadastrar.");
    }
  }

  private void cadastrarProfessor() {
    ProfessorDTO professorDTO = FormUI.formCadastrarProfessor();

    String msg = "Dados informados:\n" +
        professorDTO.toString() +
        "\nCadastrar professor? [1. Sim/2. Não]: ";

    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Cadastro cancelado.");
      return;
    }

    if (cUsuario.adicionarUsuario(professorDTO)) {
      System.out.println("Cadastrado com sucesso.");
    } else {
      System.out.println("Falha ao cadastrar.");
    }
  }

  private void cadastrarBibliotecario() {
    BibliotecarioDTO bibliotecarioDTO = FormUI.formCadastrarBibliotecario();

    String msg = "Dados informados:\n" +
        bibliotecarioDTO.toString() +
        "\nCadastrar professor? [1. Sim/2. Não]: ";

    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Cadastro cancelado.");
      return;
    }

    if (cUsuario.adicionarUsuario(bibliotecarioDTO)) {
      System.out.println("Cadastrado com sucesso.");
    } else {
      System.out.println("Falha ao cadastrar.");
    }
  }

  private void removerUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.removerUsuario();
      switch (opcao) {
        case 1:
          removerUsuarioPorMatricula();
          break;
        case 2:
          consultarMatriculaDoUsuario();
          break;
      }

    } while (opcao != 3);
  }

  private void removerUsuarioPorMatricula() {
    String matricula = FormUI.formRemoverUsuarioPorMatricula();
    if (cUsuario.buscarUsuarioPorMatricula(matricula).validar()) {
      System.out.println("Matrícula não encotrada.");
      return;
    }

    String msg = "Dados informados:\n" +
        cUsuario.buscarUsuarioPorMatricula(matricula).toString() +
        "\nRemover usuário? [1. Sim/2. Não]: ";
    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Remoção cancelada.");
      return;
    }

    if (cUsuario.removerUsuarioPorMatricula(matricula)) {
      System.out.println("Removido com sucesso.");
    } else {
      System.out.println("Falha ao remover.");
    }
  }

  public void consultarMatriculaDoUsuario() {
    String nome = Leitura.leStr("Informe um nome para consulta: ");
    listarUsuariosEncontrados(cUsuario.buscarMatriculaPorNome(nome));
  }

  private void consultarUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.consultarUsuario();
      switch (opcao) {
        case 1:
          listarUsuarios();
          break;
        case 2:
          buscarUsuario();
          break;
        case 3:
          verificarUsuario();
          break;
        case 4:
          emprestimosUsuario();
          break;
      }
    } while (opcao != 5);

  }

  private void verificarUsuario() {
    String matricula = Leitura.leStr("Informe a matrícula para verificar: ");
    if (!cUsuario.existeUsuario(matricula)) {
      System.out.println("Usuário não cadastrado.");
      return;
    }
    if (cUsuario.usuarioEmAtraso(matricula)) {
      System.out.println("Usuário em atraso.");
      System.out.println("Atraso(s) do usuário:");
      Impressao.imprimirLista(cEmprestimo.getEmprestimosAtrasados());
    }
    int numEmprestimo = cUsuario.numEmprestimoDoUsuario(matricula);
    if (numEmprestimo == 0) {
      System.out.println("Não possui emprestimos.");
    } else {
      System.out.println("O usuário possui " + numEmprestimo + " emprestimos.");
    }
  }

  private void emprestimosUsuario() {
    String matricula = Leitura.leStr("Informe a matrícula para verificar: ");
    if (!cUsuario.existeUsuario(matricula)) {
      System.out.println("Usuário não cadastrado.");
      return;
    }
    if (cUsuario.numEmprestimoDoUsuario(matricula) == 0) {
      System.out.println("Não possui emprestimos.");
      return;
    }
    System.out.println("Listando emprestimos:");
    Impressao.imprimirLista(cEmprestimo.getEmprestimosPorMatricula(matricula));
  }

  private void listarUsuarios() {
    listarUsuariosEncontrados(cUsuario.listarUsuarios());
  }

  private void buscarUsuario() {
    String nome = Leitura.leStr("Informe o nome: ");
    listarUsuariosEncontrados(cUsuario.buscarUsuarioPorNome(nome));
  }

  private <T> void listarUsuariosEncontrados(List<T> usuariosEncontrados) {
    if (usuariosEncontrados == null || usuariosEncontrados.isEmpty()) {
      System.out.println("Nenhum usuário encontrado.");
      return;
    }
    System.out.println("Listando usuários encontrados:");
    Impressao.imprimirLista(usuariosEncontrados);
  }

}
