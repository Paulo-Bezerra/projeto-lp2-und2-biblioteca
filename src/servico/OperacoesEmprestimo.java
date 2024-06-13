package servico;

import dao.BancoDAO;
import dto.EmprestimoDTO;
import modelo.Emprestimo;
import repositorio.EmprestimoRepositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OperacoesEmprestimo {
  private final BancoDAO bancoDAO;

  public OperacoesEmprestimo() {
    bancoDAO = BancoDAO.getInstance();
  }

  private EmprestimoRepositorio getER() {
    return bancoDAO.getER();
  }

  public boolean registrarEmprestimo(EmprestimoDTO emprestimoDTO) {
    return getER().adicionaEmprestimo(new Emprestimo(emprestimoDTO));
  }

  public EmprestimoDTO getEmprestimo(String matricula, String isbn) {
    return new EmprestimoDTO(getER().getEmprestimo(matricula, isbn));
  }

  public boolean existeEmprestimo(String matricula, String isbn) {
    return getER().existeEmprestimo(matricula, isbn);
  }

  public boolean registrarDevolucao(String matricula, String isbn) {
    return getER().removeEmprestimo(matricula, isbn);
  }

  public List<EmprestimoDTO> getEmprestimos() {
    ArrayList<EmprestimoDTO> emprestimos = new ArrayList<>();
    for (Emprestimo emprestimo : getER().getEmprestimos()) {
      emprestimos.add(new EmprestimoDTO(emprestimo));
    }
    return emprestimos;
  }

  public ArrayList<EmprestimoDTO> getEmprestimosAtrasados() {
    ArrayList<EmprestimoDTO> emprestimos = new ArrayList<>();
    for (Emprestimo emprestimo : getER().getEmprestimos()) {
      if (LocalDate.now().isBefore(emprestimo.getDataDevolucao())){
        emprestimos.add(new EmprestimoDTO(emprestimo));
      }
    }
    return emprestimos;
  }
}
