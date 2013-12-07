package panel;

import javax.swing.*;

import modelo.juego.Ranking;
import modelo.vehiculo.Vehiculo;
import persistencia.Archivador;

import java.awt.Color;
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

        this.usuariosGuardados = new ArrayList<Vehiculo>();
		this.ranking = Archivador.cargar(new Ranking(), "persistencia/Ranking.xml");
        List<Vehiculo> usuariosRankeados = new ArrayList<Vehiculo>();
        usuariosRankeados = this.ranking.getPuntajes();
        
        //Filtra los usuarios que han jugado mas de una ves dejando solo su usuario una vez. 
        this.filtroDeUsuarios(usuariosRankeados);

        if (this.usuariosGuardados.size() != 0){
            String user;
            
            for( int i=0; i<this.usuariosGuardados.size() ; i++ ){
                user = this.usuariosGuardados.get(i).getPiloto();
                
            	grupoDeUsuarios.addItem(user);
            }
        } else {
            botonAceptar.setEnabled(false);
        }
	}

	private void filtroDeUsuarios(List<Vehiculo> usuarios) {
        
		this.usuariosGuardados.add(usuarios.get(0));
		usuarios.remove(0);
		
		for (Vehiculo vehiculo : usuarios){
			
			boolean usuarioExistente = false;
			
			for ( Vehiculo vehiculoGuardado : this.usuariosGuardados){
				System.out.println("Vehiculoguardado: "+vehiculoGuardado.getPiloto()+"  vehiculoSacado: "+vehiculo.getPiloto());
				
				if ((vehiculo.getPiloto() == vehiculoGuardado.getPiloto()) ){
					System.out.println("Hola");
					usuarioExistente = true;
				}
			}
			if(!usuarioExistente){
				this.usuariosGuardados.add(vehiculo);
				
			}
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
        botonAceptar = new javax.swing.JButton();
        grupoDeUsuarios = new javax.swing.JComboBox();
        botonVolver = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.black);
        
        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Elija un usuario");

        jTextField1.setText("jTextField1");

        botonAceptar.setFont(new java.awt.Font("Consolas", 0, 18));
        botonAceptar.setText("Aceptar");
        botonAceptar.setForeground(Color.white);
        botonAceptar.setBackground(new java.awt.Color(0, 0, 153));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        grupoDeUsuarios.setForeground(Color.white);
        grupoDeUsuarios.setBackground(new java.awt.Color(0, 0, 153));
        grupoDeUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });

        botonVolver.setFont(new java.awt.Font("Consolas", 0, 12));
        botonVolver.setText("Volver a menu anterior");
        botonVolver.setForeground(Color.white);
        botonVolver.setBackground(new java.awt.Color(0, 0, 153));
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
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
                            .addComponent(grupoDeUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(botonVolver)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(grupoDeUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int num = grupoDeUsuarios.getSelectedIndex();
        this.usuario = (String) grupoDeUsuarios.getSelectedItem();
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
    private javax.swing.JButton botonAceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox grupoDeUsuarios;
    private javax.swing.JButton botonVolver;
    // End of variables declaration
}
