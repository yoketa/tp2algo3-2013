package fiuba.algo3.gpschallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.Auto;
import fiuba.algo3.gpschallenge.modelo.CuatroXCuatro;
import fiuba.algo3.gpschallenge.modelo.Moto;
import fiuba.algo3.gpschallenge.modelo.Vector;
import fiuba.algo3.gpschallenge.modelo.Vehiculo;

public class VehiculoTest {
	
	@Test
	public void testDeberiaCrearUnVehiculoConElNombreDelPiloto() {
		String piloto  = "pepe";
		Vehiculo vehiculo = Vehiculo.crearConPiloto(piloto,"",0,0);
		Assert.assertEquals( piloto , vehiculo.getPiloto() );
	}
	
	@Test
	public void testDeberiaCrearUnVehiculoEnLaPosicionHorizontalIndicada() {
		int x  = 1;
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","",x,0);
		Assert.assertEquals( x , vehiculo.getPosicionHorizontal() );
	}
	
	@Test
	public void testDeberiaCrearUnVehiculoConElEstadoDeVehiculo_Moto() {
		Moto moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","Moto",0,0);
		assertEquals(moto.getClass(), vehiculo.getEstado().getClass());
	}
	
	@Test
	public void testDeberiaCrearUnVehiculoConElEstadoDeVehiculo_Auto() {
		Auto auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","Auto",0,0);
		assertEquals(auto.getClass(), vehiculo.getEstado().getClass());
	}
	
	@Test
	public void testDeberiaCrearUnVehiculoConElEstadoDeVehiculo_CuatroXCuatro() {
		CuatroXCuatro cuatroXcuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","CuatroXCuatro",0,0);
		assertEquals(cuatroXcuatro.getClass(), vehiculo.getEstado().getClass());
	}
	
	
	@Test
	public void testDeberiaCrearUnVehiculoConElEstadoDeVehiculoIndicado() {
		Moto moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","Moto",0,0);
		assertEquals(moto.getClass(), vehiculo.getEstado().getClass());
	}
	
	@Test
	public void testDeberiaCrearUnVehiculoConPuntajeEnCero() {
		double puntaje = 0;
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","",0,0);
		Assert.assertEquals( puntaje , vehiculo.getPuntaje());
	}


@Test
public void testMoverDeberiaCambiarLaPosicionEnLaDireccionHorizontal() {

	Vector direccion = new Vector(1,0);
	Vehiculo vehiculo = Vehiculo.crearConPiloto("","",0,0);
	
	try {
		vehiculo.mover(direccion);
		Assert.assertEquals( 1 , vehiculo.getPosicionHorizontal() );
		Assert.assertEquals( 0 , vehiculo.getPosicionVertical() );
	}
	catch (Exception e) {
	}
}

@Test
public void testMoverDeberiaCambiarLaPosicionEnLaDireccionVertical() {

	Vector direccion = new Vector(0,1);
	Vehiculo vehiculo = Vehiculo.crearConPiloto("","",0,0);
	
	try {
		vehiculo.mover(direccion);
		Assert.assertEquals( 1 , vehiculo.getPosicionVertical() );
		Assert.assertEquals( 0 , vehiculo.getPosicionHorizontal() );
	}
	catch (Exception e) {
	}
}

@Test
public void testMoverDeberiaLanzarUnaExcepcionSiLaDireccionDeMovimientoNoEsOrtonormal() {

	Vector direccion = new Vector(1,1);
	Vehiculo vehiculo = Vehiculo.crearConPiloto("","",0,0);
	
	try {
		vehiculo.mover(direccion);
		fail();
	}
	catch (Exception e) {
	}
}
}
	
