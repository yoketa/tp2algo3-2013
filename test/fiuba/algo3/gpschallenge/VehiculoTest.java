package fiuba.algo3.gpschallenge;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import modelo.interfaces.EstadoVehiculo;
import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class VehiculoTest {
	
	@Test
	public void testDeberiaCrearUnVehiculoConElNombreDelPilotoYELVehiculo() {
		
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
		assertEquals( "Pepe" , vehiculo.getPiloto() );
		assertEquals(auto.getClass(), vehiculo.getEstado().getClass());
	}
	
	@Test
	public void testDeberiaCrearUnVehiculoConPuntajeEnCero() {
		
		double puntaje = 0;
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("Pepe",auto);
		
	    Assert.assertEquals( puntaje , vehiculo.getPuntaje());
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

}
	
