package fiuba.algo3.gpschallenge.modelo;

public class ProbabilidadEquiprobable extends Probabilidad {
	
	public ProbabilidadEquiprobable probabilidadEquiprobable(){
		
		 ProbabilidadEquiprobable probabilidadEquiprobable = new  ProbabilidadEquiprobable();
		 this.probabilidad = 0;
		
		return probabilidadEquiprobable;
	}
	
	public double calcular() {
		
		   double probabilidad =  (double) Math.random();
		   return probabilidad;
			
	}
}
