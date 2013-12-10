package Unitarias;

import static org.junit.Assert.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.obstaculo.ControlPolicial;
import modelo.probabilidades.Probabilidad;
import modelo.probabilidades.ProbabilidadEquiprobable;
import modelo.probabilidades.ProbabilidadFija;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

import excepciones.ValorDeProbabilidadInvalidoException;

public class ControlPolicialTest {
	
	@Test
	public void testConstructorControlPolicialInizializaSuPosicionEnCeroCero(){
	
		/* Arrange */
		ControlPolicial control = new ControlPolicial();

		/* Assert*/
		assertEquals( 0, control.getX());	
		assertEquals( 0, control.getY());
	}
	
	@Test
	public void testControlPolicialDeberiaCrearseConUnaProbabilidad() throws ValorDeProbabilidadInvalidoException{
	
		/* Arrange */
		Vector posicion = new Vector(4,4);
		Probabilidad probabilidad = new ProbabilidadEquiprobable();
		ControlPolicial controlPolicial = new ControlPolicial(posicion,probabilidad);

		/* Assert*/
		assertTrue( 1 >= controlPolicial.getProbabilidad());	
		assertTrue( 0 <= controlPolicial.getProbabilidad());
	}
	
	@Test
	public void testgetProbabilidadDeberiaDevolverUnValorDeProbabilidad(){
	
		/* Arrange */
		Vector posicion = new Vector(4,4);
		try {
			Probabilidad probabilidad = new ProbabilidadFija(0.3);
			ControlPolicial controlPolicial = new ControlPolicial(posicion,probabilidad);

			/* Assert*/
			assertEquals( 0.3, controlPolicial.getProbabilidad(), 0);
			
		} catch ( ValorDeProbabilidadInvalidoException ex) {
			System.out.println(ex.toString());
		}	
	}
	
	@Test
	public void testgetProbabilidadDeberiaLanzarValorDeProbabilidadInvalidoException(){
	
		/* Arrange */
		Vector posicion = new Vector(4,4);
		try {
			Probabilidad probabilidad = new ProbabilidadFija(-0.2);
			ControlPolicial controlPolicial = new ControlPolicial(posicion,probabilidad);

			/* Assert*/
			assertEquals( 0.3, controlPolicial.getProbabilidad(), 0);
			
		} catch ( ValorDeProbabilidadInvalidoException ex) {
			System.out.println(ex.toString());
		}	
	}
	
	@Test
	public void testgetXeYDeberiaDevolverSuPosicionEnXeY(){
	
		/* Arrange */
		Vector posicion = new Vector(4,4);
		
		try {
			Probabilidad probabilidad = new ProbabilidadFija(0.79);
			ControlPolicial controlPolicial = new ControlPolicial(posicion,probabilidad);

			/* Assert*/
			assertEquals( 4, controlPolicial.getX());	
			assertEquals( 4, controlPolicial.getY());
			
		} catch ( ValorDeProbabilidadInvalidoException ex) {
			System.out.println(ex.toString());
		}
	}
	
	@Test
	public void testAfectarDeberiaAfectarUnVehiculoConUnControlPolicial(){
		
		/* Arrange */
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		ControlPolicial controlPolicial = new ControlPolicial();
		
		/* Act */
		try {
			vehiculo.bajar();
			controlPolicial.afectar(vehiculo);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}	
	}
}
