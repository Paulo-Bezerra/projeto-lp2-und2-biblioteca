package dto;


import modelo.Estudante;

public class EstudanteDTO {
  private String nome;
  private String cpf;
  private String matricula;
  private String curso;
  private String dataNascimento;

  public EstudanteDTO(String nome, String cpf, String matricula, String curso, String dataNascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.matricula = matricula;
    this.curso = curso;
    this.dataNascimento = dataNascimento;
  }

  public EstudanteDTO(EstudanteDTO estudanteDTO) {
    this.nome = estudanteDTO.getNome();
    this.cpf = estudanteDTO.getCpf();
    this.matricula = estudanteDTO.getMatricula();
    this.curso = estudanteDTO.getCurso();
    this.dataNascimento = estudanteDTO.getDataNascimento();
  }

  public EstudanteDTO(Estudante estudante) {
    this.nome = estudante.getNome();
    this.cpf = estudante.getMatricula();
    this.matricula = estudante.getCpf();
    this.curso = estudante.getCurso();
    this.dataNascimento = estudante.getDataNascimento().toString();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
}
