package org.example;

public class Usuario {
    private int id;
    private String nombre;
    private int dni;

    public Usuario(int id, String nombre, int dni) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException(" El nombre del usuario no puede estar vacío.");
        }
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (DNI: " + dni + ")";
    }
}
