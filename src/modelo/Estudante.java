package modelo;

import java.time.LocalDate;

public class Estudante extends Pessoa{
    private String curso;

    public Estudante(String nome, String cpf, String matricula, String curso, LocalDate dataNascimento) {
        super(nome, cpf, matricula, dataNascimento);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}

