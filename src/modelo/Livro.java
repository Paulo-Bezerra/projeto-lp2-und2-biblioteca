package modelo;

public class Livro {
    private String titulo;
    private String autor;
    private String assunto;
    private int ano;
    private int estoque;

    public Livro(String titulo, String autor, String assunto, int ano, int estoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.assunto = assunto;
        this.ano = ano;
        this.estoque = estoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
