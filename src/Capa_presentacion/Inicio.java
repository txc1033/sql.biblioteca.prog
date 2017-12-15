package Capa_presentacion;
import Adminitrador.Administrador;
/**
 *
 * @author javier
 */
public class Inicio extends javax.swing.JFrame { 
    Administrador admin = new Administrador();
    public Inicio() {
        this.setLocationRelativeTo(null);
        initComponents();       
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jinicio = new javax.swing.JLabel();
        btn_libros = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_db_libro = new javax.swing.JButton();
        btn_db_clientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        btn_db_libro.setText("Crear tabla libros");
        btn_db_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_db_libroActionPerformed(evt);
            }
        });

        btn_db_clientes.setText("Crear tabla clientes");
        btn_db_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_db_clientesActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_db_libro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_db_clientes)
                .addGap(19, 19, 19))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_db_libro)
                    .addComponent(btn_db_clientes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_librosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_librosActionPerformed
     new Libros().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_btn_librosActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
     new Clientes().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_db_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_db_libroActionPerformed
    admin.CrearL();
    }//GEN-LAST:event_btn_db_libroActionPerformed

    private void btn_db_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_db_clientesActionPerformed
    admin.CrearC();
    }//GEN-LAST:event_btn_db_clientesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_db_clientes;
    private javax.swing.JButton btn_db_libro;
    private javax.swing.JButton btn_libros;
    private javax.swing.JLabel jinicio;
    // End of variables declaration//GEN-END:variables
}
