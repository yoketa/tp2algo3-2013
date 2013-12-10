package Unitarias;

import static org.junit.Assert.*;

import modelo.interfaces.EstadoVehiculo;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Assert;
import org.junit.Test;


public class CuatroXCuatroTest {

	@Test
	public void testpasaPorPozoNoDeberiaPenalizarAUnaCuatroXCuatro() {
		
		/* Arrange */
		int penalizacion = 0;
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		cuatro.pasaPorPozo(vehiculo);
		
		/* Assert*/
		assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPozoDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		
		/* Act */
		vehiculo.derecha();
		cuatro.pasaPorPozo(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());
	}	

	
	@Test
	public void testpasaPorPiqueteDeberiaSumarUnMovimientos() {

		/* Arrange */
		int movimientos = 1;
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		
		/* Act */
		vehiculo.derecha();
		cuatro.piquete(vehiculo);
		
		/* Assert*/
		assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPiqueteDeberiaHacerloRetrodecer() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		
		/* Act */
		vehiculo.derecha();
		cuatro.piquete(vehiculo);
		
		/* Assert*/
		assertEquals( 0 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());
	}	
	
	@Test
	public void testAfectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelCuatroXCuatro(){
		
		/* Arrange */
		int penalizacion =3;
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);

		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		cuatro.controlPolicial(vehiculo,0.29);

		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());
	}
	
	@Test
	public void testAfectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayotAlaDelCuatroXCuatro(){
		
		/* Arrange */
		int penalizacion = 0;
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);

		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		cuatro.controlPolicial(vehiculo,0.39);

		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testpasaPorControlPolicialDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);

		/* Act */
		vehiculo.derecha();
		cuatro.controlPolicial(vehiculo,0.39);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());
	}	
	
	@Test
	public void testpenalizacionFavorableDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		
		/* Act */
		vehiculo.derecha();
		cuatro.penalizacionFavorable(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
	
	@Test
	public void testpenalizacionFavorableDeberiaRestarEl20PorcientodeLosMovimientosHechos() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);

		vehiculo.sumarMovimientos(15);
		int movimientos = 13;
		
		/* Act */
		vehiculo.derecha();
		cuatro.penalizacionFavorable(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());
	}
	
	@Test
	public void testpenalizacionDesFavorableDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		
		/* Act */
		vehiculo.derecha();
		cuatro.penalizacionDesfavorable(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
	
	@Test
	public void testpenalizacionDesFavorableDeberiaSumarEl25PorcientodeLosMovimientosHechos() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		vehiculo.sumarMovimientos(15);
		int movimientos = 20;
		
		/* Act */
		vehiculo.derecha();
		cuatro.penalizacionDesfavorable(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());
	}
	
	@Test
	public void testcambiarEstadoDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		
		/* Act */
		vehiculo.derecha();
		cuatro.cambiarEstado(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
	
	@Test
	public void testcambiarEstadoDeberiaCambiarPorUnaCuatroXCuatro() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		EstadoVehiculo moto = new Moto();
		
		/* Act */
		vehiculo.derecha();
		cuatro.cambiarEstado(vehiculo);
		
		/* Assert*/
		assertEquals( moto.getClass() , vehiculo.getEstado().getClass());
	}
	
	@Test
	public void testsetProbabilidadDePasarUnControlPolicialDeberiaCambiarSuProbabilidad() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		/* Act */
		cuatro.setProbabilidadDePasarUnControlPolicial(0.2);
		
		/* Assert*/
		Assert.assertEquals(0.2, cuatro.getProbabilidadDePasarUnControlPolicial(), 0);
	}
}
			
			