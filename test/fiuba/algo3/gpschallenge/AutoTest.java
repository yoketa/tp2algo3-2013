package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.EstadoVehiculo;
import fiuba.algo3.gpschallenge.modelo.Vehiculo;

public class AutoTest {

	@Test
	public void testpasaPorPozoDeberiaSumarTresMovimientos() {
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","Auto",0,0);
		double puntaje = vehiculo.getPuntaje()+ 3;
		EstadoVehiculo auto = vehiculo.getEstado();
		auto.pasaPorPozo(vehiculo);
		
		Assert.assertEquals( puntaje , vehiculo.getPuntaje());
	}

}
