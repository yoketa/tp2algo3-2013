package modelo.juego;

import java.util.ArrayList;
import java.util.List;

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
	private String dificultadDeNivel;
	private Partida partida;
	
	public Juego(String piloto, Nivel nivel, EstadoVehiculo vehiculo){
		//persistencia
		this.nivel = nivel;
		setLimitesSegunDificultad(nivel.getDificultad());
		this.meta = this.crearMeta();
		
		this.eventos = this.crearEventos();
		this.ranking = new Ranking();
		this.vehiculo = Vehiculo.crearConPilotoYVehiculo(piloto,vehiculo);
		this.partida = new Partida(this.vehiculo);
		this.partida.setDificultad(this.getDificultadDeNivel());
	}

	/* Setea los límites del Juego según la dificultad
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
	
	/* Devuelve cuál debe ser el tamaño en píxeles para que el 
	 * escenario pueda tener tantas cuadras como se quieren
	 * 
	 * */
	private int pixelesPorCuadras(int tamañoEnCuadras) {
		return (Nivel.tamañoCalle + Nivel.tamañoCuadraCalle * tamañoEnCuadras);
	}
	
	private Meta crearMeta() {
		Meta meta = new Meta(limiteHorizontal - Nivel.tamañoCalle, pixelesPorCuadras(3) - 20);
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
	
	public String getDificultadDeNivel(){
		return this.dificultadDeNivel;
	}
	
	public void setDificultadDeNivel(String dificultad){
		this.dificultadDeNivel = dificultad;
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

	public Partida getPartida() {
        return this.partida;
	}
	
	public String getUsuario() {
		return this.vehiculo.getPiloto();
	}

	public Meta getMeta() {
		return this.meta;
	}
	
	public Nivel getNivel() {
		return this.nivel;
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
	
	public void carlcularPuntajeDeVehiculo(){
		int movimientosRealizados = this.vehiculo.getMovimientos();
		int puntajePorMovimiento = this.puntajePorMovimiento(this.dificultadDeNivel);
		int movimientosLimites = this.movimientosLimites(this.dificultadDeNivel);
		double puntajeTotal = (movimientosLimites - movimientosRealizados)*puntajePorMovimiento;
		this.vehiculo.setPuntaje(puntajeTotal);;
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
	
	public Evento obtenerEvento(Vector posicion) {
		
		Evento eventoADevolver = null;
		
		for(Evento evento : this.eventos ) {
			int limiteSuperiorEvento = evento.getPosicion().getY()+30;
			int limiteInferiorEvento = evento.getPosicion().getY()-30;
			
			if((evento.getPosicion().getX() == posicion.getX())&& ( limiteSuperiorEvento >= posicion.getY()) && (limiteInferiorEvento <= posicion.getY()))
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

	public int puntajePorMovimiento(String dificultad){
		switch (dificultad) {
		case "Facil":
			return 1;
		case "Moderado":
			return 2;
		case "Dificil":
			return 3;
		default:
			return 0;
		}
	}
	
	public int movimientosLimites(String dificultad){
		switch (dificultad) {
		case "Facil":
			return 38;
		case "Moderado":
			return 32;
		case "Dificil":
			return 25;
		default:
			return 0;
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
