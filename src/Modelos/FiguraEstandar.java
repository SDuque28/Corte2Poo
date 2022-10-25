/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;


/**
 *
 * @author Santiago D
 */
public class FiguraEstandar {

    private int x;
    private int y;
    private int alto;
    private int ancho;

    /**
     * Constructor Generico del juego
     */
    public FiguraEstandar() {
    }

    /**
     * Contstructor de la clase 
     * @param x
     * @param y
     * @param alto
     * @param ancho 
     */
    public FiguraEstandar(int x, int y, int alto, int ancho) {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;
    }

    /**
     * Metodo que retorna el valor de X
     * @return 
     */
    public int getX() {
        return x;
    }

    /**
     * Metodo que setea el valor de x
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Metodo que retorna el valor de y
     * @return 
     */
    public int getY() {
        return y;
    }

    /**
     * Metodo que setea el valor de y
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Metodo que retorna el alto
     * @return 
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Metodo que setea el alto
     * @param alto 
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * Metodo que retorna el ancho
     * @return 
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Metodo que setea el ancho
     * @param ancho 
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    /**
     * Metodo que permite mover una figura a la derecha
     * @param distancia 
     */
    public void moverDE(int distancia){
        this.x += distancia;
    }
    
    /**
     * Metodo que permite mover una figura a la izquierda
     * @param distancia 
     */
    public void moverIZ(int distancia){
        this.x -= distancia;
    }
    
    /**
     * Metodo que permite mover a una figura para arriba
     * @param distancia 
     */
    public void moverAR(int distancia){
        this.y -= distancia;
    }
    
    /**
     * Metodo que permite mover una figura para abajo
     * @param distancia 
     */
    public void moverAB(int distancia){
        this.y += distancia;
    }    
}
