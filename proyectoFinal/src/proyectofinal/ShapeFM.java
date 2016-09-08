/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Color;
import java.awt.Stroke;

/**
 * Interfaz que representa una figura
 * @author Francisco Manuel Sánchez Ramos
 */
interface ShapeFM {
    
    public Color getColor1();
    public Color getColor2();
    public Stroke getStroke();
    public Stroke getPunteo();
    public boolean getRelleno();
    public boolean getDegradadoVertical();
    public boolean getDegradadoHorizontal();
    public boolean getContinua();
    public boolean getPunteada();
    public float getPosX();
    public float getPosY();
    public float getAltura();
    public float getAnchura();
    public boolean getSeleccionada();
    
    public void cambiarColor1(Color unColor);
    public void cambiarColor2(Color unColor);
    public void setStroke(Stroke stroke);
    public void setPunteo(Stroke punteo);
    public void setRelleno(boolean unRelleno);
    public void setDegradadoVertical(boolean unDegradado);
    public void setDegradadoHorizontal(boolean unDegradado);
    public void setContinua(boolean cont);
    public void setPunteada(boolean punt);
    public void setSeleccionada(boolean sel);
    
    
}
