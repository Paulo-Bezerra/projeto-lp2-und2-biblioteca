package repositorio;

import modelo.Emprestimo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EmprestimoRepositorio implements Serializable {
  private final HashMap<String, Emprestimo> mat_isbn_ER;
  private final HashMap<String, ArrayList<Emprestimo>> matriculas_empretimos;
  private final HashMap<String, ArrayList<Emprestimo>> isbns_empretimos;

  public EmprestimoRepositorio() {
    this.mat_isbn_ER = new HashMap<>();
    this.matriculas_empretimos = new HashMap<>();
    this.isbns_empretimos = new HashMap<>();
  }

  public EmprestimoRepositorio(EmprestimoRepositorio emprestimoRepositorio) {
    this.mat_isbn_ER = new HashMap<>(emprestimoRepositorio.mat_isbn_ER);
    this.matriculas_empretimos = new HashMap<>(emprestimoRepositorio.matriculas_empretimos);
    this.isbns_empretimos = new HashMap<>(emprestimoRepositorio.isbns_empretimos);
  }

  public boolean adicionaEmprestimo(Emprestimo emprestimo) {
    if (mat_isbn_ER.containsKey(emprestimo.getMatricula() + "-" +emprestimo.getIsbn())) {
      return false;
    }
    mat_isbn_ER.put(emprestimo.getMatricula() + "-" + emprestimo.getIsbn(), emprestimo);

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

  public boolean removeEmprestimo(String matricula, String isbn) {
    if (!mat_isbn_ER.containsKey(matricula + "-" + isbn)) {
      return false;
    }
    mat_isbn_ER.remove(matricula + "-" + isbn);
    matriculas_empretimos.remove(matricula);
    isbns_empretimos.remove(isbn);
    return true;
  }

  public HashSet<Emprestimo> getEmprestimos() {
    return new HashSet<>(mat_isbn_ER.values());
  }

  public ArrayList<Emprestimo> getEmprestimosPorMatricula(String matricula) {
    return new ArrayList<>(matriculas_empretimos.get(matricula));
  }

  public ArrayList<Emprestimo> getEmprestimosIsbn(String isbn) {
    return new ArrayList<>(isbns_empretimos.get(isbn));
  }

  public Emprestimo getEmprestimo(String matricula, String isbn) {
    return mat_isbn_ER.get(matricula + "-" + isbn);
  }

  public boolean existeEmprestimo(String matricula, String isbn) {
    return mat_isbn_ER.containsKey(matricula + "-" + isbn);
  }
}
