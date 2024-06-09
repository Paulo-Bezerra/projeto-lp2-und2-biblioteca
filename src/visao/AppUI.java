package visao;

import controlador.Controlador;
import dto.BibliotecarioDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;
import dto.UsuarioDTO;
import util.Leitura;

import java.util.List;

public class AppUI {
  private final Controlador controlador = new Controlador();

  public void run() {
    int opcao = 0;
    do {
      opcao = MenuUI.exibirMenuPrincipal();
      switch (opcao) {
        case 1:
          gerenciarUsuario();
          break;
      }

    } while (opcao != 4);
  }

  public void gerenciarUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.exibirGerenciarUsuario();
      switch (opcao) {
        case 1:
          cadastrarUsuario(); // foi
          break;
        case 2:
          removerUsuario(); // foi
          break;
        case 3:
          consultarUsuario(); // aqui
          break;
      }

    } while (opcao != 4);
  }

  private void consultarUsuario() {
    int opcao = 0;
    do {
      opcao = MenuUI.exibirConsultarUsuario();
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

  private void buscarUsuario() {
    String nome = Leitura.leStr("Informe o nome: ");
    List<UsuarioDTO> resultadosBusca = controlador.buscarUsuarioPorNome(nome);
    if (resultadosBusca.isEmpty()) {
      System.out.println("Nenhum usuário encontrado.");
    }
    System.out.println("Usuarios encontrados: \n[");
    for (UsuarioDTO usuarioDTO : resultadosBusca) {
      System.out.println(usuarioDTO);
    }
    System.out.println("]");
  }

  private void listarUsuarios() {
    List<UsuarioDTO> todosUsuarios = controlador.listarUsuarios();
    System.out.println("Listando todos os usuarios:");
    System.out.println("[");
    for (UsuarioDTO usuarioDTO : todosUsuarios) {
      System.out.println(usuarioDTO.toString());
    }
    System.out.println("]");
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
          consultarMatriculaDoUsuario();
          break;
      }

    } while (opcao != 4);
  }

  private void consultarMatriculaDoUsuario() {
    String nome = Leitura.leStr("Informe um nome para consulta: ");
    List<String> resultadosBusca = controlador.buscarMatriculaPorNome(nome);
    if (resultadosBusca.isEmpty()) {
      System.out.println("Nenhum usuário encontrado.");
    }
    System.out.println("Usuarios encontrados: \n[");
    for (String resultado : resultadosBusca) {
      System.out.println(resultado);
    }
    System.out.println("]");
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
