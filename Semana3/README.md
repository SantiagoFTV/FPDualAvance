# PLAN DE FORMACIÓN INTERNO - FP DUAL
# Semana 3: Proyecto integrador y competencias
## Ejercicios Prácticos:

### Ejercicio 3.1: Proyectos Integradores
#### 
Debes elegir uno de los siguientes proyectos y realizar un desarrollo mediante TDD. Para
ello deberás realizar un desarrollo rápido independiente de elementos para
posteriormente rafactorizar el código añadiendo un DAO que permita a la empresa
realizar cambios y optimizaciones.
##### Tareas:
    Objetivo: Gestionar productos e inventario de una pequeña tienda.
    Requisitos:
    ✔ Registro de productos (nombre, stock, precio, categoría).
    ✔ Consulta de inventario y control de stock bajo.
    ✔ Exportación a un fichero JSON

## Resolución
#### Clase Producto
<details>
    
    public class Producto {
        String nombre;
        int stock;
        double precio;
        String categoria;
    
        public Producto(String nombre, int stock, double precio, String categoria) {
            this.nombre = nombre;
            this.stock = stock;
            this.precio = precio;
            this.categoria = categoria;
        }
    
        public String getNombre() { return nombre; }
        public int getStock() { return stock; }
        public double getPrecio() { return precio; }
        public String getCategoria() { return categoria; }
    }
</details>

##### Clase Inventario

<details>
    
    public class Inventario {
        private ProductoDAO dao;
    
        public Inventario(ProductoDAO dao) {
            this.dao = dao;
        }
    
        public void registrarProducto(Producto producto) {
            dao.guardar(producto);
        }
    
        public List<Producto> obtenerTodos() {
            return dao.obtenerTodos();
        }
    
        public List<Producto> stockBajo(int umbral) {
            List<Producto> bajos = new ArrayList<>();
            for (Producto p : dao.obtenerTodos()) {
                if (p.getStock() < umbral) {
                    bajos.add(p);
                }
            }
            return bajos;
        }
    }

</details>

##### ProductoDAO

<details>
    
    import java.util.List;
    
    public interface ProductoDAO {
        void guardar(Producto producto);
        List<Producto> obtenerTodos();
    }
    

</details>

##### ProductoDAOMemoria


<details>

    public class ProductoDAOMemoria implements ProductoDAO {
        private List<Producto> productos = new ArrayList<>();
    
        @Override
        public void guardar(Producto producto) {
            productos.add(producto);
        }
    
        @Override
        public List<Producto> obtenerTodos() {
            return new ArrayList<>(productos);
        }
    }

</details>

##### Main

<details>

        public class Main {
        public static void main(String[] args) {
            Inventario servicio = new Inventario(new ProductoDAOMemoria());
    
            servicio.registrarProducto(new Producto("Pan", 4, 0.50, "Alimentos"));
            servicio.registrarProducto(new Producto("Jugo", 10, 1.20, "Bebidas"));
    
            System.out.println("Stock bajo (<5):");
            for (Producto p : servicio.stockBajo(5)) {
                System.out.println(p.getNombre());
            }
        }
    }
    
</details>

##### Test

<details>

    public class InventarioServicioTest {
    
        @Test
        public void testStockBajo() {
            Inventario servicio = new Inventario(new ProductoDAOMemoria());
            servicio.registrarProducto(new Producto("Leche", 2, 1.50, "Lácteos"));
    
            assertEquals(1, servicio.stockBajo(5).size());
        }
    }


</details>
