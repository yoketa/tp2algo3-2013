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

import persistencia.Archivador;
import controladores.Nivel;
import vistas.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Juego;
import modelo.juego.Meta;
import modelo.juego.Vector;
import modelo.juego.Cuadra;
import modelo.obstaculo.*;
import modelo.sorpresas.*;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import modelo.vehiculo.*;
public class PanelDelJuego {
    
    private String usuario;
    private String dificultad;
    private MenuPartidaNueva menuPartidaNueva;
	public JFrame frame;
	private GameLoop gameLoop;
	public Juego modelo;
	private String vehiculo;
	
    public PanelDelJuego(MenuPartidaNueva menuPartida, String dificultad, String usuario,String vehiculo) {
        
    	this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.menuPartidaNueva = menuPartida;
        Nivel nivel = new Nivel();
        nivel.setDificultad(dificultad);
        this.modelo = new Juego(usuario, nivel, getVehiculoDesdeString(vehiculo));
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
		
		// Tamaño de toda la pantalla
		frame.setBounds(0, 0, 1450, 1300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Hola "+this.usuario+"         Partida "+this.dificultad);
		
		JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnGuardar = this.addBtnGuardar();

		//TODO: Tamaño del panel según la dificultad
		JPanel panel = this.addSuperficiePanel();
		
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
		VistaDeVehiculo vista = new VistaDeVehiculo(modelo.getVehiculo());

		this.gameLoop.agregar(modelo.getVehiculo());
		this.gameLoop.agregar(vista);
		
		// Agrega la meta en el límite izquierdo
		Meta meta = this.modelo.getMeta();
		VistaDeMeta vistaMeta = new VistaDeMeta(meta);
		
		this.gameLoop.agregar(meta);
		this.gameLoop.agregar(vistaMeta);
		
		Piquete piquete = new Piquete();
		piquete.setPosicion(new Vector(70, 70));
		VistaDeObstaculo vistaPiquete = new VistaDeObstaculo(piquete);
		
		this.gameLoop.agregar(piquete);
		this.gameLoop.agregar(vistaPiquete);
		
		Pozo pozo = new Pozo();
		pozo.setPosicion(new Vector(140, 70));
		VistaDeObstaculo vistaPozo = new VistaDeObstaculo(pozo);
		
		this.gameLoop.agregar(pozo);
		this.gameLoop.agregar(vistaPozo);
		
		ControlPolicial control = new ControlPolicial();
		control.setPosicion(new Vector(140, 140));
		VistaDeObstaculo vistaControl = new VistaDeObstaculo(control);
		
		this.gameLoop.agregar(control);
		this.gameLoop.agregar(vistaControl);

		Sorpresa sorpresa = new SorpresaFavorable();
		sorpresa.setPosicion(new Vector(140, 210));
		VistaDeSorpresa vistaSorpresa = new VistaDeSorpresa(sorpresa);
		
		this.gameLoop.agregar(sorpresa);
		this.gameLoop.agregar(vistaSorpresa);
		/*Nivel nivel = new Nivel ();
		nivel = Archivador.cargar(new Nivel(), Nivel.GetNivelPath(this.dificultad));
		nivel.setDificultad(this.dificultad);
		
		// TODO: Agregar Vistas y modelos de Sorpresas y Obstáculos
		modelo.agregarSorpresas(nivel.getSorpresas());
		modelo.agregarObstaculos(nivel.getObstaculos());
		*/
		
		int ultimaCuadraX = Nivel.tamañoCalle;
		int ultimaCuadraY = Nivel.tamañoCalle;
		
		for (int i = 0; i < determinarCantidadDeCuadras(modelo); i++) {
			
			/* 	Las cuadras miden 40x40 px. Debe quedar un espacio
			 * 	de 40px entre ellas para que pueda pasar el vehículo.
			 * 	El listener de las flechas del teclado luego se encarga
			 * 	de mover el vehículo la cantidad de pixeles necesarios
			 * 	para que quede siempre en una esquina (40 + 20 px)
			*/
			modelo.vehiculo.Cuadra cuadra = new modelo.vehiculo.Cuadra (ultimaCuadraX, ultimaCuadraY);
			VistaDeCuadra vistaCuadra = new VistaDeCuadra(cuadra);
			
			ultimaCuadraX += Nivel.tamañoCuadraCalle;
			
			// Se llega al límite de X -> se va a la fila que sigue
			if (ultimaCuadraX > modelo.getLimiteHorizontal() - Nivel.tamañoCuadraCalle) {
				ultimaCuadraX = Nivel.tamañoCalle;
				ultimaCuadraY += Nivel.tamañoCuadraCalle;
			}			

			this.gameLoop.agregar(cuadra);
			this.gameLoop.agregar(vistaCuadra);
		}
		
	}

	/* Setea los botones del Frame
	 * 
	 * */
	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
	}

