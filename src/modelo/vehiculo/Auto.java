package modelo.vehiculo;

import javax.swing.JOptionPane;

import modelo.interfaces.EstadoVehiculo;
import org.jdom.Attribute;
import org.jdom.Element;

public class Auto implements EstadoVehiculo {
	
	private double probabilidadDePasarUnControlPolicial;
	
	public Auto(){
		this.probabilidadDePasarUnControlPolicial = 0.5;
	}
	

	@Override
	public void pasaPorPozo(Vehiculo vehiculo) {
		
		vehiculo.sumarMovimientos(3);
		vehiculo.avanzarAFinalDeCuadra();
	}

	@Override
	public void piquete(Vehiculo vehiculo) {
		vehiculo.pegarLaVuelta();
	}


	public void controlPolicial(Vehiculo vehiculo, double probabilidad) {
	
		if ( probabilidad <= this.getProbabilidadDePasarUnControlPolicial()){
			vehiculo.sumarMovimientos(3);
			JOptionPane.showMessageDialog(null,"Te ha detenido un Control Policial, sumas 3 movimientos");
		}else{
			JOptionPane.showMessageDialog(null,"Tuviste suerte, el Control Policial te dejo pasar");
		}
		vehiculo.avanzarAFinalDeCuadra();
	}
	
	@Override
	public void setProbabilidadDePasarUnControlPolicial(double probabilidad){
		this.probabilidadDePasarUnControlPolicial = probabilidad;
	}
	
	
	@Override
	public double getProbabilidadDePasarUnControlPolicial(){
		return this.probabilidadDePasarUnControlPolicial;
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
		vehiculo.setEstado(new CuatroXCuatro());
		JOptionPane.showMessageDialog(null, "Cambias tu auto por una buena 4x4");
		vehiculo.avanzarAFinalDeCuadra();
	}

	public Element serializarXML() {
		Element element = new Element("Auto");
		Attribute att1 = new Attribute("probabilidadDePasarUnControlPolicial",Double.valueOf(probabilidadDePasarUnControlPolicial).toString());
		element.getAttributes().add(att1);
		return element;
	}

	public static Auto cargarDesdeXML(Element element) {
		String probabilidad = element.getAttributeValue("probabilidadDePasarUnControlPolicial");
		Auto auto = new Auto(); 
		auto.setProbabilidadDePasarUnControlPolicial(Double.parseDouble(probabilidad));
		return auto;
	}
}
