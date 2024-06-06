package controlador;

import dto.LivroDTO;
import servico.Operacoes;

import java.util.ArrayList;

public class Controlador {
  private Operacoes op;

  public Controlador() {
    op = new Operacoes();
  }

  public boolean adicionarLivro(LivroDTO livroDTO) {
    if (!livroDTO.validarLivro()) {
      return false;
    }
    return op.adicionarLivro(livroDTO);
  }

  public ArrayList<LivroDTO> buscarLivroPorAutor(String autor) {
    return op.buscarLivroPorAutor(autor);
  }

}
