package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.Ranking;
import fiuba.algo3.gpschallenge.modelo.Vehiculo;

public class RankingTest {

	private Vehiculo vehiculo1;
	private Vehiculo vehiculo2;
	private Vehiculo vehiculo3;
	private Ranking ranking;
	private List<Vehiculo> puntajes;
	
	@Before
	public void setup() {
		vehiculo1 = Vehiculo.crearConPiloto("pepe","",0,0);
		vehiculo2 = Vehiculo.crearConPiloto("lucas","",1,0);
		vehiculo3 = Vehiculo.crearConPiloto("juan","",0,1);
		ranking = new Ranking();
	}
	
	@Test
	public void testAlCrearElRankingElMismoSeEncuentraVacio() {
		Ranking ranking = new Ranking();
		assertEquals(0,ranking.getPuntajes().size());
	}

	@Test
	public void testAgregarPuntajesAlRanking() {
		 ranking.agregarPuntaje(vehiculo1);
		assertEquals(1,ranking.getPuntajes().size());
		ranking.agregarPuntaje(vehiculo2);
		assertEquals(2,ranking.getPuntajes().size());
		ranking.agregarPuntaje(vehiculo3);
		assertEquals(3,ranking.getPuntajes().size());
	}

	@Test
	public void testObtenerPuntajesDelRankingOrdenadoDeMayorAMenor() {
		vehiculo1.setPuntaje(100);
		vehiculo2.setPuntaje(50);
		vehiculo3.setPuntaje(150);
		ranking.agregarPuntaje(vehiculo1);
		ranking.agregarPuntaje(vehiculo2);
		ranking.agregarPuntaje(vehiculo3);
		puntajes = ranking.getPuntajes();
		double puntajeMayor = puntajes.get(0).getPuntaje();
		double puntajeMedio = puntajes.get(1).getPuntaje();
		double puntajeMenor = puntajes.get(2).getPuntaje();
		assertEquals(150.0,puntajeMayor,1E-5);
		assertEquals(50.0,puntajeMenor,1E-5);
		assertEquals(100.0,puntajeMedio,1E-5);
	
	}

}
