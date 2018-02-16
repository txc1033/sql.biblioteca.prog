
package com.javifast.repository;

import com.javifast.models.Cliente;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public interface ClienteDao {

    public String llamarSentencia(String accion, Cliente cliente) throws SQLException;
    public void agregarDato(Cliente cliente) throws SQLException;
    public void modificarDato(Cliente cliente) throws SQLException;
    public void eliminarDato(Cliente cliente) throws SQLException;
    
}
