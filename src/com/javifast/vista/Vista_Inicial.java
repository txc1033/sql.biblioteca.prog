/* Autor @Javifast | @Txc1033 */
package com.javifast.vista;

import com.javifast.controller.Administrador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Vista_Inicial extends javax.swing.JFrame {

    static Administrador admin = new Administrador();

    public Vista_Inicial() {
        this.setLocationRelativeTo(null);
        initComponents();
        try { // try - catch para inicializar el metodo uimanager
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // metodo para asignar un tema para la app (visual)
        } catch (Exception ex) {
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jinicio = new javax.swing.JLabel();
        btn_libros = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jinicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jinicio.setText("Bienvenido a la biblioteca");

        btn_libros.setText("Libros");
        btn_libros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_librosActionPerformed(evt);
            }
        });

        btn_clientes.setText("Clientes");
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jinicio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btn_libros)
                        .addGap(59, 59, 59)
                        .addComponent(btn_clientes)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jinicio)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_libros)
                    .addComponent(btn_clientes))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_librosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_librosActionPerformed
        new Vista_Libros().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_librosActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        new Vista_Clientes().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_clientesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Vista_Inicial().setVisible(true);
            try {
                admin.Crear();
            } catch (SQLException ex) {
                System.out.println("Error en CrearTabla " + ex.getMessage());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_libros;
    private javax.swing.JLabel jinicio;
    // End of variables declaration//GEN-END:variables
}
