/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.libraryAPI.services;

import edu.eci.arsw.libraryAPI.model.Libreria;
import edu.eci.arsw.libraryAPI.model.Libro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2126081
 */
@Service
public class LibraryServices {
    
    private Map<Integer,Libreria> librerias = new HashMap<Integer,Libreria>();
    private Map<String,Libreria> libreriasN = new HashMap<String,Libreria>();

    public LibraryServices() {
        
        List<Libro> libros1 = new ArrayList<Libro>();
        Libro libro1 = new Libro(1, "The Favorite", "Olivia Colman", "libro de epoca");
        Libro libro2 = new Libro(2, "Gren Book", "Alicia Keys", "libro de segrgacion");
        libros1.add(libro1);
        libros1.add(libro2);
        Libreria libreria1 = new Libreria("Enri", "calle 13", 1254849 , 1);
        libreria1.setLibros(libros1);
        librerias.put(libreria1.getId(), libreria1);
        libreriasN.put(libreria1.getNombre(), libreria1);
        
        List<Libro> libros2 = new ArrayList<Libro>();
        Libro libro3 = new Libro(3, "Vice", "Amy Adams", "libro de politica");
        Libro libro4 = new Libro(4, "Bohemian Rhapsody", "Rami Malek", "libro de musica");
        libros2.add(libro3);
        libros2.add(libro4);
        Libreria libreria2 = new Libreria("Doro", "calle 145", 123456 , 2);
        libreria2.setLibros(libros1);
        librerias.put(libreria2.getId(), libreria2);
        libreriasN.put(libreria2.getNombre(), libreria2);
        
    }
    
    
    
    public void crearLibreria(Libreria lib) throws Exception{
        if (librerias.containsKey(lib.getId())){
            throw new Exception("La libreria" + lib.getNombre()+ " identificada con "+lib.getId()+" ya existe.");
        } else {
            librerias.put(lib.getId(), lib);
        }
        
    }
    /*
    public void agregarLibro (Libreria lib, Libro libro) throws Exception{
        for (Libro libroOcupado : lib.getLibros()) {
            if (libroOcupado.getId() == libro.getId()){
                throw new Exception("El libro ya existe en esta libreria");
            }
        }
    }
    */
    
    public void agregarLibro (Libreria lib, Libro libro) throws Exception{
        for (Libro libroOcupado : lib.getLibros()) {
            if (libroOcupado.getId() == libro.getId()){
                throw new Exception("El libro ya existe en esta libreria");
            }
        }
    }
    
    
    public Map<Integer,Libreria>  consultarLibrerias(){
        return this.librerias;
    }
    
    public List<Libro> consultarLibrosDeUnaLibreria(Libreria lib){
        return lib.getLibros();
    }
    
    public List<Libro> consultarLibrosDeUnaLibreria(String lib) throws Exception{
        List<Libro> libros = new ArrayList<Libro>();
        for (String libre : libreriasN.keySet()) {
            if (libre.equals(lib)){
                libros = libreriasN.get(libre).getLibros();
            }
        }
        if (libros.isEmpty() && !libreriasN.containsKey(lib)){
            throw new Exception("La librearia no existe");
        }
        return libros;
    }
    
     public List<Libro> consultarLibrosDeUnaLibreria(int lib) throws Exception{
        List<Libro> libros = new ArrayList<Libro>();
        for (String libre : libreriasN.keySet()) {
            if (libre.equals(lib)){
                libros = libreriasN.get(libre).getLibros();
            }
        }
        if (libros.isEmpty() && !libreriasN.containsKey(lib)){
            throw new Exception("La librearia no existe");
        }
        return libros;
    }
    
    /*
    public Libreria consultarUnaLibreria(String nombre){
        Libreria library;
        for (Libro libroOcupado : lib.getLibros()) {
            if (libroOcupado.getId() == libro.getId()){
            }
        }
    }*/
}
