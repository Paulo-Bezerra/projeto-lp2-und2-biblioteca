package visao;

import controlador.ControladorLivro;
import dto.LivroDTO;
import util.FiltroLivro;
import util.Impressao;
import util.Leitura;

import java.util.List;

public class GerenciarLivroUI {
  private final ControladorLivro cLivro = new ControladorLivro();


  public void gerenciarLivro() {
    int opcao = 0;
    do {
      opcao = MenuUI.gerenciarLivro();
      switch (opcao) {
        case 1:
          cadastrarLivro(); // foi
          break;
        case 2:
          removerLivro(); // foi
          break;
        case 3:
          consultarLivro(); // foi
          break;
      }

    } while (opcao != 4);
  }

  public void cadastrarLivro() {
    LivroDTO livroDTO = FormUI.formCadastrarLivro();
    String msg = "Dados informados:\n" +
                 livroDTO.toString() +
                 "\nCadastrar livro? [1. Sim/2. Não]: ";
    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Cadastro cancelado.");
      return;
    }

    if (cLivro.adicionarLivro(livroDTO)) {
      System.out.println("Livro cadastrado com sucesso.");
    } else {
      System.out.println("Não foi possivel cadastrar o livro.");
    }
  }

  public void removerLivro() {
    int opcao = 0;
    do {
      opcao = MenuUI.removerLivro();
      switch (opcao) {
        case 1:
          removerLivroPorIsbn();
          break;
        case 2:
          consultarIsbnDoLivro();
          break;
      }

    } while (opcao != 3);
  }

  private void removerLivroPorIsbn() {
    String isbn = Leitura.leStr("Remover Livro do ISBN: ");
    LivroDTO livroDTO = cLivro.buscarLivroPorIsbn(isbn);
    if (livroDTO == null) {
      System.out.println("Livro não encotrada.");
      return;
    }

    String msg = "Livro a ser removido:\n" +
        livroDTO +
        "\nRemover livro? [1. Sim/2. Não]: ";
    if (DialogoUI.dialogoConfirmar(msg) == 2) {
      System.out.println("Remoção cancelada.");
      return;
    }

    if (cLivro.removerLivroPorIsbn(isbn)) {
      System.out.println("Livro removido com sucesso.");
    } else {
      System.out.println("Não foi possivel remover o livro.");
    }
  }

  public void consultarIsbnDoLivro() {
    String titulo = Leitura.leStr("Consultar Livro pelo título: ");
    List<String> livrosEncotrados = cLivro.consultarIsbnDoLivro(titulo);
    if (livrosEncotrados == null || livrosEncotrados.isEmpty()) {
      System.out.println("Nenhum livro encontrado.");
      return;
    }
    System.out.println("Livros encontrados:");
    Impressao.imprimirLista(livrosEncotrados);
  }

  private void consultarLivro() {
    int opcao = 0;
    do {
      opcao = MenuUI.consultarLivro();
      switch (opcao) {
        case 1:
          listarLivros();
          break;
        case 2:
          pesquisarLivro();
          break;
      }

    } while (opcao != 3);

  }

  private void listarLivros() {
    List<LivroDTO> todosLivros = cLivro.listarLivros();
    if (todosLivros == null || todosLivros.isEmpty()) {
      System.out.println("Nenhum livro encontrado.");
      return;
    }
    System.out.println("Listando todos os livros:");
    Impressao.imprimirLista(todosLivros);
  }

  private void pesquisarLivro() {
    int opcao = 0;

    do {
      opcao = MenuUI.pesquisarLivro();
      switch (opcao) {
        case 1:
          pesquisarLivroPorTitulo();
          break;
        case 2:
          pesquisarLivroPorAutor();
          break;
        case 3:
          pesquisarLivroPorAssunto();
          break;
        case 4:
          pesquisarLivroPorIsbn();
          break;

      }

    } while (opcao != 5);
  }

  private void pesquisarLivroPorTitulo() {
    String entrada = Leitura.leStr("Titulo do livro: ");
    listarLivrosEncontrados(cLivro.pesquisarLivro(entrada, FiltroLivro.POR_TITULO));
  }


  private void pesquisarLivroPorAutor() {
    String entrada = Leitura.leStr("Autor do livro: ");
    listarLivrosEncontrados(cLivro.pesquisarLivro(entrada, FiltroLivro.POR_AUTOR));
  }

  private void pesquisarLivroPorIsbn() {
    String entrada = Leitura.leStr("ISBN do livro: ");
    listarLivrosEncontrados(cLivro.pesquisarLivro(entrada, FiltroLivro.POR_ISBN));
  }

  private void pesquisarLivroPorAssunto() {
    String entrada = Leitura.leStr("Assunto do livro: ");
    listarLivrosEncontrados(cLivro.pesquisarLivro(entrada, FiltroLivro.POR_ASSUNTO));
  }

  private void listarLivrosEncontrados(List<LivroDTO> livrosEncontrados) {
    if (livrosEncontrados == null || livrosEncontrados.isEmpty()) {
      System.out.println("Nenhum livro encontrado.");
      return;
    }
    System.out.println("Listando livros encontrados:");
    Impressao.imprimirLista(livrosEncontrados);
  }

}
