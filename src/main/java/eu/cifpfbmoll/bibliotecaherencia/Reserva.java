
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
public class Reserva {
    private Libro libroReservado;
    private String fecha = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    private String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
    //public LocalTime horaReserva = LocalTime.now();
    //public ZonedDateTime fecha2 = ZonedDateTime.now();
    //public Date fechaReserva = new Date();

    public Reserva(Libro libroReservado) {
        this.setLibroReservado(libroReservado);
    }
    
    public Reserva(Reserva reserva) {
        this.setLibroReservado(reserva.getLibroReservado());
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
    
    //to string

    @Override
    public String toString() {
        return "Reserva{" + "libroReservado=" + libroReservado + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
    
    
}