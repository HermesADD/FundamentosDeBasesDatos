
import java.util.Arrays;
import java.util.Objects;

/**
 * Clase que representa a una persona con detalles personales y laborales.
 * 
 * @author Hermes Alberto Delgado Díaz
 */
public class Persona {

    /**
     * Número máximo de citas que puede tener una persona
     */
    private final int MAX_CITAS = 2;

    /**
     * Número máximo de notas que puede tener una persona
     */
    private final int MAX_NOTAS = 2;

    /**
     * Nombre de la persona
     */
    private String nombre;

    /**
     * Apellido Paterno de la persona
     */
    private String apellidoPaterno;

    /**
     * Apellido Materno de la persona
     */
    private String apellidoMaterno;

    /**
     * Direccion(es) de la persona
     */
    private String direcciones;

    /**
     * Telefono fijo de la persona
     */
    private String telefono;

    /**
     * Telefono movil(celular) de la persona
     */
    private String movil;

    /**
     * Correo electronico de la persona
     */
    private String correo;

    /**
     * Compañia donde trabaja la persona
     */
    private String compania;

    /**
     * Puesto de la persona en su compañia
     */
    private String puesto;

    /**
     * URL de la persona 
     */
    private String url;

    /**
     * Facebook de la persona
     */
    private String fbk;

    /**
     * Instagram de la persona
     */
    private String ig;

    /**
     * Un arreglo para almacenar las citas de la persona, con una capacidad máxima de 2.
     * @see Cita
     */
    private Cita[] citas = new Cita[MAX_CITAS];

    /**
     * Un arreglo para almacenar las notas de la persona, con una capacidad máxima de 2.
     * @see Nota
     */
    private Nota[] notas = new Nota[MAX_NOTAS];

