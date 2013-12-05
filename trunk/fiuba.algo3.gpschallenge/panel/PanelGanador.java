package panel;


import java.util.List;

import javax.swing.JOptionPane;

import excepciones.MovimientoFueraDeMapaException;

import persistencia.Archivador;

import modelo.juego.Juego;
import modelo.juego.Ranking;
import modelo.vehiculo.Vehiculo;

public class PanelGanador extends javax.swing.JFrame {

    private String usuario;
    private String dificultad;
    private PanelDelJuego panel;
    private MenuPrincipal menuPrincipal;
	private int movimientos;
	private int puntaje;
	private Ranking ranking;
    
public PanelGanador(String dificultad, String usuario,Juego juego) throws Exception {
        
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.setTitle("Hola "+this.usuario+"                         Partida"+this.dificultad);
        
        this.movimientos = juego.movimientosLimites(dificultad)-juego.getVehiculo().getMovimientos();
        this.puntaje = juego.puntajePorMovimiento(dificultad);
        
        this.ranking = new Ranking();
        this.ranking = Archivador.cargar(ranking, ranking.rankingPath);
        this.ranking.agregarPuntaje(juego.getVehiculo());
		Archivador.guardar(ranking, Ranking.rankingPath);
        
        initComponents();
        
        this.panel = panel;
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        botonJugarDeNuevo = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etiqueteMovimientos = new javax.swing.JLabel();
        etiquetaPuntaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonJugarDeNuevo.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        botonJugarDeNuevo.setForeground(new java.awt.Color(0, 0, 102));
        botonJugarDeNuevo.setText("Jugar de nuevo");
        botonJugarDeNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarDeNuevoActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(0, 0, 102));
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 48));
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("¡ Ganaste !");
        jLabel1.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Gabriola", 1, 24));
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Te sobraron: ");

        jLabel3.setFont(new java.awt.Font("Gabriola", 1, 24));
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Tu Puntaje es: ");

        etiqueteMovimientos.setText(Integer.toString(this.movimientos));
        etiquetaPuntaje.setText(Integer.toString(this.puntaje));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonJugarDeNuevo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaPuntaje)
                                    .addComponent(etiqueteMovimientos))))))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(botonSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etiqueteMovimientos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaPuntaje))
                .addGap(33, 33, 33)
                .addComponent(botonJugarDeNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(botonSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.exit(0);
    }                                          

    private void botonJugarDeNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        this.menuPrincipal = new MenuPrincipal(this,this.usuario);
        this.menuPrincipal.setBounds(500,250,450,250);
        this.menuPrincipal.setVisible(true);
    }                                                 

    // Variables declaration - do not modify
    private javax.swing.JButton botonJugarDeNuevo;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel etiqueteMovimientos;
    private javax.swing.JLabel etiquetaPuntaje;
    // End of variables declaration
}

