package ecommerce;

import java.util.*;

public class OrdenService {
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    private int contadorOrdenes = 1;

    public OrdenService(ClienteRepository clienteRepository, ProductoRepository productoRepository) {
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    public ResultadoOrden registrarOrden(OrdenRequest request) {
        // Validar cliente
        Optional<Cliente> clienteOpt = clienteRepository.findById(request.getClienteId());
        if (clienteOpt.isEmpty()) {
            return new ResultadoOrden(false, "Cliente no existe");
        }

        Cliente cliente = clienteOpt.get();
        if (!cliente.isActivo()) {
            return new ResultadoOrden(false, "Cliente no está activo");
        }

        // Validar productos duplicados
        Set<String> productosSet = new HashSet<>();
        for (ItemRequest item : request.getItems()) {
            if (productosSet.contains(item.getCodigoProducto())) {
                return new ResultadoOrden(false, "No se permiten productos duplicados");
            }
            productosSet.add(item.getCodigoProducto());

            if (item.getCantidad() <= 0) {
                return new ResultadoOrden(false, "Cantidad debe ser mayor a 0");
            }
        }

        // Validar stock y calcular total
        double total = 0;
        Map<String, Integer> stocksAActualizar = new HashMap<>();

        for (ItemRequest item : request.getItems()) {
            Optional<Producto> productoOpt = productoRepository.findByCodigo(item.getCodigoProducto());
            if (productoOpt.isEmpty()) {
                return new ResultadoOrden(false, "Producto no existe: " + item.getCodigoProducto());
            }

            Producto producto = productoOpt.get();
            if (producto.getStock() < item.getCantidad()) {
                return new ResultadoOrden(false, "Stock insuficiente para: " + producto.getNombre());
            }

            total += producto.getPrecio() * item.getCantidad();
            stocksAActualizar.put(item.getCodigoProducto(), producto.getStock() - item.getCantidad());
        }

        // Aplicar descuento si total > 500
        double descuento = 0;
        if (total > 500) {
            descuento = total * 0.10;
            total = total - descuento;
        }

        // Actualizar stocks
        for (Map.Entry<String, Integer> entry : stocksAActualizar.entrySet()) {
            productoRepository.updateStock(entry.getKey(), entry.getValue());
        }

        // Crear resultado exitoso
        ResultadoOrden resultado = new ResultadoOrden(true, "Orden registrada exitosamente");
        resultado.setCodigoOrden(String.format("OR-%04d", contadorOrdenes++));
        resultado.setTotal(total);
        resultado.setDescuentoAplicado(descuento);

        return resultado;
    }

}
