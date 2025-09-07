/**
 * Clase que representa una nota simple que contiene una descripción.
 * 
 * @author Hermes Alberto Delgado Díaz
 */
public class Nota {

    /**
     * La descripción o el contenido de la nota.
     */
    private String descripcion;

    /**
     * Construye un nuevo objeto Nota con la descripción proporcionada.
     *
     * @param descripcion La cadena de texto que se utilizará como contenido de la nota.
     */
    public Nota(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Construye un objeto Nota vacío con una descripción predeterminada (null).
     */
    public Nota(){}

    /**
     * Obtiene la descripción o el contenido de la nota.
     *
     * @return La cadena que contiene la descripción de la nota.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece o actualiza la descripción de la nota.
     *
     * @param descripcion La nueva cadena de texto para la descripción de la nota.
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
