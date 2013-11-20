package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.EstadoVehiculo;
import fiuba.algo3.gpschallenge.modelo.Moto;
import fiuba.algo3.gpschallenge.modelo.Obstaculo;
import fiuba.algo3.gpschallenge.modelo.Piquete;
import fiuba.algo3.gpschallenge.modelo.Pozo;
import fiuba.algo3.gpschallenge.modelo.Probabilidad;
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

//	@Test
//	public void testControlPolicialDebeImplementarObstaculo() {
//		Obstaculo obstaculo = new ControlPolicial(probabilidad);
//		EstadoVehiculo estadoMoto = new Moto();
//		Vehiculo vehiculo = Vehiculo.crearConPiloto("",estadoMoto,0,0);
//		
//		try {
//			obstaculo.afectar(vehiculo);
//			assertTrue(true);
//		}
//		catch (Exception ex) {
//			fail();
//		}	
//	}

}