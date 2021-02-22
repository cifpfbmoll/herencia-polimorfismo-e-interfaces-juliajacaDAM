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
    
    public int identificarUsuario(){
        int intentos = 0;
        boolean prohibirUsuario = true;
        int posicionUsuario = -1;
        
        Scanner lector = new Scanner(System.in);
        do{
            System.out.println("Escribe el correo");
            String correo = lector.nextLine();
            System.out.println("Escribe el telefono");
            String telefono = lector.nextLine();
            
            int posicionPersona = 0;

            do{
                if(this.getPersonas().get(posicionPersona) instanceof Usuario){
                    System.out.println("Usuario");
                    prohibirUsuario = this.getPersonas().get(posicionPersona).prohibirEntrada(correo, telefono);
                    if(prohibirUsuario == false){
                        return posicionPersona;
                    }
                }
                posicionPersona ++;

            }while(prohibirUsuario && posicionPersona < this.getPersonas().size());
            intentos ++;
            
        } while(intentos < 3);
        System.out.println("El usuario no existe");
        return posicionUsuario;
        }
        
    public void prestarLibro(){       
        int posicionUsuario = identificarUsuario();
        System.out.println("Posiscion usuario" + posicionUsuario);
        if (posicionUsuario != -1){
                System.out.println("Estas en el user "+this.getPersonas().get(posicionUsuario).toString());
                // aqui se reserva el libro o se devuelve el libro
                this.mostrarLibros();
                int posicionLibro = Libro.buscarLibroPorISBN(this.getLibros());
                System.out.println("posición libro"  + posicionLibro);

                if(this.getLibros().get(posicionLibro).getNumeroCopiasDisponibles() > 0){// teniendo la posicion del libro vamos a hacer la reserva
                    Reserva prueba = new Reserva(this.getLibros().get(posicionLibro));
                    ArrayList <Reserva> reservas = ((Usuario)this.getPersonas().get(posicionUsuario )).getListaReservas();
                    reservas.add(prueba);
                    ((Usuario)this.getPersonas().get(posicionUsuario)).setListaReservas(reservas);
                    int copiasAntes = this.getLibros().get(posicionLibro).getNumeroCopiasDisponibles();
                    this.getLibros().get(posicionLibro).setNumeroCopiasDisponibles(copiasAntes - 1);
                    System.out.println( ((Usuario)this.getPersonas().get(posicionUsuario)).toString());

                }else{
                    System.out.println("Ese libro no se puede reservar porque no hay copias disponibles");}
            }
        
    }
    // fin del metodo
}