/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAW.arkanoid.modelo;

import DAW.arkanoid.interfaz.CanvasLayer;
import javafx.geometry.Point2D;

/**
 *
 * @author Pedro
 */
enum EstadoJuego {
    PENDIETEINICIAR,
    INICIADO
}
enum Limite{
    NONE,
    TOPEARRIBA,
    TOPEABAJO,
    TOPEDERECHA,
    TOPEIZQUIERDA
}
public class Juego {

    private Campo campo;
    public static int ANCHO = 448;
    public static int ALTO = 480;
   
   
    public Juego() {
        this.campo = new Campo(Juego.ANCHO, Juego.ALTO);
        this.campo.setVelocidad(1.0f);
        this.campo.getBarra().setAlto(16);
        this.campo.getBarra().setAncho(64);
        
    }

   
    /**
     * ciclo del juego, se mueve la pelota, comprueba colision con barra y ladrillos
     * si es con ladrillos se devuelve true para repintar el fondo.
     * @param pulsados
     * @return 
     */
    public EstadoCambiosJuego ciclo(boolean pulsados[]) {
        EstadoCambiosJuego vuelta=EstadoCambiosJuego.NADA;
        
        if (pulsados[0]) {
            this.moverBarraIzquierda();
        }
        if (pulsados[1]) {
            this.moverBarraDerecha();
        }
        //si devuelve true es que toca fondo
        switch(this.moverPelota()){
            case TOPEABAJO:
                //Por arreglar.
                this.campo.getPelota().changeDirectionVertical();
                System.out.println("Perdiste.");
                break;
            case TOPEARRIBA:
                this.campo.getPelota().changeDirectionVertical();
                break;
            case TOPEDERECHA:
            case TOPEIZQUIERDA:
                this.campo.getPelota().changeDirectionHorizontal();
                break;
        }
        
        return vuelta;
    }
    
     public Limite moverPelota() {
        Limite tocaborde=Limite.NONE;
        
            this.campo.getPelota().mover();
            Point2D pos_pelota=this.campo.getPelota().getPosicion();
            if (pos_pelota.getY() > Juego.ALTO) tocaborde=Limite.TOPEABAJO;
            if (pos_pelota.getY() < 0) tocaborde=Limite.TOPEARRIBA;
            if (pos_pelota.getX() < 0) tocaborde=Limite.TOPEIZQUIERDA;
            if (pos_pelota.getX() > Juego.ANCHO) tocaborde=Limite.TOPEDERECHA;
            // pelota.mover();
        
         return tocaborde;
    }
    
    public void moverBarraIzquierda() {
       
        
            this.campo.getBarra().moverIzquierda();
           
    }
    public void moverBarraDerecha() {
        
            this.campo.getBarra().moverDerecha();
         
        
    }

   
    /**
     * @return the campo
     */
    public Campo getCampo() {
        return campo;
    }

    /**
     * @param campo the campo to set
     */
    public void setCampo(Campo campo) {
        this.campo = campo;
    }
   

    

   

   
   
}
