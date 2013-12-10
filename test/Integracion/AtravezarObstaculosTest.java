package Integracion;

import static org.junit.Assert.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.interfaces.Evento;
import modelo.juego.Juego;
import modelo.juego.Nivel;
import modelo.juego.Vector;
import modelo.obstaculo.ControlPolicial;
import modelo.obstaculo.Piquete;
import modelo.obstaculo.Pozo;
import modelo.probabilidades.Probabilidad;
import modelo.probabilidades.ProbabilidadFija;
import modelo.vehiculo.Auto;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Moto;

import org.junit.Test;

import excepciones.ValorDeProbabilidadInvalidoException;

public class AtravezarObstaculosTest {

	@Test
	public void testAtravezarObtaculosConAuto() throws ValorDeProbabilidadInvalidoException {
		
			EstadoVehiculo auto = new Auto();
			Nivel facil = new Nivel();
			Juego juego = new Juego("Pepe",facil,auto);
			int movimientos = 0;	
			
			/** Ante un piquete debe pegar la vuelta **/
			/* Arrange */
			Vector posicion = new Vector(40,0);
			Evento piquete = new Piquete (posicion);
			juego.agregarEvento(piquete);
			movimientos = 1;
			
			/* Act */
			juego.getVehiculo().derecha();
			juego.aplicarEvento();
	
	
			assertEquals( 0 , juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			
			/** Ante un pozo es penalizado con 3 movimientos **/
			/* Arrange */
			Vector posicion_1 = new Vector(0,40);
			Evento pozo = new Pozo (posicion_1);
			juego.agregarEvento(pozo);
			movimientos = 5;
			
			/* Act */
			juego.getVehiculo().bajar();
			juego.aplicarEvento();
			

			/* Assert*/
			assertEquals( 0 , juego.getVehiculo().getX() );
			assertEquals( 70, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			/**Ante un ControPolicial con probabilidad MENOR al Auto es penalizado con 3 movimientos**/
			/* Arrange */
			Probabilidad probabilidadMayor = new ProbabilidadFija(0.40);
			Vector posicion_2 = new Vector(40,70);
			Evento unControlPolicial = new ControlPolicial (posicion_2, probabilidadMayor);
			juego.agregarEvento(unControlPolicial);
			movimientos = 9;
		
			/* Act */
			juego.getVehiculo().derecha();
			juego.aplicarEvento();
			
			/* Assert*/
			assertEquals( 70 , juego.getVehiculo().getX() );
			assertEquals( 70, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			/**Ante un ControPolicial con probabilidad MAYOR al Auto avanza sin penalizacion**/
			/* Arrange */
			Probabilidad probabilidadMenor = new ProbabilidadFija(0.60);
			Vector posicion_3 = new Vector(70,40);
			Evento otroControlPolicial = new ControlPolicial (posicion_3, probabilidadMenor);
			juego.agregarEvento(otroControlPolicial);
			movimientos = 10;
		
			/* Act */
			juego.getVehiculo().subir();
			juego.aplicarEvento();
			
			/* Assert*/
			assertEquals( 70 , juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			/**Ante una cuadra sin Eventos solo suma el movimiento**/
			/* Arrange */
			movimientos = 11;
			
			/* Act */
			juego.getVehiculo().izquierda();
			juego.quitarEvento(piquete);
			juego.aplicarEvento();

			/* Assert*/
			assertEquals( 0 , juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
	}
	
	
	@Test
	public void testAtravezarObtaculosConCuatroXcuatro() throws ValorDeProbabilidadInvalidoException {
		
			EstadoVehiculo cuatro = new CuatroXCuatro();
			Nivel facil = new Nivel();
			Juego juego = new Juego("Pepe",facil,cuatro);
			int movimientos = 0;	
			
			/** Ante un piquete debe pegar la vuelta **/
			/* Arrange */
			Vector posicion = new Vector(40,0);
			Evento piquete = new Piquete (posicion);
			juego.agregarEvento(piquete);
			movimientos = 1;
			
			/* Act */
			juego.getVehiculo().derecha();
			juego.aplicarEvento();
	
	
			assertEquals( 0 , juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			
			/** Ante un pozo avanza sin penalizacion **/
			/* Arrange */
			Vector posicion_1 = new Vector(0,40);
			Evento pozo = new Pozo (posicion_1);
			juego.agregarEvento(pozo);
			movimientos = 2;
			
			/* Act */
			juego.getVehiculo().bajar();
			juego.aplicarEvento();
			

			/* Assert*/
			assertEquals( 0 , juego.getVehiculo().getX() );
			assertEquals( 70, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			
			/**Ante un ControPolicial con probabilidad MENOR a CuatroXCuatro es penalizado con 3 movimientos**/
			/* Arrange */
			Probabilidad probabilidadMayor = new ProbabilidadFija(0.20);
			Vector posicion_2 = new Vector(40,70);
			Evento unControlPolicial = new ControlPolicial (posicion_2, probabilidadMayor);
			juego.agregarEvento(unControlPolicial);
			movimientos = 6;
		
			/* Act */
			juego.getVehiculo().derecha();
			juego.aplicarEvento();
			
			/* Assert*/
			assertEquals( 70 , juego.getVehiculo().getX() );
			assertEquals( 70, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			/**Ante un ControPolicial con probabilidad MAYOR al Auto avanza sin penalizacion**/
			/* Arrange */
			Probabilidad probabilidadMenor = new ProbabilidadFija(0.60);
			Vector posicion_3 = new Vector(70,40);
			Evento otroControlPolicial = new ControlPolicial (posicion_3, probabilidadMenor);
			juego.agregarEvento(otroControlPolicial);
			movimientos = 7;
		
			/* Act */
			juego.getVehiculo().subir();
			juego.aplicarEvento();
			
			/* Assert*/
			assertEquals( 70 , juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			/**Ante una cuadra sin Eventos solo suma el movimiento**/
			/* Arrange */
			movimientos = 8;
			
			/* Act */
			juego.getVehiculo().izquierda();
			juego.quitarEvento(piquete);
			juego.aplicarEvento();

			/* Assert*/
			assertEquals( 0 , juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
	}
	
	@Test
	public void testAtravezarObtaculosConMoto() throws ValorDeProbabilidadInvalidoException {
		
			EstadoVehiculo moto = new Moto();
			Nivel facil = new Nivel();
			Juego juego = new Juego("Pepe",facil,moto);
			int movimientos = 0;	
			
			/** Ante un piquete pasa con una penalizacion de 2 movimientos **/
			/* Arrange */
			Vector posicion = new Vector(40,0);
			Evento piquete = new Piquete (posicion);
			juego.agregarEvento(piquete);
			movimientos = 3;
			
			/* Act */
			juego.getVehiculo().derecha();
			juego.aplicarEvento();
	
	
			assertEquals( 70, juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			
			/** Ante un pozo avanza con penalizacion de 3 movimientos**/
			/* Arrange */
			Vector posicion_1 = new Vector(110,0);
			Evento pozo = new Pozo (posicion_1);
			juego.agregarEvento(pozo);
			movimientos = 7;
			
			/* Act */
			juego.getVehiculo().derecha();
			juego.aplicarEvento();
			

			/* Assert*/
			assertEquals( 140 , juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			
			/**Ante un ControPolicial con probabilidad MENOR a Moto es penalizado con 3 movimientos**/
			/* Arrange */
			Probabilidad probabilidadMayor = new ProbabilidadFija(0.20);
			Vector posicion_2 = new Vector(140,40);
			Evento unControlPolicial = new ControlPolicial (posicion_2, probabilidadMayor);
			juego.agregarEvento(unControlPolicial);
			movimientos = 11;
		
			/* Act */
			juego.getVehiculo().bajar();
			juego.aplicarEvento();
			
			/* Assert*/
			assertEquals( 140 , juego.getVehiculo().getX() );
			assertEquals( 70, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			/**Ante un ControPolicial con probabilidad MAYOR a Moto avanza sin penalizacion**/
			/* Arrange */
			Probabilidad probabilidadMenor = new ProbabilidadFija(0.90);
			Vector posicion_3 = new Vector(110,70);
			Evento otroControlPolicial = new ControlPolicial (posicion_3, probabilidadMenor);
			juego.agregarEvento(otroControlPolicial);
			movimientos = 12;
		
			/* Act */
			juego.getVehiculo().izquierda();
			juego.aplicarEvento();
			
			/* Assert*/
			assertEquals( 70 , juego.getVehiculo().getX() );
			assertEquals( 70, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
			
			/**Ante una cuadra sin Eventos solo suma el movimiento**/
			/* Arrange */
			movimientos = 13;
			
			/* Act */
			juego.getVehiculo().subir();
			juego.aplicarEvento();

			/* Assert*/
			assertEquals( 70 , juego.getVehiculo().getX() );
			assertEquals( 0, juego.getVehiculo().getY() );
			assertEquals( movimientos , juego.getVehiculo().getMovimientos());
	}
}
			
			