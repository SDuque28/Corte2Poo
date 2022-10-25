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

    /**
     * Contructor generico de la clase
     */
    public Jugador() {
    }

    /**
     * Constructor de la clase
     * @param url
     * @param x
     * @param y
     * @param alto
     * @param ancho 
     */
    public Jugador(String url, int x, int y, int alto, int ancho) {
        super(url, x, y, alto, ancho);
        this.estado = "suelo";
        this.direccion = "derecha";
        this.aire = "neutral";
    }

    /**
     * Metodo que retorna la direccion
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo que setea la direccion
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo que retorna el estado
     * @return 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo que setea el estado
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo que retorna el aire
     * @return 
     */
    public String getAire() {
        return aire;
    }

    /**
     * Metodo que seta el aire
     * @param aire 
     */
    public void setAire(String aire) {
        this.aire = aire;
    }   
}
