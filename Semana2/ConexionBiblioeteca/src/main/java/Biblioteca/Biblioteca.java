package Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Biblioteca extends PrestamoLibros {

    public record Libro(long id, String titulo, String autor, String usuario) {}

    public static void main(String[] args) {
        List<Libro> libros = new ArrayList<>();

        String sql = "SELECT * FROM libros WHERE autor LIKE ?";
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce parte del nombre del autor: ");
        String autorFiltro = sc.nextLine();

        Properties prop = getProperties("biblioteca.properties");
        try (
                Connection conn = getConnection(prop);
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, "%" + autorFiltro + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong(ID);
                String titulo = rs.getString(TITULO);
                String autor = rs.getString(AUTOR);
                String usuario = rs.getString(USUARIO);
                libros.add(new Libro(id, titulo, autor, usuario));
            }
        } catch (Exception e) {
            System.out.println("Error obteniendo libros: " + e.getMessage());
        }

        libros.forEach(System.out::println);
    }
}
