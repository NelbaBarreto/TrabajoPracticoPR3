package db;

import java.sql.*;
        
public class bdOracle{
  private Connection conn;

  public void abrir(String usu, String pass) throws SQLException {
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.116.200:1521:xe", usu, pass);
  }
  
  public ResultSet sql(String sentencia) throws SQLException{
    Statement stmt = conn.createStatement();
    ResultSet rset = stmt.executeQuery(sentencia);
    return rset;
  }
  
  public int recuSigteNumero (String nombreTabla) throws SQLException {
    CallableStatement cs = null;
    cs = conn.prepareCall("{ ? = call FC_RECU_SIGTE_NRO(?) }");
    cs.registerOutParameter(1, Types.INTEGER);
    cs.setString(2, nombreTabla);
    cs.execute();

    return cs.getInt(1);
  }
  
  public int recuSigteNumero (String nombreTabla, int numeroCabecera) throws SQLException {
    CallableStatement cs = null; 
    cs = conn.prepareCall("{ ? = call FC_RECU_SIGTE_NRO(?, ?) }");
    cs.registerOutParameter(1, Types.INTEGER);
    cs.setString(2, nombreTabla);
    cs.setInt(3, numeroCabecera);
    cs.execute();

    return cs.getInt(1);
  }
  
  // Funciones para [EMPRESAS]
    public int fc_inse_empresa(int id, String desc) throws SQLException {
      CallableStatement cs = null;
      cs = conn.prepareCall("{ call PC_INSE_EMPRESA(?, ?, ?) }");
      cs.setInt(1, id);
      cs.setString(2, desc);
      cs.registerOutParameter(3, Types.INTEGER);
      cs.execute();

      return cs.getInt(3);
    }
      
