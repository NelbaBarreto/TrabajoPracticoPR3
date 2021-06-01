package models;

/**
 *
 * @author Nelba Barreto
 */
public class Empresa {
    private int id;
    private String descripcion;

    public Empresa(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Integer id_empresa) {
        this.id = id_empresa;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
