/**
 * Clase que representa una Nota dentro de una agenda electrónica.
 */
public class Nota {

    /**
     * Contenido de la nota en forma de texto.
     */
    private String nota;

    /**
     * Constructor de la clase Nota.
     *
     * @param nota contenido inicial de la nota
     */
    public Nota(String nota) {
        this.nota = nota;
    }

    /**
     * Obtiene el contenido de la nota.
     * 
     * @return texto de la nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * Establece el contenido de la nota.
     * 
     * @param nota nuevo texto de la nota
     */
    public void setNota(String nota){
        this.nota = nota;
    }

    @Override
    public String toString(){
        return this.nota;
    }
}
