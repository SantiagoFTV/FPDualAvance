import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioServicioTest {

    @Test
    public void testStockBajo() {
        InventarioServicio servicio = new InventarioServicio(new ProductoDAOMemoria());
        servicio.registrarProducto(new Producto("Leche", 2, 1.50, "Lácteos"));

        assertEquals(1, servicio.stockBajo(5).size());
    }
}
