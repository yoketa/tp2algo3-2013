package modelo.probabilidades;

import excepciones.ValorDeProbabilidadInvalidoException;

public abstract class Probabilidad {
	
	public double probabilidad;
	
	public Probabilidad () {
		this.probabilidad = 0;
	}
	
	public double calcular() throws ValorDeProbabilidadInvalidoException{
		return this.probabilidad;
	}
}