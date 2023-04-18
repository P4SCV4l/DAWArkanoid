/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAW.arkanoid.modelo.ladrillos;

import DAW.arkanoid.modelo.Pelota;
import javafx.geometry.Point2D;

/**
 *
 * @author PC
 */
public abstract class Ladrillo {
    protected Point2D posicion;
    protected int ancho;
    protected int alto;
    protected int dureza;
    
    public Ladrillo(){
        this.posicion= new Point2D(0,0);
    }
    public Ladrillo(Point2D posicion, int ancho, int alto, int dureza){
        this.posicion= posicion;
        this.ancho=ancho;
        this.alto=alto;
        this.dureza=dureza;
    }
    public abstract void restarDureza(Pelota pelota);
    public abstract void destruirLadrillo();
    /**
     * @return the posicion
     */
    public Point2D getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(Point2D posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @return the dureza
     */
    public int getDureza() {
        return dureza;
    }   
}
