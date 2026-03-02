public class Cliente {
    private String idCliente;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String telefono;

    public Cliente(){}
    
    /**
     * Constructor de la clase Cliente
     * @param idCliente ID único del cliente.
     * @param nombre - Nombre del cliente.
     * @param telefono
     */
    public Cliente(String idCliente, String nombre, String apPaterno, String apMaterno, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono = telefono;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno(){
        return apPaterno;
    }

    public void setApPaterno(String apPaterno){
        this.apPaterno = apPaterno;
    }

    public String getApMaterno(){
        return apMaterno;
    }

    public void setApMaterno(String apMaterno){
        this.apMaterno = apMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return "\tID: " + idCliente  +
        "\n\tNombre: " + nombre + " " +  apPaterno + " " + apMaterno +
        "\n\tTelefono: " + telefono;
    }

}