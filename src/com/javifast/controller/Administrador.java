/* Autor @Javifast | @Txc1033 */
package com.javifast.controller;

import com.javifast.models.Libro;
import com.javifast.models.Cliente;
import java.sql.*;

import com.javifast.repository.ClienteDaoImpl;
import com.javifast.repository.LibroDaoImpl;
import com.javifast.service.BibliotecaServicio;

public class Administrador {

    private LibroDaoImpl libroImpl = new LibroDaoImpl();
    private ClienteDaoImpl clienteImpl = new ClienteDaoImpl();
    private BibliotecaServicio biblioteca = new BibliotecaServicio();

    public void crearTablas() throws SQLException {
        biblioteca.crearTabla();
    }

    /*-----METODOS QUE INTERACUAN CON LA TABLA LIBROS-------------*/
    
    public int agregarLibro(Libro libro) throws SQLException {
       return libroImpl.agregarDato(libro);
    }

    public int modificarLibro(Libro libro) throws SQLException {
       return libroImpl.modificarDato(libro);
    }

    public int eliminarLibro(Libro libro) throws SQLException {
       return libroImpl.eliminarDato(libro);
    }

    /*-------METODOS QUE INTERACUAN CON LA TABLA CLIENTES----------------------*/
    
    public int agregarCliente(Cliente cliente) throws SQLException {
        return clienteImpl.agregarDato(cliente);
    }

    public int modificarCliente(Cliente cliente) throws SQLException {
       return clienteImpl.modificarDato(cliente);
    }

    public int eliminarCliente(Cliente cliente) throws SQLException {
        return clienteImpl.eliminarDato(cliente);
    }

}
