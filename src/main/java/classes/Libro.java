package classes;

public class Libro {

  private String titulo;
  private int paginas;
  private String autor;
  private String isbn;
  private String categoria;

  public Libro(int paginas, String autor, String isbn, String categoria) {
    this.paginas = paginas;
    this.autor = autor;
    this.isbn = isbn;
    this.categoria = categoria;
  }

  public Libro(){

  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getPaginas() {
    return paginas;
  }

  public void setPaginas(int paginas) {
    this.paginas = paginas;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return "Libro{" +
        "paginas=" + paginas +
        ", autor='" + autor + '\'' +
        ", isbn='" + isbn + '\'' +
        ", categoria='" + categoria + '\'' +
        '}';
  }
}
