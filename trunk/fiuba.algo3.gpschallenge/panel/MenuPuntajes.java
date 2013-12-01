package panel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import modelo.juego.Ranking;
import modelo.vehiculo.Vehiculo;

public class MenuPuntajes extends javax.swing.JFrame {
    
    private MenuPrincipal menuPrincipal;
    private Ranking ranking;
    private List<Vehiculo> puntajes;

    public MenuPuntajes() {
        initComponents();
    }
    
    public MenuPuntajes(MenuPrincipal principal, String user) {
        this.setTitle("Hola "+user+"         Gps Challenge");
        initComponents();
        this.menuPrincipal = principal;
        principal.setVisible(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        //Ranking
        this.marcarPuntajes();
    }

    private void marcarPuntajes() {
    	
        //this.ranking = new Ranking();
        //this.puntajes = new ArrayList();
        //this.puntajes = ranking.getPuntajes();
        
        //String puntaje = Double.toString(puntajes.get(0).getPuntaje());
        //String usuario = puntajes.get(0).getPiloto();
    	int num = 50;
    	
		JLabel etiquetaOrdenInicial = new JLabel("N°:");
        JLabel etiquetaUsuarioInicial = new JLabel("Usuario:");
        JLabel etiquetaPuntajeInicial = new JLabel("Puntaje:");

        etiquetaOrdenInicial.setBounds(50, num, 50, 50);
        etiquetaUsuarioInicial.setBounds(125, num, 50, 50);
        etiquetaPuntajeInicial.setBounds(250, num, 50, 50);
        add(etiquetaOrdenInicial);
        add(etiquetaUsuarioInicial);
        add(etiquetaPuntajeInicial);
        
        num+=15;
        int orden = 1;
        String user = "pepe";
        
    	for(int i=0; i<10;i++){
   
    		JLabel etiquetaOrden = new JLabel(Integer.toString(orden));
            JLabel etiquetaUsuario = new JLabel(user);
            JLabel etiquetaPuntaje = new JLabel(Integer.toString(i));

            etiquetaOrden.setBounds(50, num, 50, 50);
            etiquetaUsuario.setBounds(125, num, 50, 50);
            etiquetaPuntaje.setBounds(250, num, 50, 50);
            add(etiquetaOrden);
            add(etiquetaUsuario);
            add(etiquetaPuntaje);
            num+=15;
            orden++;
    	}
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
