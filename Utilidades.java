package tfg;
import java.util.Scanner;
public class Utilidades {
    public static int leenumerodel1al2()
    {
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
            else
            {
                errorLectura = false;
            }
        }
        while (errorLectura == true);
        return numero;
    }
    public static int leenumerodel1al4()
    {
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            System.out.println("¿Que dificultad deseas? \n1. Facil  \n2. Medio \n3. Dificil \n4. Salir del juego");
            numero = teclado.nextInt();
            if (numero <= 0 || numero>= 5){
                System.out.println("\033[31mError, solo se acepta los numeros 1 al 4"+"\u001B[0m");
                errorLectura = true;
            }
            else
            {
                errorLectura = false;
            }
        }
        while (errorLectura == true);
        return numero;
    }

    public static int leenumerofiladel1al8()
    {
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            System.out.println("¿Que fila deseas seleccionar?");
            numero = teclado.nextInt();
            if (numero <= 0 || numero>= 9){
                System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                errorLectura = true;
            }
            else
            {
                errorLectura = false;
            }
        }
        while (errorLectura == true);
        return numero;
    }
    public static int leenumerocolumnadel1al8()
    {
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            System.out.println("¿Que columna deseas seleccionar?");
            numero = teclado.nextInt();
            if (numero <= 0 || numero>= 9){
                System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                errorLectura = true;
            }
            else
            {
                errorLectura = false;
            }
        }
        while (errorLectura == true);
        return numero;
    }

    public static int leeacciondel1al4()
    {
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
            else
            {
                errorLectura = false;
            }
        }
        while (errorLectura == true);
        return numero;
    }

}
