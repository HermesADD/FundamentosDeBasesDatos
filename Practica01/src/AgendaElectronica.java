import java.util.Scanner;

/** Programa principal (main) de la Agenda Electrónica. */
public class AgendaElectronica {
    private static final Scanner sc = new Scanner(System.in);
    private static final LibroDirecciones libro = new LibroDirecciones();

    public static void main(String[] args) {
        System.out.println("=== Agenda Electrónica (con archivo.txt) ===");
        libro.cargar();
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String op = sc.nextLine().trim();
            switch (op) {
                case "1" -> buscarRegistro();
                case "2" -> agregarRegistro();
                case "3" -> eliminarRegistro();
                case "4" -> ponerCita();
                case "5" -> escribirNota();
                case "6" -> {
                }
                case "7" -> listarTodo();
                case "0" -> salir = true;
                default -> System.out.println("Opción inválida");
            }
        }
        System.out.println("¡Hasta luego!");
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Buscar registro (persona)");
        System.out.println("2. Agregar registro");
        System.out.println("3. Eliminar registro");
        System.out.println("4. Poner cita a un registro (máx 2)");
        System.out.println("5. Escribir nota a un registro (máx 2)");
        System.out.println("6. Imprimir calendario (año y mes)");
        System.out.println("7. Listar todos los registros");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void buscarRegistro() {
        System.out.print("Nombre completo a buscar: ");
        String nombre = sc.nextLine();
        Persona p = libro.buscarPorNombre(nombre);
        if (p == null) System.out.println("No encontrado.");
        else System.out.println("\n--- Registro ---\n" + p + "\n-----------------");
    }

    private static void agregarRegistro() {
        Persona p = new Persona();
        System.out.println("== Nuevo registro ==");
        System.out.print("Nombre(s): "); p.setNombre(sc.nextLine());
        System.out.print("Apellido paterno: "); p.setApellidoPaterno(sc.nextLine());
        System.out.print("Apellido materno: "); p.setApellidoMaterno(sc.nextLine());
        System.out.print("Dirección(es): "); p.setDirecciones(sc.nextLine());
        System.out.print("Teléfono: "); p.setTelefono(sc.nextLine());
        System.out.print("Móvil: "); p.setMovil(sc.nextLine());
        System.out.print("Correo: "); p.setCorreo(sc.nextLine());
        System.out.print("Compañía: "); p.setCompania(sc.nextLine());
        System.out.print("Puesto: "); p.setPuesto(sc.nextLine());
        System.out.print("URL: "); p.setUrl(sc.nextLine());
        System.out.print("Facebook (Fbk): "); p.setFbk(sc.nextLine());
        System.out.print("Instagram (IG): "); p.setIg(sc.nextLine());
        libro.agregar(p);
        System.out.println("Registro guardado: " + p.nombreCompleto());
    }

    private static void eliminarRegistro() {
        System.out.print("Nombre completo a eliminar: ");
        String nombre = sc.nextLine();
        if (libro.eliminarPorNombre(nombre)) System.out.println("Eliminado.");
        else System.out.println("No se encontró ese registro.");
    }

    private static void ponerCita() {
        System.out.print("Nombre completo de la persona: ");
        String nombre = sc.nextLine();
        Persona p = libro.buscarPorNombre(nombre);
        if (p == null) { System.out.println("No encontrado."); return; }
        Cita c = new Cita();
        System.out.print("Título de la cita: "); c.setTitulo(sc.nextLine());
        System.out.print("Fecha (AAAA-MM-DD): "); c.setFecha(sc.nextLine());
        System.out.print("Hora (HH:MM): "); c.setHora(sc.nextLine());
        if (p.agregarCita(c)) {
            libro.guardar();
            System.out.println("Cita agregada.");
        } else {
            System.out.println("No hay espacio: ya tiene 2 citas.");
        }
    }

    private static void escribirNota() {
        System.out.print("Nombre completo de la persona: ");
        String nombre = sc.nextLine();
        Persona p = libro.buscarPorNombre(nombre);
        if (p == null) { System.out.println("No encontrado."); return; }
        System.out.print("Escribe la nota: ");
        Nota n = new Nota(sc.nextLine());
        if (p.agregarNota(n)) {
            libro.guardar();
            System.out.println("Nota agregada.");
        } else {
            System.out.println("No hay espacio: ya tiene 2 notas.");
        }
    }

    private static void listarTodo() {
        for (Persona p : libro.listar()) {
            System.out.println("\n" + p);
            System.out.println("--------------------------");
        }
        if (libro.listar().isEmpty()) {
            System.out.println("No hay registros todavía.");
        }
    }
}