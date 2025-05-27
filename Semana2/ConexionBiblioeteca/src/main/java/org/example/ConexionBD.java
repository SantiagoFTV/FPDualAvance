package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/?useSSL=false";
        String user = "root";
        String password = ""; // Cambia esto si tu usuario tiene clave

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("🔌 Conexión establecida con el servidor MySQL.");

            // Crear base de datos
            stmt.executeUpdate("DROP DATABASE IF EXISTS Biblioteca;");
            stmt.executeUpdate("CREATE DATABASE Biblioteca;");
            stmt.executeUpdate("USE Biblioteca;");
            System.out.println("✅ Base de datos 'Biblioteca' creada.");

            // Crear tablas
            String crearTablas = """
                CREATE TABLE Libros (
                    IdLibro INT NOT NULL,
                    Titulo VARCHAR(50) NOT NULL,
                    ISBN INT NOT NULL,
                    Categoria VARCHAR(50) NOT NULL,
                    PRIMARY KEY (IdLibro)
                );

                CREATE TABLE Autores (
                    IdAutor INT NOT NULL,
                    Nombre VARCHAR(50) NOT NULL,
                    Nacionalidad VARCHAR(50) NOT NULL,
                    PRIMARY KEY (IdAutor)
                );

                CREATE TABLE LibroAutor (
                    IdLibro INT NOT NULL,
                    IdAutor INT NOT NULL,
                    PRIMARY KEY (IdLibro, IdAutor),
                    FOREIGN KEY (IdLibro) REFERENCES Libros(IdLibro),
                    FOREIGN KEY (IdAutor) REFERENCES Autores(IdAutor)
                );

                CREATE TABLE Clientes (
                    IdCliente INT NOT NULL,
                    Nombre VARCHAR(50) NOT NULL,
                    DNI INT NOT NULL,
                    PRIMARY KEY (IdCliente)
                );

                CREATE TABLE Prestamos (
                    IdPrestamo INT NOT NULL,
                    IdCliente INT NOT NULL,
                    Fecha DATE NOT NULL,
                    PRIMARY KEY (IdPrestamo),
                    FOREIGN KEY (IdCliente) REFERENCES Clientes(IdCliente)
                );

                CREATE TABLE PrestamoLibro (
                    IdPrestamo INT NOT NULL,
                    IdLibro INT NOT NULL,
                    PRIMARY KEY (IdPrestamo, IdLibro),
                    FOREIGN KEY (IdPrestamo) REFERENCES Prestamos(IdPrestamo),
                    FOREIGN KEY (IdLibro) REFERENCES Libros(IdLibro)
                );
            """;
            stmt.executeUpdate(crearTablas);
            System.out.println("📦 Tablas creadas correctamente.");

            // Insertar datos
            String insertarDatos = """
                INSERT INTO Libros (IdLibro, Titulo, ISBN, Categoria) VALUES
                (1, 'Cien Años de Soledad', 123456789, 'Novela'),
                (2, 'Don Quijote de la Mancha', 234567890, 'Clásico'),
                (3, 'La Sombra del Viento', 345678901, 'Misterio'),
                (4, 'El Principito', 456789012, 'Ficción'),
                (5, 'Rayuela', 567890123, 'Literatura');

                INSERT INTO Autores (IdAutor, Nombre, Nacionalidad) VALUES
                (1, 'Gabriel García Márquez', 'Colombiana'),
                (2, 'Miguel de Cervantes', 'Española'),
                (3, 'Julio Cortázar', 'Argentina');

                INSERT INTO LibroAutor (IdLibro, IdAutor) VALUES
                (1, 1),
                (2, 2),
                (3, 1),
                (4, 1),
                (5, 3);

                INSERT INTO Clientes (IdCliente, Nombre, DNI) VALUES
                (1, 'Ana Pérez', 12345678),
                (2, 'Luis Gómez', 87654321);

                INSERT INTO Prestamos (IdPrestamo, IdCliente, Fecha) VALUES
                (1, 1, '2025-05-01'),
                (2, 2, '2025-05-02'),
                (3, 1, '2025-05-10'),
                (4, 2, '2025-05-15');

                INSERT INTO PrestamoLibro (IdPrestamo, IdLibro) VALUES
                (1, 1),
                (1, 2),
                (2, 3),
                (3, 5),
                (4, 4);
            """;
            stmt.executeUpdate(insertarDatos);
            System.out.println(" Datos insertados correctamente.");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

