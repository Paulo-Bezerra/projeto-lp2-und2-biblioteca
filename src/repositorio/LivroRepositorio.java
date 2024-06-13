package repositorio;

import modelo.Livro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class LivroRepositorio implements Serializable {
  private final HashMap<String, Livro> isbn_LR;
  private final HashMap<String, Integer> isbn_Diponibilidade;

  public LivroRepositorio() {
    this.isbn_LR = new HashMap<>();
    this.isbn_Diponibilidade = new HashMap<>();
  }

  public LivroRepositorio(LivroRepositorio livroRepositorio) {
    this.isbn_LR = new HashMap<>(livroRepositorio.isbn_LR);
    this.isbn_Diponibilidade = new HashMap<>(livroRepositorio.isbn_Diponibilidade);
  }

  public boolean adicionarLivro(Livro livro) {
    if (isbn_LR.containsKey(livro.getIsbn()) || isbn_Diponibilidade.containsKey(livro.getIsbn())) {
      return false;
    }
    isbn_LR.put(livro.getIsbn(), livro);
    isbn_Diponibilidade.put(livro.getIsbn(), livro.getEstoque());
    return true;
  }

  public boolean removerLivro(String isbn) {
    if (!isbn_LR.containsKey(isbn) || !isbn_Diponibilidade.containsKey(isbn)) {
      return false;
    }
    isbn_LR.remove(isbn);
    isbn_Diponibilidade.remove(isbn);
    return true;
  }

  public HashSet<Livro> getLivros() {
    return new HashSet<>(isbn_LR.values());
  }

  public HashMap<String, Integer> getDisponibildade() {
    return new HashMap<>(isbn_Diponibilidade);
  }

  public Livro getLivroPorIsbn(String isbn) {
    if (!isbn_LR.containsKey(isbn)) {
      return null;
    }
    return new Livro(isbn_LR.get(isbn));
  }

  public int getDisponibilidadePorIsbn(String isbn) {
    if (!isbn_Diponibilidade.containsKey(isbn)) {
      return 0;
    }
    return isbn_Diponibilidade.get(isbn);
  }

  public boolean atualizarEstoqueDisponivel(String isbn, int estoqueDisponivel) {
    if (!isbn_Diponibilidade.containsKey(isbn)) {
      return false;
    }
    isbn_Diponibilidade.put(isbn, estoqueDisponivel);
    return true;
  }
}
