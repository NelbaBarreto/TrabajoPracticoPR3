/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.abm;

import db.bdOracle;
import forms.Login;
import forms.MenuPrincipal;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import models.Empresa;
import models.FacturaProvDet;

/**
 *
 * @author HP
 */
public class FacturasProv extends javax.swing.JPanel {
    private final JFrame fFacturaProv = new JFrame("Factura de Proveedor");
    private List<Empresa> empresas;
    private List<FacturaProvDet> facturasProvDet;
    private final bdOracle conexion;
    private String msg;

    public FacturasProv(bdOracle bd) {
        conexion = bd;
        initComponents();
        lpSecondary.setSize(350, 350);
        lpSecondary.setOpaque(true);
        tfFecha.setBorder(BorderFactory.createCompoundBorder(
        tfFecha.getBorder(), 
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        tfNroFactProv.setBorder(BorderFactory.createCompoundBorder(
        tfNroFactProv.getBorder(), 
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        tfTotal.setBorder(BorderFactory.createCompoundBorder(
        tfTotal.getBorder(), 
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = new Color(84, 52, 178);
        Color color2 = new Color(172, 95, 200);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
    
    public void run() {
        FacturasProv panel = new FacturasProv(conexion);
        fFacturaProv.add(panel);
        fFacturaProv.setSize(450, 450);
        fFacturaProv.setLocationRelativeTo(null);
        fFacturaProv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fFacturaProv.setVisible(true);
    }

    private Vector<String> populateComboEmpresa() {
        Vector<String> rowValues = new Vector<String>();
        try {
            empresas = new ArrayList<Empresa>();
            Empresa empresa = null;
            
            String query = "SELECT EMPR_ID_EMPRESA, EMPR_DESCRIPCION FROM EMPRESAS ORDER BY EMPR_ID_EMPRESA DESC";
          
            ResultSet rset = conexion.sql(query);
            while (rset.next()) {
                empresa = new Empresa(Integer.parseInt(rset.getString(1)), rset.getString(2));
                empresas.add(empresa);
                rowValues.add(empresa.getDescripcion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowValues;
    }
    
    private DefaultTableModel populateTable(int nroFacturaProv) {
        String[] columnNames = { "Ítem", "Producto", "Descripción", "Cantidad", "Importe" };
        facturasProvDet = new ArrayList<FacturaProvDet>();
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        try {
            FacturaProvDet facturaProvDetalle = null;
            String query = "SELECT fp.fpde_item, fp.fpde_nro_factura_prov, fp.fpde_cod_producto, fp.fpde_cantidad, fp.fpde_importe, p.prod_descripcion "
                    + "FROM facturas_prov_det fp, productos p WHERE fp.fpde_nro_factura_prov = " + nroFacturaProv + 
                    " AND fp.fpde_cod_producto = p.prod_cod_producto";

            ResultSet rset = conexion.sql(query);
            
            while (rset.next()) {
                facturaProvDetalle = new FacturaProvDet(rset.getInt(1), 
                        rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getString(6));
                facturasProvDet.add(facturaProvDetalle);
                String[] data = { String.valueOf(facturaProvDetalle.getItem()), 
                    String.valueOf(facturaProvDetalle.getCodigoProducto()), facturaProvDetalle.getDescripcion(), String.valueOf(facturaProvDetalle.getCantidad()),
                        String.valueOf(facturaProvDetalle.getImporte())};
                model.addRow(data);
            }
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private int calcularTotal() {
        int total = 0;
        for (FacturaProvDet fpde : facturasProvDet) {
            total += fpde.getCantidad() * fpde.getImporte();
        }
        return total;
    }
    
    public int findEmpresa(int id) {
	for(Empresa e: empresas) {
            if(id == e.getId()) {
                return empresas.indexOf(e);
            }
	}
	return -1;
    }
    
    private void setMsg(int response) {
        lMsg.setVisible(true);
        lMsg.setText(msg);
        if (response == 1) {
            lMsg.setForeground(Color.GREEN);
        } else {
            lMsg.setForeground(Color.RED);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lpSecondary = new javax.swing.JLayeredPane();
        lEmpresa = new javax.swing.JLabel();
        tfFecha = new javax.swing.JTextField();
        bCreate = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bVolver = new javax.swing.JButton();
        cxEstado = new javax.swing.JComboBox<>();
        lNroFactProv = new javax.swing.JLabel();
        lFecha = new javax.swing.JLabel();
        tfNroFactProv = new javax.swing.JTextField();
        lEstado = new javax.swing.JLabel();
        cxEmpresa = new javax.swing.JComboBox<>(populateComboEmpresa());
        lTipoFactura = new javax.swing.JLabel();
        cxTipoFactura = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tFacturaProvDet = new javax.swing.JTable();
        tfTotal = new javax.swing.JTextField();
        lEstado1 = new javax.swing.JLabel();
        bConsultar = new javax.swing.JButton();
        lMsg = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setMinimumSize(new java.awt.Dimension(450, 450));
        setPreferredSize(new java.awt.Dimension(450, 450));

        lpSecondary.setBackground(new java.awt.Color(255, 255, 255));
        lpSecondary.setFocusCycleRoot(true);
        lpSecondary.setPreferredSize(new java.awt.Dimension(350, 350));

        lEmpresa.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lEmpresa.setLabelFor(cxEstado);
        lEmpresa.setText("Empresa");

        tfFecha.setBackground(new java.awt.Color(229, 232, 237));
        tfFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tfFecha.setBorder(null);
        tfFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tfFecha.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        bCreate.setBackground(new java.awt.Color(255, 255, 255));
        bCreate.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        bCreate.setText("Insertar");
        bCreate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(84, 52, 178)));
        bCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCreate.setFocusPainted(false);
        bCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateActionPerformed(evt);
            }
        });

        bUpdate.setBackground(new java.awt.Color(255, 255, 255));
        bUpdate.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        bUpdate.setText("Actualizar");
        bUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(84, 52, 178)));
        bUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bUpdate.setFocusPainted(false);
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        bDelete.setBackground(new java.awt.Color(255, 255, 255));
        bDelete.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        bDelete.setText("Eliminar");
        bDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(84, 52, 178)));
        bDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bDelete.setFocusPainted(false);
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bVolver.setBackground(new java.awt.Color(255, 255, 255));
        bVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/goBack.png"))); // NOI18N
        bVolver.setBorder(null);
        bVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bVolver.setPreferredSize(new java.awt.Dimension(30, 30));
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });

        cxEstado.setBackground(new java.awt.Color(229, 232, 237));
        cxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "ANULADO" }));
        cxEstado.setToolTipText("");
        cxEstado.setPreferredSize(new java.awt.Dimension(1, 15));

