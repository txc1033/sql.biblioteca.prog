/* Autor @Javifast | @Txc1033 */
package Adminitrador;

import biblioteca.Coneccion; // importamos la conexion creada en la clase Coneccion del paquete biblioteca
import java.awt.HeadlessException; // importamos la clase HeadlessException
import java.sql.*; // importamos el paquete sql con todos sus metodos y clases para gestionar las consultas en nuestra base de datos
import javax.swing.JOptionPane; // importamos la clase joptionpane para generar ventanas de mensajes
import static javax.swing.JOptionPane.*;
import javax.swing.table.DefaultTableModel; // importamos el metodo defaultablemodel para diseñar nuestras tablas

public class Administrador {

    static Connection cn; // inicializamos una variable llamada cn statica con el metodo Connection 
    static Statement s; // inicializamos una variable llamada s statica con el metodo Statement
    static ResultSet rs; // inicializamos una variable llamada rs statica con el metodo ResulSet
    DefaultTableModel modelo = new DefaultTableModel(); // inicializamos un constructor llamado modelo con el metodo defaulttablemodel
    String SQL; // inicializamos una variable llamada SQL de tipo String
    int CanColumns, resultado; // inicalizamos una variable llamada CanColums y resultado de tipo int; 
    ResultSetMetaData rsmd; // inicializamos una variable llamada rsmd de tipo ResultSetMetaData;

    /*----------------------------------------------CLASES QUE INTERACUAN CON LA TABLA LIBROS-------------------------------------------------*/
    public void CrearL() throws SQLException { // metodo para crear la tabla libros
        SQL = "CREATE TABLE libros(id INT PRIMARY KEY AUTOINCREMENT NOT NULL,nombre VARCHAR NULL,autor VARCHAR  NULL);";
        // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
        resultado = this.sentencia_sql(SQL); // almacenamos el valor de retorno en la variable resultado
        if (resultado == 2) { // creamos sentencia if la cual dice si resultado es igual a 2 entonces
            JOptionPane.showMessageDialog(null, "Tabla Libros Creada", "Sentencia SQL", PLAIN_MESSAGE, null);
            // imprimimos un mensaje emergente
        }
    }

    public void AgregarConsultaL(int id, String nombre, String autor) throws SQLException {
        // este metodo pide parametros de ingreso al momento de ejecutarse
        SQL = "INSERT INTO libros (id,nombre,autor) "
                + "VALUES ('" + id + "','" + nombre + "','" + autor + "')";
        // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
        resultado = this.sentencia_sql(SQL);  // almacenamos el valor de retorno en la variable resultado
        if (resultado == 2) { // creamos sentencia if la cual dice si resultado es igual a 2 entonces
            JOptionPane.showMessageDialog(null, "AGREGADO", "Sentencia SQL", PLAIN_MESSAGE, null);
            // imprimimos un mensaje emergente
        }
    }

    public void EliminarConsultaL(int id) throws SQLException {  // este metodo pide parametros de ingreso al momento de ejecutarse 
        SQL = "DELETE FROM libros WHERE id=" + id + ""; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
        resultado = this.sentencia_sql(SQL); // almacenamos el valor de retorno en la variable resultado
        if (resultado == 2) { // creamos sentencia if la cual dice si resultado es igual a 2 entonces
            JOptionPane.showMessageDialog(null, "ELIMINADO", "Sentencia SQL", PLAIN_MESSAGE, null);
            // imprimimos un mensaje emergente
        }
    }

    public void ModificarConsultaL(int id, String nombre, String autor) throws SQLException {
        // este metodo pide parametros de ingreso al momento de ejecutarse 
        SQL = "UPDATE libros SET nombre='" + nombre + "',autor='" + autor + "' WHERE id='" + id + "';";
        // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
        resultado = this.sentencia_sql(SQL); // almacenamos el valor de retorno en la variable resultado
        if (resultado == 2) { // creamos sentencia if la cual dice si resultado es igual a 2 entonces
            JOptionPane.showMessageDialog(null, "MODIFICADO", "Sentencia SQL", PLAIN_MESSAGE, null);
            // imprimimos un mensaje emergente
        }
    }

    /*----------------------------------------------METODOS QUE INTERACUAN CON LA TABLA CLIENTES----------------------------------------------*/
    public void CrearC() throws SQLException { // metodo para crear la tabla libros         
        SQL = "CREATE TABLE clientes " + " (id INT PRIMARY KEY AUTOINCREMENT NOT NULL,nombre VARCHAR NULL,"
                + "apellido VARCHAR NULL,rut VARCHAR UNIQUE NULL,edad  VARCHAR NULL);";
        // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
        resultado = this.sentencia_sql(SQL); // almacenamos el valor de retorno en la variable resultado
        if (resultado == 2) { // creamos sentencia if la cual dice si resultado es igual a 2 entonces
            JOptionPane.showMessageDialog(null, "Tabla Clientes Creada", "Sentencia SQL", PLAIN_MESSAGE, null);
            // imprimimos un mensaje emergente
        }
    }

