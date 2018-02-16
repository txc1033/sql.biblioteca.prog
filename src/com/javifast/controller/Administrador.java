/* Autor @Javifast | @Txc1033 */
package com.javifast.controller;

import com.javifast.models.Libro;
import com.javifast.models.Cliente;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.table.DefaultTableModel;

import com.javifast.repository.ClienteDaoImpl;
import com.javifast.repository.LibroDaoImpl;
import com.javifast.service.BibliotecaServicio;

public class Administrador {

    private LibroDaoImpl libroImpl = new LibroDaoImpl();
    private ClienteDaoImpl clienteImpl = new ClienteDaoImpl();
    private BibliotecaServicio biblioteca;

    public void Crear() throws SQLException {
        biblioteca = new BibliotecaServicio();
        biblioteca.crearTabla();
    }

    /*-----METODOS QUE INTERACUAN CON LA TABLA LIBROS-------------*/
    
    public void AgregarConsulta(Libro libro) throws SQLException {
        libroImpl.agregarDato(libro);
    }

    public void EliminarConsultaL(Libro libro) throws SQLException {
        libroImpl.eliminarDato(libro);
    }

    public void ModificarConsultaL(Libro libro) throws SQLException {
        libroImpl.modificarDato(libro);
    }

    /*-------METODOS QUE INTERACUAN CON LA TABLA CLIENTES----------------------*/
    
    public void AgregarConsultaC(Cliente cliente) throws SQLException {
        clienteImpl.agregarDato(cliente);
    }

    public void ModificarConsultaC(Cliente cliente) throws SQLException {
        clienteImpl.modificarDato(cliente);
    }

    public void EliminarConsultaC(Cliente cliente) throws SQLException {
        clienteImpl.eliminarDato(cliente);
    }

}
