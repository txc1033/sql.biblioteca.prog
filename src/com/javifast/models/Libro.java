/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javifast.models;

/**
 * id INT PRIMARY KEY AUTOINCREMENT NOT NULL,nombre VARCHAR NULL,autor VARCHAR  NULL
 * @author javie
 */
public class Libro {
    private int id;
    private String nombre,autor;
    

    public Libro(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }
    
    public Libro(int id) {
        this.id = id;
    }
    
    public Libro(){
        
    }

    public Libro(int id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
