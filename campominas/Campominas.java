package tfg.campo;
public class Campominas {
    protected int dificultad;
    protected int minas;
    protected int banderas;
    protected String[][] campo;
    protected boolean[][] campominas;
    protected boolean primermov;

    /**
     * Constructor de campo, campo minas, banderas , minas y asignacion de minas
     * @param dificultad hace referencia a la dificultad que el usuario elija
     */
    public Campominas(int dificultad) {
        this.dificultad = dificultad;
        this.primermov = true;
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
                    this.minas= 0;
                    this.campo = new String[0][0];
                    this.campominas = new boolean[0][0];
                    System.out.println("Saliendo del juego");
                    break;
            }

        this.banderas = this.minas; //El mismo numero de minas deben tener las banderas
        for (int i = 0; i<campo.length; i++){ //Asignacion de X en campo y de false en en el campo minas
            for (int j = 0; j< campo[i].length; j++){
            campo[i][j] = "X";
            campominas[i][j] = false;
            }
        }
        for (int i = minas; i > 0; i--) {
            boolean mina_colocada = false;
            if (this.dificultad == 1) {
                do
                {
                    int fila = (int) (Math.random() * 10); //coge una fila aleatoria entre el 1-10
                    int columna = (int) (Math.random() * 10);//coge una columna aleatoria entre el 1-10
                    if (fila < campominas.length && columna < campominas[1].length) {//comprueba que los valores esten en rango
                        if (campominas[fila][columna] == false) {//comprueba que no pone una mina en una mina
                            campominas[fila][columna] = true;//coloca la mina en valor booleano
                            mina_colocada = true;
                        }
                    }
                }while (mina_colocada == false);
            }else {
                do
                {
                    int fila = (int) (Math.random() * 10) + (int) (Math.random() * 10);//coge una fila entre el 1-20
                    int columna = (int) (Math.random() * 10) + (int) (Math.random() * 10);//coge una columna entre el 1-20
                    if (fila < campominas.length && columna < campominas[1].length) {//comprueba que los valores esten en rango
                        if (campominas[fila][columna] == false) {//comprueba que no pone una mina en una mina
                            campominas[fila][columna] = true;//coloca la mina
                            mina_colocada = true;
                        }
                    }
                } while (mina_colocada == false);
            }
        }
    }

    /**
     * Metodo que imprime el campo de minas , no el booleano
     */
    public void imprimir(){
        String blanco = "\u001B[0m"; //color
        System.out.println(blanco+"Minas armadas: "+ this.minas+ " " + "Banderas diponibles: " +this.banderas);
        for (int i = 0; i< campo.length; i++){
            for (int j = 0; j< campo[i].length; j++){
                System.out.print("|");
                System.out.print(this.campo[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    /**
     * Metodo que imprime la seleccion de fila y columna que has elegido
     * @param fila hace referencia a la fila que marcas
     * @param columna hace referencia a la columna que marcas
     */
    public void imprimirconseleccion(int fila, int columna){
        for (int i = 0; i< campo.length; i++){
            for (int j = 0; j< campo[i].length; j++){
                if (i == fila && j == columna) {
                    System.out.print("|");
                    System.out.print("?");
                    System.out.print("|");
                }else {
                    System.out.print("|");
                    System.out.print(this.campo[i][j]);
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    /**
     * Metodo que sirve para despejar una casilla,
     * dependiendo si es mina o no, si lo es , se acaba el programa, porque quiere
     * decir que la has pisado, de lo contrario cuenta cuantas minas hay alrededor suyo
     * @param fila la fila seleccionada
     * @param columna la columna seleccionada
     * @return para que se sepa si piso mina o no
     */
    public boolean despejar_campo(int fila, int columna){
        boolean mina_pisada = false;
        Integer minas_cerca = 0;
        if (this.campominas[fila][columna] == true) {
            mina_pisada = true;
            return mina_pisada;
        }
        else {
            if (this.campo[fila][columna].equals("X")) {
                if (fila == 0) {
                    if (columna == 0) {
                        for (int i = 0; i <= fila + 1; i++) { //Posicion esquina superior izquierda
                            for (int j = 0; j <= columna + 1; j++) {
                                if (this.campominas[i][j] == true) {
                                    minas_cerca++;
                                }
                            }
                        }
                    } else if (columna + 1 == this.campominas[1].length) {//posicion esquina superior derecha
                        for (int i = 0; i <= fila + 1; i++) {
                            for (int j = columna - 1; j <= columna; j++) {
                                if (this.campominas[i][j] == true) {
                                    minas_cerca++;
                                }
                            }
                        }
                    } else {//columna normal
                        for (int i = 0; i <= fila + 1; i++) {
                            for (int j = columna - 1; j <= columna; j++) {
                                if (this.campominas[i][j] == true) {
                                    minas_cerca++;
                                }
                            }
                        }
                    }
                }
                else if (fila + 1 == this.campominas.length) { //Posicion esquina inferior izquierda
                    if (columna == 0) {
                        for (int i = fila - 1; i <= fila; i++) {
                            for (int j = 0; j <= columna; j++) {
                                if (this.campominas[i][j] == true) {
                                    minas_cerca++;
                                }
                            }
                        }
                    } else if (columna + 1 == this.campominas[1].length) {//Posicion esquina inferior derecha
                        for (int i = fila - 1; i <= fila; i++) {
                            for (int j = columna - 1; j <= columna; j++) {
                                if (this.campominas[i][j] == true) {
                                    minas_cerca++;
                                }
                            }
                        }
                    } else {//Por si la columna es normal
                        for (int i = fila - 1; i <= fila; i++) {
                            for (int j = columna - 1; j <= columna; j++) {
                                if (this.campominas[i][j] == true) {
                                    minas_cerca++;
                                }
                            }
                        }
                    }
                }
                //En caso de que la fila este entre la minima y la maxima
                else {
                    if (columna == 0) {
                        for (int i = fila - 1; i <= fila + 1; i++) {
                            for (int j = 0; j <= columna; j++) {
                                if (this.campominas[i][j] == true) {
                                    minas_cerca++;
                                }
                            }
                        }
                    } else if (columna + 1 == this.campominas[1].length) {
                        for (int i = fila - 1; i <= fila + 1; i++) {
                            for (int j = columna - 1; j <= columna; j++) {
                                if (this.campominas[i][j] == true) {
                                    minas_cerca++;
                                }
                            }
                        }
                    } else {
                        for (int i = fila - 1; i <= fila + 1; i++) {
                            for (int j = columna - 1; j <= columna + 1; j++) {
                                if (this.campominas[i][j] == true) {
                                    minas_cerca++;
                                }
                            }
                        }
                    }
                }

                if (minas_cerca == 0) {
                    this.campo[fila][columna] = " ";
                    despejar_vacio(fila,columna);
                }
                else {
                    String reset = "\u001B[0m";
                    String verde = "\033[32m";
                    this.campo[fila][columna] = verde+Integer.toString(minas_cerca)+reset;
                }
            }
        }
        return  mina_pisada;
    }

    public void despejar_vacio(int fila,int columna){
        if(this.campo[fila][columna].equals(" ")){
            if (fila == 0) {
                if (columna == 0) {
                    for (int i = 0; i <= fila + 1; i++) { //Posicion esquina superior izquierda
                        for (int j = 0; j <= columna + 1; j++) {
                            despejar_campo(i,j);
                        }
                    }
                } else if (columna + 1 == this.campominas[1].length) {//posicion esquina superior derecha
                    for (int i = 0; i <= fila + 1; i++) {
                        for (int j = columna - 1; j <= columna; j++) {
                            despejar_campo(i,j);
                        }
                    }
                } else {//columna normal
                    for (int i = 0; i <= fila + 1; i++) {
                        for (int j = columna - 1; j <= columna; j++) {
                            despejar_campo(i,j);
                        }
                    }
                }
            }
            else if (fila + 1 == this.campominas.length) { //Posicion esquina inferior izquierda
                if (columna == 0) {
                    for (int i = fila - 1; i <= fila; i++) {
                        for (int j = 0; j <= columna; j++) {
                            despejar_campo(i,j);
                        }
                    }
                } else if (columna + 1 == this.campominas[1].length) {//Posicion esquina inferior derecha
                    for (int i = fila - 1; i <= fila; i++) {
                        for (int j = columna - 1; j <= columna; j++) {
                            despejar_campo(i,j);
                        }
                    }
                } else {//Por si la columna es normal
                    for (int i = fila - 1; i <= fila; i++) {
                        for (int j = columna - 1; j <= columna; j++) {
                            despejar_campo(i,j);
                        }
                    }
                }
            }
            else {
                if (columna == 0) {
                    for (int i = fila - 1; i <= fila + 1; i++) {
                        for (int j = 0; j <= columna; j++) {
                            despejar_campo(i,j);
                        }
                    }
                } else if (columna + 1 == this.campominas[1].length) {
                    for (int i = fila - 1; i <= fila + 1; i++) {
                        for (int j = columna - 1; j <= columna; j++) {
                            despejar_campo(i,j);
                        }
                    }
                } else {
                    for (int i = fila - 1; i <= fila + 1; i++) {
                        for (int j = columna - 1; j <= columna + 1; j++) {
                            despejar_campo(i,j);
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo que comprueba si aun queda huecos libres mirando las zonas sin despejar o con banderas
     * @return true si es vacio, false si esta ocupado
     */
    public boolean campo_libre(){
        boolean vacio = false;
        int sinselec = 0;
        for (int i = 0; i< campo.length; i++){
            for (int j = 0; j< campo[i].length; j++){
             if (campo[i][j].equals("X") || campo[i][j].equals("!")){
                 sinselec++;
             }
            }
        }
        if (this.minas == sinselec){
            vacio = true;
            return vacio;
        }
        return vacio;
    }

    /**
     * Metodo que sirve para poner banderas
     * @param fila hace referencia a la fila que da el usuario
     * @param columna hace referencia a la columna que da el usuario
     * @return false si no se coloca la bandera, de lo contrario devuelve true si se marca la bandera
     */
    public boolean poner_bandera(int fila, int columna){
        boolean colocada = false;
        if (this.campo[fila][columna].equals("X")){
            this.campo[fila][columna]="!";
            colocada = true;
            this.banderas--;
            return colocada;
        }
        return colocada;
    }

    /**
     * Metodo que sirve para quitar banderas
     * @param fila hace referencia a la fila que de el usuario
     * @param columna hace referencia a la columna que de el usuario
     * @return true si se pudo quitar la bandera, false si no se pudo
     */
    public boolean quitar_bandera(int fila, int columna){
        boolean quitada = false;
        if (this.campo[fila][columna].equals("!")){
            this.campo[fila][columna]="X";
            quitada = true;
            this.banderas++;
            return quitada;
        }
        return quitada;
    }

    /**
     * Metodo que imprime el campo con una serie de simbolos representando donde estan las minas,banderas bien marcadas
     * bandera mal marcadas, y casillas faltantes, esto se mostrara cuando pierdes o ganes
     */
    public void imprimirfinal(){
        String rojo = "\033[31m";
        String reset = "\u001B[0m";
        for (int i = 0; i< campo.length; i++){
            for (int j = 0; j< campo[i].length; j++){
                if (this.campominas[i][j] == false && this.campo[i][j].equals("X")){ //Huecos no seleccionados
                    System.out.print("|");
                    System.out.print("X");
                    System.out.print("|");
                }
                else if (this.campominas[i][j] == true && this.campo[i][j].equals("!")) { //Bandera bien colocada
                    System.out.print("|");
                    System.out.print("✔");
                    System.out.print("|");
                }else if (this.campominas[i][j] == true && this.campo[i][j].equals("X")){ //Minas
                    System.out.print("|");
                    System.out.print(rojo+"M");
                    System.out.print(reset+"|");
                } else if (this.campominas[i][j] == false && this.campo[i][j].equals("!")) { //Bandera mal colocada
                    System.out.print("|");
                    System.out.print("⍻");
                    System.out.print("|");
                } else{  //Casilla bien marcada
                    System.out.print("|");
                    System.out.print(" ");
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    /**
     * Metodo que imprime la posicion de las minas para el administrador
     */
    public void impadmin(){
        String rojo = "\033[31m";
        String reset = "\u001B[0m";
        for (int i = 0; i< campo.length; i++){
            for (int j = 0; j< campo[i].length; j++){
                if (this.campominas[i][j]==false) {
                    System.out.print("|");
                    System.out.print(" ");
                    System.out.print("|");
                }else {
                    System.out.print("|");
                    System.out.print(rojo+"M");
                    System.out.print(reset+"|");
                }
            }
            System.out.println();
        }
    }
    public boolean comprobar_x(int fila,int columna){
        if(!this.campo[fila][columna].equals("X")){
            System.out.println("\033[31mCasilla despejada marque otra porfavor"); //codigo de color rojo
            return false;
        }
        return true;
    }
}
