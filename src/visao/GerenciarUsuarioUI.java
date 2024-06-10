package visao;

import controlador.ControladorUsuario;
import dto.BibliotecarioDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;
import dto.UsuarioDTO;
import util.Impressao;
import util.Leitura;

import java.util.List;

public class GerenciarUsuarioUI {
  ControladorUsuario cUsuario = new ControladorUsuario();

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
    String usuarioEncontrado = cUsuario.buscarUsuarioPorMatricula(matricula);
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

    if (cUsuario.removerUsuarioPorMatricula(matricula)) {
      System.out.println("Removido com sucesso.");
    } else {
      System.out.println("Falha ao remover.");
    }
  }

  private void consultarMatriculaDoUsuario() {
    String nome = Leitura.leStr("Informe um nome para consulta: ");
    List<String> resultadosBusca = cUsuario.buscarMatriculaPorNome(nome);
    if (resultadosBusca.isEmpty()) {
      System.out.println("Nenhum usuário encontrado.");
      return;
    }
    System.out.println("Usuarios encontrados:");
    Impressao.imprimirLista(resultadosBusca);
  }

  private void consultarUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.consultarUsuario();
      switch (opcao) {
        case 1: //Listar todos os usuários.
          listarUsuarios();
          break;
        case 2:
          buscarUsuario();
          break;
      }
    } while (opcao != 5);

  }

  private void listarUsuarios() {
    List<UsuarioDTO> todosUsuarios = cUsuario.listarUsuarios();
    System.out.println("Listando todos os usuarios:");
    Impressao.imprimirLista(todosUsuarios);
  }

  private void buscarUsuario() {
    String nome = Leitura.leStr("Informe o nome: ");
    List<UsuarioDTO> resultadosBusca = cUsuario.buscarUsuarioPorNome(nome);
    if (resultadosBusca.isEmpty()) {
      System.out.println("Nenhum usuário encontrado.");
    }
    System.out.println("Usuarios encontrados:");
    Impressao.imprimirLista(resultadosBusca);
  }

}
