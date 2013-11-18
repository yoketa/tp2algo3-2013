package fiuba.algo3.gpschallenge.modelo;

import java.util.*;
import java.util.Comparator;
import java.util.List;

/**
 * Clase que representa al ranking de puntajes.
 * 
 */

public class Ranking {

	private Comparator unComparador;
	private List<Vehiculo> mejoresPuntajes;

	public Ranking(){
		this.mejoresPuntajes = new ArrayList<Vehiculo>();
		this.unComparador = new ComparadorVehiculosPorPuntaje();
	}

	public List<Vehiculo> getPuntajes() {
		// TODO Auto-generated method stub
		return this.mejoresPuntajes;
	}
	
	/**
	 * agrego el puntaje del vehiculo al ranking de manera ordenada
	 *
	 * @param unVehiculo
	 */
	public void agregarPuntaje(Vehiculo unVehiculo){
		if(this.mejoresPuntajes.size()==0){
			this.mejoresPuntajes.add(unVehiculo);
		}
		else {
			this.mejoresPuntajes.add(unVehiculo);
			java.util.Collections.sort(mejoresPuntajes,unComparador);
			java.util.Collections.reverse(mejoresPuntajes);
		}
	}


}
