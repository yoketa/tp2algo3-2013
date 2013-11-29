package panel;

public class PanelInicial extends javax.swing.JFrame {

    private MenuRegistracion registracion;
    private MenuEleccionUsuario eleccionDeUsuario;
    
    //Constructor
    public PanelInicial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jBSoyNuevo = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jBYaTengoUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        Titulo.setText("Bienvenido a Gps Challence");

        jBSoyNuevo.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jBSoyNuevo.setText("Soy nuevo");
        jBSoyNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSoyNuevoActionPerformed(evt);
            }
        });

        jBsalir.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jBsalir.setText("Salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jBYaTengoUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jBYaTengoUsuario.setText("Ya tengo usuario");
        jBYaTengoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBYaTengoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBSoyNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jBYaTengoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jBsalir, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addGap(86, 86, 86))
                    .addComponent(Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBSoyNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBYaTengoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    
    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {                                       
        System.exit(0);
    }                                      

    private void jBSoyNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                          
    registracion = new MenuRegistracion(this);
    registracion.setBounds(500,250,450,250);
    registracion.setVisible(true);
    }                                         

    private void jBYaTengoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                         
    eleccionDeUsuario = new MenuEleccionUsuario(this);
    eleccionDeUsuario.setBounds(500,150,450,600);
    eleccionDeUsuario.setVisible(true);
    }                                        

    // Variables declaration - do not modify
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jBSoyNuevo;
    private javax.swing.JButton jBYaTengoUsuario;
    private javax.swing.JButton jBsalir;
    // End of variables declaration
}