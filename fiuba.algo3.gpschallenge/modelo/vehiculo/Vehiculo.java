package modelo.vehiculo;

import modelo.interfaces.EstadoVehiculo;
import java.util.Observable;
import modelo.juego.Vector;

import org.jdom.Attribute;
import org.jdom.Element;



public class Vehiculo extends Observable {

	private String piloto;
	private Vector posicion;
	private double puntaje;
	private EstadoVehiculo estadoActual;


	//Constructor Mejorado.
	public static Vehiculo crearConPiloto(String piloto,EstadoVehiculo estadoInicial, int x, int y) {
		Vehiculo vehiculo = new Vehiculo(x,y);
		vehiculo.setPiloto(piloto);
		vehiculo.setEstado(estadoInicial);
		vehiculo.setPuntaje(0);
		return vehiculo;
	}	
	
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
		ActualizarObservadores();
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
		ActualizarObservadores();
	}
	
	public EstadoVehiculo getEstado() {
		return this.estadoActual;
	}
	
	public void setEstado(EstadoVehiculo estado) {
		this.estadoActual = estado;
		ActualizarObservadores();
	}

	public void penalizacionDesfavorable() {
		this.estadoActual.penalizacionDesfavorable(this);
	}
	
	public void penalizacionFavorable() {
		this.estadoActual.penalizacionFavorable(this);
	}
	
	public void pasaPorPozo() {
		this.estadoActual.pasaPorPozo(this);
	}
	
	public void piquete(Vector direccion) {
		this.estadoActual.piquete(this,direccion);
	}
	
	public void controlPolicial() {
		this.estadoActual.controlPolicial(this);
	}
	
	public void cambiarEstado() {
		this.estadoActual.cambiarEstado(this);
	}

	public Element serializarXML() {
		Element element = new Element("Vehiculo");
		Attribute att1 = new Attribute("puntaje",Double.valueOf(puntaje).toString());
		Attribute att2 = new Attribute("piloto",String.valueOf(piloto).toString());
		element.getAttributes().add(att1);
		element.getAttributes().add(att2);

		element.addContent(posicion.serializarXML());
		element.addContent(estadoActual.serializarXML());

		element.addContent(posicion.serializarXML());

		return element;
	}
	
	public static Vehiculo cargarDesdeXML(Element element) {
		String valorPuntaje = element.getAttributeValue("puntaje");
		String valorPiloto = element.getAttributeValue("piloto");

		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		EstadoVehiculo estado = null;
			if ((element.getChild("Auto")) != null){
				estado = new Auto();
				estado = Auto.cargarDesdeXML(element.getChild("Auto"));
			}
			if ((element.getChild("Moto")) != null){
				estado = new Moto();
				estado = Moto.cargarDesdeXML(element.getChild("Moto"));
			}
			if ((element.getChild("CuatroXCuatro")) != null){
				estado = new CuatroXCuatro();
				estado = CuatroXCuatro.cargarDesdeXML(element.getChild("CuatroXCuatro"));
			}
			
		Vehiculo vehiculo = Vehiculo.crearConPiloto(valorPiloto,valorPiloto,vector.getX(),vector.getY());

		vehiculo.setPuntaje(Double.parseDouble(valorPuntaje)); 
		vehiculo.setEstado(estado);	
		return vehiculo;
	}
	
	public void subir() {
		Vector arriba = new Vector(1,0);
		try {
			this.mover(arriba);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bajar() {
		Vector arriba = new Vector(1,0);
		try {
			this.mover(arriba);
		} catch (Exception e) {
	
		}
	}
	
	public void derecha() {
		Vector arriba = new Vector(1,0);
		try {
			this.mover(arriba);
		} catch (Exception e) {
		
		}
	}
	
	public void izquierda() {
		Vector arriba = new Vector(1,0);
		try {
			this.mover(arriba);
		} catch (Exception e) {
			
		}
	}
	
	public void ActualizarObservadores()
	{
		setChanged();
		notifyObservers();		
	}


}
