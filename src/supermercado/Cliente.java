package supermercado;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String nombre;
    List<Producto> carrito;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.carrito = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        carrito.add(producto);
    }
}

