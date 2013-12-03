package fiuba.algo3.gpschallenge;

import static org.junit.Assert.assertEquals;
import modelo.interfaces.EstadoVehiculo;
import modelo.vehiculo.Auto;
import modelo.vehiculo.CuatroXCuatro;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;

import org.junit.Before;
import org.junit.Test;

import persistencia.Archivador;


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

		vehiculoAuto = Vehiculo.crearConPilotoYVehiculo(pilotoAuto,estadoAuto);
		vehiculoAuto.setPuntaje(50);
		
		vehiculoMoto = Vehiculo.crearConPilotoYVehiculo(pilotoMoto,estadoMoto);
		vehiculoMoto.setPuntaje(80);
	
		vehiculoCuatroXCuatro = Vehiculo.crearConPilotoYVehiculo(pilotoCuatroXCuatro,estadoCuatroXCuatro);
		vehiculoCuatroXCuatro.setPuntaje(95);

	}

	@Test
	public void GuardarYCargarVehiculoEnEstadoAutoTest() {
		/* 
		 * El archivo Auto.xml se encuentra en la siguiente direccion y en la carpeta save del tp.
		 * para hacer la prueba se debe crear la carpeta persistencia en el disco C por un motivo de comodidad   
		 * al sincronizar con el repositorio.  
		*/
		String pathArchivo = "C:\\Persistencia\\Auto.xml";

		Archivador.guardar(vehiculoAuto, pathArchivo);

		otroVehiculoAuto = Archivador.cargar(new Vehiculo(0,0), pathArchivo);
		assertEquals(otroVehiculoAuto.getPiloto(),"pepe");
		assertEquals(otroVehiculoAuto.getPuntaje(),50.0,1E-5);
		assertEquals(otroVehiculoAuto.getX(),0,1E-5);
		assertEquals(otroVehiculoAuto.getY(),0,1E-5);
		assertEquals(otroVehiculoAuto.getMovimientos(),0,1E-5);
		assertEquals(otroVehiculoAuto.getEstado().getClass(),estadoAuto.getClass());
		
	
	}

	@Test
	public void GuardarYCargarVehiculoEnEstadoMotoTest() {
		/* 
		 * El archivo vehiculo.xml se encuentra en la siguiente direccion y en la carpeta save del tp.
		 * para hacer la prueba se debe crear la carpeta persistencia en el disco C por un motivo de comodidad
		 * al sincronizar con el repositorio.
		*/
		String pathArchivo = "C:\\Persistencia\\VehiculoMoto.xml";

		Archivador.guardar(vehiculoMoto, pathArchivo);

		otroVehiculoMoto = Archivador.cargar(new Vehiculo(0,0), pathArchivo);
		assertEquals(otroVehiculoMoto.getPiloto(),"juan");
		assertEquals(otroVehiculoMoto.getPuntaje(),80.0,1E-5);
		assertEquals(otroVehiculoMoto.getX(),0,1E-5);
		assertEquals(otroVehiculoMoto.getY(),0,1E-5);
		assertEquals(otroVehiculoMoto.getMovimientos(),0,1E-5);
		assertEquals(otroVehiculoMoto.getEstado().getClass(),estadoMoto.getClass());
		
	
	}
	
	@Test
	public void GuardarYCargarVehiculoEnEstadoCuatroXCuatroTest() {
		/* 
		 * El archivo vehiculo.xml se encuentra en la siguiente direccion y en la carpeta save del tp.
		 * para hacer la prueba se debe crear la carpeta persistencia en el disco C por un motivo de comodidad
		 * al sincronizar con el repositorio.
		*/
		String pathArchivo ="C:\\Persistencia\\VehiculoCuatroXCuatro.xml";

		Archivador.guardar(vehiculoCuatroXCuatro, pathArchivo);

		otroVehiculoCuatroXCuatro = Archivador.cargar(new Vehiculo(0,0), pathArchivo);
		assertEquals(otroVehiculoCuatroXCuatro.getPiloto(),"luis");
		assertEquals(otroVehiculoCuatroXCuatro.getPuntaje(),95.0,1E-5);
		assertEquals(otroVehiculoCuatroXCuatro.getX(),0,1E-5);
		assertEquals(otroVehiculoCuatroXCuatro.getY(),0,1E-5);
		assertEquals(otroVehiculoCuatroXCuatro.getMovimientos(),0,1E-5);
		assertEquals(otroVehiculoCuatroXCuatro.getEstado().getClass(),estadoCuatroXCuatro.getClass());
	
	}


}
