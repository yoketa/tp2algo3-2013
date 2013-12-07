package fiuba.algo3.gpschallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Partida;
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
import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;

import org.junit.Before;
import org.junit.Test;




import persistencia.Archivador;


public class PartidaTest {
	private Vehiculo vehiculo;
	private EstadoVehiculo estado; 
	private Sorpresa sorpresa1;
	private Sorpresa sorpresa2;
	private Sorpresa sorpresa3;
	
	
	private Obstaculo obstaculo1;
	private Obstaculo obstaculo2;
	private Obstaculo obstaculo3;
	
	private String dificultad;
	private List<Sorpresa> sorpresas;
	private List<Obstaculo> obstaculos;
	private Partida partida;
	
	@Before
	public void setup() {
		sorpresa1 = new SorpresaDesfavorable(new Vector(110,140));
		sorpresa2 = new SorpresaDesfavorable(new Vector(420,280));
		sorpresa3 = new SorpresaFavorable(new Vector(530,280));
		dificultad = "facil";
		obstaculo1 = new Pozo (new Vector(180,210));
		obstaculo2 = new Pozo (new Vector(460,210));
		obstaculo3 = new Piquete (new Vector(110,0));
		estado = new Auto();		
		vehiculo = Vehiculo.crearConPilotoYVehiculo("nico", estado);
		partida = new Partida(vehiculo);
	}
	
	@Test
	public void testAlCrearLaPartidaLaMismaSeEncuentraVacia() {
		Partida partida = new Partida(vehiculo);
		assertEquals(0,partida.getSorpresas().size());
		assertEquals(0,partida.getObstaculos().size());
	}

	@Test
	public void testAgregarSorpresasAlaPartida() {
		 partida.agregarUnaSorpresa(sorpresa1);
		assertEquals(1,partida.getSorpresas().size());
		partida.agregarUnaSorpresa(sorpresa2);
		assertEquals(2,partida.getSorpresas().size());
		partida.agregarUnaSorpresa(sorpresa3);
		assertEquals(3,partida.getSorpresas().size());
		
	}

	@Test
	public void testAgregarObstaculosAlaPartida() {
		 partida.agregarUnObstaculo(obstaculo1);
		assertEquals(1,partida.getObstaculos().size());
		partida.agregarUnObstaculo(obstaculo2);
		assertEquals(2,partida.getObstaculos().size());
		partida.agregarUnObstaculo(obstaculo3);
		assertEquals(3,partida.getObstaculos().size());
		
	}

	
	@Test
	public void testObtenerSorpresasDeLaPartida() {
		partida.agregarUnaSorpresa(sorpresa1);
		partida.agregarUnaSorpresa(sorpresa2);
		partida.agregarUnaSorpresa(sorpresa3);
		
		sorpresas = partida.getSorpresas();
		Vector posicionSopresa1 = sorpresas.get(0).getPosicion();
		Vector posicionSopresa2 = sorpresas.get(1).getPosicion();
		Vector posicionSopresa3 = sorpresas.get(2).getPosicion();
		
		
		assertEquals(posicionSopresa1.getX(),110,1E-5);
		assertEquals(posicionSopresa1.getY(),140,1E-5);
		assertEquals(posicionSopresa2.getX(),420,1E-5);
		assertEquals(posicionSopresa2.getY(),280,1E-5);
		assertEquals(posicionSopresa3.getX(),530,1E-5);
		assertEquals(posicionSopresa3.getY(),280,1E-5);
		
		
	}
	
	
	@Test
	public void testObtenerObstaculosDeLaPartida() {
		partida.agregarUnObstaculo(obstaculo1);
		partida.agregarUnObstaculo(obstaculo2);
		partida.agregarUnObstaculo(obstaculo3);
		obstaculos = partida.getObstaculos();
		Vector posicionObstaculo1 = obstaculos.get(0).getPosicion();
		Vector posicionObstaculo2 = obstaculos.get(1).getPosicion();
		Vector posicionObstaculo3 = obstaculos.get(2).getPosicion();
		
		assertEquals(posicionObstaculo1.getX(),180,1E-5);
		assertEquals(posicionObstaculo1.getY(),210,1E-5);
		assertEquals(posicionObstaculo2.getX(),460,1E-5);
		assertEquals(posicionObstaculo2.getY(),210,1E-5);
		assertEquals(posicionObstaculo3.getX(),110,1E-5);
		assertEquals(posicionObstaculo3.getY(),0,1E-5);
	
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void testGuardarYCargarPartida() {
		Partida partida = new Partida(vehiculo);
		partida.setDificultad("Facil");
		partida.agregarUnObstaculo(obstaculo1);
		partida.agregarUnObstaculo(obstaculo2);
		partida.agregarUnObstaculo(obstaculo3);
		partida.agregarUnaSorpresa(sorpresa1);
		partida.agregarUnaSorpresa(sorpresa2);
		partida.agregarUnaSorpresa(sorpresa3);
		
		try {
			Archivador.guardar(partida,partida.getPath());
			Partida partidaCargada = Archivador.cargar(partida,partida.getPath());
			String dificultad = partidaCargada.getDificultad();
			List<Obstaculo> obstaculosRecargados = partidaCargada.getObstaculos();
			obstaculos = partida.getObstaculos();
			List<Sorpresa> sorpresasRecargadas = partidaCargada.getSorpresas();
			sorpresas = partida.getSorpresas();
			Vehiculo vehiculoRecargado = partida.getVehiculo();
			assertEquals(partida.getDificultad(),dificultad);
			assertEquals(vehiculo.getPiloto(),vehiculoRecargado.getPiloto());
			assertEquals(vehiculo.getEstado().getClass(),vehiculoRecargado.getEstado().getClass());
			assertEquals(vehiculo.getMovimientos(),vehiculoRecargado.getMovimientos());
			
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


}