/* Autor @Javifast */
package biblioteca;

import java.sql.*;
import javax.swing.JOptionPane;

public class Coneccion {

    static Connection cn = null; //se genera una variable estatica para almacenar la conexion 

    public static Connection Enlace(Connection cn) throws SQLException { // se crea metodo statico llamado conection y se inicializa la excepcion
        // SQLException
        try { // se intancia la conexion en una base de datos sqlite dentro de un try/catch para manejar excepciones
            Class.forName("org.sqlite.JDBC"); // se llama la clase del paquete sql
            String ruta = "db/Biblioteca.sqlite"; // ubicacion de la carpeta del proyecto
            cn = DriverManager.getConnection("jdbc:sqlite:" + ruta);  // se genera la conexion agregando +ruta      
        } catch (ClassNotFoundException e) {  // se maneja la excepcion clase no encontrada                                 
            JOptionPane.showMessageDialog(null, e); // proyecta codigo de error correspondiente
        }
        return cn; // retorna la conexion cn, ya sea null (por defecto) o la ruta declarada
    }

}
