package servico;

import dao.BancoDAO;
import dto.EmprestimoDTO;
import modelo.Emprestimo;
import repositorio.EmprestimoRepositorio;
import repositorio.LivroRepositorio;
import repositorio.UsuarioRepositorio;

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

  private UsuarioRepositorio getUR() {
    return bancoDAO.getUR();
  }

  private LivroRepositorio getLR() {
    return bancoDAO.getLR();
  }

  public boolean registrarEmprestimo(EmprestimoDTO emprestimoDTO) {
    if (!getUR().existeUsuario(emprestimoDTO.getMatricula())) {
      return false;
    }
    if (!getLR().existeLivro(emprestimoDTO.getIsbn())) {
      return false;
    }
    int numEmprestimoLivro = getER().getNumEmprestimosIsbn(emprestimoDTO.getIsbn());
    int numEstoqueLivro = getLR().getLivroPorIsbn(emprestimoDTO.getIsbn()).getEstoque();
    if (numEmprestimoLivro >= numEstoqueLivro) {
      return false;
    }

    int numEmprestimoUsuario = getER().getNumEmprestimosPorMatricula(emprestimoDTO.getMatricula());
    switch (emprestimoDTO.getTipoUsuario()) {
      case TIPO_ESTUDANTE ->  {
        if (numEmprestimoUsuario >= 3) {
          return false;
        }
      }
      case TIPO_PROFESSOR, TIPO_BIBLIOTECARIO -> {
        if (numEmprestimoUsuario >= 5) {
          return false;
        }
      }
    }

    return getER().adicionaEmprestimo(new Emprestimo(emprestimoDTO));
  }

  public boolean removerEmprestimo(String matricula, String isbn) {
    if (!getUR().existeUsuario(matricula)) {
      return false;
    }
    if (!getLR().existeLivro(isbn)) {
      return false;
    }
    return getER().removerEmprestimo(matricula, isbn);
  }

  public EmprestimoDTO getEmprestimo(String matricula, String isbn) {
    return new EmprestimoDTO(getER().getEmprestimo(matricula, isbn));
  }

  public boolean existeEmprestimo(String matricula, String isbn) {
    return getER().existeEmprestimo(matricula, isbn);
  }

  public boolean registrarDevolucao(String matricula, String isbn) {
    return getER().removerEmprestimo(matricula, isbn);
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
