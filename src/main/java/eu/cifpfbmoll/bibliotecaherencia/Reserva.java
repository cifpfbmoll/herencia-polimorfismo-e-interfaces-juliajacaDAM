
package eu.cifpfbmoll.bibliotecaherencia;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Reserva implements Material {
    private Libro libroReservado;
    private String fecha = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    private String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
    //public LocalTime horaReserva = LocalTime.now();
    //public ZonedDateTime fecha2 = ZonedDateTime.now();
    //public Date fechaReserva = new Date();
    private String fechaDevolucion;

    public Reserva(Libro libroReservado) {
        this.setLibroReservado(libroReservado);
        this.setFechaDevolucion(this.obtenerFechaDevolución());
    }
    
    public Reserva(Reserva reserva) {
        this.setLibroReservado(reserva.getLibroReservado());
        this.setFechaDevolucion(reserva.getFechaDevolucion());
        
    }
    public Reserva() {
    }
    
    //getters and setters
    public Libro getLibroReservado() {
        return libroReservado;
    }

    public void setLibroReservado(Libro libroReservado) {
        this.libroReservado = libroReservado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    //to string

    @Override
    public String toString() {
        return "Reserva{" + "libroReservado=" + libroReservado + ", fecha=" + fecha + ", hora=" + hora + ", fechaDevolucion=" + fechaDevolucion + '}';
    }

  

    @Override
    public String obtenerFechaDevolución() {
        if (this.getLibroReservado() instanceof Libro){
            System.out.println("Es un libro");
            Calendar c= Calendar.getInstance();
            c.add(Calendar.DATE, 30);
            Date d=c.getTime();
            String fechaDevolucion = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            System.out.println("fecha de devolucion" + fechaDevolucion);
            this.setFechaDevolucion(fechaDevolucion);
            return fechaDevolucion;
        }
        return "No es un  libro";
    }

    @Override
    public void mostrarReservaChula() {
        System.out.println("-----------RESERVA------------");
        System.out.println(this.libroReservado.toString());
        System.out.println("-------------------------------");
        System.out.println("Prestado el día  " + fecha +" a las " + hora + " horas");
        System.out.println("Debe ser devuelto el día " +fechaDevolucion);
    }
    
    
    
}