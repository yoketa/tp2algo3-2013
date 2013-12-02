package modelo.vehiculo;

import static org.junit.Assert.fail;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;

import org.jdom.Attribute;
import org.jdom.Element;

public class CuatroXCuatro implements EstadoVehiculo {
	
	private double probabilidadDePasarUnControlPolicial;
	private final double PUNTOS_PIQUETE = 40;
	private final double PUNTOS_POZO = 60;
	private final double PUNTOS_CONTROLPOLICIAL_CON_PENALIZACION =50;
	private final double PUNTOS_CONTROLPOLICIAL_SIN_PENALIZACION =80;
	
	public CuatroXCuatro(){
		this.probabilidadDePasarUnControlPolicial = 0.3;
	}
	@Override
	public void pasaPorPozo(Vehiculo vehiculo) {
		
		vehiculo.sumarPuntos(PUNTOS_POZO);
		vehiculo.avanzarAFinalDeCuadra();
	}

	@Override
	public void piquete(Vehiculo vehiculo) {
		
		vehiculo.pegarLaVuelta();
		vehiculo.sumarPuntos(PUNTOS_PIQUETE);

	}
	
	@Override
	public void controlPolicial(Vehiculo vehiculo, double probabilidad) {
		
		if ( probabilidad <= this.getProbabilidadDePasarUnControlPolicial())
		{
			vehiculo.sumarMovimientos(3);
			vehiculo.sumarPuntos(PUNTOS_CONTROLPOLICIAL_CON_PENALIZACION);
		}else{
			vehiculo.sumarPuntos(PUNTOS_CONTROLPOLICIAL_SIN_PENALIZACION);
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
