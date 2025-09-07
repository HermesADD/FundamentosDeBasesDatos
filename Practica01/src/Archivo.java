import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
/**
 * Clase que se encarga de guardar y cargar una lista de objetos {@link Persona}
 * desde y hacia un archivo de texto, utilizando un formato delimitado por el
 * carácter de barra vertical (|).
 *
 * @author Hermes Alberto Delgado Díaz 319258613
 */
public class Archivo {

    /**
     * La ruta del archivo donde se guardará la agenda electrónica.
     */
    public static final String RUTA = "AgendaElectronica.txt";

    /**
     * Limpia una cadena de texto, eliminando los caracteres que podrían interferir
     * con el formato de delimitación del archivo.
     *
     * @param s La cadena a limpiar.
     * @return La cadena limpia, con los caracteres de barra vertical, salto de línea
     * y retorno de carro reemplazados. Si la entrada es nula, devuelve una cadena vacía.
     */
    public static String limpiar(String s){
        if(s == null) return "";

        return s.replace("|", "").replace(
            "\n", " ").replace("\r", " ");

    }

    /**
     * Guarda la lista de personas en un archivo de texto.
     * 
     * Cada objeto {@link Persona} se convierte en una línea de texto
     * y se escribe en el archivo. 
     *
     * @param personas La lista de objetos {@link Persona} a guardar.
     * @throws IOException Si ocurre un error de entrada/salida durante la escritura.
     */
    public static void guardarTodo(List<Persona> personas) throws IOException{
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RUTA), StandardCharsets.UTF_8))) {
            for (Persona p : personas) {
                bw.write(convertirPersonaATexto(p));
                bw.newLine();
            }
        }
    }

    /**
     * Carga una lista de personas desde un archivo de texto.
     * 
     * Lee el archivo línea por línea, convirtiendo cada línea en un objeto
     * {@link Persona}. Si el archivo no existe, devuelve una lista vacía.
     *
     * @return Una lista de objetos {@link Persona} leídos del archivo.
     * @throws IOException Si ocurre un error de entrada/salida durante la lectura.
     */
    public static List<Persona> cargarTodo() throws  IOException{
        List<Persona> res = new ArrayList<>();
        File f = new File(RUTA);
        if (!f.exists()) return res;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                Persona p = convertirTextoAPersona(linea);
                if (p != null) res.add(p);
            }
        }
        return res;
    }

    /**
     * Convierte un objeto {@link Persona} en una cadena de texto para su almacenamiento.
     * 
     * Los campos de la persona, incluyendo las citas y notas, se concatenan y
     * se separan por el carácter de barra vertical (|).
     *
     * @param p El objeto {@link Persona} a convertir.
     * @return La cadena de texto que representa a la persona.
     */
    private static String convertirPersonaATexto(Persona p) {
        StringBuilder sb = new StringBuilder();
        sb.append(limpiar(p.getNombre())).append("|")
          .append(limpiar(p.getApellidoPaterno())).append("|")
          .append(limpiar(p.getApellidoMaterno())).append("|")
          .append(limpiar(p.getDirecciones())).append("|")
          .append(limpiar(p.getTelefono())).append("|")
          .append(limpiar(p.getMovil())).append("|")
          .append(limpiar(p.getCorreo())).append("|")
          .append(limpiar(p.getCompania())).append("|")
          .append(limpiar(p.getPuesto())).append("|")
          .append(limpiar(p.getUrl())).append("|")
          .append(limpiar(p.getFbk())).append("|")
          .append(limpiar(p.getIg()));

        // Citas (cada una: titulo, fecha, hora)
        Cita[] citas = p.getCitas();
        for (int i = 0; i < 2; i++) {
            Cita c = (citas != null && i < citas.length) ? citas[i] : null;
            sb.append("|").append(limpiar(c != null ? c.getTitulo() : ""));
            sb.append("|").append(limpiar(c != null ? c.getFecha() : ""));
            sb.append("|").append(limpiar(c != null ? c.getHora() : ""));
        }
        // Notas
        Nota[] notas = p.getNotas();
        for (int i = 0; i < 2; i++) {
            Nota n = (notas != null && i < notas.length) ? notas[i] : null;
            sb.append("|").append(limpiar(n != null ? n.getDescripcion() : ""));
        }
        return sb.toString();
    }

    /**
     * Convierte una línea de texto de un archivo en un objeto {@link Persona}.
     * 
     * La línea de texto debe estar en el formato correcto, con los campos
     * separados por el carácter de barra vertical (|).
     *
     * @param line La cadena de texto a convertir.
     * @return El objeto {@link Persona} creado a partir de la cadena, o {@code null}
     * si el formato de la línea no es válido.
     */
    private static Persona convertirTextoAPersona(String line) {
        String[] parts = line.split("\\|", -1); // -1 conserva vacíos
        if (parts.length < 12) return null;
        int idx = 0;
        Persona p = new Persona();
        p.setNombre(parts[idx++]);
        p.setApellidoPaterno(parts[idx++]);
        p.setApellidoMaterno(parts[idx++]);
        p.setDirecciones(parts[idx++]);
        p.setTelefono(parts[idx++]);
        p.setMovil(parts[idx++]);
        p.setCorreo(parts[idx++]);
        p.setCompania(parts[idx++]);
        p.setPuesto(parts[idx++]);
        p.setUrl(parts[idx++]);
        p.setFbk(parts[idx++]);
        p.setIg(parts[idx++]);

        Cita[] citas = new Cita[2];
        for (int i = 0; i < 2; i++) {
            String titulo = (idx < parts.length) ? parts[idx++] : "";
            String fecha  = (idx < parts.length) ? parts[idx++] : "";
            String hora   = (idx < parts.length) ? parts[idx++] : "";
            if (!titulo.isEmpty() || !fecha.isEmpty() || !hora.isEmpty()) {
                citas[i] = new Cita(titulo, fecha, hora);
            } else {
                citas[i] = null;
            }
        }
        p.setCitas(citas);

        Nota[] notas = new Nota[2];
        for (int i = 0; i < 2; i++) {
            String desc = (idx < parts.length) ? parts[idx++] : "";
            notas[i] = desc.isEmpty() ? null : new Nota(desc);
        }
        p.setNotas(notas);
        return p;
    }
    
}
