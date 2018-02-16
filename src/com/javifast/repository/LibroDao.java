
package com.javifast.repository;

import com.javifast.models.Libro;
import java.sql.SQLException;


public interface LibroDao {

    public String llamarSentencia(String accion, Libro libro) throws SQLException;
    public void agregarDato(Libro libro) throws SQLException;
    public void modificarDato(Libro libro) throws SQLException;
    public void eliminarDato(Libro libro) throws SQLException;
}
