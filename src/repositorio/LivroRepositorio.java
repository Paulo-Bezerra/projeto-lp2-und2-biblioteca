package repositorio;

import modelo.Livro;

import java.util.ArrayList;
import java.util.HashMap;

public class LivroRepositorio {
  private final HashMap<Livro, Integer> LR;
  private final HashMap<String, Livro> livrosPorIsbn;

  public LivroRepositorio() {
    this.LR = new HashMap<>();
    this.livrosPorIsbn = new HashMap<>();
  }

  public boolean adicionarLivro(Livro livro) {
    if (LR.containsKey(livro) || livrosPorIsbn.containsKey(livro.getIsbn())) {
      return false;
    }
    LR.put(livro, livro.getEstoque());
    livrosPorIsbn.put(livro.getIsbn(), livro);
    return true;
  }

  public boolean removerLivro(Livro livro) {
    if (!LR.containsKey(livro) || !livrosPorIsbn.containsKey(livro.getIsbn())) {
      return false;
    }
    LR.remove(livro);
    livrosPorIsbn.remove(livro.getIsbn());
    return true;
  }

  public HashMap<Livro, Integer> getLivros() {
    return new HashMap<Livro, Integer>(LR);
  }

  public Livro getLivroPorIsbn(String isbn) {
    if (!livrosPorIsbn.containsKey(isbn)) {
      return null;
    }
    return new Livro(livrosPorIsbn.get(isbn));
  }
}
