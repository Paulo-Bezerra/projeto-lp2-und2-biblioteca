package servico;

import dao.BancoDAO;
import dto.LivroDTO;
import modelo.Livro;
import repositorio.EmprestimoRepositorio;
import repositorio.LivroRepositorio;
import repositorio.UsuarioRepositorio;
import util.FiltroLivro;
import util.Tratamento;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OperacoesLivro {
  private final BancoDAO bancoDAO;

  public OperacoesLivro() {
    bancoDAO = BancoDAO.getInstance();
  }

  private LivroRepositorio getLR() {
    return bancoDAO.getLR();
  }

  private EmprestimoRepositorio getER() {
    return bancoDAO.getER();
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
    if (getER().getNumEmprestimosIsbn(isbn) > 0) {
      return false;
    }
    return getLR().removerLivro(isbn);
  }

  public List<LivroDTO> listarLivros() {
    List<LivroDTO> livrosDTO = new ArrayList<>();
    for (Livro livro : cpLivros()) {
      livrosDTO.add(new LivroDTO(livro, calcularDisponibilidade(livro)));
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
        livrosEncotrados.add(new LivroDTO(livro, calcularDisponibilidade(livro)));
        encontrou = false;
      }
    }
    return livrosEncotrados;
  }

  public LivroDTO buscarLivroPorIsbn(String isbn) {
    Livro livro = getLR().getLivroPorIsbn(isbn);
    try {
      return new LivroDTO(livro, calcularDisponibilidade(livro));
    } catch (Exception e) {
      return null;
    }
  }

  private int calcularDisponibilidade(Livro livro) {
    try {
      return livro.getEstoque() - getER().getNumEmprestimosIsbn(livro.getIsbn());
    } catch (Exception e) {
      return 0;
    }

  }
}
