package dto;


import modelo.Estudante;
import util.Tratamento;

public class EstudanteDTO extends UsuarioDTO {
  private String curso;

  public EstudanteDTO(String nome, String cpf, String matricula, String dataNascimento, String curso) {
    super(nome, cpf, matricula, dataNascimento);
    this.curso = curso;
  }

  public EstudanteDTO(EstudanteDTO estudanteDTO) {
    super(estudanteDTO);
    this.curso = estudanteDTO.getCurso();

  }

  public EstudanteDTO(Estudante estudante) {
    super(estudante);
    this.curso = estudante.getCurso();
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  @Override
  public boolean validar() {
    return (Tratamento.validarStrings(this.getNome(), this.getCurso())
            && Tratamento.validarStringNumerica(this.getMatricula())
            && Tratamento.validarCPF(this.getCpf())
            && Tratamento.validarDatas(this.getDataNascimento()));
  }

  @Override
  public String toString() {
    return "Estudante: {" +
           "Nome: '" + this.getNome() + "'" +
           ", CPF: '" + this.getCpf() + "'" +
           ", Matrícula: '" + this.getMatricula() + "'" +
           ", Data de nascimento: '" + this.getDataNascimento() + "'" +
           ", Curso: " + this.getCurso() +
           "}";
  }
}
