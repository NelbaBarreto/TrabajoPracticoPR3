package models;

/**
 *
 * @author Nelba Barreto
 */
public class FacturaProvDet {
    private int item;
    private int nroFacturaProv;
    private int codigoProducto;
    private int cantidad;
    private int importe;
    private String descripcion;

    public FacturaProvDet(int item, int nroFacturaProv, int codigoProducto, int cantidad, int importe, String descripcion) {
        this.item = item;
        this.nroFacturaProv = nroFacturaProv;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.importe = importe;
        this.descripcion = descripcion;
    }

    public int getItem() {
        return item;
    }

    public int getNroFacturaProv() {
        return nroFacturaProv;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getImporte() {
        return importe;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setNroFacturaProv(int nroFacturaProv) {
        this.nroFacturaProv = nroFacturaProv;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }
}
