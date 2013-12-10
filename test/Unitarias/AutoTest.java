package Unitarias;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.interfaces.EstadoVehiculo;
import modelo.vehiculo.Auto;
import modelo.vehiculo.CuatroXCuatro;
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
	public void testAfectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayortAlaDelAuto(){
		
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
	
	@Test
	public void testpenalizacionFavorableDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		
		/* Act */
		vehiculo.derecha();
		auto.penalizacionFavorable(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
	
	@Test
	public void testpenalizacionFavorableDeberiaRestarEl20PorcientodeLosMovimientosHechos() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		vehiculo.sumarMovimientos(15);
		int movimientos = 13;
		
		/* Act */
		vehiculo.derecha();
		auto.penalizacionFavorable(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());
	}
	
	@Test
	public void testpenalizacionDesFavorableDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		
		/* Act */
		vehiculo.derecha();
		auto.penalizacionDesfavorable(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
	
	@Test
	public void testpenalizacionDesFavorableDeberiaSumarEl25PorcientodeLosMovimientosHechos() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		vehiculo.sumarMovimientos(15);
		int movimientos = 20;
		
		/* Act */
		vehiculo.derecha();
		auto.penalizacionDesfavorable(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());
	}
	
	@Test
	public void testcambiarEstadoDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);

		
		/* Act */
		vehiculo.derecha();
		auto.cambiarEstado(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
	
	@Test
	public void testcambiarEstadoDeberiaCambiarPorUnaCuatroXCuatro() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		EstadoVehiculo cuatro = new CuatroXCuatro();
		
		/* Act */
		vehiculo.derecha();
		auto.cambiarEstado(vehiculo);
		
		/* Assert*/
		assertEquals( cuatro.getClass() , vehiculo.getEstado().getClass());
	}
	
	@Test
	public void testsetProbabilidadDePasarUnControlPolicialDeberiaCambiarSuProbabilidad() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		/* Act */
		auto.setProbabilidadDePasarUnControlPolicial(0.2);
		
		/* Assert*/
		Assert.assertEquals(0.2, auto.getProbabilidadDePasarUnControlPolicial(), 0);
	}	
}