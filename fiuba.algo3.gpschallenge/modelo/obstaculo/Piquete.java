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
	public void afectar(Vehiculo vahiculo){
		
	}
	public Element serializarXML() {
		Element element = new Element("SorpresaFavorable");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}
}
