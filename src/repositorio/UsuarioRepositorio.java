package repositorio;

import modelo.Usuario;

import java.util.HashSet;

public class UsuarioRepositorio {
    private final HashSet<Usuario> UR;

    public UsuarioRepositorio() {
        this.UR = new HashSet<Usuario>();
    }

    public boolean adicionarUsuario(Usuario usuario) {
        return UR.add(usuario);
    }

    public boolean removerUsuario(Usuario usuario) {
        return UR.remove(usuario);
    }

    public HashSet<Usuario> getUR() {
        return new HashSet<Usuario>(UR);
    }

}
