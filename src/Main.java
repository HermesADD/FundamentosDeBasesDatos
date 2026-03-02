import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final SistemaFarmacia<Cliente> clientes = new SistemaFarmacia<>(Cliente.class, "clientes.csv", "Cliente");
    private static final SistemaFarmacia<Medicamento> medicamentos = new SistemaFarmacia<>(Medicamento.class, "medicamentos.csv", "Medicamento");
    private static final SistemaFarmacia<Sucursal> sucursales = new SistemaFarmacia<>(Sucursal.class, "sucursales.csv", "Sucursal");

    public static void main(String[] args) {
        Menu.bienvenida();
        int op;
        do {
            Menu.menuPrincipal();
            op = leerEntero();
            switch (op) {
                case 1 -> gestionar(clientes, "C");
                case 2 -> gestionar(sucursales, "S");
                case 3 -> gestionar(medicamentos, "M");
                case 0 -> Colors.println("Saliendo...", Colors.YELLOW);
                default -> Menu.error("Opción inválida.");
            }
        } while (op != 0);
    }

    private static <O> void gestionar(SistemaFarmacia<O> sistema, String tipo){
        Menu.menuSecundario();
        int op = leerEntero();
        
        switch (op) {
            case 1 -> { // AGREGAR con validación de ID Único
                try {
                    O nuevo = capturarDatos(tipo, null);
                    if (nuevo != null) {
                        sistema.agregar(nuevo);
                        Colors.println("Registro exitoso.", Colors.GREEN);
                    }
                } catch (Exception e) {
                    Menu.error(e.getMessage());
                }
            }
            case 2 -> { // CONSULTAR
                Menu.pedirID(tipo);
                O res = sistema.buscarPorID(sc.nextLine());
                if (res != null) Colors.println("\n" + res, Colors.CYAN);
                else Menu.error("No se encontró el registro.");
            }
            case 3 -> { // EDITAR
                Menu.pedirID(tipo);
                String id = sc.nextLine();
                if (sistema.existeID(id)) {
                    O editado = capturarDatos(tipo, id); // Mantenemos el mismo ID
                    sistema.editar(id, editado);
                    Colors.println("Actualización exitosa.", Colors.GREEN);
                } else Menu.error("El ID no existe.");
            }
            case 4 -> { // ELIMINAR
                Menu.pedirID(tipo);
                String id = sc.nextLine();
                if (sistema.existeID(id)) {
                    sistema.eliminar(id);
                    Colors.println("Eliminado correctamente.", Colors.YELLOW);
                } else Menu.error("ID no encontrado.");
            }
        }
    }

    private static <O> O capturarDatos(String tipo, String idExistente){
        try {
            String id;
            if (idExistente == null) {
                while (true) {
                    System.out.print("Ingrese ID (6 dígitos numéricos): ");
                    id = sc.nextLine();
                    if (id.matches("\\d{6}")) { 
                        break;
                    }
                    Menu.error("Error: El ID debe ser de exactamente 6 números.");
                }
            } else {
                id = idExistente;
            }

            // El resto del switch permanece igual para capturar los atributos...
            return switch (tipo) {
                case "C" -> {
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Ap Paterno: "); String p = sc.nextLine();
                    System.out.print("Ap Materno: "); String m = sc.nextLine();
                    System.out.print("Tel: "); String t = sc.nextLine();
                    yield (O) new Cliente(id, n, p, m, t); //
                }
                case "M" -> {
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Precio: "); double pr = Double.parseDouble(sc.nextLine()); //
                    System.out.print("Stock: "); int st = Integer.parseInt(sc.nextLine()); //
                    yield (O) new Medicamento(id, n, pr, st);
                }
                case "S" -> {
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Dirección: "); String d = sc.nextLine();
                    System.out.print("Num Empleados: "); int e = Integer.parseInt(sc.nextLine()); //
                    yield (O) new Sucursal(id, n, d, e);
                }
                default -> null;
            };
        } catch (NumberFormatException e) {
        Menu.error("Error: En los campos numéricos solo se permiten números."); //
        return null;
        }
    }

    private static int leerEntero() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) { 
            return -1;
        }
    }

}
