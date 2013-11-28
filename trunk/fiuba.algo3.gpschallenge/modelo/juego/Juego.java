package modelo.juego;

import java.util.ArrayList;
import java.util.List;

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
	public static Juego crearJuegoConUsuario(String user){
		Juego juego = new Juego(user);
		return juego;
	}
	
	public Juego(String piloto){
		this.limiteHorizontal = 10;
		this.limiteVertical = 10;
		this.eventos = this.crearEventos();
		this.ranking = new Ranking();
		this.vehiculo = this.crearVehiculo(piloto);
		this.meta = this.crearMeta(limiteHorizontal,limiteVertical/2);
	}

	private Meta crearMeta(int x,int y) {
		Meta meta = new Meta(x,y);
		return meta;
	}
	
	private Vehiculo crearVehiculo(String piloto) {
		Vehiculo vehiculo = Vehiculo.crearConPiloto(piloto,1,limiteVertical/2);
		return vehiculo;
	}
	
	private List<Evento> crearEventos() {
		ArrayList<Evento> nuevosEventos = new ArrayList<Evento>();
		return nuevosEventos;
	}

	public int getLimiteHorizontal() {
		return this.limiteHorizontal;
	}
	
	public int getLimiteVertical() {
		return this.limiteVertical;
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

	public boolean hayEvento(Vector posicion) {
		
		for(Evento evento : this.eventos ) {
			if((evento.getPosicion().getX() == posicion.getX()) && (evento.getPosicion().getY() == posicion.getY()))
				return true;
		}
		return false;
	}
	
}
