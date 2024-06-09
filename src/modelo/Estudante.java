package modelo;

import dto.EstudanteDTO;
import dto.UsuarioDTO;

import java.time.LocalDate;

public class Estudante extends Usuario {
  private String curso;

  public Estudante(String nome, String cpf, String matricula, LocalDate dataNascimento, String curso) {
    super(nome, cpf, matricula, dataNascimento);
    this.curso = curso;
  }

  public Estudante(Estudante estudante) {
    super(estudante.getNome(), estudante.getCpf(), estudante.getMatricula(), estudante.getDataNascimento());
    this.curso = estudante.getCurso();
  }

  public Estudante(EstudanteDTO estudanteDTO) {
    super(estudanteDTO);
    this.curso = estudanteDTO.getCurso();
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }
}

