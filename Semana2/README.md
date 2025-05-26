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
<img src="https://github.com/user-attachments/assets/9afe2a50-ef23-4218-9579-ff863b8dcdd1" width="400" height="400" />

