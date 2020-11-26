package menu;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;

public class Menu extends javax.swing.JFrame {
	
	private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botonIniciarJuego;
    private javax.swing.JButton botonInstrucciones;
    private javax.swing.JLabel etiquetaTitulo;
    
    private javax.swing.JLabel imagenfondo;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JPanel panel;
    private javax.swing.JMenuItem subMenuSalir;
	
    public Menu() {
    	iniciarComponentes();
    	this.setTitle(Juego.TITULO);
    	this.setSize(685, 650);
        this.setLocationRelativeTo(null);
        
    }

                              
    private void iniciarComponentes() {
    	ImageIcon imagen = new ImageIcon ("./resources/fondo/fondopp.png");
    	panel = new javax.swing.JPanel();
        etiquetaTitulo = new javax.swing.JLabel();
        
        imagenfondo = new javax.swing.JLabel(new ImageIcon (imagen.getImage().getScaledInstance(685,650,Image.SCALE_SMOOTH)));
        
        botonIniciarJuego = new javax.swing.JButton();
        botonInstrucciones = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        subMenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(0, 0, 0));            

        etiquetaTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); 
        etiquetaTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("Boss Rabbit - Grupo 6 - V1");      

        botonIniciarJuego.setFont(new java.awt.Font("Arial Black", 0, 24)); 
        botonIniciarJuego.setText("INICIAR JUEGO");
        botonIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarJuegoActionPerformed(evt);
            }
        });

        botonInstrucciones.setFont(new java.awt.Font("Arial Black", 0, 24)); 
        botonInstrucciones.setText("INSTRUCCIONES");
        botonInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInstruccionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiquetaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonIniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(etiquetaTitulo)
                .addGap(128, 128, 128)
                .addComponent(botonIniciarJuego)
                .addGap(97, 97, 97)
                .addComponent(botonInstrucciones))
        );

        menuOpciones.setText("Opciones");

        subMenuSalir.setText("Salir");
        subMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSalirActionPerformed(evt);
            }
        });
        menuOpciones.add(subMenuSalir);

        barraMenu.add(menuOpciones);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                       

    private void botonIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        this.dispose();
        Juego juego=new Juego();
        
    }                                                 

    private void botonInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        MenuInstrucciones instrucciones = new MenuInstrucciones(this,true);
        instrucciones.setVisible(true);
    }                                                  

    private void subMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.exit(0);
    }                                            

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }              
}
