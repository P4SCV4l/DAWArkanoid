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
    TOPEIZQUIERDA,
    TOPEBARRA
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
            case TOPEBARRA:
                this.campo.getPelota().changeDirectionVertical();
                break;
        }
        
        return vuelta;
    }
    
     public Limite moverPelota() {
        Limite tocaborde=Limite.NONE;
        
            this.campo.getPelota().mover();
            Point2D pos_pelota=this.campo.getPelota().getPosicion();
            if (pos_pelota.getY() > Juego.ALTO) tocaborde=Limite.TOPEABAJO;
            if (pos_pelota.getY() < 0 + 18) tocaborde=Limite.TOPEARRIBA;
            if (pos_pelota.getX() < 0 + 17) tocaborde=Limite.TOPEIZQUIERDA;
            if (pos_pelota.getX() > Juego.ANCHO - 25) tocaborde=Limite.TOPEDERECHA;
            if (pos_pelota.getX() >= this.campo.getBarra().getPosicion().getX() && pos_pelota.getX() <= this.campo.getBarra().getPosicion().getX() + this.campo.getBarra().getAncho() &&
                    pos_pelota.getY() >= this.campo.getBarra().getPosicion().getY() - 6 && pos_pelota.getY() <= this.campo.getBarra().getPosicion().getY() + this.campo.getBarra().getAlto()) 
                tocaborde=Limite.TOPEBARRA;
            // pelota.mover();
        
         return tocaborde;
    }
    
//    public void choqueBarraLimite() {
//        if(this.campo.getBarra().getPosicion().getX()>=0){
//            this.campo.getBarra().setPosicion(new Point2D(0.0d,this.campo.getBarra().getPosicion().getY()));
//        }
//        if(this.campo.getBarra().getPosicion().getX()<=Juego.ANCHO - 25){
//            this.campo.getBarra().setPosicion(new Point2D(Juego.ANCHO - 25,this.campo.getBarra().getPosicion().getY()));
//        }
//    }
     
    public void moverBarraIzquierda() {
            this.campo.getBarra().moveHorizontal(-2,17, (Juego.ANCHO - 18));     
    }
    public void moverBarraDerecha() {
            this.campo.getBarra().moveHorizontal(2,17, (Juego.ANCHO - 18));
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

    private Point2D Point2D(double d, double y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   

    

   

   
   
}
