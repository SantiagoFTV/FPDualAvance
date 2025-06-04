import java.util.List;

public interface ProductoDAO {
    void guardar(Producto producto);
    List<Producto> obtenerTodos();
}
