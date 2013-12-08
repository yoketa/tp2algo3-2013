package Unitarias;

import static org.junit.Assert.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Vehiculo;
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
}
			
			