package servico;

import dao.BancoDAO;
import dto.BibliotecarioDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;
import dto.UsuarioDTO;
import modelo.Bibliotecario;
import modelo.Estudante;
import modelo.Professor;
import modelo.Usuario;
import util.Tratamento;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OperacoesUsuario {
  private final BancoDAO bancoDAO;

  public OperacoesUsuario() {
    bancoDAO = BancoDAO.getInstance();
  }

  // Operações com os usuário.

  public <T extends UsuarioDTO> boolean adicionarUsuario(T usuarioDTO) {
    if (usuarioDTO instanceof EstudanteDTO) {
      return adicionarUsuario(new Estudante((EstudanteDTO) usuarioDTO));
    } else if (usuarioDTO instanceof ProfessorDTO) {
      return adicionarUsuario(new Professor((ProfessorDTO) usuarioDTO));
    } else if (usuarioDTO instanceof BibliotecarioDTO) {
      return adicionarUsuario(new Bibliotecario((BibliotecarioDTO) usuarioDTO));
    }
    return false;
  }

  private <T extends Usuario> boolean adicionarUsuario(T usuario) {
    return bancoDAO.getUR().adicionarUsuario(usuario);
  }

  public boolean removerUsuarioPorMatricula(String matricula) {
    HashSet<Usuario> usuarios = bancoDAO.getUR().getUsuarios();
    for (Usuario usuario : usuarios) {
      if (usuario.getMatricula().equals(matricula)) {
        return removerUsuarioPorMatricula(usuario);
      }
    }
    return false;
  }

  public boolean removerUsuarioPorMatricula(Usuario usuario) {
    return bancoDAO.getUR().removerUsuario(usuario);
  }

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


  public List<UsuarioDTO> buscarMatriculaPorNome(String nome) {
    HashSet<Usuario> usuarios = bancoDAO.getUR().getUsuarios();
    String usuarioNormalizado, entradaNormalizada = Tratamento.removerAcentuacao(nome).toLowerCase();
    ArrayList<UsuarioDTO> usuariosEncontrados = new ArrayList<>();

    for (Usuario usuario : usuarios) {
      usuarioNormalizado = Tratamento.removerAcentuacao(usuario.getNome()).toLowerCase();
      if (usuarioNormalizado.contains(entradaNormalizada)) {
        if (usuario instanceof Estudante) {
          usuariosEncontrados.add(new EstudanteDTO((Estudante) usuario));
        } else if (usuario instanceof Professor) {
          usuariosEncontrados.add(new ProfessorDTO((Professor) usuario));
        } else if (usuario instanceof Bibliotecario) {
          usuariosEncontrados.add(new BibliotecarioDTO((Bibliotecario) usuario));
        }
      }
    }
    return usuariosEncontrados;
  }


  public List<UsuarioDTO> buscarUsuarioPorNome(String nome) {
    HashSet<Usuario> usuarios = bancoDAO.getUR().getUsuarios();
    String usuarioNormalizado, entradaNormalizada = Tratamento.removerAcentuacao(nome).toLowerCase();
    ArrayList<UsuarioDTO> usuariosEncontrados = new ArrayList<>();
    for (Usuario usuario : usuarios) {
      usuarioNormalizado = Tratamento.removerAcentuacao(usuario.getNome()).toLowerCase();
      if (usuarioNormalizado.contains(entradaNormalizada)) {
        if (usuario instanceof Estudante) {
          usuariosEncontrados.add(new EstudanteDTO((Estudante) usuario));
        } else if (usuario instanceof Professor) {
          usuariosEncontrados.add(new ProfessorDTO((Professor) usuario));
        } else if (usuario instanceof Bibliotecario) {
          usuariosEncontrados.add(new BibliotecarioDTO((Bibliotecario) usuario));
        }
      }
    }
    return usuariosEncontrados;
  }

  public List<UsuarioDTO> listarUsuarios() {
    HashSet<Usuario> usuarios = bancoDAO.getUR().getUsuarios();
    ArrayList<UsuarioDTO> usuariosDTO = new ArrayList<>();
    for (Usuario usuario : usuarios) {
      if (usuario instanceof Estudante) {
        usuariosDTO.add(new EstudanteDTO((Estudante) usuario));
      } else if (usuario instanceof Professor) {
        usuariosDTO.add(new ProfessorDTO((Professor) usuario));
      } else if (usuario instanceof Bibliotecario) {
        usuariosDTO.add(new BibliotecarioDTO((Bibliotecario) usuario));
      }
    }
    return usuariosDTO;
  }
}
