package Integracion;

import static org.junit.Assert.assertEquals;
import modelo.interfaces.EstadoVehiculo;
import modelo.interfaces.Evento;
import modelo.juego.Juego;
import modelo.juego.Nivel;
import modelo.juego.Vector;
import modelo.sorpresas.CambioDeVehiculo;
import modelo.sorpresas.SorpresaDesfavorable;
import modelo.sorpresas.SorpresaFavorable;
import modelo.vehiculo.Auto;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Moto;

import org.junit.Test;

public class AtravezarSorpresas {
	
	@Test
	public void testAtravezarSorpresasConAuto() {
		
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		Juego juego = new Juego("Pepe",facil,auto);
		int movimientos = 0;	
			
		/** Ante una Sorpresa Favorable resta la parte "entera" del 20% de los movimientos hechos**/
		/** En este caso debe no resta nada**/
		/* Arrange */
		Vector posicion = new Vector(40,0);
		Evento sor_Favorable = new SorpresaFavorable (posicion);
		juego.agregarEvento(sor_Favorable);
		movimientos = 1;
			
		/* Act */
		juego.getVehiculo().derecha();//movimiento 1
		juego.aplicarEvento();
	
		assertEquals( 70 , juego.getVehiculo().getX() );
		assertEquals( 0, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			
		/** En este caso debe restar 1**/
		/* Arrange */
		Vector posicion_1 = new Vector(110,140);
		Evento sor_Favorable_1 = new SorpresaFavorable (posicion_1);
		juego.agregarEvento(sor_Favorable_1);
		movimientos = 4;
			
		/* Act */
			
		juego.getVehiculo().derecha(); //movimiento 2
		juego.aplicarEvento();
		juego.getVehiculo().bajar();//movimiento 3
		juego.aplicarEvento();
		juego.getVehiculo().bajar();//movimiento 4
		juego.aplicarEvento();
		juego.getVehiculo().izquierda();//movimiento 5
		juego.aplicarEvento();
	
		assertEquals( 70 , juego.getVehiculo().getX() );
		assertEquals(140, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());	
			
		/** Ante una Sorpresa Desfavorable suma la parte "entera" del 25% de los movimientos hechos**/
		/** En este caso debe no resta nada**/
		/* Arrange */
		Vector posicion_2 = new Vector(70,180);
		Evento sor_Desfavorable = new SorpresaDesfavorable (posicion_2);
		juego.agregarEvento(sor_Desfavorable);
		movimientos = 6;
			
		/* Act */
		juego.getVehiculo().bajar();//movimiento 5
		juego.aplicarEvento();
	
	
		assertEquals( 70 , juego.getVehiculo().getX() );
		assertEquals( 210, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
		/** Ante una Sorpresa CambioDeVehiculo se convierte en una CuatroXcuatro**/
		/** En este caso debe no resta nada**/
			
		/* Arrange */
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vector posicion_3 = new Vector(40,210);
		Evento sor_Cambio = new CambioDeVehiculo (posicion_3);
		juego.agregarEvento(sor_Cambio);
		movimientos = 7;
			
		/* Act */
		juego.getVehiculo().izquierda();//movimiento 7
		juego.aplicarEvento();
	
		assertEquals( 0 , juego.getVehiculo().getX() );
		assertEquals( 210, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
		assertEquals( cuatro.getClass() , juego.getVehiculo().getEstado().getClass());
			
	}
	
	@Test
	public void testAtravezarSorpresasConMoto() {
		
		EstadoVehiculo moto = new Moto();
		Nivel facil = new Nivel();
		Juego juego = new Juego("Pepe",facil,moto);
		int movimientos = 0;	
		
		/** Ante una Sorpresa Favorable resta la parte "entera" del 20% de los movimientos hechos**/
		/** En este caso debe no resta nada**/
		/* Arrange */
		Vector posicion = new Vector(40,0);
		Evento sor_Favorable = new SorpresaFavorable (posicion);
		juego.agregarEvento(sor_Favorable);
		movimientos = 1;
		
		/* Act */
		juego.getVehiculo().derecha();//movimiento 1
		juego.aplicarEvento();


		assertEquals( 70 , juego.getVehiculo().getX() );
		assertEquals( 0, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
		
		
		/** En este caso debe restar 1**/
		/* Arrange */
		Vector posicion_1 = new Vector(110,140);
		Evento sor_Favorable_1 = new SorpresaFavorable (posicion_1);
		juego.agregarEvento(sor_Favorable_1);
		movimientos = 4;
		
		/* Act */
		
		juego.getVehiculo().derecha(); //movimiento 2
		juego.aplicarEvento();
		juego.getVehiculo().bajar();//movimiento 3
		juego.aplicarEvento();
		juego.getVehiculo().bajar();//movimiento 4
		juego.aplicarEvento();
		juego.getVehiculo().izquierda();//movimiento 5
		juego.aplicarEvento();


		assertEquals( 70 , juego.getVehiculo().getX() );
		assertEquals(140, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
		
		
		/** Ante una Sorpresa Desfavorable suma la parte "entera" del 25% de los movimientos hechos**/
		/** En este caso debe no resta nada**/
		/* Arrange */
		Vector posicion_2 = new Vector(70,180);
		Evento sor_Desfavorable = new SorpresaDesfavorable (posicion_2);
		juego.agregarEvento(sor_Desfavorable);
		movimientos = 6;
		
		/* Act */
		juego.getVehiculo().bajar();//movimiento 5
		juego.aplicarEvento();


		assertEquals( 70 , juego.getVehiculo().getX() );
		assertEquals( 210, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
		
		/** Ante una Sorpresa CambioDeVehiculo se convierte en una CuatroXcuatro**/
		/** En este caso debe no resta nada**/
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vector posicion_3 = new Vector(40,210);
		Evento sor_Cambio = new CambioDeVehiculo (posicion_3);
		juego.agregarEvento(sor_Cambio);
		movimientos = 7;
		
		/* Act */
		juego.getVehiculo().izquierda();//movimiento 7
		juego.aplicarEvento();


		assertEquals( 0 , juego.getVehiculo().getX() );
		assertEquals( 210, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
		assertEquals( auto.getClass() , juego.getVehiculo().getEstado().getClass());
	}	
	
	@Test
	public void testAtravezarSorpresasConCuatroXCuatro() {
		
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Nivel facil = new Nivel();
		Juego juego = new Juego("Pepe",facil,cuatro);
		int movimientos = 0;	
		
		/** Ante una Sorpresa Favorable resta la parte "entera" del 20% de los movimientos hechos**/
		/** En este caso debe no resta nada**/
		/* Arrange */
		Vector posicion = new Vector(40,0);
		Evento sor_Favorable = new SorpresaFavorable (posicion);
		juego.agregarEvento(sor_Favorable);
		movimientos = 1;
		
		/* Act */
		juego.getVehiculo().derecha();//movimiento 1
		juego.aplicarEvento();


		assertEquals( 70 , juego.getVehiculo().getX() );
		assertEquals( 0, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
		
		
		/** En este caso debe restar 1**/
		/* Arrange */
		Vector posicion_1 = new Vector(110,140);
		Evento sor_Favorable_1 = new SorpresaFavorable (posicion_1);
		juego.agregarEvento(sor_Favorable_1);
		movimientos = 4;
		
		/* Act */
		
		juego.getVehiculo().derecha(); //movimiento 2
		juego.aplicarEvento();
		juego.getVehiculo().bajar();//movimiento 3
		juego.aplicarEvento();
		juego.getVehiculo().bajar();//movimiento 4
		juego.aplicarEvento();
		juego.getVehiculo().izquierda();//movimiento 5
		juego.aplicarEvento();


		assertEquals( 70 , juego.getVehiculo().getX() );
		assertEquals(140, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
		
		
		/** Ante una Sorpresa Desfavorable suma la parte "entera" del 25% de los movimientos hechos**/
		/** En este caso debe no resta nada**/
		/* Arrange */
		Vector posicion_2 = new Vector(70,180);
		Evento sor_Desfavorable = new SorpresaDesfavorable (posicion_2);
		juego.agregarEvento(sor_Desfavorable);
		movimientos = 6;
		
		/* Act */
		juego.getVehiculo().bajar();//movimiento 5
		juego.aplicarEvento();


		assertEquals( 70 , juego.getVehiculo().getX() );
		assertEquals( 210, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
		
		/** Ante una Sorpresa CambioDeVehiculo se convierte en una CuatroXcuatro**/
		/** En este caso debe no resta nada**/
		
		/* Arrange */
		EstadoVehiculo moto = new Moto();
		Vector posicion_3 = new Vector(40,210);
		Evento sor_Cambio = new CambioDeVehiculo (posicion_3);
		juego.agregarEvento(sor_Cambio);
		movimientos = 7;
		
		/* Act */
		juego.getVehiculo().izquierda();//movimiento 7
		juego.aplicarEvento();


		assertEquals( 0 , juego.getVehiculo().getX() );
		assertEquals( 210, juego.getVehiculo().getY() );
		assertEquals( movimientos , juego.getVehiculo().getMovimientos());
		assertEquals( moto.getClass() , juego.getVehiculo().getEstado().getClass());
	}	

}
