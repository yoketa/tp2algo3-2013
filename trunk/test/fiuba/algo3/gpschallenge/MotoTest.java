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

public class MotoTest {

	@Test
	public void testpasaPorPozoDeberiaSumarTresMovimientosAUnaMoto() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		int movimientos = 3;
		
		/* Act */
		moto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(movimientos, vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPozoDeberiaSumarPuntos() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		double puntaje = 30;
		
		/* Act */
		moto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(puntaje, vehiculo.getPuntaje());
	}
	
	@Test
	public void testPuiqueteDebePenalizarConDosMovimientos() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		int movimientos = vehiculo.getMovimientos()+ 2;
		
		/* Act */
		moto.piquete(vehiculo);
		
		/* Assert*/
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());
	}
	
	@Test
	public void testpasaPorPiqueteDeberiaSumarPuntos() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		double puntaje = 50;
		
		/* Act */
		moto.piquete(vehiculo);
		
		/* Assert*/
		Assert.assertEquals(puntaje, vehiculo.getPuntaje());
	}
	
	@Test
	public void testpasaPorPozoDeberiaMoverEnLaDireccionDelVehiculo() {
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		vehiculo.subir();
		
		/* Act */
		moto.pasaPorPozo(vehiculo);
		
		/* Assert*/
		Assert.assertEquals( 0 , vehiculo.getX());
		Assert.assertEquals( 2 , vehiculo.getY());
		
	}
	
	@Test
	public void testafectarDeberiaSumarTresPenalizacionessSiLaProbabilidadDelControlPolicialEsMenorAlaDelaMoto(){
	
		EstadoVehiculo moto = new Moto();
		Vector posicion = new Vector(0,0);

		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		int movimientos = vehiculo.getMovimientos()+ 3;
		
		moto.controlPolicial(vehiculo, 0.79);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
		}
	
	@Test
	public void testafectarNoDeberiaSumarTresPenalizacionessSiLaProbabilidadDelControlPolicialEsMayorAlaDelaMoto(){
	
		EstadoVehiculo moto = new Moto();
		Vector posicion = new Vector(0,0);

		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		int movimientos = vehiculo.getMovimientos();
		
		moto.controlPolicial(vehiculo, 0.81);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
		}

}
