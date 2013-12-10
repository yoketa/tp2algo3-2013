package Unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import modelo.juego.Nivel;
import modelo.juego.Vector;
import modelo.obstaculo.ControlPolicial;
import modelo.obstaculo.Obstaculo;
import modelo.obstaculo.Piquete;
import modelo.obstaculo.Pozo;
import modelo.probabilidades.ProbabilidadEquiprobable;
import modelo.sorpresas.CambioDeVehiculo;
import modelo.sorpresas.Sorpresa;
import modelo.sorpresas.SorpresaDesfavorable;
import modelo.sorpresas.SorpresaFavorable;

import org.junit.Before;
import org.junit.Test;

import excepciones.ValorDeProbabilidadInvalidoException;
import persistencia.Archivador;

public class NivelTest {

	private Sorpresa sorpresa1;
	private Sorpresa sorpresa2;
	private Sorpresa sorpresa3;
	private Sorpresa sorpresa4;
	private Sorpresa sorpresa5;
	private Sorpresa sorpresa6;
	private Sorpresa sorpresa7;
	private Sorpresa sorpresa8;
	private Sorpresa sorpresa9;
	private Sorpresa sorpresa10;
	private Sorpresa sorpresa11;
	private Sorpresa sorpresa12;
	
	private Obstaculo obstaculo1;
	private Obstaculo obstaculo2;
	private Obstaculo obstaculo3;
	private Obstaculo obstaculo4;
	private Obstaculo obstaculo5;
	private Obstaculo obstaculo6;
	private Obstaculo obstaculo7;
	private Obstaculo obstaculo8;
	private Obstaculo obstaculo9;
	private Obstaculo obstaculo10;
	private Obstaculo obstaculo11;
	private Obstaculo obstaculo12;
	private Obstaculo obstaculo13;
	private Obstaculo obstaculo14;
	private Obstaculo obstaculo15;
	private List<Sorpresa> sorpresas;
	private List<Obstaculo> obstaculos;
	private Nivel nivel;
	
	@Before
	public void setup() throws ValorDeProbabilidadInvalidoException {
		sorpresa1 = new SorpresaDesfavorable(new Vector(70,320));
		sorpresa2 = new SorpresaDesfavorable(new Vector(740,0));
		sorpresa3 = new SorpresaFavorable(new Vector(530,280));
		sorpresa4 = new SorpresaFavorable(new Vector(250,350));
		sorpresa5 = new CambioDeVehiculo(new Vector(250,0));
		sorpresa6 = new CambioDeVehiculo(new Vector(110,140));
		sorpresa7 = new SorpresaDesfavorable(new Vector(320,70));
		sorpresa8 = new SorpresaDesfavorable(new Vector(740,350));
		sorpresa9 = new SorpresaDesfavorable(new Vector(670,210));
		sorpresa10 = new SorpresaFavorable(new Vector(880,420));
		sorpresa11 = new SorpresaDesfavorable(new Vector(0,180));
		sorpresa12 = new SorpresaFavorable(new Vector(180,70));
		ProbabilidadEquiprobable proba = new ProbabilidadEquiprobable();
		
		obstaculo1 = new Pozo (new Vector(180,210));
		obstaculo2 = new Pozo (new Vector(460,210));
		obstaculo3 = new Piquete (new Vector(110,0));
		obstaculo4 = new ControlPolicial(new Vector(420,180),proba) ;
		obstaculo5 = new Piquete (new Vector(280,250));
		obstaculo6 = new ControlPolicial (new Vector(670,140),proba);
		obstaculo7 = new ControlPolicial (new Vector(460,70),proba);
		obstaculo8 = new Pozo (new Vector(390,420));
		obstaculo9 = new Piquete (new Vector(810,70));
		obstaculo10 = new Piquete (new Vector(810,280));
		obstaculo11 = new Piquete (new Vector(530,70));
		obstaculo12 = new Piquete (new Vector(250,140));
		obstaculo13 = new ControlPolicial (new Vector(320,70),proba);
		obstaculo14 = new ControlPolicial (new Vector(390,280),proba);
		obstaculo15 = new Piquete (new Vector(180,420));
		nivel = new Nivel();
	}
	
