package modelo.obstaculo;

import org.jdom.Element;

import excepciones.ValorDeProbabilidadInvalidoException;
import modelo.juego.Vector;
import modelo.probabilidades.Probabilidad;
import modelo.probabilidades.ProbabilidadEquiprobable;
import modelo.vehiculo.Vehiculo;

public class ControlPolicial extends Obstaculo {
	
	private double probabilidad;
	
	public ControlPolicial (){
		super();
	}
	
	public ControlPolicial (Vector posicion,Probabilidad proba) throws ValorDeProbabilidadInvalidoException{
		super(posicion);
		this.probabilidad = proba.calcular();	
	}
	
	@Override
	public void afectar(Vehiculo vehiculo) {
			vehiculo.controlPolicial(this.getProbabilidad());
	}
	
	@Override
	public int getX() {
		return this.getPosicion().getX();
	}

	@Override
	public int getY() {
		return this.getPosicion().getY();
	}
	
	public double getProbabilidad(){
	 return this.probabilidad;
	}

	public Element serializarXML() {
		Element element = new Element("ControlPolicial");
		element.addContent(this.getPosicion().serializarXML());
		
		return element;
	}

	public static ControlPolicial cargarDesdeXML(Element element) throws ValorDeProbabilidadInvalidoException {
		ProbabilidadEquiprobable proba = new ProbabilidadEquiprobable();
		Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
		ControlPolicial controlPolicial = new ControlPolicial(vector,proba);
		
		return controlPolicial;
	}

	@Override
	public void vivir() {
	}	
}
