package controlador;

import dto.*;
import servico.Operacoes;

import java.util.List;

public class Controlador {
  private final Operacoes op;

  public Controlador() {
    op = new Operacoes();
  }

  public boolean adicionarLivro(LivroDTO livroDTO) {
    if (!livroDTO.validar()) {
      return false;
    }
    return op.adicionarLivro(livroDTO);
  }

  public boolean removerLivro(LivroDTO livroDTO) {
    if (!livroDTO.validar()) {
      return false;
    }
    return op.removerLivro(livroDTO);
  }

  public List<LivroDTO> listarLivros() {
    return op.listarLivros();
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

  public boolean adicionarEstudante(EstudanteDTO estudanteDTO) {
    if (!estudanteDTO.validar()) {
      return false;
    }
    return op.adicionarEstudante(estudanteDTO);
  }

  public boolean adicionarProfessor(ProfessorDTO professorDTO) {
    if (!professorDTO.validar()) {
      return false;
    }
    return op.adicionarProfessor(professorDTO);
  }

  public boolean adicionarBibliotecario(BibliotecarioDTO bibliotecarioDTO) {
    if (!bibliotecarioDTO.validar()) {
      return false;
    }
    return op.adicionarBibliotecario(bibliotecarioDTO);
  }
}