	@Test
	public void testAlCrearElNivelElMismoSeEncuentraVacio() {
		Nivel nivel = new Nivel();
		assertEquals(0,nivel.getSorpresas().size());
		assertEquals(0,nivel.getObstaculos().size());
	}

	@Test
	public void testAgregarSorpresasAlNivel() {
		 nivel.agregarUnaSorpresa(sorpresa1);
		assertEquals(1,nivel.getSorpresas().size());
		nivel.agregarUnaSorpresa(sorpresa2);
		assertEquals(2,nivel.getSorpresas().size());
		nivel.agregarUnaSorpresa(sorpresa3);
		assertEquals(3,nivel.getSorpresas().size());
		nivel.agregarUnaSorpresa(sorpresa4);
		assertEquals(4,nivel.getSorpresas().size());
	}

	@Test
	public void testAgregarObstaculosAlNivel() {
		 nivel.agregarUnObstaculo(obstaculo1);
		assertEquals(1,nivel.getObstaculos().size());
		nivel.agregarUnObstaculo(obstaculo2);
		assertEquals(2,nivel.getObstaculos().size());
		nivel.agregarUnObstaculo(obstaculo3);
		assertEquals(3,nivel.getObstaculos().size());
		nivel.agregarUnObstaculo(obstaculo4);
		assertEquals(4,nivel.getObstaculos().size());
	}

	
	@Test
	public void testObtenerSorpresasDelNivel() {
		nivel.agregarUnaSorpresa(sorpresa1);
		nivel.agregarUnaSorpresa(sorpresa2);
		nivel.agregarUnaSorpresa(sorpresa3);
		nivel.agregarUnaSorpresa(sorpresa4);
		sorpresas = nivel.getSorpresas();
		Vector posicionSopresa1 = sorpresas.get(0).getPosicion();
		Vector posicionSopresa2 = sorpresas.get(1).getPosicion();
		Vector posicionSopresa3 = sorpresas.get(2).getPosicion();
		Vector posicionSopresa4 = sorpresas.get(3).getPosicion();
		
		assertEquals(posicionSopresa1.getX(),70,1E-5);
		assertEquals(posicionSopresa1.getY(),320,1E-5);
		assertEquals(posicionSopresa2.getX(),740,1E-5);
		assertEquals(posicionSopresa2.getY(),0,1E-5);
		assertEquals(posicionSopresa3.getX(),530,1E-5);
		assertEquals(posicionSopresa3.getY(),280,1E-5);
		assertEquals(posicionSopresa4.getX(),250,1E-5);
		assertEquals(posicionSopresa4.getY(),350,1E-5);
	}
	
	
	@Test
	public void testObtenerObstaculosDelNivel() {
		nivel.agregarUnObstaculo(obstaculo1);
		nivel.agregarUnObstaculo(obstaculo2);
		nivel.agregarUnObstaculo(obstaculo3);
		nivel.agregarUnObstaculo(obstaculo4);
		obstaculos = nivel.getObstaculos();
		Vector posicionObstaculo1 = obstaculos.get(0).getPosicion();
		Vector posicionObstaculo2 = obstaculos.get(1).getPosicion();
		Vector posicionObstaculo3 = obstaculos.get(2).getPosicion();
		Vector posicionObstaculo4 = obstaculos.get(3).getPosicion();
		
		assertEquals(posicionObstaculo1.getX(),180,1E-5);
		assertEquals(posicionObstaculo1.getY(),210,1E-5);
		assertEquals(posicionObstaculo2.getX(),460,1E-5);
		assertEquals(posicionObstaculo2.getY(),210,1E-5);
		assertEquals(posicionObstaculo3.getX(),110,1E-5);
		assertEquals(posicionObstaculo3.getY(),0,1E-5);
		assertEquals(posicionObstaculo4.getX(),420,1E-5);
		assertEquals(posicionObstaculo4.getY(),180,1E-5);
	}
	
	
	
