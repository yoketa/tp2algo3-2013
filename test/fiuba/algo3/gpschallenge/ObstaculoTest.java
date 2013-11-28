package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.obstaculo.Obstaculo;
import modelo.obstaculo.Piquete;
import modelo.obstaculo.Pozo;
import modelo.probabilidades.Probabilidad;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

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