    public int fc_actu_empresa(int id, String desc) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_EMPRESA(?, ?, ?) }");
        cs.setInt(1, id);
        cs.setString(2, desc);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();

        return cs.getInt(3);
    }
    
    public int fc_dele_empresa(int id) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_DELE_EMPRESA(?, ?) }");
        cs.setInt(1, id);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.execute();

        return cs.getInt(2);
    }
    
    // Funciones para [PERSONAS]
    public int fc_inse_persona(int cod, String nombre1, String nombre2, 
        String apellido1, String apellido2, String cedula, int cod_ciudad) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_PERSONA(?, ?, ?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, cod);
        cs.setString(2, nombre1);
        cs.setString(3, nombre2);
        cs.setString(4, apellido1);
        cs.setString(5, apellido2);
        cs.setString(6, cedula);
        cs.setInt(7, cod_ciudad);
        cs.registerOutParameter(8, Types.INTEGER);
        cs.execute();

        return cs.getInt(8);
    }
    
    public int fc_actu_persona(int cod, String nombre1, String nombre2, 
        String apellido1, String apellido2, String cedula, int cod_ciudad) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_PERSONA(?, ?, ?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, cod);
        cs.setString(2, nombre1);
        cs.setString(3, nombre2);
        cs.setString(4, apellido1);
        cs.setString(5, apellido2);
        cs.setString(6, cedula);
        cs.setInt(7, cod_ciudad);
        cs.registerOutParameter(8, Types.INTEGER);
        cs.execute();

        return cs.getInt(8);
    }
    
    public int fc_dele_persona(int cod) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_DELE_PERSONA(?, ?) }");
        cs.setInt(1, cod);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.execute();

        return cs.getInt(2);
    }
    
    // Funciones para [PRODUCTOS]
    public int fc_inse_producto(int cod, String desc) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_PRODUCTO(?, ?, ?) }");
        cs.setInt(1, cod);
        cs.setString(2, desc);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();

        return cs.getInt(3);
    }
    
    public int fc_actu_producto(int cod, String desc) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_PRODUCTO(?, ?, ?) }");
        cs.setInt(1, cod);
        cs.setString(2, desc);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();

        return cs.getInt(3);
    }
    
    public int fc_dele_producto(int cod) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_DELE_PRODUCTO(?, ?) }");
        cs.setInt(1, cod);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.execute();

        return cs.getInt(2);
    }
    
    // Funciones para [FACTURAS_PROV]
    public int fc_inse_factura_prov(int nro, String fecha, int estado, 
            int tipoFactura, int idEmpresa) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_FACTURA_PROV(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, nro);
        cs.setString(2, fecha);
        cs.setInt(3, estado);
        cs.setInt(4, tipoFactura);
        cs.setInt(5, idEmpresa);
        cs.registerOutParameter(6, Types.INTEGER);
        cs.execute();

        return cs.getInt(6);
    }
    
    public int fc_actu_factura_prov(int nro, String fecha, int estado, 
            int tipoFactura, int idEmpresa) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_FACTURA_PROV(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, nro);
        cs.setString(2, fecha);
        cs.setInt(3, estado);
        cs.setInt(4, tipoFactura);
        cs.setInt(5, idEmpresa);
        cs.registerOutParameter(6, Types.INTEGER);
        cs.execute();

        return cs.getInt(6);
    }
    
    public int fc_dele_factura_prov(int nro) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_DELE_FACTURA_PROV(?, ?) }");
        cs.setInt(1, nro);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.execute();

        return cs.getInt(2);
    }
    
    // Funciones para [FACTURAS_PROV_DET]
    public int fc_inse_factura_prov_det(int item, int cantidad, int importe, 
            int nroFacturaProv, int codProd) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_FACTURA_PROV_DET(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, item);
        cs.setInt(2, cantidad);
        cs.setInt(3, importe);
        cs.setInt(4, nroFacturaProv);
        cs.setInt(5, codProd);
        cs.registerOutParameter(6, Types.INTEGER);
        cs.execute();

        return cs.getInt(6);
    }
    
    public int fc_actu_factura_prov_det(int item, int cantidad, int importe, 
            int nroFacturaProv, int codProd) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_FACTURA_PROV_DET(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, item);
        cs.setInt(2, cantidad);
        cs.setInt(3, importe);
        cs.setInt(4, nroFacturaProv);
        cs.setInt(5, codProd);
        cs.registerOutParameter(6, Types.INTEGER);
        cs.execute();

        return cs.getInt(6);
    }
    
    public int fc_dele_factura_prov_det(int item, int nroFacturaProv) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_DELE_FACTURA_PROV_DET(?, ?, ?) }");
        cs.setInt(1, item);
        cs.setInt(2, nroFacturaProv);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();

        return cs.getInt(3);
    }
    
    // Funciones para [CIUDADES]
    public int fc_inse_ciudad(int cod, String desc) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_CIUDAD(?, ?, ?) }");
        cs.setInt(1, cod);
        cs.setString(2, desc);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();

        return cs.getInt(3);
    }
    
    public int fc_actu_ciudad(int cod, String desc) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_CIUDAD(?, ?, ?) }");
        cs.setInt(1, cod);
        cs.setString(2, desc);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();

        return cs.getInt(3);
    }
    
    public int fc_dele_ciudad(int cod) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_DELE_CIUDAD(?, ?) }");
        cs.setInt(1, cod);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.execute();

        return cs.getInt(2);
    }
    
    // Funciones para [RECEPCIONES]
    public int fc_inse_recepcion(int nro, String fecha, 
            String fechaFact, int nroFacturaProv) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_RECEPCION(?, ?, ?, ?, ?) }");
        cs.setInt(1, nro);
        cs.setString(2, fecha);
        cs.setString(3, fechaFact);
        cs.setInt(4, nroFacturaProv);
        cs.registerOutParameter(5, Types.INTEGER);
        cs.execute();

        return cs.getInt(5);
    }
    
    public int fc_actu_recepcion(int nro, int nroFacturaProv, 
            String fecha, String fechaFact) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_RECEPCION(?, ?, ?, ?, ?) }");
        cs.setInt(1, nro);
        cs.setString(2, fecha);
        cs.setString(3, fechaFact);
        cs.setInt(4, nroFacturaProv);
        cs.registerOutParameter(5, Types.INTEGER);
        cs.execute();

        return cs.getInt(5);
    }
    
    public int fc_dele_recepciones(int nro) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_DELE_RECEPCION(?, ?) }");
        cs.setInt(1, nro);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.execute();

        return cs.getInt(2);
    }
    
    // Funciones para [FACTURAS_PROV_DET]
    public int fc_inse_recepcion_det(int item, int cantidad, 
            int nroRecepcion, int codProducto) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_RECEPCION_DET(?, ?, ?, ?, ?) }");
        cs.setInt(1, item);
        cs.setInt(2, cantidad);
        cs.setInt(3, nroRecepcion);
        cs.setInt(4, codProducto);
        cs.registerOutParameter(5, Types.INTEGER);
        cs.execute();

        return cs.getInt(5);
    }
    
    public int fc_actu_recepcion_det(int item, int cantidad, 
            int nroRecepcion, int codProducto) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_RECEPCION_DET(?, ?, ?, ?, ?) }");
        cs.setInt(1, item);
        cs.setInt(2, cantidad);
        cs.setInt(3, nroRecepcion);
        cs.setInt(4, codProducto);
        cs.registerOutParameter(5, Types.INTEGER);
        cs.execute();

        return cs.getInt(5);
    }
    
    public int fc_dele_recepcion_det(int item, int nroRecepcion) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_DELE_FACTURA_PROV_DET(?, ?, ?) }");
        cs.setInt(1, item);
        cs.setInt(2, nroRecepcion);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.execute();

        return cs.getInt(3);
    }
}