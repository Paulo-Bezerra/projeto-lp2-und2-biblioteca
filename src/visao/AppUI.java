package visao;

public class AppUI {
  private final Controlador controlador = new Controlador();
  private final GerenciarUsuarioUI gUsuarioUI = new GerenciarUsuarioUI();
  private final GerenciarLivroUI gLivroUI = new GerenciarLivroUI();

  public void run() {
    int opcao = 0;
    do {
      opcao = MenuUI.menuPrincipal();
      switch (opcao) {
        case 1:
          gUsuarioUI.gerenciarUsuario(); //aqui
          break;
          case 2:
            gLivroUI.gerenciarLivro();
      }

    } while (opcao != 4);
  }
}
