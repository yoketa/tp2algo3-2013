package panel;

import javax.swing.JLabel;

public class PanelDelJuego extends javax.swing.JFrame {
    
    private String usuario;
    private String dificultad;
    private MenuPartidaNueva menuPartidaNueva;
    private String tipoDeVehiculo;

    /** Creates new form PanelDelJuego */
    public PanelDelJuego() {
        initComponents();
    }

    PanelDelJuego(MenuPartidaNueva menuPartida, String dificultad, String usuario,String vehiculo) {
        
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.tipoDeVehiculo = vehiculo;
        this.setTitle("Hola "+this.usuario+"                          "
                + "                                                   "
                + "                       Partida"+this.dificultad);
        initComponents();
        this.menuPartidaNueva = menuPartida;
        menuPartida.setVisible(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
        
        // Añado Tipo de Vehiculo
        this.addTipoDeVehiculo();
        
//        Imagen del mapa
//         JLabel img = new JLabel("");   
//         img.setIcon(new ImageIcon("C:\\Users\\Ramon\\Documents\\NetBeansProjects\\Gps\\src\\imagenes\\mapa_prueba.png")); 
//         img.setBounds(50, 1, 500, 600);
//         add(img);
//
//        Image image = new Image("C:\\Users\\Ramon\\Documents\\NetBeansProjects\\Gps\\src\\imagenes\\mapa_prueba.png"); 
//        this.add(img); // "dibujar" es mi panel ok... 
//        //Propiedades de la etiqueta
//        img.setIcon(image); 
//        img.setSize(100,100); 
//        img.setLocation(500,250); 
//        img.setVisible(true); 
          //panel.setBackground(Color.green);
//        panel.imageUpdate(image, 100, 500, 250, 100, 100);
    }

    private void addTipoDeVehiculo() {

        int x,y,alto,ancho;
        
        x = this.EtiquetaTipoVehiculo.getX();
        y = this.EtiquetaTipoVehiculo.getY();
        alto = this.EtiquetaTipoVehiculo.getHeight();
        ancho = this.EtiquetaTipoVehiculo.getWidth();

        JLabel tipoDeVehiculo = new JLabel(this.tipoDeVehiculo);
        tipoDeVehiculo.setBounds(x+125,y,ancho,alto);
        add(tipoDeVehiculo);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        EtiquetaMovimientosActuales = new javax.swing.JLabel();
        EtiquetaMovimientosPermitidos = new javax.swing.JLabel();
        EtiquetaPuntaje = new javax.swing.JLabel();
        EtiquetaTipoVehiculo = new javax.swing.JLabel();
        BotonGuardarYSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EtiquetaMovimientosActuales.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        EtiquetaMovimientosActuales.setText("#Movimiento Actuales   : ");

        EtiquetaMovimientosPermitidos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        EtiquetaMovimientosPermitidos.setText("#Movimiento Permitidos : ");

        EtiquetaPuntaje.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        EtiquetaPuntaje.setText("Puntaje : ");

        EtiquetaTipoVehiculo.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        EtiquetaTipoVehiculo.setText("Vehiculo Actual : ");

        BotonGuardarYSalir.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        BotonGuardarYSalir.setText("Guardar y Salir");
        BotonGuardarYSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarYSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(EtiquetaMovimientosPermitidos)
                        .addComponent(EtiquetaMovimientosActuales))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EtiquetaTipoVehiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addGap(406, 406, 406)
                .addComponent(EtiquetaPuntaje)
                .addGap(119, 119, 119))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(629, Short.MAX_VALUE)
                .addComponent(BotonGuardarYSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EtiquetaMovimientosPermitidos)
                    .addComponent(EtiquetaPuntaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EtiquetaMovimientosActuales)
                .addGap(87, 87, 87)
                .addComponent(EtiquetaTipoVehiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(BotonGuardarYSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void BotonGuardarYSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton BotonGuardarYSalir;
    private javax.swing.JLabel EtiquetaMovimientosActuales;
    private javax.swing.JLabel EtiquetaMovimientosPermitidos;
    private javax.swing.JLabel EtiquetaPuntaje;
    private javax.swing.JLabel EtiquetaTipoVehiculo;
    // End of variables declaration

}
