/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.awt.Rectangle;

/**
 *
 * @author Santiago D
 */
public class FiguraEstandar {
    
    private Rectangle area;
    private int x;
    private int y;
    private int alto;
    private int ancho;
    private boolean maquina;

    public FiguraEstandar() {
    }

    public FiguraEstandar(int x, int y, int alto, int ancho) {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;
        this.area = new Rectangle(x, y, alto, ancho);
        this.maquina = true;
    }

    public boolean isMaquina() {
        return maquina;
    }

    public void setMaquina(boolean maquina) {
        this.maquina = maquina;
    }

    public Rectangle getArea() {
        return area;
    }

    public void setArea(Rectangle area) {
        this.area = area;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    public void moverDE(int distancia){
        this.x += distancia;
        actualizarArea();
    }
    public void moverIZ(int distancia){
        this.x -= distancia;
        actualizarArea();
    }
    
    public void moverAR(int distancia){
        this.y -= distancia;
        actualizarArea();
    }
    
    public void moverAB(int distancia){
        this.y += distancia;
        actualizarArea();
    }
    
    public void actualizarArea(){
        this.getArea().setLocation(this.x, this.y);
    }
    
}