	@Test
	public void testPersistenciaNivel() {
		try {
			Archivador.guardar(nivel, Nivel.nivelPath);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}		
	}
	
	@Test
	public void testGuardarYCargarSorpresas() {
		Nivel nivel = new Nivel();
		nivel.agregarUnaSorpresa(sorpresa1);
		nivel.agregarUnaSorpresa(sorpresa2);
		nivel.agregarUnaSorpresa(sorpresa3);
		nivel.agregarUnaSorpresa(sorpresa4);
		try {
			Archivador.guardar(nivel, Nivel.nivelSorpresaPath);
			Nivel nivelRecargado = Archivador.cargar(new Nivel(), Nivel.nivelSorpresaPath);
			List<Sorpresa> sorpresasRecargadas = nivelRecargado.getSorpresas();
			sorpresas = nivel.getSorpresas();
			
		assertEquals(sorpresas.size(), sorpresasRecargadas.size());			
		assertEquals(sorpresas.get(0).getClass(), sorpresasRecargadas.get(0).getClass());
		assertEquals(sorpresas.get(1).getClass(), sorpresasRecargadas.get(1).getClass());
		assertEquals(sorpresas.get(2).getClass(), sorpresasRecargadas.get(2).getClass());
		assertEquals(sorpresas.get(3).getClass(), sorpresasRecargadas.get(3).getClass());
		
		}
		catch (Exception ex) {
			fail();
		}		
	}


	@Test
	public void testGuardarYCargarObstaculos() {
		Nivel nivel = new Nivel();
		nivel.agregarUnObstaculo(obstaculo1);
		nivel.agregarUnObstaculo(obstaculo2);
		nivel.agregarUnObstaculo(obstaculo3);
		nivel.agregarUnObstaculo(obstaculo4);
		try {
			Archivador.guardar(nivel, Nivel.nivelObstaculoPath);
			Nivel nivelRecargado = Archivador.cargar(new Nivel(), Nivel.nivelObstaculoPath);
			List<Obstaculo> obstaculosRecargados = nivelRecargado.getObstaculos();
			obstaculos = nivel.getObstaculos();
			
			assertEquals(obstaculos.size(), obstaculosRecargados.size());			
			assertEquals(obstaculos.get(0).getClass(), obstaculosRecargados.get(0).getClass());
			assertEquals(obstaculos.get(1).getClass(), obstaculosRecargados.get(1).getClass());
			assertEquals(obstaculos.get(2).getClass(), obstaculosRecargados.get(2).getClass());
			assertEquals(obstaculos.get(3).getClass(), obstaculosRecargados.get(3).getClass());
			
		}
		catch (Exception ex) {
			fail();
		}		
	}
	
