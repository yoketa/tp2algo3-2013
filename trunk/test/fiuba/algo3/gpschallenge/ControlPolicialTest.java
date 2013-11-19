package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.ControlPolicial;
import fiuba.algo3.gpschallenge.modelo.Obstaculo;
import fiuba.algo3.gpschallenge.modelo.Probabilidad;
import fiuba.algo3.gpschallenge.modelo.ProbabilidadFija;
import fiuba.algo3.gpschallenge.modelo.Vehiculo;

public class ControlPolicialTest {

	@Test
	public void testafectarDeberiaSumarTresMovimientosSiLaProbabilidadDelControlPolicialEsMayorAlaDelAuto(){
		
		Probabilidad probabilidad = new ProbabilidadFija(0.51);
		Obstaculo controlPolicial = new ControlPolicial(probabilidad);
		Vehiculo auto = Vehiculo.crearConPiloto("","Auto",0,0);
		double puntaje = auto.getPuntaje()+ 3;
		
		controlPolicial.afectar(auto);
		Assert.assertEquals( puntaje , auto.getPuntaje());	
	}
	
	@Test
	public void testafectarDeberiaSumarTresMovimientosSiLaProbabilidadDelControlPolicialEsMenorAlaDelAuto(){
		
		Probabilidad probabilidad = new ProbabilidadFija(0.50);
		Obstaculo controlPolicial = new ControlPolicial(probabilidad);
		Vehiculo auto = Vehiculo.crearConPiloto("","Auto",0,0);
		double puntaje = auto.getPuntaje();
		
		controlPolicial.afectar(auto);
		Assert.assertEquals( puntaje , auto.getPuntaje());	
	}
	
	@Test
	public void testafectarDeberiaSumarTresMovimientosSiLaProbabilidadDelControlPolicialEsMayorAlaDelaMoto(){
		
		Probabilidad probabilidad = new ProbabilidadFija(0.81);
		Obstaculo controlPolicial = new ControlPolicial(probabilidad);
		Vehiculo auto = Vehiculo.crearConPiloto("","Moto",0,0);
		double puntaje = auto.getPuntaje()+ 3;
		
		controlPolicial.afectar(auto);
		Assert.assertEquals( puntaje , auto.getPuntaje());	
	}
	
	@Test
	public void testafectarDeberiaSumarTresMovimientosSiLaProbabilidadDelControlPolicialEsMenorAlaDelaMoto(){
		
		Probabilidad probabilidad = new ProbabilidadFija(0.80);
		Obstaculo controlPolicial = new ControlPolicial(probabilidad);
		Vehiculo auto = Vehiculo.crearConPiloto("","Moto",0,0);
		double puntaje = auto.getPuntaje();
		
		controlPolicial.afectar(auto);
		Assert.assertEquals( puntaje , auto.getPuntaje());	
	}
	
	@Test
	public void testafectarDeberiaSumarTresMovimientosSiLaProbabilidadDelControlPolicialEsMayorAlaDeUnaCuatroXCuatro(){
		
		Probabilidad probabilidad = new ProbabilidadFija(0.31);
		Obstaculo controlPolicial = new ControlPolicial(probabilidad);
		Vehiculo auto = Vehiculo.crearConPiloto("","CuatroXCuatro",0,0);
		double puntaje = auto.getPuntaje()+ 3;
		
		controlPolicial.afectar(auto);
		Assert.assertEquals( puntaje , auto.getPuntaje());	
	}
	
	@Test
	public void testafectarDeberiaSumarTresMovimientosSiLaProbabilidadDelControlPolicialEsMenorAlaDeUnaCuatroXCuatro(){
		
		Probabilidad probabilidad = new ProbabilidadFija(0.30);
		Obstaculo controlPolicial = new ControlPolicial(probabilidad);
		Vehiculo auto = Vehiculo.crearConPiloto("","CuatroXCuatro",0,0);
		double puntaje = auto.getPuntaje();
		
		controlPolicial.afectar(auto);
		Assert.assertEquals( puntaje , auto.getPuntaje());	
	}

}
