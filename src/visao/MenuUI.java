package visao;

import util.Leitura;

public class MenuUI {
  public static int exibirMenuPrincipal() {
    String msg = """
        1. Gerenciar usuários.
        2. Gerenciar livros.
        3. Gerenciar empréstimos.
        4. Sair.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  public static int exibirGerenciarUsuario() {
    String msg = """
        1. Cadastrar usuários.
        2. Remover usuários.
        3. Consultar usuários.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  public static int exibirCadastrarUsuario() {
    String msg = """
        1. Cadastrar estudante.
        2. Cadastrar professor.
        3. Cadastrar bibliotecário.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  public static int exibirRemoverUsuario() {
    String msg = """
        1. Remover usuário (necessário informar a matrícula).
        2. Consultar matrícula do usuário.
        3. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  public static int exibirConsultarUsuario() {
    String msg = """
        1. Listar todos os usuários.
        2. Pesquisar usuário.
        3. Verificar situação de usuário.
        4. Listar empréstimos ativos de usuário.
        5. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  public static int exibirGerenciarLivro() {
    String msg = """
        1. Cadastrar livro.
        2. Remover livro.
        3. Consultar livros.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  public static int exibirConsultarLivro() {
    String msg = """
        1. Listar todos os livros.
        2. Pesquisar livro.
        3. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  public static int exibirGerenciarEmprestimo() {
    String msg = """
        1. Registrar empréstimo.
        2. Registrar devolução.
        3. Consultar empréstimos.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

  public static int exibirConsultarEmprestimo() {
    String msg = """
        1. Listar todos os empréstimos.
        2. Listar devoluções em atraso.
        3. Voltar.
        Escolha uma opção:\s""";
    return Leitura.LeInt(msg);
  }

}
