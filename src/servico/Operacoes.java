package servico;

import dao.BancoDAO;
import dto.*;
import modelo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Operacoes implements IOperacoesLivro, IOperacoesUsuario, IOperacoesEstudante, IOperacoesProfessor, IOperacoesBibliotecario, IOperacoesEmprestimo {
    private final BancoDAO bancoDAO;

    public Operacoes() {
        bancoDAO = BancoDAO.getInstance();
    }

    // Operações com livros.
    @Override
    public boolean adicionarLivro(LivroDTO livroDTO) {
        return this.adicionarLivro(new Livro(livroDTO));
    }

    private boolean adicionarLivro(Livro livro) {
        return bancoDAO.getLR().adicionarLivro(livro);
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

    // Operações com os usuário.
    @Override
    public String buscarUsuarioPorMatricula(String matricula) {
        HashSet<Usuario> usuarios = bancoDAO.getUR().getUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                if (usuario instanceof Estudante) {
                    return new EstudanteDTO((Estudante) usuario).toString();
                }
                if (usuario instanceof Professor) {
                    return new ProfessorDTO((Professor) usuario).toString();
                }
                if (usuario instanceof Bibliotecario) {
                    return new BibliotecarioDTO((Bibliotecario) usuario).toString();
                }
            }
        }
        return null;
    }

    @Override
    public boolean removerUsuarioPorMatricula(String matricula) {
        HashSet<Usuario> usuarios = bancoDAO.getUR().getUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                return bancoDAO.getUR().removerUsuario(usuario);
            }
        }
        return false;
    }

    // Operações com os estudantes.

    @Override
    public boolean adicionarEstudante(EstudanteDTO estudanteDTO) {
        return adicionarEstudante(new Estudante(estudanteDTO));
    }

    private boolean adicionarEstudante(Estudante estudante) {
        return bancoDAO.getUR().adicionarUsuario(estudante);
    }

    @Override
    public List<EstudanteDTO> listarEstudantes() {
        return List.of();
    }

    // Operações com os professores.
    @Override
    public boolean adicionarProfessor(ProfessorDTO professorDTO) {
        return adicionarProfessor(new Professor(professorDTO));
    }

    private boolean adicionarProfessor(Professor professor) {
        return bancoDAO.getUR().adicionarUsuario(professor);
    }

    // Operações com os professores.
    @Override
    public boolean adicionarBibliotecario(BibliotecarioDTO bibliotecarioDTO) {
        return adicionarBibliotecario(new Bibliotecario(bibliotecarioDTO));
    }

    private boolean adicionarBibliotecario(Bibliotecario bibliotecario) {
        return bancoDAO.getUR().adicionarUsuario(bibliotecario);
    }
}
