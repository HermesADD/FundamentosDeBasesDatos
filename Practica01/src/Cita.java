
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase que representa una Cita de una agenda electrónica.
 */
public class Cita {
    /**
     * Título o descripción breve de la cita.
     */
    private String titulo;

    /**
     * Fecha en la que ocurrirá la cita.
     */
    private LocalDate fecha;

    /**
     * Hora en la que ocurrirá la cita.
     */
    private LocalTime hora;

    /**
     * Constructor de la clase Cita.
     *
     * @param titulo Título o descripción de la cita
     * @param fecha  Fecha de la cita
     * @param hora   Hora de la cita
     */
    public Cita(String titulo, LocalDate fecha, LocalTime hora) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
    }

    /**
     * Obtiene el título de la cita.
     * 
     * @return título de la cita
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la cita.
     * 
     * @param titulo nuevo título de la cita
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la fecha de la cita.
     * 
     * @return fecha de la cita
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la cita.
     * 
     * @param fecha nueva fecha de la cita
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de la cita.
     * 
     * @return hora de la cita
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora de la cita.
     * 
     * @param hora nueva hora de la cita
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
