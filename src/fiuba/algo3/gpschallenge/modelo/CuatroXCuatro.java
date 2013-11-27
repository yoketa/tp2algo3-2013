package fiuba.algo3.gpschallenge.modelo;

import static org.junit.Assert.fail;

import org.jdom.Attribute;
import org.jdom.Element;

public class CuatroXCuatro implements EstadoVehiculo {
	
private double probabilidadDePasarUnControlPolicial;
	
	public CuatroXCuatro(){
		this.probabilidadDePasarUnControlPolicial = 0.3;
	}

	@Override
	public void pasaPorPozo(Vehiculo vehiculo) {	
	}

	@Override
	public void piquete(Vehiculo vehiculo, Vector direccion) {
		direccion.setX(direccion.getX()*(-1));
		direccion.setY(direccion.getY()*(-1));
		try {
			vehiculo.mover(direccion);	
		}
		catch (Exception e) {
			fail();
		}
	}
	
	@Override
	public void controlPolicial(Vehiculo vehiculo) {
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual + 3);
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
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual * 0.8);		
	}

	@Override
	public void penalizacionDesfavorable(Vehiculo vehiculo) {
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual * 1.25);
	}

	@Override
	public void cambiarEstado(Vehiculo vehiculo) {
		vehiculo.setEstado(new Moto());
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
