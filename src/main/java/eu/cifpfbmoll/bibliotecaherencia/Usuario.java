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
 * @author asix
 */
public class Usuario extends Persona{
    private String telefono;
    private String direccion;
    private String cp;
    private String correo;
    private ArrayList <Reserva> listaReservas = new ArrayList();

    public Usuario() {
    }

    public Usuario(String telefono, String direccion, String cp, String correo, String nombre, String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setCp(cp);
        this.setCorreo(correo);
    }
    
    public Usuario(Usuario usuario) {
        super((Persona)usuario);
        this.setTelefono(usuario.getTelefono());
        this.setDireccion(usuario.getDireccion());
        this.setCp(usuario.getCp());
        this.setCorreo(usuario.getCorreo());
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return  "Usuario{" + super.toString() +"telefono=" + telefono + ", direccion=" + direccion + ", cp=" + cp + ", correo=" + correo + ", listaReservas=" + listaReservas + '}';
    }

    @Override
    public void solicitarDatosPersona() {
        super.solicitarDatosPersona(); //To change body of generated methods, choose Tools | Templates.
        Scanner lector = new Scanner(System.in);
        System.out.println("estoy en usuario");
        System.out.println("Dime el telefono");
        String telefono = lector.nextLine();
        System.out.println("Dime la direccion");
        String direccion = lector.nextLine();
        System.out.println("DIme el correo");
        String correo = lector.nextLine();
        System.out.println("Dime el cp");
        String cp = lector.nextLine();
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setCorreo(correo);
        this.setCp(cp);
              
    }

    @Override
    public boolean prohibirEntrada(String correo, String telefono) {
         if(this.getCorreo().equals(correo)&& this.getTelefono().equals(telefono)){
            return false;
        }
         return true;
    }
    
    
    
}
