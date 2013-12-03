package Integracion;

import static org.junit.Assert.*;
import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.interfaces.Evento;
import modelo.juego.Juego;
import modelo.juego.Vector;
import modelo.obstaculo.Piquete;
import modelo.obstaculo.Pozo;
import modelo.vehiculo.Auto;

import org.junit.Test;

public class IntegracionTest {

	@Test
	public void testAtravezarObtaculosConAuto() {
		
			EstadoVehiculo auto = new Auto();
			Juego juego = new Juego ("Pepe",auto);
			int movimientos = 0;	
			
			/** Ante un piquete no avanza **/
			
			Vector posicion = new Vector(40,0);
			Evento piquete = new Piquete (posicion);
			
			juego.agregarEvento(piquete);
			
			juego.getVehiculo().derecha();
			juego.aplicarEvento();
			
			movimientos = 1;
			
			assertEquals( 0 , juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			Assert.assertEquals( movimientos , juego.getVehiculo().getMovimientos());
	}
}
			
			