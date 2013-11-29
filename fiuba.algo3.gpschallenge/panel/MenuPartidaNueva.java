package panel;

import javax.swing.event.ChangeEvent;

public class MenuPartidaNueva extends javax.swing.JFrame {
    
    private MenuPrincipal menuPrincipal;

    public MenuPartidaNueva() {
        initComponents();
    }

    MenuPartidaNueva(MenuPrincipal principal,String user) {
        this.setTitle("Hola "+user+"         Gps Challenge");
        initComponents();
        this.menuPrincipal = principal;
        principal.setVisible(false);
        jugar.setEnabled(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }

    public void stateChanged() {
        boolean facil = botonFacil.isSelected();
        boolean moderado = botonModerado.isSelected();
        boolean dificil = botonDificil.isSelected();
        boolean moto = botonMoto.isSelected();
        boolean auto = botonAuto.isSelected();
        boolean cuatroXCuatro = boton4x4.isSelected(); 
        
        if ((facil == true || moderado == true || dificil == true)&&
                (auto == true || moto == true || cuatroXCuatro == true ) ){
            jugar.setEnabled(true);
        }else{
            jugar.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        botonModerado = new javax.swing.JRadioButton();
        botonDificil = new javax.swing.JRadioButton();
        botonMoto = new javax.swing.JRadioButton();
        boton4x4 = new javax.swing.JRadioButton();
        botonAuto = new javax.swing.JRadioButton();
        botonFacil = new javax.swing.JRadioButton();
        volver = new javax.swing.JButton();
        jugar = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonModerado.setText("Moderado");
        botonModerado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModeradoActionPerformed(evt);
            }
        });

        botonDificil.setText("Dificil");
        botonDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDificilActionPerformed(evt);
            }
        });

        botonMoto.setText("Moto");
        botonMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMotoActionPerformed(evt);
            }
        });

        boton4x4.setText("4x4");
        boton4x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4x4ActionPerformed(evt);
            }
        });

        botonAuto.setText("Auto");
        botonAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAutoActionPerformed(evt);
            }
        });

        botonFacil.setText("Facil");
        botonFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFacilActionPerformed(evt);
            }
        });

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        jugar.setText("Jugar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonFacil)
                    .addComponent(botonModerado)
                    .addComponent(botonDificil))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonMoto)
                    .addComponent(botonAuto)
                    .addComponent(boton4x4))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(jugar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonFacil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonModerado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonDificil))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonMoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAuto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton4x4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volver)
                    .addComponent(jugar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {                                       
        menuPrincipal.setVisible(true);
        this.dispose();
    }                                      

    private void botonFacilActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.stateChanged();
        botonModerado.setSelected(false);
        botonDificil.setSelected(false);
    }                                          

    private void botonModeradoActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.stateChanged();
        botonFacil.setSelected(false);
        botonDificil.setSelected(false);
    }                                             

    private void botonDificilActionPerformed(java.awt.event.ActionEvent evt) {                                             
        this.stateChanged();
        botonModerado.setSelected(false);
        botonFacil.setSelected(false);
    }                                            

    private void botonMotoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.stateChanged();
        botonAuto.setSelected(false);
        boton4x4.setSelected(false);
    }                                         

    private void botonAutoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.stateChanged();
        botonMoto.setSelected(false);
        boton4x4.setSelected(false);
    }                                         

    private void boton4x4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.stateChanged();
        botonAuto.setSelected(false);
        botonMoto.setSelected(false);
    }                                        

    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton boton4x4;
    private javax.swing.JRadioButton botonAuto;
    private javax.swing.JRadioButton botonDificil;
    private javax.swing.JRadioButton botonFacil;
    private javax.swing.JRadioButton botonModerado;
    private javax.swing.JRadioButton botonMoto;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JButton jugar;
    private javax.swing.JButton volver;
    // End of variables declaration                   
}
