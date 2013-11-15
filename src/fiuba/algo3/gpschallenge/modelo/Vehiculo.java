package fiuba.algo3.gpschallenge.modelo;

public class Vehiculo {

	private String piloto;
	
	public static Vehiculo crearConPiloto(String piloto) {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPiloto(piloto);
		return vehiculo;
	}

	private void setPiloto(String piloto) {
		this.piloto = piloto;		
	}

	public String getPiloto() {
		return this.piloto;
	}

}
