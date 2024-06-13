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
import repositorio.EmprestimoRepositorio;
import repositorio.UsuarioRepositorio;
import util.Tratamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OperacoesUsuario {
  private final BancoDAO bancoDAO;

  public OperacoesUsuario() {
    bancoDAO = BancoDAO.getInstance();
  }

  private UsuarioRepositorio getUR() {
    return bancoDAO.getUR();
  }

  private EmprestimoRepositorio getER() {
    return bancoDAO.getER();
  }

  private Set<Usuario> cpUsuarios() {
    return getUR().getUsuarios();
  }

  public <T extends UsuarioDTO> boolean adicionarUsuario(T usuarioDTO) {
    return adicionarUsuario(converterDTOParaUsuario(usuarioDTO));
  }

  private <T extends Usuario> boolean adicionarUsuario(T usuario) {
    return getUR().adicionarUsuario(usuario);
  }

  public boolean removerUsuarioPorMatricula(String matricula) {
    if (getER().getNumEmprestimosPorMatricula(matricula) > 0) {
      return false;
    }
    return getUR().removerUsuario(matricula);
  }

  public UsuarioDTO buscarUsuarioPorMatricula(String matricula) {
    return converterUsuarioParaDTO(getUR().getUsuarioPorMatricula(matricula));
  }

  public List<UsuarioDTO> listarUsuarios() {
    ArrayList<UsuarioDTO> usuariosDTO = new ArrayList<>();
    for (Usuario usuario : cpUsuarios()) {
      usuariosDTO.add(converterUsuarioParaDTO(usuario));
    }
    return usuariosDTO;
  }

  public List<UsuarioDTO> buscarUsuarioPorNome(String nome) {
    ArrayList<UsuarioDTO> usuariosEncontrados = new ArrayList<>();
    for (Usuario usuario : cpUsuarios()) {
      if (Tratamento.contemSubString(usuario.getNome(), nome)) {
        usuariosEncontrados.add(converterUsuarioParaDTO(usuario));
      }
    }
    return usuariosEncontrados;
  }

  private Usuario converterDTOParaUsuario(UsuarioDTO usuarioDTO) {
    switch (usuarioDTO) {
      case EstudanteDTO estudanteDTO -> {
        return new Estudante(estudanteDTO);
      }
      case ProfessorDTO professorDTO -> {
        return new Professor(professorDTO);
      }
      case BibliotecarioDTO bibliotecarioDTO -> {
        return new Bibliotecario(bibliotecarioDTO);
      }
      default -> {
        return null;
      }
    }
  }

  private UsuarioDTO converterUsuarioParaDTO(Usuario usuario) {
    switch (usuario) {
      case Estudante estudante -> {
        return new EstudanteDTO(estudante);
      }
      case Professor professor -> {
        return new ProfessorDTO(professor);
      }
      case Bibliotecario bibliotecario -> {
        return new BibliotecarioDTO(bibliotecario);
      }
      default -> {
        return null;
      }
    }
  }
}
