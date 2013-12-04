package fiuba.algo3.gpschallenge;

import static org.junit.Assert.*;

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
	public void testafectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelaMoto(){
	
		/* Arrange */
		int penalizacion = 3;
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		Probabilidad probabilidad = new ProbabilidadFija(0.79);
		Vector posicion = new Vector(0,0);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		controlPolicial.afectar(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testafectarNoDeberiaSumarTresPenalizacionessSiLaProbabilidadDelControlPolicialEsMayorAlaDelaMoto(){
		
		/* Arrange */
		int penalizacion = 0;
		EstadoVehiculo moto = new Moto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",moto);
		Probabilidad probabilidad = new ProbabilidadFija(0.89);
		Vector posicion = new Vector(0,0);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		controlPolicial.afectar(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	
	@Test
	public void testAfectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelCuatroXCuatro(){
		
		/* Arrange */
		int penalizacion = 3;
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		Probabilidad probabilidad = new ProbabilidadFija(0.29);
		Vector posicion = new Vector(0,0);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		controlPolicial.afectar(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testAfectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayotAlaDelCuatroXCuatro(){
		
		/* Arrange */
		int penalizacion = 0;
		EstadoVehiculo cuatro = new CuatroXCuatro();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",cuatro);
		Probabilidad probabilidad = new ProbabilidadFija(0.59);
		Vector posicion = new Vector(0,0);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		controlPolicial.afectar(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testAfectarDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMenorAlaDelAuto(){
		
		/* Arrange */
		int penalizacion = 3;
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		Probabilidad probabilidad = new ProbabilidadFija(0.49);
		Vector posicion = new Vector(0,0);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		controlPolicial.afectar(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
	}
	
	@Test
	public void testAfectarNoDeberiaSumarTresPenalizacionesSiLaProbabilidadDelControlPolicialEsMayotAlaDelAuto(){
		
		/* Arrange */
		int penalizacion = 0;
		EstadoVehiculo auto = new Auto();
		Vehiculo vehiculo = Vehiculo.crearConPilotoYVehiculo("",auto);
		Probabilidad probabilidad = new ProbabilidadFija(0.59);
		Vector posicion = new Vector(0,0);
		Obstaculo controlPolicial = new ControlPolicial(posicion,probabilidad);
		
		/* Act */
		vehiculo.derecha();
		int movimientos = vehiculo.getMovimientos()+ penalizacion;
		controlPolicial.afectar(vehiculo);
		
		/* Assert*/
		assertEquals( movimientos , vehiculo.getMovimientos());	
	}

}
