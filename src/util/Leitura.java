package util;

import java.util.Scanner;

public class Leitura {

  private static Scanner sc = new Scanner(System.in);

  public static int leInt(String msg) {
    System.out.print(msg);
    return sc.nextInt();
  }

  public static float leFloat(String msg) {
    System.out.print(msg);
    return sc.nextFloat();
  }

  public static String leStr(String msg) {
    System.out.print(msg);
    sc = new Scanner(System.in);
    return sc.nextLine();
  }

}