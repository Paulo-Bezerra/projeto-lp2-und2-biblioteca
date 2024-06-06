package dao;

import repositorio.EstudanteRepositorio;
import repositorio.LivroRepositorio;

public class BancoDAO {
  private final LivroRepositorio LR;
  private final EstudanteRepositorio ER;

  private static BancoDAO instance;

  private BancoDAO() {
    LR = new LivroRepositorio();
    ER = new EstudanteRepositorio();
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

  public EstudanteRepositorio getER() {
    return ER;
  }
}