    public void AgregarConsultaC(int id, String nombre, String apellido, String rut, String edad) throws SQLException {
        SQL = "INSERT INTO clientes (id,nombre,apellido,rut,edad) "
                + "VALUES ('" + id + "','" + nombre + "','" + apellido + "','" + rut + "','" + edad + "')";
        // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
        int resultado = this.sentencia_sql(SQL);
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "AGREGADO", "Sentencia SQL", PLAIN_MESSAGE, null);
            // si el procedimiento se realiza correctamente mostramos el mensaje
        }
    }

    public void EliminarConsultaC(int id) throws SQLException { // este metodo pide parametros de ingreso al momento de ejecutarse
        SQL = "DELETE FROM clientes WHERE id=" + id + ";"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
        int resultado = this.sentencia_sql(SQL);
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "ELIMINADO", "Sentencia SQL", PLAIN_MESSAGE, null);
        }
    }

    public void ModificarConsultaC(int id, String nombre, String apellido, String rut, String edad) throws SQLException {
        SQL = "UPDATE clientes SET nombre='" + nombre + "',apellido='" + apellido + "',rut='"
                + rut + "',edad='" + edad + "' WHERE id='" + id + "';";
        // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
        int resultado = this.sentencia_sql(SQL);
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "MODIFICADO"); // si el procedimiento se realiza correctamente mostramos el mensaje
        }

    }

    /*----------------------------------------------METODO QUE INTERACTUA CON LA TABLA LIBROS Y CLIENTE---------------------------------------*/

    public DefaultTableModel listar_tabla(String tabla) { // unificamos los metodos listaC y listaL en un solo metodo
        switch (tabla) {
            case "libros":
                SQL = "select * from LIBROS WHERE id>0"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
                break;
            case "clientes":
                SQL = "select * from clientes WHERE id>0;"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
                break;
        }
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement(); // almacenamos en la variable s el metodo createStatement de la variable cn    
            rs = s.executeQuery(SQL); // ejecutamos el metodo executeUpdate + sentencia sql y la almacenamos en la variable rs
            rsmd = rs.getMetaData(); // ejecutamos el metodo getMetaData y la almacenamos el resultado en la variable rsmd
            CanColumns = rsmd.getColumnCount();// obtenemos el tamaño de las columnas con el metodo .getColumCount y lo almacenamos
            // en la variable CanColums
            for (int i = 1; i <= CanColumns; i++) { // para llenar nuestra tabla nos apoyaremos por un ciclo for donde intanciamos un int llamado i
                // con la condicion de que i sea menor o igual a la variable CanConlums y con el incrementador i++
                modelo.addColumn(rsmd.getColumnLabel(i));
            }// minetras el ciclo continue se se agregara al objeto modeloC la columna correspondiente
            while (rs.next()) { // tambien crearemos un while donde 
                Object[] fila = new Object[CanColumns]; // crearemos un objeto de tipo array llamado fila con la dimension de Cancolumns
                for (int i = 0; i < CanColumns; i++) { // crearemos otro for para esta vez imprimir las filas
                    fila[i] = rs.getObject(i + 1); // mientras continue el ciclo fila[i] sera igual al objeto re i+1
                }
                modelo.addRow(fila); // ademas iremos agregando las filas con el metodo addRow
            }
            s.close(); // finalizamos el Statement
            cn.close(); // cerramos la conexion
        } catch (HeadlessException | SQLException error) { // en caso de error
            System.out.println(error); // imprimiremos un mensaje por consola
        }
        return modelo; // retornamos el objeto modelo
    }

    public int sentencia_sql(String cadena) throws SQLException {
        int retorno = 0; // inicializamos la variable que retorna con valor 0 por defecto
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement(); // almacenamos en la variable s el metodo createStatement de la variable cn                
            if (true == s.execute(cadena)) { // generamos un if al momento de ejecutar la sentencia si es verdadero
                retorno = 1; // la variable retorno es igual a 1
            } else { // en caso que no se cumpla la sentencia if
                retorno = 2; // la variable retorno es igual a 2
            }
        } catch (HeadlessException | SQLException error) {// en caso de ocurrir un error
            JOptionPane.showMessageDialog(null, "Error " + error.getMessage(), "Sentencia SQL", ERROR_MESSAGE, null);
            // imprimimos un mensaje alertando el codigo del error con el metodo getMessage();
        }
        cadena = null; // limpiamos la variable string opcional
        s.close(); // finalizamos el  Statement
        cn.close(); // cerramos la conexion
        return retorno; // retornamos el valor de tipo int
    }
}
