package servico;

import dto.LivroDTO;

import java.util.List;

public interface IOperacoesLivro {
    boolean adicionarLivro(LivroDTO livroDTO);

    boolean removerLivro(LivroDTO livroDTO);

    List<LivroDTO> listarLivros();

    List<LivroDTO> buscarLivroPorTitulo(String titulo);

    List<LivroDTO> buscarLivroPorAutor(String autor);

    List<LivroDTO> buscarLivroPorAssunto(String assunto);

    List<LivroDTO> buscarLivroPorAno(int ano);

    List<LivroDTO> buscarLivrosPorEstoqueCadastrado(int estoqueCadastrado);

    List<LivroDTO> buscarLivrosPorEstoqueDisponivel(int estoqueDisponivel);
}