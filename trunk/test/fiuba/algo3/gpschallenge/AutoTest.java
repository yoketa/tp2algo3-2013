package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.EstadoVehiculo;
import fiuba.algo3.gpschallenge.modelo.Vector;
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
	
	@Test
	public void testPuiqueteNoDebeDejarPasar() {
		Vector direccion = new Vector(1,0);
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","Auto",0,0);
		
		try {
			vehiculo.mover(direccion);
			EstadoVehiculo auto = vehiculo.getEstado();
			auto.piquete(vehiculo,direccion);
			
			Assert.assertEquals( 0 , vehiculo.getPosicionHorizontal());
			Assert.assertEquals( 0 , vehiculo.getPosicionVertical());
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testpasaPorControlPolicialSumaTreaMovimientos() {
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","Auto",0,0);
		double puntaje = vehiculo.getPuntaje()+ 3;
		EstadoVehiculo auto = vehiculo.getEstado();
		auto.controlPolicial(vehiculo);
		Assert.assertEquals( puntaje , vehiculo.getPuntaje());
	}

}
