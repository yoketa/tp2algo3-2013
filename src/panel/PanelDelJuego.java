package panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import persistencia.Archivador;
import vistas.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Juego;
import modelo.juego.Meta;
import modelo.juego.Nivel;
import modelo.juego.Oscurecimiento;
import modelo.juego.Partida;
import modelo.obstaculo.*;
import modelo.sorpresas.*;
import modelo.vehiculo.Auto;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import modelo.vehiculo.*;
public class PanelDelJuego {
    
    private String usuario;
    private String dificultad;
	public JFrame frame;
	private GameLoop gameLoop;
	public Juego modelo;
	private List<Sorpresa> sorpresas;
	private List<Obstaculo> obstaculos;
	private int movimientosRestantes;
	private JLabel etiquetaMovimientos;
	private VistaDeVehiculo vista;
	private Oscurecimiento oscurecimiento;
	private Partida partidaCargada;
	private boolean eligioPartidaNueva;
	
	
	//Constructor para juego nuevo
    public PanelDelJuego(MenuPartidaNueva menuPartida, String dificultad, String usuario,String vehiculo) {
        
    	this.eligioPartidaNueva = true;
        this.usuario = usuario;
        this.dificultad = dificultad;
        Nivel nivel = new Nivel();
        nivel.setDificultad(dificultad);
        this.modelo = new Juego(usuario, nivel, getVehiculoDesdeString(vehiculo));
        this.modelo.setDificultadDeNivel(dificultad);
        try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
        menuPartida.setVisible(false);
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }
    
    //Constructor para juego ya empezado
    public PanelDelJuego(MenuPrincipal menuPrincipal, String usuario) {
    	
		this.eligioPartidaNueva = false;      
        this.usuario = usuario;

		Nivel nivel = new Nivel();
        nivel.setDificultad("Facil");

        this.modelo = new Juego(usuario, nivel, getVehiculoDesdeString(this.usuario));
        
        try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
        menuPrincipal.setVisible(false);
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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Hola "+this.usuario+"         Partida "+this.dificultad);
		
        JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnGuardar = this.addBtnGuardar();

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

		visualizarOscurecimiento();
		visualizarVehiculo();
		visualizarMeta();
		
		if(this.eligioPartidaNueva)	visualizarEventosDePartidaNueva();
				else visualizarEventosDePartidaGuardada();
		
		etiquetaMovimientos.setBounds(550, 10, 300, 19);
	    etiquetaMovimientos.setFont(new java.awt.Font("Gabriola", 1, 18));
        etiquetaMovimientos.setForeground(new java.awt.Color(0, 0, 102));
        etiquetaMovimientos.setVisible(true);
        this.frame.getContentPane().add(etiquetaMovimientos);
			
		visualizarCuadras();
		
	}

	private void visualizarOscurecimiento() throws IOException {
		
		Oscurecimiento oscurecimiento = new Oscurecimiento();
		oscurecimiento.setX(this.modelo.getVehiculo().getX());
		oscurecimiento.setY(this.modelo.getVehiculo().getY());
		VistaDeOscurecimiento vistaOscurecimiento = new VistaDeOscurecimiento(oscurecimiento);
		this.oscurecimiento = oscurecimiento;
		
		this.gameLoop.agregar(oscurecimiento);
		this.gameLoop.agregar(vistaOscurecimiento);		
	}
	
	private void visualizarVehiculo() throws IOException {
		
		vista = new VistaDeVehiculo(modelo.getVehiculo());

		this.gameLoop.agregar(modelo.getVehiculo());
		this.gameLoop.agregar(vista);		
	}
	
	private void visualizarMeta() {
		
		// Agrega la meta en el límite izquierdo
		Meta meta = this.modelo.getMeta();
		VistaDeMeta vistaMeta = new VistaDeMeta(meta);
		
		this.gameLoop.agregar(meta);
		this.gameLoop.agregar(vistaMeta);
		
	}
	
	private void visualizarEventosDePartidaNueva() throws IOException {
		Nivel nivel = new Nivel();
		nivel = modelo.getNivel();
		nivel = Archivador.cargar(new Nivel(), Nivel.GetNivelPath(this.dificultad));
		
		obstaculos = nivel.getObstaculos();
		for(Obstaculo obstaculo : this.obstaculos ) {
			VistaDeObstaculo vistaObstaculo = new VistaDeObstaculo(obstaculo);
			modelo.agregarEvento(obstaculo);		
			this.gameLoop.agregar(obstaculo);
			this.gameLoop.agregar(vistaObstaculo);
		}

		sorpresas = nivel.getSorpresas();
		for(Sorpresa sorpresa : this.sorpresas ) {
			VistaDeSorpresa vistaDeSorpresa = new VistaDeSorpresa(sorpresa);
			modelo.agregarEvento(sorpresa);		
			this.gameLoop.agregar(sorpresa);
			this.gameLoop.agregar(vistaDeSorpresa);
		}
		
		//contador de movimientos disponibles
		this.movimientosRestantes = modelo.movimientosLimites(dificultad);
		etiquetaMovimientos = new JLabel("Movimientos restantes: " + String.valueOf(movimientosRestantes));
		
	}
	
