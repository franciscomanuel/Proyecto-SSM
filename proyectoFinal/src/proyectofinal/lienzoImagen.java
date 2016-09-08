/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un lienzo para una imagen.
 * Hereda de la clase javax.swing.JPanel
 * @author Francisco Manuel Sánchez Ramos
 */
public class lienzoImagen extends javax.swing.JPanel {

    /**
     * Variables estáticas para cada tipo de figura.
     */
    static LineaFM punto;
    static LineaFM linea;
    static ElipseFM elipse;
    static RectanguloFM rectangulo;
    
    /**
     * Vector de figuras de tipo ShapeFM 
     */
    private List<ShapeFM> vShape = new ArrayList();
    
    /**
     * Variable de tipo ShapeFM
     */
    private ShapeFM sh = null;

    /**
     * Variables de tipo Point2D que representan los puntos "x" e "y" de
     * las figuras.
     */
    Point2D p1 = null;
    Point2D p2 = null;
    
    private BufferedImage img;
    private Graphics2D g2dImg;
    
    private Point2D inicioArrastre;
    private Point2D finArrastre;
    
    /**
     * Crea un objeto de tipo lienzoImagen
     */
    public lienzoImagen() {
        initComponents(); 
    }
    
    /**
     * Método que devuelve una imagen.
     * @param img Una imagen.
     */
    public void setImage(BufferedImage img){
        this.img=img;
        g2dImg = img.createGraphics();
        g2dImg.setPaint(Color.BLACK);
        setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
    }
    
    /**
     * Método que devuelve una imagen de tipo BufferedImage.
     * @return Una imagen
     */
    public BufferedImage getImage(){
        return img;
    }
    
    /**
     * Método booleano pasa saber si una línea está cerca de un punto.
     * @param line Línea dibujada.
     * @param p Punto donde presionamos sobre el lienzo.
     * @return True o false en función de si la distancia del punto a la línea
     * es menor o igual que 2.
     */
    public boolean isNear(LineaFM line, Point2D p){
        return line.ptSegDist(p)<=2.0;
    }
    
    /**
     * Método booleano para saber si el punto donde se ha hecho clic está 
     * contenido dentro de alguna de las formas del lienzo.
     * @param s Figura del lienzo.
     * @param p Punto donde presionamos.
     * @return True o false en función de si el punto donde se ha hecho
     * clic está contenido dentro de alguna de las formas del lienzo.
     */
    public boolean contiene(Shape s, Point2D p){
        
        if(s instanceof LineaFM){
            return this.isNear((LineaFM)s , p);
        }else if(s instanceof RectanguloFM){
            return s.contains(p);
        }else if(s instanceof ElipseFM){
            return s.contains(p);
        }else{
            return false;
        }
    }
    
    /**
     * Método que devuelve el tipo de figura seleccionada.
     * @param p Punto donde presionamos sobre la figura.
     * @return El tipo de figura seleccionada.
     */
    public ShapeFM getSelectedShape(Point2D p){
         for(ShapeFM s:vShape){
            if(s instanceof LineaFM && contiene((LineaFM)s, p)){
                return s;
            }else if(s instanceof RectanguloFM && contiene((RectanguloFM)s, p)){
                return s;
            }else if(s instanceof ElipseFM && contiene((ElipseFM)s, p)){
                return s;
            }
        }
        return null;
    }
    
