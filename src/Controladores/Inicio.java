/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Controladores;

import Modelos.FiguraEstandar;
import Modelos.Imagen;
import Modelos.Jugador;
import Modelos.Proyectil;
import java.awt.event.KeyEvent;

/**
 *
 * @author Santiago D
 */
public final class Inicio extends javax.swing.JFrame implements Runnable{

    Thread procesoJuego;
    Thread tiempo;
    Jugador jugador;
    int j = 0;
    int alturaMax;
    
    /**
     * Constructor del Frame
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        this.setSize(1300, 748);
        this.setResizable(false);
        setLocationRelativeTo(null);
        crearObjetos1();
        crearObjetos2();
        this.lienzo.setVisible(false);
        this.setFocusable(true);
        alturaMax = this.jugador.getY()-180;
        GameOver.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new Controladores.Lienzo();
        points = new javax.swing.JLabel();
        btn_restart = new javax.swing.JLabel();
        btn_pause = new javax.swing.JLabel();
        btn_play = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        points2 = new javax.swing.JLabel();
        GameOver = new javax.swing.JLabel();
        intro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lienzo.setBackground(new java.awt.Color(255, 255, 255));
        lienzo.setOpaque(false);
        lienzo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        points.setFont(new java.awt.Font("OCR A Std", 0, 27)); // NOI18N
        points.setForeground(new java.awt.Color(255, 185, 5));
        lienzo.add(points, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 120, 50));

        btn_restart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_restartMouseClicked(evt);
            }
        });
        lienzo.add(btn_restart, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 25, 30, 30));

        btn_pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pauseMouseClicked(evt);
            }
        });
        lienzo.add(btn_pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 25, 30, 30));

        btn_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_playMouseClicked(evt);
            }
        });
        lienzo.add(btn_play, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 25, 30, 30));

        time.setFont(new java.awt.Font("OCR A Std", 0, 27)); // NOI18N
        time.setForeground(new java.awt.Color(255, 185, 5));
        lienzo.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 5, 120, 40));

        getContentPane().add(lienzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1200, 630));

        points2.setFont(new java.awt.Font("OCR A Std", 0, 36)); // NOI18N
        points2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(points2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 125, 180, 60));
        points2.getAccessibleContext().setAccessibleDescription("");

        GameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GameOver.png"))); // NOI18N
        getContentPane().add(GameOver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        intro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/intro.png"))); // NOI18N
        getContentPane().add(intro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 710));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Detecta si el usuario presiono una tecla, y segun eso se mueve para alguna direccion
     * @param evt 
     */
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(this.lienzo.isIsPlaying()){
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_RIGHT -> moverDerecha();                
                case KeyEvent.VK_LEFT -> moverIzquierda();
                case KeyEvent.VK_UP -> moverArriba();
                case KeyEvent.VK_DOWN -> moverAbajo();
            }
        }        
    }//GEN-LAST:event_formKeyPressed

    /**
     * Detecta si el usuario presiona enter para iniciar el juego
     * @param evt 
     */
    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            if(GameOver.isVisible()){
                intro.setVisible(true);
                GameOver.setVisible(false);
                points2.setText("");
            }else{
                if(!this.lienzo.isIsPlaying()){
                    reinicio1();
                    reinicio2();
                }
                this.setFocusable(true); 
            }            
        }
    }//GEN-LAST:event_formKeyTyped

    /**
     * Boton de pausa del juego
     * @param evt 
     */
    private void btn_pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pauseMouseClicked
        if(this.lienzo.isIsPlaying()){
            this.lienzo.setIsPlaying(false);
        }        
    }//GEN-LAST:event_btn_pauseMouseClicked

    /**
     * Boton de play
     * @param evt 
     */
    private void btn_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_playMouseClicked
        if(!this.lienzo.isIsPlaying()){
            this.procesoJuego = new Thread(this.lienzo);
            this.lienzo.setIsPlaying(true);
            this.procesoJuego.start();
            this.tiempo = new Thread(this);
            this.tiempo.start();
        }
    }//GEN-LAST:event_btn_playMouseClicked

    /**
     * Boton de reinicio
     * @param evt 
     */
    private void btn_restartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restartMouseClicked
        if(!this.lienzo.isIsPlaying()){
            reinicio1();
            reinicio2();
            this.lienzo.setAux(-3);
            this.lienzo.setAux1(0);
            this.lienzo.setPuntos(0);
        }else{
            reinicio3();
            this.lienzo.setPuntos(0);
        }
    }//GEN-LAST:event_btn_restartMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }
    
    /**
     * Metodo que mantiene actualizado el tiempo y los puntos en el juego
     */
   public void actualizarTiempo(){
       this.time.setText(""+this.lienzo.getSegundos()+"."+this.lienzo.getI());
       this.points.setText(""+this.lienzo.getPuntos()*100);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GameOver;
    private javax.swing.JLabel btn_pause;
    private javax.swing.JLabel btn_play;
    private javax.swing.JLabel btn_restart;
    private javax.swing.JLabel intro;
    private javax.swing.JLabel jLabel1;
    private Controladores.Lienzo lienzo;
    private javax.swing.JLabel points;
    private javax.swing.JLabel points2;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo que se mantiene corriendo mientras se este hugando
     */
    @Override
    public void run() {
        while(this.lienzo.isIsPlaying()){
            actualizarTiempo();
            mover();
            esperar(2);
        }
    }
    
    /**
     * Metodo que verifica si el usuario choca con algo ya sea una plataforma o un proyectil
     * @return El valor de dicha colision
     */
    public String verificarColision(){
        String colision = "no colisiona";
        int i = 0;
        while(i < this.lienzo.getMisFiguras().size() && colision.equals("no colisiona")){
            FiguraEstandar actual = this.lienzo.getMisFiguras().get(i);
            colision = colision3(actual);
            i++;
        }
        return colision;
    }
    
    /**
     * Metodo que permite al usuario saltar detectando cual es su estado y subiendo o bajando 
     * segun sea el caso
     */
    public void mover(){
        String respuesta = verificarColision();
        if(this.jugador.getEstado().equals("aire") || respuesta.equals("no colisiona")){                    
            if(this.jugador.getAire().equals("subida") && this.jugador.getY() - 1 >= alturaMax){
                salto1();
            }else if(!respuesta.equals("abajo")){  
                salto2();
                alturaMax = this.jugador.getY()-180;
            }else if(respuesta.equals("abajo")){
                salto3();
            }
        }
    } 
    
    /**
     * Metodo que hace esperar al sistema para continuar su ejecucion
     * @param milisegundos 
     */
    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Metodo inicializador de todos los objetos nesesarios para empezar el juego
     * Ademas de a??adirlos a la lista de figuras para posteriormente ser pintadas en lienzo
     */
    public void crearObjetos1(){
        this.jugador = new Jugador("src/Imagenes/StandingR.png", 600, 493, 90, 86);        
        FiguraEstandar suelo = new FiguraEstandar(0,583, 1, 1200);
        FiguraEstandar suelo1 = new FiguraEstandar(0,420, 1, 327);
        FiguraEstandar suelo2 = new FiguraEstandar(548,420, 1, 513);
        FiguraEstandar suelo3 = new FiguraEstandar(159,276, 1, 257);
        FiguraEstandar suelo4 = new FiguraEstandar(727,276, 1, 92);
        this.lienzo.getMisFiguras().add(suelo);
        this.lienzo.getMisFiguras().add(suelo1);
        this.lienzo.getMisFiguras().add(suelo2);
        this.lienzo.getMisFiguras().add(suelo3);
        this.lienzo.getMisFiguras().add(suelo4);
        
    }
    
    /**
     * Metodo auxiliar a crearObjetos1 en el cual se crean y a??aden objetos para empezar el juego
     */
    public void crearObjetos2(){
        FiguraEstandar suelo5 = new FiguraEstandar(1046,276, 1, 238);
        FiguraEstandar suelo6 = new FiguraEstandar(0,132, 1, 92);
        FiguraEstandar suelo7 = new FiguraEstandar(286,132, 1, 217);
        FiguraEstandar suelo8 = new FiguraEstandar(798,132, 1, 758);
        this.lienzo.getMisFiguras().add(suelo5);
        this.lienzo.getMisFiguras().add(suelo6);
        this.lienzo.getMisFiguras().add(suelo7);
        this.lienzo.getMisFiguras().add(suelo8);
        this.lienzo.getMisFiguras().add(jugador);
    }
    
    /**
     * Metodo que crea la animacion del usuario caminando cambiandolo por una serie de imagenes
     * Siempre y cuando su direccion sea la derecha
     */
    public void animacionDerecha(){
        switch (this.j) {
            case 0 -> this.jugador.setUrl("src/Imagenes/StandingR.png");
            case 1 -> this.jugador.setUrl("src/Imagenes/wk1.png");
            case 2 -> this.jugador.setUrl("src/Imagenes/wk2.png");
            case 3 -> this.jugador.setUrl("src/Imagenes/wk3.png");
            case 4 -> this.jugador.setUrl("src/Imagenes/wk4.png");
            case 5 -> this.jugador.setUrl("src/Imagenes/wk5.png");
            case 6 -> this.jugador.setUrl("src/Imagenes/wk6.png");
            case 7 -> this.jugador.setUrl("src/Imagenes/wk7.png");
            default -> this.j = 0;            
        }
    }
    
    /**
     * Metodo que crea la animacion del usuario caminando cambiandolo por una serie de imagenes
     * Siempre y cuando su direccion sea la izquierda
     */
    public void animacionIzquierda(){
        switch (j) {
            case 0 -> this.jugador.setUrl("src/Imagenes/StandingL.png");
            case 1 -> this.jugador.setUrl("src/Imagenes/wk8.png");
            case 2 -> this.jugador.setUrl("src/Imagenes/wk9.png");
            case 3 -> this.jugador.setUrl("src/Imagenes/wk10.png");
            case 4 -> this.jugador.setUrl("src/Imagenes/wk11.png");
            case 5 -> this.jugador.setUrl("src/Imagenes/wk12.png");
            case 6 -> this.jugador.setUrl("src/Imagenes/wk13.png");
            case 7 -> this.jugador.setUrl("src/Imagenes/wk14.png");
            default -> j = 0;
        }
    }
    
    /**
     * Metodo que permite al usuario moverse hacia la derecha y preveendo que no se salga de los limites
     * predispuestos por el liezo
     */
    public void moverDerecha(){
        if(this.jugador.getEstado().equals("suelo")){
            if(this.jugador.getDireccion().equals("derecha")){
                animacionDerecha();
            }else if(this.jugador.getDireccion().equals("izquierda")){
                this.jugador.setDireccion("derecha");
                this.jugador.setUrl("src/Imagenes/StandingR.png");
            }   
            if(this.jugador.getX()+this.jugador.getAncho()+20 <= this.lienzo.getWidth()){
                this.jugador.moverDE(20);
            }
        }
        j++;
    }
    
    /**
     * Metodo que permite al usuario moverse hacia la izquierda y preveendo que no se salga de los limites
     * predispuestos por el liezo
     */
    public void moverIzquierda(){
        if(this.jugador.getDireccion().equals("derecha")){
            this.jugador.setDireccion("izquierda");
            this.jugador.setUrl("src/Imagenes/StandingL.png");
        }else{
            animacionIzquierda();
        }   
        if(this.jugador.getX()-20 >= 0){
            this.jugador.moverIZ(20);
        }
        j++;
    }
    
    /**
     * Metodo que mueve al jugador hacia arriba siempre y cuando este saltando
     */
    public void moverArriba(){
        if(this.jugador.getEstado().equals("suelo")){
            this.jugador.setEstado("aire");
            this.jugador.setAire("subida");                        
        }
        this.jugador.moverAR(1);
    }
    
    /**
     * Metodo que permite mover el jugador para abajao siempre y cuando este en bajada
     */
    public void moverAbajo(){
        if(this.jugador.getY() != 493){
            this.jugador.moverAB(1);
        }
    }
    
    /**
     * Primero de tres metodos que permite el reinicio del juego y todos sus parametros
     */
    public void reinicio1(){
        this.procesoJuego = new Thread(this.lienzo);
        this.lienzo.setSegundos(0);
        this.lienzo.setI(0);
        this.lienzo.setIsPlaying(true);
        this.procesoJuego.start();
        this.tiempo = new Thread(this);
        this.tiempo.start();
        this.lienzo.setVisible(true);
        this.lienzo.setPuntos(0);
    }
    
    /**
     * Segundo de tres metodos que permite el reinicio del juego y todos sus parametros
     */
    public void reinicio2(){
        intro.setVisible(false);
        this.jugador.setX(600);
        this.jugador.setY(493);
        this.lienzo.setVisible(true);
        this.jugador.setUrl("src/Imagenes/StandingR.png");
        this.jugador.setEstado("suelo");
        this.jugador.setAire("neutral");
        alturaMax = this.jugador.getY()-180;
    }
    
    /**
     * Tercero de tres metodos que permite el reinicio del juego y todos sus parametros
     */
    public void reinicio3(){
        this.lienzo.setSegundos(0);
        this.lienzo.setI(0);
        this.jugador.setX(600);
        this.jugador.setY(493);
        this.jugador.setUrl("src/Imagenes/StandingR.png");
        this.jugador.setEstado("suelo");
        this.jugador.setAire("neutral");
        this.lienzo.getAdver().setAlto(0);
        this.lienzo.getAdver().setAncho(0);
        this.lienzo.getFlecha().setAlto(0);
        this.lienzo.getFlecha().setAncho(0);
        this.lienzo.getShuriken().setAlto(0);
        this.lienzo.getShuriken().setAncho(0);
    }
    
    /**
     * Metodo que verifica que el usuario no se halla chocado con un proyectil
     * Y en el caso de que si que se termine el juego y muestre game over
     * @param temp 
     */
    public void colision(Imagen temp){
        if((jugador.getY()+jugador.getAlto() >= temp.getY() && temp.getY() + temp.getAlto() >= jugador.getY()) && (temp.getX() + temp.getAncho() >= jugador.getX() && jugador.getX() + jugador.getAncho() >= temp.getX())){
            this.lienzo.setIsPlaying(false);
            GameOver.setVisible(true);
            this.points2.setText(""+this.lienzo.getPuntos()*100);
            this.lienzo.setVisible(false);
            temp.setAncho(0);
            temp.setAlto(0);
            temp.setX(0);
            temp.setY(0);
            this.lienzo.setAux(-3);
            this.lienzo.setAux1(0);
        }
    }
    
    /**
     * Metodo que verifica que el jugador siempre este parado sobre una plataforma lo cual le permite
     * Poder saltar y caerse de plataforma a plataforma
     * @param actual
     * @return el valor de colision
     */
    public String colision2(FiguraEstandar actual){
        String colision = "no colisiona";
        if(jugador!= actual){
            if((jugador.getY()+jugador.getAlto() >= actual.getY() && actual.getY() + actual.getAlto() >= jugador.getY()) && (actual.getX() + actual.getAncho() >= jugador.getX() && jugador.getX() + jugador.getAncho() >= actual.getX())){
                if(jugador.getY()+jugador.getAlto() == actual.getY()){
                    colision = "abajo";
                }
            }else{
                colision = "no colisiona";
            }
        }
        return colision;
    }
    
    /**
     * Metodo principal que junta los metodos de colision1 y dos para ver si el jugador colisiona con 
     * Un proyectil o con una plataforma
     * @param actual
     * @return el valor de la colision
     */
    public String colision3(FiguraEstandar actual){
        String colision = "no colisiona";
        if(actual instanceof Imagen){
            Imagen temp = (Imagen) actual;
            if(temp instanceof Proyectil){
                colision(temp);
            }
        }else{
            if(jugador!= actual){
                colision = colision2(actual);
            } 
        }
        return colision;
    }
    
    /**
     * Metodo que move al jugador a la derecha o a la izquierda ademas de cambiarle la imagen cuando el 
     * Jugador esta saltando, para que se pueda ver su movimiento parabolico, cuando esta llendo para arriba
     */
    public void salto1(){
        this.jugador.moverAR(1);
        if(this.jugador.getDireccion().equals("derecha")){
            if(this.jugador.getX() + this.jugador.getAncho() + 1 < this.lienzo.getWidth()){
                this.jugador.moverDE(1); 
                this.jugador.setUrl("src/Imagenes/slt1.png");
            }
        }else{
            if(this.jugador.getX() - 1 > 0){
                this.jugador.moverIZ(1);
                this.jugador.setUrl("src/Imagenes/sl3.png");
            }                            
        }
    }
    
    /**
     * Metodo que move al jugador a la derecha o a la izquierda ademas de cambiarle la imagen cuando el 
     * Jugador esta saltando, para que se pueda ver su movimiento parabolico, cuando esta llendo para abajo
     */
    public void salto2(){
        this.jugador.setAire("bajada");
        this.jugador.moverAB(1);
        if(this.jugador.getDireccion().equals("derecha")){
            if(this.jugador.getX() + this.jugador.getAncho() + 1 < this.lienzo.getWidth()){
                this.jugador.moverDE(1);
                this.jugador.setUrl("src/Imagenes/slt2.png");
            }   
        }else{
            if(this.jugador.getX() - 1 > 0){
                this.jugador.moverIZ(1);
                this.jugador.setUrl("src/Imagenes/sl4.png");
            }                            
        }
    }
    
    /**
     * Metodo que finaliza los saltos y reinica los valores del jugador para que pueda volver a saltar
     */
    public void salto3(){
        if(this.jugador.getDireccion().equals("derecha")){
            this.jugador.setUrl("src/Imagenes/StandingR.png");
        }else{
            this.jugador.setUrl("src/Imagenes/StandingL.png");
        }
        this.jugador.setEstado("suelo"); 
        this.jugador.setAire("neutral");
        alturaMax = this.jugador.getY()-180;
    }
    
}
