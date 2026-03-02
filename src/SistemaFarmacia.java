import java.util.*;
import java.io.IOException;

public class SistemaFarmacia<O> {
    private final Archivo<O> gestor;
    private final String ruta;
    private List<O> datos;
    private final String nombreEntidad;

    public SistemaFarmacia(Class<O> clase, String ruta, String nombreEntidad){
        this.gestor = new Archivo<>(clase);
        this.ruta = ruta;
        this.nombreEntidad = nombreEntidad;
        this.cargarDatos();
    }

    private void cargarDatos(){
        try{
            this.datos = new ArrayList<>(gestor.leer(ruta));
        }catch (IOException e){
            this.datos = new ArrayList<>();
        }
    }

    public boolean existeID(String id){
        return buscarPorID(id) != null;
    }

    public void validarFormatoId(String id) throws Exception {
    if (!id.matches("\\d{6}")) {
        throw new Exception("Formato inválido: El ID debe tener exactamente 6 números (Ej: 941123).");
    }
}

    public void agregar(O objeto)throws Exception{
        String idNuevo = obtenerID(objeto);
    
        validarFormatoId(idNuevo);

        if(existeID(idNuevo)){
            throw new Exception("El ID '" + idNuevo + "' ya existe. Debe ser único."); // Validación de unicidad
        }

        datos.add(objeto);
        guardar();
    }

    public void editar(String id, O objetoEditado){
        for(int i = 0; i<datos.size(); i++){
            if(obtenerID(datos.get(i)).equals(id)){
                datos.set(i, objetoEditado);
                guardar();
                return;
            }
        }
    }

    public void guardar(){
        try {
            gestor.guardar(ruta, datos);
        } catch (IOException e) {
            Menu.error("Error de escritura: " + e.getMessage());
        }   
    }

    public O buscarPorID(String id){
        return datos.stream()
            .filter(obj -> obtenerID(obj).equals(id))
            .findFirst()
            .orElse(null);
    }

    public void eliminar(String id){
        datos.removeIf(obj -> obtenerID(obj).equals(id));
        guardar();
    }

    private String obtenerID(O objeto){
        try{
            var atributoID = objeto.getClass().getDeclaredFields()[0];
            atributoID.setAccessible(true);
            return atributoID.get(objeto).toString();
        }catch(Exception e){
            return "";
        }
    }
}
