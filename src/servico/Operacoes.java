package servico;

import dao.BancoDAO;
import dto.LivroDTO;
import modelo.Livro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Operacoes implements IOperacoesLivro {
    private final BancoDAO bancoDAO;

    public Operacoes() {
        bancoDAO = BancoDAO.getInstance();
    }

    @Override
    public boolean adicionarLivro(LivroDTO livroDTO) {
        return this.adicionarLivro(livroDTO.getTitulo(), livroDTO.getAutor(), livroDTO.getAssunto(), livroDTO.getAno(), livroDTO.getEstoque());
    }

    private boolean adicionarLivro(String titulo, String autor, String assunto, int ano, int estoque) {
        return bancoDAO.getLR().adicionarLivro(new Livro(titulo, autor, assunto, ano, estoque));
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    /*
    private ArrayList<LivroDTO> converterListaDeLivrosParaDTO(HashMap<Livro, Integer> livros){
        ArrayList<LivroDTO> livrosDTO = new ArrayList<LivroDTO>();

        for(Livro livro : livros.keySet()) {
            livrosDTO.add(new LivroDTO(livro, livros.get(livro)));
        }
        return livrosDTO;
    }
    */
}
