package fiuba.algo3.gpschallenge;

import fiuba.algo3.gpschallenge.modelo.Juego;

import junit.framework.Assert;
import org.junit.Test;

public class JuegoTest {

	@Test
	public void testDeberiaCrearUnJuegoConLimite() {
		int limiteHorizontal = 10;
		Juego juego = Juego.crearJuego();
		Assert.assertEquals( limiteHorizontal , juego.getLimiteHorizontal() );
	}

	@Test
	public void testDeberiaCrearUnJuegoConEventosYRankingVacio() {
		Juego juego = Juego.crearJuego();
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
		Assert.assertEquals(5, juego.getMeta().getPosicionVertical());
		Assert.assertEquals(10, juego.getMeta().getPosicionHorizontal());
	}
}
