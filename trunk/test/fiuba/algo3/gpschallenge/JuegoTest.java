package fiuba.algo3.gpschallenge;

import junit.framework.Assert;
import modelo.interfaces.Evento;
import modelo.juego.Juego;
import modelo.juego.Vector;


import modelo.obstaculo.Pozo;

import org.junit.Test;

public class JuegoTest {

	@Test
	public void testDeberiaCrearUnJuegoConLimite() {
		int limiteHorizontal = 10;
		Juego juego = Juego.crearJuegoConUsuario("Pepe");
		Assert.assertEquals( limiteHorizontal , juego.getLimiteHorizontal() );
	}

	@Test
	public void testDeberiaCrearUnJuegoConEventosYRankingVacio() {
		Juego juego = Juego.crearJuegoConUsuario("Pepe");
		Assert.assertEquals(0, juego.getEventos().size());
		Assert.assertEquals(0, juego.getRanking().getPuntajes().size());
	}
	
	@Test
	public void testDeberiaCrearUnJuegoConVehiculoYaConUsuario(){
		Juego juego = Juego.crearJuegoConUsuario("Pepe");
		Assert.assertEquals("Pepe", juego.getUsuario());
	}
	
	@Test
	public void testDeberiaCrearUnJuegoConMetaEnPosicion(){
		Juego juego = Juego.crearJuegoConUsuario("Pepe");
		Assert.assertEquals(5, juego.getMeta().getY());
		Assert.assertEquals(10, juego.getMeta().getX());
	}

	@Test
	public void testDeberiaCrearUnJuegoConVehiculoConPosicion(){
		Juego juego = Juego.crearJuegoConUsuario("Pepe");
		Assert.assertEquals(5, juego.getVehiculo().getY());
		Assert.assertEquals(1, juego.getVehiculo().getX());
	}
	
	@Test
	public void testDeberiaAgregarEvento(){
		Juego juego = Juego.crearJuegoConUsuario("Pepe");
		Evento pozo = new Pozo();
		Vector posicion = new Vector(1,2);
		pozo.setPosicion(posicion);
		
		juego.agregarEvento(pozo);
		
		Assert.assertEquals(1, juego.getEventos().size());
	}
	
	@Test
	public void testDeberiaHaberEvento(){
		Juego juego = Juego.crearJuegoConUsuario("Pepe");
		Evento pozo = new Pozo();
		Vector posicion = new Vector(1,2);
		pozo.setPosicion(posicion);
		
		juego.agregarEvento(pozo);

		Assert.assertTrue(juego.hayEvento(posicion));
	}
	
}
