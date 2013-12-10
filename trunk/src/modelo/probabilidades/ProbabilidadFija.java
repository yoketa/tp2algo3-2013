package modelo.probabilidades;

import excepciones.ValorDeProbabilidadInvalidoException;


public class ProbabilidadFija extends Probabilidad {
	
	public ProbabilidadFija(double valorFijo) throws ValorDeProbabilidadInvalidoException{
		
		if ( valorFijo >= 0 && valorFijo <= 1){
		 this.probabilidad = valorFijo;
		 
		}else throw new ValorDeProbabilidadInvalidoException("No es un valor de probabilidad");
			
	}
	public double calcular() {
		return this.probabilidad;	
	}
}
