package trabajo_practico;

import java.sql.*;
        
public class bdOracle{
  private Connection conn;

  public void abrir(String usu, String pass)throws SQLException{
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
        String apellido1, String apellido2) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_PERSONA(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, cod);
        cs.setString(2, nombre1);
        cs.setString(3, nombre2);
        cs.setString(4, apellido1);
        cs.setString(5, apellido2);
        cs.registerOutParameter(6, Types.INTEGER);
        cs.execute();

        return cs.getInt(6);
    }
    
    public int fc_actu_persona(int cod, String nombre1, String nombre2, 
        String apellido1, String apellido2) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_PERSONA(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, cod);
        cs.setString(2, nombre1);
        cs.setString(3, nombre2);
        cs.setString(4, apellido1);
        cs.setString(5, apellido2);
        cs.registerOutParameter(6, Types.INTEGER);
        cs.execute();

        return cs.getInt(6);
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
    public int fc_inse_factura_prov(int nro, Date fecha, int estado, 
            int tipo_factura, int id_empresa) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_FACTURA_PROV(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, nro);
        cs.setDate(2, fecha);
        cs.setInt(3, estado);
        cs.setInt(4, tipo_factura);
        cs.setInt(5, id_empresa);
        cs.registerOutParameter(6, Types.INTEGER);
        cs.execute();

        return cs.getInt(6);
    }
    
    public int fc_actu_factura_prov(int nro, Date fecha, int estado, 
            int tipo_factura, int id_empresa) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_FACTURA_PROV(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, nro);
        cs.setDate(2, fecha);
        cs.setInt(3, estado);
        cs.setInt(4, tipo_factura);
        cs.setInt(5, id_empresa);
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
            int nro_factura_prov, int cod_prod) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_INSE_FACTURA_PROV_DET(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, item);
        cs.setInt(2, cantidad);
        cs.setInt(3, importe);
        cs.setInt(4, nro_factura_prov);
        cs.setInt(5, cod_prod);
        cs.registerOutParameter(6, Types.INTEGER);
        cs.execute();

        return cs.getInt(6);
    }
    
    public int fc_actu_factura_prov_det(int item, int cantidad, int importe, 
            int nro_factura_prov, int cod_prod) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_ACTU_FACTURA_PROV_DET(?, ?, ?, ?, ?, ?) }");
        cs.setInt(1, item);
        cs.setInt(2, cantidad);
        cs.setInt(3, importe);
        cs.setInt(4, nro_factura_prov);
        cs.setInt(5, cod_prod);
        cs.registerOutParameter(6, Types.INTEGER);
        cs.execute();

        return cs.getInt(6);
    }
    
    public int fc_dele_factura_prov_det(int item) throws SQLException {
        CallableStatement cs = null;
        cs = conn.prepareCall("{ call PC_DELE_FACTURA_PROV_DET(?, ?) }");
        cs.setInt(1, item);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.execute();

        return cs.getInt(2);
    }
}