package controlador;

import dto.LivroDTO;
import servico.Operacoes;

import java.util.List;

public class Controlador {
    private final Operacoes op;

    public Controlador() {
        op = new Operacoes();
    }

    public boolean adicionarLivro(LivroDTO livroDTO) {
        if (!livroDTO.validarLivro()) {
            return false;
        }
        return op.adicionarLivro(livroDTO);
    }

    public List<LivroDTO> buscarLivroPorAutor(String autor) {
        return op.buscarLivroPorAutor(autor);
    }



}
