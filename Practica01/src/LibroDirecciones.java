import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Contenedor de personas y operaciones CRUD, con persistencia en Archivo.agenda.txt */
public class LibroDirecciones {
    private final List<Persona> personas = new ArrayList<>();

    /** Carga desde disco. */
    public void cargar() {
        try {
            personas.clear();
            personas.addAll(Archivo.cargarTodo());
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo: " + e.getMessage());
        }
    }

    /** Guarda en disco. */
    public void guardar() {
        try {
            Archivo.guardarTodo(personas);
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo: " + e.getMessage());
        }
    }

    public List<Persona> listar() { return personas; }

    public void agregar(Persona p) {
        personas.add(p);
        guardar();
    }

    public boolean eliminarPorNombre(String nombreCompleto) {
        boolean eliminado = personas.removeIf(
            p -> p.nombreCompleto().equalsIgnoreCase(nombreCompleto)
        );
        if(eliminado) guardar();
        return eliminado;
    }

    public Persona buscarPorNombre(String nombreCompleto) {
        return personas.stream()
            .filter(p -> p.nombreCompleto().equalsIgnoreCase(nombreCompleto))
            .findFirst()
            .orElse(null);
    }
}