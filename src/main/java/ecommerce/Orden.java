package ecommerce;

import java.time.LocalDate;
import java.util.List;

public class Orden {

    private String codigoOrden;
    private String clienteId;
    private List<ItemOrden> items;
    private LocalDate fecha;
    private double total;

    public Orden(String codigoOrden, String clienteId, List<ItemOrden> items, LocalDate fecha, double total) {
        this.codigoOrden = codigoOrden;
        this.clienteId = clienteId;
        this.items = items;
        this.fecha = fecha;
        this.total = total;
    }

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemOrden> getItems() {
        return items;
    }

    public void setItems(List<ItemOrden> items) {
        this.items = items;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
