package visao;

import controlador.Controlador;
import dto.BibliotecarioDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;

public class AppUI {
  private final Controlador controlador = new Controlador();

  public void run() {
    int opcao = 0;
    do {
      opcao = MenuUI.exibirMenuPrincipal();
      switch (opcao) {
        case 1:
          gerenciarUsuario();
      }

    } while (opcao != 4);
  }

  public void gerenciarUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.exibirGerenciarUsuario();
      switch (opcao) {
        case 1:
          cadastrarUsuario();
          break;
        case 2:
          removerUsuario();
          break;
      }

    } while (opcao != 4);
  }

  public void cadastrarUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.exibirCadastrarUsuario();
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

  public void cadastrarEstudante() {
    EstudanteDTO estudanteDTO = FormUI.formCadastrarEstudante();

    String msg = "Dados informados:\n" +
                 estudanteDTO.toString() +
                 "\nCadastrar estudante? [1. Sim/2. Não]: ";

    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Cadastro cancelado.");
      return;
    }

    if (controlador.adicionarEstudante(estudanteDTO)) {
      System.out.println("Cadastrado com sucesso.");
    } else {
      System.out.println("Falha ao cadastrar.");
    }
  }

  public void cadastrarProfessor() {
    ProfessorDTO professorDTO = FormUI.formCadastrarProfessor();

    String msg = "Dados informados:\n" +
                 professorDTO.toString() +
                 "\nCadastrar professor? [1. Sim/2. Não]: ";

    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Cadastro cancelado.");
      return;
    }

    if (controlador.adicionarProfessor(professorDTO)) {
      System.out.println("Cadastrado com sucesso.");
    } else {
      System.out.println("Falha ao cadastrar.");
    }
  }

  public void cadastrarBibliotecario() {
    BibliotecarioDTO bibliotecarioDTO = FormUI.formCadastrarBibliotecario();

    String msg = "Dados informados:\n" +
                 bibliotecarioDTO.toString() +
                 "\nCadastrar professor? [1. Sim/2. Não]: ";

    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Cadastro cancelado.");
      return;
    }

    if (controlador.adicionarBibliotecario(bibliotecarioDTO)) {
      System.out.println("Cadastrado com sucesso.");
    } else {
      System.out.println("Falha ao cadastrar.");
    }
  }

  public void removerUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.exibirRemoverUsuario();
      switch (opcao) {
        case 1:
          removerUsuarioPorMatricula();
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

  public void removerUsuarioPorMatricula() {
    String matricula = FormUI.formRemoverUsuarioPorMatricula();
    String usuarioEncontrado = controlador.buscarUsuarioPorMatricula(matricula);
    if (usuarioEncontrado == null) {
      System.out.println("Matrícula não encotrada.");
      return;
    }

    String msg = "Dados informados:\n" +
                 usuarioEncontrado +
                 "\nRemover usuário? [1. Sim/2. Não]: ";

    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Remoção cancelada.");
      return;
    }

    if (controlador.removerUsuarioPorMatricula(matricula)) {
      System.out.println("Removido com sucesso.");
    } else {
      System.out.println("Falha ao remover.");
    }
  }
}
