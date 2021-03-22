/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.bibliotecaherencia;

/**
 *
 * @author USER
 */
public class MiException extends Exception{
    private int codigoError;

    public MiException(int codigoError) {
        super();
        this.codigoError = codigoError;
    }

    @Override
    public String getMessage() {
        String mensaje="";
        switch(codigoError){
            case 111:
                mensaje="EL bibliotecario no existe";
                break;
            case 222:
                mensaje="El usuario no existe";
                break;
            case 333:
                mensaje = "No hay libros disponibles";
                break;
        }

        return mensaje; 
    }
    

}
