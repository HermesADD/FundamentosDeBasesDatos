
import java.util.List;

/**
 * Clase que representa un Libro de Direcciones.
 */
public class LibroDirecciones {
    
    /**
     * Lista de personas registradas en el libro de direcciones.
     */
    private List<Persona> personas;

    /**
     * Constructor de la clase LibroDirecciones.
     * 
     * @param personas lista inicial de personas que tendrá el libro de direcciones
     */
    public LibroDirecciones(List<Persona> personas) {
        this.personas = personas;
    }

    /**
     * Obtiene la lista de personas del libro de direcciones.
     * 
     * @return lista de personas
     */
    public List<Persona> getPersonas() {
        return personas;
    }

    /**
     * Establece la lista de personas del libro de direcciones.
     * 
     * @param personas nueva lista de personas
     */
    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
