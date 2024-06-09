package visao;

import util.Leitura;

public class DialogoUI {
  public static int dialogoConfirmar(String msg) {
    int opcao = 0;
    while (true) {
      opcao = Leitura.LeInt(msg);
      if (opcao == 1 || opcao == 2) {
        return opcao;
      }
      System.out.println("Opção invalida.");
    }
  }
}
