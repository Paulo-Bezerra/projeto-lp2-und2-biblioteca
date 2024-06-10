package controlador;

import dto.LivroDTO;
import servico.OperacoesLivro;
import util.FiltroLivro;
import util.Tratamento;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    if (!Tratamento.validarStringNumerica(isbn)) {
      return false;
    }
    return opLivro.removerLivroPorIsbn(isbn);
  }

  public List<String> consultarIsbnDoLivro(String titulo) {
    if (!Tratamento.validarStrings(titulo)) {
      return null;
    }
    return opLivro.consultarIsbnDoLivro(titulo);
  }

  public List<LivroDTO> listarLivros() {
    return opLivro.listarLivros();
  }

  public List<LivroDTO> pesquisarLivro(String entrada, FiltroLivro filtroLivro) {
    if (!Tratamento.validarStrings(entrada) || filtroLivro == null) {
      return null;
    }
    return opLivro.pesquisarLivro(entrada, filtroLivro);
  }
}
