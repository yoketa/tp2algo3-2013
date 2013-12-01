package modelo.sorpresas;



import org.jdom.Element;

import modelo.juego.Vector;
import modelo.vehiculo.Vehiculo;

public class SorpresaFavorable extends Sorpresa {
	
	
	
	public SorpresaFavorable (){
		super(new Vector(0,0));
	}
	
	public SorpresaFavorable (Vector posicion){
		super(posicion);
	}
	
	
	@Override
	public void afectar(Vehiculo vehiculo) {
		vehiculo.penalizacionFavorable();
	}

	public Element serializarXML() {
		Element element = new Element("SorpresaFavorable");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}

	public static SorpresaFavorable cargarDesdeXML(Element element) {
		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable(vector);
		
		return sorpresaFavorable;
	}
}
