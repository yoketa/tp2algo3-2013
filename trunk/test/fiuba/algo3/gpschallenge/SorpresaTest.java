package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelo.juego.Vector;
import modelo.sorpresas.CambioDeVehiculo;
import modelo.sorpresas.Sorpresa;
import modelo.sorpresas.SorpresaDesfavorable;
import modelo.sorpresas.SorpresaFavorable;
import modelo.vehiculo.Auto;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;


public class SorpresaTest {
	
	@Test
	public void testSorpresaDesfavorableDebeImplementarEvento(){
		Sorpresa sorpresa = new SorpresaDesfavorable();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Auto", 0, 0);
		
		try {
			sorpresa.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}
	}
	
	@Test
	public void testSorpresaFavorableDebeImplementarEvento() {
		Sorpresa sorpresa = new SorpresaFavorable();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Auto", 0, 0);
		
		try {
			sorpresa.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}	
	}

	@Test
	public void testCambioDeVehiculoDebeImplementarEvento() {
		Sorpresa sorpresa = new CambioDeVehiculo();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Auto", 0, 0);
		
		try {
			sorpresa.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}	
	}
	
	@Test
	public void testSorpresaDesfavorableSumaVeinticincoPorciento() {
		Sorpresa sorpresa = new SorpresaDesfavorable();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Auto", 0, 0);
		
		try {
			vehiculo.mover(new Vector(1,0));
			vehiculo.mover(new Vector(1,0));
			vehiculo.mover(new Vector(1,0));
			vehiculo.mover(new Vector(1,0));
			vehiculo.mover(new Vector(1,0));
			
			sorpresa.afectar(vehiculo);
			
			assertEquals(5*1.25, vehiculo.getPuntaje(), 0.01);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testSorpresaFavorableRestaVeintePorciento() {
		Sorpresa sorpresa = new SorpresaFavorable();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Auto", 0, 0);
		
		try {
			vehiculo.mover(new Vector(1,0));
			vehiculo.mover(new Vector(1,0));
			vehiculo.mover(new Vector(1,0));
			vehiculo.mover(new Vector(1,0));
			vehiculo.mover(new Vector(1,0));
			
			sorpresa.afectar(vehiculo);
			
			assertEquals(5*0.8, vehiculo.getPuntaje(), 0.01);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testCambioDeVehiculoCambiaMotoPorAuto() {
		Sorpresa sorpresa = new CambioDeVehiculo();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Moto", 0, 0);
		
		Auto auto = new Auto();
		sorpresa.afectar(vehiculo);
		
		assertEquals(auto.getClass(), vehiculo.getEstado().getClass());
		
	}
	
	@Test
	public void testCambioDeVehiculoCambiaAutoPorCuatroXCuatro() {
		Sorpresa sorpresa = new CambioDeVehiculo();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "Auto", 0, 0);
		
		CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
		sorpresa.afectar(vehiculo);
		
		assertEquals(cuatroXCuatro.getClass(), vehiculo.getEstado().getClass());
		
	}
	
	@Test
	public void testCambioDeVehiculoCambiaCuatroXCuatroPorMoto() {
		Sorpresa sorpresa = new CambioDeVehiculo();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("", "CuatroXCuatro", 0, 0);
		
		Moto moto = new Moto();
		sorpresa.afectar(vehiculo);
		
		assertEquals(moto.getClass(), vehiculo.getEstado().getClass());
		
	}
	
}