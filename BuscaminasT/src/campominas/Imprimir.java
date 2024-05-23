package campominas;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Imprimir {


    /**
     * Metodo que imprime los registros totales
     */
    public static void imprimir_totales(){
        System.out.println("Se han jugado "+devolver_jugadas()+" partidas");
        System.out.println("Se han ganado "+devolver_ganadas()+" partidas");
        System.out.println("Se han perdido "+devolver_perdidas()+" partidas");
    }

    /**
     * Metodo que imprime por nombre, busca los nombre de los jugadores que han ganado una partida
     * @param nombre hace referencia al nombre del jugador ganador
     * @return dependiendo si el nombre existe o no
     * @throws FileNotFoundException expcion de que el archivo no existe
     * @throws IOException excepción cuando estamos interactuando un fichero
     */
    public static boolean imprimirpornombre(String nombre)throws FileNotFoundException, IOException{
        String rutanombre = "resultados_general.txt";
        FileReader leernombre = new FileReader(rutanombre);
        BufferedReader imprimirnombre = new BufferedReader(leernombre);
        String nombre2;
        boolean existe = false;
        System.out.println("--------------");
        try {
            while ((nombre2 = imprimirnombre.readLine()) != null) {
                Pattern registro = Pattern.compile("\\b" + Pattern.quote(nombre) + "\\b", Pattern.CASE_INSENSITIVE);
                Matcher buscar = registro.matcher(nombre2);
                if (buscar.find()) {
                    System.out.println(nombre2);
                    existe = true;
                }
            }
        } catch (Exception e) {

        }
        System.out.println("--------------");
        return  existe;
    }

    /**
     * Metodo que imprime por dificultad
     * @param dif hace referencia a la dificultad de la partida
     * @throws FileNotFoundException expecion cuando el archivo no ha sido entontrado
     * @throws IOException expecion
     */
    public static void imprimirpordif(int dif)throws FileNotFoundException, IOException {
        String rutanombre;
        if (dif==1){
            rutanombre = "resultados_facil.txt";
        } else if (dif==2) {
            rutanombre = "resultados_medio.txt";
        }else {
            rutanombre = "resultados_dificil.txt";
        }
        FileReader leernombre = new FileReader(rutanombre);
        BufferedReader imprimirnombre = new BufferedReader(leernombre);
        String nombre;
        try {
            while((nombre = imprimirnombre.readLine()) != null) {
                System.out.println("--------------");
                System.out.println(nombre);}
        }
        catch (Exception e){
            System.out.println("Archivo no encontrado");
        }
    }

    /**
     * Metodo que imprime datos de todos los jugadores que han jugado en el buscaminas
     * @throws FileNotFoundException exepecion por si el archivo no fue encontrado
     * @throws IOException excepción cuando estamos interactuando un fichero
     */
    public static void imprimirdatos() throws FileNotFoundException, IOException {
        String rutanombre = "resultados_general.txt";
        FileReader leernombre = new FileReader(rutanombre);
        BufferedReader imprimirnombre = new BufferedReader(leernombre);
        String nombre;
        try {
            while ((nombre = imprimirnombre.readLine()) != null) {
                System.out.println("--------------");
                System.out.println(nombre);}
        }
        catch (Exception e){
            System.out.println("Archivo no encontrado");
        }
    }
    /**
     * Metodo que devuelve partidas ganadas por el usuario
     * @return los datos si hay registros de que se ha ganado una partida, de lo contrario devuelve 0
     */
    public static Integer devolver_ganadas(){
        ArrayList<Integer> datos1 = obtener_datos_totales();
        if(!datos1.isEmpty() && datos1.size() >= 1){
            return datos1.get(1);
        }
        return 0;
    }
    /**
     * Meotodo que obtiene los datos totales de un determina archivo en este caso : datos_totales.txt
     * @return los datos totales guardados
     */
    public static ArrayList<Integer> obtener_datos_totales(){
        ArrayList<Integer>guardardatos = new ArrayList<Integer>();
        String ruta = "datos_totales.txt";
        File leer = new File(ruta);
        String dato;
        if (leer.exists()) {
            try {
                FileReader lectura = new FileReader(leer);
                BufferedReader lecfinal = new BufferedReader(lectura);
                while ((dato = lecfinal.readLine()) != null) {
                    Integer dato2 = Integer.valueOf(dato);
                    guardardatos.add(dato2);
                }
                lecfinal.close();
                lectura.close();
                return guardardatos;
            } catch (IOException j) {
                System.out.println("no se pudo leer el archivo");
            }
        }else {
            Guardar.guardar_datos_totales(0,0,0);
        }
        return guardardatos;
    }

    /**
     * Metodo que devuelve partidas jugadas por el usuario
     * @return los datos si hay registros de que se ha jugado una partida, de lo contrario devuelve 0
     */
    public static Integer devolver_jugadas() {
        ArrayList<Integer> datos = obtener_datos_totales();
        if (!datos.isEmpty() && datos.size() >= 1) {
            return datos.get(0);
        }
        return 0;
    }

    /**
     * Metodo que devuelve partidas perdidas por el usuario
     * @return los datos si hay partidas perdidas , de lo contrario devuelve 0
     */
    public static Integer devolver_perdidas(){
        ArrayList<Integer> datos2 = obtener_datos_totales();
        if(!datos2.isEmpty() && datos2.size() >= 1){
            return datos2.get(2);
        }
        return 0;
    }



}
