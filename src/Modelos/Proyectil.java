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

    public Proyectil() {
    }

    public Proyectil(String url, int x, int y, int alto, int ancho) {
        super(url, x, y, alto, ancho);
        this.puntero = "nada";
    }

    public String getPuntero() {
        return puntero;
    }

    public void setPuntero(String puntero) {
        this.puntero = puntero;
    }
    
    
}
