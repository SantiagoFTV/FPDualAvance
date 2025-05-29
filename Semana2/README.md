# PLAN DE FORMACIÓN INTERNO - FP DUAL
# Semana 2: Desarrollo de bases de datos y POO
## Ejercicios Prácticos:

### Ejercicio 2.1: Modelo Relacional
#### Objetivo: 
Enunciado: Una biblioteca necesita gestionar libros, autores y préstamos. Los 
libros tienen título, ISBN y categoría. Los autores tienen nombre y nacionalidad. 
Un libro puede tener varios autores. Los préstamos registran qué libro se presta 
a qué usuario y en qué fecha
##### Tareas:
	+ Diagrama E-R y tablas resultantes normalizada

## Resolución
#### 1. Creación del modelo E-R en MySql Workbench
<img src="https://github.com/user-attachments/assets/96afd0d3-2ee1-49af-8321-fc021666e0a2" width="800" height="500" />

### Ejercicio 2.2: Creación de base de datos
#### Objetivo: Implementar el modelo anterior en MyS
##### Tareas:
	+ Crear las tablas y relaciones.
 	+ Insertar 5 libros, 3 autores y 4 préstamos.
	+ Probar consultas con JOIN, ORDER BY y filtros.
 
## Resolución
#### 1. Creación de la Base de Datos Biblioteca
	-- Crear base de datos
	CREATE DATABASE Biblioteca;
	USE Biblioteca;
	
	-- Tabla de libros
	CREATE TABLE Libros (
	    IdLibro INT NOT NULL,
	    Titulo VARCHAR(50) NOT NULL,
	    ISBN INT NOT NULL,
	    Categoria VARCHAR(50) NOT NULL,
	    PRIMARY KEY (IdLibro)
	);
	
	-- Tabla de autores
	CREATE TABLE Autores (
	    IdAutor INT NOT NULL,
	    Nombre VARCHAR(50) NOT NULL,
	    Nacionalidad VARCHAR(50) NOT NULL,
	    PRIMARY KEY (IdAutor)
	);
	
	-- Tabla intermedia para relación muchos-a-muchos entre autores y libros
	CREATE TABLE LibroAutor (
	    IdLibro INT NOT NULL,
	    IdAutor INT NOT NULL,
	    PRIMARY KEY (IdLibro, IdAutor),
	    FOREIGN KEY (IdLibro) REFERENCES Libros(IdLibro),
	    FOREIGN KEY (IdAutor) REFERENCES Autores(IdAutor)
	);
	
	-- Tabla de clientes
	CREATE TABLE Clientes (
	    IdCliente INT NOT NULL,
	    Nombre VARCHAR(50) NOT NULL,
	    DNI INT NOT NULL,
		PRIMARY KEY (IdCliente)
	);
	
	-- Tabla de préstamos
	CREATE TABLE Prestamos (
	    IdPrestamo INT NOT NULL,
	    IdCliente INT NOT NULL,
	    Fecha DATE NOT NULL,
	    FOREIGN KEY (IdCliente) REFERENCES Clientes(IdCliente),
	    PRIMARY KEY (IdPrestamo)
	);
	
	-- Tabla intermedia para relación muchos-a-muchos entre préstamos y libros
	CREATE TABLE PrestamoLibro (
	    IdPrestamo INT NOT NULL,
	    IdLibro INT NOT NULL,
	    PRIMARY KEY (IdPrestamo, IdLibro),
	    FOREIGN KEY (IdPrestamo) REFERENCES Prestamos(IdPrestamo),
	    FOREIGN KEY (IdLibro) REFERENCES Libros(IdLibro)
	);
<img src="https://github.com/user-attachments/assets/9afe2a50-ef23-4218-9579-ff863b8dcdd1" width="400" height="300" />

