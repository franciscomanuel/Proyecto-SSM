/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

/**
 * Clase que representa una elipse.
 * Hereda de la clase Ellipse2D.Double e implementa una interfaz ShapeFM.
 * Se deben implementar todos los metodos de la interfaz para esta clase.
 * @author Francisco Manuel Sánchez Ramos.
 */
public class ElipseFM extends Ellipse2D.Double implements ShapeFM{
    
    /**
     * Variables privadas para manejar los atributos de la elipse
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
     * Variable elipse de tipo Ellipse2D.
     */
    Ellipse2D elipse;
    
    /**
     * Crea un objeto elipse a partir de las coordenadas "x" e "y" y
     * del alto y del ancho.
     * @param x Coordenada X de la elipse.
     * @param y Coordenada Y de la elipse.
     * @param w Ancho de la elipse.
     * @param h Alto de la elipse.
     */
     public ElipseFM(double x, double y, double w, double h){
         super(x,y,w,h);
      elipse = new Ellipse2D.Double(x,y,w,h);
    }
    
     /**
      * Método para asignar el color al trazo de la elipse
      * @param unColor Variable de tipo Color que asignará el color al 
      * trazo de la elipse.
      */
    @Override
    public void cambiarColor1(Color unColor){
        color1 = unColor;
    }
    
    /**
     * Método para asignar el color del relleno a la elipse
     * @param unColor Variable de tipo Color que asígnara el color del 
     * relleno a la elipse.
     */
    @Override
    public void cambiarColor2(Color unColor){
        color2 = unColor;
    }
    
    /**
     * Método para devuelver el color del trazo de la elipse.
     * @return El color del trazo de la elipse.
     */
    @Override
    public Color getColor1() {
        return color1;
    }
    
    /**
     * Método para devolver el color del relleno de la elipse.
     * @return El color del relleno de la elipse.
     */
    @Override
    public Color getColor2() {
        return color2;
    }
    
    /**
     * Método que devuelve un Stroke con el grosor de la elipse.
     * @return El grosor del trazo de la elipse.
     */
    @Override
    public Stroke getStroke() {
        return st;
    }

    /**
     * Método que devuelve si hay que rellenar la elipse o no.
     * @return True o false en función de si está marcada la casilla de 
     * relleno o no.
     */
    @Override
    public boolean getRelleno(){
        return relleno;
    }
    
    /**
     * Método que devuelve si hay que aplicar el degradado vertical a una 
     * elipse o no.
     * @return True o false en función de si está seleccionada la casilla
     * de degradado vertical.
     */
    @Override
    public boolean getDegradadoVertical(){
        return degradadoVertical;
    }
    
    /**
     * Método que devuelve si hay que aplicar el degradado horizontal a 
     * una elipse o no.
     * @return True o false en función de si está seleccionada la casilla de
     * degradado horizonta.
     */
    @Override
    public boolean getDegradadoHorizontal(){
        return degradadoHorizontal;
    }
    
    /**
     * Método que devuelve si una elipse está seleccionada.
     * @return True o false en función de si la elipse ha sido seleccionada
     * para ser editada.
     */
    @Override
    public boolean getSeleccionada(){
        return seleccionada;
    }
    
    /**
     * Método que devuelve si el tipo de trazo de la elipse es continuo.
     * @return True o false en función de si está seleccionada la casilla 
     * de trazo continuo o no.
     */
    @Override
    public boolean getContinua(){
        return continua;
    }
    
    /**
     * Método que devuelve si el tipo de trazo de la elipse es punteado.
     * @return True o false en función de si está seleccionada la casilla de 
     * trazo punteado o no.
     */
    @Override
    public boolean getPunteada(){
        return punteada;
    }
    
    /**
     * Método que devuelve el estilo del punteado de la elipse.
     * @return El tipo de punteado para la elipse.
     */
    @Override
    public Stroke getPunteo(){
        return punteo;
    }
    
    /**
     * Método para asignar el tipo de grosor a la elipse.
     * @param stroke Variable de tipo Stroke que asigna el tipo de grosor
     * a la elipse.
     */
    @Override
    public void setStroke(Stroke stroke){
        st = stroke;
    }
    
    /**
     * Método para asignar el tipo de punteado a la elipse.
     * @param unPunteo Variable Stroke que asignar a la elipse el estilo 
     * de punteado del trazo.
     */
    @Override
    public void setPunteo(Stroke unPunteo){
        punteo=unPunteo;
    }
    
    /**
     * Método para asignar si una elipse debe ser rellenada.
     * @param unRelleno Variable booleana que asigna true o false en función 
     * de si se ha seleccionado la casilla de relleno o no.
     */
    @Override
    public void setRelleno(boolean unRelleno){
        relleno=unRelleno;
    }
    
    /**
     * Método para asignar si a una elipse se le debe aplicar el degradado 
     * vertical o no.
     * @param unDegradado Variable booleana que asigna true o false dependiendo
     * de si se ha seleccionado la casilla de degradado vertical o no.
     */
    @Override
    public void setDegradadoVertical(boolean unDegradado){
        degradadoVertical=unDegradado;
    }
    
    /**
     * Método para asignar si a una elipse se le debe aplicar el degradado 
     * horizontal o no.
     * @param unDegradado Variable booleana que asigna true o false dependiendo
     * de si se ha seleccionado la casilla de degradado horizontal o no.
     */
    @Override
    public void setDegradadoHorizontal(boolean unDegradado){
        degradadoHorizontal=unDegradado;
    }
    
    /**
     * Método para asignar si una elipse se ha seleccionado o no.
     * @param sel Variable booleana que asigna true o false dependiendo de si 
     * se ha seleccionado alguna elipse para editarse.
     */
    @Override
    public void setSeleccionada(boolean sel){
        seleccionada=sel;
    }
    
    /**
     * Método para asignar a la elipse si el tipo de trazo es continuo o no.
     * @param cont Variable booleana que asigna true o false en función de 
     * si se ha seleccionado la casilla de trazo continuo para la elipse.
     */
    @Override
    public void setContinua(boolean cont){
        continua=cont;
    }
    
    /**
     * Método que asigna si el trazo de la elipse será discontinuo o no.
     * @param punt Variable booleana que asigna true o false dependiendo de si
     * se ha seleccionado la casilla de trazo discontinuo.
     */
    @Override
    public void setPunteada(boolean punt){
        punteada=punt;
    }
    
    /**
     * Método para obtener el valor de la posición X de la elipse
     * para el tipo de gradiente.
     * @return La posición X
     */
    @Override
    public float getPosX(){
        return (float) super.getX();
    }
    
    /**
     * Método para obtener el valor de la posición Y de la elipse para 
     * el tipo de gradiente
     * @return La posición Y
     */
    @Override
    public float getPosY(){
        return (float) super.getY();
    }
    
    /**
     * Método para devolver el valor de la altura de la elipse para el tipo
     * de gradiente.
     * @return La altura de la elipse.
     */
    @Override
    public float getAltura(){
        return (float) super.getHeight();
    }
    
    /**
     * Método para devolver el valor de la anchura de la elipse para el tipo
     * de gradiente.
     * @return La anchura de la elipse.
     */
    @Override
    public float getAnchura(){
        return (float) super.getWidth();
    }
}
