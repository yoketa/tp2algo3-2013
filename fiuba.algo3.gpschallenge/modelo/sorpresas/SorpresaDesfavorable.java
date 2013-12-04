package modelo.sorpresas;

import org.jdom.Element;

import modelo.juego.Vector;
import modelo.vehiculo.Vehiculo;

public class SorpresaDesfavorable extends Sorpresa {


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
		Element element = new Element("SorpresaDesfavorable");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}

public static SorpresaDesfavorable cargarDesdeXML(Element element) {
		
		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable(vector);
		
		return sorpresaDesfavorable;
	}

}
