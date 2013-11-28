package modelo.obstaculo;

import modelo.probabilidades.Probabilidad;
import modelo.vehiculo.Vehiculo;

public class ControlPolicial extends Obstaculo {
	
	private double probabilidad;
	
	public ControlPolicial(Probabilidad probabilidad){
		this.probabilidad = probabilidad.calcular();	
	}
	
	@Override
	public void afectar(Vehiculo vehiculo) {
		
		double probabilidadDelvehiculo = vehiculo.getEstado().getProbabilidadDePasarUnControlPolicial();

		if ( this.getProbabilidad() > probabilidadDelvehiculo)
		{
			vehiculo.controlPolicial();
		}
	}
	
	public double getProbabilidad(){
	 return this.probabilidad;
	}

}
