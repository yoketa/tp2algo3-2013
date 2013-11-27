package fiuba.algo3.gpschallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import persistencia.Archivador;
import fiuba.algo3.gpschallenge.modelo.Vehiculo;


public class PersistenciaVehiculoTest {
	private Vehiculo vehiculo;
	private Vehiculo otroVehiculo;
	
	@Before
	public void setup() {
		String piloto  = "pepe";
		vehiculo = Vehiculo.crearConPiloto(piloto,"",2,3);
		vehiculo.setPuntaje(50);
	}

	@Test
	public void GuardarYCargarTest() {
		String pathArchivo = "C:\\Users\\Miguel\\workspace\\repositorio\\save\\Vehiculo.xml";

		Archivador.guardar(vehiculo, pathArchivo);

		 otroVehiculo = Archivador.cargar(new Vehiculo(0,0), pathArchivo);
		assertEquals(otroVehiculo.getPiloto(),"pepe");
		assertEquals(otroVehiculo.getPuntaje(),50.0,1E-5);
		assertEquals(otroVehiculo.getPosicionHorizontal(),2,1E-5);
		assertEquals(otroVehiculo.getPosicionVertical(),3,1E-5);
	}
}
