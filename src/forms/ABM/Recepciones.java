/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.ABM;

import db.bdOracle;
import javax.swing.JTable;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import utils.Formulario;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JTextField;
import models.RecepcionDet;

/**
 *
 * @author Nelba Barreto
 */
public class Recepciones extends javax.swing.JPanel {

    private List<RecepcionDet> recepcionesDet;

    public JTextField getTfNroRecepcion() {
        return tfNroRecepcion;
    }

    public void setTfNroRecepcion(JTextField tfNroRecepcion) {
        this.tfNroRecepcion = tfNroRecepcion;
    }

    public List<RecepcionDet> getRecepcionesDet() {
        return recepcionesDet;
    }

    public static bdOracle getConexion() {
        return conexion;
    }

    public static void setConexion(bdOracle conexion) {
        Recepciones.conexion = conexion;
    }

    public void setRecepcionesDet(List<RecepcionDet> recepcionesDet) {
        this.recepcionesDet = recepcionesDet;
    }
    private static bdOracle conexion;
    private String msg;

    public Recepciones(bdOracle bd) {
        conexion = bd;
        initComponents();
    }

    public JTable gettRecepcionDet() {
        return tRecepcionDet;
    }

    public void settRecepcionDet(JTable tRecepcionDet) {
        this.tRecepcionDet = tRecepcionDet;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pEmpresas = new javax.swing.JPanel();
        laNroRecepcion = new javax.swing.JLabel();
        tfNroFactProv = new javax.swing.JTextField();
        bCreate = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        lMsg = new javax.swing.JLabel();
        tfFechaFactura = new javax.swing.JTextField();
        tfFecha = new javax.swing.JTextField();
        tfNroRecepcion = new javax.swing.JTextField();
        bConsultar = new javax.swing.JButton();
        laApellido1 = new javax.swing.JLabel();
        laFechaFactura = new javax.swing.JLabel();
        laFecha = new javax.swing.JLabel();
        laNroFactProv = new javax.swing.JLabel();
        bClean = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tRecepcionDet = new javax.swing.JTable();
        bGenerarDetalle = new javax.swing.JButton();
        bDelete2 = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bAdd = new javax.swing.JButton();

        pEmpresas.setBackground(new java.awt.Color(255, 255, 255));

        laNroRecepcion.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        laNroRecepcion.setLabelFor(tfNroRecepcion);
        laNroRecepcion.setText("N??mero Recepci??n");

        tfNroFactProv.setBackground(new java.awt.Color(229, 232, 237));
        tfNroFactProv.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tfNroFactProv.setBorder(null);
        tfNroFactProv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tfNroFactProv.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        tfNroFactProv.setBorder(BorderFactory.createCompoundBorder(
            tfNroFactProv.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

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

    lMsg.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    tfFechaFactura.setBackground(new java.awt.Color(229, 232, 237));
    tfFechaFactura.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    tfFechaFactura.setBorder(null);
    tfFechaFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    tfFechaFactura.setDisabledTextColor(new java.awt.Color(51, 51, 51));
    tfFechaFactura.setBorder(BorderFactory.createCompoundBorder(
        tfFechaFactura.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

tfFecha.setBackground(new java.awt.Color(229, 232, 237));
tfFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
tfFecha.setBorder(null);
tfFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
tfFecha.setDisabledTextColor(new java.awt.Color(51, 51, 51));
tfFecha.setBorder(BorderFactory.createCompoundBorder(
    tfFecha.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    tfNroRecepcion.setBackground(new java.awt.Color(229, 232, 237));
    tfNroRecepcion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    tfNroRecepcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(84, 52, 178)));
    tfNroRecepcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    tfNroRecepcion.setDisabledTextColor(new java.awt.Color(51, 51, 51));
    tfNroRecepcion.setBorder(BorderFactory.createCompoundBorder(
        tfNroRecepcion.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

bConsultar.setBackground(new java.awt.Color(255, 255, 255));
bConsultar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
bConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/search.png"))); // NOI18N
bConsultar.setToolTipText("Consultar");
bConsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(84, 52, 178)));
bConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
bConsultar.setFocusPainted(false);
bConsultar.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        bConsultarActionPerformed(evt);
    }
    });

    laApellido1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    laFechaFactura.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    laFechaFactura.setLabelFor(tfFechaFactura);
    laFechaFactura.setText("Fecha Factura");

    laFecha.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    laFecha.setLabelFor(tfFecha);
    laFecha.setText("Fecha");

    laNroFactProv.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    laNroFactProv.setLabelFor(tfFecha);
    laNroFactProv.setText("N??mero Factura Proveedor");

    bClean.setBackground(new java.awt.Color(255, 255, 255));
    bClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/broom.png"))); // NOI18N
    bClean.setToolTipText("Limpiar");
    bClean.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(172, 95, 200)));
    bClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bClean.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bCleanActionPerformed(evt);
        }
    });

    tRecepcionDet.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    tRecepcionDet.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] {
            "??tem", "Producto", "Descripci??n", "Cantidad"
        }
    ));
    jScrollPane2.setViewportView(tRecepcionDet);

    bGenerarDetalle.setBackground(new java.awt.Color(255, 255, 255));
    bGenerarDetalle.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    bGenerarDetalle.setText("Generar Detalle");
    bGenerarDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(84, 52, 178)));
    bGenerarDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bGenerarDetalle.setFocusPainted(false);
    bGenerarDetalle.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bGenerarDetalleActionPerformed(evt);
        }
    });

    bDelete2.setBackground(new java.awt.Color(255, 255, 255));
    bDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/delete.png"))); // NOI18N
    bDelete2.setToolTipText("Eliminar");
    bDelete2.setBorder(null);
    bDelete2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bDelete2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bDelete2ActionPerformed(evt);
        }
    });

    bEdit.setBackground(new java.awt.Color(255, 255, 255));
    bEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/edit.png"))); // NOI18N
    bEdit.setToolTipText("Editar");
    bEdit.setBorder(null);
    bEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bEdit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bEditActionPerformed(evt);
        }
    });

    bAdd.setBackground(new java.awt.Color(255, 255, 255));
    bAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/add.png"))); // NOI18N
    bAdd.setToolTipText("Agregar Nuevo ");
    bAdd.setBorder(null);
    bAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bAdd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bAddActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pEmpresasLayout = new javax.swing.GroupLayout(pEmpresas);
    pEmpresas.setLayout(pEmpresasLayout);
    pEmpresasLayout.setHorizontalGroup(
        pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pEmpresasLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEmpresasLayout.createSequentialGroup()
                    .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pEmpresasLayout.createSequentialGroup()
                            .addComponent(tfNroFactProv, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(laFechaFactura)
                                .addComponent(tfFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bClean)
                                    .addComponent(tfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(laFecha)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pEmpresasLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pEmpresasLayout.createSequentialGroup()
                                    .addComponent(bCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(bGenerarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(20, 20, 20))
                .addGroup(pEmpresasLayout.createSequentialGroup()
                    .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(laApellido1)
                        .addComponent(laNroRecepcion)
                        .addGroup(pEmpresasLayout.createSequentialGroup()
                            .addComponent(tfNroRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(bConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pEmpresasLayout.createSequentialGroup()
                    .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(laNroFactProv)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))))
    );
    pEmpresasLayout.setVerticalGroup(
        pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pEmpresasLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(bClean)
            .addGap(2, 2, 2)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(laFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(laNroRecepcion))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(tfNroRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(laNroFactProv)
                .addComponent(laFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tfNroFactProv, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(laApellido1)
            .addGap(7, 7, 7)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(pEmpresasLayout.createSequentialGroup()
                    .addComponent(bGenerarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pEmpresasLayout.createSequentialGroup()
                    .addComponent(bAdd)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bEdit)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bDelete2)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(31, 31, 31)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(52, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 568, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 475, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void clear() {
        tfFechaFactura.setText("");
        tfNroFactProv.setText("");
        tfFecha.setText("");
        tfNroRecepcion.setText("");
        recepcionesDet = Formulario.Recepciones.clearTable(tRecepcionDet);
    }

    private void bCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCleanActionPerformed
        clear();
    }//GEN-LAST:event_bCleanActionPerformed

    private void bConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarActionPerformed
        try {
            if (tfNroRecepcion.getText().equals("")) {
                msg = "N??mero de Recepci??n no puede estar vac??o";
                Formulario.General.setMsg(0, lMsg, msg);
            } else {
                int nroRecepcion = Integer.parseInt(tfNroRecepcion.getText());
                String query = "SELECT rece_nro_recepcion, rece_nro_factura_prov, TO_CHAR(rece_fecha, 'dd/mm/yyyy'), "
                        + "TO_CHAR(rece_fec_fact, 'dd/mm/yyyy') FROM RECEPCIONES WHERE rece_nro_recepcion = " + nroRecepcion;

                ResultSet rset = conexion.sql(query);

                if (Formulario.General.resultSetIsEmpty(rset) == true) {
                    msg = "No se encuentra ninguna Recepci??n con ese c??digo";
                    Formulario.General.setMsg(0, lMsg, msg);
                    clear();
                } else {
                    lMsg.setText("");
                    do {
                        tfNroRecepcion.setText(rset.getString(1));
                        tfNroFactProv.setText(rset.getString(2));
                        tfFecha.setText(rset.getString(3));
                        tfFechaFactura.setText(rset.getString(4));
                        recepcionesDet = Formulario.Recepciones.populateTable(tRecepcionDet, nroRecepcion, conexion);
                    } while (rset.next());
                }
            }
        } catch (SQLException ex) {
            msg = "Error al consultar";
            Formulario.General.setMsg(0, lMsg, msg);
            Logger.getLogger(Recepciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            msg = "Error al consultar";
            Formulario.General.setMsg(0, lMsg, msg);
            Logger.getLogger(Recepciones.class.getName()).log(Level.SEVERE, null, ex);
        };
    }//GEN-LAST:event_bConsultarActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        try {
            int nroRecepcion = Integer.parseInt(tfNroRecepcion.getText());

            /* for (RecepcionDet rece : recepcionesDet) {
                if (rece.getItem() > 0) {
                    if (conexion.fc_dele_recepcion_det(rece.getItem(), nroRecepcion) == 1) {
                        System.out.println("Detalle eliminado correctamente");
                    }
                }
            }*/
            String query = "DELETE FROM RECEPCIONES_DET WHERE rede_nro_recepcion = " + nroRecepcion;
            conexion.sql(query);

            int response = conexion.fc_dele_recepciones(nroRecepcion);
            if (response == 1) {
                clear();
                msg = "Registro eliminado correctamente";
            } else {
                msg = "No se pudo eliminar el registro";
            }
            Formulario.General.setMsg(response, lMsg, msg);
        } catch (SQLException ex) {
            Logger.getLogger(Recepciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        try {
            int nroRecepcion = Integer.parseInt(tfNroRecepcion.getText());
            int nroFacturaProv = Integer.parseInt(tfNroFactProv.getText());
            String fecha = tfFecha.getText();
            String fechaFactura = tfFechaFactura.getText();

            int response = conexion.fc_actu_recepcion(nroRecepcion, nroFacturaProv, fecha,
                    fechaFactura);
            if (response == 1) {
                msg = "Registro actualizado correctamente";
                for (RecepcionDet rede : recepcionesDet) {
                    if (rede.getItem() == 0) {
                        if (conexion.fc_inse_recepcion_det(conexion.recuSigteNumero("RECEPCIONES_DET", nroRecepcion),
                                rede.getCantidad(), nroRecepcion, rede.getCodigoProducto()) == 1) {
                            System.out.println("Detalle insertado correctamente");
                        } else {
                            System.out.println("Error al insertar detalle");
                        }
                    } else {
                        if (conexion.fc_actu_recepcion_det(rede.getItem(),
                                rede.getCantidad(), nroRecepcion, rede.getCodigoProducto()) == 1) {
                            System.out.println("Detalle actualizado correctamente");
                        } else {
                            System.out.println("Error al actualizar detalle");
                        }
                    }
                }
                Formulario.Recepciones.populateTable(tRecepcionDet, nroRecepcion, conexion);
            } else {
                msg = "No se pudo actualizar el registro";
            }
            Formulario.General.setMsg(response, lMsg, msg);
        } catch (SQLException ex) {
            Logger.getLogger(Recepciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateActionPerformed
        try {
            int nroFacturaProv = Integer.parseInt(tfNroFactProv.getText());
            String fecha = tfFecha.getText();
            int nroRecepcion = conexion.recuSigteNumero("RECEPCIONES");

            int response = conexion.fc_inse_recepcion(nroRecepcion,
                    fecha, fecha, nroFacturaProv);
            if (response == 1) {
                msg = "Registro insertado correctamente";
                for (RecepcionDet rede : recepcionesDet) {
                    if (conexion.fc_inse_recepcion_det(conexion.recuSigteNumero("RECEPCIONES_DET", nroRecepcion), rede.getCantidad(),
                            nroRecepcion, rede.getCodigoProducto()) == 1) {
                        System.out.println("Detalle insertado correctamente");
                    } else {
                        System.out.println("Error al insertar detalle");
                    }
                }
                clear();
            } else {
                msg = "No se pudo insertar el registro";
            }
            Formulario.General.setMsg(response, lMsg, msg);
            Formulario.Recepciones.populateTable(tRecepcionDet, nroRecepcion, conexion);

        } catch (SQLException ex) {
            Logger.getLogger(Recepciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bCreateActionPerformed

    private void bGenerarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarDetalleActionPerformed
        if (!tfNroFactProv.getText().equals("")) {
            int nroFacturaProv = Integer.parseInt(tfNroFactProv.getText());
            String query = "SELECT TO_CHAR(FAPR_FECHA, 'dd/mm/yyyy') FROM "
                    + "facturas_prov where FAPR_NRO_FACTURA_PROV = " + nroFacturaProv;
            try {
                ResultSet rset = conexion.sql(query);
                while (rset.next()) {
                    tfFechaFactura.setText(rset.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Recepciones.class.getName()).log(Level.SEVERE, null, ex);
            }

            recepcionesDet = Formulario.Recepciones.populateTable2(tRecepcionDet,
                    nroFacturaProv, conexion);
            lMsg.setText("");
        } else {
            msg = "Nro. Factura Proveedor no puede estar vac??o";
            Formulario.General.setMsg(0, lMsg, msg);
        }
    }//GEN-LAST:event_bGenerarDetalleActionPerformed

    private void bDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelete2ActionPerformed
        if (!tfNroRecepcion.getText().equals("")) {
            int nroFacturaProv = Integer.parseInt(tfNroFactProv.getText());
            int index = tRecepcionDet.getSelectedRow();
            if (index == -1) {
                msg = "Seleccionar la fila que desea eliminar";
                Formulario.General.setMsg(0, lMsg, msg);
            } else {
                int item = recepcionesDet.get(index).getItem();
                int response;
                try {
                    response = conexion.fc_dele_factura_prov_det(item, nroFacturaProv);
                    if (response == 1) {
                        recepcionesDet = Formulario.Recepciones.populateTable(tRecepcionDet, nroFacturaProv, conexion);
                        msg = "Registro eliminado correctamente";
                    } else {
                        msg = "No se pudo eliminar el registro";
                    }
                    Formulario.General.setMsg(response, lMsg, msg);
                } catch (SQLException ex) {
                    Logger.getLogger(Recepciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            msg = "Nro. Factura Proveedor no puede estar vac??o";
            Formulario.General.setMsg(0, lMsg, msg);
        }
    }//GEN-LAST:event_bDelete2ActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        int EDITAR = 2;
        int index = tRecepcionDet.getSelectedRow();

        if (index == -1) {
            msg = "Seleccionar la fila que desea editar";
            Formulario.General.setMsg(0, lMsg, msg);
        } else {
            JFrame frame = new JFrame();
            RecepcionesDet pAddFacturaProvDet = new RecepcionesDet(EDITAR, this);
            frame.add(pAddFacturaProvDet);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_bEditActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        if (!tfNroFactProv.getText().equals("")) {
            int INSERTAR = 1;

            JFrame frame = new JFrame();
            RecepcionesDet pAddFacturaProvDet = new RecepcionesDet(INSERTAR, this);
            frame.add(pAddFacturaProvDet);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
        } else {
            msg = "Nro. Recepci??n no puede estar vac??o";
            Formulario.General.setMsg(0, lMsg, msg);
        }
    }//GEN-LAST:event_bAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bClean;
    private javax.swing.JButton bConsultar;
    private javax.swing.JButton bCreate;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bDelete2;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bGenerarDetalle;
    private javax.swing.JButton bUpdate;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lMsg;
    private javax.swing.JLabel laApellido1;
    private javax.swing.JLabel laFecha;
    private javax.swing.JLabel laFechaFactura;
    private javax.swing.JLabel laNroFactProv;
    private javax.swing.JLabel laNroRecepcion;
    private javax.swing.JPanel pEmpresas;
    private javax.swing.JTable tRecepcionDet;
    private javax.swing.JTextField tfFecha;
    private javax.swing.JTextField tfFechaFactura;
    private javax.swing.JTextField tfNroFactProv;
    private javax.swing.JTextField tfNroRecepcion;
    // End of variables declaration//GEN-END:variables
}
