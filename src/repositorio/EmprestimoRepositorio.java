package repositorio;

import modelo.Emprestimo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EmprestimoRepositorio {
  private final HashSet<Emprestimo> ER;
  private final HashMap<String, ArrayList<Emprestimo>> matriculas_empretimos;
  private final HashMap<String, ArrayList<Emprestimo>> isbns_empretimos;

  public EmprestimoRepositorio() {
    this.ER = new HashSet<>();
    this.matriculas_empretimos = new HashMap();
    this.isbns_empretimos = new HashMap();
  }

  public boolean adicionaEmprestimo(Emprestimo emprestimo) {
    if (!ER.add(emprestimo)) {
      return false;
    }
    if (matriculas_empretimos.containsKey(emprestimo.getMatricula())) {
      matriculas_empretimos.get(emprestimo.getMatricula()).add(emprestimo);
    } else {
      ArrayList<Emprestimo> emprestimosMatricula = new ArrayList<>();
      emprestimosMatricula.add(emprestimo);
      matriculas_empretimos.put(emprestimo.getMatricula(), emprestimosMatricula);
    }
    if (isbns_empretimos.containsKey(emprestimo.getIsbn())) {
      isbns_empretimos.get(emprestimo.getIsbn()).add(emprestimo);
    } else {
      ArrayList<Emprestimo> emprestimosIsbn = new ArrayList<>();
      emprestimosIsbn.add(emprestimo);
      isbns_empretimos.put(emprestimo.getIsbn(), emprestimosIsbn);
    }
    return true;
  }

  public boolean removeEmprestimo(Emprestimo emprestimo) {
    if (!ER.remove(emprestimo)) {
      return false;
    }
    matriculas_empretimos.remove(emprestimo.getMatricula());
    isbns_empretimos.remove(emprestimo.getIsbn());
    return true;
  }

  public HashSet<Emprestimo> getEmprestimos() {
    return new HashSet<Emprestimo>(ER);
  }

  public ArrayList<Emprestimo> getEmprestimosPorMatricula(String matricula) {
    return new ArrayList<>(matriculas_empretimos.get(matricula));
  }

  public ArrayList<Emprestimo> getEmprestimosIsbn(String isbn) {
    return new ArrayList<>(isbns_empretimos.get(isbn));
  }
}
