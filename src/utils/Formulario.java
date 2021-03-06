/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import db.bdOracle;
import forms.Login;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Empresa;
import models.FacturaProvDet;
import models.Producto;
import models.Ciudad;
import models.RecepcionDet;

/**
 *
 * @author HP
 */
public class Formulario {

    public static class Empresas {

        public static int findEmpresa(int id, List<Empresa> empresas) {
            for (Empresa e : empresas) {
                if (id == e.getId()) {
                    return empresas.indexOf(e);
                }
            }
            return -1;
        }

        public static List<Empresa> populateList(JList lEmpresa, bdOracle conexion) {
            DefaultListModel<String> rowValues = new DefaultListModel<>();
            List<Empresa> empresas = new ArrayList<Empresa>();

            try {
                empresas = new ArrayList<Empresa>();
                Empresa currentEmpresa = null;
                int i = 0;
                String query = "SELECT EMPR_ID_EMPRESA, EMPR_DESCRIPCION FROM "
                        + "EMPRESAS ORDER BY EMPR_DESCRIPCION";

                ResultSet rset = conexion.sql(query);
                while (rset.next()) {
                    currentEmpresa = new Empresa(Integer.parseInt(rset.getString(1)), rset.getString(2));
                    empresas.add(currentEmpresa);

                    rowValues.add(i, rset.getString(2));
                    i++;
                }
                lEmpresa.setModel(rowValues);

                return empresas;
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        public static List<Empresa> populateComboBox(JComboBox cxEmpresa, bdOracle conexion) {
            DefaultComboBoxModel<String> rowValues = new DefaultComboBoxModel<>();
            List<Empresa> empresas = new ArrayList<Empresa>();

            try {
                empresas = new ArrayList<Empresa>();
                Empresa empresa = null;
                String query = "SELECT EMPR_ID_EMPRESA, EMPR_DESCRIPCION "
                        + "FROM EMPRESAS ORDER BY EMPR_DESCRIPCION";

                ResultSet rset = conexion.sql(query);
                while (rset.next()) {
                    empresa = new Empresa(Integer.parseInt(rset.getString(1)), rset.getString(2));
                    empresas.add(empresa);
                    rowValues.addElement(empresa.getDescripcion());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            cxEmpresa.setModel(rowValues);
            return empresas;
        }
    }

    public static class FacturasProvDet {

        public static int calcularTotal(List<FacturaProvDet> facturasProvDet) {
            int total = 0;
            for (FacturaProvDet fpde : facturasProvDet) {
                total += fpde.getCantidad() * fpde.getImporte();
            }
            return total;
        }

        public static List<FacturaProvDet> populateTable(JTable tFacturaProvDet,
                int nroFacturaProv, bdOracle conexion) {
            List<FacturaProvDet> facturasProvDet = new ArrayList<>();
            String[] columnNames = {"??tem", "Producto", "Descripci??n", "Cantidad", "Importe"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);

            try {
                FacturaProvDet facturaProvDetalle = null;
                String query = "SELECT fp.fpde_item, fp.fpde_nro_factura_prov, fp.fpde_cod_producto, fp.fpde_cantidad, fp.fpde_importe, p.prod_descripcion "
                        + "FROM facturas_prov_det fp, productos p WHERE fp.fpde_nro_factura_prov = " + nroFacturaProv
                        + " AND fp.fpde_cod_producto = p.prod_cod_producto ORDER BY fp.fpde_item";

                ResultSet rset = conexion.sql(query);

                while (rset.next()) {
                    facturaProvDetalle = new FacturaProvDet(rset.getInt(1),
                            rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getString(6));
                    facturasProvDet.add(facturaProvDetalle);
                    String[] data = {String.valueOf(facturaProvDetalle.getItem()),
                        String.valueOf(facturaProvDetalle.getCodigoProducto()), facturaProvDetalle.getDescripcion(), String.valueOf(facturaProvDetalle.getCantidad()),
                        String.valueOf(facturaProvDetalle.getImporte())};
                    model.addRow(data);
                }
                tFacturaProvDet.setModel(model);

                return facturasProvDet;
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        public static List<FacturaProvDet> clearTable(JTable tFacturaProvDet) {
            String[] columnNames = {"??tem", "Producto", "Descripci??n", "Cantidad", "Importe"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);
            tFacturaProvDet.setModel(model);
            return null;
        }
    }

    public static class Productos {

        public static int findProducto(int codigo, List<Producto> productos) {
            for (Producto p : productos) {
                if (codigo == p.getCodigo()) {
                    return productos.indexOf(p);
                }
            }
            return -1;
        }

        public static List<Producto> populateComboBox(JComboBox cxProductos, bdOracle conexion) {
            DefaultComboBoxModel<String> rowValues = new DefaultComboBoxModel<>();
            List<Producto> productos = new ArrayList<>();

            try {
                productos = new ArrayList<>();
                Producto producto = null;
                String query = "SELECT PROD_COD_PRODUCTO, PROD_DESCRIPCION "
                        + "FROM PRODUCTOS ORDER BY PROD_DESCRIPCION";

                ResultSet rset = conexion.sql(query);
                while (rset.next()) {
                    producto = new Producto(Integer.parseInt(rset.getString(1)), rset.getString(2));
                    productos.add(producto);
                    rowValues.addElement(producto.getDescripcion());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            cxProductos.setModel(rowValues);
            return productos;
        }

        public static List<Producto> populateList(JList lProductos, bdOracle conexion) {
            DefaultListModel<String> rowValues = new DefaultListModel<>();
            List<Producto> productos;

            try {
                productos = new ArrayList<>();
                Producto currentProducto = null;
                int i = 0;
                String query = "SELECT PROD_COD_PRODUCTO, PROD_DESCRIPCION "
                        + "FROM PRODUCTOS ORDER BY PROD_DESCRIPCION";

                ResultSet rset = conexion.sql(query);
                while (rset.next()) {
                    currentProducto = new Producto(Integer.parseInt(rset.getString(1)), rset.getString(2));
                    productos.add(currentProducto);

                    rowValues.add(i, rset.getString(2));
                    i++;
                }
                lProductos.setModel(rowValues);

                return productos;
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }

    public static class Ciudades {

        public static List<Ciudad> populateComboBox(JComboBox cxCiudades, bdOracle conexion) {
            DefaultComboBoxModel<String> rowValues = new DefaultComboBoxModel<>();
            List<Ciudad> ciudades = new ArrayList<>();

            try {
                ciudades = new ArrayList<>();
                Ciudad ciudad = null;
                String query = "SELECT CIUD_COD_CIUDAD, CIUD_DESCRIPCION "
                        + "FROM CIUDADES ORDER BY CIUD_COD_CIUDAD";
                ResultSet rset = conexion.sql(query);
                while (rset.next()) {
                    ciudad = new Ciudad(Integer.parseInt(rset.getString(1)), rset.getString(2));
                    ciudades.add(ciudad);
                    rowValues.addElement(ciudad.getDescripcion());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            cxCiudades.setModel(rowValues);
            return ciudades;
        }

        public static List<Ciudad> populateList(JList lCiudades, bdOracle conexion) {
            DefaultListModel<String> rowValues = new DefaultListModel<>();
            List<Ciudad> ciudades;

            try {
                ciudades = new ArrayList<>();
                Ciudad currentciudad = null;
                int i = 0;
                String query = "SELECT CIUD_COD_CIUDAD, CIUD_DESCRIPCION "
                        + "FROM CIUDADES ORDER BY CIUD_DESCRIPCION";

                ResultSet rset = conexion.sql(query);
                while (rset.next()) {
                    currentciudad = new Ciudad(Integer.parseInt(rset.getString(1)), rset.getString(2));
                    ciudades.add(currentciudad);

                    rowValues.add(i, rset.getString(2));
                    i++;
                }
                lCiudades.setModel(rowValues);

                return ciudades;
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }

    public static class Recepciones {

        public static List<RecepcionDet> populateTable(JTable tFacturaProvDet,
                int nroRecepcion, bdOracle conexion) {
            List<RecepcionDet> recepcionesDet = new ArrayList<>();
            String[] columnNames = {"??tem", "Producto", "Descripci??n", "Cantidad"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);

            try {
                RecepcionDet recepcionDet = null;
                String query = "SELECT d.rede_item, d.rede_cantidad, d.rede_nro_recepcion, d.rede_cod_producto, p.prod_descripcion "
                        + "FROM recepciones_det d, productos p WHERE rede_nro_recepcion = " + nroRecepcion
                        + "AND rede_cod_producto = p.prod_cod_producto";

                ResultSet rset = conexion.sql(query);

                while (rset.next()) {
                    recepcionDet = new RecepcionDet(rset.getInt(1),
                            rset.getInt(4), rset.getInt(2), rset.getString(5), rset.getInt(3));
                    recepcionesDet.add(recepcionDet);
                    String[] data = {String.valueOf(recepcionDet.getItem()),
                        String.valueOf(recepcionDet.getCodigoProducto()), recepcionDet.getDescripcion(), String.valueOf(recepcionDet.getCantidad())};
                    model.addRow(data);
                }
                tFacturaProvDet.setModel(model);

                return recepcionesDet;
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        public static List<RecepcionDet> populateTable2(JTable tFacturaProvDet,
                int nroFacturaProv, bdOracle conexion) {
            List<RecepcionDet> recepcionesDet = new ArrayList<>();
            String[] columnNames = {"??tem", "Producto", "Descripci??n", "Cantidad"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);

            try {
                RecepcionDet recepcionDet = null;
                String query = "SELECT d.fpde_item, d.fpde_cantidad, d.fpde_nro_factura_prov, d.fpde_cod_producto, p.prod_descripcion "
                        + "FROM facturas_prov_det d, productos p WHERE d.fpde_nro_factura_prov = " + nroFacturaProv
                        + "AND d.fpde_cod_producto =  p.prod_cod_producto";

                ResultSet rset = conexion.sql(query);

                while (rset.next()) {
                    recepcionDet = new RecepcionDet(rset.getInt(1),
                            rset.getInt(4), rset.getInt(2), rset.getString(5), rset.getInt(3));
                    recepcionesDet.add(recepcionDet);
                    String[] data = {String.valueOf(recepcionDet.getItem()),
                        String.valueOf(recepcionDet.getCodigoProducto()), recepcionDet.getDescripcion(), String.valueOf(recepcionDet.getCantidad())};
                    model.addRow(data);
                }
                tFacturaProvDet.setModel(model);

                return recepcionesDet;
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        public static List<RecepcionDet> clearTable(JTable tRecepcionesDet) {
            String[] columnNames = {"??tem", "Producto", "Descripci??n", "Cantidad"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);
            tRecepcionesDet.setModel(model);
            return null;
        }
    }

    public static class General {

        public static boolean resultSetIsEmpty(ResultSet rs) throws SQLException {
            boolean isEmpty;

            if (rs.next() == false) {
                isEmpty = true;
            } else {
                isEmpty = false;
            }

            return isEmpty;
        }

        public static void setMsg(int response, JLabel lMsg, String msg) {
            lMsg.setVisible(true);
            lMsg.setText(msg);
            if (response == 1) {
                lMsg.setForeground(Color.GREEN);
            } else {
                lMsg.setForeground(Color.RED);
            }
        }
    }
}
