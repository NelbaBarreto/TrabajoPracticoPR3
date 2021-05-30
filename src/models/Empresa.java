package models;

/**
 *
 * @author Nelba Barreto
 */
public class Empresa {
    private int id_empresa;
    private String descripcion;

    public Empresa(int id_empresa, String descripcion) {
        this.id_empresa = id_empresa;
        this.descripcion = descripcion;
    }
    
    public Integer getId_empresa() {
        return id_empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
