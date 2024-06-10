package controlador;

import dto.*;
import servico.Operacoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Controlador {
  private final Operacoes op;

  public Controlador() {
    op = new Operacoes();
  }

  public List<LivroDTO> buscarLivroPorTitulo(String titulo) {
    return op.buscarLivroPorTitulo(titulo);
  }

  public List<LivroDTO> buscarLivroPorAutor(String autor) {
    return op.buscarLivroPorAutor(autor);
  }

  public List<LivroDTO> buscarLivroPorAssunto(String assunto) {
    return op.buscarLivroPorAssunto(assunto);
  }

  public List<LivroDTO> buscarLivroPorAno(int ano) {
    return op.buscarLivroPorAno(ano);
  }

  public List<LivroDTO> buscarLivrosPorEstoqueCadastrado(int estoqueCadastrado) {
    return op.buscarLivrosPorEstoqueCadastrado(estoqueCadastrado);
  }

  public List<LivroDTO> buscarLivrosPorEstoqueDisponivel(int estoqueDisponivel) {
    return op.buscarLivrosPorEstoqueDisponivel(estoqueDisponivel);
  }
}
