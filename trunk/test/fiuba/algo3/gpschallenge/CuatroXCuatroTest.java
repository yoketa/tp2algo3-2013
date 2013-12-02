package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.obstaculo.ControlPolicial;
import modelo.obstaculo.Obstaculo;
import modelo.probabilidades.Probabilidad;
import modelo.probabilidades.ProbabilidadFija;
import modelo.vehiculo.Auto;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class CuatroXCuatroTest {

	@Test
	public void testpasaPorPozoNoDeberiaAfectarAUnaCuatroXCuatro() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		int movimientos = 0;
		
		/* Act */
		cuatro.pasaPorPozo(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPozoDeberiaSumarPuntos() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		double puntaje = 60;
		
		/* Act */
		cuatro.pasaPorPozo(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(puntaje, vehiculo.getPuntaje());
	}
	
	@Test
	public void testpasaPorPiqueteDeberiaSumarUnMovimientos() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		int movimientos = 0;
		
		/* Act */
		cuatro.piquete(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPiqueteDeberiaSumarPuntos() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		double puntaje = 40;
		
		/* Act */
		cuatro.piquete(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(puntaje, vehiculo.getPuntaje());
	}
	
	
	@Test
	public void testpasaPorPozoDeberiaMoverEnLaDireccionDelVehiculo() {
		
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		vehiculo.subir();
		
		/* Act */
		cuatro.pasaPorPozo(vehiculo);
		
		/* Assert*/
		Assert.assertEquals( 0 , vehiculo.getX());
		Assert.assertEquals( 2 , vehiculo.getY());
		
	}	
	
	@Test
	public void testAfectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelCuatroXCuatro(){
		
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vector posicion = new Vector(0,0);

		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		int movimientos = vehiculo.getMovimientos()+ 3;
		
		cuatro.controlPolicial(vehiculo, 0.29);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testAfectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayotAlaDelCuatroXCuatro(){
		
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vector posicion = new Vector(0,0);
	
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		int movimientos = vehiculo.getMovimientos();
		
		cuatro.controlPolicial(vehiculo, 0.31);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
	}
}