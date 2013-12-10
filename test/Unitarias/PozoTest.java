package Unitarias;

import static org.junit.Assert.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.obstaculo.Pozo;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class PozoTest {

		@Test
		public void testConstructorPozoInizializaSuPosicionEnCeroCero(){
		
			/* Arrange */
			Pozo pozo = new Pozo();

			/* Assert*/
			assertEquals( 0, pozo.getX());	
			assertEquals( 0, pozo.getY());
		}
		
		@Test
		public void testgetXeYDeberiaDevolverSuPosicionEnXeY(){
		
			/* Arrange */
			Vector posicion = new Vector(4,4);
			Pozo pozo = new Pozo(posicion);

			/* Assert*/
			assertEquals( 4, pozo.getX());	
			assertEquals( 4, pozo.getY());
		}
		
		@Test
		public void testAfectarDeberiaAfectarUnVehiculoConUnPozo(){
			
			/* Arrange */
			Pozo pozo = new Pozo();
			EstadoVehiculo auto = new Auto();
			Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
			
			/* Act */
			try {
				vehiculo.bajar();
				pozo.afectar(vehiculo);
				assertTrue(true);
			}
			catch (Exception ex) {
				fail();
			}	
		}

}