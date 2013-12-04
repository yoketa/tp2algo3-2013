package panel;

import javax.swing.*;

import modelo.juego.Ranking;
import modelo.vehiculo.Vehiculo;
import persistencia.Archivador;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MenuEleccionUsuario extends javax.swing.JFrame {

    private PanelInicial menu;
    private MenuPrincipal menuPrincipal;
    private String usuario;
	private List<Vehiculo> usuariosGuardados;
	private Ranking ranking;
    
    public MenuEleccionUsuario() {
        initComponents();
    }

    public MenuEleccionUsuario(PanelInicial panel) {
        this.setTitle("Gps Challenge");
        initComponents();
        menu = panel;
        panel.setVisible(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        //Agrego los usuarios
        this.agregarUsuarios();
    }
    
    private void agregarUsuarios() {

        this.usuariosGuardados = new ArrayList();
		this.ranking = Archivador.cargar(new Ranking(), "c:\\Level\\Ranking.xml");
        this.usuariosGuardados = this.ranking.getPuntajes();
        
        String user;
        
        for( int i=0; i<this.usuariosGuardados.size() ; i++ ){
            user = this.usuariosGuardados.get(i).getPiloto();
        	usuarios.addItem(user);
        }
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();
        usuarios = new javax.swing.JComboBox();
        volver = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Elija un usuario");

        jTextField1.setText("jTextField1");

        aceptar.setFont(new java.awt.Font("Consolas", 0, 18));
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });

        volver.setFont(new java.awt.Font("Consolas", 0, 12));
        volver.setText("Volver a menu anterior");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(volver)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int num = usuarios.getSelectedIndex();
        this.usuario = (String) usuarios.getSelectedItem();
        menuPrincipal = new MenuPrincipal(this,this.usuario);
        menuPrincipal.setBounds(500,250,450,250);
        menuPrincipal.setVisible(true);
    }                                       

    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {                                       
        menu.setVisible(true);
        this.dispose();
    }                                      

    // Variables declaration - do not modify
    private javax.swing.JButton aceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox usuarios;
    private javax.swing.JButton volver;
    // End of variables declaration
}
