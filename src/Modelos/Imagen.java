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
    private String direccion;
    private String estado;
    private String aire;

    public Imagen() {
    }

    public Imagen(String url, int x, int y, int alto, int ancho) {
        super(x, y, alto, ancho);
        this.url = url;
        this.estado = "suelo";
        this.direccion = "derecha";
        this.aire = "neutral";
    }

    public String getAire() {
        return aire;
    }

    public void setAire(String aire) {
        this.aire = aire;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
