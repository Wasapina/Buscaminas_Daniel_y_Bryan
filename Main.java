package tfg;
import tfg.campo.Campominas;

public class Main {
    public static void main(String[] args){
        int fila;
        int columna;
        int accion;
        boolean salir = false;
        do {
            int eleccion_jugar_registros = Utilidades.leenumerodel1al2();
            switch (eleccion_jugar_registros){
                case 1:
                    break;
                case 2:
                    boolean jugando = true;
                    boolean reiniciar = false;
                    do {
                        int selecdificultad = Utilidades.leenumerodel1al4() ;
                        if(selecdificultad != 4){
                            Campominas c1 = new Campominas(selecdificultad);
                        do {
                            c1.imprimir();
                            c1.comprueba_final(selecdificultad);

                            if(c1.comprueba_final(selecdificultad) == true){
                                reiniciar = true;
                                jugando = true;
                                salir = false;
                            }

                           do{
                                System.out.println("¿Que fila deseas seleccionar?");
                                fila = Utilidades.leenumerofilacolumna(selecdificultad)-1;}
                            while (fila==-1);
                            do{
                                System.out.println("¿Que columna deseas seleccionar?");
                                columna = Utilidades.leenumerofilacolumna(selecdificultad)-1;}
                            while (columna==-1);

                            c1.imprimirconseleccion(fila, columna);

                            if(c1.comprobar_x(fila,columna) == true) {

                                do{accion = Utilidades.leeacciondel1al4();}
                                while(accion == 0);

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
                            salir = false;
                        }
                    }while (reiniciar == true);
                    break;
            }
        }while (salir == false);
    }
}
