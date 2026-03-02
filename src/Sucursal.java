public class Sucursal {
    private String idSucursal;
    private String nombre;
    private String direccion;
    private int numEmpleados;

    public Sucursal(){}
    
    public Sucursal(String idSucursal, String nombre, String direccion, int numEmpleados){
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numEmpleados = numEmpleados;
    }

    public String getIdSucursal(){
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal){
        this.idSucursal = idSucursal;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public int getNumeroEmpleados(){
        return numEmpleados;
    }

    public void setNumeroEmpleados(int numEmpleados){
        this.numEmpleados = numEmpleados;
    }

    public String toString(){
        return "\tID: " + idSucursal  +
        "\n\tNombre: " + nombre +
        "\n\tDireccion: " + direccion +
        "\n\tNumero de empleados: " + numEmpleados;
    }


}
