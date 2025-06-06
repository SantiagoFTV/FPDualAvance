# PLAN DE FORMACIÓN INTERNO - FP DUAL
# Semana 1: Fundamentos técnicos y herramientas profesionales
## Ejercicios Prácticos:
### Ejercicio 1.1: Instalación y configuración de sistemas operativos
#### Objetivo: Instalar una distribución de Linux sin GUI (interfaz gráfica) en entornos virtualizados (VirtualBox)
##### Tareas:
	+ Asignar recursos adecuada.
	+ Crear usuarios.
	+ Configurar carpetas compartidas y acceso remoto

## Resolución
#### 1. Descargar VirtualBox y Un Sistema Operativo Linux (Ubuntu)
<img src="https://github.com/user-attachments/assets/a5879ea8-bd11-49e3-b1f1-5811e37ffe05" width="800" height="500" />

#### 2. Instalar VirtualBox y agregar una nueva máquina con el sistema Linux
<img src="https://github.com/user-attachments/assets/7ffa5911-391f-4ee9-9d12-a4b3b41bebc3" width="800" height="500" />

#### 3. Asignar nombre de usuario y contraseña
<img src="https://github.com/user-attachments/assets/4f456ef5-1769-4700-95cd-a1b0d400c10f" width="800" height="500" />

#### 4. Asignar los recursos adecuados para un buen rendimiento de la máquina
<img src="https://github.com/user-attachments/assets/be4be58c-3038-4220-960b-8b2d146e48e1" width="800" height="500" />
<img src="https://github.com/user-attachments/assets/b7856464-58f4-49e1-abc8-d9b739870809" width="800" height="500" />

#### 5. Ejecutar máquina virtual e instalar el Sistema operativo
<img src="https://github.com/user-attachments/assets/fc0153e5-31d3-40b4-b133-e22fb12ad7c6" width="800" height="500" />

#### 6. Abrir terminal para empezar a ejecutar comando
##### Utilizamos el comando sudo adduser para crear un nuevo usuario
	+ Sudo nos permite acceder como root
 <img src="https://github.com/user-attachments/assets/6de18549-105b-4c49-a207-290dbde7a514" width="800" height="400" />
 <img src="https://github.com/user-attachments/assets/b26eb0a8-d690-41a0-bc8a-3353fededafb" width="400" height="300" />

#### 7. Configuración de carpetas compartidas y acceso remoto
	+ Dentro de la máquina virtual en el apartado de dispositivos accedemos a carpetas compartidas.
 	+ Seleccionamos la carpeta o pegamos directamente la ruta de acceso a esta carpeta dentro de nuestro escritorio principal.
  	+ Dentro de la máquina virtual colocamos la ruta de la carpeta con la cual se va a comunicar el sistema princiapl.

<img src="https://github.com/user-attachments/assets/458311c9-447e-43df-957a-8dae9141b4b6" width="600" height="400" />

 

### Ejercicio 1.2: Gestión del sistema de archivos
#### Objetivo: Trabajar con permisos, carpetas, enlaces simbólicos y estructuras jerárquicas en Linux
##### Tareas:
	+ Crear un árbol de directorios que simule departamentos de una empresa.
 	+ Asignar permisos personalizados a grupos y usuario.
### Resolución
#### 1. Crear un árbol de directorios
	+ Comando mkdir nos permite crear directorios dentro del sistema.
 	+ Creamos carpetas dentro de otras.
  	+ Con el comando tree podremos visualizar todas las carpetas como si fuera un árbol.
<img src="https://github.com/user-attachments/assets/daabc040-b08e-4a50-aed4-c0c6d75164a6" width="800" height="500" />

#### 2. Asignar permisos personalizados
	+ Comando chmod para cambiar los permisos de escritura, lectura y visualización.
 	+ Comando chown para cambiar propietario.
  	+ Comando chgrp para cambiar de grupo.
 	+ Comando groupadd para crear un nuevo grupo.
  	+ Comando sudo usermod -aG nombreDelGrupo NombreDelUsuario para agregar un usuario al grupo.
<img src="https://github.com/user-attachments/assets/0a16cb91-e790-4218-ada3-f2d1f0caad9c" width="800" height="100" />
<img src="https://github.com/user-attachments/assets/fe31b0a9-a9e8-4010-8d4a-6583b2388f7c" width="800" height="100" />

