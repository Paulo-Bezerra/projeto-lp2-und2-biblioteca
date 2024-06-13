package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitura {

  private static final Scanner sc = new Scanner(System.in);

  public static int leInt(String msg) {
    System.out.print(msg);
    try {
      return sc.nextInt();
    } catch (InputMismatchException e) {
      return leInt(msg);
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
