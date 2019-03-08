/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.libraryAPI.model;

import java.util.List;

/**
 *
 * @author 2126081
 */
public class Libreria {
    
    private String nombre;
    private String direccion;
    private int telefono;
    private int id;
    private List<Libro> libros;

    
    public Libreria() {
    }
        
    public Libreria(String nombre, String direccion, int telefono, int id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void nuevoLibro(Libro libro) {
    	this.libros.add(libro);
    }
    
}