        lNroFactProv.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lNroFactProv.setLabelFor(tfFecha);
        lNroFactProv.setText("Nro. Factura Prov.");

        lFecha.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lFecha.setLabelFor(tfFecha);
        lFecha.setText("Fecha");

        tfNroFactProv.setBackground(new java.awt.Color(229, 232, 237));
        tfNroFactProv.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tfNroFactProv.setBorder(null);
        tfNroFactProv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tfNroFactProv.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        lEstado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lEstado.setLabelFor(cxEstado);
        lEstado.setText("Estado");

        cxEmpresa.setBackground(new java.awt.Color(229, 232, 237));
        cxEmpresa.setPreferredSize(new java.awt.Dimension(1, 15));

        lTipoFactura.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lTipoFactura.setLabelFor(cxTipoFactura);
        lTipoFactura.setText("Tipo Factura");

        cxTipoFactura.setBackground(new java.awt.Color(229, 232, 237));
        cxTipoFactura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CRÉDITO" }));
        cxTipoFactura.setPreferredSize(new java.awt.Dimension(1, 15));

        tFacturaProvDet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ítem", "Producto", "Descripción", "Cantidad", "Importe"
            }
        ));
        jScrollPane2.setViewportView(tFacturaProvDet);

        tfTotal.setBackground(new java.awt.Color(229, 232, 237));
        tfTotal.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tfTotal.setBorder(null);
        tfTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tfTotal.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        tfTotal.setEnabled(false);

        lEstado1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lEstado1.setLabelFor(cxEstado);
        lEstado1.setText("Total");

        bConsultar.setBackground(new java.awt.Color(255, 255, 255));
        bConsultar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        bConsultar.setText("Consultar");
        bConsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(84, 52, 178)));
        bConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bConsultar.setFocusPainted(false);
        bConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarActionPerformed(evt);
            }
        });

        lpSecondary.setLayer(lEmpresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(tfFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(bCreate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(bUpdate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(bDelete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(bVolver, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(cxEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(lNroFactProv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(lFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(tfNroFactProv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(lEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(cxEmpresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(lTipoFactura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(cxTipoFactura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(tfTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(lEstado1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(bConsultar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSecondary.setLayer(lMsg, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpSecondaryLayout = new javax.swing.GroupLayout(lpSecondary);
        lpSecondary.setLayout(lpSecondaryLayout);
        lpSecondaryLayout.setHorizontalGroup(
            lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lpSecondaryLayout.createSequentialGroup()
                .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lpSecondaryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(lpSecondaryLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lEstado1)
                        .addGap(18, 18, 18)
                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(lpSecondaryLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lpSecondaryLayout.createSequentialGroup()
                        .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(lpSecondaryLayout.createSequentialGroup()
                                .addComponent(lEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lTipoFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cxTipoFactura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lpSecondaryLayout.createSequentialGroup()
                                .addComponent(lNroFactProv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNroFactProv, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(lFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFecha))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lpSecondaryLayout.createSequentialGroup()
                                .addComponent(lEmpresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cxEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))
                    .addGroup(lpSecondaryLayout.createSequentialGroup()
                        .addComponent(bVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lpSecondaryLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        lpSecondaryLayout.setVerticalGroup(
            lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpSecondaryLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(bVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lEmpresa))
                .addGap(10, 10, 10)
                .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNroFactProv, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNroFactProv)
                    .addComponent(lFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lEstado))
                    .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cxTipoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lTipoFactura)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lEstado1)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lpSecondaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lpSecondary, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lpSecondary, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        fFacturaProv.dispose();
        MenuPrincipal fMainMenu = new MenuPrincipal(conexion);
        fMainMenu.run();
    }//GEN-LAST:event_bVolverActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        try {
            // Nro. Factura Proveedor
            int nroFacturaProv = Integer.parseInt(tfNroFactProv.getText());
            try {
                conexion.sql("DELETE FROM facturas_prov_det WHERE fpde_nro_factura_prov = " + nroFacturaProv);
            } catch (SQLException ex) {
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
            }
            int response = conexion.fc_dele_factura_prov(nroFacturaProv);
            if (response == 1) {
                msg = "Registro eliminado correctamente";
            } else {
                msg = "No se pudo eliminar el registro";
            }
            setMsg(response);
        } catch (SQLException ex) {
            msg = "No se pudo eliminar el registro";
            setMsg(0);
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            msg = "No se pudo eliminar el registro";
            setMsg(0);
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        };
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        try {
            // Nro. Factura Proveedor
            int nroFacturaProv = Integer.parseInt(tfNroFactProv.getText());
            // Id Empresa
            int index = cxEmpresa.getSelectedIndex();
            int idEmpresa = empresas.get(index).getId();
            String fecha = tfFecha.getText();
            // Estado (1. ACTIVO, 2. CANCELADO, 3. ANULADO )
            int estado = cxEstado.getSelectedIndex() + 1;
            // Tipo (1. CONTADO, 2. CREDITO)
            int tipo = cxTipoFactura.getSelectedIndex() + 1;

            int response = conexion.fc_actu_factura_prov(nroFacturaProv, fecha, estado, tipo, idEmpresa);
            if (response == 1) {
                msg = "Registro actualizado correctamente";
            } else {
                msg = "No se pudo actualizar el registro";
            }
            setMsg(response);
            
            // Actualizar detalle
            for (int i = 0; i < tFacturaProvDet.getRowCount(); i++) {
                // Item, Cantidad, Importe, Nro_factura_prov, Cod_producto
                conexion.fc_actu_factura_prov_det(Integer.parseInt(tFacturaProvDet.getValueAt(i, 0).toString()), 
                        Integer.parseInt(tFacturaProvDet.getValueAt(i, 3).toString()), 
                        Integer.parseInt(tFacturaProvDet.getValueAt(i, 4).toString()),
                        nroFacturaProv,
                        Integer.parseInt(tFacturaProvDet.getValueAt(i, 1).toString()));
            }
        } catch (Exception ex) {
            msg = "No se pudo actualizar el registro";
            setMsg(0);
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        };
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateActionPerformed
        try {
            // Id Empresa
            int index = cxEmpresa.getSelectedIndex();
            int idEmpresa = empresas.get(index).getId();
            // Fecha
            String fecha = tfFecha.getText();
            // Estado (1. ACTIVO, 2. CANCELADO, 3. ANULADO )
            int estado = cxEstado.getSelectedIndex() + 1;
            // Tipo (1. CONTADO, 2. CREDITO)
            int tipo = cxTipoFactura.getSelectedIndex() + 1;

            int response = conexion.fc_inse_factura_prov(conexion.recuSigteNumero("FACTURAS_PROV"), fecha, estado, tipo, idEmpresa);
            if (response == 1) {
                msg = "Registro insertado correctamente";
            } else {
                msg = "No se pudo insertar el registro";
            }
            setMsg(response);
        } catch (Exception ex) {
            msg = "No se pudo insertar el registro";
            setMsg(0);
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        };
    }//GEN-LAST:event_bCreateActionPerformed

    private void bConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarActionPerformed
        try {
            if (tfNroFactProv.getText().equals("")) {
                msg = "Nro. Factura Prov. no puede estar vacío";
                setMsg(0);
            } else {
                // Nro. Factura Proveedor
                int nroFacturaProv = Integer.parseInt(tfNroFactProv.getText());
                String query = "SELECT fapr_nro_factura_prov, TO_CHAR(fapr_fecha, 'dd/mm/yyyy'), fapr_estado, "
                        + "fapr_tipo_factura, fapr_id_empresa FROM facturas_prov WHERE fapr_nro_factura_prov = " + nroFacturaProv;

                ResultSet rset = conexion.sql(query);
                while (rset.next()) {
                    tfFecha.setText(rset.getString(2));
                    cxEstado.setSelectedIndex(rset.getInt(3) - 1);
                    cxTipoFactura.setSelectedIndex(rset.getInt(4) - 1);
                    cxEmpresa.setSelectedIndex(findEmpresa(rset.getInt(5)));
                    tFacturaProvDet.setModel(populateTable(nroFacturaProv));
                    tfTotal.setText(String.valueOf(calcularTotal()));
                }
            }
        } catch (SQLException ex) {
            msg = "Error al consultar";
            setMsg(0);
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            msg = "Error al consultar";
            setMsg(0);
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        };
    }//GEN-LAST:event_bConsultarActionPerformed

        

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConsultar;
    private javax.swing.JButton bCreate;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bUpdate;
    private javax.swing.JButton bVolver;
    private javax.swing.JComboBox<String> cxEmpresa;
    private javax.swing.JComboBox<String> cxEstado;
    private javax.swing.JComboBox<String> cxTipoFactura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lEmpresa;
    private javax.swing.JLabel lEstado;
    private javax.swing.JLabel lEstado1;
    private javax.swing.JLabel lFecha;
    private javax.swing.JLabel lMsg;
    private javax.swing.JLabel lNroFactProv;
    private javax.swing.JLabel lTipoFactura;
    private javax.swing.JLayeredPane lpSecondary;
    private javax.swing.JTable tFacturaProvDet;
    private javax.swing.JTextField tfFecha;
    private javax.swing.JTextField tfNroFactProv;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
