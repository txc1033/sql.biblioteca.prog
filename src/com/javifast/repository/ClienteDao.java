
package com.javifast.repository;

import com.javifast.models.Cliente;
import java.sql.SQLException;


public interface ClienteDao {

    public String llamarSentencia(String accion, Cliente cliente) throws SQLException;
    public int agregarDato(Cliente cliente) throws SQLException;
    public int modificarDato(Cliente cliente) throws SQLException;
    public int eliminarDato(Cliente cliente) throws SQLException;
    
}
