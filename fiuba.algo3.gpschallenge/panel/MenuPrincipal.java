package panel;

public class MenuPrincipal extends javax.swing.JFrame {

    private MenuEleccionUsuario menuDeEleccion;
    private MenuRegistracion menuRegistracion;
    private MenuPartidaNueva menuPartidaNueva;
    private MenuPuntajes menuPuntajes;
    private String usuario;
    private boolean accionPreviaEsRegistracion = false;
    
    public MenuPrincipal() {
        initComponents();
    }

    MenuPrincipal(MenuEleccionUsuario menuEleccion, String user) {
        this.usuario = user;
        this.setTitle("Hola "+usuario+"                       Gps Challenge");
        initComponents();
        this.menuDeEleccion = menuEleccion;
        menuEleccion.setVisible(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }
    
    MenuPrincipal(MenuRegistracion menuRegistracion, String user) {
        this.accionPreviaEsRegistracion = true;
        this.usuario = user;
        this.setTitle("Hola "+usuario+"                       Gps Challenge");
        initComponents();
        this.menuRegistracion = menuRegistracion;
        menuRegistracion.setVisible(false);
        this.retornarPartida.setEnabled(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        comenzarPartida = new javax.swing.JButton();
        verPuntajes = new javax.swing.JButton();
        retornarPartida = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("meu"); // NOI18N

        comenzarPartida.setFont(new java.awt.Font("Consolas", 0, 14));
        comenzarPartida.setText("Comenzar Partida");
        comenzarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comenzarPartidaActionPerformed(evt);
            }
        });

        verPuntajes.setFont(new java.awt.Font("Consolas", 0, 14));
        verPuntajes.setText("Ver puntajes");
        verPuntajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPuntajesActionPerformed(evt);
            }
        });

        retornarPartida.setFont(new java.awt.Font("Consolas", 0, 14));
        retornarPartida.setText("Retomar partida guardada");
        retornarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornarPartidaActionPerformed(evt);
            }
        });

        salir.setFont(new java.awt.Font("Consolas", 0, 14));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        volver.setFont(new java.awt.Font("Consolas", 0, 14));
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comenzarPartida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(verPuntajes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(retornarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(comenzarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(retornarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verPuntajes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir)
                    .addComponent(volver))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {                                      
        System.exit(0);
    }                                     

    private void comenzarPartidaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        menuPartidaNueva = new MenuPartidaNueva(this,usuario);
        menuPartidaNueva.setBounds(500,250,425,250);
        menuPartidaNueva.setVisible(true);
    }                                               

    private void retornarPartidaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void verPuntajesActionPerformed(java.awt.event.ActionEvent evt) {                                            
        menuPuntajes = new MenuPuntajes(this,usuario);
        menuPuntajes.setBounds(500,250,400,450);
        menuPuntajes.setVisible(true);
    }                                           

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (this.accionPreviaEsRegistracion){
            this.menuRegistracion.setVisible(true);
        }else{
            this.menuDeEleccion.setVisible(true);
        }
        this.dispose();
    }                                      

    // Variables declaration - do not modify                     
    private javax.swing.JButton comenzarPartida;
    private javax.swing.JButton retornarPartida;
    private javax.swing.JButton salir;
    private javax.swing.JButton verPuntajes;
    private javax.swing.JButton volver;
    // End of variables declaration                   
}
