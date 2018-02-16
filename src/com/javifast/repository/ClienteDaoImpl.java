
package com.javifast.repository;



import com.javifast.models.Cliente;
import com.javifast.service.BibliotecaServicio;
import java.sql.SQLException;


public class ClienteDaoImpl implements ClienteDao {

    
    BibliotecaServicio biblioteca = new BibliotecaServicio();
    String sql ,accion;       

    @Override
    public int agregarDato(Cliente cliente) throws SQLException{
        sql = this.llamarSentencia("agregar",cliente);
        return biblioteca.ejecutarSentencia(sql);        
    }

    @Override
    public int modificarDato(Cliente cliente) throws SQLException{
        sql = this.llamarSentencia("modificar",cliente);
        return biblioteca.ejecutarSentencia(sql);
    }

    @Override
    public int eliminarDato(Cliente cliente) throws SQLException{
        sql = this.llamarSentencia("eliminar", cliente);
        return biblioteca.ejecutarSentencia(sql);
    }

        @Override
    public String llamarSentencia(String accion, Cliente cliente) throws SQLException{
                  switch(accion){
                case "seleccionar":
                sql = "select * from clientes WHERE id>0;";
                break;
                case "agregar":
                sql = "INSERT INTO clientes (nombre,apellido,rut,edad) "+"VALUES ('"
                    + cliente.getNombre()+ "','" + cliente.getApellido() + "','" 
                    + cliente.getRut() + "','" + cliente.getEdad() + "')";
                break;
                case "modificar":
                sql = "UPDATE clientes SET nombre='" + cliente.getNombre() + "',apellido='" + cliente.getApellido() 
                    + "',rut='" + cliente.getRut() + "',edad='" + cliente.getEdad() + "' WHERE id='"
                    + cliente.getId() + "';";
                break;
                case "eliminar":
                sql = "DELETE FROM clientes WHERE id=" + cliente.getId() + ";";
                break; 
            }  
            return sql;
    }

}
