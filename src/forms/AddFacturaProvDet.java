package forms;

import db.bdOracle;
import forms.ABM.Productos;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import models.Producto;
import utils.Formulario;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

/**
 *
 * @author Nelba Barreto
 */
public class AddFacturaProvDet extends javax.swing.JPanel {

    private List<Producto> productos;
    private static bdOracle conexion;
    private String msg;
    private int operacion;
    private int nroFacturaProv;
    private int item;

    public AddFacturaProvDet(bdOracle bd, int nroFacturaProv, int operacion, int item) {
        conexion = bd;
        this.nroFacturaProv = nroFacturaProv;
        this.operacion = operacion;
        this.item = item;
        initComponents();
        setDefaultValues();
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
        laProducto = new javax.swing.JLabel();
        laCantidad = new javax.swing.JLabel();
        tfImporte = new javax.swing.JTextField();
        bAceptar = new javax.swing.JButton();
        lMsg = new javax.swing.JLabel();
        cxProductos = new javax.swing.JComboBox<>();
        bMore = new javax.swing.JButton();
        laCantidad1 = new javax.swing.JLabel();
        tfCantidad = new javax.swing.JTextField();

        pEmpresas.setBackground(new java.awt.Color(255, 255, 255));

        laProducto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        laProducto.setText("Producto");

        laCantidad.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        laCantidad.setText("Cantidad");

        tfImporte.setBackground(new java.awt.Color(229, 232, 237));
        tfImporte.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tfImporte.setBorder(null);
        tfImporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tfImporte.setBorder(BorderFactory.createCompoundBorder(
            tfImporte.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    bAceptar.setBackground(new java.awt.Color(255, 255, 255));
    bAceptar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    bAceptar.setText("Aceptar");
    bAceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(84, 52, 178)));
    bAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bAceptar.setFocusPainted(false);
    bAceptar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bAceptarActionPerformed(evt);
        }
    });

    lMsg.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    cxProductos.setBackground(new java.awt.Color(229, 232, 237));
    cxProductos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    cxProductos.setPreferredSize(new java.awt.Dimension(1, 15));
    cxProductos.setPreferredSize(new java.awt.Dimension(1, 15));
    productos = Formulario.Productos.populateComboBox(cxProductos, conexion);

    bMore.setBackground(new java.awt.Color(255, 255, 255));
    bMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/more.png"))); // NOI18N
    bMore.setToolTipText("Cargar Producto");
    bMore.setBorder(null);
    bMore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bMore.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bMoreActionPerformed(evt);
        }
    });

    laCantidad1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    laCantidad1.setText("Importe");

    tfCantidad.setBackground(new java.awt.Color(229, 232, 237));
    tfCantidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    tfCantidad.setBorder(null);
    tfCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    tfCantidad.setBorder(BorderFactory.createCompoundBorder(
        tfCantidad.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

javax.swing.GroupLayout pEmpresasLayout = new javax.swing.GroupLayout(pEmpresas);
pEmpresas.setLayout(pEmpresasLayout);
pEmpresasLayout.setHorizontalGroup(
    pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(pEmpresasLayout.createSequentialGroup()
        .addGap(27, 27, 27)
        .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(laCantidad)
            .addComponent(laProducto)
            .addComponent(laCantidad1))
        .addGap(18, 18, 18)
        .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pEmpresasLayout.createSequentialGroup()
                .addComponent(cxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bMore)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEmpresasLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEmpresasLayout.createSequentialGroup()
                .addComponent(lMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEmpresasLayout.createSequentialGroup()
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))))
    );
    pEmpresasLayout.setVerticalGroup(
        pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pEmpresasLayout.createSequentialGroup()
            .addGap(64, 64, 64)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laProducto)
                    .addComponent(cxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(bMore))
            .addGap(23, 23, 23)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(laCantidad)
                .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(31, 31, 31)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tfImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(laCantidad1))
            .addGap(55, 55, 55)
            .addComponent(lMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(50, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 358, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 358, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 380, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void setDefaultValues() {
        if (operacion == 2) {
            try {
                String query = "SELECT fpde_cod_producto, fpde_cantidad, fpde_importe "
                        + "FROM facturas_prov_det WHERE fpde_nro_factura_prov = " + nroFacturaProv
                        + " AND fpde_item = " + item;
                ResultSet rset = conexion.sql(query);
                if (Formulario.General.resultSetIsEmpty(rset) == true) {
                    Formulario.General.setMsg(0, lMsg, msg);
                } else {
                    do {
                        System.out.println(rset.getString(2));
                        cxProductos.setSelectedIndex(Formulario.Productos.findProducto(rset.getInt(1), productos));
                        tfCantidad.setText(rset.getString(2));
                        tfImporte.setText(rset.getString(3));
                    } while (rset.next());
                }

            } catch (SQLException ex) {
                Logger.getLogger(AddFacturaProvDet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void createFacturaProvDetalle() {
        try {
            // Código Producto
            int index = cxProductos.getSelectedIndex();
            int codigoProducto = productos.get(index).getCodigo();

            if (tfCantidad.getText().equals("") || tfImporte.getText().equals("")) {
                msg = "Debe llenar todos los campos";
                Formulario.General.setMsg(0, lMsg, msg);
            } else {
                // Cantidad
                int cantidad = Integer.parseInt(tfCantidad.getText());
                // Importe
                int importe = Integer.parseInt(tfImporte.getText());

                int response = conexion.fc_inse_factura_prov_det(conexion.recuSigteNumero("FACTURAS_PROV_DET", nroFacturaProv),
                        cantidad, importe, nroFacturaProv, codigoProducto);
                if (response == 1) {
                    cxProductos.setSelectedIndex(0);
                    tfCantidad.setText("");
                    tfImporte.setText("");
                    msg = "Registro insertado correctamente";
                } else {
                    msg = "No se pudo insertar el registro";
                }
                Formulario.General.setMsg(response, lMsg, msg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddFacturaProvDet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editFacturaProvDetalle() {
        try {
            // Código Producto
            int index = cxProductos.getSelectedIndex();
            int codigoProducto = productos.get(index).getCodigo();

            if (tfCantidad.getText().equals("") || tfImporte.getText().equals("")) {
                msg = "Debe llenar todos los campos";
                Formulario.General.setMsg(0, lMsg, msg);
            } else {
                // Cantidad
                int cantidad = Integer.parseInt(tfCantidad.getText());
                // Importe
                int importe = Integer.parseInt(tfImporte.getText());

                int response = conexion.fc_actu_factura_prov_det(item,
                        cantidad, importe, nroFacturaProv, codigoProducto);
                if (response == 1) {
                    cxProductos.setSelectedIndex(0);
                    tfCantidad.setText("");
                    tfImporte.setText("");
                    msg = "Registro actualizado correctamente";
                } else {
                    msg = "No se pudo actualizar el registro";
                }
                Formulario.General.setMsg(response, lMsg, msg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddFacturaProvDet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        if (operacion == 1) {
            createFacturaProvDetalle();
        } else {
            editFacturaProvDetalle();
        }
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMoreActionPerformed
        JFrame frame = new JFrame();
        Productos pProductos = new Productos(conexion);
        frame.add(pProductos);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_bMoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bMore;
    private javax.swing.JComboBox<String> cxProductos;
    private javax.swing.JLabel lMsg;
    private javax.swing.JLabel laCantidad;
    private javax.swing.JLabel laCantidad1;
    private javax.swing.JLabel laProducto;
    private javax.swing.JPanel pEmpresas;
    private javax.swing.JTextField tfCantidad;
    private javax.swing.JTextField tfImporte;
    // End of variables declaration//GEN-END:variables
}