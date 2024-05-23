package campominas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Guardar {

    /**
     * Metodo que guarda los datos totales de una persona que ha jugado una partida
     * @param partidas_jugadas hace referencia a las partidas totales de todos los jugadores
     * @param partidas_ganadas hace referencia a las partidas ganadas de todos los jugadores
     * @param partidas_perdidas hace referencia a las partidas perdidas de todos los jugadores
     */
    public static void guardar_datos_totales(Integer partidas_jugadas, Integer partidas_ganadas, Integer partidas_perdidas){//esto está muy cogido con pinzas
        String ruta = "datos_totales.txt";
        File total = new File(ruta);
        if (total.exists()) {
            try {
                FileWriter escribir = new FileWriter(total);
                BufferedWriter bufer = new BufferedWriter(escribir);
                total.delete();
                bufer.write(partidas_jugadas.toString());
                bufer.newLine();
                bufer.write(partidas_ganadas.toString());
                bufer.newLine();
                bufer.write(partidas_perdidas.toString());
                bufer.close();
                escribir.close();
            } catch (IOException e) {
                System.out.println("No se pudieron guardar los datos");
            }
        }
    }
    /**
     * Metodo que guarda los datos dependiendo de la dificultad
     * @param nombre hace referencia al nombre del usuario
     * @param minutos hace referencia a los minutos que le tomo acabar la partida al usuario
     */
    public static void guardar_datos(String nombre,  Integer minutos, int dificultad) {
        String ruta;
        switch (dificultad){
            case 1:
                ruta = "resultados_facil.txt";
                guardarnombre(ruta, nombre, minutos,dificultad);
                break;
            case 2:
                ruta = "resultados_medio.txt";
                guardarnombre(ruta, nombre, minutos,dificultad);
                break;
            case 3:
                ruta = "resultados_dificil.txt";
                guardarnombre(ruta, nombre, minutos,dificultad);
                break;
        }
        ruta = "resultados_general.txt";
        guardarnombre(ruta, nombre, minutos,dificultad);

    }
    /**
     * Metodo que guarda el nombre del jugador que ha ganado
     * @param ruta hace referencia a la ruta en donde se va a guardar el nombre del jugador
     * @param nombre hace referencia al nombre del jugador ganador
     * @param minutos hace referencia a los minutos que el jugador a jugado en la partida
     */
    public static void guardarnombre(String ruta, String nombre, Integer minutos, int dificultad){
        try {
            File resultados = new File(ruta);
            String dif;
            BufferedWriter escribir = new BufferedWriter(new FileWriter(resultados.getAbsoluteFile(), true));
            if (resultados.exists()) {
                if (ruta.equals("resultados_general.txt")){
                    if (dificultad==1){
                        dif = "facil";
                    } else if (dificultad==2) {
                        dif="medio";
                    }else {
                        dif="dificil";
                    }
                    escribir.write("nombre: "+nombre+" tiempo: "+minutos+" minutos, en la dificultad "+dif+" Fecha: "+ LocalDate.now()+" "+ LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
                }else {
                    escribir.write("nombre: " + nombre + " tiempo: " + minutos + " minutos");
                }
            }
            escribir.newLine();
            escribir.close();
        }catch (IOException e){
            System.out.println("Error no se pudo guardar el nombre");
        }
    }

    /**
     * METODO QUE GUARDA LA PARTIDA PERDIDA
     */
    public static void partida_perdida_guardar(){
        guardar_datos_totales(Imprimir.devolver_jugadas()+1,Imprimir.devolver_ganadas(),Imprimir.devolver_perdidas()+1);
    }
    /**
     * METODO QUE GUARDA LA PARTIDA GANADA
     */
    public static void partida_ganada_guardar(){
        guardar_datos_totales(Imprimir.devolver_jugadas()+1,Imprimir.devolver_ganadas()+1,Imprimir.devolver_perdidas());
    }
}
