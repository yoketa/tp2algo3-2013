package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class AutoTest {

	@Test
	public void testpasaPorPozoDeberiaSumarTresMovimientos() {
		EstadoVehiculo estadoAuto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoAuto,0,0);
		double puntaje = vehiculo.getPuntaje()+ 3;
		EstadoVehiculo auto = vehiculo.getEstado();
		auto.pasaPorPozo(vehiculo);
		
		Assert.assertEquals( puntaje , vehiculo.getPuntaje());
	}
	
	@Test
	public void testPuiqueteNoDebeDejarPasar() {
		EstadoVehiculo estadoAuto = new Auto();
		Vector direccion = new Vector(1,0);
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoAuto,0,0);
		
		try {
			vehiculo.mover(direccion);
			EstadoVehiculo auto = vehiculo.getEstado();
			auto.piquete(vehiculo,direccion);
			
			Assert.assertEquals( 0 , vehiculo.getX());
			Assert.assertEquals( 0 , vehiculo.getY());
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testpasaPorControlPolicialSumaTreaMovimientos() {
		EstadoVehiculo estadoAuto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoAuto,0,0);
		double puntaje = vehiculo.getPuntaje()+ 3;
		
		EstadoVehiculo auto = vehiculo.getEstado();
		auto.controlPolicial(vehiculo);
		
		Assert.assertEquals( puntaje , vehiculo.getPuntaje());
	}

}
