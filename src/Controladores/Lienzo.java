/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Controladores;

import Modelos.FiguraEstandar;
import Modelos.Imagen;
import Modelos.Jugador;
import Modelos.Proyectil;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;



/**
 *
 * @author Santiago D
 */
public class Lienzo extends javax.swing.JPanel implements Runnable{

    
    private LinkedList<FiguraEstandar> misFiguras;
    private boolean isPlaying;
    private int i = 0,segundos = 0,aux = -1,aux1 = 0;
    private Imagen adver;
    private Imagen flecha;
    private Proyectil shuriken;
    
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        this.isPlaying = false;
        this.misFiguras = new LinkedList<>();
        adver = new Imagen("src/Imagenes/adver.png", 0, 0,0,0);
        flecha = new Imagen("src/Imagenes/fizc.png", 0, 0,0,0);
        shuriken = new Proyectil("src/Imagenes/shuriken.png", 0, 0,0,0);
        this.misFiguras.add(adver);
        this.misFiguras.add(flecha);
        this.misFiguras.add(shuriken);
    }

    public boolean isIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public LinkedList<FiguraEstandar> getMisFiguras() {
        return misFiguras;
    }

    public void setMisFiguras(LinkedList<FiguraEstandar> misFiguras) {
        this.misFiguras = misFiguras;
    }
    
    public void dibujarImagen(Graphics g,Imagen imagenActual){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage(imagenActual.getUrl());
        g.drawImage(imagen,imagenActual.getX(),imagenActual.getY(), imagenActual.getAncho(),imagenActual.getAlto(), this);
        //g.drawRect(imagenActual.getX(),imagenActual.getY(), imagenActual.getAncho(),imagenActual.getAlto());
    }
    
    public void dibujarRectangulo(Graphics g,FiguraEstandar rectangulo){
        g.setColor(Color.red);
        //g.drawRect(rectangulo.getX(),rectangulo.getY(),rectangulo.getAncho(),rectangulo.getAlto());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int a = 0;a < this.misFiguras.size();a++){
            FiguraEstandar actual = this.misFiguras.get(a);
            if(actual instanceof Imagen){
                dibujarImagen(g, (Imagen) actual);                
            }else{
                dibujarRectangulo(g, actual);
            }
            
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        while(this.isPlaying){
            repaint();
            mover();
            esperar(5);
            i++;
            if(i == 200){
               i = 0;
               segundos++;               
            }                        
        }
        System.out.println("Fin del proceso");
    }

    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    public String verificarColision(Jugador jugador){
        String colision = "no colisiona";
        int i = 0;
        while(i < this.getMisFiguras().size() && colision.equals("no colisiona")){
            if(jugador!= this.getMisFiguras().get(i)){
                if(jugador.getY()+jugador.getAlto() == this.misFiguras.get(i).getY()){
                    colision = "abajo";
                }else{
                    colision = "no colisiona";
                }
            }            
            i++;
        }
        return colision;
    }
    
    public void mover(){
        for(FiguraEstandar actual: this.misFiguras){
            if(actual instanceof FiguraEstandar){
                //System.out.println(""+aux);
                if(actual instanceof Imagen){
                    Imagen temp = (Imagen)actual;
                    if(temp instanceof Jugador){
                       Jugador jugador = (Jugador)temp;
                       String respuesta = verificarColision(jugador);
                       //System.out.println(respuesta);
                    }                    
                    
                    //System.out.println(""+this.segundos);
                }else if(this.segundos >= 2){
                    if(aux != this.segundos && aux+1 != this.segundos && aux+2 != this.segundos && aux+3 != this.segundos){                        
                        aux = this.segundos;
                        this.adver.setAlto(80);
                        this.adver.setAncho(80);
                        this.flecha.setAlto(40);
                        this.flecha.setAncho(40);
                        this.shuriken.setAlto(0);
                        this.shuriken.setAncho(0);
                        int num1 = (int)Math.floor(Math.random()*6+1);
                        switch (num1) {
                            case 1 -> {
                                this.adver.setX(10);
                                this.adver.setY(470);
                                int num2 = (int)Math.floor(Math.random()*2+1);
                                if(num2 == 1){
                                    this.flecha.setX(88);
                                    this.flecha.setY(495);
                                    this.flecha.setUrl("src/Imagenes/fdec.png");
                                }else if(num2 == 2){
                                    this.flecha.setX(82);
                                    this.flecha.setY(470);
                                    this.flecha.setUrl("src/Imagenes/fdear.png");
                                }                                
                            }
                            case 2 -> {
                                this.adver.setX(10);
                                this.adver.setY(330);
                                int num2 = (int)Math.floor(Math.random()*3+1);
                                if(num2 == 1){
                                    this.flecha.setX(88);
                                    this.flecha.setY(355);
                                    this.flecha.setUrl("src/Imagenes/fdec.png");
                                }else if(num2 == 2){
                                    this.flecha.setX(82);
                                    this.flecha.setY(330);
                                    this.flecha.setUrl("src/Imagenes/fdear.png");
                                }else if(num2 == 3){
                                    this.flecha.setX(82);
                                    this.flecha.setY(380);
                                    this.flecha.setUrl("src/Imagenes/fdeab.png");
                                }
                            }
                            case 3 -> {
                                this.adver.setX(10);
                                this.adver.setY(170);
                                int num2 = (int)Math.floor(Math.random()*3+1);
                                if(num2 == 1){
                                    this.flecha.setX(88);
                                    this.flecha.setY(195);
                                    this.flecha.setUrl("src/Imagenes/fdec.png");
                                }else if(num2 == 2){
                                    this.flecha.setX(82);
                                    this.flecha.setY(170);
                                    this.flecha.setUrl("src/Imagenes/fdear.png");
                                }else if(num2 == 3){
                                    this.flecha.setX(82);
                                    this.flecha.setY(220);
                                    this.flecha.setUrl("src/Imagenes/fdeab.png");
                                }
                            }
                            case 4 -> {
                                this.adver.setX(1110);
                                this.adver.setY(170);
                                int num2 = (int)Math.floor(Math.random()*3+1);
                                if(num2 == 1){
                                    this.flecha.setX(1080);
                                    this.flecha.setY(189);
                                    this.flecha.setUrl("src/Imagenes/fizc.png");
                                }else if(num2 == 2){
                                    this.flecha.setX(1085);
                                    this.flecha.setY(170);
                                    this.flecha.setUrl("src/Imagenes/fizar.png");
                                }else if(num2 == 3){
                                    this.flecha.setX(1085);
                                    this.flecha.setY(220);
                                    this.flecha.setUrl("src/Imagenes/fizab.png");
                                }
                            }
                            case 5 -> {
                                this.adver.setX(1110);
                                this.adver.setY(330);
                                int num2 = (int)Math.floor(Math.random()*3+1);
                                if(num2 == 1){
                                    this.flecha.setX(1080);
                                    this.flecha.setY(349);
                                    this.flecha.setUrl("src/Imagenes/fizc.png");
                                }else if(num2 == 2){
                                    this.flecha.setX(1085);
                                    this.flecha.setY(330);
                                    this.flecha.setUrl("src/Imagenes/fizar.png");
                                }else if(num2 == 3){
                                    this.flecha.setX(1085);
                                    this.flecha.setY(380);
                                    this.flecha.setUrl("src/Imagenes/fizab.png");
                                }
                            }
                            case 6 -> {
                                this.adver.setX(1110);
                                this.adver.setY(470);
                                int num2 = (int)Math.floor(Math.random()*2+1);
                                if(num2 == 1){
                                    this.flecha.setX(1080);
                                    this.flecha.setY(489);
                                    this.flecha.setUrl("src/Imagenes/fizc.png");
                                }else if(num2 == 2){
                                    this.flecha.setX(1085);
                                    this.flecha.setY(470);
                                    this.flecha.setUrl("src/Imagenes/fizar.png");
                                }
                            }
                            default -> {
                            }
                        }
                    }                   
                }
                if(this.segundos >= 2){
                    if(aux1 != this.segundos && aux1+1 != this.segundos){
                        aux1 = this.segundos;
                        this.adver.setAlto(0);
                        this.adver.setAncho(0);
                        this.flecha.setAlto(0);
                        this.flecha.setAncho(0);
                    }
                }
                if(this.segundos>=3){
                    if(this.adver.getAlto() == 0 && this.shuriken.getAlto()== 0){
                        this.shuriken.setAlto(60);
                        this.shuriken.setAncho(60);
                        this.shuriken.setX(this.adver.getX());
                        this.shuriken.setY(this.adver.getY());
                        if(flecha.getUrl().equals("src/Imagenes/fdec.png")){
                            this.shuriken.setPuntero("derecha-centro");
                        }else if(flecha.getUrl().equals("src/Imagenes/fdear.png")){
                            this.shuriken.setPuntero("derecha-arriba");
                        }else if(flecha.getUrl().equals("src/Imagenes/fdeab.png")){
                            this.shuriken.setPuntero("derecha-abajo");
                        }else if(flecha.getUrl().equals("src/Imagenes/fizc.png")){
                            this.shuriken.setPuntero("izquierda-centro");
                        }else if(flecha.getUrl().equals("src/Imagenes/fizar.png")){
                            this.shuriken.setPuntero("izquierda-arriba");
                        }else if(flecha.getUrl().equals("src/Imagenes/fizab.png")){
                            this.shuriken.setPuntero("izquierda-abajo");
                        }
                    }else if(this.adver.getAlto() == 0){
                        if(this.shuriken.getPuntero().equals("derecha-centro")){
                            this.shuriken.moverDE(1);
                        }else if(this.shuriken.getPuntero().equals("derecha-arriba")){
                            this.shuriken.moverDE(1);
                            this.shuriken.moverAR(1);
                        }else if(this.shuriken.getPuntero().equals("derecha-abajo")){
                            this.shuriken.moverDE(1);
                            this.shuriken.moverAB(1);
                        }else if(this.shuriken.getPuntero().equals("izquierda-centro")){
                            this.shuriken.moverIZ(1);
                        }else if(this.shuriken.getPuntero().equals("izquierda-arriba")){
                            this.shuriken.moverIZ(1);
                            this.shuriken.moverAR(1);
                        }else if(this.shuriken.getPuntero().equals("izquierda-abajo")){
                            this.shuriken.moverIZ(1);
                            this.shuriken.moverAB(1);
                        }                        
                    }
                }
            }
        }
    }

    public int getI() {
        return i/2;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public int getAux1() {
        return aux1;
    }

    public void setAux1(int aux1) {
        this.aux1 = aux1;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
