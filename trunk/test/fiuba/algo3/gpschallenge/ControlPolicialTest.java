package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;
import junit.framework.Assert;

import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;
import modelo.obstaculo.ControlPolicial;
import modelo.obstaculo.Obstaculo;
import modelo.probabilidades.Probabilidad;
import modelo.probabilidades.ProbabilidadFija;
import modelo.vehiculo.Auto;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Test;

public class ControlPolicialTest {

	@Test
	public void testafectarDeberiaSumarTresPenalizacionessSiLaProbabilidadDelControlPolicialEsMenorAlaDelaMoto(){
	
		EstadoVehiculo moto = new Moto();
		Vector posicion = new Vector(0,0);
		
		Probabilidad probabilidad = new ProbabilidadFija(0.79);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		int movimientos = vehiculo.getMovimientos()+ 3;
		
		controlPolicial.afectar(vehiculo);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
		}
	
	@Test
	public void testafectarNoDeberiaSumarTresPenalizacionessSiLaProbabilidadDelControlPolicialEsMayorAlaDelaMoto(){
	
		EstadoVehiculo moto = new Moto();
		Vector posicion = new Vector(0,0);
		
		Probabilidad probabilidad = new ProbabilidadFija(0.81);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		int movimientos = vehiculo.getMovimientos();
		
		controlPolicial.afectar(vehiculo);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
		}
	
	@Test
	public void testAfectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelCuatroXCuatro(){
		
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vector posicion = new Vector(0,0);
		
		Probabilidad probabilidad = new ProbabilidadFija(0.29);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		int movimientos = vehiculo.getMovimientos()+ 3;
		
		controlPolicial.afectar(vehiculo);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testAfectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayotAlaDelCuatroXCuatro(){
		
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vector posicion = new Vector(0,0);
		
		Probabilidad probabilidad = new ProbabilidadFija(0.31);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		int movimientos = vehiculo.getMovimientos();
		
		controlPolicial.afectar(vehiculo);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testAfectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelAuto(){
		
		EstadoVehiculo auto = new Auto();
		Vector posicion = new Vector(0,0);
		
		Probabilidad probabilidad = new ProbabilidadFija(0.49);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		int movimientos = vehiculo.getMovimientos()+ 3;
		
		controlPolicial.afectar(vehiculo);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testAfectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayotAlaDelAuto(){
		
		EstadoVehiculo auto = new Auto();
		Vector posicion = new Vector(0,0);
		
		Probabilidad probabilidad = new ProbabilidadFija(0.51);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		int movimientos = vehiculo.getMovimientos();
		
		controlPolicial.afectar(vehiculo);
		
		Assert.assertEquals( movimientos , vehiculo.getMovimientos());	
	}

}
