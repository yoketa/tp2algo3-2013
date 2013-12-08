package Unitarias;

import static org.junit.Assert.*;
import modelo.interfaces.EstadoVehiculo;
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
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		try {
			vehiculo.bajar();
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
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		try {
			vehiculo.derecha();
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
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		try {
			vehiculo.izquierda();
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
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		try {
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			
			sorpresa.afectar(vehiculo);
			
			assertEquals(6, vehiculo.getMovimientos());
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testSorpresaFavorableRestaVeintePorciento() {
		
		Sorpresa sorpresa = new SorpresaFavorable();
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		try {
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();
			vehiculo.subir();

			sorpresa.afectar(vehiculo);

			assertEquals(8, vehiculo.getMovimientos());
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testCambioDeVehiculoCambiaMotoPorAuto() {
		Sorpresa sorpresa = new CambioDeVehiculo();

		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",moto);
		EstadoVehiculo auto = new Auto();
		vehiculo.subir();
		sorpresa.afectar(vehiculo);
		
		assertEquals(auto.getClass(), vehiculo.getEstado().getClass());
		
	}
	
	@Test
	public void testCambioDeVehiculoCambiaAutoPorCuatroXCuatro() {
		
		Sorpresa sorpresa = new CambioDeVehiculo();
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
		vehiculo.subir();
		sorpresa.afectar(vehiculo);
		
		assertEquals(cuatroXCuatro.getClass(), vehiculo.getEstado().getClass());	
	}
	
	
	@Test
	public void testCambioDeVehiculoCambiaCuatroXCuatroPorMoto() {
		
		Sorpresa sorpresa = new CambioDeVehiculo();
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",cuatro);
		
		Moto moto = new Moto();
		vehiculo.subir();
		sorpresa.afectar(vehiculo);
		
		assertEquals(moto.getClass(), vehiculo.getEstado().getClass());	
	}
	
}
