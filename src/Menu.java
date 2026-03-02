public class Menu {
    
    public static void bienvenida(){
        Colors.println(
            "Bienvenido a la cadena de farmacias UNA FARMACIA DE OTRO MUNDO :)", 
            Colors.HIGH_INTENSITY);

    }

    public static void menuPrincipal(){
        Colors.println("Selecciona una opcion"
        + "\n\t 1. Clientes"
        + "\n\t 2. Sucursales"
        + "\n\t 3. Medicamentos"
        + "\n\t 0. Salir", Colors.HIGH_INTENSITY);

    }

    public static void menuSecundario(){
        Colors.println("Selecciona una opcion" 
        + "\n\t 1. Agregar"
        + "\n\t 2. Consultar"
        + "\n\t 3. Editar"
        + "\n\t 4. Eliminar", Colors.HIGH_INTENSITY);
    }

    public static void error(String error){
        Colors.println(error , Colors.RED);
    }

    public static void pedirID(String tipo){
        switch (tipo) {
            case "C" -> Colors.println("Ingresa el ID del cliente", Colors.GREEN);
            case "S" -> Colors.println("Ingresa el ID de la sucursal", Colors.GREEN);
            case "M" -> Colors.println("Ingresa el ID del medicamento", Colors.GREEN);
            default -> System.out.println("");
        }
    }
}
