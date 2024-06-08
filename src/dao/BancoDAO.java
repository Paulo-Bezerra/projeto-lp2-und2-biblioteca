package dao;

import modelo.Usuario;
import repositorio.EmprestimoRepositorio;
import repositorio.LivroRepositorio;
import repositorio.UsuarioRepositorio;

public class BancoDAO {
  private final LivroRepositorio LR;
  private final UsuarioRepositorio UR;
  private final EmprestimoRepositorio ER;

  private static BancoDAO instance;

  private BancoDAO() {
    LR = new LivroRepositorio();
    UR = new UsuarioRepositorio();
    ER = new EmprestimoRepositorio();
  }

  public static BancoDAO getInstance() {
    if (instance == null) {
      instance = new BancoDAO();
    }
    return instance;
  }

  public LivroRepositorio getLR() {
    return LR;
  }
  public UsuarioRepositorio getUR() {
    return UR;
  }
  public EmprestimoRepositorio getER() {
    return ER;
  }
}
