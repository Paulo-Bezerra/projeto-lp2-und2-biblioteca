package visao;

import util.Leitura;

public class MenuUI {
  public static int menuPrincipal() {
    String msg = """
        1. Gerenciar usuários.
        2. Gerenciar livros.
        3. Gerenciar empréstimos.
        4. Sair.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }

  public static int gerenciarUsuario() {
    String msg = """
        1. Cadastrar usuários.
        2. Remover usuários.
        3. Consultar usuários.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }

  public static int cadastrarUsuario() {
    String msg = """
        1. Cadastrar estudante.
        2. Cadastrar professor.
        3. Cadastrar bibliotecário.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }

  public static int removerUsuario() {
    String msg = """
        1. Remover usuário (necessário informar a matrícula).
        2. Consultar matrícula do usuário.
        3. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }

  public static int consultarUsuario() {
    String msg = """
        1. Listar todos os usuários.
        2. Pesquisar usuário.
        3. Verificar situação de usuário.
        4. Listar empréstimos ativos de usuário.
        5. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }

  public static int gerenciarLivro() {
    String msg = """
        1. Cadastrar livro.
        2. Remover livro.
        3. Consultar livros.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }

  public static int removerLivro() {
    String msg = """
        1. Remover livro (necessário informar o ISBN).
        2. Consultar ISBN do livro.
        3. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }

  public static int consultarLivro() {
    String msg = """
        1. Listar todos os livros.
        2. Pesquisar livro.
        3. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }
//  private String titulo;
//  private String autor;
//  private String isbn;
//  private String assunto;
//  private int ano;
//  private int estoque;
//  private int qtdDisponivel;
  public static int pesquisarLivro() {
    String msg = """
        1. Por título.
        2. Por autor.
        3. Por ISBN.
        4. Por assunto.
        5. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }

  public static int gerenciarEmprestimo() {
    String msg = """
        1. Registrar empréstimo.
        2. Registrar devolução.
        3. Consultar empréstimos.
        4. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }

  public static int consultarEmprestimo() {
    String msg = """
        1. Listar todos os empréstimos.
        2. Listar devoluções em atraso.
        3. Voltar.
        Escolha uma opção:\s""";
    return Leitura.leInt(msg);
  }
}
