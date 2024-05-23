package campominas;
import java.io.IOException;

public class Creacionarchi {
    /**
     * Metodo que se encarga de llamar a otra clase para crear arhcivos
     * @throws IOException excepción cuando estamos interactuando un fichero
     */
    public static void Creaarchivos() throws IOException {
        Campominas leer = new Campominas(1);
        leer.crearinicio();

    }

}