	private void visualizarEventosDePartidaGuardada() throws IOException {
		Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPiloto(this.usuario);
        
        //Aca va cargadesde partida.xml
		Partida partida = new Partida(vehiculo);
		this.partidaCargada = Archivador.cargar(partida,partida.getPath());
		
		obstaculos = this.partidaCargada.getObstaculos();
		for(Obstaculo obstaculo : this.obstaculos ) {
			VistaDeObstaculo vistaObstaculo = new VistaDeObstaculo(obstaculo);
			modelo.agregarEvento(obstaculo);		
			this.gameLoop.agregar(obstaculo);
			this.gameLoop.agregar(vistaObstaculo);
		}

		sorpresas = this.partidaCargada.getSorpresas();
		for(Sorpresa sorpresa : this.sorpresas ) {
			VistaDeSorpresa vistaDrpresa = new VistaDeSorpresa(sorpresa);
			modelo.agregarEvento(sorpresa);		
			this.gameLoop.agregar(sorpresa);
			this.gameLoop.agregar(vistaDrpresa);
		}
		
		//contador de movimientos disponibles
		int movimientosHechos = this.partidaCargada.getVehiculo().getMovimientos();
		
		this.dificultad = this.partidaCargada.getDificultad();
		this.movimientosRestantes = modelo.movimientosLimites(this.dificultad) - movimientosHechos;
		etiquetaMovimientos = new JLabel("Movimientos restantes: " + String.valueOf(movimientosRestantes));
	}
	
	private void visualizarCuadras() throws IOException {
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
	public void llegoAMeta() throws Exception{
		
		if( this.modelo.llegoALaMeta() ){
	        PanelGanador panelGanador= new PanelGanador(this.dificultad,this.usuario,modelo);
	        panelGanador.setBounds(400,50,panelGanador.getWidth(),panelGanador.getHeight());
	        panelGanador.setVisible(true);
	        
	        
		}
	}
	
	//Chequea si ya agoto los movimientos permitidos
	private void chequeoDeMovimientosValidos() {

		int movimientos = modelo.movimientosLimites(this.dificultad) - modelo.getVehiculo().getMovimientos();
		
		if(movimientos <= 0){
	        PanelPerdedor panelPerdedor= new PanelPerdedor(this.dificultad,this.usuario);
	        panelPerdedor.setBounds(400,50,panelPerdedor.getWidth(),panelPerdedor.getHeight());
	        panelPerdedor.setVisible(true);
		}

	} 
	
	//Chequea todo cambio en la vista, si llego a la meta, si posee movimientos restante
	private void actualizar() throws IOException {
		try {
			llegoAMeta();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		finally {
			etiquetaMovimientos.setText("Movimientos restantes: " + String.valueOf(movimientosRestantes - modelo.getVehiculo().getMovimientos()));
			chequeoDeMovimientosValidos();
			
			cambioDeVista();
		}		
	}
	
	private void cambioDeVista() throws IOException{

		this.gameLoop.remover(vista);
		vista = new VistaDeVehiculo(modelo.getVehiculo());
		this.gameLoop.agregar(modelo.getVehiculo());
		this.gameLoop.agregar(vista);
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
								
				// Dependiendo del código de la tecla
				// La cantidad a mover es 40 (tamaño de cuadra) + 30
				// (para ponerse en el medio de la calle) pixeles
	    		int posicionActual = 0;
			    switch( keyCode ) { 
			        case KeyEvent.VK_UP: // ARRIBA
				        	posicionActual = modelo.getVehiculo().getX();
				        	if (posicionActual + Nivel.tamañoCuadra < modelo.getLimiteHorizontal()) {
				        		modelo.getVehiculo().subir();
				            	modelo.aplicarEvento();
				        	}
							try {
								actualizar();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
				            break;
			        case KeyEvent.VK_DOWN: // ABAJO
				        	posicionActual = modelo.getVehiculo().getX();
				        	if (posicionActual + Nivel.tamañoCuadra < modelo.getLimiteHorizontal()) {
				        		modelo.getVehiculo().bajar();
				            	modelo.aplicarEvento();
				        	}
							try {
								actualizar();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
				            break;
			        case KeyEvent.VK_LEFT: // IZQUIERDA
			        	posicionActual = modelo.getVehiculo().getX();
			        	if (posicionActual + Nivel.tamañoCuadra < modelo.getLimiteHorizontal()) {
			        		modelo.getVehiculo().izquierda();
			            	modelo.aplicarEvento();
			        	}
			        		try {
								actualizar();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
			        		break;
			        case KeyEvent.VK_RIGHT : // DERECHA
				        	posicionActual = modelo.getVehiculo().getX();
				        	if (posicionActual + Nivel.tamañoCuadra < modelo.getLimiteHorizontal()) {
				        		modelo.getVehiculo().derecha();
				            	modelo.aplicarEvento();
				        	}
							try {
								actualizar();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
			        		break;
			     }
			    
			    // Actualiza la posición del oscurecimiento
			    oscurecimiento.setX(modelo.getVehiculo().getX());
			    oscurecimiento.setY(modelo.getVehiculo().getY());
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
			}});
	}

	/* Crea el Panel de la pantalla con el mapa
	 * 
	 * */
	private JPanel addSuperficiePanel() throws IOException {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(Color.WHITE);
		
		panel.setBounds(40, 40, this.modelo.getLimiteHorizontal(), this.modelo.getLimiteVertical());
		frame.getContentPane().add(panel);
		return panel;
	}

	/* Crea el botón de Guardar Partida
	 * 
	 * */
	private JButton addBtnGuardar() {
		JButton btnDetener = new JButton("Guardar");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
				gameLoop.detenerEjecucion();
			}

			
		});
		btnDetener.setBounds(325, 10, 92, 19);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}

	private void guardar() {
		Nivel nivel = modelo.getNivel();
		nivel = Archivador.cargar(new Nivel(), Nivel.GetNivelPath(this.dificultad));
		modelo.getPartida().setDificultad(this.dificultad);
		modelo.getPartida().agregarObstaculos(nivel.getObstaculos());
		modelo.getPartida().agregarSorpresas(nivel.getSorpresas());
		Archivador.guardar(modelo.getPartida(),modelo.getPartida().getPath());

	}
	
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
		btnIniciar.setBounds(42, 10, 92, 19);
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
