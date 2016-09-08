/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

/**
 * Clase que representa un rectángulo.
 * Hereda de la clase Rectangle2D.Double e implementa una interfaz ShapeFM.
 * Se deben implementar todos los metodos de la interfaz para esta clase.
 * @author Francisco Manuel Sánchez Ramos.
 */
public class RectanguloFM extends Rectangle2D.Double implements ShapeFM{
    
    /**
     * Variables privadas para manejar los atributos del rectángulo.
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
     * Variable rectángulo de tipo Rectangle2D.
     */
    Rectangle2D rectangulo;
    
    /**
     * Crea un objeto rectángulo a partir de las coordenadas "x" e "y" y del 
     * alto y del ancho.
     * @param x Coordenada X del rectángulo.
     * @param y Coordenada Y del rectángulo,
     * @param w Ancho del rectángulo.
     * @param h Alto del rectángulo.
     */
    public RectanguloFM(double x, double y, double w, double h){
        super(x,y,w,h);
      rectangulo = new Rectangle2D.Double(x,y,w,h);
    }
    
    /**
      * Método para asignar el color al trazo del rectángulo
      * @param unColor Variable de tipo Color que asignará el color al trazo
      * del rectángulo
      */
    @Override
    public void cambiarColor1(Color unColor){
        color1 = unColor;
    }
    
    /**
     * Método para asignar el color del relleno al rectángulo.
     * @param unColor Variable de tipo Color que asígnara el color del 
     * relleno arectángulo.
     */
    @Override
    public void cambiarColor2(Color unColor){
        color2 = unColor;
    }

    /**
     * Método para devuelver el color del trazo del rectángulo.
     * @return El color del trazo del rectángulo.
     */
    @Override
    public Color getColor1() {
        return  color1;
    }
    
    /**
     * Método para devolver el color del relleno del rectángulo.
     * @return El color del relleno del rectángulo.
     */
    @Override
    public Color getColor2() {
        return  color2;
    }

    /**
     * Método que devuelve un Stroke con el grosor del rectángulo.
     * @return El grosor del trazo del rectángulo.
     */
    @Override
    public Stroke getStroke() {
        return st;
    }

    /**
     * Método que devuelve si hay que rellenar el rectángulo o no.
     * @return True o false en función de si está marcada la casilla de 
     * relleno o no.
     */
    @Override
    public boolean getRelleno(){
        return relleno;
    }
    
    /**
     * Método que devuelve si hay que aplicar el degradado vertical a un 
     * rectángulo o no.
     * @return True o false en función de si está seleccionada la casilla
     * de degradado vertical.
     */
    @Override
    public boolean getDegradadoVertical(){
        return degradadoVertical;
    }
    
    /**
     * Método que devuelve si hay que aplicar el degradado horizontal a 
     * un rectángulo o no.
     * @return True o false en función de si está seleccionada la casilla de
     * degradado horizonta.
     */
    @Override
    public boolean getDegradadoHorizontal(){
        return degradadoHorizontal;
    }
    
    /**
     * Método que devuelve si el tipo de trazo del rectángulo es continuo.
     * @return True o false en función de si está seleccionada la casilla 
     * de trazo continuo o no.
     */
    @Override
    public boolean getContinua(){
        return continua;
    }
    
    /**
     * Método que devuelve si un rectángulo está seleccionado.
     * @return True o false en función de si el rectángulo ha sido seleccionado
     * para ser editado.
     */
    @Override
    public boolean getSeleccionada(){
        return seleccionada;
    }
    
    /**
     * Método que devuelve si el tipo de trazo del rectángulo es punteado.
     * @return True o false en función de si está seleccionada la casilla de 
     * trazo punteado o no.
     */
    @Override
    public boolean getPunteada(){
        return punteada;
    }
    
    /**
     * Método que devuelve el estilo del punteado del rectángulo.
     * @return El tipo de punteado para el rectángulo.
     */
    @Override
    public Stroke getPunteo(){
        return punteo;
    }

    /**
     * Método para asignar el tipo de grosor al rectángulo.
     * @param stroke Variable de tipo Stroke que asigna el tipo de grosor
     * al rectángulo.
     */
    @Override
    public void setStroke(Stroke stroke){
        st = stroke;
    }
    
    /**
     * Método para asignar el tipo de punteado al rectángulo.
     * @param unPunteo Variable Stroke que asignar al rectángulo el estilo 
     * de punteado del trazo.
     */
    @Override
    public void setPunteo(Stroke unPunteo){
        punteo=unPunteo;
    }
    
    /**
     * Método para asignar si un rectángulo debe ser rellenado.
     * @param unRelleno Variable booleana que asigna true o false en función 
     * de si se ha seleccionado la casilla de relleno o no.
     */
    @Override
    public void setRelleno(boolean unRelleno){
        relleno=unRelleno;
    }
    
    /**
     * Método para asignar si a un rectángulo se le debe aplicar el degradado 
     * vertical o no.
     * @param unDegradado Variable booleana que asigna true o false dependiendo
     * de si se ha seleccionado la casilla de degradado vertical o no.
     */
    @Override
    public void setDegradadoVertical(boolean unDegradado){
        degradadoVertical=unDegradado;
    }
    
    /**
     * Método para asignar si a un rectángulo se le debe aplicar el degradado 
     * horizontal o no.
     * @param unDegradado Variable booleana que asigna true o false dependiendo
     * de si se ha seleccionado la casilla de degradado horizontal o no.
     */
    @Override
    public void setDegradadoHorizontal(boolean unDegradado){
        degradadoHorizontal=unDegradado;
    }
    
    /**
     * Método para asignar al rectángulo si el tipo de trazo es continuo o no.
     * @param cont Variable booleana que asigna true o false en función de 
     * si se ha seleccionado la casilla de trazo continuo para el rectángulo.
     */
    @Override
    public void setContinua(boolean cont){
        continua=cont;
    }
    
    /**
     * Método que asigna si el trazo del rectángulo será discontinuo o no.
     * @param punt Variable booleana que asigna true o false dependiendo de si
     * se ha seleccionado la casilla de trazo discontinuo.
     */
    @Override
    public void setPunteada(boolean punt){
        punteada=punt;
    }
    
    /**
     * Método para asignar si un rectángulo se ha seleccionado o no.
     * @param sel Variable booleana que asigna true o false dependiendo de si 
     * se ha seleccionado algun rectángulo para editarse.
     */
    @Override
    public void setSeleccionada(boolean sel){
        seleccionada=sel;
    }
    
    /**
     * Método para obtener el valor de la posición X del rectángulo
     * para el tipo de gradiente.
     * @return La posición X
     */
    @Override
    public float getPosX(){
        return (float) super.getX();
    }
    
    /**
     * Método para obtener el valor de la posición Y del rectángulo para 
     * el tipo de gradiente
     * @return La posición Y
     */
    @Override
    public float getPosY(){
        return (float) super.getY();
    }
    
    /**
     * Método para devolver el valor de la altura del rectángulo para el tipo
     * de gradiente.
     * @return La altura del rectángulo.
     */
    @Override
    public float getAltura(){
        return (float) super.getHeight();
    }
    
    /**
     * Método para devolver el valor de la anchura del rectángulo para el tipo
     * de gradiente.
     * @return La anchura del rectángulo.
     */
    @Override
    public float getAnchura(){
        return (float) super.getWidth();
    }
}
