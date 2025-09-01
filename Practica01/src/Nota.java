/**
 * Clase que representa una Nota dentro de una agenda electrónica.
 */
public class Nota {

    /**
     * Descripción de la nota en forma de texto.
     */
    private String descripcion;

    /**
     * Constructor de la clase Nota.
     *
     * @param nota contenido inicial de la nota
     */
    public Nota(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Constructor vacío.
     */
    public Nota(){}

    /**
     * Obtiene el contenido de la nota.
     * 
     * @return texto de la nota
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece el contenido de la nota.
     * 
     * @param descripcion nueva de la nota
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
