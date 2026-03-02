import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Archivo<O> {
    private final Class<O> clase;    

    public Archivo(Class<O> clase){
        this.clase = clase;
    }

    public void guardar(String ruta, List<O> lista)throws IOException{
        try(var writer = new BufferedWriter(new FileWriter(ruta))){
            Field[] atributos = clase.getDeclaredFields();

            String primeraLinea = Arrays.stream(atributos)
                .map(Field:: getName)
                .collect(Collectors.joining(","));
            
            writer.write(primeraLinea);
            writer.newLine();

            for(O objeto : lista){
                String fila = Arrays.stream(atributos)
                    .map(atributo -> {
                        try {
                            atributo.setAccessible(true);
                            return String.valueOf(atributo.get(objeto));
                        } catch(IllegalAccessException e){
                            return "";
                        }
                    })
                    .collect(Collectors.joining(","));
                
                writer.write(fila);
                writer.newLine();
            }
        }
    }

    public List<O> leer(String ruta)throws IOException{
        List<O> objetos = new ArrayList<>();

        try(var reader = new BufferedReader(new FileReader(ruta))){
            String[] primeraFila = reader.readLine().split(",");
            Field[] atributos = clase.getDeclaredFields();

            String linea;

            while ((linea = reader.readLine()) != null){
                String[] valores = linea.split(",");

                O instancia = clase.getDeclaredConstructor().newInstance();
                
                for(int i = 0; i<valores.length; i++){
                    atributos[i].setAccessible(true);
                    Object valorCasteado = castearAtributo(atributos[i].getType(), valores[i]);
                    atributos[i].set(instancia, valorCasteado);
                }
                objetos.add(instancia);

            }
        }catch (ReflectiveOperationException e) {
            throw new RuntimeException("Error : Asegurate de tener un constructor vacio.", e);
        }
        return objetos;
    }

    private Object castearAtributo(Class<?> tipo, String valor){
        return switch (tipo.getSimpleName()){
            case "int", "Integer" -> Integer.parseInt(valor);
            case "double", "Double" -> Double.parseDouble(valor);
            case "boolean", "Boolean" -> Boolean.parseBoolean(valor);
            case "long", "Long" -> Long.parseLong(valor);
            default -> valor;
        };
    }
}
