import java.util.*;

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
