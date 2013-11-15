package fiuba.algo3.gpschallenge.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

	
	private List<Vehiculo> mejoresPuntajes;

	public Ranking(){
		this.mejoresPuntajes = new ArrayList<Vehiculo>();
	}

	public List<Vehiculo> getPuntajes() {
		// TODO Auto-generated method stub
		return this.mejoresPuntajes;
	}
}
