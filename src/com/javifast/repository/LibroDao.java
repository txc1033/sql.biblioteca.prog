
package com.javifast.repository;

import com.javifast.models.Libro;
import java.sql.SQLException;


public interface LibroDao {

    public String llamarSentencia(String accion, Libro libro) throws SQLException;
    public int agregarDato(Libro libro) throws SQLException;
    public int modificarDato(Libro libro) throws SQLException;
    public int eliminarDato(Libro libro) throws SQLException;
}
