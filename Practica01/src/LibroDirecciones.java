
import java.util.List;

public class LibroDirecciones {
    private List<Persona> personas;

    public LibroDirecciones(List<Persona> personas){
        this.personas = personas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
