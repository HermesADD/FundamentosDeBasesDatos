public class Medicamento {
    private String idMedicamento;
    private String nombre;
    private double precio;
    private int stock;

    public Medicamento(){}
    
    public Medicamento(String idMedicamento, String nombre, double precio, int stock){
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getIdMedicamento(){
        return idMedicamento;
    }

    public void setIdMedicamento(String idMedicamento){
        this.idMedicamento = idMedicamento;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    @Override
    public String toString(){
        return "\tID: " + idMedicamento  +
        "\n\tNombre: " + nombre +
        "\n\tPrecio: " + precio +
        "\n\tStock: " + stock;

    }
}
