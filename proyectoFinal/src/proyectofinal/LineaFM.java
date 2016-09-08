/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Clase que representar una línea que hereda de la clase Line2D.Double y 
 * que implementa una interfaz ShapeFM.
 * Se deben implementar todos los metodos de la interfaz y solo para esta clase
 * alguno de estos métodos no se usan y por tanto en ellos no voy a devolver un
 * valor significativo. Ej: color del relleno.
 * Cada línea queda determinada por dos puntos.
 * @author Francisco Manuel Sánchez Ramos.
 */
public class LineaFM extends Line2D.Double implements ShapeFM{
    
    /** 
     * Variables privadas para manejar los atribujos de la línea.
     */
    private Color color1;
    private Color color2;
    private Stroke st;
    private boolean relleno;
    private boolean degradadoVertical;
    private boolean degradadoHorizontal;
    private boolean continua;
    private boolean punteada;
    private boolean seleccionada;
    private Stroke punteo;
    
    /** 
     * Variable línea de tipo Line2D
     */
    Line2D linea;
    
    /**
     * Crea un objeto línea a partir de dos puntos, el punto de inicio y 
     * el punto final.
     * @param x El punto de inicio de la línea.
     * @param y El punto final de la línea.
     */
    public LineaFM(Point2D x, Point2D y){
        super(x, y);
        linea = new Line2D.Double(x, y);
    }
    
    /**
     * Devuelve el color de la línea
     * @return El color de la línea
     */
    @Override
    public Color getColor1() {
        return color1;
    }
    
    /**
     * Método para devuelve el color del relleno. 
     * @return Este método devuelve null porque una línea no tiene relleno
     */
    @Override
    public Color getColor2() {
        return null;
    }
    
    /**
     * Método para devolver el grosor de una línea.
     * @return Retorna el grosor de una línea.
     */
    @Override
    public Stroke getStroke() {
        return st;
    }
    
    /**
     * Método para cambiar el color de una línea.
     * @param unColor Variable de tipo color que asignará el color a la línea.
     */
    @Override
    public void cambiarColor1(Color unColor){
        color1=unColor;
    }
    
    /**
     * Método para asignar el relleno de una línea.
     * @param unColor El color asignado va a ser null porque una línea no tiene 
     * relleno.
     */
    @Override
    public void cambiarColor2(Color unColor){
        color2=null;
    }

    /**
     * Método que devuelve true o false en función de si hay que rellenar la 
     * línea o no
     * @return Devuelve false porque una línea no tiene relleno
     */
    @Override
    public boolean getRelleno() {
        return false;
    }
    
    /**
     * Método que devuelve true o false en función de si hay que aplicar el 
     * degradado vertical o no a una línea.
     * @return Devuelve false porque una línea no tiene degradado vertical
     */
    @Override
    public boolean getDegradadoVertical(){
        return false;
    }
    
    /**
     * Método para asignar true o false en función de si se ha seleccionado
     * una línea o no.
     * @param sel Variable tomará valores true o false en función de si 
     * se a seleccionado la línea o no.
     */
    @Override
    public void setSeleccionada(boolean sel){
        seleccionada=sel;
    }
    
    /**
     * Método que devuelve true o false en función de si hay que aplicar el 
     * degradado horizontal o no a una línea.
     * @return Asigna false porque una línea no tiene degradado horizontal
     */
    @Override
    public boolean getDegradadoHorizontal(){
        return false;
    }

    /**
     * Método para devolver si una línea tiene el trazo contínuo.
     * @return True o false si el trazo es contínuo o no.
     */
    @Override
    public boolean getContinua(){
        return continua;
    }
    
    /**
     * Método que devuelve si el trazo de una línea es punteado.
     * @return True o false en función de si es o no punteada la línea.
     */
    @Override
    public boolean getPunteada(){
        return punteada;
    }
    
    /**
     * Método que devuelve si una línea está o no seleccionada
     * @return Devuelve true o false en función de si está o no seleccionada.
     */
    @Override
    public boolean getSeleccionada(){
        return seleccionada;
    }
    
    /**
     * Método que devuelve el estilo del punteado.
     * @return El tipo de punteado.
     */
    @Override
    public Stroke getPunteo(){
        return punteo;
    }  
    
    /**
     * Método para asignar el grosor a la línea.
     * @param stroke Variable de tipo Stroke para asignar un grosor a
     * la línea
     */
    @Override
    public void setStroke(Stroke stroke){
        st = stroke;
    }
    
    /**
     * Método para asignar el estilo del punteado a la línea
     * @param unPunteo Tipo de punteado a asignar a la línea.
     */
    @Override
    public void setPunteo(Stroke unPunteo){
        punteo=unPunteo;
    }
    
    /**
     * Método para asignar true o false en función de si se tiene que rellenar
     * la línea o no
     * @param unRelleno Asigna false porque una línea no se rellena
     */
    @Override
    public void setRelleno(boolean unRelleno){
        relleno=false;
    }
    
    /**
     * Método para asginar true o false en función de si se tiene que 
     * aplicar el degradado vertical o no a la línea.
     * @param unDegradado Asigna false porque una línea no tiene 
     * degradado vertical
     */
    @Override
    public void setDegradadoVertical(boolean unDegradado){
        degradadoVertical=false;
    }
    
    /**
     * Método para asginar true o false en función de si se tiene que 
     * aplicar el degradado horizontal o no a la línea.
     * @param unDegradado Asigna false porque una línea no tiene 
     * degradado horizontal.
     */
    @Override
    public void setDegradadoHorizontal(boolean unDegradado){
        degradadoHorizontal=false;
    }

    /**
     * Método para asignar un valor booleano en función de si la línea es 
     * continua o no
     * @param cont Variable booleana que indica si la línea va a ser continua
     * o no.
     */
    @Override
    public void setContinua(boolean cont){
        continua=cont;
    }
    
    /**
     * Método para asignar un valor booleano si la línea es punteada
     * @param punt Variable booleana para asginar true o false en función 
     * de si se va a querer el estilo punteado para la línea o no.
     */
    @Override
    public void setPunteada(boolean punt){
        punteada=punt;
    }
    
    /**
     * Método para obtener el valor de la posición X de la línea 
     * para el tipo de gradiente.
     * @return El mínimo entre la posición X1 y X2.
     */
    @Override
    public float getPosX(){
        return (float) Math.min(super.getX1(), super.getX2());
    }
    
    /**
     * Método para obtener el valor de la posición Y de la línea para 
     * el tipo de gradiente
     * @return El mínimo entre la posición Y1 e Y2.
     */
    @Override
    public float getPosY(){
        return (float) Math.min(super.getY1(), super.getY2());
    }
    
    /**
     * Método para devolver el valor de la altura de la línea para el tipo
     * de gradiente.
     * @return Devuelvo 0 porque la línea no tiene ninguna altura para 
     * el gradiente.
     */
    @Override
    public float getAltura(){
        return 0;
    }
    
    /**
     * Método para devolver el valor de la anchura de la línea para el tipo
     * de gradiente.
     * @return Devuelvo 0 porque la línea no tiene ninguna anchura para 
     * el gradiente.
     */
    @Override
    public float getAnchura(){
        return 0;
    }
}
