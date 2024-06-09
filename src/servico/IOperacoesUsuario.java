package servico;

import dto.UsuarioDTO;

import java.util.HashSet;
import java.util.List;

public interface IOperacoesUsuario {
  String buscarUsuarioPorMatricula(String matricula);
  boolean removerUsuarioPorMatricula(String matricula);
  List<UsuarioDTO> buscarMatriculaPorNome(String nome);
  List<UsuarioDTO> buscarUsuarioPorNome(String nome);
}
