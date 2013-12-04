package fiuba.algo3.gpschallenge;

import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.interfaces.Evento;
import modelo.juego.Juego;
import modelo.juego.Vector;


import modelo.obstaculo.Pozo;
import modelo.vehiculo.Auto;

import org.junit.Test;

import controladores.Nivel;
import excepciones.MovimientoFueraDeMapaException;

public class JuegoTest {
	
	
//	Adaptarlo a persistencia por nivel
	@Test
	public void testDeberiaCrearUnJuegoConLimite() {
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Nivel facil = new Nivel();
		facil.setDificultad("facil");
		Juego juego = new Juego("Pepe",facil,auto);
		
		int limiteHorizontal = 0;
		int limiteVertical = 450;
		
		/* Assert */
		Assert.assertEquals( limiteHorizontal , juego.getLimiteHorizontal() );
		Assert.assertEquals( limiteVertical , juego.getLimiteVertical() );
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
	public void testDeberiaLlegarALaMeta() throws MovimientoFueraDeMapaException{
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Juego juego = Juego.crearJuego("Pepe",auto);
		
		/* Act */
		juego.getVehiculo().setX(juego.getMeta().getX());
		juego.getVehiculo().setY(juego.getMeta().getY());
		
		
		/* Assert */
		Assert.assertTrue(juego.llegoALaMeta());
	}
	
}
