package controlador;

import dto.LivroDTO;
import servico.OperacoesLivro;
import util.FiltroLivro;
import util.Tratamento;

import java.util.ArrayList;
import java.util.List;

public class ControladorLivro {
  private final OperacoesLivro opLivro = new OperacoesLivro();

  public boolean adicionarLivro(LivroDTO livroDTO) {
    if (livroDTO == null) {
      return false;
    }
    if (!livroDTO.validar()) {
      return false;
    }
    return opLivro.adicionarLivro(livroDTO);
  }

  public boolean removerLivroPorIsbn(String isbn) {
    if (isbn == null) {
      return false;
    }
    if (!Tratamento.validarStringsNumericas(isbn)) {
      return false;
    }
    return opLivro.removerLivroPorIsbn(isbn);
  }

  public List<String> consultarIsbnDoLivro(String titulo) {
    if (titulo == null) {
      return null;
    }
    if (!Tratamento.validarStrings(titulo)) {
      return null;
    }
    List<String> isbns = new ArrayList<>();
    for (LivroDTO livro : pesquisarLivro(titulo, FiltroLivro.POR_TITULO)) {
      isbns.add("Livro: {Título: '" + livro.getTitulo() + "', Autor: '" + livro.getAutor() + "' ISBN: '" + livro.getIsbn() + "'}");
    }
    return isbns;
  }

  public List<LivroDTO> listarLivros() {
    return opLivro.listarLivros();
  }

  public List<LivroDTO> pesquisarLivro(String entrada, FiltroLivro filtroLivro) {
    if (entrada == null) {
      return null;
    }
    if (!Tratamento.validarStrings(entrada) || filtroLivro == null) {
      return null;
    }
    return opLivro.pesquisarLivro(entrada, filtroLivro);
  }

  public LivroDTO buscarLivroPorIsbn(String isbn) {
    if (isbn == null) {
      return null;
    }
    if (!Tratamento.validarStrings(isbn)) {
      return null;
    }
    return opLivro.buscarLivroPorIsbn(isbn);
  }
}
