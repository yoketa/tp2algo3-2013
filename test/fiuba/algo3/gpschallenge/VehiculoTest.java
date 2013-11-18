package fiuba.algo3.gpschallenge;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.Moto;
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
	public void testDeberiaCrearUnVehiculoEnLaPosicionVerticalIndicada() {
		int y  = 1;
		Vehiculo vehiculo = Vehiculo.crearConPiloto("","",0,y);
		Assert.assertEquals( y , vehiculo.getPosicionVertical() );
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
}
	
