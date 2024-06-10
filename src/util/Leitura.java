package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitura {

  private static final Scanner sc = new Scanner(System.in);

  public static int leInt(String msg) {
    int valor = 0;
    boolean lido = false;
    while (!lido) {
      System.out.print(msg);
      try {
        valor = sc.nextInt();
        lido = true;
      } catch (InputMismatchException e) {
        System.out.println("Erro: por favor, digite um número inteiro válido.");
        sc.next(); // Limpa o buffer de entrada
      }
    }
    return valor;
  }

  public static String leStr(String msg) {
    System.out.print(msg);
    return sc.nextLine();
  }
}
