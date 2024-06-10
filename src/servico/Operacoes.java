package servico;

import dao.BancoDAO;
import dto.*;
import modelo.*;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Operacoes {
  private final BancoDAO bancoDAO;

  public Operacoes() {
    bancoDAO = BancoDAO.getInstance();
  }

  // Operações com livros.

  public boolean adicionarLivro(LivroDTO livroDTO) {
    return this.adicionarLivro(new Livro(livroDTO));
  }

  private boolean adicionarLivro(Livro livro) {
    return bancoDAO.getLR().adicionarLivro(livro);
  }


  public boolean removerLivro(LivroDTO livroDTO) {
    return this.removerLivro(new Livro(livroDTO));
  }

  private boolean removerLivro(Livro livro) {
    return bancoDAO.getLR().removerLivro(livro);
  }

  public List<LivroDTO> listarLivros() {
    HashMap<Livro, Integer> livros = bancoDAO.getLR().getLivros();
    ArrayList<LivroDTO> listaLivrosDTO = new ArrayList<LivroDTO>();
    for (Livro livro : livros.keySet()) {
      listaLivrosDTO.add(new LivroDTO(livro, livros.get(livro)));
    }
    return listaLivrosDTO;
  }


  public List<LivroDTO> buscarLivroPorTitulo(String titulo) {
    HashMap<Livro, Integer> livros = bancoDAO.getLR().getLivros();
    ArrayList<LivroDTO> listaLivrosDTO = new ArrayList<LivroDTO>();
    for (Livro livro : livros.keySet()) {
      if (livro.getTitulo().equals(titulo)) {
        listaLivrosDTO.add(new LivroDTO(livro, livros.get(livro)));
      }
    }
    return listaLivrosDTO;
  }


  public List<LivroDTO> buscarLivroPorAutor(String autor) {
    HashMap<Livro, Integer> livros = bancoDAO.getLR().getLivros();
    ArrayList<LivroDTO> listaLivrosDTO = new ArrayList<LivroDTO>();
    for (Livro livro : livros.keySet()) {
      if (livro.getAutor().equals(autor)) {
        listaLivrosDTO.add(new LivroDTO(livro, livros.get(livro)));
      }
    }
    return listaLivrosDTO;
  }


  public List<LivroDTO> buscarLivroPorAssunto(String assunto) {
    HashMap<Livro, Integer> livros = bancoDAO.getLR().getLivros();
    ArrayList<LivroDTO> listaLivrosDTO = new ArrayList<LivroDTO>();
    for (Livro livro : livros.keySet()) {
      if (livro.getAssunto().equals(assunto)) {
        listaLivrosDTO.add(new LivroDTO(livro, livros.get(livro)));
      }
    }
    return listaLivrosDTO;
  }


  public List<LivroDTO> buscarLivroPorAno(int ano) {
    HashMap<Livro, Integer> livros = bancoDAO.getLR().getLivros();
    ArrayList<LivroDTO> listaLivrosDTO = new ArrayList<LivroDTO>();
    for (Livro livro : livros.keySet()) {
      if (livro.getAno() == ano) {
        listaLivrosDTO.add(new LivroDTO(livro, livros.get(livro)));
      }
    }
    return listaLivrosDTO;
  }


  public List<LivroDTO> buscarLivrosPorEstoqueCadastrado(int estoqueCadastrado) {
    HashMap<Livro, Integer> livros = bancoDAO.getLR().getLivros();
    ArrayList<LivroDTO> listaLivrosDTO = new ArrayList<LivroDTO>();
    for (Livro livro : livros.keySet()) {
      if (livro.getEstoque() == estoqueCadastrado) {
        listaLivrosDTO.add(new LivroDTO(livro, livros.get(livro)));
      }
    }
    return listaLivrosDTO;
  }


  public List<LivroDTO> buscarLivrosPorEstoqueDisponivel(int estoqueDisponivel) {
    HashMap<Livro, Integer> livros = bancoDAO.getLR().getLivros();
    ArrayList<LivroDTO> listaLivrosDTO = new ArrayList<LivroDTO>();
    for (Livro livro : livros.keySet()) {
      if (livros.get(livro).equals(estoqueDisponivel)) {
        listaLivrosDTO.add(new LivroDTO(livro, livros.get(livro)));
      }
    }
    return listaLivrosDTO;
  }
}
