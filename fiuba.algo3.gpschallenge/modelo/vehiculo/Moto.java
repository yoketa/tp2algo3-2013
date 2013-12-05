package modelo.vehiculo;

import javax.swing.JOptionPane;

import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;

import org.jdom.Attribute;
import org.jdom.Element;

public class Moto implements EstadoVehiculo {
	

	private double probabilidadDePasarUnControlPolicial;
	
	public Moto(){
		this.probabilidadDePasarUnControlPolicial = 0.8;
	}
	
	@Override
	public void pasaPorPozo(Vehiculo vehiculo) {
		
		vehiculo.sumarMovimientos(3);
		vehiculo.avanzarAFinalDeCuadra();

	}

	@Override
	public void piquete(Vehiculo vehiculo) {
		
		vehiculo.sumarMovimientos(2);
		vehiculo.avanzarAFinalDeCuadra();
	}

	@Override
	public void controlPolicial(Vehiculo vehiculo, double probabilidad) {
		
		if ( probabilidad <= this.getProbabilidadDePasarUnControlPolicial())
		{
			vehiculo.sumarMovimientos(3);
		}
		vehiculo.avanzarAFinalDeCuadra();
	}

	
	@Override
	public double getProbabilidadDePasarUnControlPolicial(){
		return this.probabilidadDePasarUnControlPolicial;
	}

	@Override
	public void setProbabilidadDePasarUnControlPolicial(double probabilidad){
		this.probabilidadDePasarUnControlPolicial = probabilidad;
	}
	
	@Override
	public void penalizacionFavorable(Vehiculo vehiculo) {
		int movimientosActuales = vehiculo.getMovimientos();
		vehiculo.sumarMovimientos((int) (-movimientosActuales * 0.2));
		JOptionPane.showMessageDialog(null, "Utilizas Nitro!! Has encontrado una Sorpresa Favorable");
		vehiculo.avanzarAFinalDeCuadra();		
	}

	@Override
	public void penalizacionDesfavorable(Vehiculo vehiculo) {
		int movimientosActuales = vehiculo.getMovimientos();
		vehiculo.sumarMovimientos((int) (movimientosActuales * 0.25));
		JOptionPane.showMessageDialog(null, "Pinchaste una rueda, Has encontrado una Sorpresa Desfavorable");
		vehiculo.avanzarAFinalDeCuadra();
	}

	@Override
	public void cambiarEstado(Vehiculo vehiculo) {
		vehiculo.setEstado(new Auto());
		JOptionPane.showMessageDialog(null, "Vendes tu moto y consigues un Auto");
		vehiculo.avanzarAFinalDeCuadra();
	}
	
	public Element serializarXML() {
		Element element = new Element("Moto");
		Attribute att1 = new Attribute("probabilidadDePasarUnControlPolicial",Double.valueOf(probabilidadDePasarUnControlPolicial).toString());
		element.getAttributes().add(att1);
		return element;
	}

	public static Moto cargarDesdeXML(Element element) {
		String probabilidad = element.getAttributeValue("probabilidadDePasarUnControlPolicial");
		Moto moto = new Moto(); 
		moto.setProbabilidadDePasarUnControlPolicial(Double.parseDouble(probabilidad));
		return moto;
	}
}
