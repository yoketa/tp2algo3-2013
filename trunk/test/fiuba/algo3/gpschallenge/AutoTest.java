package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.obstaculo.ControlPolicial;
import modelo.obstaculo.Obstaculo;
import modelo.probabilidades.Probabilidad;
import modelo.probabilidades.ProbabilidadFija;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;


public class AutoTest {

	@Test
	public void testpasaPorPozoDeberiaSumarTresMovimientos() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		int movimientos = 3;
		
		/* Act */
		auto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPozoDeberiaSumarPuntos() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		double puntaje = 40;
		
		/* Act */
		auto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(puntaje, vehiculo.getPuntaje());
	}
	
	@Test
	public void testpasaPorPozoDeberiaMoverEnLaDireccionDelVehiculo() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		vehiculo.subir();
		
		/* Act */
		auto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		Assert.assertEquals( 0 , vehiculo.getX());
		Assert.assertEquals( 2 , vehiculo.getY());
		
	}
	
	@Test
	public void testpasaPorPiqueteDeberiaSumarUnMovimientos() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		int movimientos = 1;
		
		/* Act */
		auto.piquete(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPiqueteDeberiaSumarPuntos() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		double puntaje = 30;
		
		/* Act */
		auto.piquete(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(puntaje, vehiculo.getPuntaje());
	}
	
	@Test
	public void testAfectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelAuto(){
		
		EstadoVehiculo auto = new Auto();
		Vector posicion = new Vector(0,0);
		
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		int movimientos = vehiculo.getMovimientos()+ 3;
		
		auto.controlPolicial(vehiculo,0.49);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testAfectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayotAlaDelAuto(){
		
		EstadoVehiculo auto = new Auto();
		Vector posicion = new Vector(0,0);

		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		int movimientos = vehiculo.getMovimientos();
		
		auto.controlPolicial(vehiculo,0.51);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
	}
}
