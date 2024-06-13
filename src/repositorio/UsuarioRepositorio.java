package repositorio;

import modelo.Bibliotecario;
import modelo.Estudante;
import modelo.Professor;
import modelo.Usuario;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class UsuarioRepositorio implements Serializable {
  private final HashSet<Usuario> UR;
  private final HashMap<String, Usuario> usuarioPorMatricula;

  public UsuarioRepositorio() {
    this.UR = new HashSet<>();
    this.usuarioPorMatricula = new HashMap<>();
  }

  public UsuarioRepositorio(UsuarioRepositorio usuarioRepositorio) {
    this.UR = new HashSet<>(usuarioRepositorio.UR);
    this.usuarioPorMatricula = new HashMap<>(usuarioRepositorio.usuarioPorMatricula);
  }

  public boolean adicionarUsuario(Usuario usuario) {
    if (UR.contains(usuario) || usuarioPorMatricula.containsKey(usuario.getMatricula())) {
      return false;
    }
    if (!UR.add(usuario)) {
      return false;
    }
    usuarioPorMatricula.put(usuario.getMatricula(), usuario);
    return true;
  }

  public boolean removerUsuario(String matricula) {
    if (!usuarioPorMatricula.containsKey(matricula)) {
      return false;
    }
    if (!UR.remove(usuarioPorMatricula.get(matricula))) {
      return false;
    }
    usuarioPorMatricula.remove(matricula);
    return true;
  }

  public HashSet<Usuario> getUsuarios() {
    return new HashSet<>(UR);
  }

  public Usuario getUsuarioPorMatricula(String matricula) {
    switch (usuarioPorMatricula.get(matricula)) {
      case Estudante estudante -> {
        return new Estudante(estudante);
      }
      case Professor professor -> {
        return new Professor(professor);
      }
      case Bibliotecario bibliotecario -> {
        return new Bibliotecario(bibliotecario);
      }
      default -> {
        return null;
      }
    }
  }


}
