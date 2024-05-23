
import java.util.Scanner;
public class Utilidades {

    /**
     * Metodo que lee numeros del 1 al 2
     * @return devuelve el numero introducido
     */
    public static int leernumerodel1al2(){
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            System.out.println("Buscaminas \n¿Que deseas hacer?:  \n1. Ver registros \n2. Jugar");
            numero = teclado.nextInt();
            if (numero <= 0 || numero>= 3){
                System.out.println("\033[31mError, solo se acepta los numeros 1 o 2"+"\u001B[0m");
                errorLectura = true;
            }
        }
        while (errorLectura == true);
        return numero;
    }

    /**
     * Metodo que lee numeros del 1 al 3
     * @return devuelve el numero introducido
     */
    public static int leernumerodel1al3(){
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            System.out.println("Que quieres hacer?");
            System.out.println("1. Ver registros totales");
            System.out.println("2. Ver registros de jugadores");
            System.out.println("3. Salir");
            numero = teclado.nextInt();
            if (numero <= 0 || numero>= 4){
                System.out.println("\033[31mError, solo se acepta los numeros 1 o 3"+"\u001B[0m");
                errorLectura = true;
            }
        }
        while (errorLectura == true);
        return numero;
    }

    /**
     * Metodo que lee numeros del 1 al 4
     * @return el numero introducido
     */
    public static int leernumerodel1al4() {
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            System.out.println("¿Que dificultad deseas? \n1. Facil  \n2. Medio \n3. Dificil \n4. Retroceder");
            numero = teclado.nextInt();
            if (numero <= 0 || numero>= 5){
                System.out.println("\033[31mError, solo se acepta los numeros 1 al 4"+"\u001B[0m");
                errorLectura = true;
            }
        }
        while (errorLectura == true);
        return numero;
    }

    /**
     * Metodo que lee numeros del 1 al 4 en la seccion de lectura
     * @return el numero introducido
     */
    public static int leenumerodel1al4lectura() {
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            numero = teclado.nextInt();
            if (numero <= 0 || numero>= 5){
                System.out.println("\033[31mError, solo se acepta los numeros 1 al 4"+"\u001B[0m");
                errorLectura = true;
            }
        }
        while (errorLectura == true);
        return numero;
    }
    /**
     * Metodo que lee numeros del 1 al 4 para la accion
     * @return el numero introducido
     */
    public static int leeacciondel1al4(){
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            System.out.println("¿Que deseas hacer? \n1. Despejar  \n2. Plantar bandera \n3. Quitar bandera \n4. Modo desarrollador");
            numero = teclado.nextInt();
            if (numero <= 0 || numero>= 5){
                System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                errorLectura = true;
            }
        }
        while (errorLectura == true);
        return numero;
    }

    /**
     * Metodo que lee filas dependiendo de la difultad
     * @param dificultad hace referencia a la dificultad del juego
     * @return el numero introducido si es correcto de lo contrario entra en bucle hasta que lee des un numero bueno
     */
    public static int leerfilasgeneral(int dificultad){
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura;
        if(dificultad == 1){
            do {
                errorLectura = false;
                System.out.println("¿Que fila deseas seleccionar?");
                numero = teclado.nextInt();
                if (numero <= 0 || numero>= 9){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                    errorLectura = true;
                }
            }
            while (errorLectura == true);
            return numero;
        }
        else if(dificultad == 2){
            do {
                errorLectura = false;
                System.out.println("¿Que fila deseas seleccionar?");
                numero = teclado.nextInt();
                if (numero <= 0 || numero>= 15){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 14"+"\u001B[0m");
                    errorLectura = true;
                }
            }
            while (errorLectura == true);
            return numero;
        }
        else{
            do {
                errorLectura = false;
                System.out.println("¿Que fila deseas seleccionar?");
                numero = teclado.nextInt();
                if (numero <= 0 || numero>= 21){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 20"+"\u001B[0m");
                    errorLectura = true;
                }
            }
            while (errorLectura == true);
            return numero;
        }
    }
    /**
     * Metodo que lee columnas dependiendo de la difultad
     * @param dificultad hace referencia a la dificultad del juego
     * @return el numero introducido si es correcto de lo contrario entra en bucle hasta que lee des un numero bueno
     */
    public static int leercolumnasgeneral(int dificultad){
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura;
        if(dificultad == 1){
            do {
                errorLectura = false;
                System.out.println("¿Que columna deseas seleccionar?");
                numero = teclado.nextInt();
                if (numero <= 0 || numero>= 9){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                    errorLectura = true;
                }
            }
            while (errorLectura == true);
            return numero;
        }
        else if(dificultad == 2){
            do {
                errorLectura = false;
                System.out.println("¿Que columna deseas seleccionar?");
                numero = teclado.nextInt();
                if (numero <= 0 || numero>= 15){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 14"+"\u001B[0m");
                    errorLectura = true;
                }
            }
            while (errorLectura == true);
            return numero;
        }
        else{
            do {
                errorLectura = false;
                System.out.println("¿Que columna deseas seleccionar?");
                numero = teclado.nextInt();
                if (numero <= 0 || numero>= 21){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 20"+"\u001B[0m");
                    errorLectura = true;
                }
            }
            while (errorLectura == true);
            return numero;
        }
    }




}
