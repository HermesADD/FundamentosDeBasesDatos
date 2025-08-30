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

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre nuevo nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno de la persona.
     * 
     * @return apellido paterno
     */
    public String getApellido_Paterno() {
        return apellido_Paterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     * 
     * @param apellido_Paterno nuevo apellido paterno
     */
    public void setApellido_Paterno(String apellido_Paterno) {
        this.apellido_Paterno = apellido_Paterno;
    }

    /**
     * Obtiene el apellido materno de la persona.
     * 
     * @return apellido materno
     */
    public String getApellido_Materno() {
        return apellido_Materno;
    }

    /**
     * Establece el apellido materno de la persona.
     * 
     * @param apellido_Materno nuevo apellido materno
     */
    public void setApellido_Materno(String apellido_Materno) {
        this.apellido_Materno = apellido_Materno;
    }

    /**
     * Obtiene la dirección o direcciones de la persona.
     * 
     * @return direcciones de la persona
     */
    public String getDirecciones() {
        return direcciones;
    }

    /**
     * Establece la dirección o direcciones de la persona.
     * 
     * @param direcciones nuevas direcciones
     */
    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }

    /**
     * Obtiene el teléfono fijo de la persona.
     * 
     * @return teléfono fijo
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono fijo de la persona.
     * 
     * @param telefono nuevo número de teléfono fijo
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el número de móvil de la persona.
     * 
     * @return número de móvil
     */
    public String getMovil() {
        return movil;
    }

    /**
     * Establece el número de móvil de la persona.
     * 
     * @param movil nuevo número de móvil
     */
    public void setMovil(String movil) {
        this.movil = movil;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * 
     * @return correo electrónico
     */
    public String getC_electronico() {
        return c_electronico;
    }

    /**
     * Establece el correo electrónico de la persona.
     * 
     * @param c_electronico nuevo correo electrónico
     */
    public void setC_electronico(String c_electronico) {
        this.c_electronico = c_electronico;
    }

    /**
     * Obtiene la compañía en la que trabaja la persona.
     * 
     * @return compañía
     */
    public String getCompania() {
        return compania;
    }

    /**
     * Establece la compañía en la que trabaja la persona.
     * 
     * @param compania nueva compañía
     */
    public void setCompania(String compania) {
        this.compania = compania;
    }

    /**
     * Obtiene el puesto laboral de la persona.
     * 
     * @return puesto de la persona
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto laboral de la persona.
     * 
     * @param puesto nuevo puesto de la persona
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene la URL personal o profesional de la persona.
     * 
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Establece la URL personal o profesional de la persona.
     * 
     * @param url nueva URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Obtiene la cuenta de Facebook de la persona.
     * 
     * @return cuenta de Facebook
     */
    public String getFbk() {
        return fbk;
    }

    /**
     * Establece la cuenta de Facebook de la persona.
     * 
     * @param fbk nueva cuenta de Facebook
     */
    public void setFbk(String fbk) {
        this.fbk = fbk;
    }

    /**
     * Obtiene la cuenta de Instagram de la persona.
     * 
     * @return cuenta de Instagram
     */
    public String getIg() {
        return ig;
    }

    /**
     * Establece la cuenta de Instagram de la persona.
     * 
     * @param ig nueva cuenta de Instagram
     */
    public void setIg(String ig) {
        this.ig = ig;
    }

    /**
     * Obtiene la lista de citas de la persona.
     * 
     * @return lista de citas
     */
    public List<Cita> getCitas() {
        return citas;
    }

    /**
     * Establece la lista de citas de la persona.
     * 
     * @param citas nueva lista de citas
     */
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    /**
     * Obtiene la lista de notas de la persona.
     * 
     * @return lista de notas
     */
    public List<Nota> getNotas() {
        return notas;
    }

    /**
     * Establece la lista de notas de la persona.
     * 
     * @param notas nueva lista de notas
     */
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
