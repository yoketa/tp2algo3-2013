package modelo.probabilidades;


public class ProbabilidadEquiprobable extends Probabilidad {
	
	public double calcular() {
		
		   double probabilidad =  (double) Math.random();
		   return probabilidad;
			
	}
}
