/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.bibliotecaherencia;

import java.util.Scanner;

/**
 *
 * @author asix
 */
public class Bibliotecario extends Persona{
    private String puesto;
    private String nif;
    private String contraseña;

    public Bibliotecario() {
    }

    public Bibliotecario(String puesto, String nif, String contraseña, String nombre, String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.setPuesto(puesto);
        this.setNif(nif);
        this.setContraseña(contraseña);
    }
    
    public Bibliotecario(Bibliotecario bibliotecario) {
        super((Persona)bibliotecario);
        this.setPuesto(bibliotecario.getPuesto());
        this.setNif(bibliotecario.getNif());
        this.setContraseña(bibliotecario.getContraseña());
    }
     
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "puesto=" + puesto + ", nif=" + nif + ", contrase\u00f1a=" + contraseña + '}';
    }

    @Override
    public void solicitarDatosPersona() {
        super.solicitarDatosPersona(); //To change body of generated methods, choose Tools | Templates.
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el puesto");
        String puesto = lector.nextLine();
        System.out.println("DIme el nif");
        String nif = lector.nextLine();
        System.out.println("DIme la contraseña");
        String contraseña = lector.nextLine();
        this.setPuesto(puesto);
        this.setNif(nif);
        this.setApellido1(contraseña);
        
    }
    
    @Override
    public boolean prohibirEntrada(String nombreUsuario, String constraseña){
        if(this.getNif().equals(nombreUsuario)&& this.getContraseña().equals(constraseña)){
            return false;
        }
        else {return true;}
    }
    
    
    
    
}
