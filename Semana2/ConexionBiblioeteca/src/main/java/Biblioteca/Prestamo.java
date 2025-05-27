package Biblioteca;

import java.time.LocalDate;

public class Prestamo {
    private long id;
    private Libro libro;
    private Usuario usuario;
    private int fechaPrestamo;
    private int fechaDevolucion;

    public Prestamo(long id, Libro libro, Usuario usuario, int fechaPrestamo, int fechaDevolucion) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public long getId() { return id; }
    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
    public int getFechaPrestamo() { return fechaPrestamo; }
    public int getFechaDevolucion() { return fechaDevolucion; }

    public void setId(long id) { this.id = id; }
    public void setLibro(Libro libro) { this.libro = libro; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setFechaPrestamo(int fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    public void setFechaDevolucion(int fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", libro=" + libro +
                ", usuario=" + usuario +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
