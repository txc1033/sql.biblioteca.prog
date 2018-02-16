package com.javifast.repository;

import com.javifast.models.Libro;
import com.javifast.service.BibliotecaServicio;
import java.sql.SQLException;

public class LibroDaoImpl implements LibroDao {

    BibliotecaServicio biblioteca = new BibliotecaServicio();
    String sql, accion;

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
        switch (accion) {
            case "agregar":
                sql = "INSERT INTO libros (nombre,autor) " + "VALUES ('" + libro.getNombre()
                        + "','" + libro.getAutor() + "')";
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
}
