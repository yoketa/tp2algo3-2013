package panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import persistencia.Archivador;
import vistas.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Juego;
import modelo.juego.Meta;
import modelo.juego.Nivel;
import modelo.juego.Oscurecimiento;
import modelo.juego.Partida;
import modelo.juego.Ranking;
import modelo.obstaculo.*;
import modelo.sorpresas.*;
import modelo.vehiculo.Auto;
import excepciones.MovimientoFueraDeMapaException;
import excepciones.OcupacionCoincidenteConOtroObjetoException;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import modelo.vehiculo.*;

public class PanelDelJuego {

	public Juego modelo;
	public JFrame frame;    
	private String usuario;
    private String dificultad;
	private boolean eligioPartidaNueva;
	private int movimientosRestantes;
	private double puntaje;
	private JLabel etiquetaMovimientos;
	private JLabel etiquetaPuntaje;
	private GameLoop gameLoop;
	private List<Sorpresa> sorpresas;
	private List<VistaDeSorpresa> vistaSorpresas;
	private List<Obstaculo> obstaculos;
	private VistaDeVehiculo vista;
	private Oscurecimiento oscurecimiento;
	private Partida partidaCargada;
	private Ranking ranking;
	private Nivel nivel;
	
	//Constructor para juego nuevo
    public PanelDelJuego(MenuPartidaNueva menuPartida, String dificultad, String usuario,String vehiculo) {
        
    	this.eligioPartidaNueva = true;
        this.usuario = usuario;
        this.dificultad = dificultad;
        Nivel nivel = new Nivel();
        nivel.setDificultad(dificultad);
        this.modelo = new Juego(usuario, nivel, vehiculo);
        this.modelo.setDificultadDeNivel(dificultad);
        this.vistaSorpresas = new ArrayList<VistaDeSorpresa>();
		this.nivel = Archivador.cargar(new Nivel(), Nivel.GetNivelPath(this.dificultad));
        try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
        menuPartida.setVisible(false);
    }
    
    //Constructor para juego ya empezado
    public PanelDelJuego(MenuPrincipal menuPrincipal, String usuario) {
    	
		this.eligioPartidaNueva = false;      
        this.usuario = usuario;
        
		Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPiloto(this.usuario);
        
        //Aca va cargadesde partida.xml
        Partida partida = new Partida(vehiculo);
		this.partidaCargada = Archivador.cargar(partida,partida.getPath());
		
        this.vistaSorpresas = new ArrayList<VistaDeSorpresa>();
		
		Nivel nivel = new Nivel();
        nivel.setDificultad(this.partidaCargada.getDificultad());
        this.modelo = new Juego(usuario, nivel, this.usuario);
        this.dificultad = nivel.getDificultad();
        
		this.modelo.getVehiculo().setPosicion(this.partidaCargada.getVehiculo().getPosicion());
		this.modelo.getVehiculo().setEstado(this.partidaCargada.getVehiculo().getEstado());
        
        try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
        menuPrincipal.setVisible(false);
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
		frame.getContentPane().setBackground(Color.BLUE);
		
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

		visualizarVehiculo();
		visualizarEventos();
		visualizarCuadras();
		visualizarMovimientos();
		visualizarPuntaje();
		visualizarOscurecimiento();
		visualizarMeta();
	}

	private void visualizarPuntaje() {

		modelo.carlcularPuntajeDeVehiculo();
		this.puntaje = modelo.getVehiculo().getPuntaje();
		etiquetaPuntaje = new JLabel("Puntaje actual: " + String.valueOf(this.puntaje));
		etiquetaPuntaje.setBounds(520, 10, 300, 19);
		etiquetaPuntaje.setFont(new java.awt.Font("Gabriola", 1, 24));
		etiquetaPuntaje.setForeground(Color.white);
		etiquetaPuntaje.setVisible(true);
        this.frame.getContentPane().add(etiquetaPuntaje);
	}

