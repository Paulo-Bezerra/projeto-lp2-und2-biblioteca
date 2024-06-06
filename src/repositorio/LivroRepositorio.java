package repositorio;

import modelo.Livro;

import java.util.HashMap;

public class LivroRepositorio {
    private final HashMap<Livro, Integer> LR;

    public LivroRepositorio() {
        LR = new HashMap<>();
    }

    public boolean adicionarLivro(Livro livro) {
        if (LR.containsKey(livro)) {
            return false;
        }
        LR.put(livro, livro.getEstoque());
        return true;
    }

    public boolean removerLivro(Livro livro) {
        if (!LR.containsKey(livro)) {
            return false;
        }
        LR.remove(livro);
        return true;
    }

    public HashMap<Livro, Integer> getLivros() {
        return new HashMap<Livro, Integer>(LR);
    }
}
