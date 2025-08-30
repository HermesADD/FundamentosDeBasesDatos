import java.util.List;

/**
 * Clase que representa a una Persona con información de contacto, 
 * datos laborales, redes sociales, así como sus citas y notas asociadas.
 */
public class Persona {

    /**
     * Nombre de la persona.
     */
    private String nombre;

    /**
     * Apellido paterno de la persona.
     */
    private String apellido_Paterno;

    /**
     * Apellido materno de la persona.
     */
    private String apellido_Materno;

    /**
     * Dirección o direcciones de la persona.
     */
    private String direcciones;

    /**
     * Teléfono de casa o principal de la persona.
     */
    private String telefono;

    /**
     * Número de teléfono móvil de la persona.
     */
    private String movil;

    /**
     * Correo electrónico de la persona.
     */
    private String c_electronico;

    /**
     * Compañía o empresa en la que trabaja la persona.
     */
    private String compania;

    /**
     * Puesto o cargo que ocupa la persona en su trabajo.
     */
    private String puesto;

    /**
     * URL personal o profesional de la persona (ej. página web).
     */
    private String url;

    /**
     * Enlace o usuario de Facebook de la persona.
     */
    private String fbk;

    /**
     * Enlace o usuario de Instagram de la persona.
     */
    private String ig;

    /**
     * Lista de citas asociadas a la persona.
     */
    private List<Cita> citas;

    /**
     * Lista de notas asociadas a la persona.
     */
    private List<Nota> notas;

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre Nombre de la persona
     * @param apellido_Paterno Apellido paterno
     * @param apellido_Materno Apellido materno
     * @param direcciones Dirección de la persona
     * @param telefono Teléfono fijo
     * @param movil Teléfono móvil
     * @param c_electronico Correo electrónico
     * @param compania Empresa en la que trabaja
     * @param puesto Puesto que ocupa
     * @param url URL personal o profesional
     * @param fbk Cuenta de Facebook
     * @param ig Cuenta de Instagram
     * @param citas Lista de citas
     * @param notas Lista de notas
     */
    public Persona(String nombre, String apellido_Paterno, String apellido_Materno, String direcciones, String telefono,
                   String movil, String c_electronico, String compania, String puesto, String url, String fbk, String ig,
                   List<Cita> citas, List<Nota> notas) {
        this.nombre = nombre;
        this.apellido_Paterno = apellido_Paterno;
        this.apellido_Materno = apellido_Materno;
        this.direcciones = direcciones;
        this.telefono = telefono;
        this.movil = movil;
        this.c_electronico = c_electronico;
        this.compania = compania;
        this.puesto = puesto;
        this.url = url;
        this.fbk = fbk;
        this.ig = ig;
        this.citas = citas;
        this.notas = notas;
    }

    /** @return Nombre de la persona */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre Nombre de la persona */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return Apellido paterno */
    public String getApellido_Paterno() {
        return apellido_Paterno;
    }

    /** @param apellido_Paterno Apellido paterno */
    public void setApellido_Paterno(String apellido_Paterno) {
        this.apellido_Paterno = apellido_Paterno;
    }

    /** @return Apellido materno */
    public String getApellido_Materno() {
        return apellido_Materno;
    }

    /** @param apellido_Materno Apellido materno */
    public void setApellido_Materno(String apellido_Materno) {
        this.apellido_Materno = apellido_Materno;
    }

    /** @return Dirección o direcciones */
    public String getDirecciones() {
        return direcciones;
    }

    /** @param direcciones Dirección o direcciones */
    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }

    /** @return Teléfono fijo */
    public String getTelefono() {
        return telefono;
    }

    /** @param telefono Teléfono fijo */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /** @return Teléfono móvil */
    public String getMovil() {
        return movil;
    }

    /** @param movil Teléfono móvil */
    public void setMovil(String movil) {
        this.movil = movil;
    }

    /** @return Correo electrónico */
    public String getC_electronico() {
        return c_electronico;
    }

    /** @param c_electronico Correo electrónico */
    public void setC_electronico(String c_electronico) {
        this.c_electronico = c_electronico;
    }

    /** @return Compañía */
    public String getCompania() {
        return compania;
    }

    /** @param compania Compañía */
    public void setCompania(String compania) {
        this.compania = compania;
    }

    /** @return Puesto */
    public String getPuesto() {
        return puesto;
    }

    /** @param puesto Puesto */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /** @return URL */
    public String getUrl() {
        return url;
    }

    /** @param url URL */
    public void setUrl(String url) {
        this.url = url;
    }

    /** @return Cuenta de Facebook */
    public String getFbk() {
        return fbk;
    }

    /** @param fbk Cuenta de Facebook */
    public void setFbk(String fbk) {
        this.fbk = fbk;
    }

    /** @return Cuenta de Instagram */
    public String getIg() {
        return ig;
    }

    /** @param ig Cuenta de Instagram */
    public void setIg(String ig) {
        this.ig = ig;
    }

    /** @return Lista de citas */
    public List<Cita> getCitas() {
        return citas;
    }

    /** @param citas Lista de citas */
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    /** @return Lista de notas */
    public List<Nota> getNotas() {
        return notas;
    }

    /** @param notas Lista de notas */
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
