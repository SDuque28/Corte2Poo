/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;


/**
 *
 * @author Santiago D
 */
public class Imagen extends FiguraEstandar{
    
    private String url;

    /**
     * Constructor generico de la clase
     */
    public Imagen() {
    }

    /**
     * Constructor de la clase
     * @param url
     * @param x
     * @param y
     * @param alto
     * @param ancho 
     */
    public Imagen(String url, int x, int y, int alto, int ancho) {
        super(x, y, alto, ancho);
        this.url = url;
    }

    /**
     * Metodo que retorna el url de la imagen
     * @return 
     */
    public String getUrl() {
        return url;
    }

    /**
     * Metodo que setea el url de la imagen
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url;
    }   
}
