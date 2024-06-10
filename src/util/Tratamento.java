package util;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Tratamento {
  public static String removerAcentuacao(String texto) {
    return Normalizer.normalize(texto, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}", "");
  }

  public static boolean validarStrings(String... entradas) {
    for (String entrada : entradas) {
      if (entrada.isEmpty() || entrada.equals(" ")) {
        return false;
      }
    }
    return true;
  }

  public static boolean validarStringNumerica(String... strNumerica) {
    Pattern pattern = Pattern.compile("^\\d+$");
    for (String strNum : strNumerica) {
      if (!pattern.matcher(strNum).matches() || strNum.isEmpty()) {
        return false;
      }
    }
    return true;
  }

  public static boolean validarInteirosPositivos(Integer... numeros) {
    for (int num : numeros) {
      if (num < 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean validarCPF(String cpf) {
    return (cpf.length() == 11 && cpf.matches("^\\d{11}$"));
  }

  public static boolean validarDatas(String... data) {
    for (String d : data) {
      if (!validarFormatoData(d)) {
        return false;
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      try {
        LocalDate.parse(d, formatter);
      } catch (DateTimeParseException e) {
        return false;
      }
    }
    return true;
  }

  private static boolean validarFormatoData(String data) {
    Pattern pattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
    return pattern.matcher(data).matches();
  }
}
