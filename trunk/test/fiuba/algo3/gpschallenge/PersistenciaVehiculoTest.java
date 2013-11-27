package fiuba.algo3.gpschallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import persistencia.Archivador;
import fiuba.algo3.gpschallenge.modelo.Auto;
import fiuba.algo3.gpschallenge.modelo.CuatroXCuatro;
import fiuba.algo3.gpschallenge.modelo.EstadoVehiculo;
import fiuba.algo3.gpschallenge.modelo.Moto;
import fiuba.algo3.gpschallenge.modelo.Vehiculo;


public class PersistenciaVehiculoTest {
	private Vehiculo vehiculoAuto;
	private Vehiculo vehiculoMoto;
	private Vehiculo vehiculoCuatroXCuatro;
	private Vehiculo otroVehiculoAuto;
	private Vehiculo otroVehiculoMoto;
	private Vehiculo otroVehiculoCuatroXCuatro;
	
	private EstadoVehiculo estadoAuto = new Auto();
	private EstadoVehiculo estadoMoto = new Moto();
	private EstadoVehiculo estadoCuatroXCuatro = new CuatroXCuatro();
	private String pilotoAuto  = "pepe";
	private String pilotoMoto  = "juan";
	private String pilotoCuatroXCuatro  = "luis";
	
	@Before
	public void setup() {

		vehiculoAuto = Vehiculo.crearConPiloto(pilotoAuto,estadoAuto,2,3);
		vehiculoAuto.setPuntaje(50);
		
		vehiculoMoto = Vehiculo.crearConPiloto(pilotoMoto,estadoMoto, 1, 2);
		vehiculoMoto.setPuntaje(80);
	
		vehiculoCuatroXCuatro = Vehiculo.crearConPiloto(pilotoCuatroXCuatro,estadoCuatroXCuatro, 4, 2);
		vehiculoCuatroXCuatro.setPuntaje(95);

	}

	@Test
	public void GuardarYCargarVehiculoEnEstadoAutoTest() {
		String pathArchivo = "C:\\Users\\Miguel\\workspace\\repositorio\\save\\VehiculoAuto.xml";

		Archivador.guardar(vehiculoAuto, pathArchivo);

		otroVehiculoAuto = Archivador.cargar(new Vehiculo(0,0), pathArchivo);
		assertEquals(otroVehiculoAuto.getPiloto(),"pepe");
		assertEquals(otroVehiculoAuto.getPuntaje(),50.0,1E-5);
		assertEquals(otroVehiculoAuto.getPosicionHorizontal(),2,1E-5);
		assertEquals(otroVehiculoAuto.getPosicionVertical(),3,1E-5);
		assertEquals(otroVehiculoAuto.getEstado().getClass(),estadoAuto.getClass());
	
	
	}

	@Test
	public void GuardarYCargarVehiculoEnEstadoMotoTest() {
		String pathArchivo = "C:\\Users\\Miguel\\workspace\\repositorio\\save\\VehiculoMoto.xml";

		Archivador.guardar(vehiculoMoto, pathArchivo);

		otroVehiculoMoto = Archivador.cargar(new Vehiculo(0,0), pathArchivo);
		assertEquals(otroVehiculoMoto.getPiloto(),"juan");
		assertEquals(otroVehiculoMoto.getPuntaje(),80.0,1E-5);
		assertEquals(otroVehiculoMoto.getPosicionHorizontal(),1,1E-5);
		assertEquals(otroVehiculoMoto.getPosicionVertical(),2,1E-5);
		assertEquals(otroVehiculoMoto.getEstado().getClass(),estadoMoto.getClass());
	
	}
	
	@Test
	public void GuardarYCargarVehiculoEnEstadoCuatroXCuatroTest() {
		String pathArchivo = "C:\\Users\\Miguel\\workspace\\repositorio\\save\\VehiculoCuatroXCuatro.xml";

		Archivador.guardar(vehiculoCuatroXCuatro, pathArchivo);

		otroVehiculoCuatroXCuatro = Archivador.cargar(new Vehiculo(0,0), pathArchivo);
		assertEquals(otroVehiculoCuatroXCuatro.getPiloto(),"luis");
		assertEquals(otroVehiculoCuatroXCuatro.getPuntaje(),95.0,1E-5);
		assertEquals(otroVehiculoCuatroXCuatro.getPosicionHorizontal(),4,1E-5);
		assertEquals(otroVehiculoCuatroXCuatro.getPosicionVertical(),2,1E-5);
		assertEquals(otroVehiculoCuatroXCuatro.getEstado().getClass(),estadoCuatroXCuatro.getClass());
	
	}


}