#### 2. Insertar libros autores y prestamos.

	use biblioteca;
	
	-- Insertar libros
	INSERT INTO Libros (IdLibro, Titulo, ISBN, Categoria) VALUES
	(1, 'Cien Años de Soledad', 123456789, 'Novela'),
	(2, 'Don Quijote de la Mancha', 234567890, 'Clásico'),
	(3, 'La Sombra del Viento', 345678901, 'Misterio'),
	(4, 'El Principito', 456789012, 'Ficción'),
	(5, 'Rayuela', 567890123, 'Literatura');
	
	-- Insertar autores
	INSERT INTO Autores (IdAutor, Nombre, Nacionalidad) VALUES
	(1, 'Gabriel García Márquez', 'Colombiana'),
	(2, 'Miguel de Cervantes', 'Española'),
	(3, 'Julio Cortázar', 'Argentina');
	
	-- Insertar relación libro-autor
	INSERT INTO LibroAutor (IdLibro, IdAutor) VALUES
	(1, 1), -- Cien Años de Soledad - Gabriel García Márquez
	(2, 2), -- Don Quijote de la Mancha - Miguel de Cervantes
	(3, 1), -- La Sombra del Viento (ficticio) - Gabriel García Márquez
	(4, 1), -- El Principito (ficticio) - Gabriel García Márquez
	(5, 3); -- Rayuela - Julio Cortázar
	
	-- Insertar clientes
	INSERT INTO Clientes (IdCliente, Nombre, DNI) VALUES
	(1, 'Ana Pérez', 12345678),
	(2, 'Luis Gómez', 87654321);
	
	-- Insertar préstamos
	INSERT INTO Prestamos (IdPrestamo, IdCliente, Fecha) VALUES
	(1, 1, '2025-05-01'),
	(2, 2, '2025-05-02'),
	(3, 1, '2025-05-10'),
	(4, 2, '2025-05-15');
	
	-- Relación préstamos-libros
	INSERT INTO PrestamoLibro (IdPrestamo, IdLibro) VALUES
	(1, 1), -- Ana Pérez pidió "Cien Años de Soledad"
	(1, 2), -- Ana Pérez también pidió "Don Quijote"
	(2, 3), -- Luis Gómez pidió "La Sombra del Viento"
	(3, 5), -- Ana Pérez pidió "Rayuela"
	(4, 4); -- Luis Gómez pidió "El Principito"

#### 3. Probar consultas con JOIN, ORDER BY y filtros
#### a. Listar los libros prestados con el nombre del cliente y la fecha del préstamo
<img src="https://github.com/user-attachments/assets/5f623589-ed72-4341-ab8e-b8c86ed0a326" width="500" height="400" />
 
#### b. Cantidad de libros prestados por cada cliente
<img src="https://github.com/user-attachments/assets/1dca72f3-66d9-4aa7-9dae-638f44045262" width="500" height="400" />

#### c. Categoría 'Novela' que han sido prestados
<img src="https://github.com/user-attachments/assets/44a5d92e-5e8e-4831-b24f-ad47bc758b0e" width="500" height="400" />

### Ejercicio 2.3: Aplicación Java con conexión a BD
#### Objetivo: Crear una app Java que permita consultar y registrar préstamos.
##### Tareas:

	+ Usar JDBC para conectar con la BD.
 	+ Crear clases Libro, Usuario y Prestam
  	+ Validar entradas, capturar excepciones y mostrar mensajes de error claros
   
## Resolución
#### 1. Programa en Java
##### Clase Libro
<details>

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

</details>
##### Clase Usuario
<details>

	public class Usuario {
    	private long id;
    	private String nombreUsuario;
    	private String email;

    public Usuario(long id, String nombreUsuario, String email) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
    }

    public long getId() { return id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getEmail() { return email; }

    public void setId(long id) { this.id = id; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", email='" + email + '\'' +
                '}';
    		}
	}


</details>

##### Clase Prestamo
<details>


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


</details>

##### Clase Biblioteca
<details>

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


</details>

##### Clase PrestamoLibros
<details>

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
	

</details>


##### Properties
<details>
	
	USE biblioteca;
	
	
	CREATE TABLE usuarios (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre_usuario VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL
	);
	
	
	CREATE TABLE libros (
	id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
	autor VARCHAR(60) NOT NULL
	);
	
	
	CREATE TABLE prestamos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	libro_id INT NOT NULL,
	usuario_id INT NOT NULL,
	fecha_prestamo DATE NOT NULL,
	fecha_devolucion DATE,
	FOREIGN KEY (libro_id) REFERENCES libros(id),
	FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
	);
	
	
	SHOW TABLES;
	
	
	DESCRIBE libros;
	DESCRIBE usuarios;
	DESCRIBE prestamos;
	
	
	INSERT INTO usuarios(nombre_usuario, email) VALUES
	("juan123", "juan@example.com"),
	("ana456", "ana@example.com"),
	("luis789", "luis@example.com");
	
	
	INSERT INTO libros(titulo, autor) VALUES
	("Cien Años de Soledad", "Gabriel García Márquez"),
	("1984", "George Orwell"),
	("El Principito", "Antoine de Saint-Exupéry"),
	("Fahrenheit 451", "Ray Bradbury");
	
	
	-- Suponiendo que los IDs generados empiezan en 1
	INSERT INTO prestamos(libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES
	(1, 1, '2025-05-01', '2025-05-20'),
	(2, 2, '2025-05-10', NULL),
	(3, 3, '2025-05-15', NULL);
	
	
	SELECT p.id AS prestamo_id, l.titulo, u.nombre_usuario, p.fecha_prestamo, p.fecha_devolucion
	FROM prestamos p
	JOIN libros l ON p.libro_id = l.id
	JOIN usuarios u ON p.usuario_id = u.id;

</details>


