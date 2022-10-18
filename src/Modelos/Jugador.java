/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Santiago D
 */
public class Jugador extends Imagen{
    
    private String direccion;
    private String estado;
    private String aire;

    public Jugador() {
    }

    public Jugador(String url, int x, int y, int alto, int ancho) {
        super(url, x, y, alto, ancho);
        this.estado = "suelo";
        this.direccion = "derecha";
        this.aire = "neutral";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAire() {
        return aire;
    }

    public void setAire(String aire) {
        this.aire = aire;
    }
    
    
}
