import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una lista de objetos {@link Persona}, actuando como
 * un libro de direcciones.
 * 
 * Se encarga de la carga, guardado, listado, adición, eliminación y búsqueda
 * de personas. La persistencia de los datos se maneja a través de la clase
 * {@link Archivo}.
 * 
 * @author Hermes Alberto Delgado Díaz
 * @see Persona
 * @see Archivo
 */
public class LibroDirecciones {

    /**
     * La lista interna que almacena los objetos Persona.
     */
    private final List<Persona> personas = new ArrayList<>();

    /**
     * Carga el libro de direcciones desde el archivo.
     * Si ocurre un error de lectura, muestra un mensaje en la terminal.
     */
    public void cargar() {
        try {
            personas.clear();
            personas.addAll(Archivo.cargarTodo());
        } catch (IOException e) {
            Colors.println("No se pudo cargar el archivo: " + e.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
        }
    }

    /**
     * Guarda el libro de direcciones en el archivo.
     * Si ocurre un error de escritura, muestra un mensaje en la terminal.
     */
    public void guardar() {
        try {
            Archivo.guardarTodo(personas);
        } catch (IOException e) {
            Colors.println("No se pudo guardar el archivo: " + e.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
        }
    }

    /**
     * Agrega una nueva persona al libro de direcciones y guarda los cambios automáticamente.
     *
     * @param p El objeto {@link Persona} a agregar.
     */
    public void agregar(Persona p) {
        personas.add(p);
        guardar();
    }

    /**
     * Elimina una persona del libro de direcciones por su nombre completo.
     * Los cambios se guardan automáticamente si se realiza una eliminación.
     *
     * @param nombreCompleto El nombre completo de la persona a eliminar.
     * @return {@code true} si la persona fue eliminada con éxito, {@code false} si no se encontró.
     */
    public boolean eliminarPorNombre(String nombreCompleto) {
        boolean eliminado = personas.removeIf(
            p -> p.nombreCompleto().equalsIgnoreCase(nombreCompleto)
        );
        if(eliminado) guardar();
        return eliminado;
    }

    /**
     * Busca una persona en el libro de direcciones por su nombre completo.
     *
     * @param nombreCompleto El nombre completo de la persona a buscar.
     * @return El objeto {@link Persona} si se encuentra, o {@code null} si no se encuentra.
     */
    public Persona buscarPorNombre(String nombreCompleto) {
        return personas.stream()
            .filter(p -> p.nombreCompleto().equalsIgnoreCase(nombreCompleto))
            .findFirst()
            .orElse(null);
    }
}