package fiuba.algo3.gpschallenge;

import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.interfaces.Evento;
import modelo.juego.Juego;
import modelo.juego.Vector;


import modelo.obstaculo.Pozo;
import modelo.vehiculo.Auto;

import org.junit.Test;

public class JuegoTest {
	
	
//	Adaptarlo a persistencia por nivel
	@Test
	public void testDeberiaCrearUnJuegoConLimite() {
		
		/* Arrange */
		int limiteHorizontal = 10;
		EstadoVehiculo auto = new Auto();
		Juego juego = Juego.crearJuego("Pepe",auto);
		
		/* Assert */
		Assert.assertEquals( limiteHorizontal , juego.getLimiteHorizontal() );
	}

	@Test
	public void testDeberiaCrearUnJuegoConEventosYRankingVacio() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Juego juego = Juego.crearJuego("Pepe",auto);
		
		/* Assert */
		Assert.assertEquals(0, juego.getEventos().size());
		Assert.assertEquals(0, juego.getRanking().getPuntajes().size());
	}
	
	@Test
	public void testDeberiaCrearUnJuegoConVehiculoYaConUsuario(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Juego juego = Juego.crearJuego("Pepe",auto);
		
		/* Assert */
		Assert.assertEquals("Pepe", juego.getUsuario());
		Assert.assertEquals(auto.getClass(), juego.getVehiculo().getEstado().getClass());
	}
	
//	Adaptarlo a persistencia por nivel
	@Test
	public void testDeberiaCrearUnJuegoConMetaEnPosicion(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Juego juego = Juego.crearJuego("Pepe",auto);		
		
		/* Assert */
		Assert.assertEquals(5, juego.getMeta().getY());
		Assert.assertEquals(10, juego.getMeta().getX());
	}

	@Test
	public void testDeberiaCrearUnJuegoConVehiculoConPosicion(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Juego juego = Juego.crearJuego("Pepe",auto);
		
		/* Assert */
		Assert.assertEquals(0, juego.getVehiculo().getY());
		Assert.assertEquals(0, juego.getVehiculo().getX());
	}
	
	@Test
	public void testDeberiaAgregarEvento(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Juego juego = Juego.crearJuego("Pepe",auto);
		Evento pozo = new Pozo();
		Vector posicion = new Vector(1,2);
		pozo.setPosicion(posicion);
		
		
		/* Act */
		juego.agregarEvento(pozo);
		
		/* Assert */
		Assert.assertEquals(1, juego.getEventos().size());
	}
	
	@Test 
	public void testDeberiaLlegarALaMeta(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Juego juego = Juego.crearJuego("Pepe",auto);
		
		/* Act */
		juego.getVehiculo().setX(juego.getLimiteHorizontal());
		juego.getVehiculo().setY(juego.getLimiteVertical()/2);
		
		
		/* Assert */
		Assert.assertEquals(juego.getVehiculo().getX(), juego.getMeta().getX());
		Assert.assertEquals(juego.getVehiculo().getY(), juego.getMeta().getY());
		
		Assert.assertTrue(juego.llegoALaMeta());
	}
	
}
