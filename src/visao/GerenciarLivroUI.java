package visao;

import controlador.ControladorLivro;
import dto.LivroDTO;
import util.Impressao;
import util.Leitura;

import java.util.List;

public class GerenciarLivroUI {
  ControladorLivro cLivro = new ControladorLivro();

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
          consultarLivro(); // aqui
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
    if(cLivro.removerLivroPorIsbn(isbn)) {
      System.out.println("Livro removido com sucesso.");
    } else {
      System.out.println("Não foi possivel remover o livro.");
    }
  }

  private void consultarIsbnDoLivro() {
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
          consultarIsbnDoLivro();
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

}
