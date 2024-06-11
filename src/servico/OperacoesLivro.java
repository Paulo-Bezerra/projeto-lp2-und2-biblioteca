package servico;

import dao.BancoDAO;
import dto.LivroDTO;
import modelo.Livro;
import util.FiltroLivro;
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
    Livro livro = bancoDAO.getLR().getLivroPorIsbn(isbn);
    if (livro == null) {
      return false;
    }
    return bancoDAO.getLR().removerLivro(livro);
  }

  public List<LivroDTO> listarLivros() {
    Map<Livro, Integer> livros = cpLivros();
    List<LivroDTO> livrosDTO = new ArrayList<>();
    for (Livro livro : livros.keySet()) {
      livrosDTO.add(new LivroDTO(livro, livros.get(livro)));
    }
    return livrosDTO;
  }

  public List<LivroDTO> pesquisarLivro(String entrada, FiltroLivro filtroLivro) {
    Map<Livro, Integer> livros = cpLivros();
    List<LivroDTO> livrosEncotrados = new ArrayList<>();
    boolean encontrou = false;
    for (Livro livro : livros.keySet()) {
      switch (filtroLivro) {
        case POR_TITULO -> {
          if (Tratamento.contemSubString(livro.getTitulo(), entrada)) {
            encontrou = true;
          }
        }
        case POR_AUTOR -> {
          if (Tratamento.contemSubString(livro.getAutor(), entrada)) {
            encontrou = true;
          }
        }
        case POR_ISBN -> {
          if (Tratamento.contemSubString(livro.getIsbn(), entrada)) {
            encontrou = true;
          }
        }
        case POR_ASSUNTO -> {
          if (Tratamento.contemSubString(livro.getAssunto(), entrada)) {
            encontrou = true;
          }
        }
      }
      if (encontrou) {
        livrosEncotrados.add(new LivroDTO(livro, livros.get(livro)));
        encontrou = false;
      }
    }
    return livrosEncotrados;
  }
}
