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

    public Imagen() {
    }

    public Imagen(String url, int x, int y, int alto, int ancho) {
        super(x, y, alto, ancho);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
