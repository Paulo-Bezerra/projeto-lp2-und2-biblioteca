package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitura {

  private static final Scanner sc = new Scanner(System.in);

  public static int leInt(String msg) {
    System.out.print(msg);
    while (true) {
      try {
        return sc.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
        sc.next(); // Limpa o buffer do scanner
        System.out.print(msg);
      }
    }
  }

  public static String leStr(String msg) {
    System.out.print(msg);
    String str = sc.nextLine().trim();
    if (str.isEmpty()) {
      return sc.nextLine().trim();
    }
    return str;
  }
}
