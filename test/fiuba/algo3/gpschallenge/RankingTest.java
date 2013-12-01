package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;

import java.util.List;

import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Ranking;
import modelo.vehiculo.Auto;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Before;
import org.junit.Test;

import persistencia.Archivador;

public class RankingTest {

	
	private Vehiculo vehiculo1;
	private Vehiculo vehiculo2;
	private Vehiculo vehiculo3;
	private Ranking ranking;
	private List<Vehiculo> puntajes;
	private String pilotoAuto  = "pepe";
	private String pilotoMoto  = "juan";
	private String pilotoCuatroXCuatro  = "luis";	
	private EstadoVehiculo estadoAuto = new Auto();
	private EstadoVehiculo estadoMoto = new Moto();
	private EstadoVehiculo estadoCuatroXCuatro = new CuatroXCuatro();
	
	@Before
	public void setup() {
		vehiculo1 =  Vehiculo.crearConPiloto(pilotoAuto,estadoAuto,2,3);
		vehiculo1.setPuntaje(50);
		vehiculo2 = Vehiculo.crearConPiloto(pilotoMoto,estadoMoto, 1, 2);
		vehiculo2.setPuntaje(85);
		vehiculo3 = Vehiculo.crearConPiloto(pilotoCuatroXCuatro,estadoCuatroXCuatro, 4, 2);
		vehiculo3.setPuntaje(90);
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
	
	@Test
	public void testPersistenciaRanking() {
		try {
			Archivador.guardar(ranking, Ranking.rankingPath);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}		
	}
	
	@Test
	public void testGuardarYCargarTodosLosPuntajes() {
		
		ranking.agregarPuntaje(vehiculo1);
		ranking.agregarPuntaje(vehiculo2);
		ranking.agregarPuntaje(vehiculo3);
		
		try {
			Archivador.guardar(ranking, Ranking.rankingPath);
			Ranking rankingRecargado = Archivador.cargar(new Ranking(), Ranking.rankingPath);
			List<Vehiculo> puntajesRecargados = rankingRecargado.getPuntajes();
			puntajes = ranking.getPuntajes();
			
			assertEquals(puntajes.size(), puntajesRecargados.size());				
			assertEquals(puntajes.get(0).getEstado().getClass(), puntajesRecargados.get(0).getEstado().getClass());
			assertEquals(puntajes.get(1).getEstado().getClass(), puntajesRecargados.get(1).getEstado().getClass());
			assertEquals(puntajes.get(2).getEstado().getClass(), puntajesRecargados.get(2).getEstado().getClass());
		
			assertEquals(puntajes.get(0).getPiloto(), puntajesRecargados.get(0).getPiloto());
			assertEquals(puntajes.get(1).getPiloto(), puntajesRecargados.get(1).getPiloto());
			assertEquals(puntajes.get(2).getPiloto(), puntajesRecargados.get(2).getPiloto());
			
			assertEquals(puntajes.get(0).getPuntaje(), puntajesRecargados.get(0).getPuntaje(),1E-5);
			assertEquals(puntajes.get(1).getPuntaje(), puntajesRecargados.get(1).getPuntaje(),1E-5);
			assertEquals(puntajes.get(2).getPuntaje(), puntajesRecargados.get(2).getPuntaje(),1E-5);
			
			assertEquals(puntajes.get(0).getPosicionHorizontal(), puntajesRecargados.get(0).getPosicionHorizontal(),1E-5);
			assertEquals(puntajes.get(1).getPosicionHorizontal(), puntajesRecargados.get(1).getPosicionHorizontal(),1E-5);
			assertEquals(puntajes.get(2).getPosicionHorizontal(), puntajesRecargados.get(2).getPosicionHorizontal(),1E-5);
			
			assertEquals(puntajes.get(0).getPosicionVertical(), puntajesRecargados.get(0).getPosicionVertical(),1E-5);
			assertEquals(puntajes.get(1).getPosicionVertical(), puntajesRecargados.get(1).getPosicionVertical(),1E-5);
			assertEquals(puntajes.get(2).getPosicionVertical(), puntajesRecargados.get(2).getPosicionVertical(),1E-5);
			
		}
		catch (Exception ex) {
			fail();
		}		
	}
	

}
