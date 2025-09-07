import java.time.DateTimeException;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Clase que se utiliza para generar e imprimir un calendario mensual.
 * 
 * @author Hermes Alberto Delgado Diaz
 */
public class Calendario {
    
    /**
     * Imprime un calendario mensual para un mes y año específicos.
     *
     * @param mes La cadena de texto que representa el mes en formato numérico (MM).
     * @param anio La cadena de texto que representa el año en formato numérico (AAAA).
     */
    public static void imprimirCalendario(String mes, String anio){
        if(mes == null || anio == null){
            Colors.println("El mes o año es vacío.(Inválido)", Colors.RED);
            return;
        }

        mes = mes.trim();
        anio = anio.trim();

        if(!mes.matches("\\d{2}")){
            Colors.println("El mes debe estar en formato MM (dos dígitos).", Colors.RED);
            return;
        }
        if (!anio.matches("\\d{4}")) {
            Colors.println("El año debe estar en formato AAAA (cuatro dígitos).", Colors.RED);
            return;
        }

        try {
            int m = Integer.parseInt(mes);
            int a = Integer.parseInt(anio);
            
            if (m < 1 || m > 12) {
                Colors.println("Error: el mes debe estar entre 01 y 12.", Colors.RED);
                return;
            }

            YearMonth anioMes = YearMonth.of(a, m);

            String nombreMes = anioMes.getMonth().getDisplayName(TextStyle.FULL, new Locale("es","MX"));

            Colors.println("Calendario de " + nombreMes + " " + a, Colors.HIGH_INTENSITY);
            Colors.println("-----------------------------------", Colors.WHITE);
            Colors.println("Lu  Ma  Mi  Ju  Vi  Sá  Do", Colors.HIGH_INTENSITY + Colors.ITALICS);

            int primerDiaMes = anioMes.atDay(1).getDayOfWeek().getValue();
            for (int i = 1; i < primerDiaMes; i++) {     
                System.out.print("    "); 
            }

            int diasEnElMes = anioMes.lengthOfMonth();
            for (int dia = 1; dia <= diasEnElMes; dia++) {
                System.out.printf("%2d  ", dia);
                if ((dia + primerDiaMes - 1) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println();

        } catch (NumberFormatException e) {
            Colors.println("El mes y el año deben ser valores numéricos. (MM y AAAA)", Colors.RED);
        } catch (DateTimeException e) {
            Colors.println("Los valores de mes o año no son válidos. Asegúrate de que el mes esté entre 1 y 12.", Colors.RED);
        }
    }
}
