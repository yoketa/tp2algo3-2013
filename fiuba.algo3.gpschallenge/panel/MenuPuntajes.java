package panel;

public class MenuPuntajes extends javax.swing.JFrame {
    
    private MenuPrincipal menuPrincipal;

    public MenuPuntajes() {
        initComponents();
    }
    
    public MenuPuntajes(MenuPrincipal principal, String user) {
        this.setTitle("Hola "+user+"         Gps Challenge");
        initComponents();
        this.menuPrincipal = principal;
        principal.setVisible(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 204));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("Mejores Puntajes");

        volver.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(volver)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>                        

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {                                       
        menuPrincipal.setVisible(true);
        this.dispose();
    }                                      

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton volver;
    // End of variables declaration                   
}