### Ejercicio 1.3: Iniciación en Git
#### Objetivo: Usar Git como herramienta de control de versiones.
##### Tareas:
	+ Inicializar un repositorio local y enlazarlo con GitHub.
	+ Realizar commits con mensajes claros.
	+ Crear ramas, fusionarlas y resolver conflictos simples Asignar recursos adecuados.
### Resolución
#### 1. Iniciar un repositoro Git
	+ Debemos crear un repositorio dentro de Github.
	+ Debemos descargar e instalar Git, el cual nos incluye Gitbash y GitGui.
 	+ Dentro de GitGui debemos crear nuestra llave SSH para poder enlazar Git con nuestro repositorio en Github.
	+ Luego nos pedira el enlace SSH que se encuetra en nuestro repositorio con el comando "git add remote origin 'enlace' ".
	+ Luego con el comando "git config --global email@email.com" y "git config --global username" para enlazar nuestro correo y nombrar el repositorio.
	+ Crearemos una carpeta en nuestro ordenador y accedemos desde gitBash y utilizamos el comnado init para 
   	  inicializarlo como nuestro repositorio.
	+ Esta carpeta incluira un archivo .git.
    
<img src="https://github.com/user-attachments/assets/7d6e5922-28f6-4947-ac04-ec99e534b8b8" width="600" height="300" />

#### 2. Realizar un commit correctamente
	+ Con el comando "git status" verificamos cuales han sido los cambios dentro del repositorio.
<img src="https://github.com/user-attachments/assets/7904f61e-bf2a-4f88-b81e-681dcb182089" width="600" height="300" />
 
	+ Antes de realizar un commit debemos añadir lo que hayamos creado en el repositorio con "git add".
	+ Realizamos el commit con "git commit -m "message".
	+ Finalmente realizamos un "git push" para subir el contenido al repositorio en github.

<img src="https://github.com/user-attachments/assets/0a6a0b32-9d25-4fea-a70f-ee9dcce39482" width="600" height="400" />

#### 3. Crear ramas, fusionarlas y resolución de conflictos simples.
	+ Comando "git branch nombreRama".
 	+ Comando "git checkout nombreRama" para ingresar a la rama.
  	+ Comando "git merge nombreRama" desde el main para fusionarlo.
  <img src="https://github.com/user-attachments/assets/358b4d31-a01d-4c51-89a8-d915e0ed7a6f" width="600" height="100" />
  <img src="https://github.com/user-attachments/assets/f1cbc275-546e-42de-8763-2c4ff856619d" width="600" height="100" />
  <img src="https://github.com/user-attachments/assets/bc404fba-d715-4d48-9929-321aab2c0363" width="600" height="300" />


	+ Con el comando vim podemos modificar un archivo 
<img src="https://github.com/user-attachments/assets/13a05a3f-d9d7-4ccf-be0c-64bb13563b11" width="600" height="400" />

	+ Una solución rápida para el repositorio es hacer un "git clone 'git@github.com:SantiagoFTV/FPDualAvance.git' " 
 	  el cual nos permite clonar el repositorio tal como está a nuestro ordenador desde el último push a GitHub.
<img src="https://github.com/user-attachments/assets/4ae43f8a-2dc1-48d7-b5a2-a6a561a945c0" width="700" height="300" />

### Ejercicio 1.4: Primera base de datos
#### Objetivo: Crear una BBDD sencilla con MySQL y realizar consultas básicas.
##### Tareas:
	+ Crear tablas "clientes" y "productos".
	+ Insertar registros simulados.
 	+ Ejecutar consultas SELECT, JOIN y filtros básicos Asignar recursos adecuados.
  
#### 1. Crear tablas en mysql workbench
<img src="https://github.com/user-attachments/assets/3fe8071a-05ba-4f9a-997e-0befab90d2d6" width="600" height="400" />

#### 2. Insertas registro
<img src="https://github.com/user-attachments/assets/c9794c78-247c-4a76-a29b-ae3f2da127f5" width="600" height="200" />

#### 3. Consultas con Select y Join
	+ Con el comando SELECT podemos seleccionar los datos que queremos mostrar de una tabla dentro de la BBDD.
<img src="https://github.com/user-attachments/assets/fbcdd19d-cd89-458c-9cda-b3e5a5c83ba7" width="600" height="200" />

 	+ Con el comando NATURAL JOIN podemos fusionar las tablas en una sola con todos los datos.
<img src="https://github.com/user-attachments/assets/de793443-d1f3-4ea4-a7bf-88c95704165e" width="600" height="200" />


    

   
   

 
