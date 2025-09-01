
import java.util.Arrays;
import java.util.Objects;


public class Persona {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direcciones;
    private String telefono;
    private String movil;
    private String correo;
    private String compania;
    private String puesto;
    private String url;
    private String fbk;
    private String ig;
    private Cita[] citas = new Cita[2];
    private Nota[] notas = new Nota[2];

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

    public Persona(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFbk() {
        return fbk;
    }

    public void setFbk(String fbk) {
        this.fbk = fbk;
    }

    public String getIg() {
        return ig;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    public Cita[] getCitas() {
        return citas;
    }

    public void setCitas(Cita[] citas) {
        if(citas == null){
            this.citas = new Cita[2];
        }else{ 
            this.citas = Arrays.copyOf(citas,2);
        }
    }

    public boolean agregarCita(Cita c){
        for(int i = 0; i<2; i++){
            if(this.citas[i] == null){
                this.citas[i] = c;
                return true;
            }
        }
        return false;
    }

    public Nota[] getNotas() {
        return notas;
    }

    public void setNotas(Nota[] notas) {
        if(notas == null){
            this.notas = new Nota[2];
        }else{
            this.notas = Arrays.copyOf(notas, 2);
        }
    }

    public boolean agregarNota(Nota n){
        for(int i = 0; i<2; i++){
            if(this.notas[i] == null){
                this.notas[i] = n;
                return true;
            }
        }
        return false;
    }

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
