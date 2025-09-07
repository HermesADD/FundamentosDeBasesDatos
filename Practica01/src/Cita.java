/**
 * Clase que representa una Cita de una agenda electrónica.
 * 
 * @author Hermes Alberto Delgado Díaz 319258613
 */
public class Cita {
    /**
     * Título o descripción breve de la cita.
     */
    private String titulo;

    /**
     * Fecha en la que ocurrirá la cita. e.g., 2025-09-01
     */
    private String fecha;

    /**
     * Hora en la que ocurrirá la cita. e.g. 14:30
     */
    private String hora;

    /**
     * Construye un nuevo objeto Cita
     *
     * @param titulo Título o descripción de la cita
     * @param fecha  Fecha de la cita
     * @param hora   Hora de la cita
     */
    public Cita(String titulo, String fecha, String hora) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
    }

    /**
     * Construye un nuevo objeto Cita vacío con valores predeterminados
     */
    public Cita(){}

    /**
     * Obtiene el título de la cita.
     * @return El título de la cita.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Establece el título de la cita.
     * @param titulo El nuevo título de la cita.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la fecha de la cita.
     * @return La fecha de la cita.
     */
    public String getFecha() {
        return this.fecha;
    }

    /**
     * Establece la fecha de la cita.
     * @param fecha La nueva fecha de la cita.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de la cita.
     * @return La hora de la cita.
     */
    public String getHora() {
        return this.hora;
    }

    /**
     * Establece la hora de la cita.
     * @param hora La nueva hora de la cita.
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return String.format("%s | %s %s", 
            titulo == null ? "" : titulo, 
            fecha == null ? "" : fecha, 
            hora == null ? "" : hora).trim();
    }
}
