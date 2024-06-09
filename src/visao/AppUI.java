package visao;

import controlador.Controlador;
import dto.BibliotecarioDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;
import modelo.Bibliotecario;
import util.Leitura;

public class AppUI {
  private final Controlador controlador = new Controlador();

  private static int exibirMenuPrincipal() {
    String msg = """
        1. Gerenciar usuários.
        2. Gerenciar livros.
        3. Gerenciar empréstimos.
        4. Sair.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  private static int exibirGerenciarUsuarios() {
    String msg = """
        1. Cadastrar usuário.
        2. Remover usuário.
        3. Consultar usuários.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  private static int exibirCadastrarUsuarios() {
    String msg = """
        1. Cadastrar estudante.
        2. Cadastrar professor.
        3. Cadastrar bibliotecário.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  private static int exibirConsultarUsuarios() {
    String msg = """
        1. Listar todos os usuários.
        2. Pesquisar usuário.
        3. Verificar situação de usuário.
        4. Listar empréstimos ativos de usuário.
        5. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  private static int exibirGerenciarLivros() {
    String msg = """
        1. Cadastrar livro.
        2. Remover livro.
        3. Consultar livros.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  private static int exibirConsultarLivros() {
    String msg = """
        1. Listar todos os livros.
        2. Pesquisar livro.
        3. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  private static int exibirGerenciarEmprestimos() {
    String msg = """
        1. Registrar empréstimo.
        2. Registrar devolução.
        3. Consultar empréstimos.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  private static int exibirConsultarEmprestimos() {
    String msg = """
        1. Listar todos os empréstimos.
        2. Listar devoluções em atraso.
        3. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  public void run() {
    int opcao = 0;
    do {
      opcao = exibirMenuPrincipal();
      switch (opcao) {
        case 1:
          gerenciarUsuarios();
      }

    } while (opcao != 4);
  }

  public void gerenciarUsuarios() {
    int opcao = 0;
    do {
      opcao = exibirGerenciarUsuarios();
      switch (opcao) {
        case 1:
          cadastrarUsuarios();
      }

    } while (opcao != 4);
  }

  public void cadastrarUsuarios() {
    int opcao = 0;
    do {
      opcao = exibirCadastrarUsuarios();
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

    if (DialogoUI.dialogoConfirmarCadastro(msg) == 2) {
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

    if (DialogoUI.dialogoConfirmarCadastro(msg) == 2) {
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

    if (DialogoUI.dialogoConfirmarCadastro(msg) == 2) {
      System.out.println("Cadastro cancelado.");
      return;
    }

    if (controlador.adicionarBibliotecario(bibliotecarioDTO)) {
      System.out.println("Cadastrado com sucesso.");
    } else {
      System.out.println("Falha ao cadastrar.");
    }
  }
}
