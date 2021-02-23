/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.bibliotecaherencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int numeroCopiasTotales;
    private int numeroCopiasDisponibles;
    private static int titulosDistintos;

    public Libro(String ISBN, String titulo, String autor, String editorial, int numeroCopiasTotales, int numeroCopiasDisponibles) {
        this.setISBN(ISBN);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setNumeroCopiasTotales(numeroCopiasTotales);
        this.setNumeroCopiasDisponibles(numeroCopiasDisponibles);
        titulosDistintos++;
    }

    public Libro() {
        titulosDistintos++;
    }
    
    public Libro(Libro libro) {
        titulosDistintos++;
        this.setISBN(libro.getISBN());
        this.setTitulo(libro.getTitulo());
        this.setAutor(libro.getAutor());
        this.setEditorial(libro.getEditorial());
        this.setNumeroCopiasTotales(libro.getNumeroCopiasTotales());
        this.setNumeroCopiasDisponibles(libro.getNumeroCopiasDisponibles());    
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroCopiasTotales() {
        return numeroCopiasTotales;
    }

    public void setNumeroCopiasTotales(int numeroCopiasTotales) {
        while (numeroCopiasTotales < 1){
            System.out.println("Al menos hace falta una copia del libro! Vuelve a probar");
            Scanner lector = new Scanner (System.in);
            numeroCopiasTotales = lector.nextInt();
        }
        this.numeroCopiasTotales = numeroCopiasTotales;
    }

    public int getNumeroCopiasDisponibles() {
        return numeroCopiasDisponibles;
    }

    public void setNumeroCopiasDisponibles(int numeroCopiasDisponibles) {
            while (numeroCopiasDisponibles > this.getNumeroCopiasTotales() || numeroCopiasDisponibles < 0){
                System.out.println("Numero de copias disponibles incorrecto. Vuelve a probar");
                Scanner lector = new Scanner (System.in);
                numeroCopiasDisponibles = lector.nextInt();
        }
        
        this.numeroCopiasDisponibles = numeroCopiasDisponibles;
    }

    public static int getTitulosDistintos() {
        return titulosDistintos;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", numeroCopiasTotales=" + numeroCopiasTotales + ", numeroCopiasDisponibles=" + numeroCopiasDisponibles + '}';
    }
    
    public static void añadirLibro(ArrayList <Libro> arrayLibros){
        Libro libroNuevo = new Libro();
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el ISBN");
        libroNuevo.setISBN(lector.nextLine());
        System.out.println("Dime el titulo");
        libroNuevo.setTitulo(lector.nextLine());
        System.out.println("Dime el autor");
        libroNuevo.setAutor(lector.nextLine());
        System.out.println("Dime la editorial");
        libroNuevo.setEditorial(lector.nextLine());
        System.out.println("Dime las copias totales");
        libroNuevo.setNumeroCopiasTotales(lector.nextInt());
        lector.nextLine();
        System.out.println("Dime las copias disponibles");
        libroNuevo.setNumeroCopiasDisponibles(lector.nextInt());
        lector.nextLine();
        arrayLibros.add(libroNuevo);
    }
    
    public static void eliminarLibro(ArrayList <Libro> arrayLibros){
        Scanner lector = new Scanner(System.in);
        String noEncontrado = "NO";
        while (noEncontrado == "NO"){
            System.out.println("Dime el ISBN del libro que quieres eliminar");
            String isbnUsuario = lector.nextLine();
            for(int i = 0; i< arrayLibros.size(); i++ ){
                if(arrayLibros.get(i).getISBN().equals(isbnUsuario)){
                    System.out.println("Libro encontrado");
                    noEncontrado = "SI";
                    if(arrayLibros.get(i).getNumeroCopiasDisponibles() == arrayLibros.get(i).getNumeroCopiasTotales()){
                        System.out.println("Se va a borrar el libro");
                        arrayLibros.remove(i);
                    }else{
                        System.out.println("El título no se puede borrar porque hay ejemplares prestados");
                    }
                }    
            }
        }
        System.out.println("Estos son los libros que quedan");
        for (int i = 0; i<arrayLibros.size(); i++){
            System.out.println(arrayLibros.get(i).toString());
        }
        
    }
    
    public static int buscarLibroPorISBN(ArrayList <Libro> arrayLibros){
        Scanner lector = new Scanner(System.in);
        int posicionLibro = -1;
        System.out.println("Dime el ISBN del libro");
        String ISBNUsuario = lector.nextLine();
        for(int i = 0; i < arrayLibros.size(); i++){
            if(arrayLibros.get(i).getISBN().equals(ISBNUsuario)){
                System.out.println("Libro encontrado");
                posicionLibro = i;
            }
        }
        return posicionLibro;   
    }
    
    public static void buscarLibroPorTitulo(ArrayList <Libro> arrayLibros){
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el texto a buscar en el título del libro");
        String busquedaUsuario = lector.nextLine();
        for(int i = 0; i < arrayLibros.size(); i++){
            if(arrayLibros.get(i).getTitulo().indexOf(busquedaUsuario) != -1){
                System.out.println(arrayLibros.get(i).toString());
            }
        }
    }
    
    public static int devolverPosicionLibroPorISBN(String ISBN, ArrayList <Libro> arrayLibros){
        int posicionLibro = -1;
        int vueltas = 0;
        while(posicionLibro !=1 && vueltas < arrayLibros.size()){
         if(arrayLibros.get(vueltas).getISBN().equals(ISBN)){
                System.out.println("Libro encontrado");
                posicionLibro = vueltas;
            }
         vueltas++;
        }
        return posicionLibro;   
    }

    // FIn de la clase
}
