package modelo.juego;

import java.util.ArrayList;
import java.util.List;

import controladores.Nivel;
import modelo.interfaces.EstadoVehiculo;
import modelo.interfaces.Evento;
import modelo.obstaculo.Obstaculo;
import modelo.sorpresas.Sorpresa;
import modelo.vehiculo.Vehiculo;

public class Juego {
	
	// Atributos
	private int limiteVertical;
	private int limiteHorizontal;
	private List<Evento> eventos;
	private Nivel nivel;
	private Ranking ranking;
	private Vehiculo vehiculo;
	private Meta meta;
	
	// Metodos
	public static Juego crearJuego(String user,EstadoVehiculo vehiculo){
		Juego juego = new Juego(user,vehiculo);
		return juego;
	}
	
	public Juego(String piloto){
		//persistencia
		this.setLimiteHorizontal(Nivel.tama�oCuadraCalle);
		this.setLimiteVertical(Nivel.tama�oCuadraCalle);
		this.meta = this.crearMeta();
		
		this.eventos = this.crearEventos();
		this.ranking = new Ranking();
		this.vehiculo = Vehiculo.crearConPiloto(piloto,0,0);
	}
	
	public Juego(String piloto, EstadoVehiculo vehiculo){
		//persistencia
		this.setLimiteHorizontal(Nivel.tama�oCuadraCalle);
		this.setLimiteVertical(Nivel.tama�oCuadraCalle);
		this.meta = this.crearMeta();
		
		this.eventos = this.crearEventos();
		this.ranking = new Ranking();
		this.vehiculo = Vehiculo.crearConPilotoYVehiculo(piloto,vehiculo);
	}
	
	public Juego(String piloto, Nivel nivel, EstadoVehiculo vehiculo){
		//persistencia
		this.nivel = nivel;
		setLimitesSegunDificultad(nivel.getDificultad());
		this.meta = this.crearMeta();
		
		this.eventos = this.crearEventos();
		this.ranking = new Ranking();
		this.vehiculo = Vehiculo.crearConPilotoYVehiculo(piloto,vehiculo);
	}

	/* Setea los l�mites del Juego seg�n la dificultad
	 * 
	 * */
	private void setLimitesSegunDificultad(String dificultad) {
		switch (this.nivel.getDificultad()) {
		case "Facil":
			this.limiteHorizontal = pixelesPorCuadras(6);
			break;
		case "Moderado":
			this.limiteHorizontal = pixelesPorCuadras(8);
			break;
		case "Dificil":
			this.limiteHorizontal = pixelesPorCuadras(13);
			break;
		}

		this.limiteVertical = pixelesPorCuadras(6);
	}
	
	/* Devuelve cu�l debe ser el tama�o en p�xeles para que el 
	 * escenario pueda tener tantas cuadras como se quieren
	 * 
	 * */
	private int pixelesPorCuadras(int tama�oEnCuadras) {
		return (Nivel.tama�oCalle + Nivel.tama�oCuadraCalle * tama�oEnCuadras);
	}
	
	private Meta crearMeta() {
		Meta meta = new Meta(limiteHorizontal - Nivel.tama�oCalle, pixelesPorCuadras(3) - 20);
		return meta;
	}
	
	private List<Evento> crearEventos() {
		ArrayList<Evento> nuevosEventos = new ArrayList<Evento>();
		return nuevosEventos;
	}

	public int getLimiteHorizontal() {
		return this.limiteHorizontal;
	}
	
	public void setLimiteHorizontal(int i) {
		this.limiteHorizontal = i;
	}
	
	public int getLimiteVertical() {
		return this.limiteVertical;
	}
	
	public void setLimiteVertical(int i) {
		this.limiteVertical = i;
	}
	
	public List<Evento> getEventos() {
		return this.eventos;
	}

	public Ranking getRanking() {
        return this.ranking;
	}

	public String getUsuario() {
		return this.vehiculo.getPiloto();
	}

	public Meta getMeta() {
		return this.meta;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void agregarEvento(Evento evento) {
		this.eventos.add(evento);
	}
	
	public void quitarEvento(Evento evento) {
		this.eventos.remove(evento);
	}

	public void agregarSorpresas(List<Sorpresa> sorpresas){
		for (Sorpresa sorpresa : sorpresas) {
			this.eventos.add(sorpresa);
		}
		
	}
	public void agregarObstaculos(List<Obstaculo> obstaculos){
		for (Obstaculo obstaculo : obstaculos){
			this.eventos.add(obstaculo);
		}
	} 
	
	private boolean hayEvento(Vector posicion) {
		
		for(Evento evento : this.eventos ) {
			
			int limiteSuperiorEvento = evento.getPosicion().getY()+30;
			int limiteInferiorEvento = evento.getPosicion().getY()-30;
			
			if((evento.getPosicion().getX() == posicion.getX())&& ( limiteSuperiorEvento >= posicion.getY()) && (limiteInferiorEvento <= posicion.getY()))
				return true;
		}
		return false;
	}
	
	private Evento obtenerEvento(Vector posicion) {
		
		Evento eventoADevolver = null;
		
		for(Evento evento : this.eventos ) {
			if((evento.getPosicion().getX() == posicion.getX()) && (evento.getPosicion().getY() == posicion.getY()))
				eventoADevolver = evento;
		}
		return eventoADevolver;
	}
	
	public void aplicarEvento(){
		Vector posicion = this.vehiculo.getPosicion();
		
		boolean hayEvento = this.hayEvento(posicion);
		
		if ( hayEvento ) {
			obtenerEvento(posicion).afectar(this.vehiculo);
		}else{
			this.vehiculo.avanzarAFinalDeCuadra();
		}
	}

	public boolean llegoALaMeta() {
		
		int limiteSuperiorMeta = this.meta.getY()+30;
		int limiteInferiorMeta = this.meta.getY()-30;
		
		if ( this.meta.getX() == this.vehiculo.getX() &&  limiteSuperiorMeta >= this.vehiculo.getY() && limiteInferiorMeta <= this.vehiculo.getY())
			return true;
		return false;
	}
}
