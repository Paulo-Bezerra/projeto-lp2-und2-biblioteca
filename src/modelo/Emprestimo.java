package modelo;

import java.time.LocalDate;

public class Emprestimo {
    private String matricula;
    private String isbn;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(String matricula, String isbn, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.matricula = matricula;
        this.isbn = isbn;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(Emprestimo emprestimo) {
        this.matricula = emprestimo.getMatricula();
        this.isbn = emprestimo.getIsbn();
        this.dataEmprestimo = emprestimo.getDataEmprestimo();
        this.dataDevolucao = emprestimo.getDataDevolucao();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
