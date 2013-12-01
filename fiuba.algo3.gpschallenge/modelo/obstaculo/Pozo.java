package modelo.obstaculo;

import org.jdom.Element;

import modelo.juego.Vector;
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
		
	}
	
	public Element serializarXML() {
		Element element = new Element("SorpresaFavorable");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}
	
}
