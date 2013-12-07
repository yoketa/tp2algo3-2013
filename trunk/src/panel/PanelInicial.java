package panel;

import java.awt.Color;

public class PanelInicial extends javax.swing.JFrame {

    private MenuRegistracion registracion;
    private MenuEleccionUsuario eleccionDeUsuario;
    
    //Constructor
    public PanelInicial() {
        this.setTitle("Gps Challenge");
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jBSoyNuevo = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jBYaTengoUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.black);

        Titulo.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 0, 250));
        Titulo.setText("Bienvenido a Gps Challence");

        jBSoyNuevo.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        jBSoyNuevo.setText("Soy nuevo");
        jBSoyNuevo.setForeground(Color.white);
        jBSoyNuevo.setBackground(new java.awt.Color(0, 0, 153));
        jBSoyNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSoyNuevoActionPerformed(evt);
            }
        });

        jBsalir.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        jBsalir.setText("Salir");
        jBsalir.setForeground(Color.white);
        jBsalir.setBackground(new java.awt.Color(0, 0, 153));
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jBYaTengoUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        jBYaTengoUsuario.setText("Ya tengo usuario");
        jBYaTengoUsuario.setForeground(Color.white);
        jBYaTengoUsuario.setBackground(new java.awt.Color(0, 0, 153));
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
                .addGap(25, 25, 25)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBSoyNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jBYaTengoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jBsalir, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBSoyNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBYaTengoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>

    
    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {                                        
        System.exit(0);
    }                                       

    private void jBSoyNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                           
        registracion = new MenuRegistracion(this);
        registracion.setBounds(500,250,450,275);
        registracion.setVisible(true);
    }                                          

    private void jBYaTengoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        eleccionDeUsuario = new MenuEleccionUsuario(this);
        eleccionDeUsuario.setBounds(500,150,300,350);
        eleccionDeUsuario.setVisible(true);
    }                                                

    // Variables declaration - do not modify
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jBSoyNuevo;
    private javax.swing.JButton jBYaTengoUsuario;
    private javax.swing.JButton jBsalir;
    // End of variables declaration
}
