package panel;

public class PanelPerdedor extends javax.swing.JFrame {
    
    private String usuario;
    private String dificultad;
    private MenuPrincipal menuPrincipal;

    /** Creates new form PanelPerdiste */
    public PanelPerdedor() {
        initComponents();
    }

    public PanelPerdedor(String dificultad, String usuario) {
        
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.setTitle("Hola "+this.usuario+"                         Partida"+this.dificultad);
        
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonJugarDeNuevo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("¡¡ Perdiste !!");

        botonJugarDeNuevo.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        botonJugarDeNuevo.setText("Jugar de nuevo");
        botonJugarDeNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarDeNuevoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("La Proxima sera...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonJugarDeNuevo)
                    .addComponent(jLabel2))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(botonJugarDeNuevo)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>

    private void botonJugarDeNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        this.menuPrincipal = new MenuPrincipal(this,this.usuario);
        this.menuPrincipal.setBounds(500,250,450,250);
        this.menuPrincipal.setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton botonJugarDeNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration
}