	@Test
	public void testGuardarYCargarNivelFacil() {
		Nivel nivel = new Nivel();
		nivel.agregarUnObstaculo(obstaculo1);
		nivel.agregarUnObstaculo(obstaculo12);
		nivel.agregarUnObstaculo(obstaculo3);
		nivel.agregarUnObstaculo(obstaculo13);
		nivel.agregarUnObstaculo(obstaculo14);
		nivel.agregarUnObstaculo(obstaculo15);
		
		nivel.agregarUnaSorpresa(sorpresa1);
		nivel.agregarUnaSorpresa(sorpresa11);
		nivel.agregarUnaSorpresa(sorpresa4);
		nivel.agregarUnaSorpresa(sorpresa5);
		nivel.agregarUnaSorpresa(sorpresa6);
		nivel.agregarUnaSorpresa(sorpresa12);
		
		try {
			Archivador.guardar(nivel, Nivel.nivelFacilPath);
			Nivel nivelRecargado = Archivador.cargar(new Nivel(), Nivel.nivelFacilPath);
			List<Obstaculo> obstaculosRecargados = nivelRecargado.getObstaculos();
			obstaculos = nivel.getObstaculos();
			List<Sorpresa> sorpresasRecargadas = nivelRecargado.getSorpresas();
			sorpresas = nivel.getSorpresas();
			assertEquals(obstaculos.size(), obstaculosRecargados.size());			
			assertEquals(obstaculos.get(0).getClass(), obstaculosRecargados.get(0).getClass());
			assertEquals(obstaculos.get(1).getClass(), obstaculosRecargados.get(1).getClass());
			assertEquals(obstaculos.get(2).getClass(), obstaculosRecargados.get(2).getClass());
			
			assertEquals(obstaculos.get(0).getPosicion().getX(), obstaculosRecargados.get(0).getPosicion().getX());
			assertEquals(obstaculos.get(0).getPosicion().getY(), obstaculosRecargados.get(0).getPosicion().getY());
			
			assertEquals(sorpresas.size(), sorpresasRecargadas.size());			
			assertEquals(sorpresas.get(0).getClass(), sorpresasRecargadas.get(0).getClass());
			assertEquals(sorpresas.get(1).getClass(), sorpresasRecargadas.get(1).getClass());
			assertEquals(sorpresas.get(2).getClass(), sorpresasRecargadas.get(2).getClass());
			assertEquals(sorpresas.get(0).getPosicion().getX(), sorpresasRecargadas.get(0).getPosicion().getX());
			
		
		}
		catch (Exception ex) {
			fail();
		}		
	}
	
	@Test
	public void testGuardarYCargarNivelMedio() {
		Nivel nivel = new Nivel();
		nivel.agregarUnObstaculo(obstaculo1);
		nivel.agregarUnObstaculo(obstaculo2);
		nivel.agregarUnObstaculo(obstaculo3);
		nivel.agregarUnObstaculo(obstaculo4);
		nivel.agregarUnObstaculo(obstaculo5);
		nivel.agregarUnObstaculo(obstaculo8);
		nivel.agregarUnObstaculo(obstaculo11);
		nivel.agregarUnObstaculo(obstaculo12);
		nivel.agregarUnObstaculo(obstaculo14);
		nivel.agregarUnObstaculo(obstaculo15);
		nivel.agregarUnaSorpresa(sorpresa1);
		nivel.agregarUnaSorpresa(sorpresa3);
		nivel.agregarUnaSorpresa(sorpresa4);
		nivel.agregarUnaSorpresa(sorpresa5);
		nivel.agregarUnaSorpresa(sorpresa6);
		nivel.agregarUnaSorpresa(sorpresa7);
		nivel.agregarUnaSorpresa(sorpresa11);
		
		try {
			Archivador.guardar(nivel, Nivel.nivelMedioPath);
			Nivel nivelRecargado = Archivador.cargar(new Nivel(), Nivel.nivelMedioPath);
			List<Obstaculo> obstaculosRecargados = nivelRecargado.getObstaculos();
			obstaculos = nivel.getObstaculos();
			List<Sorpresa> sorpresasRecargadas = nivelRecargado.getSorpresas();
			sorpresas = nivel.getSorpresas();
			assertEquals(obstaculos.size(), obstaculosRecargados.size());			
			assertEquals(obstaculos.get(0).getClass(), obstaculosRecargados.get(0).getClass());
			assertEquals(obstaculos.get(1).getClass(), obstaculosRecargados.get(1).getClass());
			assertEquals(obstaculos.get(2).getClass(), obstaculosRecargados.get(2).getClass());
			assertEquals(obstaculos.get(3).getClass(), obstaculosRecargados.get(3).getClass());
			assertEquals(obstaculos.get(0).getPosicion().getX(), obstaculosRecargados.get(0).getPosicion().getX());
			assertEquals(obstaculos.get(0).getPosicion().getY(), obstaculosRecargados.get(0).getPosicion().getY());
			
			assertEquals(sorpresas.size(), sorpresasRecargadas.size());			
			assertEquals(sorpresas.get(0).getClass(), sorpresasRecargadas.get(0).getClass());
			assertEquals(sorpresas.get(1).getClass(), sorpresasRecargadas.get(1).getClass());
			assertEquals(sorpresas.get(2).getClass(), sorpresasRecargadas.get(2).getClass());
			assertEquals(sorpresas.get(3).getClass(), sorpresasRecargadas.get(3).getClass());
		
		}
		catch (Exception ex) {
			fail();
		}		
	}

