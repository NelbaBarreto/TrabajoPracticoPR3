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
                String query = "SELECT EMPR_ID_EMPRESA, EMPR_DESCRIPCION FROM EMPRESAS ORDER BY EMPR_ID_EMPRESA DESC";

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
                        + "FROM EMPRESAS ORDER BY EMPR_ID_EMPRESA DESC";

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
            List<FacturaProvDet> facturasProvDet = new ArrayList<FacturaProvDet>();
            String[] columnNames = {"Ítem", "Producto", "Descripción", "Cantidad", "Importe"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);

            try {
                FacturaProvDet facturaProvDetalle = null;
                String query = "SELECT fp.fpde_item, fp.fpde_nro_factura_prov, fp.fpde_cod_producto, fp.fpde_cantidad, fp.fpde_importe, p.prod_descripcion "
                        + "FROM facturas_prov_det fp, productos p WHERE fp.fpde_nro_factura_prov = " + nroFacturaProv
                        + " AND fp.fpde_cod_producto = p.prod_cod_producto";

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
            String[] columnNames = {"Ítem", "Producto", "Descripción", "Cantidad", "Importe"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);
            tFacturaProvDet.setModel(model);
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
    }
}
