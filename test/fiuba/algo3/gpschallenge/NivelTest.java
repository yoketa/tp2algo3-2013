package fiuba.algo3.gpschallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import modelo.juego.Ranking;
import modelo.juego.Vector;
import modelo.obstaculo.ControlPolicial;
import modelo.obstaculo.Obstaculo;
import modelo.obstaculo.Piquete;
import modelo.obstaculo.Pozo;
import modelo.sorpresas.CambioDeVehiculo;
import modelo.sorpresas.Sorpresa;
import modelo.sorpresas.SorpresaDesfavorable;
import modelo.sorpresas.SorpresaFavorable;
import modelo.vehiculo.Vehiculo;

import org.junit.Before;
import org.junit.Test;

import controladores.Nivel;
import persistencia.Archivador;

public class NivelTest {

	private Sorpresa sorpresa1;
	private Sorpresa sorpresa2;
	private Sorpresa sorpresa3;
	private Sorpresa sorpresa4;
	
	
	private Obstaculo obstaculo1;
	private Obstaculo obstaculo2;
	private Obstaculo obstaculo3;
	private Obstaculo obstaculo4;
	
	
	private List<Sorpresa> sorpresas;
	private List<Obstaculo> obstaculos;
	private Nivel nivel;
	
	private Vehiculo vehiculo1;
	private Vehiculo vehiculo2;
	private Vehiculo vehiculo3;
	private Ranking ranking;
	private List<Vehiculo> puntajes;
		
	@Before
	public void setup() {
		
		sorpresa1 = new SorpresaDesfavorable(new Vector(1,1));
		sorpresa2 = new SorpresaDesfavorable(new Vector(2,2));
		sorpresa3 = new SorpresaFavorable(new Vector(1,2));
		sorpresa4 = new SorpresaFavorable(new Vector(4,2));
		
		
		obstaculo1 = new Pozo (new Vector(5,5));
		obstaculo2 = new Pozo (new Vector(5,6));
		obstaculo3 = new ControlPolicial(new Vector(1,6)) ;
		obstaculo4 = new Piquete (new Vector(3,3));
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
		 nivel.agregarSorpresa(sorpresa1);
		assertEquals(1,nivel.getSorpresas().size());
		nivel.agregarSorpresa(sorpresa2);
		assertEquals(2,nivel.getSorpresas().size());
		nivel.agregarSorpresa(sorpresa3);
		assertEquals(3,nivel.getSorpresas().size());
		nivel.agregarSorpresa(sorpresa4);
		assertEquals(4,nivel.getSorpresas().size());
	}

	@Test
	public void testObtenerSorpresasDelNivel() {
		nivel.agregarSorpresa(sorpresa1);
		nivel.agregarSorpresa(sorpresa2);
		nivel.agregarSorpresa(sorpresa3);
		nivel.agregarSorpresa(sorpresa4);
		sorpresas = nivel.getSorpresas();
		Vector posicionSopresa1 = sorpresas.get(0).getPosicion();
		Vector posicionSopresa2 = sorpresas.get(1).getPosicion();
		Vector posicionSopresa3 = sorpresas.get(2).getPosicion();
		Vector posicionSopresa4 = sorpresas.get(3).getPosicion();
		
		assertEquals(posicionSopresa1.getX(),1,1E-5);
		assertEquals(posicionSopresa1.getY(),1,1E-5);
		assertEquals(posicionSopresa2.getX(),2,1E-5);
		assertEquals(posicionSopresa2.getY(),2,1E-5);
		assertEquals(posicionSopresa3.getX(),1,1E-5);
		assertEquals(posicionSopresa3.getY(),2,1E-5);
		assertEquals(posicionSopresa4.getX(),4,1E-5);
		assertEquals(posicionSopresa4.getY(),2,1E-5);
	}
	
	
	@Test
	public void testObtenerObstaculosDelNivel() {
		nivel.agregarObstaculo(obstaculo1);
		nivel.agregarObstaculo(obstaculo2);
		nivel.agregarObstaculo(obstaculo3);
		nivel.agregarObstaculo(obstaculo4);
		obstaculos = nivel.getObstaculos();
		Vector posicionObstaculo1 = obstaculos.get(0).getPosicion();
		Vector posicionObstaculo2 = obstaculos.get(1).getPosicion();
		Vector posicionObstaculo3 = obstaculos.get(2).getPosicion();
		Vector posicionObstaculo4 = obstaculos.get(3).getPosicion();
		
		assertEquals(posicionObstaculo1.getX(),5,1E-5);
		assertEquals(posicionObstaculo1.getY(),5,1E-5);
		assertEquals(posicionObstaculo2.getX(),5,1E-5);
		assertEquals(posicionObstaculo2.getY(),6,1E-5);
		assertEquals(posicionObstaculo3.getX(),1,1E-5);
		assertEquals(posicionObstaculo3.getY(),6,1E-5);
		assertEquals(posicionObstaculo4.getX(),3,1E-5);
		assertEquals(posicionObstaculo4.getY(),3,1E-5);
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
		nivel.agregarSorpresa(sorpresa1);
		nivel.agregarSorpresa(sorpresa2);
		nivel.agregarSorpresa(sorpresa3);
		nivel.agregarSorpresa(sorpresa4);
		try {
			Archivador.guardar(nivel, Nivel.nivelPath);
			/*Nivel nivelRecargado = Archivador.cargar(new Nivel(), Nivel.nivelPath);
			List<Sorpresa> sorpresasRecargadas = nivelRecargado.getSorpresas();
			sorpresas = nivel.getSorpresas();
			
			assertEquals(sorpresas.size(), sorpresasRecargadas);	*/			
		}
		catch (Exception ex) {
			fail();
		}		
	}

}
