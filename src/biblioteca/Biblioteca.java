/* Autor @Javifast | @Txc1033 */
package biblioteca;

import java.sql.*; // importamos las clases del paquete sql
import javax.swing.JOptionPane; // importamos la clase JOptionPane

public class Biblioteca {

    static Connection cn = null; // inicializamos una variable estatico de tipo Connection llamada cn con un valor de null

    public static Connection Enlace(Connection cn) throws SQLException { // creamos un metodo llamado Enlace que retorne un valor estatico
        // de tipo conection
      

        try { // generamos un try-catch para manejar los errores
            Class.forName("org.sqlite.JDBC"); // llamamos al metodo forName con el parametro del tipo de database a manejar en este caso
            // sera sqlite
            cn = DriverManager.getConnection("jdbc:sqlite:Biblioteca.sqlite"); // almacenamos el metodo getConnection en la variable cn 
            // mas el parametro de coneccion
        } catch (ClassNotFoundException e) { // en caso de ocurrir un error
            JOptionPane.showMessageDialog(null, e); // mostraremos en un joption el error
        }
        return cn; // y retornamos el valor de cn
    }

}
