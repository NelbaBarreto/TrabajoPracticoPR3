package models;

/**
 *
 * @author Nelba Barreto
 */
public class FacturaProvDet {
    private int item;
    private int nroFacturaProv;
    private int codigoProducto;
    private double cantidad;
    private double importe;

    public FacturaProvDet(int item, int nroFacturaProv, int codigoProducto, double cantidad, double importe) {
        this.item = item;
        this.nroFacturaProv = nroFacturaProv;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.importe = importe;
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

    public double getCantidad() {
        return cantidad;
    }

    public double getImporte() {
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

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
