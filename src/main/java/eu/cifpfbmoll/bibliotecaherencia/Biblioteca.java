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
    
    public int identificarBibliotecario() throws MiException{
        int intentos = 0;
        boolean prohibirBibliotecario = true;
        
        Scanner lector = new Scanner(System.in);
        do{
            System.out.println("Escribe el nif");
            String nif = lector.nextLine();
            System.out.println("Escribe el contraseña");
            String contraseña = lector.nextLine();
            
            int posicionPersona = 0;

            do{
                if(this.getPersonas().get(posicionPersona) instanceof Bibliotecario){
                    System.out.println("Bibliotecario");
                    prohibirBibliotecario = this.getPersonas().get(posicionPersona).prohibirEntrada(nif, contraseña);
                    if(prohibirBibliotecario == false){
                        return posicionPersona;
                    }
                }
                posicionPersona ++;

            }while(prohibirBibliotecario && posicionPersona < this.getPersonas().size());
            intentos ++;
            
        } while(intentos < 3);
        throw new MiException(111);
        
    }
    
    public int identificarUsuario() throws MiException{
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
        throw new MiException(222);
        }
        
    public void prestarLibro(){   
        // TRATO EXCEPCION EN EL METODO LLAMANTE Y TRATO EXCEPTION EN EL PROPIO METODO
        try{
            int posicionUsuario = identificarUsuario();
        System.out.println("Posiscion usuario" + posicionUsuario);
        if (posicionUsuario != -1){
                System.out.println("Estas en el user "+this.getPersonas().get(posicionUsuario).toString());
                // aqui se reserva el libro o se devuelve el libro
                this.mostrarLibros();
                int posicionLibro = Libro.buscarLibroPorISBN(this.getLibros());
                System.out.println("posición libro"  + posicionLibro);
                
                try{
                     if(this.getLibros().get(posicionLibro).getNumeroCopiasDisponibles() > 0){// teniendo la posicion del libro vamos a hacer la reserva
                    Reserva prueba = new Reserva(this.getLibros().get(posicionLibro));
                    ArrayList <Reserva> reservas = ((Usuario)this.getPersonas().get(posicionUsuario )).getListaReservas();
                    reservas.add(prueba);
                    ((Usuario)this.getPersonas().get(posicionUsuario)).setListaReservas(reservas);
                    int copiasAntes = this.getLibros().get(posicionLibro).getNumeroCopiasDisponibles();
                    this.getLibros().get(posicionLibro).setNumeroCopiasDisponibles(copiasAntes - 1);
                    System.out.println( ((Usuario)this.getPersonas().get(posicionUsuario)).toString());

                }else {
                     throw new MiException(333); 
                     }
                }
                catch(MiException ex){
                    System.out.println(ex.getMessage());
                }}
        }catch(MiException ex){
            System.out.println(ex.getMessage());
        }
        
        
    }
    // fin del metodo
    public void devolverLibro(){
        try{
        int posicionUsuario = identificarUsuario();
        System.out.println("Posiscion usuario" + posicionUsuario);
        if (posicionUsuario != -1){
            System.out.println("Estas en el user "+this.getPersonas().get(posicionUsuario).toString());
            // Mostrar los libros del usuario
            ArrayList <Reserva> reservas = ((Usuario)this.getPersonas().get(posicionUsuario)).getListaReservas();
            System.out.println(reservas);
            // Creo un array de libros con las reservas del usuario
            ArrayList <Libro> librosUser = new ArrayList();
            for(int i = 0; i < reservas.size(); i++){
                Libro libro = reservas.get(i).getLibroReservado();
                librosUser.add(libro);
            }
            int posicionLibro = Libro.buscarLibroPorISBN(librosUser);
            System.out.println(librosUser);
            System.out.println("Posicion del libro" + posicionLibro);
            
            //si el libro está
            if(posicionLibro != -1){
                //lo quitaoms de la lista de reservas
                reservas.remove(posicionLibro);
                String ISBNLibro = librosUser.get(posicionLibro).getISBN();
                // busco el libro en la coleccion de la biblioteca
                int posicionLibroBiblioteca = Libro.devolverPosicionLibroPorISBN(ISBNLibro, this.getLibros());
                System.out.println(posicionLibroBiblioteca + "esta es la posicion del libro");
                //Añado una copia disponible al libro en la biblioteca
                this.getLibros().get(posicionLibroBiblioteca).setNumeroCopiasDisponibles(this.getLibros().get(posicionLibroBiblioteca).getNumeroCopiasDisponibles() +1);
                System.out.println(this.getLibros().get(posicionLibroBiblioteca).toString());
                this.getLibros().get(posicionLibroBiblioteca).toString();
               // el libro no está en la lista de reservas del usuario
            }else{
                System.out.println("Ese libro no está en la lista del usuario");
            }
 
        }
        }
        catch (MiException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    // metodo libro copia
    public void añadirLibroCopia(int posicionLibro){
        Libro libroCopia = new Libro(this.getLibros().get(posicionLibro));
        Scanner lector = new Scanner(System.in);
        System.out.println("Quieres modificar el ISBN? Escribe Y");
        String respuesta = lector.nextLine();
        if(respuesta.equals("Y")){
            System.out.println("Escribe el nuevo ISBN");
            String nuevoISBN = lector.nextLine();
            libroCopia.setISBN(nuevoISBN);
        }
        System.out.println("Quieres modificar el autor? Escribe Y");
        respuesta = lector.nextLine();
        if(respuesta.equals("Y")){
            System.out.println("Escribe el nuevo autor");
            String nuevoAutor = lector.nextLine();
            libroCopia.setAutor(nuevoAutor);
        }
        System.out.println("Quieres modificar la editorial? Escribe Y");
        respuesta = lector.nextLine();
        if(respuesta.equals("Y")){
            System.out.println("Escribe la nueva editorial");
            String nuevaEditorial = lector.nextLine();
            libroCopia.setEditorial(nuevaEditorial);
        }
        System.out.println("Quieres modificar el titulo?");
        respuesta = lector.nextLine();
        if(respuesta.equals("Y")){
            System.out.println("Escribe el nuevo titulo");
            String nuevoTitulo = lector.nextLine();
            libroCopia.setTitulo(nuevoTitulo);
        }
        System.out.println("Quieres modificar el número de copias totales?");
        respuesta = lector.nextLine();
        if(respuesta.equals("Y")){
            System.out.println("Escribe las copias totales");
            int nuevasCopiasTotales = lector.nextInt();
            lector.nextLine();
            libroCopia.setNumeroCopiasTotales(nuevasCopiasTotales);
        }
        System.out.println("Quieres modificar el numero de copias disponibles?");
        respuesta = lector.nextLine();
        if(respuesta.equals("Y")){
            System.out.println("Escribe el nº de copias disponibles");
            int nuevasCopiasDisponibles = lector.nextInt();
            lector.nextLine();
            libroCopia.setNumeroCopiasDisponibles(nuevasCopiasDisponibles);
        }
        this.getLibros().add(libroCopia);
    }
    
    public static void añadirBiblioteca(ArrayList <Biblioteca> bibliotecas){
        Scanner lector = new Scanner(System.in);
        System.out.println("Escribe el nombre de la biblioteca");
        String nombre = lector.nextLine();
        bibliotecas.add(new Biblioteca(nombre));   
    }
    
    public static int buscarBiblioteca(ArrayList <Biblioteca> bibliotecas){
        boolean encontrada = false;
        int posicionBiblioteca = 0;
        Scanner lector = new Scanner(System.in);
        System.out.println("Escribe el nombre de la biblioteca a buscar");
        String nombre = lector.nextLine();
        while(!encontrada && posicionBiblioteca < bibliotecas.size()){
            if(bibliotecas.get(posicionBiblioteca).getNombreBiblioteca().equals(nombre)){
                return posicionBiblioteca;
            } 
            posicionBiblioteca++;
        }
        return -1;
    }
    
    public static void eliminarBiblioteca(ArrayList <Biblioteca> bibliotecas){
        int posicionBiblioteca = buscarBiblioteca(bibliotecas);
        if(posicionBiblioteca != -1){
            bibliotecas.remove(posicionBiblioteca);
        }else{
            System.out.println("La biblioteca no existe");
        }
    }
}