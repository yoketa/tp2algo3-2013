package modelo.juego;

import java.util.ArrayList;
import java.util.List;

import modelo.interfaces.EstadoVehiculo;
import modelo.interfaces.Evento;
import modelo.vehiculo.Vehiculo;

public class Juego {
	
	// Atributos
	private int limiteVertical;
	private int limiteHorizontal;
	private List<Evento> eventos;
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
		this.setLimiteHorizontal(10);
		this.setLimiteVertical(10);
		this.meta = this.crearMeta();
		
		this.eventos = this.crearEventos();
		this.ranking = new Ranking();
		this.vehiculo = Vehiculo.crearConPiloto(piloto,0,0);
	}
	
	public Juego(String piloto, EstadoVehiculo vehiculo){
		//persistencia
		this.setLimiteHorizontal(10);
		this.setLimiteVertical(10);
		this.meta = this.crearMeta();
		
		this.eventos = this.crearEventos();
		this.ranking = new Ranking();
		this.vehiculo = Vehiculo.crearConPilotoYVehiculo(piloto,vehiculo);
	}

	private Meta crearMeta() {
		Meta meta = new Meta(limiteHorizontal,limiteVertical/2);
		return meta;
	}
	
//	private Vehiculo crearVehiculo(String piloto) {
//	Vehiculo vehiculo = Vehiculo.crearConPiloto(piloto,1,limiteVertical/2);
//	return vehiculo;
//}
	
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

	private boolean hayEvento(Vector posicion) {
		
		for(Evento evento : this.eventos ) {
			if((evento.getPosicion().getX() == posicion.getX()) && (evento.getPosicion().getY() == posicion.getY()))
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
		if ( this.meta.getX() == this.vehiculo.getX() && this.meta.getY() == this.vehiculo.getY())
			return true;
		return false;
	}
}
