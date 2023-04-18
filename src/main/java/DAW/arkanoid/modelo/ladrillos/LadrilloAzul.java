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
public class LadrilloAzul extends Ladrillo {   
    public LadrilloAzul(){
        super();
    }
    public LadrilloAzul(Point2D posicion, int ancho, int alto, int dureza){
        super(posicion, ancho, alto, dureza);
        dureza = 6;
    } 
    
    @Override
    public void restarDureza(Pelota pelota) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void destruirLadrillo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   
}