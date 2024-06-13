package controlador;

import dao.BancoDAO;

public class Controlador {
  private final BancoDAO bancoDAO;

  public Controlador() {
    this.bancoDAO = BancoDAO.getInstance();
  }

  public boolean carregarBancoDAO(){
    return bancoDAO.carregarDados();
  }

  public boolean salvarBancoDAO(){
    return bancoDAO.salvarDados();
  }
}
