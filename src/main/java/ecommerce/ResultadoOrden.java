package ecommerce;

public class ResultadoOrden {
    private boolean exitoso;
    private String mensaje;
    private String codigoOrden;
    private double total;
    private double descuentoAplicado;

    public ResultadoOrden(boolean exitoso, String mensaje) {
        this.exitoso = exitoso;
        this.mensaje = mensaje;
    }

    public boolean isExitoso() { return exitoso; }
    public String getMensaje() { return mensaje; }
    public String getCodigoOrden() { return codigoOrden; }
    public void setCodigoOrden(String codigoOrden) { this.codigoOrden = codigoOrden; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public double getDescuentoAplicado() { return descuentoAplicado; }
    public void setDescuentoAplicado(double descuentoAplicado) { this.descuentoAplicado = descuentoAplicado; }

}
