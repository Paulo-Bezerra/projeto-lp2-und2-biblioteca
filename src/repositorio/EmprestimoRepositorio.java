package repositorio;

import modelo.Emprestimo;

import java.util.HashSet;

public class EmprestimoRepositorio {
    private final HashSet<Emprestimo> ER;

    public EmprestimoRepositorio() {
        this.ER = new HashSet<Emprestimo>();
    }

    public boolean adicionaEmprestimo(Emprestimo emprestimo) {
        return ER.add(emprestimo);
    }

    public boolean removeEmprestimo(Emprestimo emprestimo) {
        return ER.remove(emprestimo);
    }

    public HashSet<Emprestimo> getEmprestimos() {
        return new HashSet<Emprestimo>(ER);
    }
}
