package servico;

import dao.BancoDAO;
import dto.LivroDTO;
import modelo.Livro;
import util.Tratamento;

import java.util.*;

public class OperacoesLivro {
  private final BancoDAO bancoDAO;

  public OperacoesLivro() {
    bancoDAO = BancoDAO.getInstance();
  }

  private Map<Livro, Integer> cpLivros() {
    return bancoDAO.getLR().getLivros();
  }

  public boolean adicionarLivro(LivroDTO livroDTO) {
    return adicionarLivro(new Livro(livroDTO));
  }

  private boolean adicionarLivro(Livro livro) {
    return bancoDAO.getLR().adicionarLivro(livro);
  }

  public boolean removerLivroPorIsbn(String isbn) {
    Livro livro = getLivroPorIsbn(isbn);
    if (livro == null) {
      return false;
    }
    return bancoDAO.getLR().removerLivro(livro);
  }

  private Livro getLivroPorIsbn(String isbn) {
    Set<Livro> livros = bancoDAO.getLR().getLivros().keySet();
    for (Livro livro : livros) {
      if (livro.getIsbn().equals(isbn)) {
        return livro;
      }
    }
    return null;
  }

  public List<String> consultarIsbnDoLivro(String titulo) {
    Map<Livro, Integer> livros = cpLivros();
    List<String> livrosEncontrados = new ArrayList<>();
    String livroFormatado, livroNormalizado, tituloNormalizado = Tratamento.removerAcentuacao(titulo).toLowerCase();
    for (Livro livro : livros.keySet()) {
      livroNormalizado = Tratamento.removerAcentuacao(livro.getTitulo()).toLowerCase();
      if (livroNormalizado.contains(tituloNormalizado)) {
        livroFormatado = "{Livro: '" + livro.getTitulo() + "', ISBN: " + livro.getIsbn() + "}";
        livrosEncontrados.add(livroFormatado);
      }
    }
    return livrosEncontrados;
  }

  public List<LivroDTO> listarLivros() {
    Map<Livro, Integer> livros = cpLivros();
    List<LivroDTO> livrosDTO = new ArrayList<>();
    for (Livro livro : livros.keySet()) {
      livrosDTO.add(new LivroDTO(livro, livros.get(livro)));
    }
    return livrosDTO;
  }
}
