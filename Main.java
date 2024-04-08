package tfg;
import tfg.campo.Campominas;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        int eleccion_jugar_registros = Utilidades.leenumerodel1al2();
        do {
            switch (eleccion_jugar_registros){
                case 1:
                    break;
                case 2:
                    boolean jugando = true;
                    boolean reiniciar = false;
                    do {
                        int selecdificultad = Utilidades.leenumerodel1al4();
                        Campominas c1 = new Campominas(selecdificultad);
                        if(selecdificultad != 4){
                        do {
                            c1.imprimir();
                            int fila = Utilidades.leenumerofiladel1al8()-1;
                            int columna = Utilidades.leenumerocolumnadel1al8()-1;
                            c1.imprimirconseleccion(fila, columna);
                            if(c1.comprobar_x(fila,columna) == true) {
                                int accion = Utilidades.leeacciondel1al4();
                                switch (accion) {
                                    case 1:
                                        if (c1.despejar_campo(fila, columna) != true) {
                                        } else {
                                            System.out.println("\033[31mPisaste una mina\nFin de la partida" + "\u001B[0m");
                                            c1.imprimirfinal();
                                            jugando = false;
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
                        }
                        else{
                            reiniciar=false;
                            salir = true;
                        }
                    }while (reiniciar == true);
                    break;
            }
        }while (salir == false);

    }
}