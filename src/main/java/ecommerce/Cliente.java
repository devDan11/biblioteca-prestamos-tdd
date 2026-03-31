package ecommerce;

import java.time.LocalDate;

public class Cliente {

    private String id;
    private String nombre;
    private boolean activo;

    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.activo = true;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}
