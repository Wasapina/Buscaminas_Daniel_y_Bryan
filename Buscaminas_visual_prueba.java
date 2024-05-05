package prueba;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
public class Buscaminas_visual_prueba {

    private class casillamina extends JButton{//creando un contructor para los botones de las casilllas
        int r;
        int c;
        public casillamina(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
  int tamañocasilla =70;//tamaño de la casilla
  int numfila = 8;//numero de columnas
  int numcolumna = numfila;//numero de filas
  int anchura = numcolumna * tamañocasilla;//el ancho
  int altura = numfila * tamañocasilla;//el alto
  JFrame frame = new JFrame("buscaminas");//esto es para crear la pantalla para verlo visual
  JLabel etiquetatexto = new JLabel();//esto es para escribir
  JLabel paneltexto = new JLabel();//esto es para poner la etiquetatexto
  JLabel panelcampo = new JLabel();
  casillamina[][] tablero = new casillamina[numfila][numcolumna];
  ArrayList<casillamina>listaminas;
  int casillasselecionadas=0;
  boolean perdiste=false;
  int minas = 10;
  Random aleatorio = new Random();

 Buscaminas_visual_prueba(){
//frame.setVisible(true);//hace que se vea la ventana
frame.setSize(altura,anchura);//le da el tamaño a la ventana
frame.setLocationRelativeTo(null);//hace que no este atada la ventana a ningun lugar de la pantalla
frame.setResizable(false);//para que no se pueda cambiar el tamaño de la ventana
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para que cuando cerremos la ventana se pare el programa por defecto
frame.setLayout(new BorderLayout());//para darle un borde

    etiquetatexto.setFont(new Font("Arial",Font.BOLD,25));//esto le da un estilo de letra a la etiqueta de texto
etiquetatexto.setHorizontalAlignment(JLabel.CENTER);//esto orienta la etiqueta al centro
etiquetatexto.setText("Buscaminas");//esto establece el texto de la etiqueta
etiquetatexto.setOpaque(true);//esto la hace opaca


    paneltexto.setLayout(new BorderLayout());//esto le da bordes al panel
paneltexto.add(etiquetatexto);//añades la etiqueta al panel
frame.add(paneltexto, BorderLayout.NORTH);//añades el panel a la ventana y lo coloca en la parte de arriba

panelcampo.setLayout(new GridLayout(numfila,numcolumna));//establece el panel del campo, el grid layout es para que las filas y columnas no tengan tamaños estaticos y se adapten a la pantalla
//panelcampo.setBackground(Color.green);//le da color al campo
frame.add(panelcampo);//añade el panel del campo a la ventana

for (int r = 0; r< numfila;r++){
    for (int c=0; c<numcolumna;c++){
        casillamina casilla = new casillamina(r,c);
        tablero[r][c]=casilla;

        casilla.setFocusable(false);
        casilla.setMargin(new Insets(0,0,0,0));//margenes para las casillas
        casilla.setFont(new Font("Arial Unicode MS",Font.PLAIN,45));//la fuente es esa para poder añadir los simbolor
        //casilla.setText("💣");
        casilla.addMouseListener(new MouseAdapter() {//para que detecte el predionar el mouse
            @Override
            public void mousePressed(MouseEvent e) {//hay que hacer overide
               if (perdiste==true){
                   return;
               }
                casillamina casilla = (casillamina) e.getSource();//estamos transformando el click para que interactue con las casillas

                //click izquierdo
                if (e.getButton()==MouseEvent.BUTTON1){
                    if (casilla.getText()==""){//comprueba que sea una casilla sin selecionar ya que no tendria texto
                        if (listaminas.contains(casilla)){//comprueba que la casilla selecionada con click izquierdo no sea una mina
                            revelarminas();
                        }else {
                            comprobarmina(casilla.r,casilla.c);
                        }
                    }
                } else if (e.getButton()== MouseEvent.BUTTON3) {//click derecho
                    if (casilla.getText().equals("")&&casilla.isEnabled()){//si la casilla no esta marcada y no tiene nada, se pone una bandera
                        casilla.setText("🚩");
                    } else if (casilla.getText().equals("🚩")) {//si tiene una bandera se la quita
                        casilla.setText("");
                    }
                }
            }
        });
        panelcampo.add(casilla);
    }
}
frame.setVisible(true);//lo pongo aqui abajo xq puede ser que el programa no cargue todas las casillas por el ordenador

     ponerminas();
}
void ponerminas(){
     listaminas = new ArrayList<casillamina>();
     int minasfaltantes = minas;
    while (minasfaltantes>0){
        int r = aleatorio.nextInt(numfila);
        int c = aleatorio.nextInt(numcolumna);
        listaminas.add(tablero[r][c]);
        minasfaltantes--;
    }
}
void  revelarminas(){
for (int i = 0; i<listaminas.size();i++){
    casillamina casilla = listaminas.get(i);
    casilla.setText("💣");
}
perdiste=true;
etiquetatexto.setText("perdiste☠️");
}
void comprobarmina(int r, int c){//comprueba cuantas minas cerca tiene
    if (r<0 || r>= numfila || c<0 ||c>=numcolumna){//para que no compruebe fuera de su rango
        return;
    }

     casillamina casilla = tablero[r][c];
    if (!casilla.isEnabled()){//para que no entre en bucle al hacer la comprobacion recursiva
        return;
    }
     casilla.setEnabled(false);
    casillasselecionadas+=1;

     int minascerca = 0;
     minascerca += contarminas(r-1,c-1);//arriba la izquierda
    minascerca += contarminas(r-1,c);//ariba
    minascerca += contarminas(r-1,c+1);//arriba a la derecha

    minascerca += contarminas(r,c-1);//izquierda
    minascerca += contarminas(r,c+1);//derecha

    minascerca += contarminas(r+1,c-1);//abajo a la izquierda
    minascerca += contarminas(r+1,c);//abajo
    minascerca += contarminas(r+1,c+1);//abajo a la derecha

    if (minascerca > 0){
        casilla.setText(Integer.toString(minascerca));
    }else {
        casilla.setText("");

        //comprobar los vecinos para liberar las vacias circundantes
        comprobarmina(r-1,c-1);//arriba la izquierda
        comprobarmina(r-1,c);//ariba
        comprobarmina(r-1,c+1);//arriba a la derecha

        comprobarmina(r,c-1);//izquierda
        comprobarmina(r,c+1);//derecha

        comprobarmina(r+1,c-1);//abajo a la izquierda
        comprobarmina(r+1,c);//abajo
        comprobarmina(r+1,c+1);//abajo a la derecha
    }
    if (casillasselecionadas==numfila*numcolumna-listaminas.size()){
        perdiste=true;
        etiquetatexto.setText("ganaste🥳🥳");
    }
}
int contarminas(int r, int c){
     if (r<0 || r>= numfila || c<0 ||c>=numcolumna){
         return 0;
     }
     if (listaminas.contains(tablero[r][c])){
         return 1;
     }
     return 0;
}
}
