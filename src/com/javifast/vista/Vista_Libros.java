/* Autor @Javifast */
package com.javifast.vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.javifast.controller.Administrador;
import com.javifast.models.Libro;
import com.javifast.service.BibliotecaServicio;
import java.sql.SQLException;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.UIManager;

public class Vista_Libros extends javax.swing.JFrame {

    private Administrador admin = new Administrador();
    private Libro libro = new Libro();
    private final int opcion = 1;

    public Vista_Libros() {
        this.setLocationRelativeTo(null);
        initComponents();
        try {
            DatosTabla();
            jtxt_id.setText(String.valueOf(jtable_libro.getRowCount() + 1));
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception error) {
            System.out.println("Error en Vista Libro: " + error.getMessage());
        }
    }

    public void DatosTabla() throws SQLException {
        DefaultTableModel model;
        BibliotecaServicio biblioteca = new BibliotecaServicio();
        model = biblioteca.listaTabla(opcion);
        jtable_libro.setModel(model);
    }

    public Libro obtenerDatos() {
        libro.setId(Integer.parseInt(jtxt_id.getText()));
        libro.setNombre(jtxt_nombre.getText());
        libro.setAutor(jtxt_autor.getText());
        return libro;
    }

    public void Agregar() throws SQLException {
        mensaje(admin.agregarLibro(obtenerDatos()), "Agregado");
    }

    public void Eliminar() throws SQLException {
        mensaje(admin.eliminarLibro(obtenerDatos()), "Eliminado");
    }

    public void Modificar() throws SQLException {
        mensaje(admin.modificarLibro(obtenerDatos()), "Modificado");
    }

    public void mensaje(int resultado, String accion) {
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, accion, "Sentencia SQL", PLAIN_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(null, "Error", "Sentencia SQL", PLAIN_MESSAGE, null);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScroll = new javax.swing.JScrollPane();
        jtable_libro = new javax.swing.JTable();
        jLab_id = new javax.swing.JLabel();
        jLab_nombre = new javax.swing.JLabel();
        jLab_autor = new javax.swing.JLabel();
        jLab_libros = new javax.swing.JLabel();
        jtxt_id = new javax.swing.JTextField();
        jtxt_nombre = new javax.swing.JTextField();
        jtxt_autor = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jtable_libro.setModel(new javax.swing.table.DefaultTableModel(
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
        jtable_libro.setFocusable(false);
        jtable_libro.setRequestFocusEnabled(false);
        jtable_libro.getTableHeader().setReorderingAllowed(false);
        jtable_libro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtable_libroMouseClicked(evt);
            }
        });
        jScroll.setViewportView(jtable_libro);

        jLab_id.setText("ID:");

        jLab_nombre.setText("NOMBRE:");

        jLab_autor.setText("AUTOR:");

        jLab_libros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLab_libros.setText("LIBROS");

        jtxt_id.setEditable(false);
        jtxt_id.setFocusable(false);
        jtxt_id.setRequestFocusEnabled(false);

        jtxt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_nombreActionPerformed(evt);
            }
        });

        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_regresar.setText("REGRESAR");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScroll)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLab_nombre)
                                    .addComponent(jLab_id))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtxt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(206, 206, 206))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtxt_nombre)
                                        .addGap(21, 21, 21)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_autor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxt_autor, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLab_libros, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_id)
                    .addComponent(jtxt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(jLab_nombre)
                    .addComponent(jtxt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar)
                    .addComponent(jLab_autor)
                    .addComponent(jtxt_autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLab_libros)
                            .addComponent(btn_regresar))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtable_libroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable_libroMouseClicked
        this.jtable_libro.getModel();
        int fila = jtable_libro.getSelectedRow();
        if (fila == -1) {
            System.out.println("Tabla no ha sido cargada!");
        } else {
            jtxt_id.setText(String.valueOf(jtable_libro.getValueAt(fila, 0)));
            jtxt_nombre.setText(String.valueOf(jtable_libro.getValueAt(fila, 1)));
            jtxt_autor.setText(String.valueOf(jtable_libro.getValueAt(fila, 2)));
        }
    }//GEN-LAST:event_jtable_libroMouseClicked

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        try {
            Agregar();
            DatosTabla();
        } catch (Exception error) {
            System.out.println("Error en Vista Libro: " + error.getMessage());
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
            Eliminar();
            DatosTabla();
        } catch (Exception error) {
            System.out.println("Error en Vista Libro: " + error.getMessage());
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        try {
            Modificar();
            DatosTabla();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        new Vista_Inicial().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        try {
            DatosTabla();
        } catch (Exception error) {
            System.out.println("Error en Vista Libro: " + error.getMessage());
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void jtxt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_nombreActionPerformed

    }//GEN-LAST:event_jtxt_nombreActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Vista_Libros().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JLabel jLab_autor;
    private javax.swing.JLabel jLab_id;
    private javax.swing.JLabel jLab_libros;
    private javax.swing.JLabel jLab_nombre;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JTable jtable_libro;
    private javax.swing.JTextField jtxt_autor;
    private javax.swing.JTextField jtxt_id;
    private javax.swing.JTextField jtxt_nombre;
    // End of variables declaration//GEN-END:variables
}
