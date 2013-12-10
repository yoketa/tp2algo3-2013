package Unitarias;

import static org.junit.Assert.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.obstaculo.Piquete;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;
import org.junit.Test;

public class PiqueteTest {

		@Test
		public void testConstructorPiqueteInizializaSuPosicionEnCeroCero(){
		
			/* Arrange */
			Piquete piquete = new Piquete();

			/* Assert*/
			assertEquals( 0, piquete.getX());	
			assertEquals( 0, piquete.getY());
		}
		
		@Test
		public void testgetXeYDeberiaDevolverSuPosicionEnXeY(){
		
			/* Arrange */
			Vector posicion = new Vector(4,4);
			Piquete piquete = new Piquete(posicion);

			/* Assert*/
			assertEquals( 4, piquete.getX());	
			assertEquals( 4, piquete.getY());
		}
		
		@Test
		public void testAfectarDeberiaAfectarUnVehiculoConUnPiquete(){
			
			/* Arrange */
			Piquete piquete = new Piquete();
			EstadoVehiculo auto = new Auto();
			Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
			
			/* Act */
			try {
				vehiculo.bajar();
				piquete.afectar(vehiculo);
				assertTrue(true);
			}
			catch (Exception ex) {
				fail();
			}	
		}

}

