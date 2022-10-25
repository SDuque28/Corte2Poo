/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Santiago D
 */
public class Proyectil extends Imagen{
    
    private String puntero;

    /**
     * Constructor generico de la clase
     */
    public Proyectil() {
    }

    /**
     * Constructor de la clase
     * @param url
     * @param x
     * @param y
     * @param alto
     * @param ancho 
     */
    public Proyectil(String url, int x, int y, int alto, int ancho) {
        super(url, x, y, alto, ancho);
        this.puntero = "nada";
    }

    /**
     * Metodo que retorna el puntero
     * @return 
     */
    public String getPuntero() {
        return puntero;
    }

    /**
     * Metodo que setea el puntero
     * @param puntero 
     */
    public void setPuntero(String puntero) {
        this.puntero = puntero;
    }   
}
