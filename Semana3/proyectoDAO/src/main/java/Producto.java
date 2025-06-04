
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