    /**
     * Método para mover una figura.
     * @param s Variable de tipo Shape para representar las figuras 
     * pintadas sobre el lienzo.
     * @param pos Punto donde presionamos sobre el lienzo para arrastar una 
     * figura.
     */
    public void setLocation(Shape s, Point2D pos){
        
        if(s instanceof LineaFM){
            linea=(LineaFM) s;
            double dx=pos.getX()-linea.getX1();
            double dy=pos.getY()-linea.getY1();
            
            Point2D newp2=new Point2D.Double(linea.getX2()+dx, linea.getY2()+dy);
        
            linea.setLine(pos, newp2);
        }else if(s instanceof LineaFM){
            punto=(LineaFM)s;
            double dx=pos.getX()-punto.getX1();
            double dy=pos.getY()-punto.getY1();
            
            Point2D newp2=new Point2D.Double(punto.getX2()+dx, punto.getY2()+dy);
        
            punto.setLine(pos, newp2);
        }else if(s instanceof RectanguloFM){
            rectangulo=(RectanguloFM)s;
            double dx=pos.getX()-rectangulo.getX();
            double dy=pos.getY()-rectangulo.getY();
        
            rectangulo.setFrame(pos.getX(), pos.getY(), rectangulo.getWidth(), rectangulo.getHeight());
        }else if(s instanceof ElipseFM){
            elipse=(ElipseFM)s;
            double dx=pos.getX()-elipse.getX();
            double dy=pos.getY()-elipse.getY();
        
            elipse.setFrame(pos.getX(), pos.getY(), elipse.getWidth(), elipse.getHeight());
        }           
    }

    /**
     * Método para crear una figura.
     * @param p1 Punto de inicio de la figura.
     * @param p2 Punto de fin la figura.
     */
    public void createShape(Point2D p1, Point2D p2){
       
        if(VentanaPrincipal.valor_figura==1){
            punto = new LineaFM(p1, p1);
            sh= punto;
        }else if(VentanaPrincipal.valor_figura==2){
            elipse = new ElipseFM(p1.getX(), p1.getY(), 0, 0);
             sh= elipse;
        }else if(VentanaPrincipal.valor_figura==3){
            linea = new LineaFM(p1, p2);
             sh= linea;
        }else if(VentanaPrincipal.valor_figura==4){
             rectangulo = new RectanguloFM(p1.getX(), p1.getY(), 0, 0);
             sh=rectangulo;
        }else if(VentanaPrincipal.valor_figura==5){
            inicioArrastre = p1;
        }
        if(sh!=null){
            vShape.add(sh);
        }
    }
    
    /**
     * Método para modificar las formas.
     * @param p1 Punto de inicio de la figura.
     * @param p2 Punto de fin la figura.
     */
    public void updateShape(Point2D p1, Point2D p2){
        if(VentanaPrincipal.valor_figura==1){
            punto.setLine(p1.getX(), p1.getY(), p1.getX(), p1.getY());
        }
        if(VentanaPrincipal.valor_figura==2){
            double a = Math.min(p1.getX(), p2.getX());
            double b = Math.min(p1.getY(), p2.getY());
            double c = Math.abs(p2.getX()-p1.getX());
            double d = Math.abs(p2.getY()-p1.getY());
            
            elipse.setFrame(a, b, c, d);
        }
        if(VentanaPrincipal.valor_figura==3){
            linea.setLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        }
        if(VentanaPrincipal.valor_figura==4){
            double a = Math.min(p1.getX(), p2.getX());
            double b = Math.min(p1.getY(), p2.getY());
            double c = Math.abs(p2.getX()-p1.getX());
            double d = Math.abs(p2.getY()-p1.getY());
            
            rectangulo.setFrame(a, b, c, d);
        }
        if(VentanaPrincipal.valor_figura==5){
            finArrastre=p2;
            linea=new LineaFM(inicioArrastre, finArrastre);
            vShape.add(linea);
            inicioArrastre=p2;
        }
    } 
    
