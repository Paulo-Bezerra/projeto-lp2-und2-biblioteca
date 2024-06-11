package visao;

import controlador.ControladorLivro;

public class GerenciarEmprestimoUI {
  ControladorLivro cEmprestimo = new ControladorLivro();

  public void gerenciarEmprestimo() {
    int opcao = 0;
    do {
      opcao = MenuUI.gerenciarEmprestimo();
      switch (opcao) {
        case 1:
          registrarEmprestimo(); //
          break;
        case 2:
          registrarDevolucao(); //
          break;
        case 3:
          consultarEmprestimos(); // //
          break;
      }

    } while (opcao != 4);
  }

  private void registrarEmprestimo() {
  }
  private void registrarDevolucao() {
  }

  private void consultarEmprestimos() {
  }
}
