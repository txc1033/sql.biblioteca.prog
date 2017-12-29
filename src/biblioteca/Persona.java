/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 * CREATE TABLE clientes " + " (id INT PRIMARY KEY AUTOINCREMENT NOT NULL,nombre VARCHAR NULL,"
                + "apellido VARCHAR NULL,rut VARCHAR UNIQUE NULL,edad  VARCHAR NULL);
 * @author javie
 */
public class Persona {
    private int id,edad;
    private String nombre,apellido,rut;
    
    public Persona(int id,String nombre, String apellido,String rut, int edad) {
                this.id = id;
                this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
                this.edad = edad;
                
	}
    public Persona(String nombre, String apellido,String rut,int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.edad = edad;
	}
    public Persona(int id) {
		this.id = id;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
       this.edad = edad;
    }
}
