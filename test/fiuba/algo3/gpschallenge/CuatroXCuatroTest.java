package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class CuatroXCuatroTest {

	@Test
	public void testpasaPorPozoNoDeberiaAfectarAUnaCuatroXCuatro() {

		EstadoVehiculo estadoCuatroXCuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoCuatroXCuatro,0,0);
		Vector direccion = new Vector(1,0);
		
		try{
			vehiculo.mover(direccion);
			EstadoVehiculo cuatroXcuatro = vehiculo.getEstado();
			cuatroXcuatro.pasaPorPozo(vehiculo);
			
			Assert.assertEquals( 1 , vehiculo.getPosicionHorizontal());
			Assert.assertEquals( 0 , vehiculo.getPosicionVertical());	
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testPuiqueteNoDebeDejarPasar() {
		Vector direccion = new Vector(1,0);
		EstadoVehiculo estadoCuatroXCuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoCuatroXCuatro,0,0);
		
		try {
			vehiculo.mover(direccion);
			EstadoVehiculo cuatroXcuatro = vehiculo.getEstado();
			cuatroXcuatro.piquete(vehiculo,direccion);
			
			Assert.assertEquals( 0 , vehiculo.getPosicionHorizontal());
			Assert.assertEquals( 0 , vehiculo.getPosicionVertical());
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testpasaPorControlPolicialSumaTreaMovimientos() {
		EstadoVehiculo estadoCuatroXCuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoCuatroXCuatro,0,0);
		
		double puntaje = vehiculo.getPuntaje()+ 3;
		EstadoVehiculo cuatroXcuatro = vehiculo.getEstado();
		cuatroXcuatro.controlPolicial(vehiculo);
		Assert.assertEquals( puntaje , vehiculo.getPuntaje());
	}

}
