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

import excepciones.MovimientoFueraDeMapaException;
import persistencia.Archivador;

public class RankingTest {

	
	private Vehiculo vehiculo1;
	private Vehiculo vehiculo2;
	private Vehiculo vehiculo3;
	private Vehiculo vehiculo4;
	private Vehiculo vehiculo5;
	private Ranking ranking;
	private List<Vehiculo> puntajes;
	private String pilotoAuto  = "Nico";
	private String pilotoMoto  = "Diego";
	private String pilotoCuatroXCuatro  = "Pablo";	
	private String pilotoAuto2  = "Juan";
	private String pilotoAuto3  = "Gabriel";
	
	private EstadoVehiculo estadoAuto = new Auto();
	private EstadoVehiculo estadoMoto = new Moto();
	private EstadoVehiculo estadoCuatroXCuatro = new CuatroXCuatro();
	
	@Before
	public void setup() {
		vehiculo1 =  Vehiculo.crearConPilotoYVehiculo(pilotoAuto,estadoAuto);
		vehiculo1.setPuntaje(50);
		vehiculo2 = Vehiculo.crearConPilotoYVehiculo(pilotoMoto,estadoMoto);
		vehiculo2.setPuntaje(85);
		vehiculo3 = Vehiculo.crearConPilotoYVehiculo(pilotoCuatroXCuatro,estadoCuatroXCuatro);
		vehiculo3.setPuntaje(90);
		vehiculo4 = Vehiculo.crearConPilotoYVehiculo(pilotoAuto2,estadoAuto);
		vehiculo4.setPuntaje(40);
		vehiculo5 = Vehiculo.crearConPilotoYVehiculo(pilotoAuto3,estadoAuto);
		vehiculo5.setPuntaje(24);
		ranking = new Ranking();
	}
	
	@Test
	public void testAlCrearElRankingElMismoSeEncuentraVacio() {
		Ranking ranking = new Ranking();
		assertEquals(0,ranking.getPuntajes().size());
	}

	@Test
	public void testAgregarPuntajesAlRanking() throws MovimientoFueraDeMapaException {
		 ranking.agregarPuntaje(vehiculo1);
		assertEquals(1,ranking.getPuntajes().size());
		ranking.agregarPuntaje(vehiculo2);
		assertEquals(2,ranking.getPuntajes().size());
		ranking.agregarPuntaje(vehiculo3);
		assertEquals(3,ranking.getPuntajes().size());
	}

	@Test
	public void testObtenerPuntajesDelRankingOrdenadoDeMayorAMenor() throws MovimientoFueraDeMapaException {
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
			Archivador.guardar(ranking, "persistenciaTest/Ranking.xml");
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}		
	}
	
	@Test
	public void testGuardarYCargarTodosLosPuntajes() throws MovimientoFueraDeMapaException {
		
		ranking.agregarPuntaje(vehiculo1);
		ranking.agregarPuntaje(vehiculo2);
		ranking.agregarPuntaje(vehiculo3);
		
		try {
			Archivador.guardar(ranking, "persistenciaTest/Ranking.xml");
			Ranking rankingRecargado = Archivador.cargar(new Ranking(), "persistenciaTest/Ranking.xml");
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
			
			assertEquals(puntajes.get(0).getX(), puntajesRecargados.get(0).getX(),1E-5);
			assertEquals(puntajes.get(1).getX(), puntajesRecargados.get(1).getX(),1E-5);
			assertEquals(puntajes.get(2).getX(), puntajesRecargados.get(2).getX(),1E-5);
			
			assertEquals(puntajes.get(0).getY(), puntajesRecargados.get(0).getY(),1E-5);
			assertEquals(puntajes.get(1).getY(), puntajesRecargados.get(1).getY(),1E-5);
			assertEquals(puntajes.get(2).getY(), puntajesRecargados.get(2).getY(),1E-5);
			
		}
		catch (Exception ex) {
			fail();
		}		
	}
	
	@Test
	public void testCrearRanking() throws MovimientoFueraDeMapaException {
		
		
		
		ranking.agregarPuntaje(vehiculo1);
		ranking.agregarPuntaje(vehiculo2);
		ranking.agregarPuntaje(vehiculo3);
		ranking.agregarPuntaje(vehiculo4);
		ranking.agregarPuntaje(vehiculo5);
		try {
			Archivador.guardar(ranking, "persistenciaTest/Ranking.xml");
			Ranking rankingRecargado = Archivador.cargar(new Ranking(), "persistenciaTest/Ranking.xml");
			List<Vehiculo> puntajesRecargados = rankingRecargado.getPuntajes();
			puntajes = ranking.getPuntajes();
			
			assertEquals(puntajes.size(), puntajesRecargados.size());				
			assertEquals(puntajes.get(0).getEstado().getClass(), puntajesRecargados.get(0).getEstado().getClass());
			assertEquals(puntajes.get(1).getEstado().getClass(), puntajesRecargados.get(1).getEstado().getClass());
			assertEquals(puntajes.get(2).getEstado().getClass(), puntajesRecargados.get(2).getEstado().getClass());
			assertEquals(puntajes.get(3).getEstado().getClass(), puntajesRecargados.get(3).getEstado().getClass());
			assertEquals(puntajes.get(4).getEstado().getClass(), puntajesRecargados.get(4).getEstado().getClass());
			
			assertEquals(puntajes.get(0).getPiloto(), puntajesRecargados.get(0).getPiloto());
			assertEquals(puntajes.get(1).getPiloto(), puntajesRecargados.get(1).getPiloto());
			assertEquals(puntajes.get(2).getPiloto(), puntajesRecargados.get(2).getPiloto());
			assertEquals(puntajes.get(3).getPiloto(), puntajesRecargados.get(3).getPiloto());
			assertEquals(puntajes.get(4).getPiloto(), puntajesRecargados.get(4).getPiloto());
			
			assertEquals(puntajes.get(0).getPuntaje(), puntajesRecargados.get(0).getPuntaje(),1E-5);
			assertEquals(puntajes.get(1).getPuntaje(), puntajesRecargados.get(1).getPuntaje(),1E-5);
			assertEquals(puntajes.get(2).getPuntaje(), puntajesRecargados.get(2).getPuntaje(),1E-5);
			assertEquals(puntajes.get(3).getPuntaje(), puntajesRecargados.get(3).getPuntaje(),1E-5);
			assertEquals(puntajes.get(4).getPuntaje(), puntajesRecargados.get(4).getPuntaje(),1E-5);
			
			assertEquals(puntajes.get(0).getX(), puntajesRecargados.get(0).getX(),1E-5);
			assertEquals(puntajes.get(1).getX(), puntajesRecargados.get(1).getX(),1E-5);
			assertEquals(puntajes.get(2).getX(), puntajesRecargados.get(2).getX(),1E-5);
			assertEquals(puntajes.get(3).getX(), puntajesRecargados.get(3).getX(),1E-5);
			assertEquals(puntajes.get(4).getX(), puntajesRecargados.get(4).getX(),1E-5);
			
			assertEquals(puntajes.get(0).getY(), puntajesRecargados.get(0).getY(),1E-5);
			assertEquals(puntajes.get(1).getY(), puntajesRecargados.get(1).getY(),1E-5);
			assertEquals(puntajes.get(2).getY(), puntajesRecargados.get(2).getY(),1E-5);
			assertEquals(puntajes.get(3).getY(), puntajesRecargados.get(3).getY(),1E-5);
			assertEquals(puntajes.get(4).getY(), puntajesRecargados.get(4).getY(),1E-5);
		}
		catch (Exception ex) {
			fail();
		}		
	}

}
