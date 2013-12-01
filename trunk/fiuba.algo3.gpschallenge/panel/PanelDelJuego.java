package panel;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelDelJuego extends javax.swing.JFrame {
    
    private String usuario;
    private String dificultad;
    private MenuPartidaNueva menuPartidaNueva;

    /** Creates new form PanelDelJuego */
    public PanelDelJuego() {
        initComponents();
    }

    PanelDelJuego(MenuPartidaNueva menuPartida, String dificultad, String usuario) {
        
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.setTitle("Hola "+this.usuario+"         Partida"+this.dificultad);
        initComponents();
        this.menuPartidaNueva = menuPartida;
        menuPartida.setVisible(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
//        
//        //Imagen del mapa
//        JLabel img = new JLabel(" dfds"); 
//
//        Image image = new Image("C:\\Users\\Ramon\\Documents\\NetBeansProjects\\Gps\\src\\imagenes\\mapa_prueba.png"); 
//        this.add(img); // "dibujar" es mi panel ok... 
//        //Propiedades de la etiqueta
//        img.setIcon(image); 
//        img.setSize(100,100); 
//        img.setLocation(500,250); 
//        img.setVisible(true); 
//        panel.setBackground(Color.red);
//        panel.imageUpdate(image, 100, 500, 250, 100, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        panel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.JDesktopPane panel;
    // End of variables declaration
}
