/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.libraryAPI.controller;

import edu.eci.arsw.libraryAPI.model.Libreria;
import edu.eci.arsw.libraryAPI.model.Libro;
import edu.eci.arsw.libraryAPI.services.LibraryServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2126081
 */

@RestController
@Service
public class LibraryRestController {
    
    @Autowired
    LibraryServices lbs;

    @RequestMapping(method = RequestMethod.GET, value = "/libraries")
    public ResponseEntity<?> recursoGetAllLibraries() {

        try {
            Object data = lbs.consultarLibrerias();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(LibraryRestController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error Librerias no encontradas", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/libraries/{name}")
    public ResponseEntity<?> recursoGetAllBooksByLibrary(@PathVariable String name) {

        try {
            Object data = lbs.consultarLibrosDeUnaLibreria(name);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            //Logger.getLogger(LibraryRestController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error Libreria no encontrada", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/libraries")
    public ResponseEntity<?> recursoPOSTLibrary(@RequestBody Libreria lib) {
        try {
            lbs.crearLibreria(lib);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(LibraryRestController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo añadir la libreria", HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/libraries/{name}")
    public ResponseEntity<?> recursoPOSTLibroAUnaLibreria(@RequestBody Libro lib, @PathVariable int name) {
        try {
            
           lbs.agregarLibro(name, lib);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(LibraryRestController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo añadir la libreria", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
