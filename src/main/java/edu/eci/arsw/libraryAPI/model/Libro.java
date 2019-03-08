/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.libraryAPI.model;

/**
 *
 * @author 2126081
 */
public class Libro {
    
    private int id;
    private String nombre;
    private String autor;
    private String sinopsis;

    public Libro(int id, String nombre, String autor, String sinopsis) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.sinopsis = sinopsis;
    }

    public Libro() {
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

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
   
    
    
}
