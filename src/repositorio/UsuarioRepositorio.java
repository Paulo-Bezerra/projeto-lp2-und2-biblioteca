package repositorio;

import modelo.Bibliotecario;
import modelo.Estudante;
import modelo.Professor;
import modelo.Usuario;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class UsuarioRepositorio implements Serializable {
  private final HashMap<String, Usuario> matriculas_UR;

  public UsuarioRepositorio() {
    this.matriculas_UR = new HashMap<>();
  }

  public UsuarioRepositorio(UsuarioRepositorio usuarioRepositorio) {
    this.matriculas_UR = new HashMap<>(usuarioRepositorio.matriculas_UR);
  }

  public boolean adicionarUsuario(Usuario usuario) {
    if (matriculas_UR.containsKey(usuario.getMatricula())) {
      return false;
    }
    matriculas_UR.put(usuario.getMatricula(), usuario);
    return true;
  }

  public boolean removerUsuario(String matricula) {
    if (!matriculas_UR.containsKey(matricula)) {
      return false;
    }
    matriculas_UR.remove(matricula);
    return true;
  }

  public HashSet<Usuario> getUsuarios() {
    return new HashSet<>(matriculas_UR.values());
  }

  public Usuario getUsuarioPorMatricula(String matricula) {
    switch (matriculas_UR.get(matricula)) {
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
  public boolean existeUsuario(String matricula) {
    return matriculas_UR.containsKey(matricula);
  }
}
