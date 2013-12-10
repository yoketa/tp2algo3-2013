package modelo.probabilidades;

import excepciones.ValorDeProbabilidadInvalidoException;


public class ProbabilidadEquiprobable extends Probabilidad {
	
	public double calcular() throws ValorDeProbabilidadInvalidoException{
		
		double probabilidad =  (double) Math.random();
		
		if ( probabilidad >= 0 && probabilidad <= 1){
			return probabilidad;
		 
		}else throw new ValorDeProbabilidadInvalidoException("Error en valor de probabilidad");
		
	}
}