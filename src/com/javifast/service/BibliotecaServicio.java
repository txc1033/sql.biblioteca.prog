package com.javifast.service;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import com.javifast.controller.Connect;
import com.javifast.models.Cliente;
import com.javifast.models.Libro;
import com.javifast.repository.ClienteDaoImpl;
import com.javifast.repository.LibroDaoImpl;

public class BibliotecaServicio {

    private static Connection conection;
    private static Statement statement;
    private static ResultSet resultSet;
    private ResultSetMetaData resultMetaData;
    private String sql;

    public void crearTabla() throws SQLException {
        sql = "crear";
        if (ejecutarSentenciaAnonima(sql, 1) + ejecutarSentenciaAnonima(sql, 2) == 4) {
            System.out.println("Tablas Libros y Clientes creadas correctamente!");
        }
    }

    public DefaultTableModel listaTabla(int opcion) throws SQLException {
        int columnas;
        sql = "seleccionar";
        if (opcion == 1) {
            columnas = ejecutarSentenciaAnonima(sql, opcion);
        } else {
            columnas = ejecutarSentenciaAnonima(sql, opcion);
        }
        DefaultTableModel model = llenarTabla(columnas);
        return model;
    }

        public DefaultTableModel llenarTabla(int columnas) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            for (int i = 1; i <= columnas; i++) {
                model.addColumn(resultMetaData.getColumnLabel(i));
            }
            while (resultSet.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                model.addRow(fila);
            }
            statement.close();
            conection.close();
        } catch (HeadlessException | SQLException error) {
            System.out.println("Error en Lista Tabla: " + error.getMessage());
        }
        return model;
    }
    
    public int ejecutarSentencia(String sql) throws SQLException {
        int resultado = 0;
        try {
            conection = Connect.Enlace(conection);
            statement = conection.createStatement();
            resultado = (true == statement.execute(sql)) ? 1 : 2;
            if (sql.length() == 31 || sql.length() == 34) {
                resultSet = statement.executeQuery(sql);
                resultMetaData = resultSet.getMetaData();
                return resultMetaData.getColumnCount();
            }
        } catch (HeadlessException | SQLException error) {
            System.out.println("Error en Ejecutar Sentencia: " + error.getMessage()+" n°: "+ resultado);
        }
        sql = null;
        statement.close();
        conection.close();
        return resultado;
    }

    public int ejecutarSentenciaAnonima(String sql, int opcion) throws SQLException {
        LibroDaoImpl libroImpl = new LibroDaoImpl();
        ClienteDaoImpl clienteImpl = new ClienteDaoImpl();
        Libro libro = new Libro("JavierMS");
        Cliente cliente = new Cliente();
        if (opcion == 1) {
            return ejecutarSentencia(libroImpl.llamarSentencia(sql, libro));
        } else {
            return ejecutarSentencia(clienteImpl.llamarSentencia(sql, cliente));
        }
    }
}
