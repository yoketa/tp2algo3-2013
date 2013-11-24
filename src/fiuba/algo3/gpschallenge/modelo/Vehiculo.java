package fiuba.algo3.gpschallenge.modelo;

import org.jdom.Attribute;
import org.jdom.Element;



public class Vehiculo {

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
		
	//TODO: Tipo de excepci�n en caso de que la direcci�n no sea ortonormal
	public void mover(Vector direccion) throws Exception {
		int tama�o = direccion.getX() + direccion.getY();
		
		if (tama�o > 1)
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
		Attribute att3 = new Attribute("x", String.valueOf(Integer.valueOf(this.posicion.getX())));
		Attribute att4 = new Attribute("y", String.valueOf(Integer.valueOf(this.posicion.getY())));
		element.getAttributes().add(att1);
		element.getAttributes().add(att2);
		element.getAttributes().add(att3);
		element.getAttributes().add(att4);
		return element;
	}
	
	public static Vehiculo cargarDesdeXML(Element element) {
		String valorPuntaje = element.getAttributeValue("puntaje");
		String valorPiloto = element.getAttributeValue("piloto");
		String valorX = element.getAttributeValue("x");
		String valorY = element.getAttributeValue("y");
		Vehiculo vehiculo = Vehiculo.crearConPiloto(valorPiloto,valorPiloto,Integer.parseInt(valorX),Integer.parseInt(valorY));
		vehiculo.setPuntaje(Double.parseDouble(valorPuntaje)); 
		
		return vehiculo;
	}


}