	private void visualizarMovimientos() {
        
		if (this.eligioPartidaNueva){
			this.movimientosRestantes = modelo.movimientosLimites(dificultad);
			
		}else{
			
			int movimientosHechos = this.partidaCargada.getVehiculo().getMovimientos();			
			this.movimientosRestantes = modelo.movimientosLimites(this.dificultad) - movimientosHechos;
		}
		etiquetaMovimientos = new JLabel("Movimientos restantes: " + String.valueOf(movimientosRestantes));
		etiquetaMovimientos.setBounds(720, 10, 300, 19);
	    etiquetaMovimientos.setFont(new java.awt.Font("Gabriola", 1, 24));
        etiquetaMovimientos.setForeground(Color.white);
        etiquetaMovimientos.setVisible(true);
        this.frame.getContentPane().add(etiquetaMovimientos);
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
	
	private void visualizarEventos() throws IOException{
		
		if(this.eligioPartidaNueva){
			obstaculos = this.nivel.getObstaculos();
			sorpresas = this.nivel.getSorpresas();
		
		} else {
			obstaculos = this.partidaCargada.getObstaculos();
			sorpresas = this.partidaCargada.getSorpresas();
	
			frame.setTitle("Hola "+this.usuario+"             Partida "+this.partidaCargada.getDificultad());
		}
		cargarEventos();
	}
	
	private void cargarEventos() throws IOException {	

		for(Obstaculo obstaculo : this.obstaculos ) {
			VistaDeObstaculo vistaObstaculo = new VistaDeObstaculo(obstaculo);
			try {
				modelo.agregarEvento(obstaculo);
			} catch (OcupacionCoincidenteConOtroObjetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			this.gameLoop.agregar(obstaculo);
			this.gameLoop.agregar(vistaObstaculo);
		}
		
		for(Sorpresa sorpresa : this.sorpresas ) {
			VistaDeSorpresa vistaDeSorpresa = new VistaDeSorpresa(sorpresa);
			this.vistaSorpresas.add (vistaDeSorpresa);
			try {
				modelo.agregarEvento(sorpresa);
			} catch (OcupacionCoincidenteConOtroObjetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			this.gameLoop.agregar(sorpresa);
			this.gameLoop.agregar(vistaDeSorpresa);
		}
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
	        this.frame.setVisible(false);
	        panelGanador.setVisible(true);
		}
	}
	
	//Chequea si ya agoto los movimientos permitidos
	private void chequeoDeMovimientosValidos() {

		int movimientos = modelo.movimientosLimites(this.dificultad) - modelo.getVehiculo().getMovimientos();
		
		if(movimientos <= 0){
	        PanelPerdedor panelPerdedor= new PanelPerdedor(this.dificultad,this.usuario);
	        panelPerdedor.setBounds(400,50,panelPerdedor.getWidth(),panelPerdedor.getHeight());
	        this.frame.setVisible(false);
	        panelPerdedor.setVisible(true);
		}
	} 
	
	
	//Chequea todo cambio en la vista, si llego a la meta, si posee movimientos restante
	private void actualizar() throws IOException {
		try {
			llegoAMeta();
		} catch (Exception e1) {
		}
		finally {
			etiquetaMovimientos.setText("Movimientos restantes: " + String.valueOf(movimientosRestantes - modelo.getVehiculo().getMovimientos()));
			chequeoDeMovimientosValidos();

			modelo.carlcularPuntajeDeVehiculo();
			this.puntaje = modelo.getVehiculo().getPuntaje();
			etiquetaPuntaje.setText("Puntaje actual: " + String.valueOf(this.puntaje));
			
			cambioDeVista();
			this.sorpresas = modelo.getListaDeSorpresas();
		}		
		
	}
	
	private void cambioDeVista() throws IOException{

		this.gameLoop.detenerEjecucion();
		this.gameLoop.remover(vista);
		vista = new VistaDeVehiculo(modelo.getVehiculo());
		this.gameLoop.agregar(modelo.getVehiculo());
		this.gameLoop.agregar(vista);
		
		if (this.seBorroUnaSorpresa()){
			int posicionEnLista = this.obtenerPosicionDeSorpresaBorrada();
			VistaDeSorpresa vistaSorpresa = this.vistaSorpresas.get(posicionEnLista );
			this.vistaSorpresas.remove(vistaSorpresa);
			this.gameLoop.remover(vistaSorpresa);
		}

		this.gameLoop.iniciarEjecucion();
	}
	
	public int obtenerPosicionDeSorpresaBorrada(){
		
		int contador =  -1;
		List<Sorpresa> sorpresasAux =  modelo.getListaDeSorpresas();
		for( Sorpresa sorpresa : sorpresasAux){
			contador++;
			if (sorpresa != this.sorpresas.get(contador)){
				return contador;
			}
		}
		return this.sorpresas.size()-1;
	}
	
	private boolean seBorroUnaSorpresa(){
		
		if (modelo.getListaDeSorpresas().size() == this.sorpresas.size()){
			return false;
		}
		return true;
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
				        	posicionActual = modelo.getVehiculo().getY();
				        	if (posicionActual - Nivel.tamañoCuadra > 0) {
				        		modelo.getVehiculo().subir();
				            	modelo.aplicarEvento();
				        	}
							try {
								actualizar();
							} catch (IOException e1) {
							}
				            break;
			        case KeyEvent.VK_DOWN: // ABAJO
				        	posicionActual = modelo.getVehiculo().getY();
				        	if (posicionActual + Nivel.tamañoCuadra < modelo.getLimiteVertical()) {
				        		modelo.getVehiculo().bajar();
				            	modelo.aplicarEvento();
				        	}
							try {
								actualizar();
							} catch (IOException e1) {
							}
				            break;
			        case KeyEvent.VK_LEFT: // IZQUIERDA
			        	posicionActual = modelo.getVehiculo().getX();
			        	if (posicionActual + Nivel.tamañoCuadra > Nivel.tamañoCuadra) {
			        		modelo.getVehiculo().izquierda();
			            	modelo.aplicarEvento();
			        	}
			        		try {
								actualizar();
							} catch (IOException e1) {
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

	/* Crea el Panel de la pantalla con el mapa */
	private JPanel addSuperficiePanel() throws IOException {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(Color.WHITE);
		
		panel.setBounds(40, 40, this.modelo.getLimiteHorizontal(), this.modelo.getLimiteVertical());
		frame.getContentPane().add(panel);
		return panel;
	}

	/* Crea el botón de Guardar Partida */
	private JButton addBtnGuardar() {
		JButton botonGuardarYSalir = new JButton("Guardar y salir");
		botonGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
				System.exit(0);
			}
		});
		botonGuardarYSalir.setBounds(325, 10, 150, 19);
		botonGuardarYSalir.setFont(new java.awt.Font("Consola", 0, 12));
        botonGuardarYSalir.setForeground(Color.white);
        botonGuardarYSalir.setBackground(new java.awt.Color(0, 0, 153));
		frame.getContentPane().add(botonGuardarYSalir);
		return botonGuardarYSalir;
	}

	private void guardar() {
		Nivel nivel = modelo.getNivel();
		nivel = Archivador.cargar(new Nivel(), Nivel.GetNivelPath(this.dificultad));
		modelo.getPartida().setDificultad(this.dificultad);
		modelo.getPartida().agregarObstaculos(nivel.getObstaculos());
		modelo.getPartida().agregarSorpresas(nivel.getSorpresas());
		Archivador.guardar(modelo.getPartida(),modelo.getPartida().getPath());
        
        this.ranking = new Ranking();
        this.ranking = Archivador.cargar(ranking, ranking.rankingPath);
        try {
			this.ranking.agregarPuntaje(modelo.getVehiculo());
		} catch (MovimientoFueraDeMapaException e) {
			e.printStackTrace();
		}
		Archivador.guardar(ranking, Ranking.rankingPath);
	}
	
	/* Crea el botón de Inicio */
	private JButton addBotonIniciar() {
		JButton botonIniciar = new JButton("Iniciar");
		botonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		botonIniciar.setBounds(42, 10, 92, 19);
		botonIniciar.setFont(new java.awt.Font("Consola", 0, 12));
		botonIniciar.setForeground(Color.white);
        botonIniciar.setBackground(new java.awt.Color(0, 0, 153));
		frame.getContentPane().add(botonIniciar);
		return botonIniciar;
	}
	
	/* Determina la cantidad de cuadras a renderear dependiendo el 
	 * nivel del juego  */
	private int determinarCantidadDeCuadras(Juego juego) {
		int cuadrasHorizontales = (juego.getLimiteHorizontal() - Nivel.tamañoCalle) / Nivel.tamañoCuadraCalle;
		
		// Se determina que son siempre 6 cuadras de alto
		return cuadrasHorizontales * 6;
	}
}
