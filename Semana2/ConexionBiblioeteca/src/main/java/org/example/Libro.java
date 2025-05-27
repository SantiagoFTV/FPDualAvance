package org.example;

public class Libro {
    private int id;
    private String titulo;
    private int isbn;
    private String categoria;

    public Libro(int id, String titulo, int isbn, String categoria) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException(" El título no puede estar vacío.");
        }
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id + " - " + titulo + " (" + categoria + ")";
    }

    // Getters y setters opcionales
}
