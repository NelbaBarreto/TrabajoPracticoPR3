package forms.ABM;

import forms.Main;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import models.Producto;
import utils.Formulario;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import models.FacturaProvDet;

/**
 *
 * @author Nelba Barreto
 */
public class FacturasProvDet extends javax.swing.JPanel {

    private List<Producto> productos;
    private String msg;
    private int operacion;
    private Main main;

    public FacturasProvDet(int operacion, Main main) {
        this.operacion = operacion;
        this.main = main;
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
        bReload = new javax.swing.JButton();

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
    productos = Formulario.Productos.populateComboBox(cxProductos, main.getConexion());

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

bReload.setBackground(new java.awt.Color(255, 255, 255));
bReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/reload.png"))); // NOI18N
bReload.setToolTipText("Agregar Nuevo ");
bReload.setBorder(null);
bReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
bReload.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        bReloadActionPerformed(evt);
    }
    });

    javax.swing.GroupLayout pEmpresasLayout = new javax.swing.GroupLayout(pEmpresas);
    pEmpresas.setLayout(pEmpresasLayout);
    pEmpresasLayout.setHorizontalGroup(
        pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pEmpresasLayout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(laCantidad)
                .addComponent(laProducto)
                .addComponent(laCantidad1)
                .addComponent(bReload))
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
            .addGap(58, 58, 58)
            .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(bMore)
                .addGroup(pEmpresasLayout.createSequentialGroup()
                    .addComponent(bReload)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(laProducto)
                        .addComponent(cxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
            .addContainerGap(33, Short.MAX_VALUE))
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

    private void close() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }

    private void setDefaultValues() {
        if (operacion == 2) {
            int index = main.gettFacturaProvDet().getSelectedRow();
            
            int codigoProducto = Integer.parseInt(main.gettFacturaProvDet().getValueAt(index, 1).toString());
            int selectedProducto = Formulario.Productos.findProducto(codigoProducto, productos);
            String cantidad = main.gettFacturaProvDet().getValueAt(index, 3).toString();
            String importe = main.gettFacturaProvDet().getValueAt(index, 4).toString();
            
            tfCantidad.setText(cantidad);
            tfImporte.setText(importe);
            cxProductos.setSelectedIndex(selectedProducto);
        }
    }

    private void updateFacturaProvDet() {
        FacturaProvDet facturaProvDet = null;
        main.setFacturasProvDet(new ArrayList<>());
        int nroFacturaProv;
        
        try {
            nroFacturaProv = Integer.parseInt(main.getTfNroFactProv().getText());
        } catch(Exception e) {
            nroFacturaProv = 0;
        }
        
        int codigoProducto;
        String descripcion;
        int cantidad;
        int importe;

        for (int i = 0; i < main.gettFacturaProvDet().getRowCount(); i++) {
            codigoProducto = Integer.parseInt(main.gettFacturaProvDet().getValueAt(i, 1).toString());
            descripcion = main.gettFacturaProvDet().getValueAt(i, 2).toString();
            cantidad = Integer.parseInt(main.gettFacturaProvDet().getValueAt(i, 3).toString());
            importe = Integer.parseInt(main.gettFacturaProvDet().getValueAt(i, 4).toString());

            facturaProvDet = new FacturaProvDet(0, nroFacturaProv, codigoProducto, cantidad, importe, descripcion);
            main.getFacturasProvDet().add(facturaProvDet);
        }
    }

    private void createFacturaProvDetalle() {
        DefaultTableModel model = (DefaultTableModel) main.gettFacturaProvDet().getModel();

        if (tfCantidad.getText().equals("") || tfImporte.getText().equals("")) {
            msg = "Debe llenar todos los campos";
            Formulario.General.setMsg(0, lMsg, msg);
        } else {
            // Cantidad
            String cantidad = tfCantidad.getText();
            // Importe
            String importe = tfImporte.getText();
            // Producto
            int index = cxProductos.getSelectedIndex();
            int codigoProducto = productos.get(index).getCodigo();
            String descripcion = productos.get(index).getDescripcion();

            model.insertRow(model.getRowCount(), new Object[]{0, codigoProducto, descripcion,
                cantidad, importe});
            updateFacturaProvDet();

            close();
        }
    }

    private void editFacturaProvDetalle() {
        DefaultTableModel model = (DefaultTableModel) main.gettFacturaProvDet().getModel();
        int index = main.gettFacturaProvDet().getSelectedRow();

        int codigoProducto = productos.get(cxProductos.getSelectedIndex()).getCodigo();
        String descripcion = productos.get(cxProductos.getSelectedIndex()).getDescripcion();
        String cantidad = tfCantidad.getText();
        String importe = tfImporte.getText();

        model.setValueAt(codigoProducto, index, 1);
        model.setValueAt(descripcion, index, 2);
        model.setValueAt(cantidad, index, 3);
        model.setValueAt(importe, index, 4);
        
        main.getFacturasProvDet().get(index).setCodigoProducto(codigoProducto);
        main.getFacturasProvDet().get(index).setDescripcion(descripcion);
        main.getFacturasProvDet().get(index).setCantidad(Integer.parseInt(cantidad));
        main.getFacturasProvDet().get(index).setImporte(Integer.parseInt(importe));

        close();
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
        Productos pProductos = new Productos(main.getConexion());
        frame.add(pProductos);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_bMoreActionPerformed

    private void bReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReloadActionPerformed
        productos = Formulario.Productos.populateComboBox(cxProductos, main.getConexion());
    }//GEN-LAST:event_bReloadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bMore;
    private javax.swing.JButton bReload;
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
