package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.CambioDeVehiculo;
import fiuba.algo3.gpschallenge.modelo.CuatroXCuatro;
import fiuba.algo3.gpschallenge.modelo.EstadoVehiculo;
import fiuba.algo3.gpschallenge.modelo.Moto;
import fiuba.algo3.gpschallenge.modelo.Obstaculo;
import fiuba.algo3.gpschallenge.modelo.Piquete;
import fiuba.algo3.gpschallenge.modelo.Pozo;
import fiuba.algo3.gpschallenge.modelo.Sorpresa;
import fiuba.algo3.gpschallenge.modelo.SorpresaDesfavorable;
import fiuba.algo3.gpschallenge.modelo.SorpresaFavorable;
import fiuba.algo3.gpschallenge.modelo.Vector;
import fiuba.algo3.gpschallenge.modelo.Vehiculo;

public class ObstaculoTest {

	
	@Test
	public void testPozoDebeImplementarEvento(){
		Obstaculo obstaculo = new Pozo();
		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoMoto,0,0);
		try {
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
		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoMoto,0,0);
		
		try {
			obstaculo.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}	
	}
//
//	@Test
//	public void testCambioDeVehiculoDebeImplementarEvento() {
//		Sorpresa sorpresa = new CambioDeVehiculo();
//		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Auto", 0, 0);
//		
//		try {
//			sorpresa.afectar(vehiculo);
//			assertTrue(true);
//		}
//		catch (Exception ex) {
//			fail();
//		}	
//	}
//	
//	@Test
//	public void testSorpresaDesfavorableSumaVeinticincoPorciento() {
//		Sorpresa sorpresa = new SorpresaDesfavorable();
//		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Auto", 0, 0);
//		
//		try {
//			vehiculo.mover(new Vector(1,0));
//			vehiculo.mover(new Vector(1,0));
//			vehiculo.mover(new Vector(1,0));
//			vehiculo.mover(new Vector(1,0));
//			vehiculo.mover(new Vector(1,0));
//			
//			sorpresa.afectar(vehiculo);
//			
//			assertEquals(5*1.25, vehiculo.getPuntaje(), 0.01);
//		} catch (Exception e) {
//			fail();
//		}
//	}
//	
//	@Test
//	public void testSorpresaFavorableRestaVeintePorciento() {
//		Sorpresa sorpresa = new SorpresaFavorable();
//		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Auto", 0, 0);
//		
//		try {
//			vehiculo.mover(new Vector(1,0));
//			vehiculo.mover(new Vector(1,0));
//			vehiculo.mover(new Vector(1,0));
//			vehiculo.mover(new Vector(1,0));
//			vehiculo.mover(new Vector(1,0));
//			
//			sorpresa.afectar(vehiculo);
//			
//			assertEquals(5*0.8, vehiculo.getPuntaje(), 0.01);
//		} catch (Exception e) {
//			fail();
//		}
//	}
}
