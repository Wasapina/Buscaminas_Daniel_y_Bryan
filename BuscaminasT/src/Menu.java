import campominas.Campominas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    /**
     * Metodo que llama a las clases para empezar el juego
     * @throws IOException excepción cuando estamos interactuando un fichero
     */
    public static void juego() throws IOException {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        LocalDateTime fechinicio;
        LocalDateTime fechfinalizado;
        Campominas leer = new Campominas(1);
        do {
            int eleccion_jugar_registros = Utilidades.leernumerodel1al2();

            switch (eleccion_jugar_registros) {
                case 1:
                    boolean salirlectura = false;
                    do {
                        int elecregistro = Utilidades.leernumerodel1al3();
                        switch (elecregistro) {
                            case 1:
                                leer.imprimir_totales();
                                break;
                            case 2:
                                System.out.println("Que deseas ver?:\n1. Todos los datos \n2. Datos de todas las dificultades  \n3. Datos de una dificultad especifica \n4. Buscar por nombre");
                                elecregistro = Utilidades.leenumerodel1al4lectura();
                                try {
                                    switch (elecregistro) {
                                        case 1:
                                            leer.imprimirdatos();
                                            break;
                                        case 2:
                                            System.out.println("Facil");
                                            leer.imprimirpordif(1);
                                            System.out.println("Medio");
                                            leer.imprimirpordif(2);
                                            System.out.println("Dificil");
                                            leer.imprimirpordif(3);
                                            break;
                                        case 3:
                                            System.out.println("Que dificultad deseas ver?: \n1. Facil \n2. Medio \n3. Dificil \n4. Retroceder");
                                            int difi = Utilidades.leenumerodel1al4lectura();
                                            if (difi != 4) {
                                                leer.imprimirpordif(difi);
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Que nombre deseas ver");
                                            String nom = teclado.next();
                                            if (leer.imprimirpornombre(nom) == false) {
                                                System.out.println("no se pudo encontrar ese nombre");
                                            }
                                            break;
                                    }
                                } catch (FileNotFoundException e) {
                                    System.out.println("No se encontraron archivos");
                                } catch (IOException j) {
                                    System.out.println("No se puede leer");
                                }
                                break;
                            case 3:
                                salirlectura = true;
                                break;
                        }
                    } while (salirlectura == false);
                    break;
                case 2:
                    boolean jugando = true;
                    boolean reiniciar = false;
                    do {
                        int selecdificultad = Utilidades.leernumerodel1al4();
                        Campominas c1 = new Campominas(selecdificultad);
                        c1.crearinicio();
                        fechinicio = LocalDateTime.now();
                        if (selecdificultad > 0 && selecdificultad < 4) {
                            do {
                                c1.imprimir();
                                int fila = Utilidades.leerfilasgeneral(selecdificultad) - 1;
                                int columna = Utilidades.leercolumnasgeneral(selecdificultad) - 1;
                                c1.imprimirconseleccion(fila, columna);
                                if (c1.comprobar_fila(fila, columna) == true) {
                                    int accion = Utilidades.leeacciondel1al4();
                                    switch (accion) {
                                        case 1:
                                            if (c1.despejar_campo(fila, columna) != true) {

                                            } else {
                                                System.out.println("\033[31mPisaste una mina\nFin de la partida" + "\u001B[0m");
                                                c1.imprimirfinal();
                                                jugando = false;
                                                c1.partida_perdida_guardar();
                                                c1.vaciararray();
                                            }
                                            if (c1.terminar() == true) {
                                                jugando = false;
                                                fechfinalizado = LocalDateTime.now();
                                                c1.victoria(fechinicio, fechfinalizado);
                                                c1.vaciararray();
                                            }
                                            break;
                                        case 2:
                                            c1.poner_bandera(fila, columna);
                                            break;
                                        case 3:
                                            c1.quitar_bandera(fila, columna);
                                            break;
                                        case 4:
                                            c1.impadmin();
                                            break;
                                    }
                                }
                            } while (jugando == true);
                        } else if (selecdificultad == 4) {
                            reiniciar = false;
                        } else {
                            reiniciar = false;
                            salir = true;
                        }
                    } while (reiniciar == true);
                    break;
            }
        } while (salir == false);

    }




}
