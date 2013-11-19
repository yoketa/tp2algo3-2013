package fiuba.algo3.gpschallenge.modelo;

public class ProbabilidadFija extends Probabilidad {
	
	public ProbabilidadFija(double valorFijo){

		 this.probabilidad = valorFijo;
	}
	
	public double calcular() {
		return this.probabilidad;	
	}

}
