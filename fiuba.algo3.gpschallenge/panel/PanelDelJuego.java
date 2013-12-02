package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vistas.VistaDeCuadra;
import vistas.VistaDeMeta;
import vistas.VistaDeVehiculo;
import modelo.juego.Juego;
import modelo.juego.Meta;
import modelo.juego.Vector;
import modelo.vehiculo.Cuadra;
import modelo.vehiculo.Vehiculo;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class PanelDelJuego {
    
    private String usuario;
    private String dificultad;
    private MenuPartidaNueva menuPartidaNueva;
	public JFrame frame;
	private GameLoop gameLoop;
	private Juego modelo;

    public PanelDelJuego(MenuPartidaNueva menuPartida, String dificultad, String usuario) {
        
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.menuPartidaNueva = menuPartida;
        try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        menuPartida.setVisible(false);
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }
    
    /**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		
		// TODO: Tama�o seg�n dificultad
		frame.setBounds(100, 100, 1450, 1300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Hola "+this.usuario+"         Partida "+this.dificultad);
		
		JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnGuardar = this.addBtnGuardar();
		
		//TODO: Tama�o del panel seg�n la dificultad
		JPanel panel = this.addSuperficiePanel();
		
		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\27176876544\\Downloads\\cuadra.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		panel.add(picLabel);
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		
		this.inicializarModelo();
		
		this.addMouseListener(panel);
		
		this.addKeyListener();

		this.setComponentsFocus(btnIniciar, btnGuardar);

	}
	
	/* Inicializa el modelo y la vista a controlar por Titiritero
	 * 
	 * */
	private void inicializarModelo() throws IOException {
		Juego modelo = new Juego(this.usuario);
		VistaDeVehiculo vista = new VistaDeVehiculo(modelo.getVehiculo());
		this.modelo = modelo;
		
		this.gameLoop.agregar(modelo.getVehiculo());
		this.gameLoop.agregar(vista);
		
		int ultimaCuadraX = 30;
		int ultimaCuadraY = 30;
		for (int i = 0; i < 100; i++) {
			
			/* 	Las cuadras miden 40x40 px. Debe quedar un espacio
			 * 	de 40px entre ellas para que pueda pasar el veh�culo.
			 * 	El listener de las flechas del teclado luego se encarga
			 * 	de mover el veh�culo la cantidad de pixeles necesarios
			 * 	para que quede siempre en una esquina (40 + 20 px)
			*/
			Cuadra cuadra = new Cuadra (ultimaCuadraX, ultimaCuadraY);
			VistaDeCuadra vistaCuadra = new VistaDeCuadra(cuadra);
			
			ultimaCuadraX += 70;
			
			// Se llega al l�mite de X -> se va a la fila que sigue
			if (ultimaCuadraX > 730) {
				ultimaCuadraX = 30;
				ultimaCuadraY += 70;
			}			

			this.gameLoop.agregar(cuadra);
			this.gameLoop.agregar(vistaCuadra);
		}
		
		// Agrega la meta en el l�mite izquierdo
		Meta meta = this.modelo.getMeta();
		meta.setX(700);
		meta.setY(360);
		VistaDeMeta vistaMeta = new VistaDeMeta(meta);
		
		this.gameLoop.agregar(meta);
		this.gameLoop.agregar(vistaMeta);
		
	}

	/* Setea los botones del Frame
	 * 
	 * */
	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
	}

	/* Captura que se haya apretado una tecla
	 * */
	private void addKeyListener() {
		frame.addKeyListener(new KeyListener(
				) {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println("Key pressed");
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			/* Captura que se haya apretado una de las teclas de flechas
			 * */
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				/* TODO: Aqu� creo que debe verse si al mover el veh�culo
				*		 para donde se quiere se choca con un evento y ver
				*		 como aplicarlo seg�n sea el caso
				*/
				
				// Dependiendo del c�digo de la tecla
				// La cantidad a mover es 40 (tama�o de cuadra) + 30
				// (para ponerse en el medio de la calle) pixeles
			    switch( keyCode ) { 
			        case KeyEvent.VK_UP: // ARRIBA
			            modelo.getVehiculo().mover(new Vector(0, -70));
			            break;
			        case KeyEvent.VK_DOWN: // ABAJO
			            modelo.getVehiculo().mover(new Vector(0, 70));
			            break;
			        case KeyEvent.VK_LEFT: // IZQUIERDA
			            modelo.getVehiculo().mover(new Vector(-70, 0));
			            break;
			        case KeyEvent.VK_RIGHT : // DERECHA
			            modelo.getVehiculo().mover(new Vector(70, 0));
			            break;
			     }
			}  
			 	
		});
	}

	/*
	 * Captura los clicks del mouse sobre el panel (no se usa)
	 * */
	private void addMouseListener(JPanel panel) {
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MouseEvent a = arg0;
				int b = a.getXOnScreen();
				int c = a.getYOnScreen();
			}});
	}

	/* Crea el Panel de la pantalla con el mapa
	 * 
	 * */
	private JPanel addSuperficiePanel() throws IOException {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(Color.WHITE);
		// TODO: Tama�o seg�n la dificultad del juego
		
		// Ejemplo con 10 X 10 cuadras
		panel.setBounds(40, 40, 730, 730);
		frame.getContentPane().add(panel);
		return panel;
	}

	// TODO: Funcionalidad del bot�n de guardar partida
	/* Crea el bot�n de Guardar Partida
	 * 
	 * */
	private JButton addBtnGuardar() {
		JButton btnDetener = new JButton("Guardar");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(325, 16, 92, 25);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}

	// TODO: Ver si el bot�n es redundante y no se deber�a sacar
	/* Crea el bot�n de Inicio
	 * 
	 * */
	private JButton addBotonIniciar() {
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		btnIniciar.setBounds(42, 16, 77, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
	
}
