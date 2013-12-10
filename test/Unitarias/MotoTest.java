package Unitarias;

import static org.junit.Assert.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Assert;
import org.junit.Test;

public class MotoTest {

	@Test
	public void testpasaPorPozoDeberiaSumarTresMovimientosAUnaMoto() {
		
		/* Arrange */
		int penalizacion = 3;
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		moto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPozoDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		
		/* Act */
		vehiculo.derecha();
		moto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());
	}
	
	
	@Test
	public void testPiqueteDebePenalizarConDosMovimientos() {
		
		/* Arrange */
		int penalizacion = 2;
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		moto.piquete(vehiculo);
		
		/* Assert*/
		assertEquals(movimientos, vehiculo.getMovimientos());	
	}
	
	@Test
	public void testpiqueteDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		
		/* Act */
		vehiculo.derecha();
		moto.piquete(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());
	}
	
	@Test
	public void testafectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelaMoto(){
	
		/* Arrange */
		int penalizacion =3;
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);

		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		moto.controlPolicial(vehiculo,0.49);

		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
		}
	
	@Test
	public void testafectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayorAlaDelaMoto(){
	
		/* Arrange */
		int penalizacion = 0;
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		moto.controlPolicial(vehiculo,0.81);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
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
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		vehiculo.sumarMovimientos(15);
		int movimientos = 13;
		
		/* Act */
		vehiculo.derecha();
		moto.penalizacionFavorable(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());
	}
	
	@Test
	public void testpenalizacionDesFavorableDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		
		/* Act */
		vehiculo.derecha();
		moto.penalizacionDesfavorable(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());	
	}
	
	@Test
	public void testpenalizacionDesFavorableDeberiaSumarEl25PorcientodeLosMovimientosHechos() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		vehiculo.sumarMovimientos(15);
		int movimientos = 20;
		
		/* Act */
		vehiculo.derecha();
		moto.penalizacionDesfavorable(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());
	}
	
	@Test
	public void testcambiarEstadoDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		
		/* Act */
		vehiculo.derecha();
		moto.cambiarEstado(vehiculo);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());
	}
	
	@Test
	public void testcontrolPolicialDeberiaMoverALaSiguenteEsquina() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		
		/* Act */
		vehiculo.derecha();
		moto.controlPolicial(vehiculo, 0.2);
		
		/* Assert*/
		assertEquals( 70 , vehiculo.getX());
		assertEquals( 0 , vehiculo.getY());
	}
	
	@Test
	public void testcambiarEstadoDeberiaCambiarPorUnAuto() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		EstadoVehiculo auto = new Auto();
		
		/* Act */
		vehiculo.derecha();
		moto.cambiarEstado(vehiculo);
		
		/* Assert*/
		assertEquals( auto.getClass() , vehiculo.getEstado().getClass());
	}
	
	@Test
	public void testsetProbabilidadDePasarUnControlPolicialDeberiaCambiarSuProbabilidad() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		/* Act */
		moto.setProbabilidadDePasarUnControlPolicial(0.2);
		
		/* Assert*/
		Assert.assertEquals(0.2, moto.getProbabilidadDePasarUnControlPolicial(), 0);
	}	

}