    /**
     * Construye un nuevo objeto Persona con todos los detalles proporcionados.
     *
     * @param nombre El nombre.
     * @param apellidoPaterno El apellido paterno.
     * @param apellidoMaterno El apellido materno.
     * @param direcciones La(s) dirección(es).
     * @param telefono El teléfono fijo.
     * @param movil El teléfono móvil.
     * @param correo El correo electrónico.
     * @param compania El nombre de la compañía.
     * @param puesto El puesto de trabajo.
     * @param url La URL.
     * @param fbk El enlace del perfil de Facebook.
     * @param ig El enlace del perfil de Instagram.
     * @param citas Un arreglo de citas.
     * @param notas Un arreglo de notas.
     */
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String direcciones, String telefono,
            String movil, String correo, String compania, String puesto, String url, String fbk, String ig,
            Cita[] citas, Nota[] notas) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direcciones = direcciones;
        this.telefono = telefono;
        this.movil = movil;
        this.correo = correo;
        this.compania = compania;
        this.puesto = puesto;
        this.url = url;
        this.fbk = fbk;
        this.ig = ig;
        this.citas = citas;
        this.notas = notas;
    }

    /**
     * Construye un objeto Persona vacío con valores predeterminados.
     */
    public Persona(){}

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * @param nombre El nuevo nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno de la persona.
     * @return El apellido paterno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     * @param apellidoPaterno El nuevo apellido paterno a establecer.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno de la persona.
     * @return El apellido materno.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno de la persona.
     * @param apellidoMaterno El nuevo apellido materno a establecer.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la(s) dirección(es) de la persona.
     * @return La(s) dirección(es).
     */
    public String getDirecciones() {
        return direcciones;
    }

    /**
     * Establece la(s) dirección(es) de la persona.
     * @param direcciones La(s) nueva(s) dirección(es) a establecer.
     */
    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }

    /**
     * Obtiene el teléfono fijo.
     * @return El teléfono fijo.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono fijo.
     * @param telefono El nuevo teléfono fijo a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el teléfono móvil.
     * @return El teléfono móvil.
     */
    public String getMovil() {
        return movil;
    }

    /**
     * Establece el teléfono móvil.
     * @param movil El nuevo teléfono móvil a establecer.
     */
    public void setMovil(String movil) {
        this.movil = movil;
    }

    /**
     * Obtiene el correo electrónico.
     * @return El correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico.
     * @param correo El nuevo correo electrónico a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el nombre de la compañía.
     * @return El nombre de la compañía.
     */
    public String getCompania() {
        return compania;
    }

    /**
     * Establece el nombre de la compañía.
     * @param compania El nuevo nombre de la compañía a establecer.
     */
    public void setCompania(String compania) {
        this.compania = compania;
    }

    /**
     * Obtiene el puesto de trabajo de la persona.
     * @return El puesto de trabajo.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto de trabajo de la persona.
     * @param puesto El nuevo puesto de trabajo a establecer.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene la URL.
     * @return La URL.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Establece la URL.
     * @param url La nueva URL a establecer.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Obtiene el enlace del perfil de Facebook.
     * @return El enlace de Facebook.
     */
    public String getFbk() {
        return fbk;
    }

    /**
     * Establece el enlace del perfil de Facebook.
     * @param fbk El nuevo enlace de Facebook a establecer.
     */
    public void setFbk(String fbk) {
        this.fbk = fbk;
    }

    /**
     * Obtiene el enlace del perfil de Instagram.
     * @return El enlace de Instagram.
     */
    public String getIg() {
        return ig;
    }

    /**
     * Establece el enlace del perfil de Instagram.
     * @param ig El nuevo enlace de Instagram a establecer.
     */
    public void setIg(String ig) {
        this.ig = ig;
    }

    /**
     * Obtiene el arreglo de citas.
     * @return Un arreglo que contiene las citas.
     */
    public Cita[] getCitas() {
        return citas;
    }

    /**
     * Establece el arreglo de citas. Si el arreglo proporcionado es nulo,
     * inicializa un nuevo arreglo de tamaño 2. De lo contrario, copia los
     * elementos del arreglo proporcionado, truncándolo a tamaño 2 si es necesario.
     * @param citas El nuevo arreglo de citas a establecer.
     */
    public void setCitas(Cita[] citas) {
        if(citas == null){
            this.citas = new Cita[2];
        }else{ 
            this.citas = Arrays.copyOf(citas,2);
        }
    }

    /**
     * Agrega una nueva cita al siguiente espacio disponible en el arreglo de citas.
     *
     * @param c La cita a agregar.
     * @return {@code true} si la cita se agregó con éxito, {@code false} si el arreglo está lleno.
     */
    public boolean agregarCita(Cita c){
        for(int i = 0; i<2; i++){
            if(this.citas[i] == null){
                this.citas[i] = c;
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene el arreglo de notas.
     * @return Un arreglo que contiene las notas.
     */
    public Nota[] getNotas() {
        return notas;
    }

    /**
     * Establece el arreglo de notas. Si el arreglo proporcionado es nulo,
     * inicializa un nuevo arreglo de tamaño 2. De lo contrario, copia los
     * elementos del arreglo proporcionado, truncándolo a tamaño 2 si es necesario.
     * @param notas El nuevo arreglo de notas a establecer.
     */
    public void setNotas(Nota[] notas) {
        if(notas == null){
            this.notas = new Nota[2];
        }else{
            this.notas = Arrays.copyOf(notas, 2);
        }
    }

    /**
     * Agrega una nueva nota al siguiente espacio disponible en el arreglo de notas.
     *
     * @param n La nota a agregar.
     * @return {@code true} si la nota se agregó con éxito, {@code false} si el arreglo está lleno.
     */
    public boolean agregarNota(Nota n){
        for(int i = 0; i<2; i++){
            if(this.notas[i] == null){
                this.notas[i] = n;
                return true;
            }
        }
        return false;
    }

    /**
     * Crea y devuelve el nombre completo de la persona, concatenando el nombre,
     * el apellido paterno y el apellido materno.
     *
     * @return Una cadena que representa el nombre completo, con espacios entre los nombres y los apellidos.
     */
    public String nombreCompleto(){
        return String.format("%s %s %s",
            Objects.toString(this.nombre, ""),
            Objects.toString(apellidoPaterno, ""),
            Objects.toString(apellidoMaterno,"")).trim();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombreCompleto())
          .append("\nTel: ").append(this.telefono)
          .append("  Móvil: ").append(this.movil)
          .append("\nCorreo: ").append(this.correo)
          .append("\nCompañía: ").append(this.compania).append("  Puesto: ").append(this.puesto)
          .append("\nURL: ").append(this.url)
          .append("\nFBK: ").append(this.fbk).append("  IG: ").append(this.ig)
          .append("\nDirección: ").append(this.direcciones);

        for(int i = 0; i<2; i++){
            Cita c = citas[i];
            sb.append("\nCita ").append(i+1).append(": ");
            if(c == null){
                sb.append("(vacía)");
            }else{
                sb.append(c.toString());
            }
        }

        for (int i = 0; i < 2; i++) {
            Nota n = notas[i];
            sb.append("\nNota ").append(i+1).append(": ");
            if (n == null){ 
                sb.append("(vacía)");
            }else{ 
                sb.append(n.getDescripcion());
            }
        }

        return sb.toString();
    }
    
}
