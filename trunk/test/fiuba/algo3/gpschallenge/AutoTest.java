package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.interfaces.EstadoVehiculo;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;


public class AutoTest {

	@Test
	public void testpasaPorPozoDeberiaSumarTresPenalizaciones() {
		
		/* Arrange */
		int penalizacion = 3;
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		auto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPozoDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		
		/* Act */
		vehiculo.derecha();
		auto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
	
	@Test
	public void testpasaPorPiqueteDeberiaSumarSoloUnMovimientos() {
		
		/* Arrange */
		int movimientos = 1;
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		
		/* Act */
		vehiculo.derecha();
		auto.piquete(vehiculo);
		
		/* Assert*/
		assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpiqueteDeberiaHacerloRetroceder() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		
		/* Act */
		vehiculo.derecha();
		auto.piquete(vehiculo);
		
		/* Assert*/
		assertEquals( 0 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
	
	@Test
	public void testAfectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelAuto(){
		
		/* Arrange */
		int penalizacion =3;
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);

		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		auto.controlPolicial(vehiculo,0.49);

		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testAfectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayotAlaDelAuto(){
		
		/* Arrange */
		int penalizacion = 0;
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		auto.controlPolicial(vehiculo,0.51);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testcontrolPolicialDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		
		/* Act */
		vehiculo.derecha();
		auto.controlPolicial(vehiculo,0.51);
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
}