
package com.javifast.repository;



import com.javifast.models.Cliente;
import com.javifast.service.BibliotecaServicio;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;


public class ClienteDaoImpl implements ClienteDao {

    
    BibliotecaServicio biblioteca = new BibliotecaServicio();
    String sql ,accion;
    int resultado;
    
    
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
            System.out.println("Sentencia => "+sql);
            return sql;
    }
    

    @Override
    public void agregarDato(Cliente cliente) throws SQLException{
        sql = this.llamarSentencia("agregar",cliente);
        resultado = biblioteca.ejecutarSentencia(sql);
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "AGREGADO", "Sentencia SQL", PLAIN_MESSAGE, null);
        }
    }

    @Override
    public void modificarDato(Cliente cliente) throws SQLException{
        sql = this.llamarSentencia("modificar",cliente);
        resultado = biblioteca.ejecutarSentencia(sql);
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "MODIFICADO");
        }
    }

    @Override
    public void eliminarDato(Cliente cliente) throws SQLException{
        sql = this.llamarSentencia("eliminar", cliente);
        resultado = biblioteca.ejecutarSentencia(sql);
        if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "ELIMINADO", "Sentencia SQL", PLAIN_MESSAGE, null);
        }
    }


}
