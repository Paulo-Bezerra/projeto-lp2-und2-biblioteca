package util;

import java.util.List;

public class Impressao {

  public static <T> void imprimirLista(List<T> lista) {
    System.out.println("[");
    lista.forEach(System.out::println);
    System.out.println("]");
  }

}