    /**
     * Método para dibujar figuras e imágenes.
     * @param g Imagen o figura a pintar.
     */
    @Override
    public void paint(Graphics g){

        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        if(img!=null){
            g2d.drawImage(img, 0, 0, this);
            //Para pintar solo en el interior de la imagen
            Rectangle2D r = new Rectangle2D.Float();
            r.setRect(0, 0, img.getWidth(), img.getHeight());
            g2d.clip(r);
        }
        
        if(VentanaPrincipal.modificar && VentanaPrincipal.editar && sh!=null){
                sh.cambiarColor1(VentanaPrincipal.valor_color1);
                sh.cambiarColor2(VentanaPrincipal.valor_color2);
                sh.setContinua(VentanaPrincipal.continua);
                sh.setDegradadoVertical(VentanaPrincipal.degradadoVertical);
                sh.setDegradadoHorizontal(VentanaPrincipal.degradadoHorizontal);
                sh.setPunteada(VentanaPrincipal.punteada);
                float punteo1[]={10.0f, 10.0f};
                BasicStroke punteo = new BasicStroke(VentanaPrincipal.gro, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 3.0f, punteo1, 1.0f);
                sh.setPunteo(punteo);
                sh.setRelleno(VentanaPrincipal.liso);
                BasicStroke stroke = new BasicStroke(VentanaPrincipal.gro);
                sh.setStroke(stroke);
                sh.setSeleccionada(false);
        }
        
        for(ShapeFM s:vShape) {
                if(s.getRelleno()){
                        g2d.setPaint(s.getColor1());
                        g2d.setPaint(s.getColor2());
                        g2d.setStroke(s.getStroke());
                        g2d.fill((Shape) s);
                }
                if(s.getDegradadoVertical()){
                        GradientPaint gradientPaint = new GradientPaint(s.getPosX()+s.getAnchura()/2, s.getPosY(),s.getColor1(), s.getPosX()+s.getAnchura()/2, s.getPosY()+s.getAltura(),s.getColor2());
                        g2d.setPaint(gradientPaint);
                        g2d.setStroke(s.getStroke()); 
                        g2d.fill((Shape) s);
                 }
                if(s.getDegradadoHorizontal()){
                        GradientPaint gradientPaint = new GradientPaint(s.getPosX(), s.getPosY()+s.getAnchura()/2,s.getColor1(), s.getPosX()+s.getAltura(), s.getPosY()+s.getAnchura()/2,s.getColor2());
                        g2d.setPaint(gradientPaint);
                        g2d.setStroke(s.getStroke()); 
                        g2d.fill((Shape) s);
                 }
                if(s.getPunteada()){  
                    g2d.setPaint(s.getColor1());
                    g2d.setStroke(s.getStroke());
                    g2d.setStroke(s.getPunteo());
                    g2d.draw((Shape) s);
                }
                if(s.getContinua()){
                        g2d.setPaint(s.getColor1());
                        g2d.setStroke(s.getStroke());
                        g2d.draw((Shape) s);
                }//Si se activa este else se puede pintar el trazo libre pero modifica algunas de las figuras ya pintadas
                /*else{    
                    g2d.setPaint(s.getColor1());
                    g2d.draw((Shape) s);
                }*/
        }
        repaint();
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        p1=evt.getPoint();
        if(!VentanaPrincipal.editar){
            createShape(p1, evt.getPoint());
            if(sh!=null){
                sh.cambiarColor1(VentanaPrincipal.valor_color1);
                sh.cambiarColor2(VentanaPrincipal.valor_color2);
                sh.setContinua(VentanaPrincipal.continua);
                sh.setDegradadoVertical(VentanaPrincipal.degradadoVertical);
                sh.setDegradadoHorizontal(VentanaPrincipal.degradadoHorizontal);
                sh.setPunteada(VentanaPrincipal.punteada);
                float punteo1[]={10.0f, 10.0f};
                BasicStroke punteo = new BasicStroke(VentanaPrincipal.gro, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 3.0f, punteo1, 1.0f);
                sh.setPunteo(punteo);
                sh.setRelleno(VentanaPrincipal.liso);
                BasicStroke stroke = new BasicStroke(VentanaPrincipal.gro);
                sh.setStroke(stroke);
            }
        }else{
            sh = (ShapeFM) (Shape) this.getSelectedShape(p1); 
            
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        if(VentanaPrincipal.editar){
            if(sh!=null) setLocation((Shape) sh, evt.getPoint());
       }else{
            updateShape(p1, evt.getPoint());
        }    
       repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        if(VentanaPrincipal.editar){
            if(sh!=null) setLocation((Shape) sh, evt.getPoint());
         }else{
            updateShape(p1, evt.getPoint());
        }
        repaint();
    }//GEN-LAST:event_formMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}


