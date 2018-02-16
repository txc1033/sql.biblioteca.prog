package com.javifast.service;

import com.javifast.controller.Coneccion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class BibliotecaServicio {

    DefaultTableModel modelo = new DefaultTableModel();
    static Connection cn;
    static Statement s;
    static ResultSet rs;
    int CanColumns;
    ResultSetMetaData rsmd;

    public void crearTabla() {
        try {
            String tablaLibro, tablaCliente;
            tablaLibro = "CREATE TABLE `libros` (`id` int(3) NOT NULL AUTO_INCREMENT,`nombre` varchar(60) NOT NULL,`autor` varchar(40) NOT NULL,"
                    + "  UNIQUE KEY `id` (`id`));";
            tablaCliente = "CREATE TABLE `clientes` (`id` int(3) NOT NULL AUTO_INCREMENT,`nombre` varchar(60) NOT NULL,`apellido` varchar(60) NOT NULL,"
                    + "`rut` varchar(12) NOT NULL,`edad` int(3) NOT NULL,PRIMARY KEY (`id`),UNIQUE KEY `rut` (`rut`));";
            cn = Coneccion.Enlace(cn);s = cn.createStatement();s.execute(tablaLibro);s.execute(tablaCliente);s.close();cn.close();
        } catch (SQLException error) {
            System.out.println("Error " + error.getMessage());
        }
    }

    public int ejecutarSentencia(String sql) throws SQLException {
        int retorno = 0;
        try {
            cn = Coneccion.Enlace(cn);
            s = cn.createStatement();
            if (true == s.execute(sql)) {
                retorno = 1;
            } else {
                retorno = 2;
            }
        } catch (HeadlessException | SQLException error) {
            System.out.println("Error " + error.getMessage());
        }
        sql = null;
        s.close();
        cn.close();
        return retorno;
    }

    public DefaultTableModel listaTabla(int tabla) throws SQLException {
        try {
            String sql;
            if (tabla == 1) {
                sql = "select * from libros WHERE id>0";
            } else {
                sql = "select * from clientes WHERE id>0;";
            }
            cn = Coneccion.Enlace(cn);s = cn.createStatement();rs = s.executeQuery(sql);rsmd = rs.getMetaData();CanColumns = rsmd.getColumnCount();
            for (int i = 1; i <= CanColumns; i++) {
                modelo.addColumn(rsmd.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[CanColumns];
                for (int i = 0; i < CanColumns; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            s.close();cn.close();
        } catch (HeadlessException | SQLException error) {
            System.out.println("Error " + error.getMessage());
        }
        return modelo;
    }

}
