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
        ArrayList <Biblioteca> bibliotecas = new ArrayList();
        System.out.println("HOLA MUNDO");
        Libro libro1 = new Libro("ISBN1", "El nombre de la rosa","Umberto ECO", "AAA Editores", 20,19);
        Libro libro2 = new Libro("ISBN2", "Sinuhe el Egipcio","Mika Waltari", "BBB Editores", 1,1);
        System.out.println(libro1.toString());
        ArrayList <Libro> coleccion = new ArrayList();
        coleccion.add(0, libro1);
        coleccion.add(libro2);
        Biblioteca biblioteca = new Biblioteca("maria Moliner");
        biblioteca.setLibros(coleccion);
        System.out.println(biblioteca.toString());
        
        //System.out.println(prueba.horaReserva);
        //System.out.println(prueba.fechaReserva);
        //System.out.println(prueba.fecha2);
        //System.out.println(prueba.getHora());
        //System.out.println(prueba.getFecha());
        //System.out.println(prueba.toString());
        
        Usuario usuario1 = new Usuario("00000", "C/Falsa", "41222", "hola@hola","estrellita", "castro","fer", 87 );
        Reserva prueba = new Reserva(libro1);
        System.out.println("Fecha de devolucion");
        prueba.obtenerFechaDevolución();
        prueba.mostrarReservaChula();
        ArrayList <Reserva> reservasUser = usuario1.getListaReservas();
        reservasUser.add(prueba);
        usuario1.setListaReservas(reservasUser);
        Bibliotecario bibliotecarioPrueba = new Bibliotecario("1","1","1", "Jacinta", "Fortun", "Lama",77);
        System.out.println(usuario1.toString());
        ArrayList<Persona> arrayPersonas = biblioteca.getPersonas();
        arrayPersonas.add(0, usuario1);
        arrayPersonas.add(bibliotecarioPrueba);
        biblioteca.setPersonas(arrayPersonas);
        //usuario1.solicitarDatosPersona();
        bibliotecas.add(biblioteca);
        boolean continuar = true;
        while(continuar){
            Scanner lector = new Scanner(System.in);
            System.out.println("Escribe la opción que quieras:\n A: Añadir USUARIO\nB:Añadir bibliotecario\n L: Hacer login "
                    + "\nLC: Añadir libro copia "
                    + "\nCCU: Cambiar contraseña usuario"
                     + "\nCCB: Cambiar contraseña bibliotecario"
                    +"\nG: Gestionar bibliotecas"
                    + "\nSalir: cerrar la aplicación" );
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
            case "L":
                System.out.println("Vas a hacer login BIBLIOTECARIO");
                int posicionBibliotecario = biblioteca.identificarBibliotecario();
                    
                if(posicionBibliotecario != -1){
                    System.out.println("Bienvenido"+biblioteca.getPersonas().get(posicionBibliotecario).toString());
                    String desloguear = "no";
                    do{
                        System.out.println("Elige tu opcion \n P:Prestar Libro \n D:Devolver \n Salir: Desloguear");

                        String opcionBiblio = lector.nextLine();
                        switch(opcionBiblio){
                            case "P":
                                // PRESTAR LIBRO (llama tmb a itentificar usuario)
                                biblioteca.prestarLibro();
                                break;
                            case "D":
                                System.out.println("Vas a devolver un libro");
                               // El usuario tiene que hacer login
                                biblioteca.devolverLibro();
                                break;
                            case "Salir":
                                desloguear = "si";
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    }while("no".equals(desloguear));

                }
                  break;
            case "LC":
                System.out.println("Vas a añadir un libro copia");
                int posicionLibro = Libro.buscarLibroPorISBN(biblioteca.getLibros());
                if(posicionLibro != -1){
                 //hacer cosas
                    biblioteca.añadirLibroCopia(posicionLibro);
                    System.out.println(biblioteca.getLibros().toString());
                }else {
                    System.out.println("Ese libro no existe");
                }
                break;
            case "CCU":
                System.out.println("Vas a cambiar la contraseña");
                int posicionUsuario = biblioteca.identificarUsuario();
                System.out.println("Posiscion usuario" + posicionUsuario);
                if (posicionUsuario != -1){
                    System.out.println("datos antes" +biblioteca.getPersonas().get(posicionUsuario).toString());
                    //llamo al metodo de cambiar 
                    biblioteca.getPersonas().get(posicionUsuario).cambiarContraseña();
                    System.out.println("datos despues" + biblioteca.getPersonas().get(posicionUsuario).toString());
                }else{
                        System.out.println("No existe");
                        }
                 break;
            case "CCB":
                System.out.println("Vas a cambiar la contraseña");
                int posicionBibliotecarioC = biblioteca.identificarBibliotecario();
                System.out.println("Posiscion usuario" + posicionBibliotecarioC);
                if (posicionBibliotecarioC != -1){
                    System.out.println("datos antes" +biblioteca.getPersonas().get(posicionBibliotecarioC).toString());
                    //llamo al metodo de cambiar 
                    biblioteca.getPersonas().get(posicionBibliotecarioC).cambiarContraseña();
                    System.out.println("datos despues" + biblioteca.getPersonas().get(posicionBibliotecarioC).toString());
                }else{
                        System.out.println("No existe");
                        }
                break;
            case "G":
                System.out.println(" \"Vas a gestionar bibliotecas\"");
                boolean gestionar = true;
                while(gestionar){
                    System.out.println("A: añadir biblioteca"
                            + "\nE: Eliminar Biblioteca");
                    String opcionGestion = lector.nextLine();
                    switch(opcionGestion){
                        case "A":
                            Biblioteca.añadirBiblioteca(bibliotecas);
                            System.out.println(bibliotecas);
                            break;
                        case "E":
                            System.out.println("bibliotecas antes" + bibliotecas);
                            Biblioteca.eliminarBiblioteca(bibliotecas);
                            System.out.println("Bibliotecas despues" + bibliotecas);
                            break;
                        case "Salir":
                            gestionar = false;
                            break;
                        default:
                           System.out.println("Opcion incorrecta"); 
                    }
                }
               
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