import java.util.*;

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
