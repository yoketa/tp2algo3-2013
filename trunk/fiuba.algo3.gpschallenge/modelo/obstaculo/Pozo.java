package modelo.obstaculo;

import org.jdom.Element;

import modelo.juego.Vector;
import modelo.sorpresas.SorpresaFavorable;
import modelo.vehiculo.Vehiculo;


public class Pozo extends Obstaculo {
	
	public Pozo (){
		super(new Vector(0,0));
	}
	
	public Pozo (Vector posicion){
		super(posicion);
	}
	
	@Override
	public void afectar(Vehiculo vehiculo){
		vehiculo.pasaPorPozo();
	}
	
	public Element serializarXML() {
		Element element = new Element("Pozo");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}
	
	public static Pozo cargarDesdeXML(Element element) {
		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		Pozo pozo = new Pozo(vector);
		
		return pozo;
	}	

	@Override
	public int getX() {
		return this.getPosicion().getX();
	}

	@Override
	public int getY() {
		return this.getPosicion().getY();
	}

	@Override
	public void vivir() {
		
	}	
}
