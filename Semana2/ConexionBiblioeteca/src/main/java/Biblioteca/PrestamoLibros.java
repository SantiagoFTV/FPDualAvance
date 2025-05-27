package Biblioteca;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public abstract class PrestamoLibros {
    public static final String ID = "id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String USUARIO = "usuario";

    public static Properties getProperties(String filename) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(filename)) {
            props.load(fis);
        } catch (Exception e) {
            System.out.println("Error leyendo config: " + e.getMessage());
        }
        return props;
    }

    public static Connection getConnection(Properties props) throws Exception {
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        return DriverManager.getConnection(url, user, password);
    }
}
