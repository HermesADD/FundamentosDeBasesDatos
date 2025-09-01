import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Archivo {

    public static final String RUTA = "agenda.txt";

    public static String limpiar(String s){
        if(s == null) return "";

        return s.replace("|", "").replace(
            "\n", " ").replace("\r", " ");

    }

    public static void guardarTodo(List<Persona> personas) throws IOException{
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RUTA), StandardCharsets.UTF_8))) {
            for (Persona p : personas) {
                bw.write(serialize(p));
                bw.newLine();
            }
        }
    }

    public static List<Persona> cargarTodo() throws  IOException{
        List<Persona> res = new ArrayList<>();
        File f = new File(RUTA);
        if (!f.exists()) return res;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                Persona p = deserialize(linea);
                if (p != null) res.add(p);
            }
        }
        return res;
    }

    private static String serialize(Persona p) {
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

    private static Persona deserialize(String line) {
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
