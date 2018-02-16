
package com.javifast.repository;

import com.javifast.models.Libro;
import com.javifast.service.BibliotecaServicio;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;


public class LibroDaoImpl implements LibroDao {

    BibliotecaServicio biblioteca = new BibliotecaServicio();
    String sql ,accion;
    int resultado;
    
    public String llamarSentencia(String accion, Libro libro) throws SQLException{
            switch(accion){
                case "agregar":
                sql = "INSERT INTO libros (nombre,autor) "+ "VALUES ('"+libro.getNombre()
                    +"','"+libro.getAutor()+"')";
                break;
                case "modificar":
                sql = "UPDATE libros SET nombre='" + libro.getNombre() + "',autor='" + libro.getAutor() 
                + "' WHERE id='" + libro.getId() + "';";
                break;
                case "eliminar":
                sql = "DELETE FROM libros WHERE id=" + libro.getId() + "";
                break;
            }
            return sql;
        }
        


    @Override
    public void agregarDato(Libro libro) throws SQLException {
        sql = this.llamarSentencia("agregar", libro);
        resultado = biblioteca.ejecutarSentencia(sql);
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "AGREGADO", "Sentencia SQL", PLAIN_MESSAGE, null);
        }
    }

    @Override
    public void modificarDato(Libro libro) throws SQLException {
        sql = this.llamarSentencia("modificar", libro);
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "MODIFICADO");
        }
    }

    @Override
    public void eliminarDato(Libro libro) throws SQLException {
        sql = this.llamarSentencia("eliminar", libro);
        resultado = biblioteca.ejecutarSentencia(sql);
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "ELIMINADO", "Sentencia SQL", PLAIN_MESSAGE, null);
        }
    }

    
}
