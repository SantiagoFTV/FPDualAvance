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
 <img src="https://github.com/user-attachments/assets/5f623589-ed72-4341-ab8e-b8c86ed0a326" width="800" height="300" />
#### b. Cantidad de libros prestados por cada cliente
 <img src="https://github.com/user-attachments/assets/1dca72f3-66d9-4aa7-9dae-638f44045262" width="800" height="300" />




