package campominas;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Campominas {
    protected Scanner teclado = new Scanner(System.in);
    protected int dificultad;
    protected int minas;
    protected int banderas;
    protected String[][] campo;
    protected boolean[][] campominas;
    protected ArrayList<Integer>guardardatos;

    /**
     * Constructor de campo, campo minas, banderas , minas y asignacion de minas
     * @param dificultad hace referencia a la dificultad que el usuario elija
     */
    public Campominas(int dificultad) {
        this.guardardatos = new ArrayList<>();
        this.dificultad = dificultad;
        switch (this.dificultad) {
            case 1:
                this.minas = 10;
                this.campo = new String[8][8];
                this.campominas = new boolean[8][8];
                break;
            case 2:
                this.minas = 40;
                this.campo = new String[14][14];
                this.campominas = new boolean[14][14];
                break;
            case 3:
                this.minas = 99;
                this.campo = new String[20][20];
                this.campominas = new boolean[20][20];
                break;
            case 4:
                this.minas = 0;
                this.campo = new String[0][0];
                this.campominas = new boolean[0][0];
                break;
        }

        this.banderas = this.minas;
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                campo[i][j] = "X";
                campominas[i][j] = false;
            }
        }
        for (int i = minas; i > 0; i--) {
            boolean mina_colocada = false;
            if (this.dificultad == 1) {
                do {
                    int fila = (int) (Math.random() * 10);
                    int columna = (int) (Math.random() * 10);
                    if (fila < campominas.length && columna < campominas[1].length) {
                        if (campominas[fila][columna] == false) {
                            campominas[fila][columna] = true;
                            mina_colocada = true;
                        }
                    }
                } while (mina_colocada == false);
            } else {
                do {
                    int fila = (int) (Math.random() * 10) + (int) (Math.random() * 10);
                    int columna = (int) (Math.random() * 10) + (int) (Math.random() * 10);
                    if (fila < campominas.length && columna < campominas[1].length) {
                        if (campominas[fila][columna] == false) {
                            campominas[fila][columna] = true;
                            mina_colocada = true;
                        }
                    }
                } while (mina_colocada == false);
            }
        }
    }

    /**
     * Metodo que sirve para despejar una casilla, dependiendo si es mina o no, si lo es , se acaba el programa, porque quiere
     * decir que la has pisado, de lo contrario cuenta cuantas minas hay alrededor suyo
     * @param fila    hace referencia a la fila seleccionada
     * @param columna hace referencia a la columna seleccionada
     * @return la mina pisada dependiendo de las condiciones, exepto si la en la fila y en la columna seleccionada hay una bandera
     * esta misma devolveria false
     */
    public boolean despejar_campo(int fila, int columna) {
        boolean mina_pisada = false;
        Integer minas_cerca = 0;
        if (fila<0||columna<0||fila>=this.campominas.length||columna>=this.campominas.length){
            return mina_pisada;
        }
        if(this.campo[fila][columna].equals("\033[34m!\u001B[0m"))
        {
            System.out.println("\033[31mError no se pueden despejar banderas\u001B[0m");
            return false;
        }
        if (this.campominas[fila][columna] == true) {
            mina_pisada = true;
            return mina_pisada;
        } else {
            if (this.campo[fila][columna].equals("X")) {
                minas_cerca += minascerca(fila-1, columna-1);
                minas_cerca += minascerca(fila-1, columna);
                minas_cerca += minascerca(fila-1, columna+1);

                minas_cerca += minascerca(fila, columna-1);
                minas_cerca += minascerca(fila, columna+1);

                minas_cerca += minascerca(fila+1, columna-1);
                minas_cerca += minascerca(fila+1, columna);
                minas_cerca += minascerca(fila+1, columna+1);
                if (minas_cerca > 0) {
                    String reset = "\u001B[0m";
                    String verde = "\033[32m";
                    this.campo[fila][columna] = verde + Integer.toString(minas_cerca) + reset;
                } else {
                    this.campo[fila][columna]=" ";
                    despejar_campo(fila-1, columna-1);
                    despejar_campo(fila-1, columna);
                    despejar_campo(fila-1, columna+1);

                    despejar_campo(fila, columna-1);
                    despejar_campo(fila, columna+1);

                    despejar_campo(fila+1, columna-1);
                    despejar_campo(fila+1, columna);
                    despejar_campo(fila+1, columna+1);
                }
            }
        }
        return mina_pisada;
    }

    /**
     * Metodo que sirve para poner banderas
     * @param fila    hace referencia a la fila que da el usuario
     * @param columna hace referencia a la columna que da el usuario
     * @return true si la bandera fue colocada, de lo contrario devulve false
     */
    public boolean poner_bandera(int fila, int columna) {
        boolean colocada = false;
        if (this.campo[fila][columna].equals("X")) {
            this.campo[fila][columna] = "\033[34m!\u001B[0m";
            colocada = true;
            this.banderas--;
            return colocada;
        }
        return colocada;
    }

    /**
     * Metodo que sirve para quitar banderas
     *
     * @param fila    hace referencia a la fila que de el usuario
     * @param columna hace referencia a la columna que de el usuario
     * @return true si se pudo quitar la bandera, false si no se pudo
     */
    public boolean quitar_bandera(int fila, int columna) {
        boolean quitada = false;
        if (this.campo[fila][columna].equals("\033[34m!\u001B[0m")) {
            this.campo[fila][columna]="X" ;
            quitada = true;
            this.banderas++;
            return quitada;
        }
        return quitada;
    }

    /**
     * Metodo que no permite marcar una casilla que esta despejada
     * @param fila hace refrencia a la fila de la tabla
     * @param columna hace referencia  a la columna de la tabla
     * @return true si la casilla no estaba marcada, de lo contrario devuelve false junto al mensaje
     */
    public boolean comprobar_fila(int fila, int columna) {
        if (!this.campo[fila][columna].equals("X") && !this.campo[fila][columna].equals("\033[34m!\u001B[0m")) {
            System.out.println("\033[31mCasilla despejada marque otra porfavor");
            return false;
        }
        return true;
    }

    /**
     * Metodo que dice las minas cerca de el cuadro que se va a despejar
     * @param fila hace referencia a la fila de la tabla
     * @param columna hace referencia a la columna de la tabla
     * @return 0 si no se cumple las condiciones de la fila y la columna de lo contrario devolvera 1
     */
    public int minascerca(int fila, int columna) {
        if (fila<0||columna<0||fila>=this.campominas.length||columna>=this.campominas.length){
            return 0;
        }else{
            if (this.campominas[fila][columna]==true){
                return 1;
            }
        }
        return 0;
    }

    /**
     * Metodo que termina la partida al comprobar que se cumple todas las condiciones: 1. Que el jugador halla marcado todas las banderas
     * en la posicion correcta 2. Que no halla ninguna casilla sin despejar
     * @return dependiendo si cumple las condiciones true, de lo contrario devuelve false
     */
    public boolean terminar(){
        int contador=0;
        for (int i = 0; i<this.campo.length;i++){
            for (int j = 0; j<this.campo.length;j++){
                if (this.campo[i][j].equals("X")||this.campo[i][j].equals("\033[34m!\u001B[0m")){
                    contador+=1;
                    if (contador>this.minas){
                        return false;
                    }
                }
            }
        }
        if (contador==this.minas){
            return true;
        }
        return false;
    }

    /**
     * Metodo que indica que el jugador ha ganado, guardando el nombre, los minutos y llamando a otros metodos
     * @param ini hace referencia a la hora inicial
     * @param fin hace referencia a la hora final
     */
    public void victoria(LocalDateTime ini, LocalDateTime fin){
        System.out.println("Felicidades, ganaste");
        System.out.println("¿Cual es tu nombre?");
        String nombre = teclado.next();
        int minutos = (int) ChronoUnit.MINUTES.between(ini,fin);
        System.out.println("Tardaste un total de "+minutos+" minutos");
        guardar_datos(nombre,minutos);
        partida_ganada_guardar();
    }

    /**
     * Metodo que vacia la array
     */
    public void vaciararray(){
        this.guardardatos.clear();
    }

    /**
     * Metodo que crea los archivos de guardado
     * @throws IOException excepción cuando estamos interactuando un fichero
     */
    public void crearinicio() throws IOException {
        String ruta = "datos_totales.txt";
        String ruta2 = "resultados_general.txt";
        String ruta3 = "resultados_facil.txt";
        String ruta4 = "resultados_medio.txt";
        String ruta5 = "resultados_dificil.txt";
        File resultados = new File(ruta);
        File resultados2 = new File(ruta2);
        File resultados3 = new File(ruta3);
        File resultados4 = new File(ruta4);
        File resultados5 = new File(ruta5);
        File total = new File(ruta);
        if (total.exists()) {

        }else {
            resultados.createNewFile();
            guardar_datos_totales(0,0,0);
            resultados2.createNewFile();
            resultados3.createNewFile();
            resultados4.createNewFile();
            resultados5.createNewFile();
        }
    }

    /**
     * Metodo que imprime la posicion de las minas en modo administrador
     */
    public void impadmin() {
        String rojo = "\033[31m";
        String reset = "\u001B[0m";
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                if (this.campominas[i][j] == false) {
                    System.out.print("|");
                    System.out.print(" ");
                    System.out.print("|");
                } else {
                    System.out.print("|");
                    System.out.print(rojo + "M");
                    System.out.print(reset + "|");
                }
            }
            System.out.println();
        }
    }

    /**
     * Metodo que imprime el campo de minas , no el booleano
     */
    public void imprimir() {
        String blanco = "\u001B[0m";
        System.out.println(blanco + "Minas armadas: " + this.minas + " " + "Banderas diponibles: " + this.banderas);
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                System.out.print("|");
                System.out.print(this.campo[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    /**
     * Metodo que imprime el campo con una serie de simbolos representando donde estan las minas,banderas bien marcadas
     * bandera mal marcadas, y casillas faltantes, esto se mostrara cuando pierdes o ganes
     */
    public void imprimirfinal() {
        String rojo = "\033[31m";
        String reset = "\u001B[0m";
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                if (this.campominas[i][j] == false && this.campo[i][j].equals("X")) {
                    System.out.print("|");
                    System.out.print("X");
                    System.out.print("|");
                } else if (this.campominas[i][j] == true && this.campo[i][j].equals("!")) {
                    System.out.print("|");
                    System.out.print("✔");
                    System.out.print("|");
                } else if (this.campominas[i][j] == true && this.campo[i][j].equals("X")) {
                    System.out.print("|");
                    System.out.print(rojo + "M");
                    System.out.print(reset + "|");
                } else if (this.campominas[i][j] == false && this.campo[i][j].equals("!")) {
                    System.out.print("|");
                    System.out.print("⍻");
                    System.out.print("|");
                } else {
                    System.out.print("|");
                    System.out.print(" ");
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    /**
     * Metodo que imprime la seleccion de fila y columna que has elegido
     * @param fila    hace referencia a la fila que marcas
     * @param columna hace referencia a la columna que marcas
     */
    public void imprimirconseleccion(int fila, int columna) {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                if (i == fila && j == columna) {
                    System.out.print("|");
                    System.out.print("?");
                    System.out.print("|");
                } else {
                    System.out.print("|");
                    System.out.print(this.campo[i][j]);
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }






    /**
     * Metodo que llama a la clase guardar para guardar datos totales
     */
    public void guardar_datos_totales(Integer partidas_jugadas, Integer partidas_ganadas, Integer partidas_perdidas){
        Guardar.guardar_datos_totales(partidas_jugadas,partidas_ganadas,partidas_perdidas);
    }

    /**
     * Metodo que llama a Guardar para guardar datos
     */
    public void guardar_datos(String nombre,  Integer minutos) {
        Guardar.guardar_datos(nombre,minutos,this.dificultad);
    }
    /**
     * Metodo que llama a la clase Imprimir para imprimir  los registros totales
     */
    public void imprimir_totales(){
        Imprimir.imprimir_totales();
    }

    /**
     *  Metodo que llama a la clase Imprimir para imprimir por nombre
     */
    public boolean imprimirpornombre(String nombre)throws IOException{
        return Imprimir.imprimirpornombre(nombre);
    }

    /**
     * Metodo que llama a la clase imprimir para imprimir con dificultad
     */
    public void imprimirpordif(int dif)throws IOException {
        Imprimir.imprimirpordif(dif);
    }

    /**
     * Metodo que llama a la clase Imprimir y imprimedatos
     */
    public void imprimirdatos() throws IOException {
        Imprimir.imprimirdatos();
    }

    /**
     * METODO que llama a la clase guardar para guardar la partida perdida
     */
    public void partida_perdida_guardar(){
        Guardar.partida_perdida_guardar();
    }

    /**
     * Metodo que llama a la clase guadar para guardar partida ganada
     */
    public void partida_ganada_guardar(){
        Guardar.partida_ganada_guardar();
    }


}

