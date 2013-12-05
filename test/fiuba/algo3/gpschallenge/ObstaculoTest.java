package fiuba.algo3.gpschallenge;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import modelo.interfaces.EstadoVehiculo;
import modelo.obstaculo.Obstaculo;
import modelo.obstaculo.Piquete;
import modelo.obstaculo.Pozo;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class ObstaculoTest {

	
	@Test
	public void testPozoDebeImplementarEvento(){
		Obstaculo obstaculo = new Pozo();
		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		try {
			vehiculo.bajar();
			obstaculo.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}
	}
	
	@Test
	public void testPiqueteDebeImplementarObstaculo() {
		Obstaculo obstaculo = new Piquete();
		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		
		try {
			vehiculo.bajar();
			obstaculo.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}	
	}

}