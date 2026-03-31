package ecommerce;

import java.util.Optional;

public interface ProductoRepository {
    Optional<Producto> findByCodigo(String codigo);
    void updateStock(String codigo, int nuevoStock);
}