	//Chequea si llego a la meta
	public void llegoAMeta(){
		int movimientosHechos = modelo.getVehiculo().getMovimientos();
		double puntajeLogrado = modelo.getVehiculo().getPuntaje();
		if( this.modelo.llegoALaMeta() ){
	        PanelGanador panelGanador= new PanelGanador(this.dificultad,this.usuario,movimientosHechos,puntajeLogrado);
	        panelGanador.setBounds(400,50,700,600);
	        
	        panelGanador.setVisible(true);
	        
		}
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
				
				/* TODO: Aquí creo que debe verse si al mover el vehículo
				*		 para donde se quiere se choca con un evento y ver
				*		 como aplicarlo según sea el caso
				*/
				
				// Dependiendo del código de la tecla
				// La cantidad a mover es 40 (tamaño de cuadra) + 30
				// (para ponerse en el medio de la calle) pixeles
				int posicionActual = 0;
			    switch( keyCode ) { 
			        case KeyEvent.VK_UP: // ARRIBA
			        	posicionActual = modelo.getVehiculo().getY();
			        	int a = modelo.getVehiculo().getX();
			        	if (posicionActual - Nivel.tamañoCuadra > 0) {
				        	modelo.getVehiculo().subir();
				        	modelo.aplicarEvento();			        		
			        	}
			        	llegoAMeta();
			            break;
			        case KeyEvent.VK_DOWN: // ABAJO
			        	posicionActual = modelo.getVehiculo().getY();
			        	if (posicionActual + Nivel.tamañoCuadra < modelo.getLimiteVertical()) {
			        		modelo.getVehiculo().bajar();
				        	modelo.aplicarEvento();	
			        	}			        	
			        	llegoAMeta();
			            break;
			        case KeyEvent.VK_LEFT: // IZQUIERDA
			        	posicionActual = modelo.getVehiculo().getX();
			        	if (posicionActual - Nivel.tamañoCuadra > 0) {
			        		modelo.getVehiculo().izquierda();
				        	modelo.aplicarEvento();
			        	}			        	
			        	llegoAMeta();
			            break;
			        case KeyEvent.VK_RIGHT : // DERECHA
			        	posicionActual = modelo.getVehiculo().getX();
			        	if (posicionActual + Nivel.tamañoCuadra < modelo.getLimiteHorizontal()) {
			        		modelo.getVehiculo().derecha();
				        	modelo.aplicarEvento();	
			        	}			        	
			        	llegoAMeta();
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
		// TODO: Tamaño según la dificultad del juego
		
		panel.setBounds(40, 40, this.modelo.getLimiteHorizontal(), this.modelo.getLimiteVertical());
		frame.getContentPane().add(panel);
		return panel;
	}

	// TODO: Funcionalidad del botón de guardar partida
	/* Crea el botón de Guardar Partida
	 * 
	 * */
	private JButton addBtnGuardar() {
		JButton btnDetener = new JButton("Guardar");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(325, 10, 92, 19);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}

	// TODO: Ver si el botón es redundante y no se debería sacar
	/* Crea el botón de Inicio
	 * 
	 * */
	private JButton addBotonIniciar() {
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		btnIniciar.setBounds(42, 10, 77, 19);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
	
	/* Determina la cantidad de cuadras a renderear dependiendo el 
	 * nivel del juego
	 * 
	 * */
	private int determinarCantidadDeCuadras(Juego juego) {
		int cuadrasHorizontales = (juego.getLimiteHorizontal() - Nivel.tamañoCalle) / Nivel.tamañoCuadraCalle;
		
		// Se determina que son siempre 6 cuadras de alto
		return cuadrasHorizontales * 6;
	}
	
	/* Devuelve un objeto de tipo EstadoVehiculo según el tipo de 
	 * vehículo que se haya elegido
	 * 
	 * */
	private EstadoVehiculo getVehiculoDesdeString(String tipoVehiculo) {
		switch (tipoVehiculo) {
		case "Auto":
			return new Auto();
		case "Moto":
			return new Moto();
		case "4x4":
			return new CuatroXCuatro(); 
		}
		return new Auto();
	}
}
