/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author HP
 */
public class RecepcionDet {

    private int item;
    private int codigoProducto;
    private int cantidad;
    private int nroRecepcion;

    public int getNroRecepcion() {
        return nroRecepcion;
    }

    public void setNroRecepcion(int nroRecepcion) {
        this.nroRecepcion = nroRecepcion;
    }
    private String descripcion;

    public RecepcionDet(int item, int codigoProducto, int cantidad, String descripcion,
            int nroRecepcion) {
        this.item = item;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.nroRecepcion = nroRecepcion;
    }

    public int getItem() {
        return item;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setItem(int item) {
        this.item = item;
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

}
