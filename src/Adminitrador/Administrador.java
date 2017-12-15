/* Autor @Javifast */
package Adminitrador;

import biblioteca.Coneccion; // importamos la conexion creada en la clase Coneccion del paquete biblioteca
import java.awt.HeadlessException; // importamos la clase HeadlessException
import java.sql.*; // importamos el paquete sql con todos sus metodos y clases para gestionar las consultas en nuestra base de datos
import javax.swing.JOptionPane; // importamos la clase joptionpane para generar ventanas de mensajes
import javax.swing.table.DefaultTableModel; // importamos el metodo defaultablemodel para diseñar nuestras tablas

public class Administrador {

    static Connection cn; // inicializamos una variable llamada cn statica con el metodo Connection 
    static Statement s; // inicializamos una variable llamada s statica con el metodo Statement
    static ResultSet rs; // inicializamos una variable llamada rs statica con el metodo ResulSet
    DefaultTableModel modeloL = new DefaultTableModel(); // inicializamos un constructor llamado modeloL con el metodo defaulttablemodel
    DefaultTableModel modeloC = new DefaultTableModel(); // inicializamos un constructor llamado modeloC con el metodo defaulttablemodel
    String SQL; // inicializamos una variable llamada SQL de tipo String
    int CanColumns; // inicalizamos una variable llamada CanColums de tipo int; 
    ResultSetMetaData rsmd; // inicializamos una variable llamada rsmd de tipo ResultSetMetaData;
/* CLASES QUE INTERACUAN CON LA TABLA LIBROS */
    public void CrearL() { // metodo para crear la tabla libros
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement(); // primero almacenamos en la variable s el metodo createStatement de la variable cn
            SQL = "CREATE TABLE libros(id INT PRIMARY KEY AUTOINCREMENT NOT NULL,nombre VARCHAR NULL,autor VARCHAR  NULL);"; // almacenamos
            // la sentencia sql en la variable SQL para poder ser utilizada
            s.executeUpdate(SQL); // y ejecutamos el metodo executeUpdate + sentencia sql 
            // si todo sale correctamente creariamos una tabla con los parametros mecionados
            s.close(); // ahora finalizamos la la declaracion con el metodo .close
            cn.close();// y finalizamos la conecion con la db con el metodo .close
            JOptionPane.showMessageDialog(null, "Tabla Libros Creada");
        } // si todo salio correcto imprimimos un mensaje emergente
        catch (HeadlessException | SQLException error) {// en caso de ocurrir un error
            JOptionPane.showMessageDialog(null, "Error al Cargar la lista Clientes " + error);
            // imprimimos un mensaje alertando el codigo del error
        }
    }

    public DefaultTableModel listaL() { //metodo para llenar la tabla libro que se mostrara en el jpanel libros
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement();  // almacenamos en la variable s el metodo createStatement de la variable cn
            SQL = "select * from LIBROS WHERE id>0"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
            rs = s.executeQuery(SQL); // ejecutamos el metodo executeUpdate + sentencia sql y la almacenamos en la variable rs
            rsmd = rs.getMetaData(); // ejecutamos el metodo getMetaData y la almacenamos el resultado en la variable rsmd
            CanColumns = rsmd.getColumnCount(); // obtenemos el tamaño de las columnas con el metodo .getColumCount y lo almacenamos
            // en la variable CanColums
            for (int i = 1; i <= CanColumns; i++) { // para llenar nuestra tabla nos apoyaremos por un ciclo for donde intanciamos un int llamado i
                // con la condicion de que i sea menor o igual a la variable CanConlums y con el incrementador i++
                modeloL.addColumn(rsmd.getColumnLabel(i));
            } // minetras el ciclo continue se se agregara al objeto modeloL la columna correspondiente
            while (rs.next()) {  // tambien crearemos un while donde 
                Object[] fila = new Object[CanColumns]; // crearemos un objeto de tipo array llamado fila con la dimension de Cancolumns
                for (int i = 0; i < CanColumns; i++) { // crearemos otro for para esta vez imprimir las filas
                    fila[i] = rs.getObject(i + 1); // mientras continue el ciclo fila[i] sera igual al objeto re i+1
                }
                modeloL.addRow(fila); // ademas iremos agregando las filas con el metodo addRow
            }
            s.close(); // finalizamos el Statement
            cn.close(); // cerramos la conexion
        } catch (HeadlessException | SQLException error) { // instanciamos una exception en caso de ocurrir un error que sera mostrar
            JOptionPane.showMessageDialog(null, "Error al Cargar la lista Libros " + error); // una ventana emergente con un mensaje de error
        } // mas la informacion del error

        return modeloL; // retornamos el objeto modeloL
    }

    public void AgregarConsultaL(int id, String nombre, String autor) { // este metodo pide parametros de ingreso al momento de ejecutarse
        try { // generamos un try-catch para manejar los posibles errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement();   // almacenamos en la variable s el metodo createStatement de la variable cn                                              
            SQL = "INSERT INTO libros (id,nombre,autor) "
                    + "VALUES ('" + id + "','" + nombre + "','" + autor + "')"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
            s.executeUpdate(SQL); // ejecutamos el metodo executeUpdate + sentencia sql 
            s.close(); // finalizamos el  Statement
            cn.close(); // cerramos la conexion
            JOptionPane.showMessageDialog(null, "AGREGADO"); // si el procedimiento se realiza correctamente mostramos el mensaje
        } catch (HeadlessException | SQLException error) { // instanciamos una exception en caso de ocurrir un error que sera mostrar
            JOptionPane.showMessageDialog(null, "No se a podido agregar" + error);// una ventana emergente con un mensaje de error
        } // mas la informacion del error
    }

    public void EliminarConsultaL(int id) {  // este metodo pide parametros de ingreso al momento de ejecutarse
        try { // generamos un try-catch para manejar los posibles errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement(); // almacenamos en la variable s el metodo createStatement de la variable cn    
            SQL = "DELETE FROM libros WHERE id=" + id + ""; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
            s.executeUpdate(SQL); // ejecutamos el metodo executeUpdate + sentencia sql 
            s.close();  // finalizamos el  Statement
            cn.close(); // cerramos la conexion
            JOptionPane.showMessageDialog(null, "ELIMINADO"); // si el procedimiento se realiza correctamente mostramos el mensaje
        } catch (HeadlessException | SQLException error) { // instanciamos una exception en caso de ocurrir un error que sera mostrar
            JOptionPane.showMessageDialog(null, "No se a podido eliminar " + error);// una ventana emergente con un mensaje de error
        } // mas la informacion del error
    }

    public void ModificarConsultaL(int id, String nombre, String autor) {
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement(); // almacenamos en la variable s el metodo createStatement de la variable cn    
            SQL = "UPDATE libros SET nombre='" + nombre + "',autor='" + autor + "' WHERE id='" + id + "';"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
            s.executeUpdate(SQL); // ejecutamos el metodo executeUpdate + sentencia sql 
            s.close(); // finalizamos el  Statement
            cn.close(); // cerramos la conexion
            JOptionPane.showMessageDialog(null, "MODIFICADO"); // si el procedimiento se realiza correctamente mostramos el mensaje
        } catch (HeadlessException | SQLException error) { // instanciamos una exception en caso de ocurrir un error que sera mostrar
            JOptionPane.showMessageDialog(null, "Dato repetido o invalido " + error);// una ventana emergente con un mensaje de error
        } // mas la informacion del error
    }

    /* CLASES QUE INTERACUAN CON LA TABLA CLIENTES */
    public void CrearC() { // metodo para crear la tabla libros
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement(); // almacenamos en la variable s el metodo createStatement de la variable cn    
            SQL = "CREATE TABLE clientes " + " (id INT PRIMARY KEY AUTOINCREMENT NOT NULL,nombre VARCHAR NULL,"
                    + "apellido VARCHAR NULL,rut VARCHAR UNIQUE NULL,edad  VARCHAR NULL);"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
            s.executeUpdate(SQL); // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
            s.close(); // finalizamos el  Statement
            cn.close(); // cerramos la conexion
            JOptionPane.showMessageDialog(null, "Tabla Clientes Creada"); // si el procedimiento se realiza correctamente mostramos el mensaje
        } catch (HeadlessException | SQLException error) { // instanciamos una exception en caso de ocurrir un error que sera mostrar
            JOptionPane.showMessageDialog(null, "ya esta creada " + error);// una ventana emergente con un mensaje de error
        } // mas la informacion del error
    }

    public DefaultTableModel listaC() {
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement(); // almacenamos en la variable s el metodo createStatement de la variable cn    
            SQL = "select * from clientes WHERE id>0;"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
            rs = s.executeQuery(SQL); // ejecutamos el metodo executeUpdate + sentencia sql y la almacenamos en la variable rs
            rsmd = rs.getMetaData(); // ejecutamos el metodo getMetaData y la almacenamos el resultado en la variable rsmd
            CanColumns = rsmd.getColumnCount();// obtenemos el tamaño de las columnas con el metodo .getColumCount y lo almacenamos
            // en la variable CanColums
            for (int i = 1; i <= CanColumns; i++) { // para llenar nuestra tabla nos apoyaremos por un ciclo for donde intanciamos un int llamado i
                // con la condicion de que i sea menor o igual a la variable CanConlums y con el incrementador i++
                modeloC.addColumn(rsmd.getColumnLabel(i));
            }// minetras el ciclo continue se se agregara al objeto modeloC la columna correspondiente
            while (rs.next()) { // tambien crearemos un while donde 
                Object[] fila = new Object[CanColumns]; // crearemos un objeto de tipo array llamado fila con la dimension de Cancolumns
                for (int i = 0; i < CanColumns; i++) { // crearemos otro for para esta vez imprimir las filas
                    fila[i] = rs.getObject(i + 1); // mientras continue el ciclo fila[i] sera igual al objeto re i+1
                }
                modeloC.addRow(fila); // ademas iremos agregando las filas con el metodo addRow
            }
            s.close(); // finalizamos el Statement
            cn.close(); // cerramos la conexion
        } catch (HeadlessException | SQLException error) {
            JOptionPane.showMessageDialog(null, "Error al Cargar la lista Clientes " + error);// una ventana emergente con un mensaje de error
        } // mas la informacion del error

        return modeloC; // retornamos el objeto modeloC

    }

    public void AgregarConsultaC(int id, String nombre, String apellido, String rut, String edad) {
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement();  // almacenamos en la variable s el metodo createStatement de la variable cn            
            SQL = "INSERT INTO clientes (id,nombre,apellido,rut,edad) " // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
                    + "VALUES ('" + id + "','" + nombre + "','" + apellido + "','" + rut + "','" + edad + "')";
            s.executeUpdate(SQL);// ejecutamos el metodo executeUpdate + sentencia sql 
            s.close(); // finalizamos el  Statement
            cn.close(); // cerramos la conexion
            JOptionPane.showMessageDialog(null, "AGREGADO"); // si el procedimiento se realiza correctamente mostramos el mensaje
        } catch (HeadlessException | SQLException error) { // instanciamos una exception en caso de ocurrir un error que sera mostrar
            JOptionPane.showMessageDialog(null, "No se a podido agregar " + error);// una ventana emergente con un mensaje de error
        } // mas la informacion del error
    }

    public void EliminarConsultaC(int id) { // este metodo pide parametros de ingreso al momento de ejecutarse
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement(); // almacenamos en la variable s el metodo createStatement de la variable cn    
            SQL = "DELETE FROM clientes WHERE id=" + id + ";"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
            s.executeUpdate(SQL); // ejecutamos el metodo executeUpdate + sentencia sql 
            s.close();  // finalizamos el  Statement
            cn.close(); // cerramos la conexion
            JOptionPane.showMessageDialog(null, "ELIMINADO"); // si el procedimiento se realiza correctamente mostramos el mensaje
        } catch (HeadlessException | SQLException error) { // instanciamos una exception en caso de ocurrir un error que sera mostrar
            JOptionPane.showMessageDialog(null, "No se a podido eliminar " + error);// una ventana emergente con un mensaje de error
        } // mas la informacion del error
    }

    public void ModificarConsultaC(int id, String nombre, String apellido, String rut, String edad) {
        try { // realizamos un try-catch para controlar los errores
            cn = Coneccion.Enlace(cn);  // almacenamos el metodo enlace en la variable cn
            s = cn.createStatement(); // almacenamos en la variable s el metodo createStatement de la variable cn    
            SQL = "UPDATE clientes SET nombre='" + nombre + "',apellido='" + apellido + "',rut='"
                    + rut + "',edad='" + edad + "' WHERE id='" + id + "';"; // almacenamos la sentencia sql en la variable SQL para poder ser utilizada
            s.executeUpdate(SQL); // ejecutamos el metodo executeUpdate + sentencia sql 
            s.close(); // finalizamos el  Statement
            cn.close(); // cerramos la conexion
            JOptionPane.showMessageDialog(null, "MODIFICADO"); // si el procedimiento se realiza correctamente mostramos el mensaje
        } catch (HeadlessException | SQLException error) { // instanciamos una exception en caso de ocurrir un error que sera mostrar
            JOptionPane.showMessageDialog(null, "Dato repetido o invalido " + error);// una ventana emergente con un mensaje de error
        } // mas la informacion del error

    }
}
