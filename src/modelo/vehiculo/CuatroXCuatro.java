package modelo.vehiculo;

import javax.swing.JOptionPane;

import modelo.interfaces.EstadoVehiculo;
import org.jdom.Attribute;
import org.jdom.Element;

public class CuatroXCuatro implements EstadoVehiculo {
	
	private double probabilidadDePasarUnControlPolicial;
	
	public CuatroXCuatro(){
		this.probabilidadDePasarUnControlPolicial = 0.3;
	}
	@Override
	public void pasaPorPozo(Vehiculo vehiculo) {
		
		vehiculo.avanzarAFinalDeCuadra();
	}

	@Override
	public void piquete(Vehiculo vehiculo) {
		
		vehiculo.pegarLaVuelta();

	}
	
	@Override
	public void controlPolicial(Vehiculo vehiculo, double probabilidad) {
		
		if ( probabilidad <= this.getProbabilidadDePasarUnControlPolicial()){
			
			JOptionPane.showMessageDialog(null,"Te ha detenido un Control Policial, sumas 3 movimientos");
			vehiculo.sumarMovimientos(3);
			
		}else{
			
			JOptionPane.showMessageDialog(null,"Tuviste suerte, el Control Policial te dejo pasar");
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
		vehiculo.setEstado(new Moto());
		JOptionPane.showMessageDialog(null, "Chocas con tu 4x4, pero te robas una moto");
		vehiculo.avanzarAFinalDeCuadra();
	}

	public Element serializarXML() {
		Element element = new Element("CuatroXCuatro");
		Attribute att1 = new Attribute("probabilidadDePasarUnControlPolicial",Double.valueOf(probabilidadDePasarUnControlPolicial).toString());
		element.getAttributes().add(att1);
		return element;
	}

	public static CuatroXCuatro cargarDesdeXML(Element element) {
		String probabilidad = element.getAttributeValue("probabilidadDePasarUnControlPolicial");
		CuatroXCuatro cuatroXCuatro = new CuatroXCuatro(); 
		cuatroXCuatro.setProbabilidadDePasarUnControlPolicial(Double.parseDouble(probabilidad));
		return cuatroXCuatro;
	}
}
