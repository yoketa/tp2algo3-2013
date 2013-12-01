package modelo.sorpresas;

import org.jdom.Element;

import modelo.juego.Vector;
import modelo.vehiculo.Vehiculo;

public class SorpresaDesfavorable extends Sorpresa {

	
	public SorpresaDesfavorable(){
		super(new Vector(0,0));
	}
	
	public SorpresaDesfavorable (Vector posicion){
		super(posicion);
	}
	
	
	@Override
	public void afectar(Vehiculo vehiculo) {
		vehiculo.penalizacionDesfavorable();
	}
	
	public Element serializarXML() {
		Element element = new Element("SorpresaDesFavorable");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}

public static Sorpresa cargarDesdeXML(Element element) {
		
		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		Sorpresa sorpresaDesFavorable = new SorpresaDesfavorable(vector);
		
		return sorpresaDesFavorable;
	}

}
