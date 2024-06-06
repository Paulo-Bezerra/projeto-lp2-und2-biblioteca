package servico;

import dao.BancoDAO;
import dto.LivroDTO;
import modelo.Livro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Operacoes {
    private final BancoDAO bancoDAO;

    public Operacoes() {
        bancoDAO = BancoDAO.getInstance();
    }

    public boolean adicionarLivro(String titulo, String autor, String assunto, int ano, int estoque) {
        return bancoDAO.getLR().adicionarLivro(new Livro(titulo, autor, assunto, ano, estoque));
    }

    public boolean adicionarLivro(LivroDTO livroDTO) {
        return this.adicionarLivro(livroDTO.getTitulo(), livroDTO.getAutor(), livroDTO.getAssunto(), livroDTO.getAno(), livroDTO.getEstoque());
    }

    public boolean removerLivro(int id) {
        return false;
    }

    public boolean removerLivro(LivroDTO livroDTO) {
        return this.adicionarLivro(livroDTO);
    }

    public ArrayList<LivroDTO> buscarLivroPorAutor(String autor) {
        HashMap<Livro, Integer> filmesEncotrados = bancoDAO.getLR().buscarLivroPorAutor(autor);
        return converterListaDeLivrosParaDTO(filmesEncotrados);
    }

    private ArrayList<LivroDTO> converterListaDeLivrosParaDTO(HashMap<Livro, Integer> livros){
        ArrayList<LivroDTO> livrosDTO = new ArrayList<LivroDTO>();

        for(Livro livro : livros.keySet()) {
            livrosDTO.add(new LivroDTO(livro, livros.get(livro)));
        }
        return livrosDTO;
    }
}
