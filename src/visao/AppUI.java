package visao;

import controlador.Controlador;

public class AppUI {
  private final GerenciarUsuarioUI gUsuarioUI = new GerenciarUsuarioUI();
  private final GerenciarLivroUI gLivroUI = new GerenciarLivroUI();
  private final GerenciarEmprestimoUI gEmprestimoUI = new GerenciarEmprestimoUI();
  private final Controlador controlador = new Controlador();

  public void run() {
    controlador.carregarBancoDAO();
    int opcao = 0;
    do {
      opcao = MenuUI.menuPrincipal();
      switch (opcao) {
        case 1:
          gUsuarioUI.gerenciarUsuario();
          break;
        case 2:
          gLivroUI.gerenciarLivro();
          break;
        case 3:
          gEmprestimoUI.gerenciarEmprestimo();
      }

    } while (opcao != 4);
    controlador.salvarBancoDAO();
  }
}
