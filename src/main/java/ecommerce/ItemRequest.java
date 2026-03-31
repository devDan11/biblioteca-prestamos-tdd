package ecommerce;

public class ItemRequest {

    private String codigoProducto;
    private int cantidad;

    public ItemRequest(String codigoProducto, int cantidad) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public String getCodigoProducto() { return codigoProducto; }
    public int getCantidad() { return cantidad; }
}
