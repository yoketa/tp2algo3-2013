package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class MotoTest {

	@Test
	public void testpasaPorPozoDeberiaSumarTresMovimientosAUnaMoto() {
		
		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoMoto,0,0);
		
		double puntaje = vehiculo.getPuntaje()+ 3;
		EstadoVehiculo moto = vehiculo.getEstado();
		moto.pasaPorPozo(vehiculo);
		
		Assert.assertEquals( puntaje , vehiculo.getPuntaje());
	}
	
	@Test
	public void testPuiqueteNoDebeDejarPasar() {
		Vector direccion = new Vector(1,0);
		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoMoto,0,0);
		
		try {
			vehiculo.mover(direccion);
			
			double puntaje = vehiculo.getPuntaje()+ 2;
			
			EstadoVehiculo moto = vehiculo.getEstado();
			moto.piquete(vehiculo,direccion);
			
			Assert.assertEquals( puntaje , vehiculo.getPuntaje());
			
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testpasaPorControlPolicialSumaTreaMovimientos() {
		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoMoto,0,0);
		
		double puntaje = vehiculo.getPuntaje()+ 3;
		
		EstadoVehiculo auto = vehiculo.getEstado();
		auto.controlPolicial(vehiculo);
		
		Assert.assertEquals( puntaje , vehiculo.getPuntaje());
	}

}
