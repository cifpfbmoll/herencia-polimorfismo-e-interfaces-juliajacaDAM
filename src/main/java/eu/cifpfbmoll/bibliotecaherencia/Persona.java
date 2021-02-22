/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.bibliotecaherencia;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;

    // constructor vacio
     public Persona() {
    }
    //constructor con parametros

    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setEdad(edad);
    }

   // constructor copia
     public Persona(Persona persona) {
        this.setNombre(persona.getNombre());
        this.setApellido1(persona.getApellido1());
        this.setApellido2(persona.getApellido2());
        this.setEdad(persona.getEdad());
    }
    
    //getteres y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    // to string

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }
    
    //METODOS DE PERSONA
    public void solicitarDatosPersona(){
        System.out.println("HOLA");
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el nombre");
        String nombre = lector.nextLine();
        System.out.println("Dime el primer apellido");
        String apellido1 = lector.nextLine();
        System.out.println("Dime el segundo apellido");
        String apellido2 = lector.nextLine();
        System.out.println("Dime tu edad");
        int edad = lector.nextInt();
        lector.nextLine();
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setEdad(edad);
    }
    
    public boolean prohibirEntrada(String nif, String pass){
        return true;
    };
}