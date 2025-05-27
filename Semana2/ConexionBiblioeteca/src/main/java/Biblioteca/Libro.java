package Biblioteca;

public class Libro {
    private long id;
    private String titulo;
    private String autor;
    private String usuario;

    public Libro(long id, String titulo, String autor, String usuario) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.usuario = usuario;
    }

    public long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getUsuario() { return usuario; }

    public void setId(long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
