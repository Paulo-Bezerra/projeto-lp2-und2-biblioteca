package repositorio;

import modelo.Livro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class LivroRepositorio implements Serializable {
  private final HashMap<String, Livro> isbn_LR;;

  public LivroRepositorio() {
    this.isbn_LR = new HashMap<>();
  }

  public LivroRepositorio(LivroRepositorio livroRepositorio) {
    this.isbn_LR = new HashMap<>(livroRepositorio.isbn_LR);
  }

  public boolean adicionarLivro(Livro livro) {
    if (isbn_LR.containsKey(livro.getIsbn())) {
      return false;
    }
    isbn_LR.put(livro.getIsbn(), livro);
    return true;
  }

  public boolean removerLivro(String isbn) {
    if (!isbn_LR.containsKey(isbn)) {
      return false;
    }
    isbn_LR.remove(isbn);
    return true;
  }

  public HashSet<Livro> getLivros() {
    return new HashSet<>(isbn_LR.values());
  }

  public Livro getLivroPorIsbn(String isbn) {
    if (!isbn_LR.containsKey(isbn)) {
      return null;
    }
    return new Livro(isbn_LR.get(isbn));
  }

  public boolean existeLivro(String isbn) {
    return isbn_LR.containsKey(isbn);
  }
}
