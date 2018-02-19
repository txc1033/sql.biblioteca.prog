package com.javifast.repository;

import com.javifast.models.Cliente;
import com.javifast.service.BibliotecaServicio;
import java.sql.SQLException;

public class ClienteDaoImpl implements ClienteDao {

    private BibliotecaServicio biblioteca = new BibliotecaServicio();
    private String sql;

    @Override
    public int agregarDato(Cliente cliente) throws SQLException {
        sql = this.llamarSentencia("agregar", cliente);
        return biblioteca.ejecutarSentencia(sql);
    }

    @Override
    public int modificarDato(Cliente cliente) throws SQLException {
        sql = this.llamarSentencia("modificar", cliente);
        return biblioteca.ejecutarSentencia(sql);
    }

    @Override
    public int eliminarDato(Cliente cliente) throws SQLException {
        sql = this.llamarSentencia("eliminar", cliente);
        return biblioteca.ejecutarSentencia(sql);
    }

    @Override
    public String llamarSentencia(String accion, Cliente cliente) throws SQLException {
        switch (accion) {
            case "crear":
                return "CREATE TABLE `clientes` (`id` int(3) NOT NULL AUTO_INCREMENT,`nombre` varchar(60) "
                      +"NOT NULL,`apellido` varchar(60) NOT NULL, `rut` varchar(12) NOT NULL,`edad` int(3) "
                      +"NOT NULL,PRIMARY KEY (`id`),UNIQUE KEY `rut` (`rut`));";
            case "seleccionar":
                return "select * from clientes WHERE id>0;";
            case "agregar":
                return "INSERT INTO clientes (nombre,apellido,rut,edad) " + "VALUES ('"
                        + cliente.getNombre() + "','" + cliente.getApellido() + "','"
                        + cliente.getRut() + "','" + cliente.getEdad() + "')";
            case "modificar":
                return "UPDATE clientes SET nombre='" + cliente.getNombre() + "',apellido='" + cliente.getApellido()
                        + "',rut='" + cliente.getRut() + "',edad='" + cliente.getEdad() + "' WHERE id='"
                        + cliente.getId() + "';";
            case "eliminar":
                return "DELETE FROM clientes WHERE id=" + cliente.getId() + ";";
            default:
                return null;
        }
    }

}
