package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.interfaces.Evento;
import modelo.juego.Juego;
import modelo.juego.Nivel;
import modelo.juego.Vector;
import modelo.obstaculo.Pozo;
import modelo.vehiculo.Auto;


import org.junit.Test;

import excepciones.MovimientoFueraDeMapaException;

public class JuegoTest {
	
	@Test
	public void testDeberiaCrearUnJuegoConVehiculoYaConUsuario(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		
		/*Act*/
		Juego juego = new Juego("Pepe",facil,auto);
		
		/* Assert */
		assertEquals("Pepe", juego.getUsuario());
		assertEquals(auto.getClass(), juego.getVehiculo().getEstado().getClass());
	}
	
	
//	Adaptarlo a persistencia por nivel
	@Test
	public void testDeberiaCrearUnJuegoConLimites() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		facil.setDificultad("facil");
		
		/*Act*/
		Juego juego = new Juego("Pepe",facil,auto);
		
		int limiteHorizontal = 0;
		int limiteVertical = 450;
		
		/* Assert */
		assertEquals( limiteHorizontal , juego.getLimiteHorizontal() );
		assertEquals( limiteVertical , juego.getLimiteVertical() );
	}

	
	@Test
	public void testDeberiaCrearUnJuegoConEventosYRankingVacio() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		
		/*Act*/
		Juego juego = new Juego("Pepe",facil,auto);
		
		/* Assert */
		assertEquals(0, juego.getEventos().size());
		assertEquals(0, juego.getRanking().getPuntajes().size());
	}
	
	@Test
	public void testDeberiaCrearUnJuegoConVehiculoConPosicion(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		
		/*Act*/
		Juego juego = new Juego("Pepe",facil,auto);
		
		/* Assert */
		assertEquals(0, juego.getVehiculo().getY());
		assertEquals(0, juego.getVehiculo().getX());
	}
	
	@Test
	public void testDeberiaAgregarEvento(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		Juego juego = new Juego("Pepe",facil,auto);
		Vector posicion = new Vector(1,2);
		Evento pozo = new Pozo(posicion);
		
		/* Act */
		juego.agregarEvento(pozo);
		
		/* Assert */
		assertEquals(1, juego.getEventos().size());
	}
	
	@Test 
	public void testDeberiaLlegarALaMeta() throws MovimientoFueraDeMapaException{
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		Juego juego = new Juego("Pepe",facil,auto);
	
		/* Act */
		juego.getVehiculo().setX(juego.getMeta().getX());
		juego.getVehiculo().setY(juego.getMeta().getY());
		
		/* Assert */
		assertTrue(juego.llegoALaMeta());
	}
	
	@Test
	public void testDeberiaDevolverLosMovimientosLimites(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		Juego juego = new Juego("Pepe",facil,auto);
		
		/* Assert */
		assertEquals(38,juego.movimientosLimites("Facil"));
		assertEquals(32,juego.movimientosLimites("Moderado"));
		assertEquals(25,juego.movimientosLimites("Dificil"));
	}
	
	@Test
	public void testDeberiaDevolverElMultiplicadorDePuntajeSegunLaDificultad(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		Juego juego = new Juego("Pepe",facil,auto);
		
		/* Assert */
		assertEquals(1,juego.puntajePorMovimiento("Facil"));
		assertEquals(2,juego.puntajePorMovimiento("Moderado"));
		assertEquals(3,juego.puntajePorMovimiento("Dificil"));
	}
	
}