	@Test
	public void testGuardarYCargarNivelDificil() {
		Nivel nivel = new Nivel();
		nivel.agregarUnObstaculo(obstaculo1);
		nivel.agregarUnObstaculo(obstaculo2);
		nivel.agregarUnObstaculo(obstaculo3);
		nivel.agregarUnObstaculo(obstaculo4);
		nivel.agregarUnObstaculo(obstaculo5);
		nivel.agregarUnObstaculo(obstaculo6);
		nivel.agregarUnObstaculo(obstaculo7);
		nivel.agregarUnObstaculo(obstaculo8);
		nivel.agregarUnObstaculo(obstaculo9);
		nivel.agregarUnObstaculo(obstaculo10);
		nivel.agregarUnObstaculo(obstaculo14);
		nivel.agregarUnObstaculo(obstaculo15);
		
		nivel.agregarUnaSorpresa(sorpresa1);
		nivel.agregarUnaSorpresa(sorpresa2);
		nivel.agregarUnaSorpresa(sorpresa3);
		nivel.agregarUnaSorpresa(sorpresa4);
		nivel.agregarUnaSorpresa(sorpresa5);
		nivel.agregarUnaSorpresa(sorpresa6);
		nivel.agregarUnaSorpresa(sorpresa7);
		nivel.agregarUnaSorpresa(sorpresa8);
		nivel.agregarUnaSorpresa(sorpresa9);
		nivel.agregarUnaSorpresa(sorpresa10);
		
		try {
			Archivador.guardar(nivel, Nivel.nivelDificilPath);
			Nivel nivelRecargado = Archivador.cargar(new Nivel(), Nivel.nivelDificilPath);
			List<Obstaculo> obstaculosRecargados = nivelRecargado.getObstaculos();
			obstaculos = nivel.getObstaculos();
			List<Sorpresa> sorpresasRecargadas = nivelRecargado.getSorpresas();
			sorpresas = nivel.getSorpresas();
			assertEquals(obstaculos.size(), obstaculosRecargados.size());			
			assertEquals(obstaculos.get(0).getClass(), obstaculosRecargados.get(0).getClass());
			assertEquals(obstaculos.get(1).getClass(), obstaculosRecargados.get(1).getClass());
			assertEquals(obstaculos.get(2).getClass(), obstaculosRecargados.get(2).getClass());
			assertEquals(obstaculos.get(3).getClass(), obstaculosRecargados.get(3).getClass());
			assertEquals(obstaculos.get(0).getPosicion().getX(), obstaculosRecargados.get(0).getPosicion().getX());
			assertEquals(obstaculos.get(0).getPosicion().getY(), obstaculosRecargados.get(0).getPosicion().getY());
			
			assertEquals(sorpresas.size(), sorpresasRecargadas.size());			
			assertEquals(sorpresas.get(0).getClass(), sorpresasRecargadas.get(0).getClass());
			assertEquals(sorpresas.get(1).getClass(), sorpresasRecargadas.get(1).getClass());
			assertEquals(sorpresas.get(2).getClass(), sorpresasRecargadas.get(2).getClass());
			assertEquals(sorpresas.get(3).getClass(), sorpresasRecargadas.get(3).getClass());
		
		}
		catch (Exception ex) {
			fail();
		}		
	}


}
