package ecommerce;

import java.util.List;

public class OrdenRequest {

    private String clienteId;
    private List<ItemRequest> items;


    public OrdenRequest() {
    }

    public OrdenRequest(String clienteId, List<ItemRequest> items) {
        this.clienteId = clienteId;
        this.items = items;
    }


    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }
}
