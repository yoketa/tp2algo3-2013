package Unitarias;

import static org.junit.Assert.*;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class VehiculoTest {
	
	@Test
	public void testcrearConPilotoYVehiculDeberiaCrearUnVehiculoConElNombreDelPilotoYELVehiculo() {
		
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		assertEquals( "Pepe" , vehiculo.getPiloto() );
		assertEquals(auto.getClass(), vehiculo.getEstado().getClass());
	}
	
	@Test
	public void testcrearConPilotoYVehiculDeberiaCrearUnVehiculoConPuntajeyMovimientosEnCero() {
		

		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
	    assertEquals( 0 , vehiculo.getPuntaje(),0);
	    assertEquals( 0 , vehiculo.getMovimientos());
	}
	
	@Test
	public void testVehiculDeberiaCrearUnVehiculoConPosicionYDireccionEnCero() {
		
		Vehiculo vehiculo = new Vehiculo();
		
		assertEquals( 0 , vehiculo.getPosicion().getX());
		assertEquals( 0 , vehiculo.getPosicion().getY());
		assertEquals( 0 , vehiculo.getDireccion().getX());
		assertEquals( 0 , vehiculo.getDireccion().getY()); 
	}
	
	@Test
	public void testVehiculDeberiaCrearUnVehiculoConPosicionIndicadaYPuntajeEnCero() {
		
		Vehiculo vehiculo = new Vehiculo(1,5);
		
		assertEquals( 1 , vehiculo.getPosicion().getX());
		assertEquals( 5 , vehiculo.getPosicion().getY());
		assertEquals( 0 , vehiculo.getPuntaje(),0);
	}
	
	@Test
	public void testgetPilotoDeberiaDevolverElNombreDelPiloto() {
		
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		assertEquals( "Pepe" , vehiculo.getPiloto() );
	}
	
	@Test
	public void testsetPilotoDeberiaCambiarElNombreDelPiloto() {
		
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		vehiculo.setPiloto("Maria");
		
		assertEquals( "Maria" , vehiculo.getPiloto() );
	}
	
	@Test
	public void testgetXygetYDeberiaDevolverLasPosicionesDeXeY(){
		
		Vehiculo vehiculo = new Vehiculo(1,5);
		
		assertEquals( 1 , vehiculo.getX());
		assertEquals( 5 , vehiculo.getY());
	}
	
	@Test
	public void testSetXySetYDeberiaCambiarLasPosicionesDeXeY(){
		
		Vehiculo vehiculo = new Vehiculo(1,5);
		vehiculo.setX(4);
		vehiculo.setY(7);
		
		assertEquals( 4 , vehiculo.getX());
		assertEquals( 7 , vehiculo.getY());
	}
	
	@Test
	public void testsetPosicionDeberiaCambiarLaPosicion() {
		
		Vehiculo vehiculo = new Vehiculo(1,1);
		Vector posicion = new Vector(5,5);
		vehiculo.setPosicion (posicion);
		
		assertEquals( 5 , vehiculo.getX());
		assertEquals( 5 , vehiculo.getY());
	}
	
	@Test
	public void testSubirDeberiaCambiarLaDireccion() {

	EstadoVehiculo auto = new Auto();
	Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
	
	vehiculo.subir();
	assertEquals( 0 , vehiculo.getDireccion().getX() );
	assertEquals( -30 , vehiculo.getDireccion().getY() );

	}
	
	@Test
	public void testBajarDeberiaCambiarLaPosicionEnLaDireccionIndicada() {

	EstadoVehiculo auto = new Auto();
	Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
	
	vehiculo.bajar();
	assertEquals( 0 , vehiculo.getDireccion().getX() );
	assertEquals( 40 , vehiculo.getDireccion().getY() );
	}
	
	@Test
	public void testDerecharDeberiaCambiarLaPosicionEnLaDireccionIndicada() {

	EstadoVehiculo auto = new Auto();
	Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
	
	vehiculo.derecha();
	assertEquals( 40 ,  vehiculo.getDireccion().getX());
	assertEquals( 0 , vehiculo.getDireccion().getY());

	}
	
	@Test
	public void testIzquierdaDeberiaCambiarLaDireccion() {

	EstadoVehiculo auto = new Auto();
	Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
	
	vehiculo.izquierda();
	assertEquals( -30 , vehiculo.getDireccion().getX() );
	assertEquals( 0 , vehiculo.getDireccion().getY() );
	}
	
	@Test
	public void testsumarMovimientosDeberiaSumarLosMovimientosIndicados() {

	EstadoVehiculo auto = new Auto();
	Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
	
	vehiculo.sumarMovimientos(5);
	
	 assertEquals( 5 , vehiculo.getMovimientos());
	 
	 vehiculo.sumarMovimientos(-3);
	 
	 assertEquals( 2 , vehiculo.getMovimientos());
	}
	
	@Test
	public void testavanzarAFinalDeCuadraDeberiaCambiarLaPosicionDelEnLaDireccionIndicadaComoFinaldeCuadra(){ 

		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		vehiculo.izquierda(); // Coloca la posicion en (-30,0)
								// Coloca la direccion de finalDeCuadra en (-40,0)
		vehiculo.avanzarAFinalDeCuadra(); //
		
		assertEquals( -70 , vehiculo.getPosicion().getX() );
		assertEquals( 0 , vehiculo.getPosicion().getY() );	
	}
	
	@Test
	public void testpegarLaVueltaDeberiaCambiarRestablecerLaPosicion(){ 

		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		vehiculo.derecha(); // Coloca la posicion en (40,0)
		
		vehiculo.pegarLaVuelta(); //
		
		assertEquals( 0 , vehiculo.getPosicion().getX() );
		assertEquals( 0 , vehiculo.getPosicion().getY() );	
	}
	
	@Test
	public void testpenalizacionDesfavorableDebeSerImplementadoEstadoDevehiculo(){ 


		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		
		try {
			vehiculo.derecha();
			vehiculo.penalizacionDesfavorable();
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}
	}
	
	@Test
	public void testpenalizacionFavorableDebeSerImplementadoEstadoDevehiculo(){ 


		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		
		try {
			vehiculo.derecha();
			vehiculo.penalizacionFavorable();
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}
	}
	
	@Test
	public void testpasaPorPozoDebeSerImplementadoEstadoDevehiculo(){ 

		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		
		try {
			vehiculo.derecha();
			vehiculo.pasaPorPozo();
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}
	}
	
	@Test
	public void testpiqueteDebeSerImplementadoEstadoDevehiculo(){ 

		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		
		try {
			vehiculo.derecha();
			vehiculo.piquete();
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}
	}
	
	@Test
	public void testcambiarEstadoDebeSerImplementadoEstadoDevehiculo(){ 

		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		
		try {
			vehiculo.derecha();
			vehiculo.cambiarEstado();
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}
	}
	
	@Test
	public void testcontrolPolicialDebeSerImplementadoEstadoDevehiculo(){ 

		EstadoVehiculo estadoMoto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",estadoMoto);
		double probabilidad = 0.2;
		 
		try {
			vehiculo.derecha();
			vehiculo.controlPolicial(probabilidad);
			assertTrue(true);
		}
		catch (Exception ex) {
			fail();
		}
	}
	
	
}
	
