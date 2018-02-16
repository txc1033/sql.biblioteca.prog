/* Autor @Javifast | @Txc1033 */
package com.javifast.controller;

import java.sql.*;  // importamos las clases del paquete sql
import javax.swing.JOptionPane; // importamos la clase JOptionPane

public class Coneccion {

    static Connection cn = null; //se genera una variable estatica para almacenar la conexion 

    public static Connection Enlace(Connection cn) throws SQLException { // se crea metodo statico llamado conection y se inicializa 
        //la excepcion SQLException
        try { // se intancia la conexion en una base de datos sqlite dentro de un try/catch para manejar excepciones
            Class.forName("com.mysql.jdbc.Driver"); // se llama la clase del paquete sql
            cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblioteca?&useSSL=false", "test", "12345");  // se genera la conexion agregando +ruta      
        } catch (ClassNotFoundException e) {  // se maneja la excepcion clase no encontrada                                 
            JOptionPane.showMessageDialog(null, e); // proyecta codigo de error correspondiente
        }
        return cn; // retorna la conexion cn, ya sea null (por defecto) o la ruta declarada
    }

}

/*                              en caso de querer usar sqlite recordar exportar la libreria  sqlite-jdbc-3.8.11.2.jar
    public static Connection Enlace(Connection cn) throws SQLException { // se crea metodo statico llamado conection y se inicializa 
        //la excepcion SQLException
        try { // se intancia la conexion en una base de datos sqlite dentro de un try/catch para manejar excepciones
            Class.forName("org.sqlite.JDBC"); // se llama la clase del paquete sql
            String ruta = "db/Biblioteca.sqlite"; // ubicacion de la carpeta del proyecto
            cn = DriverManager.getConnection("jdbc:sqlite:" + ruta);  // se genera la conexion agregando +ruta      
        } catch (ClassNotFoundException e) {  // se maneja la excepcion clase no encontrada                                 
            JOptionPane.showMessageDialog(null, e); // proyecta codigo de error correspondiente
        }
        return cn; // retorna la conexion cn, ya sea null (por defecto) o la ruta declarada
    }
*/
