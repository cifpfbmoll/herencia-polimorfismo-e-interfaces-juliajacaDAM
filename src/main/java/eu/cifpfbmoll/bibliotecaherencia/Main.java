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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("HOLA MUNDO");
        Libro libro1 = new Libro("ISBN1", "El nombre de la rosa","Umberto ECO", "AAA Editores", 20,20);
        Libro libro2 = new Libro("ISBN2", "Sinuhe el Egipcio","Mika Waltari", "BBB Editores", 1,1);
        System.out.println(libro1.toString());
        ArrayList <Libro> coleccion = new ArrayList <Libro>();
        coleccion.add(0, libro1);
        coleccion.add(libro2);
        Biblioteca biblioteca = new Biblioteca("maria Moliner");
        biblioteca.setLibros(coleccion);
        System.out.println(biblioteca.toString());
        //Reserva prueba = new Reserva(libro1);
        //System.out.println(prueba.horaReserva);
        //System.out.println(prueba.fechaReserva);
        //System.out.println(prueba.fecha2);
        //System.out.println(prueba.getHora());
        //System.out.println(prueba.getFecha());
        //System.out.println(prueba.toString());
        
        Usuario usuario1 = new Usuario("00000", "C/Falsa", "41222", "hola@hola","estrellita", "castro","fer", 87 );
        System.out.println(usuario1.toString());
        ArrayList<Persona> arrayPersonas = biblioteca.getPersonas();
        arrayPersonas.add(0, usuario1);
        biblioteca.setPersonas(arrayPersonas);
        //usuario1.solicitarDatosPersona();
        
        boolean continuar = true;
        while(continuar){
            Scanner lector = new Scanner(System.in);
            System.out.println("Escribe la opción que quieras:" + "\n" + " A: Añadir USUARIO" + "\n" + "B:Añadir bibliotecario" + "\n" +" L: Hacer login" + "\n" +  " Salir: cerrar la aplicación" );
            String opcion = lector.nextLine();
            System.out.println("La opción del usuario es " + opcion);
            switch(opcion){
            case "A":
                System.out.println("Vas a meter a un usuario");
                 //METER UN USUARIO
                // creo un user vacio
                Usuario usuario2 = new Usuario();
                // saco el array personas de la biblioteca
                arrayPersonas = biblioteca.getPersonas();
                // le añado la persona vacia en la posicion 0
                arrayPersonas.add(0, usuario2);
                // vuelvo a poner el array de personas en la biblio
                biblioteca.setPersonas(arrayPersonas);

                System.out.println("sin usuario" + biblioteca.toString());
                // extraigo el usuario vacio del array de personas de la biblio
                Persona usuario3 = biblioteca.getPersonas().get(0);
                // sobre esta persona vacia llamo a solicitar datos persona, que lo va a rellenar 
                usuario3.solicitarDatosPersona();
                System.out.println("segundo usuario" + biblioteca.toString());
                break;
            case "B":
                System.out.println("Añadir bibliotecario");
                 // METER UN BIBLIOTECARIO
                Bibliotecario bibliotecario = new Bibliotecario();
                arrayPersonas = biblioteca.getPersonas();
                arrayPersonas.add(0, bibliotecario);
                biblioteca.setPersonas(arrayPersonas);
                Persona bibliotecario1 = biblioteca.getPersonas().get(0);
                bibliotecario1.solicitarDatosPersona();
                System.out.println("despues del insert" + biblioteca.toString());
                break;
            case "C":
                System.out.println("Vas a hacer login");
                break;
            case "Salir":
                System.out.println("Vas a salir");
                continuar = false;
                break;
            default:
                System.out.println("Opcion incorrecta");
        }
        
      
       
        
        }    
    }
}