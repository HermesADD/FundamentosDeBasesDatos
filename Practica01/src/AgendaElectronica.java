import java.util.Scanner;

public class AgendaElectronica {
    /**
     * Objeto Scanner para leer la entrada del usuario desde la consola.
     */
    private static final Scanner sc = new Scanner(System.in);
    
    /**
     * Instancia de {@link LibroDirecciones} para gestionar la lista de personas.
     */
    private static final LibroDirecciones libro = new LibroDirecciones();

    public static void main(String[] args) {
        Colors.println("Bienvenid@ a mi Agenga Electrónica!!!!", Colors.HIGH_INTENSITY);
        libro.cargar();
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String op = sc.nextLine().trim();
            switch (op) {
                case "1" -> agregarRegistro();
                case "2" -> buscarRegistro();
                case "3" -> modificarRegistro();
                case "4" -> eliminarRegistro();
                case "5" -> imprimirCalendario();
                case "0" -> salir = true;
                default -> Colors.println("Opción inválida", Colors.RED);
            }
        }
        Colors.println("¡Nos vemos!", Colors.HIGH_INTENSITY);
    }

    /**
     * Muestra el menú principal con las opciones disponibles para el usuario.
     */
    private static void mostrarMenu() {
        Colors.println("\nMenú Principal:", Colors.CYAN + Colors.HIGH_INTENSITY);
        Colors.println("1. Añadir registro", Colors.CYAN + Colors.ITALICS);
        Colors.println("2. Buscar registro", Colors.CYAN + Colors.ITALICS);
        Colors.println("3. Modificar registro", Colors.CYAN + Colors.ITALICS);
        Colors.println("4. Eliminar registro", Colors.CYAN + Colors.ITALICS);
        Colors.println("5. Imprimir calendario (año y mes)", Colors.CYAN + Colors.ITALICS);
        Colors.println("0. Salir", Colors.CYAN + Colors.ITALICS);
        Colors.print("Elige una opción: ", Colors.CYAN + Colors.ITALICS);
    }

    /**
     * Permite al usuario agregar un nuevo registro de persona.
     */
    private static void agregarRegistro() {
        Persona p = new Persona();
        Colors.println("== Nuevo registro ==" , Colors.GREEN + Colors.HIGH_INTENSITY);
        Colors.print("Nombre(s): ", Colors.GREEN); p.setNombre(sc.nextLine());
        Colors.print("Apellido paterno: ", Colors.GREEN); p.setApellidoPaterno(sc.nextLine());
        Colors.print("Apellido materno: ", Colors.GREEN); p.setApellidoMaterno(sc.nextLine());
        Colors.print("Dirección(es): ", Colors.GREEN); p.setDirecciones(sc.nextLine());
        Colors.print("Teléfono: ", Colors.GREEN); p.setTelefono(sc.nextLine());
        Colors.print("Móvil: ", Colors.GREEN); p.setMovil(sc.nextLine());
        Colors.print("Correo: ", Colors.GREEN); p.setCorreo(sc.nextLine());
        Colors.print("Compañía: ", Colors.GREEN); p.setCompania(sc.nextLine());
        Colors.print("Puesto: ", Colors.GREEN); p.setPuesto(sc.nextLine());
        Colors.print("URL: ", Colors.GREEN); p.setUrl(sc.nextLine());
        Colors.print("Facebook: ", Colors.GREEN); p.setFbk(sc.nextLine());
        Colors.print("Instagram: ", Colors.GREEN); p.setIg(sc.nextLine());
        libro.agregar(p);
        Colors.println("Registro guardado: " + p.nombreCompleto(), Colors.GREEN);
    }

    /**
     * Permite al usuario buscar un registro por nombre completo.
     */
    private static void buscarRegistro() {
        Colors.print("Nombre completo a buscar: ", Colors.GREEN + Colors.HIGH_INTENSITY);
        String nombre = sc.nextLine();
        Persona p = libro.buscarPorNombre(nombre);
        if (p == null) Colors.println("Registro no encontrado.", Colors.RED);
        else Colors.println("\n--- Registro ---\n" + p + "\n-----------------", Colors.GREEN);
    }

    /**
     * Muestra el submenú de opciones para modificar un registro
     * (añadir cita o nota).
     */
    private static void modificarRegistro(){
        Colors.println("1. Poner cita a un registro (máx 2)", Colors.CYAN + Colors.ITALICS);
        Colors.println("2. Escribir nota a un registro (máx 2)", Colors.CYAN + Colors.ITALICS);
        String op = sc.nextLine().trim();
            switch (op) {
                case "1" -> ponerCita();
                case "2" -> escribirNota();
                default -> Colors.println("Opción inválida", Colors.RED);
            }
    }

    /**
     * Permite al usuario eliminar un registro por nombre completo.
     */
    private static void eliminarRegistro() {
        Colors.print("Nombre completo a eliminar: ", Colors.MAGENTA);
        String nombre = sc.nextLine();
        if (libro.eliminarPorNombre(nombre)) Colors.println("Eliminado.", Colors.MAGENTA + Colors.HIGH_INTENSITY);
        else Colors.println("No se encontró ese registro.", Colors.RED);
    }

    /**
     * Permite al usuario añadir una nueva cita a una persona existente.
     * 
     * Si la persona no tiene espacio para más citas, se muestra un mensaje de error.
     */
    private static void ponerCita() {
        Colors.print("Nombre completo de la persona: ", Colors.MAGENTA);
        String nombre = sc.nextLine();
        Persona p = libro.buscarPorNombre(nombre);
        if (p == null) { Colors.println("No encontrado.", Colors.RED); return; }
        Cita c = new Cita();
        Colors.print("Título de la cita: ", Colors.MAGENTA); c.setTitulo(sc.nextLine());
        Colors.print("Fecha (DD-MM-AAAA): ", Colors.MAGENTA); c.setFecha(sc.nextLine());
        Colors.print("Hora (HH:MM): ", Colors.MAGENTA); c.setHora(sc.nextLine());
        if (p.agregarCita(c)) {
            libro.guardar();
            Colors.println("Cita agregada.", Colors.GREEN);
        } else {
            Colors.println("No hay espacio: ya tiene 2 citas.", Colors.RED);
        }
    }

    /**
     * Permite al usuario añadir una nueva nota a una persona existente.
     * 
     * Si la persona no tiene espacio para más notas, se muestra un mensaje de error.
     */
    private static void escribirNota() {
        Colors.print("Nombre completo de la persona: ", Colors.MAGENTA);
        String nombre = sc.nextLine();
        Persona p = libro.buscarPorNombre(nombre);
        if (p == null) { Colors.println("No encontrado.", Colors.RED); return; }
        Colors.print("Escribe la nota: ", Colors.MAGENTA);
        Nota n = new Nota(sc.nextLine());
        if (p.agregarNota(n)) {
            libro.guardar();
            Colors.println("Nota agregada.", Colors.GREEN);
        } else {
            Colors.println("No hay espacio: ya tiene 2 notas.", Colors.RED);
        }
    }

    /**
     * Permite al usuario imprimir el calendario de un mes y año específicos.
     * 
     * Solicita el mes y el año y utiliza el método estático de la clase
     * {@link Calendario} para generar la salida.
     */
    private static void imprimirCalendario(){
        Colors.print("Mes (MM, 01-12): ", Colors. GREEN);
        String mes = sc.nextLine();
        Colors.print("Año (AAAA, 4 dígitos): ", Colors.GREEN);
        String anio = sc.nextLine();
        Calendario.imprimirCalendario(mes, anio);
    }
}