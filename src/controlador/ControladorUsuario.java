package controlador;

import dto.BibliotecarioDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;
import dto.UsuarioDTO;
import servico.OperacoesUsuario;

import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
  private final OperacoesUsuario opUsuario = new OperacoesUsuario();

  public <T extends UsuarioDTO> boolean adicionarUsuario(T usuarioDTO) {
    if (usuarioDTO == null) {
      return false;
    }
    if (!usuarioDTO.validar()) {
      return false;
    }
    return opUsuario.adicionarUsuario(usuarioDTO);
  }

  public boolean removerUsuarioPorMatricula(String matricula) {
    if (matricula == null) {
      return false;
    }
    if (matricula.isEmpty() || matricula.equals(" ")) {
      return false;
    }
    return opUsuario.removerUsuarioPorMatricula(matricula);
  }

  public String buscarUsuarioPorMatricula(String matricula) {
    if (matricula == null) {
      return null;
    }
    if (matricula.isEmpty() || matricula.equals(" ")) {
      return null;
    }
    return opUsuario.buscarUsuarioPorMatricula(matricula);
  }

  public List<String> buscarMatriculaPorNome(String nome) {
    ArrayList<String> usuariosEncontrados = new ArrayList<>();
    StringBuilder text = new StringBuilder();
    for (UsuarioDTO usuarioDTO : opUsuario.buscarMatriculaPorNome(nome)) {
      if (usuarioDTO instanceof EstudanteDTO) {
        text = new StringBuilder("Estudante: ");
      } else if (usuarioDTO instanceof ProfessorDTO) {
        text = new StringBuilder("Professor: ");
      } else if (usuarioDTO instanceof BibliotecarioDTO) {
        text = new StringBuilder("Bibliotecario: ");
      }
      text.append("{Nome: '").append(usuarioDTO.getNome()).append("', Matrícula: ").append(usuarioDTO.getMatricula()).append("}");
      usuariosEncontrados.add(text.toString());
    }
    return usuariosEncontrados;
  }

  public List<UsuarioDTO> listarUsuarios() {
    return opUsuario.listarUsuarios();
  }

  public List<UsuarioDTO> buscarUsuarioPorNome(String nome) {
    return opUsuario.buscarUsuarioPorNome(nome);
  }
}
