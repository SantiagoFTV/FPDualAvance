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
