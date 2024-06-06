package repositorio;

import modelo.Livro;

import java.util.HashMap;

public class LivroRepositorio {
  private final HashMap<Livro, Integer> estoqueDisponivel;

  public LivroRepositorio() {
    estoqueDisponivel = new HashMap<>();
  }

  public boolean adicionarLivro(Livro livro) {
    if (estoqueDisponivel.containsKey(livro)) {
      return false;
    }
    estoqueDisponivel.put(livro, livro.getEstoque());
    return true;
  }

  public boolean removerLivro(Livro livro) {
    if (!estoqueDisponivel.containsKey(livro)) {
      return false;
    }
    estoqueDisponivel.remove(livro);
    return true;
  }

  public HashMap<Livro, Integer> getLivros() {
    return estoqueDisponivel;
  }

  public HashMap<Livro, Integer> buscarLivroPorTitulo(String titulo) {
    HashMap<Livro, Integer> livrosTitulo = new HashMap<Livro, Integer>();
    for (Livro livro : estoqueDisponivel.keySet()) {
      if (livro.getTitulo().equals(titulo)) {
        livrosTitulo.put(livro, estoqueDisponivel.get(livro));
      }
    }
    return livrosTitulo;
  }

  public HashMap<Livro, Integer> buscarLivroPorAutor(String autor) {
    HashMap<Livro, Integer> livrosAutor = new HashMap<Livro, Integer>();
    for (Livro livro : estoqueDisponivel.keySet()) {
      if (livro.getAutor().equals(autor)) {
        livrosAutor.put(livro, estoqueDisponivel.get(livro));
      }
    }
    return livrosAutor;
  }

  public HashMap<Livro, Integer> buscarLivroPorAssunto(String assunto) {
    HashMap<Livro, Integer> livrosAssunto = new HashMap<Livro, Integer>();
    for (Livro livro : estoqueDisponivel.keySet()) {
      if (livro.getAssunto().equals(assunto)) {
        livrosAssunto.put(livro, estoqueDisponivel.get(livro));
      }
    }
    return livrosAssunto;
  }

  public HashMap<Livro, Integer> buscarLivroPorAno(int ano) {
    HashMap<Livro, Integer> livrosAno = new HashMap<Livro, Integer>();
    for (Livro livro : estoqueDisponivel.keySet()) {
      if (livro.getAno() == ano) {
        livrosAno.put(livro, estoqueDisponivel.get(livro));
      }
    }
    return livrosAno;
  }

  public HashMap<Livro, Integer> buscarLivrosPorEstoqueCadastrado(int estoqueCadastrado) {
    HashMap<Livro, Integer> livrosCasdastrados = new HashMap<Livro, Integer>();
    for (Livro livro : estoqueDisponivel.keySet()) {
      if (livro.getEstoque() == estoqueCadastrado) {
        livrosCasdastrados.put(livro, estoqueDisponivel.get(livro));
      }
    }
    return livrosCasdastrados;
  }

  public HashMap<Livro, Integer> buscarLivrosPorEstoqueDisponível(int estoqueDisponivel) {
    HashMap<Livro, Integer> livrosEstoque = new HashMap<Livro, Integer>();
    for (Livro livro : this.estoqueDisponivel.keySet()) {
      if (this.estoqueDisponivel.get(livro).equals(estoqueDisponivel)) {
        livrosEstoque.put(livro, this.estoqueDisponivel.get(livro));
      }
    }
    return livrosEstoque;
  }
}
