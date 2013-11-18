package fiuba.algo3.gpschallenge.modelo;

import java.util.ArrayList;

public class Vehiculo {

	private String piloto;
	private Vector posicion;
	private double puntaje;
	private EstadoVehiculo estadoActual;
	
	public static Vehiculo crearConPiloto(String piloto,int x,int y) {
		Vehiculo vehiculo = new Vehiculo(x,y);
		vehiculo.setPiloto(piloto);
		return vehiculo;
	}

	public Vehiculo(int x, int y){
		this.posicion = new Vector(x,y);
		this.puntaje = 0;
	}
	
	//Luciana--Constructor con parametro de estadoInicial
	public static Vehiculo crearConPiloto(String piloto,String estadoInicial,int x,int y) {
		Vehiculo vehiculo = new Vehiculo(x,y);
		vehiculo.setPiloto(piloto);
		vehiculo.ComenzarConEstado(estadoInicial);
		return vehiculo;
	}

	 private void ComenzarConEstado(String estadoInicial){
		 switch ( estadoInicial ) {
	      case "Auto":
	           estadoActual= new Auto();
	           break;
	      case "Moto":
	    	  estadoActual= new Moto();
	           break;
	      case "CuatroXCuatro":
	      estadoActual= new CuatroXCuatro();
	           break;
	      }	
		}
	
	private void setPiloto(String piloto) {
		this.piloto = piloto;		
	}

	public String getPiloto() {
		return this.piloto;
	}

	public int getPosicionVertical() {
		return this.posicion.getY();
	}

	public int getPosicionHorizontal() {
		return this.posicion.getX();
	}
	
	//TODO: Tipo de excepción en caso de que la dirección no sea ortonormal
	public void mover(Vector direccion) throws Exception {
		int tamaño = direccion.getX() + direccion.getY();
		
		if (tamaño > 1)
		{
			throw new Exception();
		}
		
		this.posicion.setX(this.posicion.getX() + direccion.getX());
		this.posicion.setY(this.posicion.getY() + direccion.getY());
		
		this.puntaje++;
	}
	
	public double getPuntaje() {
		return this.puntaje;
	}
	
	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}
	
	public EstadoVehiculo getEstado() {
		return this.estadoActual;
	}
	
	public void setEstado(EstadoVehiculo estado) {
		this.estadoActual = estado;
	}
	
	public void penalizacionDesfavorable() {
		this.estadoActual.penalizacionDesfavorable(this);
	}
	
	public void penalizacionFavorable() {
		this.estadoActual.penalizacionFavorable(this);
	}
	
	public void cambiarEstado() {
		this.estadoActual.cambiarEstado(this);
	}

}
