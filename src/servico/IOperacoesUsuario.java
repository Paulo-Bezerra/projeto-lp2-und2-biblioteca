package servico;

public interface IOperacoesUsuario {
  String buscarUsuarioPorMatricula(String matricula);
  boolean removerUsuarioPorMatricula(String matricula);
}
