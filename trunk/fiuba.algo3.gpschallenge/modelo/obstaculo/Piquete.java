package modelo.obstaculo;

import org.jdom.Element;

import modelo.juego.Vector;
import modelo.vehiculo.Vehiculo;


public class Piquete extends Obstaculo {

	public Piquete (){
		super(new Vector(0,0));
	}
	
	public Piquete (Vector posicion){
		super(posicion);
	}
	
	@Override
	public void afectar(Vehiculo vehiculo){
		vehiculo.piquete();
	}
	public Element serializarXML() {
		Element element = new Element("Piquete");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}

	public static Piquete cargarDesdeXML(Element element) {
		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		Piquete piquete = new Piquete(vector);
		
		return piquete;
	}	
}
