package visao;

import controlador.Controlador;

import java.time.LocalDate;

public class AppUI {
  private final GerenciarUsuarioUI gUsuarioUI = new GerenciarUsuarioUI();
  private final GerenciarLivroUI gLivroUI = new GerenciarLivroUI();
  private final GerenciarEmprestimoUI gEmprestimoUI = new GerenciarEmprestimoUI();
  private final Controlador controlador = new Controlador();

  public void run() {
    System.out.println("Carregando os dados...");
    if (controlador.carregarBancoDAO()) {
      System.out.println("Dados carregados com sucesso.\nBem vindo ao Sistema da Bibliteca de Alexandria/RN");
    System.out.println(LocalDate.now());
    }
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
    System.out.println("Salvando os dados...");
    if (controlador.salvarBancoDAO()) {
      System.out.println("Dados salvos com sucesso.");
    } else {
      System.out.println("Erro ao salvar os dados.");
    }
    System.out.println("Saindo...");
  }
}
