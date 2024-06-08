package dao;

import repositorio.LivroRepositorio;

public class BancoDAO {
  private final LivroRepositorio LR;

  private static BancoDAO instance;

  private BancoDAO() {
    LR = new LivroRepositorio();
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
}
