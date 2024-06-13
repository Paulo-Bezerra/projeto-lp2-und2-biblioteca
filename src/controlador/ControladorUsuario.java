package controlador;

import dto.BibliotecarioDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;
import dto.UsuarioDTO;
import servico.OperacoesUsuario;
import util.Tratamento;

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
    if (!Tratamento.validarStrings()) {
      return false;
    }
    return opUsuario.removerUsuarioPorMatricula(matricula);
  }

  public UsuarioDTO buscarUsuarioPorMatricula(String matricula) {
    if (matricula == null) {
      return null;
    }
    if (!Tratamento.validarStrings()) {
      return null;
    }
    if (opUsuario.buscarUsuarioPorMatricula(matricula) == null) {
      return null;
    }
    return opUsuario.buscarUsuarioPorMatricula(matricula);
  }

  public List<String> buscarMatriculaPorNome(String nome) {
    List<String> usuariosEncontrados = new ArrayList<>();
    StringBuilder text = new StringBuilder();
    for (UsuarioDTO usuarioDTO : buscarUsuarioPorNome(nome)) {
      if (usuarioDTO instanceof EstudanteDTO) {
        text.append("Estudante: ");
      } else if (usuarioDTO instanceof ProfessorDTO) {
        text.append("Professor: ");
      } else if (usuarioDTO instanceof BibliotecarioDTO) {
        text.append("Bibliotecario: ");
      }

      text.append("{Nome: '").append(usuarioDTO.getNome())
          .append("', CPF: '").append(usuarioDTO.getCpf())
          .append("', Matrícula: '").append(usuarioDTO.getMatricula()).append("'}");

      usuariosEncontrados.add(text.toString());
    }
    return usuariosEncontrados;
  }

  public List<UsuarioDTO> listarUsuarios() {
    return opUsuario.listarUsuarios();
  }

  public List<UsuarioDTO> buscarUsuarioPorNome(String nome) {
    if (nome == null) {
      return null;
    }
    if (!Tratamento.validarStrings(nome)) {
      return null;
    }
    return opUsuario.buscarUsuarioPorNome(nome);
  }
}
