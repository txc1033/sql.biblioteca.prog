package com.javifast.repository;

import com.javifast.models.Libro;
import com.javifast.service.BibliotecaServicio;
import java.sql.SQLException;

public class LibroDaoImpl implements LibroDao {

    BibliotecaServicio biblioteca = new BibliotecaServicio();
    String sql;

    @Override
    public int agregarDato(Libro libro) throws SQLException {
        sql = this.llamarSentencia("agregar", libro);
        return biblioteca.ejecutarSentencia(sql);
    }

    @Override
    public int modificarDato(Libro libro) throws SQLException {
        sql = this.llamarSentencia("modificar", libro);
        return biblioteca.ejecutarSentencia(sql);
    }

    @Override
    public int eliminarDato(Libro libro) throws SQLException {
        sql = this.llamarSentencia("eliminar", libro);
        return biblioteca.ejecutarSentencia(sql);
    }

    public String llamarSentencia(String accion, Libro libro) throws SQLException {
        if (libro.getNombre().isEmpty()) {
            if(accion!="crear"||accion!="seleccionar"){
            accion = "nulo";
            }
        }
        switch (accion) {
            case "crear":
                return "CREATE TABLE `libros` (`id` int(3) NOT NULL AUTO_INCREMENT,`nombre` varchar(60) NOT NULL,`autor` varchar(40) NOT NULL,"
                + "  UNIQUE KEY `id` (`id`));";
            case "seleccionar":
                return "select * from libros WHERE id>0";
            case "agregar":
                return "INSERT INTO libros (nombre,autor) " + "VALUES ('" + libro.getNombre()
                        + "','" + libro.getAutor() + "')";
            case "modificar":
                return "UPDATE libros SET nombre='" + libro.getNombre() + "',autor='" + libro.getAutor()
                        + "' WHERE id='" + libro.getId() + "';";
            case "eliminar":
                return "DELETE FROM libros WHERE id=" + libro.getId() + "";
            default:
                return null;
        }
    }
}
