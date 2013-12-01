package modelo.sorpresas;

import org.jdom.Element;

import modelo.juego.Vector;
import modelo.vehiculo.Vehiculo;

public class CambioDeVehiculo extends Sorpresa {
	
	
	public CambioDeVehiculo(){
		super(new Vector(0,0));
	}
	
	public CambioDeVehiculo (Vector posicion){
		super(posicion);
	}
	
	@Override
	public void afectar(Vehiculo vehiculo){
		vehiculo.cambiarEstado();
	}

	public Element serializarXML() {
		Element element = new Element("CambioDeVehiculo");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}

public static CambioDeVehiculo cargarDesdeXML(Element element) {
		
		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		CambioDeVehiculo cambioDeVehiculo = new CambioDeVehiculo(vector);
		
		return cambioDeVehiculo;
	}

}
