/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.bibliotecaherencia;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Biblioteca {
    private String nombreBiblioteca;
    private ArrayList <Libro> libros = new ArrayList();
    private ArrayList <Persona> personas = new ArrayList();
    
    // constructores
    public Biblioteca() {
    }

    public Biblioteca(String nombreBiblioteca) {
        this.setNombreBiblioteca(nombreBiblioteca);
    }
    
    public Biblioteca(Biblioteca biblioteca) {
        this.setNombreBiblioteca(biblioteca.getNombreBiblioteca());
    }
    
    //SEtters y getters
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca.substring(0, 1).toUpperCase() + nombreBiblioteca.substring(1).toLowerCase();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> Libros) {
        this.libros = Libros;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "nombreBiblioteca=" + nombreBiblioteca + ", libros=" + libros + ", personas=" + personas + '}';
    }


 
   
    
    public void mostrarLibros() {
        for(int i = 0; i < this.libros.size(); i++){
            int ordenLibro = i +1;
            System.out.println("LIBRO "+ ordenLibro+ ": "+libros.get(i).toString());
        }
    }
    
    public void mostrarLibrosDisponibles(){
        int ordenLibro = 1;
        for(int i = 0; i < this.libros.size(); i++){
            if(this.libros.get(i).getNumeroCopiasDisponibles() > 0){ 
                System.out.println("LIBRO "+ ordenLibro+ ": "+libros.get(i).toString());
                ordenLibro++;
            }
        }
  
    }
    
}