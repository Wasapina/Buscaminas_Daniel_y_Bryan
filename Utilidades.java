package tfg;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Utilidades {

    /**
     * Metodo que solo lee los numeros, 1 o 2 , si se le pasa un caracter que no sea un numero hara bucle
     * @return el numero que has introducido si es correcto, de lo contrario devolvera un mensaje de error
     */
    public static int leenumerodel1al2(){
        try {
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
        }catch (InputMismatchException ime){
            System.out.println("Solo acepta numeros, no otros caracteres");
            return 0;
        }
    }

    /**
     * Metodo que solo lee los numeros del 1 al 4, si se le pasa un caracter que no sea un numero volvera al menu
     * @return el numero que has introducido si es correcto, de lo contrario devolvera un mensaje de eror
     */
    public static int leenumerodel1al4(){
        try {
            Scanner teclado = new Scanner(System.in);
            int numero;
            boolean errorLectura = false;
            do {
                System.out.println("¿Que dificultad deseas? \n1. Facil  \n2. Medio \n3. Dificil \n4. Volver al menu");
                numero = teclado.nextInt();
                if (numero <= 0 || numero >= 5) {
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 4" + "\u001B[0m");
                    errorLectura = true;
                } else {
                    errorLectura = false;
                }
            }
            while (errorLectura == true);
            return numero;
        }catch (InputMismatchException ime){
            System.out.println("Error , solo se acepta numeros no caracteres");
            return 4;
        }
    }

    /**
     * Metodo que depediendo de la dificultad te permite seleccionar unos rangos de numeros siendo estos :
     * Dificultad facil =  1-8 , Dificultad medio = 1-14 , Dificultad dificil = 1-20 para la fila
     * si se le pasa un caracter que no sea un numero hara bucle
     * @param dificultad hace referencia a la dificultad antes ya elegida
     * @return el numero si esta en dicho rango, de lo contrario devulve un mensaje de error
     */
    public static int leenumerofiladel1al8(int dificultad){
        try{
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            System.out.println("¿Que fila deseas seleccionar?");
            numero = teclado.nextInt();
            if(dificultad == 1){
                if (numero <= 0 || numero>= 9){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                    errorLectura = true;
                }
                else
                {
                    errorLectura = false;
                }
            }
            else if(dificultad == 2){
                if (numero <= 0 || numero>= 15){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                    errorLectura = true;
                }
                else
                {
                    errorLectura = false;
                }
            }
            else{
                if (numero <= 0 || numero>= 21){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                    errorLectura = true;
                }
                else
                {
                    errorLectura = false;
                }
            }
        }
        while (errorLectura == true);
        return numero;
        }catch (InputMismatchException ime){
            System.out.println("Solo acepta numeros, no otros caracteres");
            return 0;
        }
    }

    /**
     * Metodo que depediendo de la dificultad te permite seleccionar unos rangos de numeros siendo estos :
     * Dificultad facil =  1-8 , Dificultad medio = 1-14 , Dificultad dificil = 1-20 para la columna
     * si se le pasa un caracter que no sea un numero hara bucle
     * @param dificultad hace referencia a la dificultad antes ya elegida
     * @return el numero si esta en dicho rango, de lo contrario devulve un mensaje de error
     */
    public static int leenumerocolumnadel1al8(int dificultad) {
        try{
        Scanner teclado = new Scanner(System.in);
        int numero;
        boolean errorLectura = false;
        do {
            System.out.println("¿Que columna deseas seleccionar?");
            numero = teclado.nextInt();
            if(dificultad == 1){
                if (numero <= 0 || numero>= 9){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                    errorLectura = true;
                }
                else
                {
                    errorLectura = false;
                }
            }
            else if(dificultad == 2){
                if (numero <= 0 || numero>= 15){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                    errorLectura = true;
                }
                else
                {
                    errorLectura = false;
                }
            }
            else{
                if (numero <= 0 || numero>= 21){
                    System.out.println("\033[31mError, solo se acepta los numeros 1 al 8"+"\u001B[0m");
                    errorLectura = true;
                }
                else
                {
                    errorLectura = false;
                }
            }
        }
        while (errorLectura == true);
        return numero;
        }catch (InputMismatchException ime){
            System.out.println("Solo acepta numeros, no otros caracteres");
            return 0;
        }
    }

    /**
     * Metodo que solo lee numeros del 1 al 4 , a diferencia del otro metodo de leenumerodel1al4 es que
     * si al pasarle un caracter que no sea un numero ese te devolvera al menu, en cambio este metodo hara
     * bucle hasta que le pases un numero entre el 1 al 4
     * @return el numero si es correcto , de lo contrario devuelve un mensaje de eror
     */
    public static int leeacciondel1al4() {
        try {
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
        }catch (InputMismatchException ime){
            System.out.println("Solo acepta numeros, no otros caracteres");
            return 0;
        }

    }

}
