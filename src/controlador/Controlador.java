package controlador;

import dao.BancoDAO;
import modelo.Bibliotecario;
import modelo.Usuario;

public class Controlador {
  private final BancoDAO bancoDAO;

  public Controlador() {
    this.bancoDAO = BancoDAO.getInstance();
  }

  public boolean carregarBancoDAO() {
    return bancoDAO.carregarDados();
  }

  public boolean salvarBancoDAO() {
    return bancoDAO.salvarDados();
  }

  public boolean realizarLogin(String login, String senha) {
    for (Usuario usuario : bancoDAO.getUR().getUsuarios()) {
      if (usuario instanceof Bibliotecario) {
        if (((Bibliotecario) usuario).getCredencias().getLogin().equalsIgnoreCase(login)
            && ((Bibliotecario) usuario).getCredencias().getSenha().equalsIgnoreCase(senha)) {
          return true;
        }
      }
    }
    return false;
  }
}
