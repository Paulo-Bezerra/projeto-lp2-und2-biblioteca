import controlador.Controlador;
import dto.LivroDTO;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Controlador controlador = new Controlador();
    LivroDTO livroDTO = new LivroDTO("Bom", "eu", "1","paz", 2024, 1, 1);
    System.out.println(controlador.adicionarLivro(livroDTO));
    livroDTO = new LivroDTO("Mau", "tu", "2", "guerra", 2024, 9, 9);
    System.out.println(controlador.adicionarLivro(livroDTO));
    System.out.println("[");
    for (LivroDTO livro : controlador.buscarLivroPorAutor("eu")) {
      System.out.println("  " + livro + ",");
    }
    System.out.println("]");
    System.out.println("[");
    for (LivroDTO livro : controlador.listarLivros()) {
      System.out.println("  " + livro + ",");
    }
    System.out.println("]");
  }
}