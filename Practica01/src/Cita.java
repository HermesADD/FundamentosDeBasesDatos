/**
 * Clase que representa una Cita de una agenda electrónica.
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
     * Constructor de la clase Cita.
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
     * Constructor vacío
     */
    public Cita(){}

    /**
     * Obtiene el título de la cita.
     * 
     * @return título de la cita
     */
    public String getTitulo() {
        return this.titulo;
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
    public String getFecha() {
        return this.fecha;
    }

    /**
     * Establece la fecha de la cita.
     * 
     * @param fecha nueva fecha de la cita
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de la cita.
     * 
     * @return hora de la cita
     */
    public String getHora() {
        return this.hora;
    }

    /**
     * Establece la hora de la cita.
     * 
     * @param hora nueva hora de la cita
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
