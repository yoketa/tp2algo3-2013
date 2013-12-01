package modelo.obstaculo;

import org.jdom.Element;

import modelo.juego.Vector;
import modelo.probabilidades.Probabilidad;
import modelo.vehiculo.Vehiculo;

public class ControlPolicial extends Obstaculo {
	
	private double probabilidad;
	
	public ControlPolicial (){
		super(new Vector(0,0));
	}
	
	public ControlPolicial (Vector posicion){
		super(posicion);
	}
	
	
	public ControlPolicial(Probabilidad probabilidad){
		this.probabilidad = probabilidad.calcular();	
	}
	
	@Override
	public void afectar(Vehiculo vehiculo) {
		
		double probabilidadDelvehiculo = vehiculo.getEstado().getProbabilidadDePasarUnControlPolicial();

		if ( this.getProbabilidad() > probabilidadDelvehiculo)
		{
			vehiculo.controlPolicial();
		}
	}
	
	public double getProbabilidad(){
	 return this.probabilidad;
	}

	public Element serializarXML() {
		Element element = new Element("ControlPolicial");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}

	public static ControlPolicial cargarDesdeXML(Element element) {
		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		ControlPolicial controlPolicial = new ControlPolicial(vector);
		
		return controlPolicial;
	}	
}
