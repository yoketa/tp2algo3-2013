package panel;

import java.awt.Color;

public class MenuRegistracion extends javax.swing.JFrame {

    private PanelInicial menu;
    private MenuPrincipal menuPrincipal;
    
    public MenuRegistracion() {
        initComponents();
    }

    public MenuRegistracion(PanelInicial panel) {
        this.setTitle("Gps Challenge");
        initComponents();
        menu = panel;
        panel.setVisible(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel = new javax.swing.JLabel();
        BotonGuardar = new javax.swing.JButton();
        CampoUsuario = new javax.swing.JTextField();
        BotonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.black);
        
        jLabel.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel.setForeground(new java.awt.Color(0, 0, 153));
        jLabel.setForeground(Color.lightGray);
        jLabel.setText("Por favor elija un nombre");

        BotonGuardar.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        BotonGuardar.setText("Guardar");
        BotonGuardar.setForeground(Color.white);
        BotonGuardar.setBackground(new java.awt.Color(0, 0, 153));
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        CampoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoUsuarioActionPerformed(evt);
            }
        });

        BotonVolver.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        BotonVolver.setText("Volver");
        BotonVolver.setForeground(Color.white);
        BotonVolver.setBackground(new java.awt.Color(0, 0, 153));
        BotonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BotonGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CampoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(BotonVolver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel)
                .addGap(18, 18, 18)
                .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String usuario = CampoUsuario.getText();
        this.menuPrincipal = new MenuPrincipal(this,usuario);
        this.menuPrincipal.setBounds(500,250,450,250);
        this.menuPrincipal.setVisible(true);
    }                                            

    private void CampoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
    }                                            

    private void BotonVolverActionPerformed(java.awt.event.ActionEvent evt) {                                            
        menu.setVisible(true);
        this.dispose();
    }                                           


    // Variables declaration - do not modify
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonVolver;
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JLabel jLabel;
    // End of variables declaration
}
