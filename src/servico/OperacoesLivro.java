package servico;

import dao.BancoDAO;
import dto.LivroDTO;
import modelo.Livro;
import repositorio.LivroRepositorio;
import util.FiltroLivro;
import util.Tratamento;

import java.util.*;

public class OperacoesLivro {
  private final BancoDAO bancoDAO;

  public OperacoesLivro() {
    bancoDAO = BancoDAO.getInstance();
  }

  private LivroRepositorio getLR() {
    return bancoDAO.getLR();
  }

  private HashSet<Livro> cpLivros() {
    return getLR().getLivros();
  }

  public boolean adicionarLivro(LivroDTO livroDTO) {
    return adicionarLivro(new Livro(livroDTO));
  }

  private boolean adicionarLivro(Livro livro) {
    return bancoDAO.getLR().adicionarLivro(livro);
  }

  public boolean removerLivroPorIsbn(String isbn) {
    return bancoDAO.getLR().removerLivro(isbn);
  }

  public List<LivroDTO> listarLivros() {
    List<LivroDTO> livrosDTO = new ArrayList<>();
    for (Livro livro : cpLivros()) {
      livrosDTO.add(new LivroDTO(livro, getLR().getDisponibilidadePorIsbn(livro.getIsbn())));
    }
    return livrosDTO;
  }

  public List<LivroDTO> pesquisarLivro(String entrada, FiltroLivro filtroLivro) {
    List<LivroDTO> livrosEncotrados = new ArrayList<>();
    boolean encontrou = false;
    for (Livro livro : cpLivros()) {
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
        livrosEncotrados.add(new LivroDTO(livro, getLR().getDisponibilidadePorIsbn(livro.getIsbn())));
        encontrou = false;
      }
    }
    return livrosEncotrados;
  }

  public LivroDTO buscarLivroPorIsbn(String isbn) {
    return new LivroDTO(getLR().getLivroPorIsbn(isbn), getLR().getDisponibilidadePorIsbn(isbn));
  }
}
