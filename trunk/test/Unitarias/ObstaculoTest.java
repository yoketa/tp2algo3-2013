package Unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.obstaculo.ControlPolicial;
import modelo.obstaculo.Obstaculo;
import modelo.obstaculo.Piquete;
import modelo.obstaculo.Pozo;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class ObstaculoTest {

	@Test
	public void testPosicionDeObstaculoInizializaSuPosicionEnCeroCero(){
	
		/* Arrange */
		Obstaculo obstaculo = new ControlPolicial();

		/* Assert*/
		assertEquals( 0, obstaculo.getX());	
		assertEquals( 0, obstaculo.getY());
	}
	
	@Test
	public void testPosicionDeObstaculoInicializaConUnaPosicion(){
	
		/* Arrange */
		Vector posicion = new Vector(4,4);
		Obstaculo obstaculo = new Piquete(posicion);
		
		obstaculo.setPosicion(posicion);

		/* Assert*/
		assertEquals( posicion, obstaculo.getPosicion());
	}
	@Test
	public void testAfectarDebeSerImplementadoPorPozo(){
		
		Obstaculo obstaculo = new Pozo();
		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		try {
			vehiculo.bajar();
			obstaculo.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}
	}
	
	@Test
	public void testAfectarDebeSerImplementadoPorPiquete() {
		
		Obstaculo obstaculo = new Piquete();
		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		
		try {
			vehiculo.bajar();
			obstaculo.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}	
	}
	
	@Test
	public void testAfectarDebeSerImplementadoPorControlPolicial() {
		
		Obstaculo obstaculo = new ControlPolicial();
		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		
		try {
			vehiculo.bajar();
			obstaculo.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}	
	}
}