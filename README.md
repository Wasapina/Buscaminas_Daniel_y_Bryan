# Buscaminas Bryan y Daniel
## Descripcion general
- El trabajo consiste en un buscaminas clasico, el cual se nos ocurrio la idea de hacerlo al probar el que está integrado en [google](https://www.google.com/search?channel=fs&client=ubuntu&q=buscaminas)
ya que a parte del propio buscaminas tendriamos que hacer las dificultades y buscar una manera de hacerlo mas interactivo pudiendo despejar mas de una casilla si está vacia, el uso de banderas, etc...
## Funcionamiento
### Buscaminas
#### Campo/Campominas
- Al ser creado, el buscaminas pedirá una **dificultad** para determinar: _el tamaño, las minas, las banderas, etc..._ 
- Al terminar de crearse, acabamos con dos Arraylists las cuales son de String para lo que mostraremos al usuario, y otro de booleanos para guardar las minas.
#### Modificaciones al los campos
- Los metodos que los modifican parecen simples ya que solo estan leyendo lo que le pasa el usuario y comparandolo con el **Campo de las minas** pero dentro de esa comparación es donde está la complicación
ya que comprueba las minas en un area la cual se expande bajo ciertas condiciones .
#### Visualizar Campo
- Tenemos varios metodos encargadas para la visualizacion de los cuales **destacan** los que sirven para visualizar las minas cercanas y el de visualizar la mina que estás seleccionando ya que _ayudan al jugador_.
#### Leer y Guardar registros
- Estos metodos, son las que llaman a las clases Guardar e Imprimir .
### Guardar
- En esta clase es donde se realizan las modificaciones a los archivos donde **están los registros de las partidas**.
- Si es necesario llaman a la clase imprimir para obtener ciertos datos.
### Imprimir
- En esta clase es usada para obtener los datos de los archivos donde están **los registros de las partidas**.
### Menu
- Donde está localizado la interfaz para el usuario.
### Creacionarchi
- Clase que llama el **Main** al inicio para crear los archivos _donde se guardarán los datos_.
### Main
- Clase usada para llamar a las demas clases necesarias para jugar.
## Datos extra
### Problemas durante el desarrollo
- Durante el desarrollo no tuvimos muchos problemas, principalmente fueron ajustes de optimización como por ej:
- Para saber cuantas minas rodeaban a una casilla usabamos un gran if elseif else para comprobar la posición ya que lo usabamos para otras partes, pero cuando las descartamos pudimos simplificarlo con solo un pequeño if else.
- Tambien, el como podríamos hacer para que busque casillas vacias, pero que no entrase en bucle, pero lo solucionamos facil al ponerle que compruebe que la casilla no hubiese sido ya vaciada.
- Y los problemas obvios de intentar usar cosas como los file/bufered reader/writer sin usarlos en clase.
- El ultimo _problema_ fue el que lo hicimos solo con la clase **Main Utilidades y Campominas**.
### Añadidos no dados en clase
- Lo principal sería el uso de los buffers para facilitar la lectura y escritura de archivos.
- Añadimos Pattern y Matcher para poder buscar en los registros nombres especificos ya que el Pattern nos permitia usando "\\\b"+texto+"\\\b" buscar a pepe y que no salga pepe2, y decidimos que las mayusculas y minusculas no importen al añadir el  Pattern.CASE_INSENSITIVE.
- También usamos ChronoUnit para registrar los minutos que se tardan en ganar los jugadores.
### Cosas que nos hubiese gustado añadir
- Por falta de tiempo no pudimos asegurar el hacer y entender en programa completo en visual.
- Y también un modo extra el cual tiene un cronometro y cada cierto tiempo te mueve las minas de lugar.
